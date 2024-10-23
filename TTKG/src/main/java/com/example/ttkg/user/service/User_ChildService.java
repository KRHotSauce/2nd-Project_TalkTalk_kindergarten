package com.example.ttkg.user.service;

import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.user.DTO.ChildCreateRequest;
import com.example.ttkg.user.DTO.ChildDTO;
import com.example.ttkg.user.model.ChildEntity;
import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.model.User_ChildEntity;
import com.example.ttkg.user.model.User_Child_Idx;
import com.example.ttkg.user.repository.User_ChildRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class User_ChildService {
    private final User_ChildRepository user_childRepository;
    private final UserService userService;
    private final ChildService childService;

    public User_ChildService(User_ChildRepository user_childRepository, UserService userService,
                             ChildService childService) {
        this.user_childRepository = user_childRepository;
        this.userService = userService;
        this.childService = childService;
    }

    public boolean existsById(long userIdx,long childIdx){
        User_Child_Idx user_child_idx = new User_Child_Idx(userIdx, childIdx);
        return user_childRepository.existsById(user_child_idx);
    }

    public boolean existByUserIdx(long userIdx){
        UserEntity user=userService.getUserEntityByUserIdx(userIdx);
        return user_childRepository.existsByUsers(user);
    }

    public boolean existByKinderCode(String kinderCode){
        return user_childRepository.existsByKinderCode(kinderCode);
    }

    public List<User_ChildEntity> getUser_childListByUserIdx(Long user_idx) {
        UserEntity userEntity=userService.getUserEntityByUserIdx(user_idx);
        return user_childRepository.findByUsers(userEntity);
    }

    /**부모 아이디로만 user_child 존재하는지 조회*/
    public boolean ExistChildByUserId(Long user_idx) {
        UserEntity userEntity=userService.getUserEntityByUserIdx(user_idx);
        return existByUserIdx(user_idx);
    }

    public User_ChildEntity getUser_ChildEntityByChildIdx(Long child_idx){
       return user_childRepository.findByChild(childService.getChildRealEntity(child_idx));
    }

    /** User_child 엔티티로 차일드 조회해서 리스트로 가져오기*/
    public List<ChildDTO> findChildEntityListByUserIdx(Long userIdx){

//        List<ChildEntity> childEntityList=new ArrayList<ChildEntity>();
//        try {
//            for(User_childEntity user_childEntity:userChildEntityList){
//                ChildEntity childEntity=new ChildEntity();
//                childEntity=childRepository.findByChild_idx(user_childEntity.getChild().getChild_idx());
//                childEntityList.add(childEntity);
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return childEntityList;
        return getUser_childListByUserIdx(userIdx)
                .stream()
                .map(User_ChildEntity::getChild)
                .map(ChildDTO::of)
                .collect(Collectors.toList());
    }



    /** 아이 DB 저장 후 유저_자녀테이블까지 저장*/
    public void RegisterChild(ChildCreateRequest req, long userIdx) {
        ChildEntity childEntity = req.toEntity();
        ChildEntity saveChildEntity=childService.saveAndReturnChildEntity(childEntity); //생성된 child_id 받아오기 위해 넣어줌

        long childIdx=saveChildEntity.getChildIdx();
        User_Child_Idx userChildIdx=new User_Child_Idx(userIdx, childIdx); //임베디드 id 생성

        //유저_자녀테이블 조회 후 없을 시 저장
        if(!existsById(userIdx,childIdx)){
            User_ChildEntity user_childEntity=new User_ChildEntity();
            user_childEntity.setUser_child_idx(userChildIdx);
            user_childEntity.setUsers(userService.getUserEntityByUserIdx(userIdx));
            user_childEntity.setChild(saveChildEntity);
            user_childRepository.save(user_childEntity);
        }
    }

    public void applyKinder(long childIdx,String kinderCode) {
        User_ChildEntity user_childEntity=user_childRepository.findByChild(childService.getChildRealEntity(childIdx));
        user_childEntity.setKinderCode(kinderCode);
        user_childEntity.setAccessState(2);
        user_childRepository.save(user_childEntity);
    }

    /** 신청허가여부와 킨더코드로 유저차일드 가져오기*/
    public List<ChildEntity> getChildEntityByKinder(String KinderCode,int accessState){
        return user_childRepository.findByKinderCodeAndAccessState(KinderCode, accessState)
                .stream()
                .map(User_ChildEntity::getChild)
                .toList();

    }

    public void approveApply(long childIdx,String kinderCode){
        User_ChildEntity user_childEntity=user_childRepository.findByChild(childService.getChildRealEntity(childIdx));
        user_childEntity.setAccessState(1);
        user_childEntity.setKinderCode(kinderCode);
        user_childRepository.save(user_childEntity);

        ChildEntity childEntity=user_childEntity.getChild();
        childEntity.setKinderCode(kinderCode);
        childService.saveAndReturnChildEntity(childEntity);

        UserEntity userEntity=user_childEntity.getUsers();
        userEntity.setKinderCode(kinderCode);
        userService.saveUser(userEntity);

    }

    public void denyApply(long childIdx){
        User_ChildEntity user_childEntity=user_childRepository.findByChild(childService.getChildRealEntity(childIdx));
        user_childEntity.setAccessState(0);
        user_childEntity.setKinderCode(null);
        user_childRepository.save(user_childEntity);
    }


}

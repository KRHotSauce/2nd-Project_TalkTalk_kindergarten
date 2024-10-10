package com.example.ttkg.user.service;

import com.example.ttkg.user.DTO.ChildDTO;
import com.example.ttkg.user.model.ChildEntity;
import com.example.ttkg.user.model.User_Child_Idx;
import com.example.ttkg.user.model.User_childEntity;
import com.example.ttkg.user.repository.ChildRepository;
import com.example.ttkg.user.repository.UserRepository;
import com.example.ttkg.user.repository.User_ChildRepository;
import org.springframework.stereotype.Service;

@Service
public class ChildService {

    private final ChildRepository childRepository;
    private final User_ChildRepository user_childRepository;
    private final UserRepository userRepository;

    public ChildService(ChildRepository childRepository, User_ChildRepository user_childRepository, UserRepository userRepository) {
        this.childRepository = childRepository;
        this.user_childRepository = user_childRepository;
        this.userRepository = userRepository;
    }

    public boolean ExistUserChild(Long user_idx,Long child_idx) {
        User_Child_Idx user_child_idx = new User_Child_Idx(user_idx, child_idx);
        return user_childRepository.existsById(user_child_idx);
    }

    /** 아이 DB 저장 후 유저_자녀테이블까지 저장*/
    public void RegisterChild(ChildDTO childDTO,long user_idx) {
        ChildEntity childEntity = new ChildEntity();
        childEntity.setChild_name(childDTO.getChild_name());
        childEntity.setChild_birth(childDTO.getChild_birth());
        ChildEntity saveChildEntity=childRepository.save(childEntity); //생성된 child_id 받아오기 위해 넣어줌

        Long child_idx=saveChildEntity.getChild_idx();
        User_Child_Idx userChildIdx=new User_Child_Idx(user_idx, child_idx); //임베디드 id 생성

        //유저_자녀테이블 조회 후 없을 시 저장
        if(!user_childRepository.existsById(userChildIdx)){
            User_childEntity user_childEntity=new User_childEntity();
            user_childEntity.setUser_child_idx(userChildIdx);
            user_childEntity.setUser(userRepository.findByUserIdx(user_idx));
            user_childEntity.setChild(saveChildEntity);
            user_childRepository.save(user_childEntity);
        }


    }


}

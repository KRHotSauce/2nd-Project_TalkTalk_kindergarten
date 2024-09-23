package com.example.ttkg.user.service;

import com.example.ttkg.user.DTO.ParentsDTO;
import com.example.ttkg.user.DTO.ParentsLoginDTO;
import com.example.ttkg.user.model.ParentsEntity;
import com.example.ttkg.user.repository.ParentsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParentsService {


    private final ParentsRepository parentsRepository;

    @Autowired
    public ParentsService(ParentsRepository parentsRepository) {
        this.parentsRepository=parentsRepository;
    }

    public ParentsEntity registerNewParent(ParentsDTO parentsDTO) {
        if(parentsRepository.existsByLoginId(parentsDTO.getLoginId())) {
            throw new IllegalArgumentException("중복된 아이디입니다.");
        }
        if(parentsRepository.existsByEmail(parentsDTO.getEmail())) {
            throw new IllegalArgumentException("중복된 이메일입니다.");
        }
        if(parentsRepository.existsByNickname(parentsDTO.getNickname())) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }

        ParentsEntity parentsEntity = new ParentsEntity();
        parentsEntity.setLoginId(parentsDTO.getLoginId());
        parentsEntity.setNickname(parentsDTO.getNickname());
        parentsEntity.setEmail(parentsDTO.getEmail());
        parentsEntity.setPassword(parentsDTO.getPassword());
        parentsEntity.setName(parentsDTO.getName());

        // userId는 설정하지 않음
        parentsEntity = parentsRepository.save(parentsEntity);

        return parentsEntity;

    }
    /**로그인 할때 아이디,비밀번호 여부 일치한다면 true 아니면 false 반환*/
    public boolean checkLogin(ParentsLoginDTO parentsLoginDTO){
        Optional<ParentsEntity> parents=parentsRepository.findByLoginId(parentsLoginDTO.getLoginId());
        if(parents.isPresent()) {
        ParentsEntity parentsEntity=parents.get();
        return parentsEntity.getPassword().equals(parentsLoginDTO.getPassword());
        }
        return false;
    }

    public boolean chekcPassword(ParentsLoginDTO parentsLoginDTO,String password){
        if(parentsLoginDTO.getPassword().equals(password))
            return true;
        else{
            return false;
        }
    }

    public ParentsDTO getParentsEntitybyLoginID(String loginId){
        Optional<ParentsEntity> parents=parentsRepository.findByLoginId(loginId);
        ParentsDTO parentsDTO=new ParentsDTO();
        if(parents.isPresent()) {
            parentsDTO.setLoginId(parents.get().getLoginId());
            parentsDTO.setNickname(parents.get().getNickname());
            parentsDTO.setEmail(parents.get().getEmail());
            parentsDTO.setPassword(parents.get().getPassword());
            parentsDTO.setName(parents.get().getName());
        }
        return parentsDTO;

    }

    public void UpdateParentsProfile(ParentsDTO updatedParentsDTO, String loginId) {
        parentsRepository.findByLoginId(loginId)
                .ifPresent(parentsEntity -> {
                    parentsEntity.setNickname(updatedParentsDTO.getNickname());
                    parentsEntity.setEmail(updatedParentsDTO.getEmail());
                    parentsEntity.setPassword(updatedParentsDTO.getPassword());
                    parentsEntity.setName(updatedParentsDTO.getName());
                    parentsRepository.save(parentsEntity);

                });
    }

    @Transactional
    public void DeleteAccountMethod(String loginId) {
        parentsRepository.deleteByloginId(loginId);
    }

}

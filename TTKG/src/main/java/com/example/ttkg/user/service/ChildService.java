package com.example.ttkg.user.service;

import com.example.ttkg.user.DTO.ChildDTO;
import com.example.ttkg.user.model.ChildEntity;
import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.model.User_Child_Idx;
import com.example.ttkg.user.model.User_ChildEntity;
import com.example.ttkg.user.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildRepository childRepository;

    public ChildEntity saveAndReturnChildEntity(ChildEntity childEntity) {
        return childRepository.save(childEntity);
    }

    public ChildDTO getChildEntity(Long childIdx){
        ChildEntity childEntity = childRepository.findByChildIdx(childIdx);
        return ChildDTO.of(childEntity);
    }
    public ChildEntity getChildRealEntity(Long childIdx){
        return childRepository.findByChildIdx(childIdx);
    }








}

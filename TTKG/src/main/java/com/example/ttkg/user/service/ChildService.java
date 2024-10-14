package com.example.ttkg.user.service;

import com.example.ttkg.user.DTO.ChildDTO;
import com.example.ttkg.user.model.ChildEntity;
import com.example.ttkg.user.model.UserEntity;
import com.example.ttkg.user.model.User_Child_Idx;
import com.example.ttkg.user.model.User_ChildEntity;
import com.example.ttkg.user.repository.ChildRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildService {

    private final ChildRepository childRepository;

    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    public ChildEntity saveAndReturnChildEntity(ChildEntity childEntity) {
        return childRepository.save(childEntity);
    }









}

package com.example.ttkg.kinder.service;

import com.example.ttkg.kinder.DTO.KinderDTO;
import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.kinder.repository.KinderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KinderService {

    KinderRepository kinderRepository;
    public KinderService(KinderRepository kinderRepository) {
        this.kinderRepository = kinderRepository;
    }


    public KinderEntity findByKinderCode(String kinderCode) {
        Optional<KinderEntity> kinderEntity = kinderRepository.findByKinderCode(kinderCode);
        if(kinderEntity.isPresent()) {
            return kinderEntity.get();
        }
        else {
            System.out.println("Kinder not found");
            return null;
        }
    }



    public KinderDTO ConvertToDTO(KinderEntity kinderEntity) {
        KinderDTO kinderDTO = new KinderDTO();
        kinderDTO.setKinderCode(kinderEntity.getKinderCode());
        kinderDTO.setKinderName(kinderEntity.getKinderName());
        kinderDTO.setAddr(kinderEntity.getAddr());
        kinderDTO.setEstablish(kinderEntity.getEstablish());
        return kinderDTO;
    }

}

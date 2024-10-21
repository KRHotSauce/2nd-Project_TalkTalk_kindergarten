package com.example.ttkg.kinder.service;

import com.example.ttkg.kinder.DTO.KinderDTO;
import com.example.ttkg.kinder.model.KinderEntity;
import com.example.ttkg.kinder.model.NoticeLetterEntity;
import com.example.ttkg.kinder.repository.KinderRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KinderService {

    KinderRepository kinderRepository;

    public KinderService(KinderRepository kinderRepository) {
        this.kinderRepository = kinderRepository;
    }


    public KinderEntity findByKinderCode(String kinderCode) {
        Optional<KinderEntity> kinderEntity = kinderRepository.findByKinderCode(kinderCode);
        if (kinderEntity.isPresent()) {
            return kinderEntity.get();
        } else {
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


    // 유치원 이름으로 검색하는 메서드
    public List<KinderEntity> searchKinderByName(String query) {
        // 이름에 검색어가 포함된 유치원을 DB에서 검색
        return kinderRepository.findByKinderNameContaining(query);
    }


    public Page<KinderEntity> getKinderList(int currentPage) {
        Pageable pageable = PageRequest.of(currentPage - 1, 10, Sort.by(Sort.Direction.ASC, "kinderName"));
        //페이지 0부터 시작하므로 -1, 페이지 사이즈, 내림차순으로 정렬
        return kinderRepository.findAll(pageable);
    }

//    public Page<KinderEntity> getKinderByPage(int page,int size) {
//        Pageable pageable= PageRequest.of(page-1, size, Sort.by(Sort.Direction.ASC, "kinderName"));
//        //페이지 0부터 시작하므로 -1, 페이지 사이즈, 내림차순으로 정렬
//        return kinderRepository.findAll(pageable);
//    }
//
//    public Page<KinderEntity> getKinderAllForPage(){
//        return getKinderByPage(0,10);
//    }

}

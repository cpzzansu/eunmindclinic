package org.teamhub.groupware.user.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.user.entity.Medical;
import org.teamhub.groupware.user.mapper.MedicalMapper;
import org.teamhub.groupware.user.payload.MedicalDto;
import org.teamhub.groupware.user.repository.MedicalRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class MedicalService {

    private final MedicalRepository medicalRepository;

    public List<MedicalDto> getMedical(){

        List<Medical> medicalList = medicalRepository.findAll();

        List<MedicalDto> medicalDtoList = new ArrayList<>();

        for(Medical medical : medicalList){

            MedicalDto medicalDto = MedicalMapper.toDto(medical);

            medicalDtoList.add(medicalDto);
        }

        return medicalDtoList;
    }
}

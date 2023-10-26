package org.teamhub.groupware.user.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.user.entity.AcademicActivities;
import org.teamhub.groupware.user.mapper.AcademicActivitiesMapper;
import org.teamhub.groupware.user.payload.AcademicActivitiesDto;
import org.teamhub.groupware.user.repository.AcademicActivitiesRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class AcademicActivitiesService {

    private final AcademicActivitiesRepository academicActivitiesRepository;

    public List<AcademicActivitiesDto> getAcademicActivities(){

        List<AcademicActivities> activitiesList = academicActivitiesRepository.findAll();

        List<AcademicActivitiesDto> academicActivitiesDtoList = new ArrayList<>();

        for(AcademicActivities academicActivities : activitiesList){
            AcademicActivitiesDto academicActivitiesDto = AcademicActivitiesMapper.toDto(academicActivities);
            academicActivitiesDtoList.add(academicActivitiesDto);
        }

        return academicActivitiesDtoList;
    }
}

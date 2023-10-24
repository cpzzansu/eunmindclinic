package org.teamhub.groupware.user.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamhub.groupware.user.payload.AcademicActivitiesDto;
import org.teamhub.groupware.user.payload.MbaDto;
import org.teamhub.groupware.user.payload.MedicalDto;
import org.teamhub.groupware.user.payload.OverseasPresentationDto;
import org.teamhub.groupware.user.service.AcademicActivitiesService;
import org.teamhub.groupware.user.service.MbaService;
import org.teamhub.groupware.user.service.MedicalService;
import org.teamhub.groupware.user.service.OverseasPresentationService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class userController {

    private final AcademicActivitiesService academicActivitiesService;
    private final MedicalService medicalService;
    private final OverseasPresentationService overseasPresentationService;
    private final MbaService mbaService;

    @GetMapping("/academicActivities")
    public List<AcademicActivitiesDto> getAcademicActivities(){
        return academicActivitiesService.getAcademicActivities();
    }

    @GetMapping("/medical")
    public List<MedicalDto> getMedical(){
        return medicalService.getMedical();
    }

    @GetMapping("/overseasPresent")
    public List<OverseasPresentationDto> getOverseasPresentation(){
        return overseasPresentationService.getOverseasPresentation();
    }

    @GetMapping("/mba")
    public List<MbaDto> getMba(){
        return mbaService.getMba();
    }

}

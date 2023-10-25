package org.teamhub.groupware.user.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teamhub.groupware.user.payload.*;
import org.teamhub.groupware.user.service.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class userController {

    private final AcademicActivitiesService academicActivitiesService;
    private final MedicalService medicalService;
    private final OverseasPresentationService overseasPresentationService;
    private final MbaService mbaService;
    private final PublishedWorksService publishedWorksService;

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

    @GetMapping("/pubs")
    public List<PublishedWorksDto> getPubs(){
        return publishedWorksService.getPubs();
    }

}

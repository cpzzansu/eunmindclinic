package org.teamhub.groupware.user.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.user.entity.OverseasPresentation;
import org.teamhub.groupware.user.mapper.OverseasPresentationMapper;
import org.teamhub.groupware.user.payload.OverseasPresentationDto;
import org.teamhub.groupware.user.repository.OverseasPresentationRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class OverseasPresentationService {

    private final OverseasPresentationRepository overseasPresentationRepository;

    public List<OverseasPresentationDto> getOverseasPresentation(){

        List<OverseasPresentation> overseasPresentationList = overseasPresentationRepository.findAll();

        List<OverseasPresentationDto> overseasPresentationDtoList = new ArrayList<>();

        for(OverseasPresentation overseasPresentation : overseasPresentationList){

            OverseasPresentationDto overseasPresentationDto = OverseasPresentationMapper.toDto(overseasPresentation);

            overseasPresentationDtoList.add(overseasPresentationDto);
        }

        return overseasPresentationDtoList;
    }

}

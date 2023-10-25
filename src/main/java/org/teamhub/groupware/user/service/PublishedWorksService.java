package org.teamhub.groupware.user.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.user.entity.PublishedWorks;
import org.teamhub.groupware.user.mapper.PublishedWorksMapper;
import org.teamhub.groupware.user.payload.PublishedWorksDto;
import org.teamhub.groupware.user.repository.PublishedWorksRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class PublishedWorksService {

    private final PublishedWorksRepository publishedWorksRepository;

    public List<PublishedWorksDto> getPubs(){

        List<PublishedWorks> publishedWorksList = publishedWorksRepository.findAll();

        List<PublishedWorksDto> publishedWorksDtoList = new ArrayList<>();

        for(PublishedWorks publishedWorks : publishedWorksList){

            PublishedWorksDto publishedWorksDto = PublishedWorksMapper.toDto(publishedWorks);

            publishedWorksDtoList.add(publishedWorksDto);
        }

        return publishedWorksDtoList;
    }
}

package org.teamhub.groupware.user.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.teamhub.groupware.user.entity.Mba;
import org.teamhub.groupware.user.mapper.MbaMapper;
import org.teamhub.groupware.user.payload.MbaDto;
import org.teamhub.groupware.user.repository.MbaRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class MbaService {
    private final MbaRepository mbaRepository;

    public List<MbaDto> getMba(){

        List<Mba> mbaList = mbaRepository.findAll();

        List<MbaDto> mbaDtoList = new ArrayList<>();

        for(Mba mba : mbaList){

            MbaDto mbaDto = MbaMapper.toDto(mba);

            mbaDtoList.add(mbaDto);
        }

        return mbaDtoList;
    }
}

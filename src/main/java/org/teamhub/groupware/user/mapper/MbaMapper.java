package org.teamhub.groupware.user.mapper;

import org.teamhub.groupware.user.entity.Mba;
import org.teamhub.groupware.user.payload.MbaDto;


public class MbaMapper {
    public static MbaDto toDto(Mba mba){
        MbaDto.MbaDtoBuilder builder = MbaDto.builder()
                .id(mba.getId())
                .mbaContent(mba.getMbaContent())
                .writerId(mba.getWriterId())
                .registDate(mba.getRegistDate())
                .updaterId(mba.getUpdaterId())
                .updateDate(mba.getUpdateDate());

        return builder.build();
    }

    public static Mba toEntity(MbaDto mbaDto){
        Mba.MbaBuilder builder = Mba.builder()
                .id(mbaDto.getId())
                .mbaContent(mbaDto.getMbaContent())
                .writerId(mbaDto.getWriterId())
                .registDate(mbaDto.getRegistDate())
                .updaterId(mbaDto.getUpdaterId())
                .updateDate(mbaDto.getUpdateDate());

        return builder.build();
    }
}

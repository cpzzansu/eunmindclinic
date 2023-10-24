package org.teamhub.groupware.user.mapper;

import org.teamhub.groupware.user.entity.OverseasPresentation;
import org.teamhub.groupware.user.payload.OverseasPresentationDto;

public class OverseasPresentationMapper {
    public static OverseasPresentationDto toDto(OverseasPresentation overseasPresentation){
        OverseasPresentationDto.OverseasPresentationDtoBuilder builder = OverseasPresentationDto.builder()
                .id(overseasPresentation.getId())
                .overseasPresentation(overseasPresentation.getOverseasPresentation())
                .writerId(overseasPresentation.getWriterId())
                .registDate(overseasPresentation.getRegistDate())
                .updaterId(overseasPresentation.getUpdaterId())
                .updateDate(overseasPresentation.getUpdateDate());

        return builder.build();
    }

    public static OverseasPresentation toEntity(OverseasPresentationDto overseasPresentationDto){
        OverseasPresentation.OverseasPresentationBuilder builder = OverseasPresentation.builder()
                .id(overseasPresentationDto.getId())
                .overseasPresentation(overseasPresentationDto.getOverseasPresentation())
                .writerId(overseasPresentationDto.getWriterId())
                .registDate(overseasPresentationDto.getRegistDate())
                .updaterId(overseasPresentationDto.getUpdaterId())
                .updateDate(overseasPresentationDto.getUpdateDate());

        return builder.build();
    }
}

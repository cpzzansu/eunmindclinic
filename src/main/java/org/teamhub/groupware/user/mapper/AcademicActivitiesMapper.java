package org.teamhub.groupware.user.mapper;

import org.teamhub.groupware.user.entity.AcademicActivities;
import org.teamhub.groupware.user.payload.AcademicActivitiesDto;

public class AcademicActivitiesMapper {

    public static AcademicActivitiesDto toDto(AcademicActivities academicActivities){
        AcademicActivitiesDto.AcademicActivitiesDtoBuilder builder = AcademicActivitiesDto.builder()
                .id(academicActivities.getId())
                .academicDate(academicActivities.getAcademicDate())
                .description(academicActivities.getDescription())
                .writerId(academicActivities.getWriterId())
                .registDate(academicActivities.getRegistDate())
                .updaterId(academicActivities.getUpdaterId())
                .updateDate(academicActivities.getUpdateDate());

        return builder.build();
    }

    public static AcademicActivities toEntity(AcademicActivitiesDto academicActivitiesDto){
        AcademicActivities.AcademicActivitiesBuilder builder = AcademicActivities.builder()
                .id(academicActivitiesDto.getId())
                .academicDate(academicActivitiesDto.getAcademicDate())
                .description(academicActivitiesDto.getDescription())
                .writerId(academicActivitiesDto.getWriterId())
                .registDate(academicActivitiesDto.getRegistDate())
                .updaterId(academicActivitiesDto.getUpdaterId())
                .updateDate(academicActivitiesDto.getUpdateDate());

        return builder.build();
    }
}

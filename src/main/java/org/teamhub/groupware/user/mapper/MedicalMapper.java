package org.teamhub.groupware.user.mapper;

import org.teamhub.groupware.user.entity.Medical;
import org.teamhub.groupware.user.payload.MedicalDto;

public class MedicalMapper {

    public static MedicalDto toDto(Medical medical){
        MedicalDto.MedicalDtoBuilder builder = MedicalDto.builder()
                .id(medical.getId())
                .medicalPublication(medical.getMedicalPublication())
                .writerId(medical.getWriterId())
                .registDate(medical.getRegistDate())
                .updaterId(medical.getUpdaterId())
                .updateDate(medical.getUpdateDate());

        return builder.build();
    }

    public static Medical toEntity(MedicalDto medicalDto){
        Medical.MedicalBuilder builder = Medical.builder()
                .id(medicalDto.getId())
                .medicalPublication(medicalDto.getMedicalPublication())
                .writerId(medicalDto.getWriterId())
                .registDate(medicalDto.getRegistDate())
                .updaterId(medicalDto.getUpdaterId())
                .updateDate(medicalDto.getUpdateDate());

        return builder.build();
    }
}

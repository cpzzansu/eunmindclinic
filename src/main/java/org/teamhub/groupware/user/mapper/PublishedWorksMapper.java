package org.teamhub.groupware.user.mapper;

import org.teamhub.groupware.user.entity.Mba;
import org.teamhub.groupware.user.entity.PublishedWorks;
import org.teamhub.groupware.user.payload.MbaDto;
import org.teamhub.groupware.user.payload.PublishedWorksDto;

public class PublishedWorksMapper {
    public static PublishedWorksDto toDto(PublishedWorks publishedWorks){
        PublishedWorksDto.PublishedWorksDtoBuilder builder = PublishedWorksDto.builder()
                .id(publishedWorks.getId())
                .publishedWorks(publishedWorks.getPublishedWorks())
                .writerId(publishedWorks.getWriterId())
                .registDate(publishedWorks.getRegistDate())
                .updaterId(publishedWorks.getUpdaterId())
                .updateDate(publishedWorks.getUpdateDate());

        return builder.build();
    }

    public static PublishedWorks toEntity(PublishedWorksDto publishedWorksDto){
        PublishedWorks.PublishedWorksBuilder builder = PublishedWorks.builder()
                .id(publishedWorksDto.getId())
                .publishedWorks(publishedWorksDto.getPublishedWorks())
                .writerId(publishedWorksDto.getWriterId())
                .registDate(publishedWorksDto.getRegistDate())
                .updaterId(publishedWorksDto.getUpdaterId())
                .updateDate(publishedWorksDto.getUpdateDate());

        return builder.build();
    }
}

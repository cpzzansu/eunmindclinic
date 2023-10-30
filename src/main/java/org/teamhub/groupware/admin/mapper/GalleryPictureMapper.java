package org.teamhub.groupware.admin.mapper;

import org.teamhub.groupware.admin.entity.GalleryPicture;
import org.teamhub.groupware.admin.payload.GalleryPictureDto;


public class GalleryPictureMapper {
    public static GalleryPictureDto toDto(GalleryPicture galleryPicture){
        GalleryPictureDto.GalleryPictureDtoBuilder builder = GalleryPictureDto.builder()
                .id(galleryPicture.getId())
                .originalFileName(galleryPicture.getOriginalFileName())
                .storedFilePath(galleryPicture.getStoredFilePath())
                .imageSourcePath(galleryPicture.getImageSourcePath())
                .fileSize(galleryPicture.getFileSize())
                .writerId(galleryPicture.getWriterId())
                .registDate(galleryPicture.getRegistDate())
                .updaterId(galleryPicture.getUpdaterId())
                .updateDate(galleryPicture.getUpdateDate());

        return builder.build();
    }

    public static GalleryPicture toEntity(GalleryPictureDto galleryPictureDto){
        GalleryPicture.GalleryPictureBuilder builder = GalleryPicture.builder()
                .id(galleryPictureDto.getId())
                .originalFileName(galleryPictureDto.getOriginalFileName())
                .storedFilePath(galleryPictureDto.getStoredFilePath())
                .imageSourcePath(galleryPictureDto.getImageSourcePath())
                .fileSize(galleryPictureDto.getFileSize())
                .writerId(galleryPictureDto.getWriterId())
                .registDate(galleryPictureDto.getRegistDate())
                .updaterId(galleryPictureDto.getUpdaterId())
                .updateDate(galleryPictureDto.getUpdateDate());

        return builder.build();
    }
}

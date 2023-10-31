package org.teamhub.groupware.admin.entity;

import jakarta.persistence.*;
import lombok.*;
import org.teamhub.groupware.admin.payload.GalleryPictureDto;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "gallery_picture")
public class GalleryPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_file_name", nullable = false, length = 255)
    private String originalFileName;

    @Column(name = "stored_file_path", nullable = false, length = 500)
    private String storedFilePath;

    @Column(name = "image_source_path", nullable = false, length = 500)
    private String imageSourcePath;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "writer_id", nullable = false, length = 100)
    private String writerId;

    @Column(name = "regist_date")
    private LocalDateTime registDate;

    @Column(name = "updater_id")
    private String updaterId;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    public void modifyGallery(GalleryPictureDto galleryPictureDto){
        this.originalFileName = galleryPictureDto.getOriginalFileName();
        this.storedFilePath = galleryPictureDto.getStoredFilePath();
        this.imageSourcePath = galleryPictureDto.getImageSourcePath();
        this.fileSize = galleryPictureDto.getFileSize();
        this.updaterId = galleryPictureDto.getUpdaterId();
        this.updateDate = galleryPictureDto.getUpdateDate();
    }
}

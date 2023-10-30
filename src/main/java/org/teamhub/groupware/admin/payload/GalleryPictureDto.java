package org.teamhub.groupware.admin.payload;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GalleryPictureDto {

    private Long id;
    private String originalFileName;
    private String storedFilePath;
    private String imageSourcePath;
    private Long fileSize;
    private String writerId;
    private LocalDateTime registDate;
    private String updaterId;
    private LocalDateTime updateDate;

    @QueryProjection
    public GalleryPictureDto(Long id, String originalFileName, String storedFilePath, String imageSourcePath, Long fileSize, String writerId, LocalDateTime registDate, String updaterId, LocalDateTime updateDate){
        this.id = id;
        this.originalFileName = originalFileName;
        this.storedFilePath = storedFilePath;
        this.imageSourcePath = imageSourcePath;
        this.fileSize = fileSize;
        this.writerId = writerId;
        this.registDate = registDate;
        this.updaterId = updaterId;
        this.updateDate = updateDate;
    }
}

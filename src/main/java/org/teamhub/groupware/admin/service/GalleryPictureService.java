package org.teamhub.groupware.admin.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.teamhub.groupware.admin.entity.GalleryPicture;
import org.teamhub.groupware.admin.mapper.GalleryPictureMapper;
import org.teamhub.groupware.admin.payload.GalleryPictureDto;
import org.teamhub.groupware.admin.repository.GalleryPictureRepository;
import org.teamhub.groupware.common.payload.FileDto;
import org.teamhub.groupware.common.utils.FileUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class GalleryPictureService {

    private final GalleryPictureRepository galleryPictureRepository;
    private final FileUtils fileUtils;

    public void galleryAdd(MultipartFile file) throws Exception {
        List<MultipartFile> files = new ArrayList<>();
        files.add(file);
        List<FileDto> fileDtos = fileUtils.parseFileInfo(files);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for(FileDto fileDto : fileDtos){
            GalleryPictureDto galleryPictureDto = GalleryPictureDto.builder()
                    .originalFileName(fileDto.getOriginalFileName())
                    .storedFilePath(fileDto.getStoredFilePath())
                    .imageSourcePath(fileDto.getImageSourcePath())
                    .fileSize(fileDto.getFileSize())
                    .writerId(authentication.getName())
                    .registDate(LocalDateTime.now())
                    .build();

            GalleryPicture galleryPicture = GalleryPictureMapper.toEntity(galleryPictureDto);
            galleryPictureRepository.save(galleryPicture);
        }
    }

    public List<GalleryPictureDto> getGallery(){
        List<GalleryPicture> galleryPictures = galleryPictureRepository.findAll();
        List<GalleryPictureDto> galleryPictureDtos = new ArrayList<>();

        for(GalleryPicture galleryPicture : galleryPictures){
            GalleryPictureDto galleryPictureDto = GalleryPictureMapper.toDto(galleryPicture);
            galleryPictureDtos.add(galleryPictureDto);
        }

        return galleryPictureDtos;
    }

    public void deleteGallery(String id){
        if(deleteGalleryFile(id)){
            galleryPictureRepository.deleteById(Long.parseLong(id));
        }
    }

    public void modifyGallery(MultipartFile file, String id) throws Exception {
        deleteGalleryFile(id);
        Long galleryId = Long.parseLong(id);
        List<MultipartFile> files = new ArrayList<>();
        files.add(file);
        List<FileDto> fileDtos = fileUtils.parseFileInfo(files);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for(FileDto fileDto : fileDtos){
            GalleryPictureDto galleryPictureDto = GalleryPictureDto.builder()
                    .originalFileName(fileDto.getOriginalFileName())
                    .storedFilePath(fileDto.getStoredFilePath())
                    .imageSourcePath(fileDto.getImageSourcePath())
                    .fileSize(fileDto.getFileSize())
                    .updaterId(authentication.getName())
                    .updateDate(LocalDateTime.now())
                    .build();
            Optional<GalleryPicture> galleryPicture = galleryPictureRepository.findById(galleryId);
            log.info(galleryPictureDto.toString());
            if(galleryPicture.isPresent()){
                galleryPicture.get().modifyGallery(galleryPictureDto);
            }

        }
    }

    public Boolean deleteGalleryFile(String id){
        Boolean result = false;
        Long galleryId = Long.parseLong(id);

        Optional<GalleryPicture> galleryPicture = galleryPictureRepository.findById(galleryId);
        if(galleryPicture.isPresent()){
            String storedFilePath = galleryPicture.get().getStoredFilePath();

            log.info(storedFilePath);
            File file = new File(storedFilePath);
            result = file.delete();

        }
        return result;
    }
}

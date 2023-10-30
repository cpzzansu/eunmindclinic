package org.teamhub.groupware.common.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.teamhub.groupware.common.payload.FileDto;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtils {
    public List<FileDto> parseFileInfo(List<MultipartFile> files) throws Exception{
        if(files == null || files.isEmpty()){
            return null;
        }
        List<FileDto> fileDtos = new ArrayList<>();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();

        // 사용자 홈 디렉토리를 기반으로 저장 경로 설정

        String userHome = System.getProperty("user.home");
        String path = userHome + "/localImages/" + current.format(format);
        String imageSourcePath = "/localImages/" + current.format(format);

        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }

        String newFileName, originalFileExtension, contentType;

        for(MultipartFile multipartFile : files){
            contentType = multipartFile.getContentType();
            if(ObjectUtils.isEmpty(contentType)){
                break;
            }
            else{
                if(contentType.contains("image/jpeg")){
                    originalFileExtension = ".jpg";
                } else if(contentType.contains("image/png")){
                    originalFileExtension = ".png";
                } else if(contentType.contains("image/gif")){
                    originalFileExtension = ".gif";
                } else{
                    break;
                }
            }
            newFileName = System.nanoTime() + originalFileExtension;
            FileDto fileDto = new FileDto();
            fileDto.setOriginalFileName(multipartFile.getOriginalFilename());
            fileDto.setStoredFilePath(path + "/" + newFileName);
            fileDto.setFileSize(multipartFile.getSize());
            fileDto.setImageSourcePath(imageSourcePath + "/" + newFileName);
            fileDtos.add(fileDto);

            file = new File(path + "/" + newFileName);
            multipartFile.transferTo(file);
        }
        return fileDtos;
    }
}

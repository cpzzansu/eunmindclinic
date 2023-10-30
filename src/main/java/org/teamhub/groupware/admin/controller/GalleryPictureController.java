package org.teamhub.groupware.admin.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.teamhub.groupware.admin.payload.GalleryPictureDto;
import org.teamhub.groupware.admin.service.GalleryPictureService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class GalleryPictureController {

    private final GalleryPictureService galleryPictureService;

    @PostMapping("/galleryAdd")
    public void galleryAdd(@RequestParam("file") MultipartFile file) throws Exception {
        galleryPictureService.galleryAdd(file);
    }

    @GetMapping("/getGallery")
    public List<GalleryPictureDto> getGallery(){
        return galleryPictureService.getGallery();
    }

    @DeleteMapping("/deleteGallery")
    public void deleteGallery(@RequestParam("id") String id){
        galleryPictureService.deleteGallery(id);
    }
}

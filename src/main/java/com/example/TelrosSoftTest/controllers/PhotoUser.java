package com.example.TelrosSoftTest.controllers;

import com.example.TelrosSoftTest.compressUtil.ImageUtils;
import com.example.TelrosSoftTest.model.ContactInformationModel;
import com.example.TelrosSoftTest.model.DetailedContactInformationModel;
import com.example.TelrosSoftTest.model.PhotoUserModel;
//import com.example.TelrosSoftTest.service.PhotoUserService;
import com.example.TelrosSoftTest.service.ContactInformationService;
import com.example.TelrosSoftTest.service.PhotoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class PhotoUser {

    private final PhotoUserService photoUserService;
    private final ContactInformationService contactInformationService;

    @Autowired
    private PhotoUser (PhotoUserService photoUserService,
                       ContactInformationService contactInformationService) {
        this.photoUserService = photoUserService;
        this.contactInformationService = contactInformationService;
    }

    @PostMapping(value = "/users/{id}/photo")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file,
                                         @PathVariable(name = "id") Long id) throws IOException {
        PhotoUserModel photoUserModel = new PhotoUserModel();

        photoUserModel.setImageData(ImageUtils.compressImage(file.getBytes()));

        if (contactInformationService.read(id) != null) {
            final ContactInformationModel user = contactInformationService.read(id);
            photoUserModel.setContactInformationModel(user);

            if (photoUserService.create(photoUserModel, id)) {
                return  new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }


        } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/users/{id}/photo", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource>  getImageByName(@PathVariable(name = "id") Long id){

        if (photoUserService.read(id) != null) {
            byte[] image = ImageUtils.decompressImage(photoUserService.read(id).getImageData());

            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf("image/png"))
                    .body(new ByteArrayResource(image));

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/users/{id}/photo")
    public ResponseEntity<?> update(@RequestParam("image") MultipartFile file,
                                    @PathVariable(name = "id") Long id) throws IOException {

        final boolean updated = photoUserService.update(ImageUtils.compressImage(file.getBytes()), id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/users/{id}/photo")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = photoUserService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

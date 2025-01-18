package com.imageuploader.controller;

import com.imageuploader.services.ImageUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadImageController {

    @Autowired
    private ImageUploader imageUploader;




 @PostMapping
 public ResponseEntity<?> uploadImage(@RequestParam  MultipartFile file)
 {

     return ResponseEntity.ok(imageUploader.uploadImage(file));


 }

 @GetMapping
 public List<String> getAllFiles()
 {
     return imageUploader.allFiles();
 }


 @GetMapping("/{fileName}")
 public String getImageNyFileName(@PathVariable("fileName") String fileName)
 {

     return this.imageUploader.getImageUrlNyName(fileName);
 }



}

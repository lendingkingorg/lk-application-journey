package com.lendinking.application.controller;

import com.lendinking.application.entity.DocumentUploadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.*;
import java.nio.file.Path;
import java.util.UUID;
@RestController
public class FileController {

    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(
            @RequestPart(value = "file") MultipartFile file,
            @org.springframework.web.bind.annotation.RequestBody DocumentUploadRequest documentUploadRequest) {
        try {
            String key = generateKey(file.getOriginalFilename());
            File modifiedFile = new File(file.getOriginalFilename());
            FileOutputStream os = new FileOutputStream(modifiedFile);
            os.write(file.getBytes());
            String fileUrl = "https://" + bucketName + ".s3.amazonaws.com/" + key;

            s3Client.putObject(PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build(), RequestBody.fromFile(modifiedFile));


            modifiedFile.delete();


            return ResponseEntity.status(HttpStatus.OK).body(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }

    private String generateKey(String originalFilename) {
        return UUID.randomUUID().toString() + "_" + originalFilename;
    }
}

package com.lendinking.application.controller;

import com.lendinking.application.entity.DocumentUploadRequest;
import com.lendinking.application.model.DocumentUploadDetails;
import com.lendinking.application.repository.DocumentRepository;
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
import java.time.LocalDateTime;
import java.util.UUID;
@RestController
public class FileController {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @PostMapping(value = "/upload/{mobNo}", consumes = {"multipart/form-data", "application/json"})
    public ResponseEntity<String> handleFileUpload(
            @RequestPart(value = "file") MultipartFile file,
            @PathVariable long mobNo,
            @org.springframework.web.bind.annotation.RequestBody DocumentUploadRequest documentUploadRequest) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();

            String key = generateKey(file.getOriginalFilename());
            File modifiedFile = new File(file.getOriginalFilename());
            FileOutputStream os = new FileOutputStream(modifiedFile);
            os.write(file.getBytes());
            String fileUrl = "https://" + bucketName + ".s3.amazonaws.com/" + key + '/' + localDateTime.toString();

            s3Client.putObject(PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .build(), RequestBody.fromFile(modifiedFile));

            String bankInfo = documentUploadRequest.getDocumentInfo();
            if(!documentRepository.existsById(mobNo)){
                DocumentUploadDetails documentUploadDetails = new DocumentUploadDetails();
                documentUploadDetails.setMobileNo(mobNo);
                documentRepository.save(documentUploadDetails);
            }

            if(documentUploadRequest.getDocumentType()=="Bank Statement"){
                documentRepository.findByMobileNo(mobNo).getDocumentURL().add(fileUrl);
                documentRepository.findByMobileNo(mobNo).getDocumentBankName().add(bankInfo);
            }else{
                documentRepository.findByMobileNo(mobNo).setPanCardUrl(fileUrl);
            }





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

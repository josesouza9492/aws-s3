package com.dchristofolli.projects.awss3.controller;

import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.dchristofolli.projects.awss3.service.AdminService;
import com.dchristofolli.projects.awss3.service.DownloadService;
import com.dchristofolli.projects.awss3.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/files")
public class Controller {
    private final UploadService uploadService;
    private final DownloadService downloadService;
    private final AdminService adminService;

    @PostMapping(path = "/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadFile(MultipartFile multipartFile) {
        uploadService.uploadFile(multipartFile);
    }

    @PostMapping(path = "/multi-upload")
    public void multiFileUpload( List<File> fileList) {
        uploadService.multipleFileUpload(fileList);
    }

    @GetMapping("/list")
    public List<String> findAll() {
        return downloadService.listAll();
    }

    @GetMapping("/download/{objectKey}")
    public void downloadFile(@PathVariable String objectKey) {
        downloadService.getObject(objectKey);
    }

    @DeleteMapping("delete/{fileName}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFile(@PathVariable String fileName) {
        adminService.deleteFile(fileName);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(){
        adminService.deleteAllFiles();
    }
}

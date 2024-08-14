package com.junhan.big_event.controller;

import com.junhan.big_event.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return Result.error("File is missing or empty");
        }

        String fileName = file.getOriginalFilename();
        try {
            //保證文件名稱唯一防止覆蓋
            String uuidfileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
            File destinationFile = new File("/Users/junhan/Desktop/files/" + uuidfileName);
            file.transferTo(destinationFile);
            return Result.success(fileName);
        } catch (IOException e) {
            return Result.error("Failed to upload file: " + e.getMessage());
        }
    }
}

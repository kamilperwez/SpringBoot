package com.kamil.todo_manager.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("/file")
public class FileController {
    Logger logger= LoggerFactory.getLogger(FileController.class);
    @PostMapping(path = "/upload")
    public String uploadFile(@RequestParam("image")MultipartFile file){
        logger.info("File Name {}", file.getName());
        logger.info("File Original Name {}", file.getOriginalFilename());
        logger.info("File Size {}", file.getSize());
        logger.info("File Content {}", file.getContentType());
        return "File Test";
    }
    @GetMapping("/image")
    public void serveImageHandler(HttpServletResponse response){
        try{
            InputStream fileInputStream=new FileInputStream("D:/GitRepo/SpringBoot/todo-manager/images/wall.jpg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream,response.getOutputStream());

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException ex){
        System.out.println(ex.getMessage());
        System.out.println("Null Pointer Exception");
        return new ResponseEntity<>("Null Pointer exception generated " +ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

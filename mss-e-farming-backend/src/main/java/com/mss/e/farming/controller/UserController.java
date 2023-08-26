package com.mss.e.farming.controller;

import com.mss.e.farming.dto.UserDTO;
import com.mss.e.farming.service.impl.FileServiceImpl;
import com.mss.e.farming.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private FileServiceImpl fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping
    public ResponseEntity<UserDTO> registrationUser(@RequestBody UserDTO user) throws IOException {
        return new ResponseEntity<>(this.userService
                .registrationUser(user, null), HttpStatus.CREATED);
    }

    @GetMapping
    public String get() {
        return "Md. Tanver Ahammed";
    }

    @PostMapping("/file")
    public String upload(@RequestParam("userImage") MultipartFile userImage) throws IOException {
        System.err.println(userImage.getOriginalFilename());
        return this.fileService.uploadImage(path, userImage);
//        return "Md. Tanver Ahammed";
    }

}

package com.mss.e.farming.service.impl;

import com.mss.e.farming.dto.UserDTO;
import com.mss.e.farming.entity.User;
import com.mss.e.farming.exception.ResourceNotFoundException;
import com.mss.e.farming.repository.RoleRepository;
import com.mss.e.farming.repository.UserRepository;
import com.mss.e.farming.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author: Md. Tanver Ahammed,
 * tanvermbstuit16@gmail.com,
 * ICT, MBSTU
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private ModelMapper modelMapper;

    @Value("    ${project.image}")
    private String path;

    @Override
    public UserDTO registrationUser(UserDTO userDTO, MultipartFile userImage) throws IOException {
        boolean flag = this.userRepository.existsUserByEmailOrPhone(userDTO.getEmail(), userDTO.getPhone());
        if (flag)
            return null;
        User user = this.dtoToUser(userDTO); // userDTO to user
        if (userImage != null && !Objects.equals(userImage.getOriginalFilename(), "")) {
            String imagesName = this.fileService.uploadImage(path, userImage);
            user.setImage(imagesName);
        }
        user.setEnable(false);
        String verificationCode = RandomString.make(64);
        user.setVerificationCode(verificationCode);
        return this.userToDTO(this.userRepository.save(user));
    }

    // get user by id
    private User getUserById(long userId) {
        return this.userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User", "Id", userId));
    }

    // user to userDTO
    private UserDTO userToDTO(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }

    // userDTO to user
    private User dtoToUser(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }

}

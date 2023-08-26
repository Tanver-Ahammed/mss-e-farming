package com.mss.e.farming.service;

import com.mss.e.farming.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: Md. Tanver Ahammed,
 * tanvermbstuit16@gmail.com,
 * ICT, MBSTU
 */

public interface UserService {

    UserDTO registrationUser(UserDTO user, MultipartFile userImage) throws IOException;

}

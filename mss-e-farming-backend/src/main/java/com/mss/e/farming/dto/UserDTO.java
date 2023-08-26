package com.mss.e.farming.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Md. Tanver Ahammed,
 * tanvermbstuit16@gmail.com,
 * ICT, MBSTU
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private long id;

    private String name;

    private String email;

    private String phone;

    private short age;

    private String occupation;

    private String designation;

    private String address;

    private boolean isEnable;

    private String verificationCode;

    private String image;

    private String password;

    private Set<RoleDTO> roles = new HashSet<>();

    private OrganizationDTO organization;

    private List<BlogDTO> blogs = new ArrayList<>();

}

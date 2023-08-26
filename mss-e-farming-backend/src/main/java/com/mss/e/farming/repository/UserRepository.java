package com.mss.e.farming.repository;

import com.mss.e.farming.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Md. Tanver Ahammed,
 * tanvermbstuit16@gmail.com,
 * ICT, MBSTU
 */

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByEmailOrPhone(String email, String phone);

}

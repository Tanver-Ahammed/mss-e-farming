package com.mss.e.farming.repository;

import com.mss.e.farming.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Md. Tanver Ahammed,
 * tanvermbstuit16@gmail.com,
 * ICT, MBSTU
 */

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

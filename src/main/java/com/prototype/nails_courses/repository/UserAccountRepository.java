package com.prototype.nails_courses.repository;

import com.prototype.nails_courses.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAccountRepository extends JpaRepository<User, UUID> {
}

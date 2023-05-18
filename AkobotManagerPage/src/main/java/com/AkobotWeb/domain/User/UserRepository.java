package com.AkobotWeb.domain.User;

/**
 * User의 CRUD를 책임질 User Repository
 */

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email); // container object which may or may not contain a non-null value
}

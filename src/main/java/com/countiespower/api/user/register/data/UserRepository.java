package com.countiespower.api.user.register.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByLastName(String lastName);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUserId(String userId);
}
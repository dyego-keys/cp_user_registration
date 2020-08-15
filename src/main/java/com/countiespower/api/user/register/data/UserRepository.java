package com.countiespower.api.user.register.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findByLastNameIgnoreCase(String lastName, Pageable pageable);
    Optional<UserEntity> findByEmailIgnoreCase(String email);
    Optional<UserEntity> findByUserId(String userId);

}
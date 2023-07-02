package com.teammansasung.careerbookapi.domain.user.repository;

import com.teammansasung.careerbookapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User 엔티티를 위한 데이터베이스 인터페이스
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

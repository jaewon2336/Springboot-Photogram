package com.cos.photogramstart.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository가 @Repository 어노테이션을 가지고 있기 때문에 IoC 등록됨
public interface UserRepository extends JpaRepository<User, Integer> {
    // JPA query method
    User findByUsername(String username);
}

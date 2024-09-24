package com.db.user.repository;
import com.db.user.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<user, String> {
    boolean existsByusername(String username);
}

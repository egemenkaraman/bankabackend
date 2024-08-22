package com.example.stajbank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface loginRepository extends JpaRepository<loginEntity,Long> {
    loginEntity findByUsernameAndPassword(String username, String password);
}

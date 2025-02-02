package com.TwinLine.Blogsite.Repo;

import com.TwinLine.Blogsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User,Integer> {
    public Optional<User> findByEmail(String username);
}

package com.Aakash.jobAppRestController.spring.api.repo;


import com.Aakash.jobAppRestController.spring.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {



    User findByUsername(String username);
}

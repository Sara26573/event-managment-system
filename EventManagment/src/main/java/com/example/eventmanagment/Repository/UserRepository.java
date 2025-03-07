package com.example.eventmanagment.Repository;

import com.example.eventmanagment.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User,Long>{

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    User findByUsernameAndPassword(String username, String password);

    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(String username);

}

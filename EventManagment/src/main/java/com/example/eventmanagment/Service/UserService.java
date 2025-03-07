package com.example.eventmanagment.Service;

import com.example.eventmanagment.Dto.AuthenticationResponseDTO;
import com.example.eventmanagment.Exceptions.UsernameAlreadyExistsException;
import com.example.eventmanagment.Model.User;
import com.example.eventmanagment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.PatternSyntaxException;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        if(checkForUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already taken.");
        }
        else {
            user.setRole("user");
            return userRepository.save(user);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public AuthenticationResponseDTO authenticateUser(String username, String password) {

        User user = userRepository.findByUsernameAndPassword(username,password);
        if(user!=null) {
            String role = user.getRole();
            Long id = user.getId();
            return new AuthenticationResponseDTO(role,username,id);

        }
        else{
            return null;
        }
    }

    public Boolean checkForUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        else return true;
    }
}

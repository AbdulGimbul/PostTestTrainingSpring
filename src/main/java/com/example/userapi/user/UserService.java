package com.example.userapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository
                .findUserByUsername(user.getUsername());

        if (userOptional.isPresent()){
            throw new IllegalStateException("username taken");
        }

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException(
                    "User with id " + userId + " does not exists");
        }

        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateStudent(Long userId,
                              String username,
                              String password,
                              Integer is_active) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "User with id " + userId + " does not exists"
                ));

        if (username != null && username.length() > 0
            && !Objects.equals(user.getUsername(), username)){
            Optional<User> userOptional = userRepository
                    .findUserByUsername(username);
            if (userOptional.isPresent()){
                throw new IllegalStateException("username taken");
            }
            user.setUsername(username);
        }

        if (password != null && password.length() > 0){
            user.setPassword(password);
        }

        if (is_active != null && is_active.toString().length() > 0){
            user.setIs_active(is_active);
        }
    }
}

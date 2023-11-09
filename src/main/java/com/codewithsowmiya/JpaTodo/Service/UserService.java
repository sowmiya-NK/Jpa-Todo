package com.codewithsowmiya.JpaTodo.Service;

import com.codewithsowmiya.JpaTodo.Model.User;
import com.codewithsowmiya.JpaTodo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(User user) {
        User user1 = userRepository.findUserByNameAndPassword(user.getName(), user.getPassword());
        return user1;

    }

    public User register(User user) {
        userRepository.save(user);
        return user;
    }
}

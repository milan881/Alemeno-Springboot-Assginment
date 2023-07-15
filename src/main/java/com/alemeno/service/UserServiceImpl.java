package com.alemeno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alemeno.model.User;
import com.alemeno.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
 

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

   }

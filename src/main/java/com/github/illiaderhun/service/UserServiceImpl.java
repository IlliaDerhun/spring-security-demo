package com.github.illiaderhun.service;

import com.github.illiaderhun.dto.UserDTO;
import com.github.illiaderhun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDTO userDTO;

    @Override
    @Transactional
    public void saveUser(User user) {
        userDTO.saveUser(user);
    }
}

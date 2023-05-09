package com.estoutic.scoreservice.services.impl;

import com.estoutic.scoreservice.database.models.Worker;
import com.estoutic.scoreservice.database.repositories.UserRepository;
import com.estoutic.scoreservice.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String save(String username) {
        Worker worker = Worker.builder()
                .username(username)
                .build();
        userRepository.save(worker);
        return worker.getId();
    }
}

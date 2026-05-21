package com.music.streaming.user.application.query;

import com.music.streaming.user.application.port.UserRepository;
import com.music.streaming.user.domain.User;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
public class GetAllUsersQuery {
    @NonNull
    private UserRepository userRepository;

    public List<User> execute() {
        return userRepository.getUsers();
    }
}

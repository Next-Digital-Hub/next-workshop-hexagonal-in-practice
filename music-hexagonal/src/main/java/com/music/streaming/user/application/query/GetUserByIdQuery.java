package com.music.streaming.user.application.query;

import com.music.streaming.user.application.port.UserRepository;
import com.music.streaming.user.domain.User;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.Optional;

@SuperBuilder
public class GetUserByIdQuery {
    @NonNull
    final UserRepository userRepository;
    @NonNull
    final String id;

    public Optional<User> execute() {
        return userRepository.getUserById(id);
    }
}

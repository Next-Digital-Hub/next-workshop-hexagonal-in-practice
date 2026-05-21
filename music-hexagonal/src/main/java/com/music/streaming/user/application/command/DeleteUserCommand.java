package com.music.streaming.user.application.command;

import com.music.streaming.user.application.port.UserRepository;
import com.music.streaming.user.domain.InvalidUserException;
import com.music.streaming.user.domain.UserNotFoundException;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
public class DeleteUserCommand {
    @NonNull
    final UserRepository userRepository;
    @NonNull
    final String id;

    public void handle() throws InvalidUserException, UserNotFoundException {
        try {
            UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new InvalidUserException();
        }
        if (userRepository.getUserById(id).isEmpty()) throw new UserNotFoundException();
        userRepository.deleteUser(id);
    }
}

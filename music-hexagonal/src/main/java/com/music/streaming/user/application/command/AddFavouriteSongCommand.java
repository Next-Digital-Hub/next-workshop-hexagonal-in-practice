package com.music.streaming.user.application.command;

import com.music.streaming.shared.domain.SongNotFoundException;
import com.music.streaming.shared.application.port.out.SongRepository;
import com.music.streaming.shared.domain.Song;
import com.music.streaming.user.application.port.UserRepository;
import com.music.streaming.user.domain.User;
import com.music.streaming.user.domain.UserNotFoundException;

import java.util.Optional;

public class AddFavouriteSongCommand {

    private final UserRepository userRepository;
    private final SongRepository songRepository;
    // TODO implement port and adapter
    private final NotificationService notificationService;

    public AddFavouriteSongCommand(UserRepository userRepository, SongRepository songRepository) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
    }

    private String userId;
    private String songId;

    public void handle() throws UserNotFoundException, SongNotFoundException {
        Optional<User> user = this.userRepository.getUserById(this.userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        Optional<Song> song = this.songRepository.getSongById(this.songId);
        if (song.isEmpty()) {
            throw new SongNotFoundException();
        }

        // TODO add validation so that user didn't reach favourite songs limit

        user.get().addFavouriteSong(songId);
        userRepository.updateUser(user.get());
    }
}

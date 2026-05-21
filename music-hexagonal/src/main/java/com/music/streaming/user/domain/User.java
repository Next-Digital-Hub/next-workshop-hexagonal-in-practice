package com.music.streaming.user.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class User {
    @Builder.Default
    final String id = UUID.randomUUID().toString();
    @With
    String username;
    @With
    String email;
    @With
    List<String> favouriteSongs;

    public void addFavouriteSong(String songId) {
        this.favouriteSongs.add(songId);
    }
}

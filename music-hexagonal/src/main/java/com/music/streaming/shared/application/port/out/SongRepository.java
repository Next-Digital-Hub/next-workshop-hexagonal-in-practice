package com.music.streaming.shared.application.port.out;

import com.music.streaming.shared.domain.Song;

import java.util.List;
import java.util.Optional;

public interface SongRepository {
    List<Song> getSongs();
    Optional<Song> getSongById(String id);
    Optional<Song> getSongByTitle(String title);
    void deleteSong(String id);
    void updateSong(Song song);
    String createSong(Song song);
}

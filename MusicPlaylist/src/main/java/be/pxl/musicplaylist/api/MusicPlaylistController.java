package be.pxl.musicplaylist.api;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/playlist/songs")
@Getter
public class MusicPlaylistController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MusicPlaylistController.class);
    private final MusicPlaylistService musicPlaylistService;

    @Autowired
    public MusicPlaylistController(MusicPlaylistService musicPlaylistService) {
        this.musicPlaylistService = musicPlaylistService;
    }

    @PostMapping(path = "/add")
    public void addSong(@RequestBody Song song) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Adding song [" + song.getTitle() + "]");
        }
        musicPlaylistService.addSong(song);
    }

    @GetMapping(path = "/get")
    public List<Song> getSongs() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Getting Songs");
        }
        return musicPlaylistService.getSongs();
    }

    @GetMapping("/{genre}")
    public List<Song> getSongsOfACertainGenre(@PathVariable Genre genre) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Getting songs of genre: {'" + genre.toString() + "'} .");
        }
        return musicPlaylistService.getSongsByGenre(genre);
    }

    @PutMapping("/{index}")
    public void updateSong(@PathVariable int index, @RequestBody Song song) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Updating song: ['" + song.getTitle() + "'] ...");
        }
        musicPlaylistService.updateSong(index, song);
    }

    @DeleteMapping("/{index}")
    public void updateSong(@PathVariable int index){
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Deleting song");
        }
        musicPlaylistService.deleteSong(index);
    }
}


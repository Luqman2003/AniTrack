package com.example.anitrack.Controller;

import com.example.anitrack.Service.JikanAnimeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/anime")
public class AnimeController {
    private final JikanAnimeService jikanAnimeService;

    public AnimeController(JikanAnimeService jikanAnimeService) {
        this.jikanAnimeService = jikanAnimeService;
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getAnimeById(@PathVariable String id) {
        return jikanAnimeService.getAnimeDetails(id);
    }

    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getAnimeBySearch(@RequestParam String name) {
        return jikanAnimeService.getAnimeBySearch(name);
    }

    @GetMapping("/{id}/characters")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getAnimeCharacters(@PathVariable String id) {
        return jikanAnimeService.getAnimeCharacters(id);
    }

    @GetMapping("/{id}/episodes")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getAnimeEpisodes(@PathVariable String id) {
        return jikanAnimeService.getAnimeEpisodes(id);
    }

    @GetMapping("/{id}/pictures")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getAnimePictures(@PathVariable String id) {
        return jikanAnimeService.getAnimePictures(id);
    }
}

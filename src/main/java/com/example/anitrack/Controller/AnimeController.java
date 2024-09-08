package com.example.anitrack.Controller;

import com.example.anitrack.Service.JikanService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/anime")
public class AnimeController {
    private final JikanService jikanService;

    public AnimeController(JikanService jikanService) {
        this.jikanService = jikanService;
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getAnimeById(@PathVariable String id) {
        return jikanService.getAnimeDetails(id);
    }

    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getAnimeBySearch(@RequestParam String name) {
        return jikanService.getAnimeBySearch(name);
    }

    @GetMapping("/{id}/characters")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getAnimeCharacters(@PathVariable String id) {
        return jikanService.getAnimeCharacters(id);
    }

    @GetMapping("/{id}/episodes")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getAnimeEpisodes(@PathVariable String id) {
        return jikanService.getAnimeEpisodes(id);
    }
}

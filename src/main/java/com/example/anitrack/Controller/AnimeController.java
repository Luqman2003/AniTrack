package com.example.anitrack.Controller;

import com.example.anitrack.Service.JikanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anime")
public class AnimeController {
    private final JikanService jikanService;

    public AnimeController(JikanService jikanService) {
        this.jikanService = jikanService;
    }

    @GetMapping("/{id}")
    public String getAnime(@PathVariable String id) {
        return jikanService.getAnimeDetails(id);
    }

    @GetMapping("/test")
    public String test() {
        return "hello, world";
    }
}

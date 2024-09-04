package Controller;

import Service.JikanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimeController {
    private final JikanService jikanService;

    public AnimeController(JikanService jikanService) {
        this.jikanService = jikanService;
    }

    @GetMapping("/anime/{id}")
    public String getAnime(@PathVariable String id) {
        return jikanService.getAnimeDetails(id);
    }
}

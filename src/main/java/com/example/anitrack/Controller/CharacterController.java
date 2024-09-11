package com.example.anitrack.Controller;

import com.example.anitrack.Service.JikanCharacterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final JikanCharacterService jikanCharacterService;

    public CharacterController(JikanCharacterService jikanCharacterService) {
        this.jikanCharacterService = jikanCharacterService;
    }

    @GetMapping("/{id}/full")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getCharacterFullById(@PathVariable String id) {
        return jikanCharacterService.getCharacterFullById(id);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getCharacterById(@PathVariable String id) {
        return jikanCharacterService.getCharacterById(id);
    }

    @GetMapping("/{id}/anime")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getCharacterAnime(@PathVariable String id) {
        return jikanCharacterService.getCharacterAnime(id);
    }

    @GetMapping("/{id}/manga")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getCharacterManga(@PathVariable String id) {
        return jikanCharacterService.getCharacterManga(id);
    }

    @GetMapping("/{id}/voices")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getCharacterVoiceActors(@PathVariable String id) {
        return jikanCharacterService.getCharacterVoiceActors(id);
    }

    @GetMapping("/{id}/pictures")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getCharacterPictures(@PathVariable String id) {
        return jikanCharacterService.getCharacterPictures(id);
    }

    @GetMapping("/search")
    @CrossOrigin(origins = "http://localhost:3000")
    public String getCharactersSearch(@RequestParam String characterName) {
        return jikanCharacterService.getCharactersSearch(characterName);
    }
}

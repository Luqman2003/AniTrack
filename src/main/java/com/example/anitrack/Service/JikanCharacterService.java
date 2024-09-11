package com.example.anitrack.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class JikanCharacterService {

    private final RestTemplate restTemplate;

    @Value("${jikan.api.url}")
    private String apiUrl;

    public JikanCharacterService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCharacterFullById(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment("characters", id, "full")
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCharacterById(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment("characters", id)
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCharacterAnime(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment("characters", id, "anime")
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCharacterManga(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment("characters", id, "manga")
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCharacterVoiceActors(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment("characters", id, "voices")
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     *
     * @param id
     * @return
     */
    public String getCharacterPictures(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment("characters", id, "pictures")
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     *
     * @param characterName
     * @return
     */
    public String getCharactersSearch(String characterName) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment("characters")
                .queryParam("q", characterName)
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}

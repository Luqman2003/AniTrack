package com.example.anitrack.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class JikanService {

    private final RestTemplate restTemplate;

    @Value("${jikan.api.url}")
    private String apiUrl;

    public JikanService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * makes a call to jikan API under the /anime/{id} endpoint
     * @param id - the id of the anime
     * @return String - the string format of the response
     */
    public String getAnimeDetails(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment("anime", id)
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * makes a call to the jikan API under the /anime endpoint with the query param
     * "q" that specifies the name ofo the anime
     * @param name - the name of the anime
     * @return String - the string format of the response
     */
    public String getAnimeBySearch(String name) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .pathSegment("anime")
                .queryParam("q", name)
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * makes a call to the jikan API under the /anime/{id}/characters endpoint
     * @param id - the id of the anime
     * @return String - the string format of the response
     */
    public String getAnimeCharacters(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .pathSegment("anime", id, "characters")
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * makes a call to the jikan API under the /anime/{id}/episodes endpoint
     * @param id - the id of the anime
     * @return String - the string format of the response
     */
    public String getAnimeEpisodes(String id) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .pathSegment("anime", id, "episodes")
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}

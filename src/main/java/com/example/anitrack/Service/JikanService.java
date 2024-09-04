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

    public String getAnimeDetails(String id) {
        System.out.println(id);
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment("anime", id)
                .toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}

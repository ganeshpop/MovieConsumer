package com.ganesh.service;

import com.ganesh.bean.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class MovieService {
    private RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovieById(int id) {
        return restTemplate.getForObject("http://localhost:8082/movies/" + id, Movie.class);

    }

    public Collection<Movie> getAllMovies() {
        ResponseEntity<Collection<Movie>> responseEntity =
                restTemplate.exchange(
                        "http://localhost:8082/movies/",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Collection<Movie>>() {}
                );
        Collection<Movie> movies = responseEntity.getBody();
        assert movies != null;
        return new ArrayList<>(movies);
    }


    public Movie insertMovie(Movie movie) {
        return restTemplate.postForObject("http://localhost:8082/movies/", movie, Movie.class);
    }

    public Movie deleteMovieById(int id) {
        HttpEntity<Movie> httpEntity = new HttpEntity<>(new Movie());
        ResponseEntity<Movie> responseEntity =
                restTemplate.exchange("http://localhost:8082/movies/{id}", HttpMethod.DELETE, httpEntity, Movie.class, id);
        return responseEntity.getBody();
    }


    public Movie updateMovieName(int id, String name) {

        HttpEntity<Movie> httpEntity = new HttpEntity<>(new Movie());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> responseEntity = restTemplate.exchange("http://localhost:8082/movies/{id}/{name}", HttpMethod.PUT, httpEntity,
                Movie.class, id, name);

        return responseEntity.getBody();
    }

}

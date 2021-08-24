package com.ganesh.service;

import com.ganesh.bean.Rating;

import com.ganesh.bean.RatingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class RatingService {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Rating> getRatingByUserId(int id) {
        return Objects.requireNonNull(restTemplate.getForObject("http://localhost:8084/ratings/users/" + id, RatingList.class)).getRatings();
    }
//    public Collection<Rating> getRatingByUserId(int id) {
//        ResponseEntity<Collection<Rating>> responseEntity =
//                restTemplate.exchange(
//                        "http://localhost:8084/ratings/users/" + id,
//                        HttpMethod.GET,
//                        null,
//                        new ParameterizedTypeReference<Collection<Rating>>() {
//                        }
//                );
//        Collection<Rating> ratings = responseEntity.getBody();
//        for (Rating r : ratings) {
//            System.out.println(r);
//        }
//        assert ratings != null;
//        return new ArrayList<>(ratings);
//    }

}

package com.ganesh.service;

import com.ganesh.bean.MovieAndRating;
import com.ganesh.bean.MoviesAndRatingsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class CatalogService {
    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<MovieAndRating> moviesWithRatingsByUser(int id) {
        return Objects.requireNonNull(restTemplate.getForObject("http://localhost:8088/catalogs/" + id, MoviesAndRatingsList.class)).getMoviesAndRatings();
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

/*

class Rating{
    rating id,
user id,
movie id,
rating
}

class RatingList{
  List<rating> ratings;
//getter ad setter
}

public RatingList getRatingList(int userid)*/

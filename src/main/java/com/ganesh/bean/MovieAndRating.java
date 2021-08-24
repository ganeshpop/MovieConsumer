package com.ganesh.bean;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieAndRating {
    private int ratingId;
    private int userId;
    private int movieId;
    private String movieName;
    private int rating;
}

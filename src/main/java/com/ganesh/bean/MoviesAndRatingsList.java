package com.ganesh.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoviesAndRatingsList {
    private List<MovieAndRating> moviesAndRatings;
}
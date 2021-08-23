package com.ganesh.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Rating {
    private int id;
    private int userId;
    private int movieId;
    private int rating;

    public String toString(){
        return " User with id " + userId + " gave Movie with ID " + movieId + " a Rating of " + rating + "/5";
    }
}

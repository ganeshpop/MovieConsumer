package com.ganesh.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Movie {
    private int id;
    private String name;

    public Movie(String name){
        this.name = name;
    }

    public String toString(){
        return name  + " with ID : " + id;
    }
}

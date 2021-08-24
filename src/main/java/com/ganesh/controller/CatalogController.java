package com.ganesh.controller;

import com.ganesh.bean.MovieAndRating;
import com.ganesh.bean.Rating;
import com.ganesh.bean.RatingList;
import com.ganesh.service.CatalogService;
import com.ganesh.service.MovieService;
import com.ganesh.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

@Controller
public class CatalogController {
    MovieService movieService;
    RatingService ratingService;
    CatalogService catalogService;

    @Autowired
    public void setCatalogService(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("showMoviesWithRating")
    public ModelAndView moviesWithRatingsController(){
        return new ModelAndView("getAllMoviesAndRating");
    }

    @RequestMapping("showMoviesWithRatingByUserID")
    public ModelAndView moviesWithRatingsByUserController(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("getAllMoviesAndRatingByUserID");
        modelAndView.addObject("moviesAndRatings", catalogService.moviesWithRatingsByUser(Integer.parseInt(request.getParameter("id"))));
        return modelAndView;
    }
}

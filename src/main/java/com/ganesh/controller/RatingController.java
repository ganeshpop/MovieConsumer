package com.ganesh.controller;

import com.ganesh.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RatingController {
    RatingService ratingService;

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }
    @RequestMapping("rating")
    public ModelAndView movieController() {
        return new ModelAndView("ratingByUserId");
    }


    @RequestMapping("ratingById")
    public ModelAndView allMoviesController(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("getRatingsByUserIdOutput");
        modelAndView.addObject("ratings" , ratingService.getRatingByUserId(id));
        return modelAndView;
    }
}

package com.ganesh.controller;

import com.ganesh.bean.Rating;
import com.ganesh.bean.RatingList;
import com.ganesh.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("ratings")
public class RatingController {
    RatingService ratingService;

    @ModelAttribute
    public List<Rating> setRatings(List<Rating> ratingList) {
        return ratingList;
    }

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    @RequestMapping("rating")
    public ModelAndView movieController() {
        return new ModelAndView("ratingByUserId");
    }



    @RequestMapping("ratingById")
    public ModelAndView allMoviesController(@RequestParam("id") int id, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("getRatingsByUserIdOutput");
        setRatings(ratingService.getRatingByUserId(id));
        modelAndView.addObject("ratings", session.getAttribute("ratings") );
        return modelAndView;
    }
}

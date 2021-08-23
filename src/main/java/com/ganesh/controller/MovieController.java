package com.ganesh.controller;

import com.ganesh.bean.Movie;
import com.ganesh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class MovieController {
    MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("getMovie")
    public ModelAndView movieController() {
        return new ModelAndView("getMovieById");
    }

    @RequestMapping("insert")
    public ModelAndView movieInsertController() {
        return new ModelAndView("insertMovie", "movie", new Movie());
    }

    @RequestMapping("deleteMovie")
    public ModelAndView movieDeleteController() {
        return new ModelAndView("deleteMovieById");
    }

    @RequestMapping("update")
    public ModelAndView movieUpdateController() {
        return new ModelAndView("updateMovie", "movie", new Movie());
    }

    @ModelAttribute("movieIds")
    public List<Integer> getAllIds() {
        return movieService.getAllMovies().stream().map(Movie::getId).collect(Collectors.toList());
    }

    @RequestMapping("getMovieDetails")
    public ModelAndView movieByIdController(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("getMovieByIdOutput");
        modelAndView.addObject("movie",movieService.getMovieById(Integer.parseInt(request.getParameter("movieId"))));
        return modelAndView;
    }
    @RequestMapping("delete")
    public ModelAndView movieDeleteController(HttpServletRequest request) {
        Movie movie = movieService.deleteMovieById(Integer.parseInt(request.getParameter("id")));
        if (movie != null)
            return new ModelAndView("output", "message", "Movie " + movie + " has been deleted.");
        else
            return new ModelAndView("output", "message", "Movie has not been deleted.");
    }

    @RequestMapping("updateMovieById")
    public ModelAndView updateMovieByIdController(@ModelAttribute Movie movie) {
        if (movieService.updateMovieName(movie.getId(), movie.getName()) != null)
            return new ModelAndView("output", "message","Movie Name Updated Successfully");
        else
            return new ModelAndView("output", "message","Movie Name Update Failed");
    }
    @RequestMapping("save")
    public ModelAndView movieByIdController(@ModelAttribute("movie") Movie movie) {
        ModelAndView modelAndView = new ModelAndView("output");
        modelAndView.addObject("message", "Movie Inserted - " +movieService.insertMovie(movie).toString());
        return modelAndView;
    }

    @RequestMapping("showAllMovies")
    public ModelAndView allMoviesController() {
        ModelAndView modelAndView = new ModelAndView("getAllMoviesOutput");
        modelAndView.addObject("movies",movieService.getAllMovies());
        return modelAndView;
    }




}

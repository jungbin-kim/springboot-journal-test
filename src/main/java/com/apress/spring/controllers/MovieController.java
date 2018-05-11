package com.apress.spring.controllers;
/*
 * Created by jungbin on 2018. 5. 10.
 */

import com.apress.spring.domain.Movie;
import com.apress.spring.services.MovieService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "/m1", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody Movie findByTitle(@RequestParam String title) {
        return movieService.findByTitle(title);
    }

    @RequestMapping(value = "/m2", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Movie> findByTitleLike(@RequestParam String title) {
        return movieService.findByTitleLike(title);
    }

}

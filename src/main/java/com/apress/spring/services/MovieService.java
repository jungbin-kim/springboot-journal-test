package com.apress.spring.services;
/*
 * Created by jungbin on 2018. 5. 10.
 */

import com.apress.spring.domain.Movie;
import com.apress.spring.repository.MovieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Transactional(readOnly = true)
    public Movie findByTitle(String title) {
        Movie result = movieRepository.findByTitle(title);
        return result;
    }

    @Transactional(readOnly = true)
    public List<Movie> findByTitleLike(String title) {
        List<Movie> result = movieRepository.findByTitleLike(title);
        return result;
    }
}

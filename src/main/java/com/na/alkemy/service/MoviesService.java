package com.na.alkemy.service;

import com.na.alkemy.dto.MoviesDto;
import com.na.alkemy.payload.MoviesForm;

/**
 * @author nagredo
 * @project alkemy
 * @class MoviesService
 */
public interface MoviesService {
    MoviesDto create(MoviesForm moviesForm);

    MoviesDto update(MoviesForm moviesForm);

    boolean delete(Integer id);
}

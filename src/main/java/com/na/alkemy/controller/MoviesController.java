package com.na.alkemy.controller;

import com.na.alkemy.dto.MoviesDto;
import com.na.alkemy.payload.MoviesForm;
import com.na.alkemy.service.MoviesService;
import com.na.alkemy.util.GeneralBodyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author nagredo
 * @project alkemy
 * @class MoviesController
 */
@RestController
public class MoviesController {
    private final MoviesService moviesService;

    public MoviesController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @PostMapping("movies")
    public ResponseEntity<GeneralBodyResponse<MoviesDto>> create(@Valid @RequestBody MoviesForm moviesForm) {
        try {
            MoviesDto moviesDto = this.moviesService.create(moviesForm);

            if (moviesDto.getId() != null)
                return new ResponseEntity<>(new GeneralBodyResponse<>(moviesDto, "created", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(null, "not created", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}

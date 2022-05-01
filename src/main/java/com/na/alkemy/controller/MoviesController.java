package com.na.alkemy.controller;

import com.na.alkemy.dto.MoviesDto;
import com.na.alkemy.payload.MoviesForm;
import com.na.alkemy.service.MoviesService;
import com.na.alkemy.util.GeneralBodyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("movies")
    public ResponseEntity<GeneralBodyResponse<MoviesDto>> update(@Valid @RequestBody MoviesForm moviesForm) {
        try {
            MoviesDto moviesDto = this.moviesService.update(moviesForm);

            return new ResponseEntity<>(new GeneralBodyResponse<>(moviesDto, "update", null), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("movies/{id}")
    public ResponseEntity<GeneralBodyResponse<Boolean>> delete(@PathVariable Integer id) {
        try {
            if (this.moviesService.delete(id))
                return new ResponseEntity<>(new GeneralBodyResponse<>(true, "delete ok", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(false, "not delete", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}

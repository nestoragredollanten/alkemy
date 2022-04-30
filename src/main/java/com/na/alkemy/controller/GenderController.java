package com.na.alkemy.controller;

import com.na.alkemy.dto.GenderDto;
import com.na.alkemy.payload.GenderForm;
import com.na.alkemy.service.GenderService;
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
 * @class GenderController
 */
@RestController
public class GenderController {
    private final GenderService genderService;

    public GenderController(GenderService genderService) {
        this.genderService = genderService;
    }

    @PostMapping("gender")
    public ResponseEntity<GeneralBodyResponse<GenderDto>> create(@Valid @RequestBody GenderForm genderForm) {
        try {
            GenderDto genderDto = this.genderService.create(genderForm);

            if (genderDto.getId() != null)
                return new ResponseEntity<>(new GeneralBodyResponse<>(genderDto, "created", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(null, "not created", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}

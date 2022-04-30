package com.na.alkemy.service;

import com.na.alkemy.dto.GenderDto;
import com.na.alkemy.payload.GenderForm;

/**
 * @author nagredo
 * @project alkemy
 * @class GenderService
 */
public interface GenderService {
    GenderDto create(GenderForm genderForm);
}

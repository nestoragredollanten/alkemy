package com.na.alkemy.service;

import com.na.alkemy.dto.CharacterCreateResponseDto;
import com.na.alkemy.dto.CharacterDto;
import com.na.alkemy.payload.CharacterForm;

import java.util.List;

/**
 * @author nagredo
 * @project alkemy
 * @class CharacterService
 */
public interface CharacterService {
    List<CharacterDto> findAll();

    CharacterCreateResponseDto create(CharacterForm CharacterForm);

    CharacterCreateResponseDto update(CharacterForm characterForm);

    boolean delete(Integer id);

    CharacterDto findById(Integer id);

    CharacterDto findByName(String name);

    CharacterDto findByAge(String age);

    CharacterDto findByMovies(String movie);
}

package com.na.alkemy.dto;

/**
 * @author nagredo
 * @project alkemy
 * @class CharacterCreateResponseDto
 */
public class CharacterCreateResponseDto {
    private CharacterDto characterDto;
    private MoviesDto moviesDto;

    public CharacterDto getCharacterDto() {
        return characterDto;
    }

    public void setCharacterDto(CharacterDto characterDto) {
        this.characterDto = characterDto;
    }

    public MoviesDto getMoviesDto() {
        return moviesDto;
    }

    public void setMoviesDto(MoviesDto moviesDto) {
        this.moviesDto = moviesDto;
    }
}

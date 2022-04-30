package com.na.alkemy.service.serviceImple;

import com.na.alkemy.domain.CharacterEntity;
import com.na.alkemy.domain.MoviesEntity;
import com.na.alkemy.dto.CharacterCreateResponseDto;
import com.na.alkemy.dto.CharacterDto;
import com.na.alkemy.dto.MoviesDto;
import com.na.alkemy.payload.CharacterForm;
import com.na.alkemy.repository.CharacterRepository;
import com.na.alkemy.repository.MoviesRepository;
import com.na.alkemy.service.CharacterService;
import com.na.alkemy.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author nagredo
 * @project alkemy
 * @class CharacterServiceImple
 */
@Service
@Transactional
public class CharacterServiceImple implements CharacterService {
    private final ModelMapper modelMapper;
    private final CharacterRepository characterRepository;
    private final MoviesRepository moviesRepository;

    public CharacterServiceImple(ModelMapper modelMapper, CharacterRepository characterRepository, MoviesRepository moviesRepository) {
        this.modelMapper = modelMapper;
        this.characterRepository = characterRepository;
        this.moviesRepository = moviesRepository;
    }

    @Override
    public List<CharacterDto> findAll() {
        return ObjectMapperUtils.mapAll(characterRepository.findAll(), CharacterDto.class);
    }

    @Override
    public CharacterCreateResponseDto create(CharacterForm characterForm) {
        CharacterEntity characterEntity = modelMapper.map(characterForm, CharacterEntity.class);

        characterEntity = this.characterRepository.save(characterEntity);
        MoviesEntity moviesEntity = this.moviesRepository.findById(characterForm.getAssociatedMovies()).orElse(null);
        CharacterCreateResponseDto characterCreateResponseDto = new CharacterCreateResponseDto();

        characterCreateResponseDto.setCharacterDto(modelMapper.map(characterEntity, CharacterDto.class));
        characterCreateResponseDto.setMoviesDto(modelMapper.map(moviesEntity, MoviesDto.class));

        return characterCreateResponseDto;
    }

    @Override
    public CharacterCreateResponseDto update(CharacterForm characterForm) {
        CharacterEntity characterEntity = modelMapper.map(characterForm, CharacterEntity.class);

        characterEntity = this.characterRepository.save(characterEntity);
        MoviesEntity moviesEntity = this.moviesRepository.findById(characterForm.getAssociatedMovies()).orElse(null);
        CharacterCreateResponseDto characterCreateResponseDto = new CharacterCreateResponseDto();

        characterCreateResponseDto.setCharacterDto(modelMapper.map(characterEntity, CharacterDto.class));
        characterCreateResponseDto.setMoviesDto(modelMapper.map(moviesEntity, MoviesDto.class));

        return characterCreateResponseDto;
    }

    @Override
    public boolean delete(Integer id) {
        if (id != null) {
            CharacterDto characterDto = this.findById(id);
            CharacterEntity characterEntity = ObjectMapperUtils.map(characterDto, CharacterEntity.class);

            this.characterRepository.delete(characterEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CharacterDto findById(Integer id) {
        CharacterEntity characterEntity = characterRepository.findById(id).orElse(null);

        return ObjectMapperUtils.map(characterEntity, CharacterDto.class);
    }

    @Override
    public CharacterDto findByName(String name) {
        CharacterEntity characterEntity = characterRepository.findByName(name);

        return ObjectMapperUtils.map(characterEntity, CharacterDto.class);
    }

    @Override
    public CharacterDto findByAge(String age) {
        CharacterEntity characterEntity = characterRepository.findByAge(age);

        return ObjectMapperUtils.map(characterEntity, CharacterDto.class);
    }

    @Override
    public CharacterDto findByMovies(String movies) {
        CharacterEntity characterEntity = characterRepository.findByAssociatedMovies(movies);

        return ObjectMapperUtils.map(characterEntity, CharacterDto.class);
    }
}

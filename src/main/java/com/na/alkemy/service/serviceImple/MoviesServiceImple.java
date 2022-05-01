package com.na.alkemy.service.serviceImple;

import com.na.alkemy.domain.MoviesEntity;
import com.na.alkemy.dto.MoviesDto;
import com.na.alkemy.exceptions.ArgumentRequiredException;
import com.na.alkemy.exceptions.ModelNotFoundException;
import com.na.alkemy.payload.MoviesForm;
import com.na.alkemy.repository.MoviesRepository;
import com.na.alkemy.service.MoviesService;
import com.na.alkemy.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * @author nagredo
 * @project alkemy
 * @class MoviesServiceImple
 */
@Service
public class MoviesServiceImple implements MoviesService {
    private final ModelMapper modelMapper;
    private final MoviesRepository moviesRepository;

    public MoviesServiceImple(ModelMapper modelMapper, MoviesRepository moviesRepository) {
        this.modelMapper = modelMapper;
        this.moviesRepository = moviesRepository;
    }

    @Override
    public MoviesDto create(MoviesForm moviesForm) {
        MoviesEntity moviesEntity = modelMapper.map(moviesForm, MoviesEntity.class);

        moviesEntity = this.moviesRepository.save(moviesEntity);
        return modelMapper.map(moviesEntity, MoviesDto.class);
    }

    @Override
    public MoviesDto update(MoviesForm moviesForm) {
        if (moviesForm.getId() != null) {
            MoviesEntity moviesEntity = modelMapper.map(moviesForm, MoviesEntity.class);

            moviesEntity = this.moviesRepository.save(moviesEntity);
            return modelMapper.map(moviesEntity, MoviesDto.class);
        } else {
            throw new ArgumentRequiredException("Body requerido");
        }
    }

    @Override
    public boolean delete(Integer id) {
        if (id != null) {
            MoviesDto moviesDto = this.findById(id);
            MoviesEntity moviesEntity = ObjectMapperUtils.map(moviesDto, MoviesEntity.class);

            this.moviesRepository.delete(moviesEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MoviesDto findById(Integer id) {
        MoviesEntity sosEntity = this.moviesRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("Not found"));

        return ObjectMapperUtils.map(sosEntity, MoviesDto.class);
    }
}

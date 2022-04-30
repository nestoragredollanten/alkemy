package com.na.alkemy.service.serviceImple;

import com.na.alkemy.domain.GenderEntity;
import com.na.alkemy.dto.GenderDto;
import com.na.alkemy.payload.GenderForm;
import com.na.alkemy.repository.GenderRepository;
import com.na.alkemy.service.GenderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nagredo
 * @project alkemy
 * @class GenderServiceImple
 */
@Service
@Transactional
public class GenderServiceImple implements GenderService {
    private final ModelMapper modelMapper;
    private final GenderRepository genderRepository;

    public GenderServiceImple(ModelMapper modelMapper, GenderRepository genderRepository) {
        this.modelMapper = modelMapper;
        this.genderRepository = genderRepository;
    }

    @Override
    public GenderDto create(GenderForm genderForm) {
        GenderEntity genderEntity = modelMapper.map(genderForm, GenderEntity.class);

        genderEntity = this.genderRepository.save(genderEntity);
        return modelMapper.map(genderEntity, GenderDto.class);
    }
}

package com.na.alkemy.controller;

import com.na.alkemy.dto.CharacterCreateResponseDto;
import com.na.alkemy.dto.CharacterDto;
import com.na.alkemy.payload.CharacterForm;
import com.na.alkemy.service.CharacterService;
import com.na.alkemy.util.GeneralBodyResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nagredo
 * @project alkemy
 * @class CharacterController
 */
@RestController
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping("characters")
    public ResponseEntity<GeneralBodyResponse<CharacterCreateResponseDto>> create(@Valid @RequestBody CharacterForm characterForm) {
        try {
            CharacterCreateResponseDto characterCreateResponseDto = this.characterService.create(characterForm);

            if (characterCreateResponseDto.getCharacterDto().getId() != null)
                return new ResponseEntity<>(new GeneralBodyResponse<>(characterCreateResponseDto, "created", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(null, "not created", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("characters")
    public ResponseEntity<GeneralBodyResponse<CharacterCreateResponseDto>> update(@Valid @RequestBody CharacterForm characterForm) {
        try {
            CharacterCreateResponseDto characterCreateResponseDto = this.characterService.update(characterForm);

            if (characterForm.getId() != null)
                return new ResponseEntity<>(new GeneralBodyResponse<>(characterCreateResponseDto, "update", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(null, "not update", null), HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("characters/{id}")
    public ResponseEntity<GeneralBodyResponse<Boolean>> delete(@PathVariable Integer id) {
        try {

            if (this.characterService.delete(id))
                return new ResponseEntity<>(new GeneralBodyResponse<>(true, "delete ok", null), HttpStatus.OK);
            else
                return new ResponseEntity<>(new GeneralBodyResponse<>(false, "not delete", null), HttpStatus.BAD_REQUEST);

        } catch (Exception ex) {
            return new ResponseEntity<>(new GeneralBodyResponse<>(null, ex.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("characters")
    public <T> ResponseEntity<T> getByName(@Nullable @RequestParam String name,
                                           @Nullable @RequestParam String age,
                                           @Nullable @RequestParam String movies) {
        try {
            CharacterDto characterDto = new CharacterDto();
            List<CharacterDto> characterDtoList = new ArrayList<>();

            if (name != null)
                characterDto = this.characterService.findByName(name);

            if (age != null)
                characterDto = this.characterService.findByAge(age);

            if (movies != null)
                characterDto = this.characterService.findByMovies(movies);

            if ((name == null) && (age == null) && (movies == null))
                characterDtoList = this.characterService.findAll();

            if (!characterDtoList.isEmpty())
                return new ResponseEntity<T>((T) characterDtoList, HttpStatus.OK);
            else if (!characterDto.getName().isEmpty())
                return new ResponseEntity<T>((T) characterDto, HttpStatus.OK);
            else
                return new ResponseEntity<T>((T) "empty", HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            return new ResponseEntity<T>((T) ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

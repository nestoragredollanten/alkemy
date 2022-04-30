package com.na.alkemy.repository;

import com.na.alkemy.domain.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nagredo
 * @project alkemy
 * @class CharacterRepository
 */
@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {
    CharacterEntity findByName(String name);

    CharacterEntity findByAge(String age);

    CharacterEntity findByAssociatedMovies(String movies);
}

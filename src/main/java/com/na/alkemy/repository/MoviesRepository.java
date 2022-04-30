package com.na.alkemy.repository;

import com.na.alkemy.domain.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nagredo
 * @project alkemy
 * @class MoviesRepository
 */
@Repository
public interface MoviesRepository extends JpaRepository<MoviesEntity, Integer> {
}

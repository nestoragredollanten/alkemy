package com.na.alkemy.repository;

import com.na.alkemy.domain.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nagredo
 * @project alkemy
 * @class GenderRepository
 */
@Repository
public interface GenderRepository extends JpaRepository<GenderEntity, Integer> {
}


package com.formation.velo.repository;

import com.formation.velo.model.Pool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PoolRepository extends JpaRepository<Pool, Integer> {

    Optional<Pool> findByRecordId(String recordId);
}
package com.formation.velo.service;

import com.formation.velo.model.Pool;

import java.util.List;
import java.util.Optional;

public interface PoolService {

    List<Pool> findAll();

    Optional<Pool> findById(Integer id);

    Pool save(Pool pool);

    void saveRecord();

    Optional<Pool> findByRecordId(String recordId);

}

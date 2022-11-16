package com.formation.velo.service.impl;

import com.formation.velo.api.pool.OpenDataPool;
import com.formation.velo.api.pool.OpenDataPoolClient;
import com.formation.velo.model.Pool;
import com.formation.velo.repository.PoolRepository;
import com.formation.velo.service.PoolService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class PoolServiceImpl implements PoolService {
    private final PoolRepository poolRepository;

    public PoolServiceImpl(PoolRepository repository) {
        this.poolRepository = repository;
    }

    @Override
    public List<Pool> findAll() {
        return poolRepository.findAll();
    }

    @Override
    public Optional<Pool> findById(Integer id){
        return poolRepository.findById(id);
    }

    @Override
    public Pool save(Pool pool){
        return poolRepository.save(pool);
    }

    @Override
    public void saveRecord() {
        //Appel à OpenData
        String baseUrl = "https://data.nantesmetropole.fr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenDataPoolClient client = retrofit.create(OpenDataPoolClient.class);

        Call<OpenDataPool> openDataPoolClient = client.getRecordsPool();
        try {
            OpenDataPool openDataPool = openDataPoolClient.execute().body();

            Arrays.stream(openDataPool.getRecords()).forEach(record -> {
                Optional<Pool> pool = findByRecordId(record.getRecordId());
                if(!pool.isPresent()){
                    Double latitude = null;
                    Double longitude = null;
                    if(record.getField().getLocation() != null){
                        latitude = record.getField().getLocation()[0];
                        longitude = record.getField().getLocation()[1];
                    }

                    Pool newPool = Pool.builder()
                            .recordId(record.getRecordId())
                            .nomComplet(record.getField().getNomComplet())
                            .accesPmrEquipt(record.getField().getAccesPmrEquipt())
                            .cp(record.getField().getCp())
                            .accessibiliteHandicap(record.getField().getAccessibiliteHandicap())
                            .accesTransportsCommun(record.getField().getAccesTransportsCommun())
                            .adresse(record.getField().getAdresse())
                            .idobj(record.getField().getIdobj())
                            .bassinApprentissage(record.getField().getBassinApprentissage())
                            .bassinLoisir(record.getField().getBassinLoisir())
                            .bassinSportif(record.getField().getBassinSportif())
                            .commune(record.getField().getCommune())
                            .libreService(record.getField().getLibreService())
                            .tel(record.getField().getTel())
                            .latitude(latitude)
                            .longitude(longitude)
                            .web(record.getField().getWeb())
                            .nomUsuel(record.getField().getNomUsuel())
                            .pataugeoire(record.getField().getPataugeoire())
                            .plongeoir(record.getField().getPlongeoir())
                            .toboggan(record.getField().getToboggan())
                            .commune(record.getField().getCommune())
                            .build();
                    // on save
                    System.out.print(newPool);
                    save(newPool);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Pool> findByRecordId(String recordId){
        return poolRepository.findByRecordId(recordId);
    }
}
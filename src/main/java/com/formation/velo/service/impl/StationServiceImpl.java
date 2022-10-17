package com.formation.velo.service.impl;

import com.formation.velo.api.velo.OpenDataNantesClient;
import com.formation.velo.api.OpenData;
import com.formation.velo.model.Station;
import com.formation.velo.repository.StationRepository;
import com.formation.velo.service.StationService;
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
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository repository) {
        this.stationRepository = repository;
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override
    public Optional<Station> findById(Integer id){
        return stationRepository.findById(id);
    }

    @Override
    public Station save(Station station){
        return stationRepository.save(station);
    }

    @Override
    public void deleteById(Integer id) {
        stationRepository.deleteById(id);
    }

    @Override
    public void delete(Station station) {
        stationRepository.delete(station);
    }

    @Override
    public void saveRecord() {
        //Appel à OpenData
        String baseUrl = "https://data.nantesmetropole.fr/";
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OpenDataNantesClient client = retrofit.create(OpenDataNantesClient.class);

        Call<OpenData> openDataVeloNantesCall = client.getRecords();
        try {
            OpenData openData = openDataVeloNantesCall.execute().body();
            log.info(openData.toString());

            Arrays.stream(openData.getRecords()).forEach(record -> {
                Optional<Station> station = findByRecordId(record.getRecordId());
                if(station.isPresent()){
                    //update station
                    // on update la station
                    station.get().setAvailableBikeStands(record.getField().getAvailableBikeStands());
                    station.get().setAvailableBikes(record.getField().getAvailableBikes());
                    station.get().setBikeStands(record.getField().getBikeStands());
                    station.get().setStatus(record.getField().getStatus());

                    // on save
                    save(station.get());
                }else{
                    Station newStation = Station.builder()
                            .recordId(record.getRecordId())
                            .name(record.getField().getName())
                            .availableBikes(record.getField().getAvailableBikes())
                            .bikeStands(record.getField().getBikeStands())
                            .availableBikeStands(record.getField().getAvailableBikeStands())
                            .latitude(record.getField().getPosition()[0])
                            .longitude(record.getField().getPosition()[1])
                            .status(record.getField().getStatus())
                            .address(record.getField().getAddress())
                            .build();
                    // on save
                    save(newStation);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Station> findByRecordId(String recordId){
        return stationRepository.findByRecordId(recordId);
    }
}

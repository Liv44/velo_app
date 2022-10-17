package com.formation.velo.controllers;

import com.formation.velo.model.Station;
import com.formation.velo.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("stations")
    public ResponseEntity<List<Station>> getAll(){
        List<Station> stations = stationService.findAll();

        return ResponseEntity.ok(stations);
    }

    @GetMapping("stations/{id}")
    public ResponseEntity<Optional<Station>> getStationById(@PathVariable Integer id){
        Optional<Station> station = stationService.findById(id);

        return ResponseEntity.ok(station);
    }
}

package com.formation.velo.controllers;

import com.formation.velo.model.Pool;
import com.formation.velo.service.PoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class PoolController {
    private final PoolService poolService;

    public PoolController(PoolService poolService) {
        this.poolService = poolService;
    }

    @GetMapping("pools")
    public ResponseEntity<List<Pool>> getAll(){
        List<Pool> pools = poolService.findAll();

        return ResponseEntity.ok(pools);
    }

    @GetMapping("pools/{id}")
    public ResponseEntity<Optional<Pool>> getPoolById(@PathVariable Integer id){
        Optional<Pool> pool = poolService.findById(id);

        return ResponseEntity.ok(pool);
    }
}

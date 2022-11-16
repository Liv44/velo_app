package com.formation.velo.api;

import com.formation.velo.api.pool.Record;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenData {

    private com.formation.velo.api.velo.Record[] records;
    private Record[] recordsPool;
}

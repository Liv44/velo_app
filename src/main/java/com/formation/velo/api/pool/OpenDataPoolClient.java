package com.formation.velo.api.pool;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OpenDataPoolClient {

    @GET("/api/records/1.0/search/?dataset=244400404_piscines-nantes-metropole&q=&facet=commune&facet=acces_pmr_equipt&facet=bassin_sportif&facet=pataugeoire&facet=toboggan&facet=bassin_apprentissage&facet=plongeoir&facet=bassin_loisir&facet=accessibilite_handicap&facet=libre_service")
    Call<OpenDataPool> getRecordsPool();
}

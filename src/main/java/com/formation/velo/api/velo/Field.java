package com.formation.velo.api.velo;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {
    @SerializedName("available_bike_stands")
    private int availableBikeStands;
    @SerializedName("bike_stands")
    private int bikeStands;
    private int number;
    private String address;
    private double[] position;
    private String status;
    private String name;
    @SerializedName("available_bikes")
    private int availableBikes;
}

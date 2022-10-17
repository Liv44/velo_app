package com.formation.velo.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "station")
public class Station implements Serializable {

    private static final long serialVersionUID = -767070904974486420L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "name is mandatory")
    private String name;
    private Double latitude;
    private Double longitude;
    private String status;
    private Integer bikeStands;
    private Integer availableBikes;
    private Integer availableBikeStands;
    private String recordId;
    private String address;

    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Station station = (Station) o;
    //     return Objects.equals(id, station.id) && Objects.equals(name, station.name) && Objects.equals(latitude, station.latitude) && Objects.equals(longitude, station.longitude) && Objects.equals(status, station.status) && Objects.equals(bike_stands, station.bike_stands) && Objects.equals(available_bikes, station.available_bikes) && Objects.equals(available_bike_stands, station.available_bike_stands) && Objects.equals(recordid, station.recordid) && Objects.equals(address, station.address);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(id, name, latitude, longitude, status, bike_stands, available_bikes, available_bike_stands, recordid, address);
    // }
}

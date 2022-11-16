package com.formation.velo.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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

}

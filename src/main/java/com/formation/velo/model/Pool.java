package com.formation.velo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "pool")
public class Pool implements Serializable {

    private static final long serialVersionUID = -767070904974486420L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String recordId;

    private String idobj;
    private String nomComplet;
    private String nomUsuel;
    private String web;

    private String adresse;
    private String tel;
    private Double latitude;
    private Double longitude;
    private String commune;
    private String cp;

    private String bassinLoisir;
    private String bassinSportif;
    private String bassinApprentissage;

    private String pataugeoire;
    private String toboggan;
    private String plongeoir;

    private String infosComplementaires;
    private String libreService;
    private String accesTransportsCommun;
    private String accessibiliteHandicap;
    private String accesPmrEquipt;
}

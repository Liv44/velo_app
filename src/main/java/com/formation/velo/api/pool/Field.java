package com.formation.velo.api.pool;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {
    private String idobj;
    @SerializedName("nom_complet")
    private String nomComplet;
    @SerializedName("nom_usuel")
    private String nomUsuel;
    private String web;

    private String adresse;
    private String tel;
    private double[] location;
    private String commune;
    private String cp;

    @SerializedName("bassin_loisir")
    private String bassinLoisir;
    @SerializedName("bassin_sportif")
    private String bassinSportif;
    @SerializedName("bassin_apprentissage")
    private String bassinApprentissage;

    private String pataugeoire;
    private String toboggan;
    private String plongeoir;

    @SerializedName("infos_complementaires")
    private String infosComplementaires;
    @SerializedName("libre_service")
    private String libreService;
    @SerializedName("acces_transports_commun")
    private String accesTransportsCommun;
    @SerializedName("accessibilite_handicap")
    private String accessibiliteHandicap;
    @SerializedName("acces_pmr_equipt")
    private String accesPmrEquipt;
}
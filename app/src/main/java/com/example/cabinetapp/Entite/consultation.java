package com.example.cabinetapp.Entite;

public class consultation {
    int id,idPatient;
    String dateCons, heureCons, diagnostic, ordonnance,nature;

    public consultation(int id, int idPatient, String dateCons, String heureCons, String diagnostic, String ordonnance, String nature) {
        this.id = id;
        this.idPatient = idPatient;
        this.dateCons = dateCons;
        this.heureCons = heureCons;
        this.diagnostic = diagnostic;
        this.ordonnance = ordonnance;
        this.nature = nature;
    }
}

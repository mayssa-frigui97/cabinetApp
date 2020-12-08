package com.example.cabinetapp.Entite;

public class RendezVous {
    int id;
    String dateCons;
    Patient patient;
    String diagnostic;
    String ordonnance;
    String nature ;
    String heureCons;

    public RendezVous(int id, String dateCons, Patient patient, String diagnostic, String ordonnance, String nature, String heureCons) {
        this.id = id;
        this.dateCons = dateCons;
        this.patient = patient;
        this.diagnostic = diagnostic;
        this.ordonnance = ordonnance;
        this.nature = nature;
        this.heureCons = heureCons;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateCons() {
        return dateCons;
    }

    public void setDateCons(String dateCons) {
        this.dateCons = dateCons;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(String ordonnance) {
        this.ordonnance = ordonnance;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getHeureCons() {
        return heureCons;
    }

    public void setHeureCons(String heureCons) {
        this.heureCons = heureCons;
    }
}

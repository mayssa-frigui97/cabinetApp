package com.example.cabinetapp.Entite;

import java.util.Date;
public class Patient {
    int id;
    String nom, prenom ,tel,cnam ,dateNaiss, username;

    public Patient(int id) {
        this.id = id;
    }

    public Patient(int id, String nom, String prenom, String tel, String cnam, String dateNaiss, String username) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.cnam = cnam;
        this.dateNaiss = dateNaiss;
        this.username = username;
    }

    public Patient(int id, String nom, String prenom, String tel, String cnam, String dateNaiss) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.cnam = cnam;
        this.dateNaiss = dateNaiss;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Patient(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCnam() {
        return cnam;
    }

    public void setCnam(String cnam) {
        this.cnam = cnam;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }
}

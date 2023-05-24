package com.example.mysonysondage;

import java.util.HashMap;

public class Candidat {
    private String email, nom, service, SuggEco, SuggSoc, mdp;
    private HashMap<String, Integer> lesReponses;
    private int rbSecu, rbBien;


    public Candidat(String email, String nom, String service, String mdp) {
        this.email = email;
        this.nom = nom;
        this.service = service;
        this.lesReponses = new HashMap();
        this.mdp = mdp;
        this.SuggEco = "";
        this.SuggSoc = "";
        this.rbBien = 0;
        this.rbSecu = 0;
    }

    public void ajouterReponse(String question, int score) {
        this.lesReponses.put(question, score);

    }
    public void supprimerReponse (String email)
    {

        this.lesReponses.remove(email);
    }

    public float moyenne() {
        float m = 0;
        for (Integer score : this.lesReponses.values()) {
            m = m + score;
        }
        m = m / this.lesReponses.size();
        return m;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSuggEco() {
        return SuggEco;
    }

    public void setSuggEco(String suggEco) {
        this.SuggEco = suggEco;
    }

    public String getSuggSoc() {
        return SuggSoc;
    }

    public void setSuggSoc(String suggSoc) {
        this.SuggSoc = suggSoc;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }

    public int getRbSecu() {
        return rbSecu;
    }

    public void setRbSecu(int rbSecu) {
        this.rbSecu = rbSecu;
    }

    public int getRbBien() {
        return rbBien;
    }

    public void setRbBien(int rbBien) {
        this.rbBien = rbBien;
    }
}

package com.example.lab2;

public class Production {
    private String nom;
    private int anneeSortie;
    private String lieuProduction;
    private double reputation;
    private String genre;
    private String commentaireDescriptif;

    // Constructor
    public Production(String nom, int anneeSortie, String lieuProduction, double reputation, String genre, String commentaireDescriptif) {
        this.nom = nom;
        this.anneeSortie = anneeSortie;
        this.lieuProduction = lieuProduction;
        this.reputation = reputation;
        this.genre = genre;
        this.commentaireDescriptif = commentaireDescriptif;
    }

    // Getter methods

    public String getNom() {
        return nom;
    }

    public int getAnneeSortie() {
        return anneeSortie;
    }

    public String getLieuProduction() {
        return lieuProduction;
    }

    public double getReputation() {
        return reputation;
    }

    public String getGenre() {
        return genre;
    }

    public String getCommentaireDescriptif() {
        return commentaireDescriptif;
    }

    // Setter methods

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAnneeSortie(int anneeSortie) {
        this.anneeSortie = anneeSortie;
    }

    public void setLieuProduction(String lieuProduction) {
        this.lieuProduction = lieuProduction;
    }

    public void setReputation(double reputation) {
        this.reputation = reputation;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setCommentaireDescriptif(String commentaireDescriptif) {
        this.commentaireDescriptif = commentaireDescriptif;
    }
}

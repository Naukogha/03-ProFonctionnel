package org.example;

import java.time.LocalDate;

public class Livre {
    private String titre;             // Titre du livre
    private String auteur;            // Auteur du livre
    private String genre;             // Genre littéraire
    private LocalDate datePublication; // Date de publication
    private int nombrePages;          // Nombre de pages
    private boolean disponible;       // Disponibilité (true si disponible)
    private double prix;              // Prix du livre

    // Constructeur
    public Livre(String titre, String auteur, String genre, LocalDate datePublication,
                 int nombrePages, boolean disponible, double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.datePublication = datePublication;
        this.nombrePages = nombrePages;
        this.disponible = disponible;
        this.prix = prix;
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    public void setNombrePages(int nombrePages) {
        this.nombrePages = nombrePages;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", genre='" + genre + '\'' +
                ", datePublication=" + datePublication +
                ", nombrePages=" + nombrePages +
                ", disponible=" + disponible +
                ", prix=" + prix +
                '}';
    }
}

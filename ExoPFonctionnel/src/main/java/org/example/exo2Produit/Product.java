package org.example.exo2Produit;

public class Product {
    private String nom;
    private double prix;
    private double quantite;

    public Product(String nom, double prix, double quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double price) {
        this.prix = price;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Product{" + "nom=" + nom + ", prix=" + prix + '}';
    }
}

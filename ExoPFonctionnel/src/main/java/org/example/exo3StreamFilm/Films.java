package org.example.exo3StreamFilm;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Films {
    String titre;
    LocalDate dateDeSortie;
    String realisateur;
    String genre;
    int nombreEntrees;

    public Films(String titre, LocalDate dateDeSortie, String realisateur, String genre, int nombreEntrees) {
        this.titre = titre;
        this.dateDeSortie = dateDeSortie;
        this.realisateur = realisateur;
        this.genre = genre;
        this.nombreEntrees = nombreEntrees;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(LocalDate dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNombreEntrees() {
        return nombreEntrees;
    }

    public void setNombreEntrees(int nombreEntrees) {
        this.nombreEntrees = nombreEntrees;
    }

    public static Films parse(String string) {
        String[] split = string.split(",");
        String titre = split[0];
        String dateString = split[1];
        String realisateur = split[2];
        String genre = split[3];
        String entree = split[4];
        try {
            LocalDate dateDeSortie = LocalDate.parse(dateString);
            int nombreEntrees = Integer.parseInt(entree);
            return new Films(titre, dateDeSortie, realisateur, genre, nombreEntrees);
        } catch (NumberFormatException | DateTimeParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Titre : " + titre +
                ", Date de sortie : " + dateDeSortie +
                ", Réalisateur : " + realisateur +
                ", Genre : " + genre +
                ", Nombre d'entrées : " + nombreEntrees;
    }




}

package org.example.exo3StreamFilm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

public class Main {
    public static void main(String[] args) throws IOException {

//        List <Films> filmsList = new ArrayList<>();
//        FileReader in = new FileReader("films_with_genres 1.csv");
//        BufferedReader br = new BufferedReader(in);

//        1. Lecture et affichage basique avec Streams
//        - Utilisez un Stream pour lire le fichier CSV et afficher les 10 premiers films.
//        - Affichez tous les titres des films en utilisant un Stream.



            FileReader in = new FileReader("films_with_genres 1.csv");
            BufferedReader br = new BufferedReader(in);
            List<Films> filmsList = new ArrayList<>();
            try {
                br.readLine();
                while (br.ready()) {
                    String line = br.readLine();
                    Films film = Films.parse(line);
                    if (film != null) {
                        filmsList.add(film);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println(filmsList);
        List<Films> dixPremier = filmsList.stream()
                .limit(10)
                .toList();
//        dixPremier.forEach(System.out::println);



        System.out.println("_______________");
        System.out.println("TITRE DE FILMS : ");
        List<String> titreFilm = filmsList.stream()
                .map(Films::getTitre)
                .toList();

//        titreFilm.forEach(System.out::println);


//        Trouvez tous les films d'un genre donné (par exemple : "Action") et affichez leur titre et leur année de sortie.
        System.out.println("_______________");
        System.out.println("FILTRE PAR GENRE : ");


        Map<String, LocalDate> genreFilm  = filmsList.stream()
                .filter(f -> Objects.equals(f.getGenre(), "Action"))
                .collect(Collectors.toMap(Films::getTitre, Films::getDateDeSortie));
//        genreFilm.forEach((titre, date) ->
//                System.out.println("Titre: " + titre + ", Date de sortie: " + date));


//    Filtrez les films réalisés après l'année 2000 et affichez uniquement leurs titres.
        System.out.println("_______________");
        System.out.println("Annee 2000 : ");
        List<String> annee2000 = filmsList.stream()
                .filter(f->f.dateDeSortie.getYear() > 2000)
                .map(Films::getTitre)
                .toList();

        annee2000.forEach(System.out::println);


//        Affichez les films réalisés par un réalisateur spécifique (par exemple : "Michael Webster").
        System.out.println("_______________");
        System.out.println("Realisateur : ");
        List<Films> reaslisateur = filmsList.stream()
                .filter(f->f.realisateur.equals("Michael Webster"))
                .toList();

        reaslisateur.forEach(System.out::println);

//       PARTIE 3 ---------------------------------------------------

        // Triez les films par nombre d'entrées (ordre croissant) et affichez les 5 premiers
        System.out.println("_______________");
        System.out.println("Nombre d'entré  : ");
        List<Films> nbrEntree = filmsList.stream()
                .sorted(Comparator.comparing(Films::getNombreEntrees))
                .toList();

        nbrEntree.forEach(System.out::println);

        // Triez les films par date de sortie (ordre croissant) et affichez leurs titres.
        System.out.println("_______________");
        System.out.println("Date de sortie ordre croissant  : ");
        List<String> dateSortiCrois = filmsList.stream()
                .sorted(Comparator.comparing(Films::getDateDeSortie))
                .map(Films::getTitre)
                .toList();

        dateSortiCrois.forEach(System.out::println);


// Affichez les 10 films avec le plus petit nombre d'entrées, triés par nombre d'entrées.
        System.out.println("_______________");
        System.out.println("10 films avec le plus petit nombre d'entrées  : ");
        List<Films> dixPlusPetiteEntree = filmsList.stream()
                .sorted(Comparator.comparing(Films::getNombreEntrees))
                .limit(5)
                .toList();

        dixPlusPetiteEntree.forEach(System.out::println);

//       PARTIE 4 ---------------------------------------------------

// Regroupez les films par genre et affichez le nombre de films dans chaque genre..
        System.out.println("_______________");
        System.out.println("Groupe genres  : ");
        Map<String, Long> groupeGenre = filmsList.stream()
                .collect(groupingBy(Films::getGenre, Collectors.counting()));

        groupeGenre.forEach((genre, count) -> System.out.println(genre + ": " + count));


// Regroupez les films par réalisateur et affichez les titres des films de chaque réalisateur.
        System.out.println("_______________");
        System.out.println("Regroupez les films par réalisateur  : ");
        Map<String, List<Films>> filmParRealisateur = filmsList.stream()
                .collect(groupingBy(Films::getRealisateur));

        filmParRealisateur.forEach((realisateur, films) -> {
            System.out.println(realisateur + ":");
            films.forEach(film -> System.out.println("  - " + film.getTitre() + " (" + film.getDateDeSortie().getYear() + ")"));
        });

//       PARTIE 5 ---------------------------------------------------

        // Calculez le total des entrées au cinéma pour tous les films.
        System.out.println("_______________");
        System.out.println("Total entrée film: ");
        long totalEntreeFilm = filmsList.stream()
                .mapToLong(Films::getNombreEntrees)
                .sum();

        System.out.println("Le nombre d'entrée total : "+totalEntreeFilm);

// Trouvez le genre avec le plus grand nombre total d'entrées en utilisant un Stream.
//        System.out.println("_______________");
//        System.out.println("Groupe genres  : ");
//        Map<String, Long> grandPlusEntre = filmsList.stream()
//                .collect(Collectors.groupingBy(Films::getGenre, Collectors.summingLong(Films::getNombreEntrees)))
//                .sorted(Comparator;
//
//        List<Films> plusgrandGenre = grandPlusEntre.stream()
//                .sorted(Comparator.comparing(Films::getNombreEntrees))
//                .limit(1)
//                .toList();
//
//        grandPlusEntre.forEach((genre, totalEntrees) -> System.out.println(genre + ": " + totalEntrees));

        // Calculez la moyenne des entrées pour les films d'un réalisateur donné.
        System.out.println("_______________");
        System.out.println("moyenne des entrées pour les films d'un réalisateur donné. : ");
        Map<String, Double> moyenneEntreeRealisateur = filmsList.stream()
                .collect(groupingBy(
                        Films::getRealisateur,
                        Collectors.averagingLong(Films::getNombreEntrees)
                ));

        moyenneEntreeRealisateur.forEach((realisateur, count) -> System.out.println(realisateur + ": " + count));



        //ERREUR DANS LE CALCUL !!!



    }
}

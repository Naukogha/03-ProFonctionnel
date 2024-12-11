package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String csvFile = "src/main/java/org/example/books_dataset.csv";
        List<Livre> livres;

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
            livres =  br.lines()
                    .skip(1)
                    .map(line -> line.split(","))
                    .map(value -> new Livre(
                            value[0],
                            value[1],
                            value[2],
                            LocalDate.parse(value[3]),
                            Integer.parseInt(value[4]),
                            Boolean.parseBoolean(value[5]),
                            Double.parseDouble(value[6])))
                    .toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        1. **Filtrer les livres disponibles** (dont `estDisponible` est `true`).
        livres.stream()
                .filter(l -> l.isDisponible())
                .forEach(System.out::println);

        System.out.println();
        System.out.println("---------------");
        System.out.println("2");
//        2. **Trouver les livres publiés avant 1900** et afficher leur titre et auteur.
        livres.stream()
                .filter(l -> l.getDatePublication().isBefore(LocalDate.of(1920,1,1)))
                .forEach(f -> System.out.println("Titre : " + f.getTitre() +" , Auteur : "+ f.getAuteur()));


        System.out.println();
        System.out.println("---------------");
        System.out.println("3");
//        3. **Grouper les livres par genre** (par exemple, tous les "Romans" ensemble, tous les "Science-fiction" ensemble, etc.).
        livres.stream()
                .collect(Collectors.groupingBy(Livre::getGenre))
                .forEach((key, value) -> {
                            System.out.println(key + " : ");
                            value.forEach(System.out::println);
                        });

        System.out.println();
        System.out.println("---------------");
        System.out.println("4");
//        4. **Trouver le livre le plus ancien** dans la bibliothèque (le livre avec la date de publication la plus ancienne).
        livres.stream()
                .sorted(Comparator.comparing(Livre::getDatePublication))
                .limit(1)
                .forEach(System.out::println);


        System.out.println();
        System.out.println("---------------");
        System.out.println("5");
//        5. **Vérifier s'il existe des livres dont le titre commence par "Harry"**.
        livres.stream()
                .filter(l -> l.getTitre().startsWith("Field"))
                .forEach(System.out::println);


        System.out.println();
        System.out.println("---------------");
        System.out.println("6");
//        6. **Calculer le prix moyen des livres** disponibles dans la bibliothèque.
        OptionalDouble average = livres.stream()
                .filter(l -> l.isDisponible())
                .mapToDouble(Livre::getPrix)
                .average();
        System.out.println(average);


        System.out.println();
        System.out.println("---------------");
        System.out.println("7");
//        7. **Trier les livres par nombre de pages**, puis par prix (en cas d'égalité du nombre de pages).
        livres.stream()
                .sorted(Comparator.comparing(Livre::getPrix))
                .sorted(Comparator.comparing(Livre::getNombrePages))
                .forEach(System.out::println);


        System.out.println();
        System.out.println("---------------");
        System.out.println("8");
//        8. **Calculer le total des pages** pour tous les livres de genre "Fantasy".
        Long pages = livres.stream()
                .filter(l -> l.getGenre().equals("Fantasy"))
                .mapToLong(Livre::getNombrePages)
                .sum();
        System.out.println(pages);


        System.out.println();
        System.out.println("---------------");
        System.out.println("9");
//        9. **Trouver le livre le plus cher** disponible à la vente.
        livres.stream()
                .filter(l -> l.isDisponible())
                .sorted(Comparator.comparing(Livre::getPrix).reversed())
                .limit(1)
                .forEach(System.out::println);


        System.out.println();
        System.out.println("---------------");
        System.out.println("10");
//        10. **Trouver les auteurs les plus prolifiques** (les auteurs ayant écrit plus de 17 livre) et afficher leurs livres.
        livres.stream()
                .collect(Collectors.groupingBy(Livre::getAuteur, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 17)
                .forEach(System.out::println);


        System.out.println();
        System.out.println("---------------");
        System.out.println("11");
//        11. **Compter le nombre de livres dans chaque genre** (afficher par exemple combien de "Romans", combien de "Science-fiction", etc.).
        livres.stream()
                .collect(Collectors.groupingBy(Livre::getGenre, Collectors.counting()))
                .forEach((key,value)-> System.out.println(key + " : " + value));


        System.out.println();
        System.out.println("---------------");
        System.out.println("12");
//        12. **Vérifier si un livre est disponible et si son prix est inférieur à un seuil donné**, et afficher les livres correspondants.
        livres.stream()
                .filter(l -> l.isDisponible())
                .filter(l -> l.getPrix()<10)
                .sorted(Comparator.comparing(Livre::getPrix))
                .forEach(System.out::println);


        System.out.println();
        System.out.println("---------------");
        System.out.println("13");
//        13. **Calculer le nombre total de pages** pour les livre de chaque année.
        livres.stream()
                .collect(Collectors.groupingBy(l -> l.getDatePublication().getYear(), Collectors.summingLong(Livre::getNombrePages)))
                .forEach((key,value)-> System.out.println(key + " : " + value));

    }
}
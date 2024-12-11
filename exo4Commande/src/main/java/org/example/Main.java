package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Liste de commandes
        List<Commande> commandes = Arrays.asList(
                new Commande(1, "Alice", Arrays.asList("Ordinateur", "Souris"), 1200.50, true),
                new Commande(2, "Bob", Arrays.asList("Clavier", "Écran"), 300.75, false),
                new Commande(3, "Charlie", Arrays.asList("Imprimante"), 150.00, true),
                new Commande(4, "Alice", Arrays.asList("USB", "Casque"), 75.50, false),
                new Commande(5, "Bob", Arrays.asList("Tablette", "Ordinateur"), 200.00, true)
        );

//  --- 1. Afficher toutes les commandes.-------------------------------
        commandes.stream()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("---------------");
        System.out.println("2");
//  --- 2. Récupérer et afficher le nom des clients de chaque commande.-----------
        commandes.stream()
                .map(Commande::getClient)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("---------------");
        System.out.println("3");
//  --- 3. Calculer et afficher le montant total de toutes les commandes.---------
        Double chiffreAffaire = commandes.stream()
                .mapToDouble(Commande::getMontantTotal)
                .sum();
        System.out.println(chiffreAffaire);

        System.out.println();
        System.out.println("---------------");
        System.out.println("4");
//  --- 4. Afficher les articles et le prix total pour chaque commande..-----------
        commandes.forEach(c -> System.out.println("Articles : " + c.getArticles()+ " , Montants : "+c.getMontantTotal()));


        System.out.println();
        System.out.println("---------------");
        System.out.println("5");
//  --- 5. Lister les commandes livrées : Utiliser Stream.filter pour filtrer les commandes livrées.-----------
        commandes.stream()
                .filter(c-> c.isEstLivree())
                .forEach(System.out::println);

        System.out.println();
        System.out.println("---------------");
        System.out.println("6");
//  --- 6. Calculer le montant total par client : Grouper les commandes par client avec Collectors.groupingBy et calculer la somme des montants
        commandes.stream()
                .collect(Collectors.groupingBy(Commande::getClient, Collectors.summingDouble(Commande::getMontantTotal)))
                .forEach((key, value) -> System.out.println(key + " : " + value));


        System.out.println();
        System.out.println("---------------");
        System.out.println("7");
//  --- 7. Obtenir les articles uniques commandés.-----------
        List<String> articlesUniques = commandes.stream()
                .map(Commande::getArticles) // Extrait les listes d'articles
                .flatMap(List::stream)      // Aplatie les listes en un flux d'articles
                .distinct()
                .collect(Collectors.toList()); // Collecte les articles uniques dans un Set
        System.out.println(articlesUniques);



        System.out.println();
        System.out.println("---------------");
        System.out.println("8");
//  --- 8. Vérifier si tous les clients ont une commande livrée : Grouper par client et utiliser Stream.allMatch pour vérifier la condition.-----------
        boolean test = commandes.stream()
                .collect(Collectors.groupingBy(Commande::getClient))
                .values().stream()
                .allMatch(value -> value.stream().anyMatch(Commande::isEstLivree));

        System.out.println(test);





    }
}
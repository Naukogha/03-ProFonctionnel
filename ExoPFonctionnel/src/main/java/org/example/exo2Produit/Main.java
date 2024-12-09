package org.example.exo2Produit;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Product> products = new ArrayList<>();

        Product chocolat = new Product("chocolat", 5, 20);
        Product pomme = new Product("pomme", 2, 50);
        Product tapisCourse = new Product("tapis course", 1000, 2);



// FILTRE
        IFiltre named = (product, param) -> product.getNom().contains((String) param);
        System.out.println("Si chocolat s'appel chocolat : "+named.filtre(chocolat, "chocolat"));
        System.out.println("Si pomme s'appel chocolat : " + named.filtre(pomme, "chocolat"));


        IFiltre quantite = (product, param) -> product.getQuantite() >(double) param ;
        System.out.println("Si Pomme quantité supérieur à 25 : "+quantite.filtre(pomme, 25.0));
        System.out.println("Si Tapis de course quantité supérieur à 25 : "+quantite.filtre(tapisCourse, 25.0));

        // TRANFORM
        Transform AugPrice = (product, price) -> product.setPrix(product.getPrix() + (double) price);
        Transform DimPrice = (product, price) -> product.setPrix(product.getPrix() - (double) price);

        System.out.println("Prix avant augmentation : " + chocolat.getPrix());
        AugPrice.transform(chocolat, 3.0);
        System.out.println("Prix après augmentation : " + chocolat.getPrix());

        System.out.println("Prix avant diminution : " + pomme.getPrix());
        DimPrice.transform(pomme, 1.5);
        System.out.println("Prix après diminution : " + pomme.getPrix());
    }
}

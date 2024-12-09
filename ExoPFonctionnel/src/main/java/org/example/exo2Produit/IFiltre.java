package org.example.exo2Produit;

@FunctionalInterface
public interface IFiltre {
    boolean filtre(Product product, Object param);
}

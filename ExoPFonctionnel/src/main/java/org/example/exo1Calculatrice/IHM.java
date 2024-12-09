package org.example.exo1Calculatrice;

import java.util.Scanner;

public class IHM {
    Calculatrice calculatrice = new Calculatrice();
    Scanner scanner;

    public IHM(){
        this.scanner= new Scanner(System.in);
    }

    public  void start(){
        System.out.println("Bienvenue dans la calculatrice !");
        while (true) {
            System.out.print("Entrez le premier nombre : ");
            double num1 = scanner.nextDouble();
            System.out.print("Entrez le deuxième nombre : ");
            double num2 = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Choisissez une opération : +, -, *, /");
            String operation = scanner.nextLine();

            Calculator calculator = calculatrice.getOperation(operation);
            double result = calculator.calculate(num1, num2);

            // Afficher le résultat
            System.out.println("Résultat : " + result);

            System.out.println();
            System.out.print("Voulez-vous continuer ? (oui/non)");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("oui")) {
                break;
            }
        }
    }
}

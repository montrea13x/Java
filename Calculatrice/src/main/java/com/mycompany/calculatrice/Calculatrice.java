/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculatrice;

import java.util.Scanner;

/**
 *
 * @author montr
 */
public class Calculatrice {
    public static void main(String[] args) {
       //Crée un objet Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans mon programme de calcul");

        //Valide l'entrée de l'utilisateur et fait l'opération
        double Nb1 = getValidInput(scanner, "Entrez le premier nombre : ");
        double Nb2 = getValidInput(scanner, "Entrez le deuxième nombre : ");
        double resultat = performOperation(scanner, Nb1, Nb2);
        
        System.out.println("Le resultat est : " + resultat);
    }

    // Méthode pour obtenir une entrée valide
    private static double getValidInput(Scanner scanner, String message) {
        double number = 0;
        
        //Vérifie si l'entrée est un nombre valide et empêche l'arrêt du programme en cas d'erreur
        while (true) {
            System.out.print(message);
            try {
                String input = scanner.next();
                input = input.replace(',', '.'); // Remplace la virgule par un point
                number = Double.parseDouble(input); // Convertit la chaîne en double
                break; //Sort de la boucle si l'entrée est valide
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide, veuillez entrer un nombre valide.");
            }
        }
        return number;
    }
    
    private static double performOperation(Scanner scanner, double Nb1, double Nb2) {
        while(true){
            System.out.println("Entrez le numero du calcul à effectuer");
            System.out.println("1 - addition");
            System.out.println("2 - soustraction");
            System.out.println("3 - multiplication");
            System.out.println("4 - division");
            
            int operationNumber = 0;
            
            while(true){
                try {
                    operationNumber = scanner.nextInt();
                    break;
                }
                catch(java.util.InputMismatchException e){
                    System.out.println("Entrée invalide, veuillez entrer un nombre valide.");
                    scanner.next();
                }
            }
            switch(operationNumber) {
                case 1 -> {
                    return Nb1 + Nb2; // Addition
                }
                case 2 -> {
                    return Nb1 - Nb2; // Soustraction
                }
                case 3 -> {
                    return Nb1 * Nb2; // Multiplication
                }
                case 4 -> {
                    if (Nb2 != 0) {
                        return Nb1 / Nb2; // Division
                    } else {
                        System.out.println("Erreur : Division par zéro !");
                        return Double.NaN; // Indique une opération invalide
                    }
                }
                default -> System.out.println("Opération invalide !");
            }
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculatricev2;

import java.util.Scanner;

/**
 *
 * @author montr
 */
public class CalculatriceV2 {

    public static void main(String[] args) {
        //Crée un objet Scanner pour lire l'entrée de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans mon programme de calcul");
        System.out.println("Entrez le calcul a effectuer : ");
        
        String calcul = scanner.nextLine();
        String[] parts = calcul.split("(?=[+*/-])");
        double result = 0;
        try {
            for (String part : parts) {
                part = part.trim();
                part = part.replace(',', '.');
                if(part.startsWith("*")){
                  result *= Double.parseDouble(part.substring(1).trim());
                }
                else if(part.startsWith("/")){
                  result /= Double.parseDouble(part.substring(1).trim());
                }
                else if(part.startsWith("+")){
                  result += Double.parseDouble(part.substring(1).trim());
                }
                else if(part.startsWith("-")){
                  result -= Double.parseDouble(part.substring(1).trim());
                }
                else{
                  result += Double.parseDouble(part.trim());
                }
            }

            // Afficher le résultat
            System.out.println("Le résultat de " + calcul + " est : " + result);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer des nombres valides.");
        }

        scanner.close();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nombrealeatoire;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author montr
 */
public class NombreAleatoire {
    public static void main(String[] args) {
        play(); 
    }
    public static void play(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int nbToFind = random.nextInt(10000);
        int tempNb = -1;
        int tryNb = 1;
        System.out.println("Trouvez le chiffre entre 0 et 9999");
        while(tempNb != nbToFind){
            System.out.println("Entrez le chiffre n." + tryNb);
            try{
                tempNb = scanner.nextInt();
                if(tempNb > 9999 || tempNb < 0){
                    System.out.println("Entrez un nombre qui se situe entre 0 et 9999 inclus");
                }
                else if(tempNb > nbToFind){
                    System.out.println("Le chiffre est plus petit");
                    tryNb += 1;
                }
                else if(tempNb < nbToFind){
                    System.out.println("Le chiffre est plus grand");
                    tryNb += 1;
                }
                else{
                    String messageFin = (tryNb > 1) ? "coups" : "coup";
                    System.out.println("Vous avez trouvé le bon chiffre en " + tryNb + " " + messageFin);
                }
            }
            catch(java.util.InputMismatchException e){
                System.out.println("Entrée invalide, veuillez entrer un nombre valide.");
                scanner.next();
            }
        }
        System.out.println("Voulez-vous rejouer? (oui/non)");
        String response = scanner.next();
        
        if (response.equalsIgnoreCase("oui")) {
            play(); // Appel récursif pour recommencer le jeu
        } else {
            System.out.println("Merci d'avoir joué !");
        }
    }
}

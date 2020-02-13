/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bandas;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        String Nom;
        System.out.print("Ingresa un nuevo ranking: ");
        Scanner Scn = new Scanner(System.in);
        Nom = Scn.nextLine();
        Banda nuevo = new Banda(Nom);
    }
}

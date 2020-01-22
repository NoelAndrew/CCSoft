/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icoffe;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        String Nom;
        System.out.print("Ingresa un nuevo cafe: ");
        Scanner Scn = new Scanner(System.in);
        Nom = Scn.nextLine();
        Bebida nuevo = new Bebida(Nom);
    }
}

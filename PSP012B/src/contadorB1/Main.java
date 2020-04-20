package contadorB1;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {    
	        System.out.println("Ingresa la direccion del archivo ");
	        String File;
	        //La direcion del archivo 2
	        Scanner sn = new Scanner(System.in);
	        File = sn.nextLine();
	        System.out.println("Ingresa la direccion del archivo a comparar ");
	        String File2;
	        File2 = sn.nextLine();
	        CountLOC LOC  = new CountLOC();
	        LOC.setFileName(File);
	        LOC.setFileName(File2);
	        LOC.contarlineas();
	    }
}
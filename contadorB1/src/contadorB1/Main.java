package contadorB1;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {    
	        System.out.println("Ingresa la direccion del archivo ");
	        String File;
	        Scanner sn = new Scanner(System.in);
	        File = sn.nextLine();
	        CountLOC LOC  = new CountLOC();
	        LOC.setFileName(File);
	        LOC.contarlineas();
	        System.out.print("Numero de lineas lógicas " + LOC.GetLOC());
	    }
}

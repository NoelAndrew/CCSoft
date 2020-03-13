package fileA2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class fileWR {
	
	public static void Reader() throws IOException {
		FileInputStream fstream = new FileInputStream("C:\\Users\\Noel\\eclipse-workspace\\programA2\\src\\numeros.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String Line;

			while ((Line = br.readLine()) != null)   {
		  System.out.println (Line);
		}

		//Close the input stream
		fstream.close();
	}
	public static void Writer() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Noel\\eclipse-workspace\\programA2\\src\\numeros.txt"));
        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cuantos numeros desea?");
        int numero = input.nextInt();
        int cont =0;
        String text = "" ;
        	while(cont<numero){
            System.out.println("Ingresa un numero entero");
            text = scanner.next();
            pw.write(text);
            cont++;
            //add more fields
            //finally
            pw.println();
        
         
        }
        pw.close();
        System.out.println("Escrito");
        
	}
	public static void main(String [] args) throws IOException{
		fileWR A2;
		Scanner sn = new Scanner(System.in);
		System.out.println("Que desea hacer?");
		int opc = 0;
		System.out.println("1 - Leer");
        System.out.println("2 - Escribir");
		do {
	        switch (opc= sn.nextInt()) {
	        case 1:
	        	fileWR.Reader();
	          break;
	        case 2:
	        	fileWR.Writer();
	        	break;
	        default:
                System.out.println("No existe esa opcion");
	      }
		}while (opc!=0);
	}

}

package A3;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    static String File;   
    static Scanner File2 = new Scanner(System.in);    
    static int Sig;    
    static Scanner Sig2 = new Scanner(System.in);    
    static String Fichero;
    static Scanner Fichero2 = new Scanner(System.in); 
    
    public static void GetItem()
    {
        System.out.println("Introduce el nombre del archivo: ");
        File = File2.nextLine();
        
        System.out.println("¿Cual será el límite de datos?");
        Sig = Sig2.nextInt();
        
        FileWR.Writer(File, Sig);
    }
    
    public static String Buscar() throws IOException
    {
        System.out.println("Ingresa el nombre del archivo");
        Fichero = Fichero2.nextLine();
        FileWR.Reader(Fichero);
        return Fichero;
                           
    }
    public static void main(String[] args) throws IOException {

        Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int opc; 
 
        while (!exit) {
            System.out.println("¿Que desea hacer, guapo?");
            System.out.println("1. Escribir");
            System.out.println("2. Leer");
            System.out.println("3. Salir");
            try {
 
                opc = sn.nextInt();
 
                switch (opc) {
                    case 1:
                                GetItem();
                        break;
                    case 2:
                    		Buscar();
                            SD.Media();
                            SD.Varianza();
                            SD.SDev();                
                        break;
                    case 3:
                        exit = true;
                        break;
                    	default:
                        System.out.println("No existe esa opción");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe seleccionar una opcion");
                sn.next();
            }
        }
 
    }
    
    
    
}

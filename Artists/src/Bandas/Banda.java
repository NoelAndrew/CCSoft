package Bandas;

import java.util.regex.Pattern;

public class Banda {
    String NombreBanda;
    int [] Posicion = new int[9];
   
    Banda(String cadena)
    {
        cadena = cadena.replace(" ", "");
        if(!Empty(cadena) && Tam(cadena) && NombreInicio(cadena)){
             String [] Nom2;
             Nom2 = cadena.split(",");
             String [] Tam2 = new String[Nom2.length - 1];
             for(int i = 1; i < Nom2.length; i++)
             {
                 if(Num(Nom2[i]) && Ranking(Nom2[i]))
                 {
                    Tam2[i-1] = Nom2[i]; 
                 }
             }
             
             if(Tam3(Tam2))
             {
                 NombreBanda = Nom2[0];
                 System.out.println("Posicion " + Nom2[0] );
                 for(int w = 0; w < Tam2.length ; w++)
                 {
                     int n = w + 1;
                      System.out.println("La banda "+ n +" es: "+Tam2[w]+" " );
                      Posicion[w] = Integer.parseInt(Tam2[w]);
                 }
             }
        }
    } 
    
    public static Boolean Empty(String cadena)
    {    
        if(cadena.isEmpty())
            throw new RuntimeException("Ingrese el ranking");
        else
            return false;
    }
    
    
    public static Boolean Tam(String cadena)
    {
        String [] descomp;
        descomp = cadena.split(",");
        if(descomp.length > 10  && descomp.length <= 20 )
            return true;
        else
             throw new RuntimeException("Debe haber al cinco posiciones");
    }
    
    public static Boolean NombreInicio(String cadena)
    {
    	 String [] descomp;
         descomp = cadena.split(",");
         char ne2 = descomp[0].charAt(1);
         //int  nes= descomp[0].length();
         if(TamNombre(descomp[0]) && Character.isDigit(ne2))
         {
             return true;
         }
         else
         {
             throw new RuntimeException("El nombre se ingresa primero y debe de ser alfabetico");
         }
    	/*
        String [] descomp;
        descomp = cadena.split(",");
        char ne = descomp[0].charAt(0);
        char ne2 = descomp[0].charAt(1);
        int  nes= descomp[0].length();
        if( Character.isDigit(ne) && Character.isDigit(ne2) && nes<=2)
        {
            return true;
        }
        else 
        {
            throw new RuntimeException("El numero se ingresa primero y debe ser entero");
        }*/
    }
    
    public static Boolean TamNombre(String nombre)
    {
        nombre = nombre.replace(" ", "");
        if(nombre.length() >= 1 && nombre.length() <= 50)
            return true;
        else
            throw new RuntimeException("El numero de caracteres debe de ser de entre 1 y 50");
    }

  
 
    public static Boolean Num(String onza)
    {
        onza = onza.replace(" ", "");
        try {
        	
                    Integer.parseInt(onza);
                    return true;
            }
            catch(Exception e)
            {
                    return false;	
            }
    }
    
    public static Boolean Ranking(String onza)
    {
        if(Integer.parseInt(onza)>= 1 && Integer.parseInt(onza)<= 10)
            return true;
        else
             throw new RuntimeException("El ranking debe ser entre 1 y 10");
    }
    
    public static Boolean Tam3(String [] Tam2)
    {
        int aux = Integer.MIN_VALUE;
        for(int i = 0; i < Tam2.length; i++)
        {
            if(aux > Integer.parseInt(Tam2[i]))
            {
                aux =  Integer.parseInt(Tam2[i]);
            }
            else
            {
                  throw new RuntimeException("Los tamaños debe de ser ingresados de mayor a menor");
            }
        }
        return true;
    }
    
    
}

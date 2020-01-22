package icoffe;

import java.util.regex.Pattern;

public class Bebida {
    String NombreCafe;
    int [] TamañoCafe = new int[5];
   
    Bebida(String cadena)
    {
        cadena = cadena.replace(" ", "");
        if(!Empty(cadena) && Tam(cadena) && NombreInicio(cadena)){
             String [] Nom2;
             Nom2 = cadena.split(",");
             String [] Tam2 = new String[Nom2.length - 1];
             for(int i = 1; i < Nom2.length; i++)
             {
                 if(Num(Nom2[i]) && TamBebida(Nom2[i]))
                 {
                    Tam2[i-1] = Nom2[i]; 
                 }
             }
             
             if(Tam3(Tam2))
             {
                 NombreCafe = Nom2[0];
                 System.out.println("Nombre del cafe: " + Nom2[0] );
                 System.out.println("Hay " + Tam2.length + " tamaños" );
                 for(int w = 0; w < Tam2.length ; w++)
                 {
                     int n = w + 1;
                      System.out.println("El tamaño "+ n +" es: "+Tam2[w]+" " );
                      TamañoCafe[w] = Integer.parseInt(Tam2[w]);
                 }
             }
        }
    } 
    
    public static Boolean Empty(String cadena)
    {    
        if(cadena.isEmpty())
            throw new RuntimeException("Ingrese el nombre");
        else
            return false;
    }
    
    
    public static Boolean Tam(String cadena)
    {
        String [] descomp;
        descomp = cadena.split(",");
        if(descomp.length >= 2 && descomp.length <= 6 )
            return true;
        else
             throw new RuntimeException("Debe haber al menos un nombre");
    }
    
    public static Boolean NombreInicio(String cadena)
    {
        String [] descomp;
        descomp = cadena.split(",");
        if(TamNombre(descomp[0]) && Alfabetico(descomp[0]))
        {
            return true;
        }
        else
        {
            throw new RuntimeException("El nombre se ingresa primero y debe de ser alfabetico");
        }
    }
    
    public static Boolean TamNombre(String nombre)
    {
        nombre = nombre.replace(" ", "");
        if(nombre.length() >= 2 && nombre.length() <= 15)
            return true;
        else
            throw new RuntimeException("El numero de caracteres debe de ser de entre 12 y 15");
    }
    
    public static Boolean Alfabetico(String nombre)
    {
        nombre = nombre.replace(" ", "");
        return Pattern.matches("^[a-zA-Z]*$", nombre);
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
    
    public static Boolean TamBebida(String onza)
    {
        if(Integer.parseInt(onza)>= 1 && Integer.parseInt(onza)<= 48)
            return true;
        else
             throw new RuntimeException("El tamaño de la bebida debe ser entre 1 y 48");
    }
    
    public static Boolean Tam3(String [] Tam2)
    {
        int aux = Integer.MIN_VALUE;
        for(int i = 0; i < Tam2.length; i++)
        {
            if(aux < Integer.parseInt(Tam2[i]))
            {
                aux =  Integer.parseInt(Tam2[i]);
            }
            else
            {
                  throw new RuntimeException("Los tamaños debe de ser ingresados de menor a mayor");
            }
        }
        return true;
    }
    
    
}

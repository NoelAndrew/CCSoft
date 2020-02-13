/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import Bandas.Banda;


public class ArtistisTests {
    
    @Rule       
    public ExpectedException thrown = ExpectedException.none();
    //admite string
    @Test
    public void NotEmptyString() { 
        assertFalse(Banda.Empty("1,Nirvana"));
        
    }
    //Al menos cinco tama�os
    
    @Test
    public void MinTam() 
    {
        assertTrue(Banda.Tam("Nirvana,10,aaa,9,bbb,8,ccc,7,yyyy,6,,rrrrr,5"));
    
    }
    
    //Tama�o de 10
    @Test
    public void Maxank() 
    {
        assertTrue(Banda.Tam("Nirvana,10,aaa,9,bbb,8,ccc,7,yyyy,6,rrrrr,5, hhhhhh, 4, uuuuuu, 3, iiiiii, 2, ooooo,1"));
    }
    
    //0 Nombres
    @Test(expected=RuntimeException.class) 
    public void MinTamName()
    {
    	Banda.Tam("1,");
    }
    
    //+ 10 items
    @Test(expected=RuntimeException.class) 
    public void MaxTamName()
    {
    	Banda.Tam("Nirvana, 9,aaa,8,bbb,7,ccc,6,yyyy,5,rrrrr, 4, hhhhhh, 3, uuuuuu, 2, iiiiii, 1, ooooo, 0, kkkkk");
    }
    
    //2c char
    @Test
    public void MinName() 
    {
        assertTrue(Banda.TamNombre("N"));
    }
    
    //49 caracteres
    
    @Test
    public void MaxName()
    {
        assertTrue(Banda.TamNombre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));


    }
   @Test(expected=RuntimeException.class)
    public void MaxNamePlus1()
    {
        Banda.TamNombre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


    }
    
    //Nombre con numeros
    @Test
    public void CharName() 
    {
        assertTrue(Banda.TamNombre("The 1975"));
        
    }
    
    //no menos de 1 char
    @Test(expected=RuntimeException.class)
    public void MinCharName() 
    {
    	Banda.TamNombre(" ");
    }
    
    //Numeros con char
    @Test(expected=RuntimeException.class)
    public void NumAlfabetico() 
    {
        Banda.NombreInicio("1A");
  
    }
    
    //Espacios Numero con espacios
     @Test
    public void EsNumero()
    {
        assertTrue(Banda.Num("10"));
        assertTrue(Banda.Num(" 10"));
        assertTrue(Banda.Num("        20"));
        assertTrue(Banda.Num("2 0"));
    }
     //Numero entero
     @Test(expected=RuntimeException.class)
     public void NumEntero() 
     {
         Banda.NombreInicio("1.5");
   
     }
     
     

    
     @Test(expected=RuntimeException.class)
     public void MinTamNum() // El tamaño al menos debe de ser de 1
    {
       assertTrue(Banda.Ranking(""));
    }
     //Ranking 11
     @Test(expected=RuntimeException.class)
     public void Masde10() // El tamaño al menos debe de ser de 1
    {
       assertTrue(Banda.Ranking("11"));
       assertTrue(Banda.Ranking("40"));

    }
     
    //Posicion +10

     @Test(expected=RuntimeException.class)
     public void numeroNegativo() // El tamaño al menos debe de ser de 1
    {
       assertTrue(Banda.Ranking("-1"));
    }
   //Primero el nombre
     @Test(expected=RuntimeException.class)
     public void NameEmpty() 
     {
     	Banda.NombreInicio("1,Strokes,2,3");
     }
     //Numeros en orden
     public void Orden() // El tamaño al menos debe de ser de 1
     {
        assertTrue(Banda.Tam("10,9,8"));
     }
     //Numeros en desorden
     @Test(expected=RuntimeException.class)
     public void NoOrder() 
     {
    	 assertFalse(Banda.Tam("9,10,6"));
     }
     //Separacion por comas
     @Test(expected=RuntimeException.class)
     public void Coma() 
     {
         assertTrue(Banda.Tam("Nirvana.10"));
     }
     //Espacio en string
     
      public void Space() 
    {
        assertTrue(Banda.NombreInicio("                             Nirvana"));
    
    }
      @Test(expected=RuntimeException.class)
      public void SpecialChar() 
      {
          assertTrue(Banda.NombreInicio("N/ir*va+na"));
      
      }
      
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import icoffe.Bebida;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class iCoffeTest {
    
    @Rule       
    public ExpectedException thrown = ExpectedException.none();
    //admite string
    @Test
    public void NotEmptyString() { 
        assertFalse(Bebida.Empty("Latte1"));
        assertFalse(Bebida.Empty("Colombia1"));
        assertFalse(Bebida.Empty("Americano1"));
        assertFalse(Bebida.Empty("Expresso1"));

    }
    //Al menos un tamaño
    @Test
    public void MinTam() 
    {
        assertTrue(Bebida.Tam("Latte,num1"));
        assertTrue(Bebida.Tam("Expresso, num2"));
        assertTrue(Bebida.Tam("Colombia, num3"));

    }
    //Tamaño entre 1 y 5
    @Test
    public void IntegerTam() 
    {
        assertTrue(Bebida.Tam("Latte1,1,2,3,4"));
    }
    //0 tamaños
    @Test(expected=RuntimeException.class) 
    public void MinTamName()
    {
    	Bebida.Tam("Latte1");
    }
    //+48 tamaños
    @Test(expected=RuntimeException.class) 
    public void MaxTamName()
    {
    	Bebida.Tam("Cafe1,1,2,3,4,5,6");
    }
    //2c char
    @Test
    public void MinName() 
    {
        assertTrue(Bebida.TamNombre("La"));
    }
    
    //no mas de 15 caracteres
    @Test
    public void MaxName()
    {
        assertTrue(Bebida.TamNombre("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertTrue(Bebida.TamNombre("bbbbbbbbbbbbbbbbbbbb"));
        assertTrue(Bebida.TamNombre("ccccccccccccccccccccccccc"));
        assertTrue(Bebida.TamNombre("dddddddddddddddd"));


    }
    //Entre 2 y 15 char
    @Test
    public void CharName() 
    {
        assertTrue(Bebida.TamNombre("Latte"));
        assertTrue(Bebida.TamNombre("Americano"));
        assertTrue(Bebida.TamNombre("Expresso"));
        assertTrue(Bebida.TamNombre("Colombia"));
    }
    //no menos de 2 char
    @Test(expected=RuntimeException.class)
    public void MinCharName() 
    {
    	Bebida.TamNombre("a");
    	Bebida.TamNombre("b");
    	Bebida.TamNombre("c");
    	Bebida.TamNombre("d");
    }
    //Numeros con char
    @Test
    public void NumAlfabetico() 
    {
        assertFalse(Bebida.Alfabetico("latte3"));
        assertFalse(Bebida.Alfabetico("lat2te"));
        assertFalse(Bebida.Alfabetico("l1atte"));
        assertFalse(Bebida.Alfabetico("lat4te"));

    }
    //Tamaño sin letras
     @Test
    public void EsNumero()
    {
        assertTrue(Bebida.Num("20"));
        assertTrue(Bebida.Num(" 20"));
        assertTrue(Bebida.Num("        20"));
        assertTrue(Bebida.Num("2 0"));
    }
    //Tamaño con letras
   @Test(expected=NumberFormatException.class)
    public void LetterNum(){ 
        Integer.parseInt("Latte2");
        Integer.parseInt("2ttes");
        Integer.parseInt("Latt2e");
    }
    
    @Test(expected=NumberFormatException.class)
    public void Decimal(){ // El tamaÃ±o de la bebida es no valido si es decimal
        Integer.parseInt("2.5");
        Integer.parseInt("3.51");
        Integer.parseInt("4.005");

    }
    
    @Test
     public void MinTamNum() // El tamaÃ±o al menos debe de ser de 1
    {
       assertTrue(Bebida.TamBebida("1"));
    }
     
    @Test
     public void MaxTamNum() // El tamaÃ±o maximo de la bebida debe de ser 48
    {
       assertTrue(Bebida.TamBebida("48"));
    }
     
    //Tamaño entre 1 y 48
     @Test
     public void BetweenTam()
    {
       assertTrue(Bebida.TamBebida("30"));
       assertTrue(Bebida.TamBebida("20"));
       assertTrue(Bebida.TamBebida("10"));
       assertTrue(Bebida.TamBebida("2"));
       assertTrue(Bebida.TamBebida("47"));
    }
    
     //Tamaño menor al minimo
    @Test(expected=RuntimeException.class)
    public void MinusTam() 
    {
    	Bebida.TamBebida("0");
    }
    //Tamaño mayor al maximo
    @Test(expected=RuntimeException.class)
    public void PassTam()
    {
    	Bebida.TamBebida("0");
    }
    
    //Tamaño valido entre  y 48
    @Test
    public void ascendente()
    {
       assertTrue(Bebida.Tam3(new String []{"1","2","3","4"} ));
    }
    
    //Entero entre 1 y 40
    @Test(expected=RuntimeException.class)
    public void Noascendente() 
    {
    	Bebida.Tam3(new String []{"1","5","3","4"} );
    	Bebida.Tam3(new String []{"5","1","3","4"} );
    }
    
    //String al inicio 
    @Test
    public void NameStart()
    {
       assertTrue(Bebida.NombreInicio("Latte,1,2,3,4"));
       assertTrue(Bebida.NombreInicio("Americano,1,2,3,4"));
       assertTrue(Bebida.NombreInicio("Colombiano,1,2,3,4"));
       assertTrue(Bebida.NombreInicio("Expresso,1,2,3,4"));



    }
    //Primero el nombre
    @Test(expected=RuntimeException.class)
    public void NameEmpty() 
    {
    	Bebida.NombreInicio("1,Latte,2,3");
    	Bebida.NombreInicio("1,Americano,2,3");
    	Bebida.NombreInicio("1,,2,Expresso,3");
    	Bebida.NombreInicio("1,,2,3,Colombia");



    }
  //Maximo de tam permitidos
    @Test
    public void MaxTam() 
    {
       assertTrue(Bebida.Tam("Latte1,1,2,3,4,5"));
       assertTrue(Bebida.Tam("Expresso1,1,2,3,4,5"));
       assertTrue(Bebida.Tam("Colombia1,1,2,3,4,5"));


    }
    
    //String Vacia
    @Test(expected=RuntimeException.class) 
    public void EmpyString() {
        Bebida.Empty("");
    }
 
}

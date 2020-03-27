package Tests;
/* 
* CountLOC
* 
* Version 2.0
*
* Autor Noel Andrew
*/
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import contadorB1.CountLOC;

public class TestsCounLOC {
    
    public TestsCounLOC() {
    }
    @Test 
    
    public void isEmpty()
    {
    	CountLOC test1 = new CountLOC();
        assertFalse(test1.CheckLine("   "));
    }
    
    @Test 
    public void isNotEmty()
    {
    	CountLOC test1 = new CountLOC();
        assertTrue(test1.CheckLine("int prueba"));
    }
    
    @Test 
    public void CheckComment()
    {
    	CountLOC test1 = new CountLOC();
        assertFalse(test1.CheckLine("//jwjdqjdjskdasjjdk"));
    }
    
    @Test 
    public void CheckComment2()
    {
        CountLOC test1 = new CountLOC();
        assertFalse(test1.CheckLine("/* aahjhhjskdksdkjdksdknsdnsjk */"));
    }
    
    @Test 
    public void CheckComment3()
    {
    	CountLOC test1 = new CountLOC();
        assertFalse(test1.CheckLine("*Hola, wapo"));
    }
    
    @Test 
    public void CheckComment4()
    {
    	CountLOC test1 = new CountLOC();
        assertFalse(test1.CheckLine("*/"));
    }
    
    @Test 
    public void CheckComment5()
    {
    	CountLOC test1 = new CountLOC();
        assertFalse(test1.CheckLine("# Hola, wapo"));
    }
    
    @Test(expected=RuntimeException.class) 
    public void DirFailed()
    {
    	CountLOC test1 = new CountLOC();
        test1.setFileName("C:\\Users\\Noel\\CCSoft\\programA2\\src\\nepe.java");
    }
    
    @Test 
    public void CheckDir()
    {
    	CountLOC test1 = new CountLOC();
        test1.setFileName("C:\\Users\\Noel\\CCSoft\\programA2\\src\\fileWR.java");
    }
   
    @Test(expected=RuntimeException.class)
    public void DirFailed2()
    {
    	CountLOC test1 = new CountLOC();
        test1.setFileName("C:\\Users\\Noel\\CCSoft\\programA2\\abcd");
    }
     
    @Test
    public void A1()
    {
    	CountLOC test1 = new CountLOC();
        test1.setFileName("C:\\Users\\Noel\\CCSoft\\programA1\\src\\SD.java");
        test1.contarlineas();
        System.out.println(test1.GetLOC());
    }
    
    @Test
    public void A2()
    {
    	CountLOC test1 = new CountLOC();
        test1.setFileName("C:\\Users\\Noel\\CCSoft\\programA2\\src\\fileWR.java");
        test1.contarlineas();
        System.out.println(test1.GetLOC());
    }
    
    @Test
    public void contarlineas_ProgramaA3()
    {
    	CountLOC test1 = new CountLOC();
        test1.setFileName("C:\\Users\\Noel\\CCSoft\\ProgramA3\\src\\SD.java");
        test1.contarlineas();
        System.out.println("el programa A3 tiene: " + test1.GetLOC());
    }
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
}
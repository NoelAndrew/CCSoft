package Test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import PSP1.ListaLigada;
import PSP1.Nodo;
import PSP1.FileWR;
import PSP1.SDLOC;


public class TestPSP1 {
	 @Test 
	    public void CheckDir()
	    {
	    	FileWR test1 = new FileWR();
	        test1.setNombreArchivo("C:\\Users\\Noel\\Documents\\UNI\\CCS\\Prueba.csv");
	    } 
	    
	    @Test(expected=RuntimeException.class)
	    public void DirFailed2()
	    {
	    	FileWR test1 = new FileWR();
	        test1.setNombreArchivo("C:\\Users\\Noel\\CCSoft\\programA2\\Prueba.csv");
	    }
	    
	    @Test 
	    public void Formato()
	    {
	    	FileWR test1 = new FileWR();
	        test1.setNombreArchivo("Prueba.csv");
	    } 
	    
	    @Test(expected=RuntimeException.class)
	    public void FormatoFail()
	    {
	    	FileWR test1 = new FileWR();
	        test1.setNombreArchivo("Prueba.txt");
	    }
	    @Test 
	    public void Entero()
	    {
	    	ListaLigada test1 = new ListaLigada();
	        assertEquals(1, test1.push(1));
	    }
	    
	    @Test(expected=NumberFormatException.class)
	    public void NoEntero()
	    {

	        Integer.parseInt("1.5");	  
	    }
	    
	    @Test(expected=NumberFormatException.class)
	    public void NoEntero2()
	    {

	        Integer.parseInt("1;9");	  
	    }
	    
	    @Test 
	    public void TestSD()
	    {
	    	SDLOC test1 = new SDLOC();
	        test1.Data("Prueba.csv");
	        assertEquals(197.8955801, test1.SDF(),0.001);
	    }
	    @Test 
	    public void TestRange()
	    {
	    	SDLOC test1 = new SDLOC();
	        test1.Data("Prueba.csv");
	        assertEquals(386.0532936, test1.RangeF(),0.01);
	    }
}

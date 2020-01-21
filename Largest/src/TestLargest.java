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

/**
 *
 * @author juangonzalezcalleros
 */
public class TestLargest {
	
    
    @Test
    public void    TestLargestAtBeggining() {
        assertEquals(9, Largest.largest(new int []{9,8,7})); 
    }
    
    @Test
    public void    TestLargestAnywhere() {
        assertEquals(9, Largest.largest(new int []{8,9,7})); 
    }

     @Test
    public void    TestLargestAtEnd() {
        assertEquals(9, Largest.largest(new int []{8,7,9})); 
    }
    
    @Test
    public void    TestLargestSingleNumber() {
        assertEquals(8, Largest.largest(new int []{8})); 
    }
    
    @Test
    public void    TestLargestNegative() {
        assertEquals(9, Largest.largest(new int []{8,-7,9})); 
    }
    
    @Test
    public void    TestLargestTwoNegative() {
        assertEquals(9, Largest.largest(new int []{-8,-7,9})); 
    }
    @Test
    public void    TestLargestAllNegative() {
        assertEquals(-7, Largest.largest(new int []{-8,-7,-9})); 
    }

    @Test
    public void TestEmptyList(){
        try{
            Largest.largest (new int[]{});
            fail ("It should throw an exception");
        }
        catch (RuntimeException e){
            assertTrue(true);
        }
    }
            
            
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
	
}

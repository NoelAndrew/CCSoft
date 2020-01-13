/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatriangle;

import javax.swing.JOptionPane;

import triangulo.Triangle;

/**
 *
 * @author JuanManuel
 */
public class JavaTriangle {	
	
	public static String Condicion(String A, String B, String C)
{
	int a = -1;
	try {
		a =  Integer.parseInt(A);
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Solo enteros positivos");

	}
	int b = -1;
	try {
		b =  Integer.parseInt(B);
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "Solo enteros positivos");
	}
	int c = -1;
	try {
	c =  Integer.parseInt(C);
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null, "Solo enteros positivos");
	}
	if(a > 0 && b > 0 && c > 0)
	{
		if(a + b > c && a + c > b && b + c > a)
		{
			return Triangle.Tipo(a,b,c);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Los valores no pueden cerrar el triangulo");
		}
		
	}
	else
	{
		if(a < 0) {
			JOptionPane.showMessageDialog(null, "Lado 1 no es positivo");
		}
		if(b < 0) {
			JOptionPane.showMessageDialog(null, "Lado 2 no es positivo");
		}
		if(c < 0) {
			JOptionPane.showMessageDialog(null, "Lado 3 no es positivo");
		}
			
	}
	return "";
}



    /**
     * @param args the command line arguments
     */
	
    public static void main(String[] args) {
        // TODO code application logic here
    	
    }



	public static void Condicion(int[] is) {
		// TODO Auto-generated method stub
		
	}
    
}

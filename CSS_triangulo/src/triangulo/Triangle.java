package triangulo;

public class Triangle {
	public static String Tipo(int A, int B, int C)
	{
		if(A == B && B == C )
		{
			return "Triangulo equilatero";
			
		}
		else if((A == B && B != C )||(A==C && C != B) )
		{
			return "Triangulo isosceles";
		}
		else if(A != B && A != C && B != C)
		{
			return "Triangulo escaleno";
		}
		return null;
		
	}
}
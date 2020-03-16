package A3;

import static A3.FileWR.*;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SD {   
    static double MediaF;
    static double VarianzaF;
    static double DesviacionF;
 
    public static void Value() throws IOException
    {
        fr = new FileReader(Main.Fichero);
        br = new BufferedReader(fr);
        double aux = 0;  
        while((isEmpty = br.readLine())!=null) {
                aux = Double.parseDouble(isEmpty);
                ListaLigada.push(aux);
        }
    }
    public static void Varianza()
    {
        double Sum;
        for(int i=0; i<ListaLigada.Tam; i++)
        {
            Sum = Math.pow(ListaLigada.GetItem(i)-MediaF, 2);
            VarianzaF += Sum;
        }
        VarianzaF=VarianzaF/(ListaLigada.Tam-1);
    }
    public static void Media()
    {     
        double Suma = 0;
        for(int i=0; i<ListaLigada.Tam; i++)
        {
            Suma+=ListaLigada.GetItem(i);
        }
        MediaF = Suma/ListaLigada.Tam;
        System.out.println(ListaLigada.Tam);
        System.out.println("Media: "+MediaF);
    }
    public static void SDev()
    {
        DesviacionF = Math.sqrt(VarianzaF);
        System.out.println("Desviacion Estandar: "+DesviacionF);
    }
}

/* 
* SDLOC
* 
* Version 2.0
* 
* Autor Noel Andrew
*/
package PSP1;

import java.util.Scanner;
public class SDLOC {

    private ListaLigada LOCxi;
    private ListaLigada LOCyi;
    private int XK;
    private int YK;
    float Num1;
    float Num2;
    float SD;
    double Range;
    double A1;
 
    public static void main(String[] args){
       System.out.println("¿Que valor desea en XK: ");
       Scanner sc = new Scanner(System.in);
       String xk = sc.nextLine();
       System.out.println("Ingresa el valor A1: ");
       String t = sc.nextLine();
       System.out.println("Ingresa el nombre del archivo");
       String datos = sc.nextLine();
       SDLOC SD = new SDLOC(Integer.valueOf(xk),Double.valueOf(t));
       SD.Data(datos);
       System.out.println("Rango: " + SD.RangeF()); 
    }
    
    public SDLOC(){
        Num2 = 0;
        Num1 = 0;
        SD = 0;
        Range = 0;
        XK = 0;
        YK = 0;
    }
    
    public SDLOC(int xk,double t){
        Num2 = 0;
        Num1 = 0;
        SD = 0;
        Range = 0;
        XK = xk;
        YK = 0;
        this.A1 = t;
    }
    
    public void Data(String nombre){
        LOCxi = new ListaLigada();
        LOCyi = new ListaLigada();
        FileWR datos = new FileWR();
        datos.setNombreArchivo(nombre);
        datos.ReadFile(LOCxi, LOCyi);   
    }
    
    public double LOCXi(){
        return LOCxi.Prom();
    }
    
    public double LOCYi(){
        return LOCyi.Prom();
    }
    
    public float Beta1(){
        float Sum = 0;
        for(int i = 0; i < LOCxi.Tamaño(); i++){
            Sum = Sum + (LOCxi.Value(i) * LOCyi.Value(i));
        }
        float Numerator = 
        		(float) (Sum - (LOCxi.Tamaño()*LOCxi.Prom() * LOCyi.Prom()));
        Sum = 0;
        for(int i = 0; i < LOCxi.Tamaño(); i++){
            Sum = Sum + (LOCxi.Value(i) * LOCxi.Value(i));
        }
        float Denominator = 
        		(float) (Sum - (LOCxi.Tamaño()* (LOCxi.Prom() * LOCxi.Prom())));
        Num2 = Numerator/Denominator;
        return Num2; 
    }
    
    public float Beta0(){
        if(Num2 == 0){
            Beta1();
        }
        Num1 = (float) (LOCyi.Prom() - (Num2 * LOCxi.Prom()));
        return Num1;
    }
    
    
    public float SDF(){
        if(Num2 == 0){
           Beta1();
        }
        if(Num1 == 0){
           Beta0();
        }
        float sumatoria = 0;
        for(int i = 0 ; i < LOCxi.Tamaño(); i++){
            sumatoria = (float) (sumatoria + ( Math.pow((LOCyi.Value(i) - Num1 - (Num2 * LOCxi.Value(i))),2)));
        }
        SD = (float)Math.sqrt(((float)1/(LOCxi.Tamaño()-2)) * sumatoria);
        return SD;
    }
    
    public double RangeF(){
        if(Num2 == 0){
           Beta1();
        }
        if(Num1 == 0){
            Beta0();
        }
        if(SD == 0){
            SDF();
        }
        float Sum = 0;
        for(int i = 0 ; i < LOCxi.Tamaño(); i++){
            Sum = (float) (Sum + Math.pow((LOCxi.Value(i) * LOCxi.Prom()), 2));
        }
        float P1 =  (float) Math.sqrt(1 + ((float) 1/LOCxi.Tamaño()) + (Math.pow(XK-LOCxi.Prom(), 2)/Sum));
        Range = (double) (A1 * SD * P1);
        return Range;
    }
    
    
}

/* 
* ListaLigada
* 
* Version 2.0
* 
* Autor Noel Andrew
*/
package PSP1;

import PSP1.Nodo;

public class ListaLigada {
    static Nodo Inicio;
    static int Tam;
    private double media;
    public ListaLigada(){
        Inicio = null;
        Tam = 0;
        media = 0;
    }
    public boolean isEmpty(){
        return(Inicio==null)?true:false;
    }
    public void push(double Num){
        if(Inicio == null){
            Inicio = new Nodo(Num);
        }
        else{
            Nodo A3 = Inicio;
            Nodo nodo = new Nodo(Num);
            nodo.Next(A3);
            Inicio = nodo;
        }
        Tam++;
    }
    public static double GetItem(int i){
        int cont = 0;
        Nodo Sig = Inicio;
        while(cont<i){
            Sig = Sig.GetSig();
            cont++;
        }
        return Sig.GetNum();
    } 
    public void Mostrar(){
        if(Inicio == null)
        {
            System.out.println("Pila Vacia");
        }
        else{
            Nodo A3 = Inicio;
            while(A3 != null)
            {
                System.out.println(A3.GetNum()+" ");
                A3 = A3.GetSig();
            }
        }
    }
    public float Value(int Aux)
    {
        if(Aux > Tam)
        {
            System.out.println("El indice ingresado no es valido");
            return 0;
        }
        else
        {
            Nodo aux = Inicio; 
            for(int i = 0 ; i < Aux ; i++ )
            {
                aux = aux.GetSig();
            }
            return (float) aux.GetNum();
        }
        
    }
    public int Tamaño(){
        return Tam;
        
    }
    public double  Prom()
    {
        double suma = 0;
        for(int i = 0 ; i< Tam; i++)
        {
            suma = suma + Value(i);
        }
        media = suma / Tam;
        return media;
    }
    
}


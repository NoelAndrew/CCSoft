package A3;

public class ListaLigada {
    static Nodo Inicio;
    static int Tam;
    
    public ListaLigada()
    {
        Inicio = null;
        Tam = 0;
    }
    public boolean isEmpty()
    {
        return(Inicio==null)?true:false;
    }
    public static void push(double Num)
    {
        if(Inicio == null)
        {
            Inicio = new Nodo(Num);
        }
        else
        {
            Nodo A3 = Inicio;
            Nodo nodo = new Nodo(Num);
            nodo.Next(A3);
            Inicio = nodo;
        }
        Tam++;
    }
    public static double GetItem(int i)
    {
        int cont = 0;
        Nodo Sig = Inicio;
        while(cont<i)
        {
            Sig = Sig.GetSig();
            cont++;
        }
        return Sig.GetNum();
    } 
    public static void Mostrar()
    {
        if(Inicio == null)
        {
            System.out.println("Pila Vacia");
        }
        else
        {
            Nodo A3 = Inicio;
            while(A3 != null)
            {
                System.out.println(A3.GetNum()+" ");
                A3 = A3.GetSig();
            }
        }
    }
    public static int Tamaño()
    {
        return Tam;
        
    }
    
}

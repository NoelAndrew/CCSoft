/* 
* Nodo
* 
* Version 2.0
* 
* Autor Noel Andrew
*/
package PSP1;
public class Nodo {
     double Num;
    Nodo Sig;
    
    public Nodo(double num){
        Num=num;
    }
    public void Next(Nodo next){
        Sig = next;
    }
    public double GetNum(){
        return Num;
    }
    public Nodo GetSig() {
        return Sig;
    }
    
}

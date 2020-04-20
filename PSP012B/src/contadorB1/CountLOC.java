/* El propósito de este software es contar las líneas de logicas de
 *  codigo omitiendo espacios en blanco y comentarios*/
/* 
* CountLOC
* 
* Version 2.0
* 
* Autor Noel Andrew
*/
package contadorB1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

 public class CountLOC {
	int ContLOC;
    String [] FileName;
    
    public CountLOC(){
        ContLOC = 0;
    }
    
    public int GetLOC(){
        return ContLOC;
    }
    
    /* En esta funcion buscamos la string del archivo a contar,
     *  unicamente introduciendo la direccion del archivo Java, este tiene que tener terminacion .java*/
    public void setFileName(String nom){
        if(nom.endsWith(".java")){
            File Archivo = new File(nom);
            if(Archivo.exists()){
                FileName = new String[1];
                FileName[0] = nom;
            }
            else{
                 throw new RuntimeException("Archivo no encontrado");
            }
        }
        else{
           throw new RuntimeException("Formato incorrecto");
        }
    }
    
    /*Este metodo recorre ambos archivos linea por linea
     * este compara las cadenas de texto, imprime si se parecen o no
     * ademas de que cuenta las lineas lógicas*/
    public void contarlineas(){
        for(int i = 0 ; i < FileName.length ; i++){
            File archivo;
            //Archivo2
            File archivo2;
            //Variable que me indica si son iguales o no
            boolean Equal = true;
            FileReader fr = null;
            FileReader fr2 = null;

            try{
                archivo = new File(FileName[i]);
                //archivo2
                archivo2 = new File(FileName[i]);
                fr = new FileReader(archivo);
                fr2 = new FileReader(archivo2);
                BufferedReader br = new BufferedReader(fr);
               //BufferReader para el segundo archivo
                BufferedReader br2 = new BufferedReader(fr2);
                String Line = br.readLine();
                //Lector de lineas del segundo archivo
                String Line2 = br.readLine();
                while (Line != null || Line2 != null){
                    if(Line == null || Line2 == null){
                        Equal = false;
                         
                        break;
                    }
                    else if(! Line.equalsIgnoreCase(Line2)){
                        Equal = false;   
                        break;
                    }
                    Line = br.readLine(); 
                    Line2 = br2.readLine();
                    ContLOC++;
                }
                if(Equal){
                    System.out.println("Los dos archivos tienen el mismo contenido");
                }
                else{
                    System.out.println("Los archivos tienen diferentes lineas "+ContLOC);
                     
                    System.out.println("El archivo 1 tiene "+Line+" lineas y el archivo 2 tiene"+Line2+" lineas "+ContLOC);
                }
                 
                fr.close();
                 
                fr2.close();
              
                }catch(Exception e1){
                    e1.printStackTrace();
                }
                
            }
            
        }
    
    /*Esta funcion verifica si la linea es vacia,
     * o si es comentario tomando en cuenta que estos comeienzan con //, con /* * / y con # 
     * Si no está vacia la cuentp, sino no lo hago, de igual manera con los comentarios*/
    public boolean CheckLine(String Linea)
    {
        String lineaAux = Linea.replace(" ", "");
        if(!lineaAux.isEmpty()) {
            if(!Linea.startsWith("#") && !Linea.startsWith("//") && !Linea.startsWith("/*") && !Linea.startsWith("*/")  && !Linea.startsWith("*")) {
                return true; 
            }
            else{
                return false; 
            }
        }
        else{
            return false; 
        }
    }
}

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
    
    /*Este metodo recorre el archivo leyendo cada linea como String
     *Si no incia como comentario lo asume como una linea de código
     *Si esta linea es una Linea Logica aumenta el contador */
    public void contarlineas(){
        for(int i = 0 ; i < FileName.length ; i++){
            File archivo;
            FileReader fr = null;
            try{
                archivo = new File(FileName[i]);
                fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                String Line = br.readLine();
                while(Line != null){
                    if(CheckLine(Line))
                        ContLOC++;
                    Line = br.readLine();
                } 
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if( null != fr){
                        fr.close();
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }
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

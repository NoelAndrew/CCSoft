/* 
* FileWR
* 
* Version 2.0
* 
* Autor Noel Andrew
*/
package PSP1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import PSP1.ListaLigada;

public class FileWR {
    String FileName;
    
   
    public void setNombreArchivo(String path){
        if(path.endsWith(".csv")) {
            File input = new File(path);
            if(input.exists()){
                FileName =  path;
            }
            else{
                 throw new RuntimeException("Error de archivo");
            }   
        }
        else{
            throw new RuntimeException("Error de formato");
        }
    }
    
    public void ReadFile(ListaLigada A1, ListaLigada A2)
    {
        File nom;
        FileReader fr = null;
        try{
            nom = new File(FileName);
            fr = new FileReader(nom);
            BufferedReader br = new BufferedReader(fr);
            String Text = br.readLine();
            while(Text != null){
                    String [] aux = Text.split(",");
                    if(aux.length == 2 )
                    {
                        try{
                             A1.push(Integer.valueOf(aux[0]));
                        }catch(Exception e){
                           throw new RuntimeException("El primer dato debe ser un numero entero");
                        }
                         try{
                              A2.push(Integer.valueOf(aux[1]));
                        }catch(Exception e){
                           throw new RuntimeException("El segundo dato debe ser un numero entero");
                        }

                }
                Text = br.readLine();
            } 
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if( null != fr)
                {
                    fr.close();
                }

            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
       
        
    }
    
}

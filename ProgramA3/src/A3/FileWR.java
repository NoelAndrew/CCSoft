package A3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWR {
	static String isEmpty = "";
    static FileReader fr;
    static BufferedReader br;
    
	public static void Reader(String Path) throws IOException 
    {
        fr = new FileReader(Path);
        br = new BufferedReader(fr);
        System.out.println("File: ");
        while((isEmpty = br.readLine())!=null) {
            System.out.println(isEmpty); 
        }
        br.close();
    }
	public static void Writer(String NewFile, int Limit)
    {
        String Text;
        Scanner input = new Scanner(System.in);
        try{
            FileWriter fw = new FileWriter(NewFile);
            for(int i=1; i<=Limit; i++)
            {
                System.out.println("Ingresa un numero entero "+i);
                Text = input.nextLine();
                fw.write(Text+"\n");
            }
            fw.close();
        }catch (IOException|NumberFormatException e) {
        }
    }
    
}

package Metodos;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

public class MetodoGlobales
{

    public String QuitarEspacios(String Texto)
    {
        String Retorna="";
        for (int i=0;i<Texto.length();i++){
            if(Texto.charAt(i)!=' '){
                Retorna+=Texto.charAt(i);
            }
        }
        return Retorna;
    }

    public String QuitarAcento(String Texto){
        String original = Texto;
        String cadenaNormalize = Normalizer.normalize(original, Normalizer.Form.NFD);
        String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
        return  cadenaSinAcentos;
    }

    public void GenerarArchivoCompreso(String Ruta, String Cadena){
        try
        {
            BufferedWriter Buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ruta), StandardCharsets.UTF_8));
            PrintWriter Print = new PrintWriter(Buffer);
            Print.write(Cadena);
            Print.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Al Escribir El Archivo", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}

package Metodos;

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
}

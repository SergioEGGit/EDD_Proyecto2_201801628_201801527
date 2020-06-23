package Metodos;

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

}

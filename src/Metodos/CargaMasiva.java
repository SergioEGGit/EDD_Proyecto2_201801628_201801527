package Metodos;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FilenameFilter;
import Variables.VariablesGlobales;

public class CargaMasiva
{

    void GuardarDatos(char SplitDato,char SplitSubDato,String Datos,int CantidadSubDatos){//Guarda los datos en una matriz
        String Informacion[]=Datos.split(Character.toString(SplitDato));
        String SubInformacion[]=null;
        int Contador=0;
        for (String SubDatos: Informacion){
            SubInformacion=SubDatos.split(Character.toString(SplitSubDato));
            if(SubInformacion.length==CantidadSubDatos){
                Contador++;
                System.out.println(SubDatos);
            }else{
                System.err.println(SubDatos);
            }
        }
        if(Contador>0 && CantidadSubDatos>0) {
            VariablesGlobales.ItemsArchivo = new String[Contador][CantidadSubDatos];
            int Indice=0;
            for (String SubDatos: Informacion){
                SubInformacion=SubDatos.split(Character.toString(SplitSubDato));
                if(SubInformacion.length==CantidadSubDatos){
                    VariablesGlobales.ItemsArchivo[Indice]=SubInformacion;
                    Indice++;
                }
            }
        }
    }

    void LecturaArchivo(String Ruta,int CantidadSubDatos,char SplitDato,char SplitSubDato){//Recupera todo el texto del archivo
        try {
            FileReader fr = new FileReader(Ruta);
            BufferedReader bf = new BufferedReader(fr);
            String sCadena="";
            String Texto="";
            while ((sCadena = bf.readLine())!=null)
            {
                Texto+=sCadena;
            }
            GuardarDatos(SplitDato,SplitSubDato,Texto,CantidadSubDatos);
        }catch (Exception E){
            JOptionPane.showMessageDialog(null,"OCURRIO UN ERROR AL ABRIR EL DOCUMENTO","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    /*EJ: Dato1,Dato2,Dato3;
    * este metodo recibe un splitDato que es el que separa el primer Valor  el SplitDato=';'
    * SplitSubDato del ejemplo seria el que separa la informacion del dato principal SplitSubDato=','
    * Filtro es el que se encarga de limitar el tipo de archivo que recibe el navegador de archivo ejemplo Usuario.usr Filto=usr
    * Tipo carga es el nombre de la carga Ej: Usuarios, Carros, Rutas etc. es solo un nombre del tipo de carga
    * CantidadSubDatos= numero de sub datos de el dato general en este caso seria 3 ya que hay 3 datos
    * Dato1  Dato2  Dato2
    *   1      2      3
    *
    * La informacion se guarda en una matriz en la clase VariablesGlobales la variable se llama ItemsArchivo
    * aqui se guardan los valores separados filtrados es decir si existio algun problema con algun valor incompleto
    * lo salta
    * */
    public void CargaMasiva(char SplitDato,char SplitSubDato,String Filtro,String TipoCarga,int CantidadSubDatos){//Abre el file choose
        JButton Abrir=new JButton("ABRIR");
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter FiltroFC=new FileNameExtensionFilter(TipoCarga,Filtro);
        fileChooser.setDialogTitle("CARGA MASIVA DE "+TipoCarga);
        fileChooser.setFileFilter(FiltroFC);
        int seleccion = fileChooser.showSaveDialog(Abrir);
        if (seleccion == JFileChooser.APPROVE_OPTION){
            LecturaArchivo(fileChooser.getSelectedFile().getAbsolutePath(),CantidadSubDatos,SplitDato,SplitSubDato);
        }else if(seleccion == JFileChooser.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null,"BOTON CANCELAR");
        }else{
            JOptionPane.showMessageDialog(null,"OCURRIO UN ERROR");
        }
    }

}

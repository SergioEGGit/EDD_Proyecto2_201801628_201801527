package Estructuras;
//Ramas a la derecha 1
//Ramas a la izquierda 0

import Variables.VariablesGlobales;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.Stack;

public class Huffman {
    private HuffmanNodo HuffAuxiliar;
    private HuffmanNodo ListaArboles;
    Stack<String> Binario=null;
    Stack<Integer> BinariosNumero=null;
    String[][] TablaCompresion=null;
    String TopCompreso="";
    String CadenaEnbinario="";
    String TextoDescompreso="";
    int Contador=0;
    public Huffman() {
    }

    public HuffmanNodo getHuffAuxiliar() { return HuffAuxiliar; }

    public void setHuffAuxiliar(HuffmanNodo huffAuxiliar) { HuffAuxiliar = huffAuxiliar; }

    public HuffmanNodo getListaArboles() { return ListaArboles; }

    public void setListaArboles(HuffmanNodo listaArboles) { ListaArboles = listaArboles; }

    public void Compresion(String Texto, String TOP){
        System.out.println(Texto);
        setHuffAuxiliar(null);
        for (int i=0;i<Texto.length();i++){
            SumasFrecuencia(Texto.charAt(i));
        }
        getHuffAuxiliar().setFrecuencia(getHuffAuxiliar().getFrecuencia()-1);
        bubblesort();
        bubblesortAbecedario();
        TablaCompresion=new String[contarNodos()][2];
        Binario=new Stack<String>();
        Contador=0;
        CrearArbol();
        RecorrerArbol(getHuffAuxiliar());
        CadenaEnbinario=TOP+"\n";
        for (int i=0;i<Texto.length();i++){
            CadenaEnbinario+=RetonarBinario(Character.toString(Texto.charAt(i)));
        }
        //System.out.println(Integer.toBinaryString((0x72 & 0xFF) + 256).substring(1));
        BuscarRuta(CadenaEnbinario,TOP);
        getHuffAuxiliar().setTop(TOP);
        AgregarEnListaDeArboles(getHuffAuxiliar());
    }

    public String Descomprimir(String Top,String TextBinario){
        TextoDescompreso="";
        HuffmanNodo Aux=getListaArboles();
        HuffmanNodo Arbol=null;
        while (Aux!=null){
            if(Aux.getTop().equals(Top)){
                Arbol=Aux;
                break;
            }
            Aux=Aux.getSigLista();
        }
        if(Arbol!=null){
            BinariosNumero=new Stack<Integer>();
            for (int i=0;i<TextBinario.length();i++){
                BinariosNumero.push(Integer.parseInt(Character.toString(TextBinario.charAt(i))));
            }
            while (!BinariosNumero.empty()){
                DescomprimirTexto(Arbol);
            }
        }
        return TextoDescompreso;
    }

    void DescomprimirTexto(HuffmanNodo Nodo){
        if(Nodo.getHijoDerecha()==null && Nodo.getHijoDerecha()==null){
            TextoDescompreso+=Nodo.getCaracter();
        }else{
            int Bin=BinariosNumero.get(0);
            BinariosNumero.removeElementAt(0);
            if(Bin==0){
                if(Nodo.getHijoIzquierda()!=null){
                    DescomprimirTexto(Nodo.getHijoIzquierda());
                }
            }else{
                if(Nodo.getHijoDerecha()!=null){
                    DescomprimirTexto(Nodo.getHijoDerecha());
                }
            }
        }
    }

    void BuscarRuta(String Cadena,String Top){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filtro=new FileNameExtensionFilter("EDD TOPS","edd");
        chooser.setFileFilter(filtro);
        String Ruta=Top+".edd";
        chooser.setSelectedFile(new File(Ruta));
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            VariablesGlobales.MetodoGlobales.GenerarArchivoCompreso(chooser.getSelectedFile().getAbsolutePath(),Cadena);
        }
    }

    String RetonarBinario(String Caracter){
        for (String[] Fila:TablaCompresion){
            if(Fila[0].equals(Caracter)){
                return Fila[1];
            }
        }
        return "0";
    }

    void ImprimirLista(){
        HuffmanNodo Aux=getHuffAuxiliar();
        while (Aux!=null){
            System.out.println(Aux.toString());
            Aux=Aux.getSigLista();
        }
        System.out.println();
    }

    void SumasFrecuencia(char Caracter){
        HuffmanNodo Aux=getHuffAuxiliar();
        if(Aux==null){
            Aux=new HuffmanNodo(Caracter);
            setHuffAuxiliar(Aux);
        }
        while (Aux!=null){
            if(Aux.getCaracter()==Caracter){
                Aux.setFrecuencia(Aux.getFrecuencia()+1);
                break;
            }
            else if(Aux.getSigLista()==null){
                HuffmanNodo NuevoCaracter=new HuffmanNodo(Caracter);
                Aux.setSigLista(NuevoCaracter);
                NuevoCaracter.setAntLista(Aux);
                break;
            }
            Aux=Aux.getSigLista();
        }
    }

    void bubblesort(){
        HuffmanNodo Aux=getHuffAuxiliar();
        while (Aux!=null){
            HuffmanNodo Aux2=Aux.getSigLista();
            while (Aux2!=null){
                if(Aux.getFrecuencia()>Aux2.getFrecuencia()){
                    char Car=Aux.getCaracter();
                    int Fre=Aux.getFrecuencia();
                    Aux.setCaracter(Aux2.getCaracter());
                    Aux.setFrecuencia(Aux2.getFrecuencia());
                    Aux2.setFrecuencia(Fre);
                    Aux2.setCaracter(Car);
                }
                Aux2=Aux2.getSigLista();
            }
            Aux=Aux.getSigLista();
            if(Aux.getSigLista()==null){break;}
        }
    }
    void bubblesortAbecedario(){
        HuffmanNodo Aux=getHuffAuxiliar();
        int Frecuencia;
        while (Aux!=null){
            HuffmanNodo Aux2=Aux.getSigLista();
            while (Aux2!=null){
                if(Aux.getCaracter()>Aux2.getCaracter() && Aux.getFrecuencia()==Aux2.getFrecuencia()){
                    char Car=Aux.getCaracter();
                    int Fre=Aux.getFrecuencia();
                    Aux.setCaracter(Aux2.getCaracter());
                    Aux.setFrecuencia(Aux2.getFrecuencia());
                    Aux2.setFrecuencia(Fre);
                    Aux2.setCaracter(Car);
                }
                Frecuencia=Aux2.getFrecuencia();
                Aux2=Aux2.getSigLista();
                try {
                    if(Frecuencia!=Aux2.getFrecuencia()){break;}
                }catch (Exception E){ }
            }
            Aux=Aux.getSigLista();
            if(Aux.getSigLista()==null){break;}
        }
    }


    void CrearArbol(){
        HuffmanNodo Primero=null,Segundo=null;
        while (contarNodos()>1){
            Primero=getHuffAuxiliar();
            Segundo=Primero.getSigLista();
            try {
                Segundo.getSigLista().setAntLista(null);
            }catch (Exception E){}
            setHuffAuxiliar(Segundo.getSigLista());
            Primero.setSigLista(null);
            Segundo.setSigLista(null);
            Primero.setAntLista(null);
            Segundo.setAntLista(null);
            int ValorIndice=Primero.getFrecuencia()+Segundo.getFrecuencia();
            AgregarNuevoNodoEnLista(ValorIndice,Primero,Segundo);
        }
    }

    void AgregarNuevoNodoEnLista(int ValFrecuencia,HuffmanNodo Primero,HuffmanNodo Segundo){
        System.out.println(ValFrecuencia);
        HuffmanNodo Aux=getHuffAuxiliar();
        if(Aux==null){
            Aux=new HuffmanNodo(ValFrecuencia);
            Aux.setHijoIzquierda(Primero);
            Aux.setHijoDerecha(Segundo);
            setHuffAuxiliar(Aux);
        }else{
            while (Aux!=null){
                if(Aux.getFrecuencia()==ValFrecuencia){
                    if(Aux.getAntLista()!=null){
                        HuffmanNodo Nuevo=new HuffmanNodo(ValFrecuencia);
                        Nuevo.setHijoIzquierda(Primero);
                        Nuevo.setHijoDerecha(Segundo);
                        HuffmanNodo Anterior=Aux.getAntLista();
                        Anterior.setSigLista(Nuevo);
                        Nuevo.setSigLista(Aux);
                        Aux.setAntLista(Nuevo);
                        Nuevo.setAntLista(Anterior);
                        break;
                    }else {
                        HuffmanNodo Nuevo=new HuffmanNodo(ValFrecuencia);
                        Nuevo.setHijoIzquierda(Primero);
                        Nuevo.setHijoDerecha(Segundo);
                        Nuevo.setSigLista(Aux);
                        Aux.setAntLista(Nuevo);
                        setHuffAuxiliar(Nuevo);
                        break;
                    }
                }else if(ValFrecuencia>Aux.getFrecuencia()){
                    if(Aux.getSigLista()!=null){
                        if(ValFrecuencia<Aux.getSigLista().getFrecuencia()){
                            HuffmanNodo Anterior=Aux;
                            Aux=Aux.getSigLista();
                            HuffmanNodo Nuevo=new HuffmanNodo(ValFrecuencia);
                            Nuevo.setHijoIzquierda(Primero);
                            Nuevo.setHijoDerecha(Segundo);
                            Anterior.setSigLista(Nuevo);
                            Nuevo.setSigLista(Aux);
                            Aux.setAntLista(Nuevo);
                            Nuevo.setAntLista(Anterior);
                            break;
                        }
                    }else{
                        HuffmanNodo Nuevo=new HuffmanNodo(ValFrecuencia);
                        Nuevo.setHijoIzquierda(Primero);
                        Nuevo.setHijoDerecha(Segundo);
                        Aux.setSigLista(Nuevo);
                        Nuevo.setAntLista(Aux);
                        break;
                    }
                }else if(ValFrecuencia<Aux.getFrecuencia()){
                    if(Aux.getAntLista()==null){
                        HuffmanNodo Nuevo=new HuffmanNodo(ValFrecuencia);
                        Nuevo.setHijoIzquierda(Primero);
                        Nuevo.setHijoDerecha(Segundo);
                        Nuevo.setSigLista(Aux);
                        Aux.setAntLista(Nuevo);
                        setHuffAuxiliar(Nuevo);
                        break;
                    }
                }
                Aux=Aux.getSigLista();
            }
        }
    }

    int contarNodos(){
        int Contador=0;
        HuffmanNodo Aux=getHuffAuxiliar();
        while (Aux!=null){
            Contador++;
            Aux=Aux.getSigLista();
        }
        return Contador;
    }

    void RecorrerArbol(HuffmanNodo Nodo){
        if(Nodo.getHijoDerecha()==null && Nodo.getHijoIzquierda()==null){ /*Hoja donde hay un caracter*/
            TablaCompresion[Contador][0]=Character.toString(Nodo.getCaracter());
            TablaCompresion[Contador][1]=Binario();
            Contador++;
        }else{
            if(Nodo.getHijoIzquierda()!=null){
                Binario.push("0");
                RecorrerArbol(Nodo.getHijoIzquierda());
                Binario.pop();
            }
            if(Nodo.getHijoDerecha()!=null){
                Binario.push("1");
                RecorrerArbol(Nodo.getHijoDerecha());
                Binario.pop();
            }
        }
    }

    String Binario(){
        String binario="";
        for (int i=0;i<Binario.size();i++){
            binario+=Binario.get(i);
        }
        return binario;
    }

    void AgregarEnListaDeArboles(HuffmanNodo Inicio){
        HuffmanNodo Aux=getListaArboles();
        if(Aux==null){
            setListaArboles(Inicio);
        }else{
            while (Aux!=null){
                if(Aux.getTop().equals(Inicio.getTop())){
                    Aux.setTop(Inicio.getTop());
                    Aux.setHijoDerecha(Inicio.getHijoDerecha());
                    Aux.setHijoIzquierda(Inicio.getHijoIzquierda());
                    Aux.setFrecuencia(Inicio.getFrecuencia());
                    Aux.setCaracter(Inicio.getCaracter());
                    break;
                }
                else if(Aux.getSigLista()==null){
                    Aux.setSigLista(Inicio);
                    Inicio.setAntLista(Aux);
                    break;
                }
                Aux=Aux.getSigLista();
            }
        }
    }

}

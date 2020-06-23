package Estructuras;

import Variables.VariablesGlobales;

import java.io.*;
import java.util.List;
import java.util.Stack;

public class ListaAdyacencia {

    //inicio de la lista de adyacencia
    private ListaAdyacenciaNodo InicioListaAdyacencia;

    //Devuelve el inicio de la listas
    public ListaAdyacenciaNodo getInicioListaAdyacencia() { return InicioListaAdyacencia; }

    //Guarda el inicio de la lista
    public void setInicioListaAdyacencia(ListaAdyacenciaNodo inicioListaAdyacencia) { InicioListaAdyacencia = inicioListaAdyacencia; }

    //constructor Vacio
    public ListaAdyacencia() {
    }

    //Verifica si esta vacia la lista
    public boolean IsEmpty(){
        return getInicioListaAdyacencia()==null;
    }

    public ListaAdyacenciaNodo ExisteOrigen(String Origen){
        ListaAdyacenciaNodo Auxiliar=getInicioListaAdyacencia();//Inicio de la lista
        while(Auxiliar!=null){//recorre la lista inicial con los origenes
            if(Auxiliar.getOrigen().equals(Origen)){//si el origen existe retorna el nodo de origen
                return Auxiliar;
            }
            Auxiliar=Auxiliar.getAbajo();
        }
        return null;//si el origen existe retorna null
    }

    public boolean InsertarNodo(String Origen, String Destino, double TimepoRuta){
        if(IsEmpty()==true){
            ListaAdyacenciaNodo OrigenEnLista=new ListaAdyacenciaNodo(Origen);
            ListaAdyacenciaNodo Nuevo=new ListaAdyacenciaNodo(Origen,Destino,TimepoRuta);
            OrigenEnLista.setDerecha(Nuevo);
            setInicioListaAdyacencia(OrigenEnLista);
            return true;
        }else{
            ListaAdyacenciaNodo Auxiliar=ExisteOrigen(Origen);
            if(Auxiliar!=null){
                while(Auxiliar!=null){
                    if(Auxiliar.getDestino().equals(Destino)){
                        return false;
                    }else if(Auxiliar.getDerecha()==null){
                        ListaAdyacenciaNodo Nuevo=new ListaAdyacenciaNodo(Origen,Destino,TimepoRuta);
                        Auxiliar.setDerecha(Nuevo);
                        return true;
                    }
                    Auxiliar=Auxiliar.getDerecha();
                }
            }else{
                Auxiliar=getInicioListaAdyacencia();
                String OrigAux="",OrigAuxSig="";
                while (Auxiliar!=null){
                    OrigAux=Auxiliar.getOrigen();
                    if(Origen.compareTo(OrigAux)>0){
                        if(Auxiliar.getAbajo()!=null){
                            OrigAuxSig=Auxiliar.getAbajo().getOrigen();
                            if (Origen.compareTo(OrigAuxSig)<0){
                                ListaAdyacenciaNodo Sig=Auxiliar.getAbajo();
                                ListaAdyacenciaNodo OrigenEnLista=new ListaAdyacenciaNodo(Origen);
                                ListaAdyacenciaNodo Nuevo=new ListaAdyacenciaNodo(Origen,Destino,TimepoRuta);
                                OrigenEnLista.setDerecha(Nuevo);
                                Auxiliar.setAbajo(OrigenEnLista);
                                OrigenEnLista.setAbajo(Sig);
                                return true;
                            }
                        }else{
                            ListaAdyacenciaNodo OrigenEnLista=new ListaAdyacenciaNodo(Origen);
                            ListaAdyacenciaNodo Nuevo=new ListaAdyacenciaNodo(Origen,Destino,TimepoRuta);
                            OrigenEnLista.setDerecha(Nuevo);
                            Auxiliar.setAbajo(OrigenEnLista);
                            return true;
                        }
                    }else if(Origen.compareTo(OrigAux)<0){
                        ListaAdyacenciaNodo Sig=Auxiliar.getAbajo();
                        ListaAdyacenciaNodo DerechaAux=Auxiliar.getDerecha();
                        ListaAdyacenciaNodo OrigenEnLista=new ListaAdyacenciaNodo(Origen);
                        ListaAdyacenciaNodo Nuevo=new ListaAdyacenciaNodo(Origen,Destino,TimepoRuta);
                        OrigenEnLista.setOrigen(Auxiliar.getOrigen());
                        OrigenEnLista.setDerecha(DerechaAux);
                        Auxiliar.setOrigen(Origen);
                        Auxiliar.setDerecha(Nuevo);
                        Auxiliar.setAbajo(OrigenEnLista);
                        OrigenEnLista.setAbajo(Sig);
                        return true;
                    }
                    Auxiliar=Auxiliar.getAbajo();
                }
            }
            return false;
        }
    }

    public void ImprimirLista(){
        ListaAdyacenciaNodo Auxiliar=getInicioListaAdyacencia();
        while(Auxiliar!=null){
            ListaAdyacenciaNodo Origen=Auxiliar;
            System.out.print(Auxiliar.getOrigen()+"→");
            Auxiliar=Auxiliar.getDerecha();
            while (Auxiliar!=null){
                System.out.print(Auxiliar.getDestino()+"→");
                Auxiliar=Auxiliar.getDerecha();
            }
            System.out.print("null");
            System.out.println();
            System.out.println("↓");
            Auxiliar=Origen.getAbajo();
        }
    }

    public void GenerarGrafoRutas(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\GraficasE\\GrafoRutas.dot");
            pw = new PrintWriter(fichero);

            pw.println("digraph G {");
            pw.println("node [margin=0 shape=circle style = filled fillcolor=\"#967373\"];");
            //pw.println("edge [arrowhead=none,arrowtail=none];");
            ListaAdyacenciaNodo Auxiliar=getInicioListaAdyacencia();
            while (Auxiliar!=null){
                ListaAdyacenciaNodo Origen=Auxiliar;
                pw.println("N"+ VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getOrigen())+" [label=\""+Auxiliar.getOrigen()+"\", xlabel=\"["+Auxiliar.getViendeDeNodo()+","+Auxiliar.getTiempoAcumulado()+"]\"];");
                Auxiliar=Auxiliar.getDerecha();
                while (Auxiliar!=null){
                    pw.println("N"+ VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getOrigen()) + " -> " + "N" + VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getDestino()) + " [label=\""+Auxiliar.getTiempoRuta()+"\"];");
                    Auxiliar=Auxiliar.getDerecha();
                }
                Auxiliar=Origen.getAbajo();
            }

            pw.println("}");
            fichero.close();
            ProcessBuilder Builder;
            Builder = new ProcessBuilder("dot", "-Tpng", "-o", "C:\\GraficasE\\GrafoRutas.png","C:\\GraficasE\\GrafoRutas.dot");
            Builder.redirectErrorStream(true);
            Builder.start();
        } catch (Exception e) {

        }
    }


    void AgregarOrigenesAListaAdyacencia(String Origen){
        ListaAdyacenciaNodo Auxiliar=getInicioListaAdyacencia();
        String OrigAux="",OrigAuxSig="";
        while (Auxiliar!=null){
            OrigAux=Auxiliar.getOrigen();
            if(Origen.compareTo(OrigAux)>0){
                if(Auxiliar.getAbajo()!=null){
                    OrigAuxSig=Auxiliar.getAbajo().getOrigen();
                    if (Origen.compareTo(OrigAuxSig)<0){
                        ListaAdyacenciaNodo Sig=Auxiliar.getAbajo();
                        ListaAdyacenciaNodo OrigenEnLista=new ListaAdyacenciaNodo(Origen);
                        Auxiliar.setAbajo(OrigenEnLista);
                        OrigenEnLista.setAbajo(Sig);
                        break;
                    }
                }else{
                    ListaAdyacenciaNodo OrigenEnLista=new ListaAdyacenciaNodo(Origen);
                    Auxiliar.setAbajo(OrigenEnLista);
                    break;
                }
            }else if(Origen.compareTo(OrigAux)<0){
                ListaAdyacenciaNodo Sig=Auxiliar.getAbajo();
                ListaAdyacenciaNodo DerechaAux=Auxiliar.getDerecha();
                ListaAdyacenciaNodo OrigenEnLista=new ListaAdyacenciaNodo(Origen);
                OrigenEnLista.setOrigen(Auxiliar.getOrigen());
                OrigenEnLista.setDerecha(DerechaAux);
                Auxiliar.setOrigen(Origen);
                Auxiliar.setDerecha(null);
                Auxiliar.setAbajo(OrigenEnLista);
                OrigenEnLista.setAbajo(Sig);
                break;
            }
            Auxiliar=Auxiliar.getAbajo();
        }
    }

    void CrearOrigenesSinDestinos(){
        Stack<String> Origenes=new Stack<String>();
        ListaAdyacenciaNodo Orig=getInicioListaAdyacencia();
        ListaAdyacenciaNodo Destinos=null;
        while (Orig!=null){
            Destinos=Orig.getDerecha();
            while (Destinos!=null){
                if(Origenes.size()==0){
                    Origenes.push(Destinos.getDestino());
                }
                else{
                    for (int i=0;i<Origenes.size();i++){
                        if(Origenes.get(i).equals(Destinos.getDestino())){
                            break;
                        }
                        if(i==Origenes.size()-1){
                            Origenes.push(Destinos.getDestino());
                        }
                    }
                }
                Destinos=Destinos.getDerecha();
            }
            Orig=Orig.getAbajo();
        }
        Orig=getInicioListaAdyacencia();
        while (Orig!=null){
            for (int i=0;i<Origenes.size();i++){
                if(Origenes.get(i).equals(Orig.getOrigen())){
                    Origenes.removeElementAt(i);
                    break;
                }
            }
            Orig=Orig.getAbajo();
        }
        System.out.println(Origenes.toString());
        String Orige="";
        while (!Origenes.empty()){
            Orige=Origenes.pop();
            AgregarOrigenesAListaAdyacencia(Orige);
        }
    }


    void BuscarOrigenCambiarTiempos(ListaAdyacenciaNodo Nodo,double TiempoAcumuladoPrevio,String NombreOrigen){
        ListaAdyacenciaNodo Aux=getInicioListaAdyacencia();
        while (Aux!=null){
            if(Aux.getOrigen().equals(Nodo.getDestino())){
                double TNuevo=TiempoAcumuladoPrevio+Nodo.getTiempoRuta();
                if(TNuevo>Aux.getTiempoAcumulado()){
                    Aux.setTiempoAcumulado(TNuevo);
                    Aux.setViendeDeNodo(NombreOrigen);
                    if(Aux.getDerecha()!=null){
                        CalcularTiempoAcumulado(Aux);
                    }
                }
            }
            Aux=Aux.getAbajo();
        }
    }

    void CalcularTiempoAcumuladoMinimo(){
        ListaAdyacenciaNodo Origenes=getInicioListaAdyacencia();
        while (Origenes!=null){
            ListaAdyacenciaNodo AuxOrigenes=Origenes;
            ListaAdyacenciaNodo Destinos=Origenes.getDerecha();
            while (Destinos!=null){
                ListaAdyacenciaNodo OrigenSig=ExisteOrigen(Destinos.getDestino());
                double TiempoNuevo=Origenes.getTiempoAcumulado()+Destinos.getTiempoRuta();
                if(OrigenSig.getTiempoAcumulado()>TiempoNuevo){
                    OrigenSig.setViendeDeNodo(AuxOrigenes.getOrigen());
                    OrigenSig.setTiempoAcumulado(TiempoNuevo);
                }
                Destinos=Destinos.getDerecha();
            }
            Origenes=AuxOrigenes.getAbajo();
        }
    }



    void CalcularTiempoAcumulado(ListaAdyacenciaNodo Origen){//Max= true  Min=false
        ListaAdyacenciaNodo Auxiliar=Origen.getDerecha();//Se mueve a la derecha
        while (Auxiliar!=null){
            BuscarOrigenCambiarTiempos(Auxiliar,Origen.getTiempoAcumulado(),Auxiliar.getOrigen());
            Auxiliar=Auxiliar.getDerecha();
        }
    }




    public void AlgoritmoDijkstra(){
        CrearOrigenesSinDestinos();
        ImprimirLista();
        Stack<String> Origenes=BuscarNodoInicial();
        for(int i=0;i<Origenes.size();i++){
            String Orig=Origenes.get(i);
            ListaAdyacenciaNodo Aux=getInicioListaAdyacencia();
            while (Aux!=null){
                if(Orig.equals(Aux.getOrigen())){
                    CalcularTiempoAcumulado(Aux);
                    break;
                }
                Aux=Aux.getAbajo();
            }
        }
        CalcularTiempoAcumuladoMinimo();
    }

    Stack<String> BuscarNodoInicial(){
        ListaAdyacenciaNodo Auxiliar=getInicioListaAdyacencia();
        Stack<String> Origenes=new Stack<String>();
        while (Auxiliar!=null){
            Origenes.push(Auxiliar.getOrigen());
            Auxiliar=Auxiliar.getAbajo();
        }
        Auxiliar=getInicioListaAdyacencia();
        while (Auxiliar!=null){
            ListaAdyacenciaNodo Origen=Auxiliar;
            Auxiliar=Auxiliar.getDerecha();
            while (Auxiliar!=null){
                for (int i=0;i<Origenes.size();i++){
                    if(Origenes.get(i).equals(Auxiliar.getDestino())){
                        Origenes.removeElementAt(i);
                        break;
                    }
                }
                Auxiliar=Auxiliar.getDerecha();
            }
            Auxiliar=Origen.getAbajo();
        }
        System.out.println(Origenes.toString());
        return Origenes;
    }
}

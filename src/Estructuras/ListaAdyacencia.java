package Estructuras;

import Variables.VariablesGlobales;

import java.io.*;

public class ListaAdyacencia
{

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
    public boolean IsEmpty()
    {
        return getInicioListaAdyacencia()==null;
    }
    public ListaAdyacenciaNodo ExisteOrigen(String Origen)
    {
        ListaAdyacenciaNodo Auxiliar=getInicioListaAdyacencia();//Inicio de la lista
        while(Auxiliar!=null){//recorre la lista inicial con los origenes
            if(Auxiliar.getOrigen().equals(Origen)){//si el origen existe retorna el nodo de origen
                return Auxiliar;
            }
            Auxiliar=Auxiliar.getAbajo();
        }
        return null;//si el origen existe retorna null
    }

    public boolean InsertarNodo(String Origen, String Destino, double TimepoRuta)
    {
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
            int ContadorNodo=0;
            while (Auxiliar!=null){
                ListaAdyacenciaNodo Origen=Auxiliar;
                pw.println("N"+ VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getOrigen())+" [label=\""+Auxiliar.getOrigen()+"\"];");
                Auxiliar=Auxiliar.getDerecha();
                ContadorNodo++;
                while (Auxiliar!=null){
                    pw.println("N"+ VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getDestino())+" [label=\""+Auxiliar.getDestino()+"\"];");
                    pw.println("N"+ VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getOrigen()) + " -> " + "N" + VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getDestino()) + " [label=\""+Auxiliar.getTiempoRuta()+"\"];");
                    Auxiliar=Auxiliar.getDerecha();
                    ContadorNodo++;
                }
                Auxiliar=Origen.getAbajo();
            }

            pw.println("}");
            fichero.close();
        } catch (Exception e) {

        }
    }
}

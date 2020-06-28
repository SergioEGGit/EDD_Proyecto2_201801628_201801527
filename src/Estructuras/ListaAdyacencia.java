package Estructuras;

import Metodos.GenerarReportes;
import Variables.VariablesGlobales;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

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

    boolean BuscarRutaAlterna(String Origen, String Destino){
        ListaAdyacenciaNodo Aux=getInicioListaAdyacencia();
        ListaAdyacenciaNodo Orig=null;
        while (Aux!=null){
            Orig=Aux;
            if(Destino.equals(Aux.getOrigen())){
                Aux=Aux.getDerecha();
                while (Aux!=null){
                    if(Aux.getDestino().equals(Origen)){
                        return true;
                    }
                    Aux=Aux.getDerecha();
                }
                return false;
            }
            Aux=Orig.getAbajo();
        }
        return false;
    }

    public boolean InsertarNodo(String Origen, String Destino, double TimepoRuta)
    {
        boolean RutaAlterna=BuscarRutaAlterna(Origen,Destino);
        if(Origen.equals(Destino)){//RutaAlterna==true
            JOptionPane.showMessageDialog(null,"Existe una ruta alterna identica","Ruta Alterna",JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
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

    public void GenerarGrafoRutas()
    {
        String Cadena="";
        Cadena+="digraph G {\n";
        Cadena+="node [margin=0 shape=circle style = filled fillcolor=\"#967373\"];\n";
        //Cadena+="edge [arrowhead=none,arrowtail=none];\n";
        ListaAdyacenciaNodo Auxiliar=getInicioListaAdyacencia();
        while (Auxiliar!=null){
            ListaAdyacenciaNodo Origen=Auxiliar;
            Cadena+="N"+ VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getOrigen())+" [label=\""+Auxiliar.getOrigen()+"\", xlabel=\"["+Auxiliar.getViendeDeNodo()+","+Auxiliar.getTiempoAcumulado()+"]\"];\n";
            Auxiliar=Auxiliar.getDerecha();
            while (Auxiliar!=null){
                Cadena+="N"+ VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getOrigen()) + " -> " + "N" + VariablesGlobales.MetodoGlobales.QuitarEspacios(Auxiliar.getDestino()) + " [label=\""+Auxiliar.getTiempoRuta()+"\"];\n";
                Auxiliar=Auxiliar.getDerecha();
            }
            Auxiliar=Origen.getAbajo();
        }
        Cadena+="}\n";
        GenerarReportes Reporte = new GenerarReportes("ReporteGrafoRutas", Cadena);
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



    void BuscarOrigen(String Origen,boolean MAX_MIN){
        ListaAdyacenciaNodo Auxiliar=getInicioListaAdyacencia();
        while(Auxiliar!=null){
            if(Auxiliar.getOrigen().equals(Origen)){
                CalcularTiempoAcumuladoMinimo(Auxiliar);
            }
            Auxiliar=Auxiliar.getAbajo();
        }
    }

    void CalcularTiempoAcumuladoMinimo(ListaAdyacenciaNodo Origen){
        ListaAdyacenciaNodo Destinos=Origen.getDerecha();
        while (Destinos!=null){
            ListaAdyacenciaNodo OrigenSig=ExisteOrigen(Destinos.getDestino());
            double TiempoNuevo=Origen.getTiempoAcumulado()+Destinos.getTiempoRuta();
            if(OrigenSig.getTiempoAcumulado()>TiempoNuevo){
                OrigenSig.setViendeDeNodo(Origen.getOrigen());
                OrigenSig.setTiempoAcumulado(TiempoNuevo);
                BuscarOrigen(OrigenSig.getOrigen(),false);
            }
            Destinos=Destinos.getDerecha();
        }
    }

    void ValoresDefault(){
        ListaAdyacenciaNodo Aux=getInicioListaAdyacencia();
        while (Aux!=null){
            Aux.setTiempoAcumulado(0.0);
            Aux.setViendeDeNodo(null);
            Aux=Aux.getAbajo();
        }
    }

    public void AlgoritmoDijkstra(){
        CrearOrigenesSinDestinos();
        Stack<String> Origenes=BuscarNodoInicial();
        ListaAdyacenciaNodo Aux=getInicioListaAdyacencia();
        String Orig="";
        ValoresDefault();
        Origenes=BuscarNodoInicial();
        for (int i=0;i<Origenes.size();i++){
            Orig=Origenes.get(i);
            Aux=getInicioListaAdyacencia();
            while (Aux!=null){
                if(Aux.getOrigen().equals(Orig)){
                    Aux.setTiempoAcumulado(0.0);
                }
                Aux=Aux.getAbajo();
            }
        }
        Orig="";
        while (!Origenes.empty()){
            Orig=Origenes.pop();
            BuscarOrigen(Orig,false);
        }
        Aux=getInicioListaAdyacencia();
        while (Aux!=null){
            CalcularTiempoAcumuladoMinimo(Aux);
            Aux=Aux.getAbajo();
        }

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

    boolean ExisteDestinoEnRuta(String[] Ruta,String Nombre){
        for (String Lugar: Ruta) {
            if(Lugar.equals(Nombre)){
                return true;
            }
        }
        return false;
    }

    String[] CalcRutaFavorable(String Origen,String Destino){
        if(Origen.equals(Destino)){
            JOptionPane.showMessageDialog(null,"EL ORIGEN Y EL DESTINO SON IGUALES","Error en ruta",JOptionPane.ERROR_MESSAGE);
        }else{
            String[] Ruta= CalcularRuta(Origen,Destino);
            if(Ruta!=null){
                String[] RutaConDistancias=new String[Ruta.length];
                double RutaAcumulada=0;
                int Indice=0;
                for (int i=0;i<Ruta.length;i++){
                    if(i==0){
                        RutaConDistancias[i]=Ruta[i]+","+RutaAcumulada;
                    }else{
                        ListaAdyacenciaNodo Aux=ExisteOrigen(Ruta[i-1]);
                        Aux=Aux.getDerecha();
                        while (Aux!=null){
                            if(Aux.getDestino().equals(Ruta[i])){
                                RutaAcumulada+=Aux.getTiempoRuta();
                                RutaConDistancias[i]=Ruta[i]+","+RutaAcumulada;
                            }
                            Aux=Aux.getDerecha();
                        }
                    }
                }
                for (int i=0;i<RutaConDistancias.length;i++){
                    System.out.println(RutaConDistancias[i]);
                }
                return RutaConDistancias;
            }else{
                return null;
            }
        }
        return null;
    }

    // Falta Arreglos en el metodo
    String[] CalcularRuta(String Origen,String Destino){
        String DES=Destino;
        String ORIG=Origen;
        Stack<String> Lugares=new Stack<String>();
        ListaAdyacenciaNodo Aux=null;
        do {
            Aux=ExisteOrigen(DES);
            if(Aux!=null){
                if(!Lugares.contains(DES)){
                    Lugares.push(DES);
                    DES=Aux.getViendeDeNodo();
                    if(DES==null && !Aux.getOrigen().equals(Origen)){
                        String LUG="";
                        for (int i=Lugares.size()-1;i>=0;i--){
                            LUG=","+Lugares.get(i);
                        }
                        if (JOptionPane.showConfirmDialog(null, "La ruta Encontrada de "+Origen+" a "+Destino+" ES:\n"+
                                        Aux.getOrigen()+LUG,
                                "Ruta Encontrada",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            //Lugares.push(Aux.getOrigen());
                            String[] LUGA=new String[Lugares.size()];
                            int i=0;
                            while (!Lugares.empty()) {
                                String Luga=Lugares.pop();
                                LUGA[i]=Luga;
                                i++;
                            }
                            return LUGA;
                        } else {
                            return null;
                        }
                    }
                }else{
                    String LUG="";
                    for (int i=Lugares.size()-1;i>=0;i--){
                        LUG=","+Lugares.get(i);
                    }
                    if (JOptionPane.showConfirmDialog(null, "La ruta Encontrada de "+Origen+" a "+Destino+" ES:\n"+
                                    Aux.getOrigen()+LUG,
                                "Ruta Encontrada",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        //Lugares.push(Aux.getOrigen());
                        String[] LUGA=new String[Lugares.size()];
                        int i=0;
                        while (!Lugares.empty()) {
                            String Luga=Lugares.pop();
                            LUGA[i]=Luga;
                            i++;
                        }
                        return LUGA;
                    } else {
                        return null;
                    }
                }
            }
        }while (!DES.equals(ORIG));
        Lugares.push(Origen);
        String[] LUG=new String[Lugares.size()];
        int i=0;
        while (!Lugares.empty()) {
            String Luga=Lugares.pop();
            System.out.println(Luga);
            LUG[i]=Luga;
            i++;
        }
        return LUG;
    }

    public void Eliminar(String Origen,String Destino){
        ListaAdyacenciaNodo Aux=ExisteOrigen(Origen);
        ListaAdyacenciaNodo Anterior=Aux;
        Aux=Aux.getDerecha();
        while (Aux!=null){
            if(Destino.equals(Aux.getDestino())){
                Anterior.setDerecha(Aux.getDerecha());
                break;
            }
            Anterior=Aux;
            Aux=Aux.getDerecha();
        }
        AlgoritmoDijkstra();
    }


    public ArrayList<String> TodosLosOrigenes(){
        ListaAdyacenciaNodo Aux=getInicioListaAdyacencia();
        ArrayList<String> Origenes=new ArrayList<String>();
        while (Aux!=null){
            Origenes.add(Aux.getOrigen());
            Aux=Aux.getAbajo();
        }
        return Origenes;
    }


}

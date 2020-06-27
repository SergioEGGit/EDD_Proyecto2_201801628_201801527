package Estructuras;

import Metodos.CargaMasiva;
import Metodos.GenerarReportes;
import Modelos.ModeloVehiculo;
import Variables.VariablesGlobales;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Stack;

public class ArbolBAutos {

    private ArbolBAutosNodo InicioArbolBVehiculos;
    private int OrdenArbol=VariablesGlobales.Orden_ArbolB-1;

    //Constructor Vacio
    public ArbolBAutos() {
        Stack<String> NOMBRE=new Stack<String>();
        NOMBRE.push("1");
        NOMBRE.push("2");
        NOMBRE.push("4");
        NOMBRE.push("5");
        NOMBRE.insertElementAt("3",2);
        System.out.println("i++");
        for (int i=0;i<NOMBRE.size();i++){
            System.out.println(NOMBRE.get(i));//empieza en 1 y termina en 5
        }
        System.out.println("i--");
        for (int i=NOMBRE.size()-1;i>=0;i--){
            System.out.println(NOMBRE.get(i));
        }
        System.out.println(5/2);
    }

    //Set's & Get's
    public ArbolBAutosNodo getInicioArbolBVehiculos() { return InicioArbolBVehiculos; }

    public void setInicioArbolBVehiculos(ArbolBAutosNodo inicioArbolBVehiculos) { InicioArbolBVehiculos = inicioArbolBVehiculos; }

    void DividirYUnirHoja(ArbolBAutosNodo Padre,ArbolBAutosNodo HojaDividir,int IndiceHijo){
        ArbolBAutosNodo Derecha=new ArbolBAutosNodo();
        ArbolBAutosNodo Izquierda=new ArbolBAutosNodo();
        int MitadVehiculo=VariablesGlobales.Orden_ArbolB/2;
        //Llenar Izquierda Vehiculos
        for (int i=0;i<MitadVehiculo;i++){
            Izquierda.getVehiculos().push(HojaDividir.getVehiculos().get(i));
        }
        //Llenar Derecha Vehiculos
        for (int i=MitadVehiculo+1;i<VariablesGlobales.Orden_ArbolB;i++){
            Derecha.getVehiculos().push(HojaDividir.getVehiculos().get(i));
        }
        if(!HojaDividir.getHijos().empty()){
            //Llenar Izquierda Hijos
            for (int i=0;i<=MitadVehiculo;i++){
                Izquierda.getHijos().push(HojaDividir.getHijos().get(i));
            }
            //Llenar Derecha Hijos
            for (int i=MitadVehiculo+1;i<=VariablesGlobales.Orden_ArbolB;i++){
                Derecha.getHijos().push(HojaDividir.getHijos().get(i));
            }
        }
        Padre.getVehiculos().insertElementAt(HojaDividir.getVehiculos().get(MitadVehiculo),IndiceHijo);
        Padre.getHijos().removeElementAt(IndiceHijo);
        try{
            Padre.getHijos().insertElementAt(Izquierda,IndiceHijo);
        }catch (Exception E){
            Padre.getHijos().push(Izquierda);
        }
        try{
            Padre.getHijos().insertElementAt(Derecha,IndiceHijo+1);
        }catch (Exception E){
            Padre.getHijos().push(Derecha);
        }
    }

    boolean CasosInsercion(ArbolBAutosNodo Hoja, ModeloVehiculo Vehiculo){
        String Placa="",PlacaSig="";
        ArbolBAutosNodo Auxiliar=Hoja;
        if(Auxiliar.getHijos().empty()){
            int CantidadClaves=Auxiliar.getVehiculos().size();
            for(int i=0;i<CantidadClaves;i++){
                Placa=Auxiliar.getVehiculos().get(i).getPlaca();
                if(Vehiculo.getPlaca().compareTo(Placa)==0){ return false; }
                else if(Vehiculo.getPlaca().compareTo(Placa)<0 && i==0){
                    Auxiliar.getVehiculos().insertElementAt(Vehiculo,i);
                    return true;
                }else if(i+1<CantidadClaves){
                    PlacaSig=Auxiliar.getVehiculos().get(i+1).getPlaca();
                    if(PlacaSig.compareTo(Vehiculo.getPlaca())==0){return  false;}
                    else if(Vehiculo.getPlaca().compareTo(Placa)>0){
                        if(Vehiculo.getPlaca().compareTo(PlacaSig)<0){
                            Auxiliar.getVehiculos().insertElementAt(Vehiculo,i+1);
                            return true;
                        }
                    }
                }else if(i==CantidadClaves-1){
                    if(Vehiculo.getPlaca().compareTo(Placa)>0){
                        Auxiliar.getVehiculos().push(Vehiculo);
                        return true;
                    }else if(Vehiculo.getPlaca().compareTo(Placa)<0){
                        Auxiliar.getVehiculos().insertElementAt(Vehiculo,i);
                        return true;
                    }
                }
            }
        }else{
            int CantidadClaves=Auxiliar.getVehiculos().size();
            //Verificar que en la pagina hacia que hijo dirigirse
            for(int i=0;i<CantidadClaves;i++){
                Placa=Auxiliar.getVehiculos().get(i).getPlaca();
                if(Vehiculo.getPlaca().compareTo(Placa)==0){ return false; }
                else if(i==0 && Vehiculo.getPlaca().compareTo(Placa)<0){
                    //La placa del vehiculo es menor a la del primer vehiculo en la pagina se dirije a hijo 0
                    if(Auxiliar.getHijos().get(i)!=null){
                        boolean Agregado=CasosInsercion(Auxiliar.getHijos().get(i),Vehiculo);
                        //Verificar cuantos hijos tiene la Hoja/Pagina Mandada luego de terminar de agregar
                        if(Auxiliar.getHijos().get(i).getVehiculos().size()==VariablesGlobales.Orden_ArbolB){
                            DividirYUnirHoja(Auxiliar,Auxiliar.getHijos().get(i),i);
                        }
                        return  Agregado;
                    }
                }else if(i+1<CantidadClaves){
                    PlacaSig=Auxiliar.getVehiculos().get(i+1).getPlaca();
                    if(PlacaSig.compareTo(Vehiculo.getPlaca())==0){return  false;}
                    else if(Vehiculo.getPlaca().compareTo(Placa)>0){
                        if(Vehiculo.getPlaca().compareTo(PlacaSig)<0){
                            if(Auxiliar.getHijos().get(i+1)!=null){
                                boolean Agregado=CasosInsercion(Auxiliar.getHijos().get(i+1),Vehiculo);
                                //Verificar cuantos hijos tiene la Hoja/Pagina Mandada luego de terminar de agregar
                                if(Auxiliar.getHijos().get(i+1).getVehiculos().size()==VariablesGlobales.Orden_ArbolB){
                                    DividirYUnirHoja(Auxiliar,Auxiliar.getHijos().get(i+1),i+1);
                                }
                                return  Agregado;
                            }
                        }
                    }
                }else if(i==CantidadClaves-1){
                    if(Vehiculo.getPlaca().compareTo(Placa)>0){
                        if(Auxiliar.getHijos().get(i+1)!=null){
                            boolean Agregado=CasosInsercion(Auxiliar.getHijos().get(i+1),Vehiculo);
                            //Verificar cuantos hijos tiene la Hoja/Pagina Mandada luego de terminar de agregar
                            if(Auxiliar.getHijos().get(i+1).getVehiculos().size()==VariablesGlobales.Orden_ArbolB){
                                DividirYUnirHoja(Auxiliar,Auxiliar.getHijos().get(i+1),i+1);
                            }
                            return  Agregado;
                        }
                    }else if(Vehiculo.getPlaca().compareTo(Placa)<0){
                        if (Auxiliar.getHijos().get(i)!=null){
                            boolean Agregado=CasosInsercion(Auxiliar.getHijos().get(i),Vehiculo);
                            //Verificar cuantos hijos tiene la Hoja/Pagina Mandada luego de terminar de agregar
                            if(Auxiliar.getHijos().get(i).getVehiculos().size()==VariablesGlobales.Orden_ArbolB){
                                DividirYUnirHoja(Auxiliar,Auxiliar.getHijos().get(i),i);
                            }
                            return  Agregado;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean AgregarVehiculo(ModeloVehiculo Vehiculo){
        ArbolBAutosNodo Auxiliar=getInicioArbolBVehiculos();
        if(Auxiliar==null){
            Auxiliar=new ArbolBAutosNodo();
            Auxiliar.getVehiculos().push(Vehiculo);
            setInicioArbolBVehiculos(Auxiliar);
            return true;
        }else{
            boolean Agregado=CasosInsercion(Auxiliar,Vehiculo);
            if(Agregado==true){
                if(Auxiliar.getVehiculos().size()==VariablesGlobales.Orden_ArbolB){
                    ArbolBAutosNodo NuevaRaiz=new ArbolBAutosNodo();
                    int Index=VariablesGlobales.Orden_ArbolB/2;
                    ModeloVehiculo VehiculoEnmedio=Auxiliar.getVehiculos().get(Index);
                    NuevaRaiz.getVehiculos().push(VehiculoEnmedio);
                    ArbolBAutosNodo Derecha=new ArbolBAutosNodo();//->
                    ArbolBAutosNodo Izquierda=new ArbolBAutosNodo();//<-
                    for(int i=0;i<Index;i++){
                        Izquierda.getVehiculos().push(Auxiliar.getVehiculos().get(i));
                    }
                    for(int i=Index+1;i<VariablesGlobales.Orden_ArbolB;i++){
                        Derecha.getVehiculos().push(Auxiliar.getVehiculos().get(i));
                    }
                    try {
                        for(int i=0;i<Auxiliar.getHijos().size()/2;i++){
                            Izquierda.getHijos().push(Auxiliar.getHijos().get(i));
                        }
                        for(int i=Auxiliar.getHijos().size()/2;i<Auxiliar.getHijos().size();i++){
                            Derecha.getHijos().push(Auxiliar.getHijos().get(i));
                        }
                    }catch (Exception E){}
                    NuevaRaiz.getHijos().push(Izquierda);
                    NuevaRaiz.getHijos().push(Derecha);
                    setInicioArbolBVehiculos(NuevaRaiz);
                }
            }
            return Agregado;
        }
    }

    ModeloVehiculo Busqueda_Recursiva(ArbolBAutosNodo Hoja,String PlacaB){
        ArbolBAutosNodo Aux=Hoja;
        String Placa="",PlacaSig="";
        int CantidadVehiculos=Hoja.getVehiculos().size();
        for (int i=0;i<CantidadVehiculos;i++){
            Placa=Hoja.getVehiculos().get(i).getPlaca();
            if(PlacaB.compareTo(Placa)==0){
                return Hoja.getVehiculos().get(i);
            }
            else if(PlacaB.compareTo(Placa)<0 && i==0){
                if(!Hoja.getHijos().empty()){
                    if(Hoja.getHijos().get(i)!=null){
                        return Busqueda_Recursiva(Hoja.getHijos().get(i),PlacaB);
                    }
                }else{
                    return null;
                }
            }else if(i+1<CantidadVehiculos){
                PlacaSig=Hoja.getVehiculos().get(i+1).getPlaca();
                if(PlacaB.compareTo(PlacaSig)==0){
                    return Hoja.getVehiculos().get(i+1);
                }
                else if(PlacaB.compareTo(Placa)>0){
                    if(PlacaB.compareTo(PlacaSig)<0){
                        if(!Hoja.getHijos().empty()){
                            if(Hoja.getHijos().get(i+1)!=null){
                                return Busqueda_Recursiva(Hoja.getHijos().get(i+1),PlacaB);
                            }
                        }else{
                            return null;
                        }
                    }
                }
            }else if(i==CantidadVehiculos-1){
                if(Placa.compareTo(PlacaB)==0){
                    return Hoja.getVehiculos().get(i);
                }else if(PlacaB.compareTo(Placa)>0){
                    if(!Hoja.getHijos().empty()){
                        if(Hoja.getHijos().get(i+1)!=null){
                            return Busqueda_Recursiva(Hoja.getHijos().get(i+1),PlacaB);
                        }
                    }else{
                        return null;
                    }
                }else if(PlacaB.compareTo(Placa)<0){
                    if(!Hoja.getHijos().empty()){
                        if(Hoja.getHijos().get(i)!=null){
                            return Busqueda_Recursiva(Hoja.getHijos().get(i),PlacaB);
                        }
                    }else{
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public ModeloVehiculo BuscarVehiculoNodo(String Placa){
        if(getInicioArbolBVehiculos()!=null){
            ModeloVehiculo Automovil=Busqueda_Recursiva(getInicioArbolBVehiculos(),Placa);
            return Automovil;
        }else{
            JOptionPane.showMessageDialog(null,"El Arbol B se encuentra vacio","Estructura vacia",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public boolean BuscarVehiculoBoolean(String Placa){
        if(getInicioArbolBVehiculos()!=null){
            ModeloVehiculo Automovil=Busqueda_Recursiva(getInicioArbolBVehiculos(),Placa);
            if(Automovil!=null){return true;}
            else{return  false;}
        }else{
            JOptionPane.showMessageDialog(null,"El Arbol B se encuentra vacio","Estructura vacia",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    void MayorDeLosMenores(ArbolBAutosNodo Hoja, ModeloVehiculo Vehiculo){
        if(!Hoja.getHijos().empty()){
            MayorDeLosMenores(Hoja.getHijos().get(Hoja.getVehiculos().size()-1),Vehiculo);
            //Verificar Cuantos hijos
        }else{
            ModeloVehiculo May_Men=Hoja.getVehiculos().get(Hoja.getVehiculos().size()-1);
            Vehiculo.setPlaca(May_Men.getPlaca());
            Vehiculo.setMarca(May_Men.getMarca());
            Vehiculo.setAnio(May_Men.getAnio());
            Vehiculo.setColor(May_Men.getColor());
            Vehiculo.setModelo(May_Men.getModelo());
            Vehiculo.setPrecio(May_Men.getPrecio());
            Vehiculo.setTipoTransmicion(May_Men.isTipoTransmicion());
            Hoja.getVehiculos().removeElementAt(Hoja.getVehiculos().size()-1);
        }
    }

    void UnirPaginas(ArbolBAutosNodo Padre,int HijoModificado){
        ArbolBAutosNodo Aux=Padre;
        int Minimos=VariablesGlobales.Orden_ArbolB/2;
        try{
            ArbolBAutosNodo HIzquierdo=Aux.getHijos().get(HijoModificado);
            ArbolBAutosNodo HDerecho=Aux.getHijos().get(HijoModificado+1);
            if(HIzquierdo.getVehiculos().size()<Minimos && HDerecho.getVehiculos().size()==Minimos){
                HIzquierdo.getVehiculos().push(Padre.getVehiculos().pop());
                Padre.getHijos().pop();
                for (ModeloVehiculo Vehiculo:HDerecho.getVehiculos()) {
                    HIzquierdo.getVehiculos().push(Vehiculo);
                }
                for (ArbolBAutosNodo Hijo:HDerecho.getHijos()){
                    HIzquierdo.getHijos().push(Hijo);
                }
            }
        }catch (Exception E){
            ArbolBAutosNodo HIzquierdo=Aux.getHijos().get(HijoModificado-1);
            ArbolBAutosNodo HDerecho=Aux.getHijos().get(HijoModificado);
        }
    }

    boolean CasosEliminacion(ArbolBAutosNodo Hoja,String PlacaE){
        ArbolBAutosNodo Aux=Hoja;
        String Placa="",PlacaSig="";
        int CantidadVehiculo=Aux.getVehiculos().size();
        for(int i=0;i<CantidadVehiculo;i++){
            Placa=Aux.getVehiculos().get(i).getPlaca();
            if(!Aux.getHijos().empty()){
                if(PlacaE.compareTo(Placa)==0){
                    //Eliminar
                    MayorDeLosMenores(Aux.getHijos().get(i),Aux.getVehiculos().get(i));
                    UnirPaginas(Aux,i);
                    return true;
                }
                else if(i==0 && PlacaE.compareTo(Placa)<0){
                    boolean Eliminado=CasosEliminacion(Aux.getHijos().get(i),PlacaE);
                    //Verificar que las claves sean mayores a las minimas
                    UnirPaginas(Aux,i);
                    return Eliminado;
                }
                else if(i+1<CantidadVehiculo){
                    PlacaSig=Aux.getVehiculos().get(i+1).getPlaca();
                    if(PlacaE.compareTo(Placa)>0){
                        if(PlacaE.compareTo(PlacaSig)<0){
                            boolean Eliminado=CasosEliminacion(Aux.getHijos().get(i+1),PlacaE);
                            //Verificar que las claves sean mayores a las minimas
                            UnirPaginas(Aux,i+1);
                            return Eliminado;
                        }
                    }
                }else if(i==CantidadVehiculo-1){
                    if(PlacaE.compareTo(Placa)<0){
                        boolean Eliminado=CasosEliminacion(Aux.getHijos().get(i),PlacaE);
                        UnirPaginas(Aux,i);
                        //Verificar que las claves sean mayores a las minimas
                        return Eliminado;
                    }
                    else if(PlacaE.compareTo(Placa)>0){
                        boolean Eliminado=CasosEliminacion(Aux.getHijos().get(i+1),PlacaE);
                        UnirPaginas(Aux,i+1);
                        //Verificar que las claves sean mayores a las minimas
                        return Eliminado;
                    }
                }
                //Metodo Recursivo
            }else{
                if(PlacaE.compareTo(Placa)==0){
                    Aux.getVehiculos().removeElementAt(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean EliminarVehiculo(String PlacaE){
        ArbolBAutosNodo Aux=getInicioArbolBVehiculos();
        String Placa="",PlacaSig="";
        int CantidadVehiculo=Aux.getVehiculos().size();
        for(int i=0;i<CantidadVehiculo;i++){
            Placa=Aux.getVehiculos().get(i).getPlaca();
            if(!Aux.getHijos().empty()){
                if(PlacaE.compareTo(Placa)==0){
                    //Eliminar
                    MayorDeLosMenores(Aux.getHijos().get(i),Aux.getVehiculos().get(i));
                    UnirPaginas(Aux,i);
                    return true;
                }
                else if(i==0 && PlacaE.compareTo(Placa)<0){
                    boolean Eliminado=CasosEliminacion(Aux.getHijos().get(i),PlacaE);
                    UnirPaginas(Aux,i);
                    //Verificar que las claves sean mayores a las minimas
                    return Eliminado;
                }
                else if(i+1<CantidadVehiculo){
                    PlacaSig=Aux.getVehiculos().get(i+1).getPlaca();
                    if(PlacaE.compareTo(Placa)>0){
                        if(PlacaE.compareTo(PlacaSig)<0){
                            boolean Eliminado=CasosEliminacion(Aux.getHijos().get(i+1),PlacaE);
                            UnirPaginas(Aux,i+1);
                            //Verificar que las claves sean mayores a las minimas
                            return Eliminado;
                        }
                    }
                }else if(i==CantidadVehiculo-1){
                    if(PlacaE.compareTo(Placa)<0){
                        boolean Eliminado=CasosEliminacion(Aux.getHijos().get(i),PlacaE);
                        UnirPaginas(Aux,i);
                        //Verificar que las claves sean mayores a las minimas
                        return Eliminado;
                    }
                    else if(PlacaE.compareTo(Placa)>0){
                        boolean Eliminado=CasosEliminacion(Aux.getHijos().get(i+1),PlacaE);
                        UnirPaginas(Aux,i+1);
                        //Verificar que las claves sean mayores a las minimas
                        return Eliminado;
                    }
                }
                //Metodo Recursivo
            }else{
                if(PlacaE.compareTo(Placa)==0){
                    Aux.getVehiculos().removeElementAt(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void ImprimirArbol(){
        //MetRecursivoImpresion(getInicioArbolBVehiculos());
        //GenerarReporteArbolB();
    }

    void MetRecursivoImpresion(ArbolBAutosNodo Hoja){
        System.out.println(Hoja.getVehiculos().toString());
       for(int i=0;i<Hoja.getHijos().size();i++){
           MetRecursivoImpresion(Hoja.getHijos().get(i));
       }
    }

    String EstructuraArbolB="";

    void EstrucArbolB(ArbolBAutosNodo Hoja){
        int Contador=0;
        String NombrePadre="N"+Hoja.getNumeroHoja();
        EstructuraArbolB+=NombrePadre+" [label = \"";
        for (ModeloVehiculo Vehiculo:Hoja.getVehiculos()) {
            EstructuraArbolB+="<f"+Contador+">";
            EstructuraArbolB+=" |";
            EstructuraArbolB+="Placa: "+Vehiculo.getPlaca()+" \\n ";
            EstructuraArbolB+="Marca: "+Vehiculo.getMarca()+" \\n ";
            EstructuraArbolB+="Modelo: "+Vehiculo.getModelo()+" \\n ";
            EstructuraArbolB+="Año: "+Vehiculo.getAnio()+" \\n ";
            EstructuraArbolB+="Color: "+Vehiculo.getColor()+" \\n ";
            EstructuraArbolB+="Precio: "+Vehiculo.getPrecio()+" \\n ";
            if(Vehiculo.isTipoTransmicion()==true){
                EstructuraArbolB+="Trasmicion: Mecanica \\n ";
            }else{
                EstructuraArbolB+="Trasmicion: Automatica \\n ";
            }
            EstructuraArbolB+=" |";
            Contador++;
        }
        if(Contador>0){
            EstructuraArbolB+="<f"+Contador+">";
        }
        EstructuraArbolB+="\"]\n";
        Contador=0;
        String NombreHijo="";
        for (ArbolBAutosNodo Hijos: Hoja.getHijos()) {
            EstrucArbolB(Hijos);
            NombreHijo="N"+Hijos.getNumeroHoja();
            EstructuraArbolB+="\""+NombrePadre+"\": f"+Contador+" -> "+NombreHijo+";\n";
            Contador++;
        }
    }

    public void GenerarReporteArbolB(){
        ArbolBAutosNodo Aux=getInicioArbolBVehiculos();
        String Cadena="";
        Cadena+="digraph g {\n";
        Cadena+="node [shape = record,height=.1];\n";
        if(Aux!=null){
            EstructuraArbolB="";
            EstrucArbolB(Aux);
            Cadena+=EstructuraArbolB;
        }
        Cadena+="}\n";
        GenerarReportes Reporte = new GenerarReportes("ReporteArbolBVehiculos", Cadena);
    }

    private ArrayList<ModeloVehiculo> Vehiculos=new ArrayList<ModeloVehiculo>();

    public ArrayList<ModeloVehiculo> TodosLosVehiculos(){
        this.Vehiculos.clear();
        if(getInicioArbolBVehiculos()!=null){
            RecuperarTodosVehiculosArbolB(getInicioArbolBVehiculos());
        }
        return this.Vehiculos;
    }

    void RecuperarTodosVehiculosArbolB(ArbolBAutosNodo Hoja){
        int NumeroClave=0;
        if(!Hoja.getHijos().empty()){
            for (ArbolBAutosNodo Hijo:Hoja.getHijos()) {
                RecuperarTodosVehiculosArbolB(Hijo);
                try {
                    this.Vehiculos.add(Hoja.getVehiculos().get(NumeroClave));
                }catch (Exception E){}
                NumeroClave++;
            }
        }else{
            for (ModeloVehiculo Auto:Hoja.getVehiculos()) {
                this.Vehiculos.add(Auto);
            }
        }
    }

    public void CargaMasiva(){
        ArbolBAutos V= VariablesGlobales.ArbolBAutomoviles;
        CargaMasiva CMVehiculo=new CargaMasiva();
        CMVehiculo.CargaMasiva(';',':',"txt","VEHICULOS",7);
        int contadorAgregados=0;
        boolean TipoTransmision=false;
        for (String[] Vehiculos:VariablesGlobales.ItemsArchivo) {
            try {
                if(VariablesGlobales.MetodoGlobales.QuitarAcento(Vehiculos[6].trim().toUpperCase()).equals("AUTOMATICO")){
                    TipoTransmision=false;
                }
                else{
                    TipoTransmision=true;
                }
                ModeloVehiculo NuevoVehiculo=new ModeloVehiculo(Vehiculos[0].trim().toUpperCase(),//Placa
                        Vehiculos[1].trim().toUpperCase(),//Marca
                        Vehiculos[2].trim().toUpperCase(),//Modelo
                        Integer.parseInt(Vehiculos[3].trim().toUpperCase()),//Anio
                        Vehiculos[4].trim().toUpperCase(),//Color
                        Double.parseDouble(Vehiculos[5].trim().toUpperCase()),//Precio
                        TipoTransmision);//Transmicion
                boolean Agregado=V.AgregarVehiculo(NuevoVehiculo);
                if(Agregado==true){contadorAgregados++;}
                else{
                    JOptionPane.showMessageDialog(null,
                            "No Se agrego con exito \n"+
                                    "Placa: "+Vehiculos[0].trim().toUpperCase()+"\n"+
                                    "Marca: "+Vehiculos[1].trim().toUpperCase()+"\n"+
                                    "Modelo: "+Vehiculos[2].trim().toUpperCase()+"\n"+
                                    "Año: "+Vehiculos[3].trim().toUpperCase()+"\n"+
                                    "Color: "+Vehiculos[4].trim().toUpperCase()+"\n"+
                                    "Precio: "+Vehiculos[5].trim().toUpperCase()+"\n"+
                                    "Transmision: "+Vehiculos[6].trim().toUpperCase()+"\n"+
                                    "No se agrego con exito la placa se encuentra asignada a otro vehiculo",
                            "Error Al Agregar",JOptionPane.ERROR_MESSAGE);
                }
            }catch (Exception E){
                JOptionPane.showMessageDialog(null,
                        "No Se agrego con exito \n"+
                                "Placa: "+Vehiculos[0].trim().toUpperCase()+"\n"+
                                "Marca: "+Vehiculos[1].trim().toUpperCase()+"\n"+
                                "Modelo: "+Vehiculos[2].trim().toUpperCase()+"\n"+
                                "Año: "+Vehiculos[3].trim().toUpperCase()+"\n"+
                                "Color: "+Vehiculos[4].trim().toUpperCase()+"\n"+
                                "Precio: "+Vehiculos[5].trim().toUpperCase()+"\n"+
                                "Transmision: "+Vehiculos[6].trim().toUpperCase()+"\n"+
                                "Verifique que todos los datos sean correcto",
                        "Error Al Agregar",JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null,"Se agregaron "+contadorAgregados+" Vehiculos con exito","Carga Masiva Exitosa",JOptionPane.INFORMATION_MESSAGE);
    }


}

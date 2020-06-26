package Estructuras;

import Metodos.GenerarReportes;
import Modelos.ModeloVehiculo;
import Variables.VariablesGlobales;

import javax.swing.*;
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

    public boolean EliminarVehiculo(String PlacaE){
        
        return false;
    }

    public void ImprimirArbol(){
        MetRecursivoImpresion(getInicioArbolBVehiculos());
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

}

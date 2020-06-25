package Estructuras;

import Modelos.ModeloVehiculo;
import Variables.VariablesGlobales;

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

    boolean AgregarVehiculoAHoja(ArbolBAutosNodo Hoja, ModeloVehiculo Vehiculo){
        return false;
    }

    boolean CasosInsercion(ArbolBAutosNodo Hoja, ModeloVehiculo Vehiculo){
        String Placa="",PlacaSig="";
        ArbolBAutosNodo Auxiliar=Hoja;
        if(Auxiliar.getHijos().empty()){
            int CantidadClaves=Auxiliar.getVehiculos().size();
            for(int i=0;i<CantidadClaves;i++){
                Placa=Auxiliar.getVehiculos().get(i).getPlaca();
                if(Vehiculo.getPlaca().compareTo(Placa)<0 && i==0){
                    Auxiliar.getVehiculos().insertElementAt(Vehiculo,i);
                    return true;
                }else if(i+1<CantidadClaves){
                    PlacaSig=Auxiliar.getVehiculos().get(i+1).getPlaca();
                    if(Vehiculo.getPlaca().compareTo(Placa)>0){
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
                }else if(Vehiculo.getPlaca().compareTo(Placa)==0){ return false; }
            }
        }else{
            //Verificar que en la pagina hacia que hijo dirigirse
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

    public void ImprimirArbol(){
        System.out.println(getInicioArbolBVehiculos().getVehiculos().toString());
        for (ArbolBAutosNodo Nodo:getInicioArbolBVehiculos().getHijos()) {
            System.out.println(Nodo.getVehiculos().toString());
        }
    }

}

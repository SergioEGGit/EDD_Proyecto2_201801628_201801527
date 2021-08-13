package Estructuras;

import Modelos.ModeloVehiculo;
import Variables.VariablesGlobales;

import java.util.Stack;

public class ArbolBAutosNodo {

    private int Orden;
    private Stack<ModeloVehiculo> Vehiculos;
    private Stack<ArbolBAutosNodo> Hijos;
    private int NumeroHoja;

    public ArbolBAutosNodo() {
        this.setVehiculos(new Stack<ModeloVehiculo>());
        this.setHijos(new Stack<ArbolBAutosNodo>());
        this.setOrden(VariablesGlobales.Orden_ArbolB);
        this.NumeroHoja=VariablesGlobales.NumeroHoja;
        VariablesGlobales.NumeroHoja++;
    }

    // Set's & Get's

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int orden) {
        Orden = orden;
    }

    public Stack<ModeloVehiculo> getVehiculos() {
        return Vehiculos;
    }

    public void setVehiculos(Stack<ModeloVehiculo> vehiculos) {
        Vehiculos = vehiculos;
    }

    public Stack<ArbolBAutosNodo> getHijos() {
        return Hijos;
    }

    public void setHijos(Stack<ArbolBAutosNodo> hijos) {
        Hijos = hijos;
    }

    public int getNumeroHoja() {
        return NumeroHoja;
    }

    public void setNumeroHoja(int numeroHoja) {
        NumeroHoja = numeroHoja;
    }
}

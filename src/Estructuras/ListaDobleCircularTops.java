
//-----------------------------------------------Paquetes E Imports-----------------------------------------------------

    package Estructuras;

//---------------------------------------------------Principal----------------------------------------------------------

import javax.swing.*;
import java.util.jar.JarOutputStream;

public class ListaDobleCircularTops
    {
        //Atributos
        private ListaDobleCircularTopsNodo ListaDobleInicio;

        //Métodos

        //Get Inicio Lista

        public ListaDobleCircularTopsNodo getListaDobleInicio()
        {
            return ListaDobleInicio;
        }

        //Set Inicio Lista

        public void setListaDobleInicio(ListaDobleCircularTopsNodo listaDobleInicio)
        {
            ListaDobleInicio = listaDobleInicio;
        }

        //Inserción

        //Insertar Nuevo Top

        public void InsertarTopFinalListaDobleCircularC(String Nombre, int Cantidad)
        {
            //Declaraciones

            //Nuevo Nodo Lista Simple
            ListaDobleCircularTopsNodo NuevoNodoTops = new ListaDobleCircularTopsNodo(Nombre, Cantidad);

            //Verificar Si La Lista Esta Vacia

            if(getListaDobleInicio() == null)
            {
                //Agrego Al Inicio

                NuevoNodoTops.setSgte(NuevoNodoTops);
                NuevoNodoTops.setAnte(NuevoNodoTops);
                setListaDobleInicio(NuevoNodoTops);
            }
            else
            {
                //Agrego Al Final

                ListaDobleCircularTopsNodo Auxiliar = getListaDobleInicio();

                while(Auxiliar.getSgte() != getListaDobleInicio())
                {
                    Auxiliar = Auxiliar.getSgte();
                }

                Auxiliar.setSgte(NuevoNodoTops);
                NuevoNodoTops.setAnte(Auxiliar);
                NuevoNodoTops.setSgte(getListaDobleInicio());
                getListaDobleInicio().setAnte(NuevoNodoTops);
            }
        }

        //Ordenamientos

        //Ordenamiento Burbuja Lista Doble

        public void OrdenamientoBurbujaListaDobleCircularT()
        {
            //Declaraciones

            //Auxiliares Lista Doble Circular

            ListaDobleCircularTopsNodo Primero;
            ListaDobleCircularTopsNodo Segundo;

            //Variables Tipo String

            String Nombre;
            int Cantidad;

            //Asignacion Variables

            Primero = getListaDobleInicio();

            if(getListaDobleInicio() != null)
            {
                while(Primero.getSgte() != getListaDobleInicio())
                {
                    //Asignacion Segundo

                    Segundo = Primero.getSgte();

                    //Comienzo Valor A Comparar

                    while(Segundo != getListaDobleInicio())
                    {
                        if(Primero.getCantidad() < Segundo.getCantidad())
                        {
                            Nombre = Segundo.getNombre();
                            Cantidad = Segundo.getCantidad();

                            //Segundos
                            Segundo.setNombre(Primero.getNombre());
                            Segundo.setCantidad(Primero.getCantidad());

                            //Primeros
                            Primero.setNombre(Nombre);
                            Primero.setCantidad(Cantidad);
                        }
                        Segundo = Segundo.getSgte();
                    }
                    Primero = Primero.getSgte();
                }
            }
        }

        //Busqueda

        //Buscar Top

        public ListaDobleCircularTopsNodo BuscarTopListaDobleCircularT(String Nombre)
        {
            //Declaraciones

            //Auxiliar Lista Doble

            ListaDobleCircularTopsNodo Auxiliar = getListaDobleInicio();

            do
            {
                if(Nombre.equals(Auxiliar.getNombre()))
                {
                    return Auxiliar;
                }
                Auxiliar = Auxiliar.getSgte();
            }
            while(Auxiliar != getListaDobleInicio());

            return null;
        }

        //Recorrer

        public String GenerarTopViajesLargos()
        {
            //Declaraciones

            ListaDobleCircularTopsNodo Auxiliar = getListaDobleInicio();

            int ContadorAuxiliar = 1;

            String Cadena = "";

            if(getListaDobleInicio() != null)
            {
                do
                {
                    if(ContadorAuxiliar <= 10)
                    {
                        Cadena += "Viaje " + ContadorAuxiliar + ": " + Auxiliar.getNombre() + " Cantidad De Destinos: " + Auxiliar.getCantidad() + "\n";
                    }
                    ContadorAuxiliar++;

                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getListaDobleInicio());
            }

            return Cadena;
        }
    }

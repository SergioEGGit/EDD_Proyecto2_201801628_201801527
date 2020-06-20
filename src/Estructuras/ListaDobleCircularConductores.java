
//---------------------------------------------Paquetes E Importaciones-------------------------------------------------

    package Estructuras;

    import Modelos.ModeloConductores;
    import javax.swing.*;
    import java.util.ArrayList;

//---------------------------------------------------Principal----------------------------------------------------------

    public class ListaDobleCircularConductores
    {
        //Atributos
        private ListaDobleCircularConductoresNodo ListaDobleInicio;

        //Métodos

        //Get Inicio Lista

        public ListaDobleCircularConductoresNodo getListaDobleInicio()
        {
            return ListaDobleInicio;
        }

        //Set Inicio Lista

        public void setListaDobleInicio(ListaDobleCircularConductoresNodo listaDobleInicio)
        {
            ListaDobleInicio = listaDobleInicio;
        }

        //Tamaño Lista Circular

        private int SizeListaDobleCircularC()
        {
            //Declaraciones

            //Variable Tipo Lista Doble Circular

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            //Variables Tipo Int

            int Size = 0;

            if(Auxiliar != null)
            {
                do
                {
                    Size++;
                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getListaDobleInicio());
            }

            return Size;
        }

        //Inserción

        //Insertar Nuevo Conductor

        public void InsertarConductorFinalListaDobleCircularC(ModeloConductores NuevoConductor)
        {
            //Declaraciones
         
            //Variable Tipo Boolean

            boolean ExisteConductor = false;

            if(getListaDobleInicio() != null)
            {
                ExisteConductor = VerificarConductorListaDobleCircularC(NuevoConductor.getDPIConductor());
            }

            if(ExisteConductor)
            {
                JOptionPane.showMessageDialog(null, "El Conductor Indicado Ya Existe En El Sistema", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                //Nuevo Nodo Lista Simple
                ListaDobleCircularConductoresNodo NuevoNodoConductor = new ListaDobleCircularConductoresNodo(NuevoConductor);

                //Verificar Si La Lista Esta Vacia

                if(getListaDobleInicio() == null)
                {
                    //Agrego Al Inicio

                    NuevoNodoConductor.setSgte(NuevoNodoConductor);
                    NuevoNodoConductor.setAnte(NuevoNodoConductor);
                    setListaDobleInicio(NuevoNodoConductor);
                }
                else
                {
                    //Agrego Al Final

                    ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

                    while(Auxiliar.getSgte() != getListaDobleInicio())
                    {
                        Auxiliar = Auxiliar.getSgte();
                    }

                    Auxiliar.setSgte(NuevoNodoConductor);
                    NuevoNodoConductor.setAnte(Auxiliar);
                    NuevoNodoConductor.setSgte(getListaDobleInicio());
                    getListaDobleInicio().setAnte(NuevoNodoConductor);

                    //Ordenar Lista

                    OrdenamientoBurbujaListaDobleCircularC();
                }

                JOptionPane.showMessageDialog(null, "Conductor Agregado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            }             
        }

        //Eliminación

        //Encontrar Posicion Conductor

        private int EncontrarPosicionConductorListaDobleCircularC(String DPI)
        {
            //Declaraciones

            //Variable Tipo Lista Doble Circular

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            //Variables Tipo Int

            int Posicion = 0;

            if(Auxiliar != null)
            {
                do
                {
                    if(Auxiliar.getNuevoConductor().getDPIConductor().equals(DPI))
                    {
                        return Posicion;
                    }
                    Posicion++;
                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getListaDobleInicio());
            }

            return 0;
        }

        //Eliminar Conductor

        public void EliminarConductorListaDobleCircularC(String DPI)
        {
            //Declaraciones

            //Variables Tipo Int

            int PosicionConductor = 0;

            if(SizeListaDobleCircularC() != 0)
            {
                PosicionConductor = EncontrarPosicionConductorListaDobleCircularC(DPI);

                if(PosicionConductor <= SizeListaDobleCircularC())
                {
                    if(PosicionConductor == 1)
                    {
                        if(SizeListaDobleCircularC() == 1)
                        {
                            setListaDobleInicio(null);
                        }
                        else
                        {
                            ListaDobleCircularConductoresNodo Ultimo = getListaDobleInicio().getAnte();

                            setListaDobleInicio(getListaDobleInicio().getSgte());
                            Ultimo.setSgte(getListaDobleInicio());
                            getListaDobleInicio().setAnte(Ultimo);
                        }
                    }
                    else
                    {
                        ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

                        for(int i = 1; i <= PosicionConductor - 1; i++)
                        {
                            Auxiliar = Auxiliar.getSgte();
                        }

                        ListaDobleCircularConductoresNodo Anterior = Auxiliar.getAnte();
                        Auxiliar = Auxiliar.getSgte();
                        Anterior.setSgte(Auxiliar);
                        Auxiliar.setAnte(Anterior);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El Usuario Indicado No Existe En El Sistema", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Aún No Existen Usuarios En El Sistema", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Ordenamientos

        //Ordenamiento Burbuja Lista Doble

        private void OrdenamientoBurbujaListaDobleCircularC()
        {
            //Declaraciones

            //Auxiliares Lista Doble Circular
            
            ListaDobleCircularConductoresNodo Primero;
            ListaDobleCircularConductoresNodo Segundo;

            //Variables Tipo String
            
            String CodigoAuxiliar;

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
                        if(Primero.getNuevoConductor().getDPIConductor().compareTo(Segundo.getNuevoConductor().getDPIConductor()) > 0)
                        {
                            CodigoAuxiliar = Segundo.getNuevoConductor().getDPIConductor();
                            Segundo.getNuevoConductor().setDPIConductor(Primero.getNuevoConductor().getDPIConductor());
                            Primero.getNuevoConductor().setDPIConductor(CodigoAuxiliar); 
                        }
                        Segundo = Segundo.getSgte();
                    }
                    Primero = Primero.getSgte();
                }    
            }           
        }

        //Búsqueda

        //Buscar Conductor

        public boolean VerificarConductorListaDobleCircularC(String DPIUsuario)
        {
            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            do
            {
                if(DPIUsuario.compareTo(getListaDobleInicio().getNuevoConductor().getDPIConductor()) == 0)
                {
                    return true;
                }                
            }
            while(Auxiliar != getListaDobleInicio());
            
            return false;
        }

        //Recorridos

        //Obtener Todos Los Conductores

        public ArrayList<ModeloConductores> ObtenerTodosLosConductoresListaDobleCircularC()
        {
            //Declaraciones

            //Auxilair Lista Doble

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            //Array Tipo Modelo Conductor

            ArrayList<ModeloConductores> ArrayConductores = new ArrayList<ModeloConductores>();

            if(getListaDobleInicio() != null)
            {
                while(Auxiliar != getListaDobleInicio())
                {
                    ArrayConductores.add(Auxiliar.getNuevoConductor());
                    Auxiliar = Auxiliar.getSgte();
                }
            }

            return ArrayConductores;
        }
    }

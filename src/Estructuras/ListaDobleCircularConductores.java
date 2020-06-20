
//---------------------------------------------Paquetes E Importaciones-------------------------------------------------

    package Estructuras;

    import Modelos.ModeloConductores;
    import javax.swing.*;

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

        //Insertar Nuevo Conductor

        public void InsertarConductorFinalListaDobleCircularC(ModeloConductores NuevoConductor)
        {
            //Declaraciones
         
            //Variable Tipo Boolean

            boolean ExisteConductor = VerificarConductorListaDobleCircularC(NuevoConductor.getDPIConductor());
            
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

                    setListaDobleInicio(NuevoNodoConductor);
                }
                else
                {
                    //Agrego Al Final

                    ListaDobleCircularConductoresNodo AuxiliarAnterior = getListaDobleInicio().getAnte();

                    NuevoNodoConductor.setSgte(getListaDobleInicio());
                    NuevoNodoConductor.setAnte(AuxiliarAnterior);

                    getListaDobleInicio().setAnte(AuxiliarAnterior);
                    AuxiliarAnterior.setSgte(AuxiliarAnterior);

                    //Ordenar Lista

                    OrdenamientoBurbujaListaDobleCircularC();
                }
            }             
        }

        //Ordenamientos

        //Ordenamiento Burbuja Lista Doble

        void OrdenamientoBurbujaListaDobleCircularC()
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

        boolean VerificarConductorListaDobleCircularC(String DPIUsuario)
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
    }

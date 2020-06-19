
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
            boolean ExisteConductor = VerificarConductorListaDobleCircularC(NuevoConductor.getDPI());
            
            if(ExisteConductor)
            {
                JOptionPane.showMessageDialog(null, "El Conductor Indicado Ya Existe En El Sistema", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                //Nuevo Nodo Lista Simple
                ListaDobleCircularConductoresNodo NuevoNodoConductor = new ListaDobleCircularConductoresNodo(NuevoConductor);

                if(getListaDobleInicio() == null)
                {
                    setListaDobleInicio(NuevoNodoConductor);
                }
                else
                {
                    ListaDobleCircularConductoresNodo AuxiliarAnterior = getListaDobleInicio().getAnte();

                    NuevoNodoConductor.setSgte(getListaDobleInicio());
                    NuevoNodoConductor.setAnte(AuxiliarAnterior);

                    getListaDobleInicio().setAnte(AuxiliarAnterior);
                    AuxiliarAnterior.setSgte(AuxiliarAnterior);
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
                if(DPIUsuario.compareTo(getListaDobleInicio().getNuevoConductor().getDPI()) == 0)
                {
                    return true;
                }                
            }
            while(Auxiliar != getListaDobleInicio());
            
            return false;
        }
    }

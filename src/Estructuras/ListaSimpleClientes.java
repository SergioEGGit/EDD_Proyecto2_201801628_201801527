
//--------------------------------------------Paquetes E Imports--------------------------------------------------------

    package Estructuras;

    import Modelos.ModeloClientes;

    import java.util.ArrayList;

//-------------------------------------------------Principal------------------------------------------------------------

     public class ListaSimpleClientes
    {
        //Atributos
        ListaSimpleClientesNodo ListaSimpleUsuariosInicio;

        //-----------------------------------------Métodos--------------------------------------------------------------

        //Get Inicio Lista
        
        public ListaSimpleClientesNodo getListaSimpleUsuariosInicio() 
        {
            return ListaSimpleUsuariosInicio;
        }

        //Set Inicio Lista

        public void setListaSimpleUsuariosInicio(ListaSimpleClientesNodo listaSimpleUsuariosInicio)
        {
            ListaSimpleUsuariosInicio = listaSimpleUsuariosInicio;
        }

        //Inserción

        //Insertar Nuevo Cliente

        public void InsertarClienteListaSimpleC(ModeloClientes NuevoCliente)
        {
            //Declaraciones

            ListaSimpleClientesNodo NuevoNodoCliente = new ListaSimpleClientesNodo(NuevoCliente);

            if(getListaSimpleUsuariosInicio() == null)
            {
                NuevoNodoCliente.setSgte(null);
                setListaSimpleUsuariosInicio(NuevoNodoCliente);
            }
            else
            {
                NuevoNodoCliente.setSgte(getListaSimpleUsuariosInicio());
                setListaSimpleUsuariosInicio(NuevoNodoCliente);
            }
        }

        //Búsqueda

        //Buscar Cliente

        public ListaSimpleClientesNodo BuscarClienteListaSimpleC(String DPI)
        {
            //Declaraciones

            //Variables Tipo Lista Simple

            ListaSimpleClientesNodo AuxiliarClientes = getListaSimpleUsuariosInicio();

            while(AuxiliarClientes != null)
            {
                if(DPI.equals(AuxiliarClientes.getNuevoCliente().getDPICliente()))
                {
                    return AuxiliarClientes;
                }
                AuxiliarClientes = AuxiliarClientes.getSgte();
            }
            return null;
        }


    }

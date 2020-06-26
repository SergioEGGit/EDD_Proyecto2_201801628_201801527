
//--------------------------------------------Paquetes E Imports--------------------------------------------------------

    package Estructuras;

    import Modelos.ModeloClientes;

    import javax.swing.*;
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

        //Eliminación

        //Eliminar Cliente

        public void EliminarClienteListaSimpleC(String DPI)
        {
            ListaSimpleClientesNodo AuxiliarPrimero = getListaSimpleUsuariosInicio();
            ListaSimpleClientesNodo AuxiliarSegundo = getListaSimpleUsuariosInicio();

            while(AuxiliarPrimero != null)
            {
                if(DPI.equals(AuxiliarPrimero.getNuevoCliente().getDPICliente()) && AuxiliarPrimero == getListaSimpleUsuariosInicio())
                {
                    setListaSimpleUsuariosInicio(AuxiliarPrimero.getSgte());
                    JOptionPane.showMessageDialog(null, "Cliente Eliminado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                else if(DPI.equals(AuxiliarPrimero.getNuevoCliente().getDPICliente()) && AuxiliarPrimero != getListaSimpleUsuariosInicio())
                {
                    AuxiliarSegundo.setSgte(AuxiliarPrimero.getSgte());
                    AuxiliarPrimero = null;
                    JOptionPane.showMessageDialog(null, "Cliente Eliminado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                AuxiliarSegundo = AuxiliarPrimero;
                AuxiliarPrimero = AuxiliarPrimero.getSgte();
            }
        }

        //Recorridos

        //Listar Todos Los Clientes

        public ArrayList<ModeloClientes> ListarTodosLosClientesListaSimpleC()
        {
            //Declaracioens

            //Auxilair Lista Simple Clientes

            ListaSimpleClientesNodo AuxiliarNodo = getListaSimpleUsuariosInicio();

            //Array Auxiliar

            ArrayList<ModeloClientes> ArrayAuxiliar = new ArrayList<ModeloClientes>();

            while(AuxiliarNodo != null)
            {
                ArrayAuxiliar.add(AuxiliarNodo.getNuevoCliente());

                AuxiliarNodo = AuxiliarNodo.getSgte();
            }

            return ArrayAuxiliar;
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

        //Reportes

        //Generar Reportes Lista Simple

        public String GenerarReporteListaSimple(int ContadorAuxiliar)
        {
            String Cadena = "";

            Cadena += "subgraph Usuario" + ContadorAuxiliar + "\n { \n    rankdir = \"LR\"; \n    node[shape = rect color = brown1 fontcolor = chartreuse4]; \n";

            ListaSimpleClientesNodo AuxiliarNodo = getListaSimpleUsuariosInicio();

            while(AuxiliarNodo != null)
            {
                Cadena += AuxiliarNodo.getNuevoCliente().getDPICliente() + "[label = \"DPI: " + AuxiliarNodo.getNuevoCliente().getDPICliente() + "\n Nombres: " + AuxiliarNodo.getNuevoCliente().getNombresCliente() + "\n Apellidos: " + AuxiliarNodo.getNuevoCliente().getApellidosCliente() + "\n Fecha Nacimiento: " + AuxiliarNodo.getNuevoCliente().getFechaNacimentoCliente() + "\n Genero: " + AuxiliarNodo.getNuevoCliente().getGeneroCliente() + "\n Telefono: " + AuxiliarNodo.getNuevoCliente().getTelefonoCliente() + "\n Direccion: " + AuxiliarNodo.getNuevoCliente().getDireccionCliente() + "\"];\n";

                ListaSimpleClientesNodo Puntero = AuxiliarNodo.getSgte();

                if(Puntero != null)
                {
                    Cadena += AuxiliarNodo.getNuevoCliente().getDPICliente() + " -> " + Puntero.getNuevoCliente().getDPICliente() + "; \n";
                }
                AuxiliarNodo = AuxiliarNodo.getSgte();
            }

            Cadena += "} \n";
            return Cadena;
        }
    }

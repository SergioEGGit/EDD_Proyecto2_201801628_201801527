
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Estructuras;

    import Modelos.ModeloClientes;

//--------------------------------------------------Principal-----------------------------------------------------------

     public class TablaHashClientesNodo
    {
        private ListaSimpleClientes ListaSimpleClientes;

        //--------------------------------------------Constructor-------------------------------------------------------

        public TablaHashClientesNodo()
        {
            setListaSimpleClientes(new ListaSimpleClientes());
        }

        //--------------------------------------------Métodos-----------------------------------------------------------

        //Get ListaSimple Clientes

        public Estructuras.ListaSimpleClientes getListaSimpleClientes()
        {
            return ListaSimpleClientes;
        }

        //Set ListaSimpole Clientes

        public void setListaSimpleClientes(Estructuras.ListaSimpleClientes listaSimpleClientes)
        {
            ListaSimpleClientes = listaSimpleClientes;
        }

        //Inserción

        //Insertar Cliente Lista Simple

        public void InsertarClienteListaSimpleTablaHashNodo(ModeloClientes NuevoCliente)
        {
            getListaSimpleClientes().InsertarClienteListaSimpleC(NuevoCliente);
        }

        //Búsqueda

        //Buscar Cliente Lista Simple

        public ListaSimpleClientesNodo BuscarClienteListaSimpleTablaHashNodo(String DPI)
        {
            return getListaSimpleClientes().BuscarClienteListaSimpleC(DPI);
        }
    }

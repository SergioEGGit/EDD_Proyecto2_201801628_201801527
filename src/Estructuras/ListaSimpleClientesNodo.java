
//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Estructuras;

    import Modelos.ModeloClientes;

//--------------------------------------------------Principal-----------------------------------------------------------

     public class ListaSimpleClientesNodo
    {
        //Atributos

        //Modelos
        ModeloClientes NuevoCliente;
        //Apuntadores
        ListaSimpleClientesNodo Sgte;

        //---------------------------------------------Constructor------------------------------------------------------

        //Constructor Vacio

        public ListaSimpleClientesNodo()
        {

        }

        //Constructor Nuevo Cliente

        public ListaSimpleClientesNodo(ModeloClientes nuevoCliente)
        {
            NuevoCliente = nuevoCliente;
            Sgte = null;
        }

        //Gets And Sets

        public ModeloClientes getNuevoCliente()
        {
            return NuevoCliente;
        }

        public void setNuevoCliente(ModeloClientes nuevoCliente)
        {
            NuevoCliente = nuevoCliente;
        }

        public ListaSimpleClientesNodo getSgte()
        {
            return Sgte;
        }

        public void setSgte(ListaSimpleClientesNodo sgte)
        {
            Sgte = sgte;
        }
    }

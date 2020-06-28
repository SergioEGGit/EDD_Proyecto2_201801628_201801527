
//-----------------------------------------------Paquetes E Imports-----------------------------------------------------

    package Estructuras;

//---------------------------------------------------Principal----------------------------------------------------------

    public class ListaDobleCircularTopsNodo
    {
        //Atributos

        //Modelo
        private String Nombre;
        private int Cantidad;
        //Apuntadores
        private ListaDobleCircularTopsNodo Sgte;
        private ListaDobleCircularTopsNodo Ante;

         //----------------------------------------------Constructores---------------------------------------------------

        //Constructor Vacio

        public ListaDobleCircularTopsNodo()
        {

        }

        //Constructor Nuevo Nodo

        public ListaDobleCircularTopsNodo(String nombre, int cantidad)
        {
            Nombre = nombre;
            Cantidad = cantidad;
            Sgte = null;
            Ante = null;
        }

        //Gets And Sets

        public String getNombre()
        {
            return Nombre;
        }

        public void setNombre(String nombre)
        {
            Nombre = nombre;
        }

        public int getCantidad()
        {
            return Cantidad;
        }

        public void setCantidad(int cantidad)
        {
            Cantidad = cantidad;
        }

        public ListaDobleCircularTopsNodo getSgte()
        {
            return Sgte;
        }

        public void setSgte(ListaDobleCircularTopsNodo sgte)
        {
            Sgte = sgte;
        }

        public ListaDobleCircularTopsNodo getAnte()
        {
            return Ante;
        }

        public void setAnte(ListaDobleCircularTopsNodo ante)
        {
            Ante = ante;
        }
    }

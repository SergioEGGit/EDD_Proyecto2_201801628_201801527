
//-----------------------------------------------Paquetes E Imports-----------------------------------------------------

    package Estructuras;

    import Modelos.ModeloRutas;

//---------------------------------------------------Principal----------------------------------------------------------

    public class ListaSimpleRutasNodo
    {
        //Atributos
        ModeloRutas NuevaRuta;
        //Apuntador
        ListaSimpleRutasNodo Sgte;

        //--------------------------------------------Constructor-------------------------------------------------------

        //Constructor Nueva Ruta

        public ListaSimpleRutasNodo(ModeloRutas nuevaRuta)
        {
            NuevaRuta = nuevaRuta;
            Sgte = null;
        }

        //Constructor Vacio

        public ListaSimpleRutasNodo()
        {

        }

        //Gets And Sets

        public ModeloRutas getNuevaRuta()
        {
            return NuevaRuta;
        }

        public void setNuevaRuta(ModeloRutas nuevaRuta)
        {
            NuevaRuta = nuevaRuta;
        }

        public ListaSimpleRutasNodo getSgte()
        {
            return Sgte;
        }

        public void setSgte(ListaSimpleRutasNodo sgte)
        {
            Sgte = sgte;
        }

    }

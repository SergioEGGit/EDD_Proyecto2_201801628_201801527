
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Estructuras;

    import Modelos.ModeloRutas;

//--------------------------------------------------Principal-----------------------------------------------------------

    public class ListaSimpleRutas
    {
        //Atributos
        private ListaSimpleRutasNodo ListaSimpleRutasInicio;

        //-------------------------------------------Métodos------------------------------------------------------------

        //Gets And Sets

        public ListaSimpleRutasNodo getListaSimpleRutasInicio()
        {
            return ListaSimpleRutasInicio;
        }

        public void setListaSimpleRutasInicio(ListaSimpleRutasNodo listaSimpleRutasInicio)
        {
            ListaSimpleRutasInicio = listaSimpleRutasInicio;
        }

        //Tamaño Lista

        //Size

        public int SizeListaSimpleRutas()
        {
            //Declaraciones

            int Auxiliar = 1;

            while(getListaSimpleRutasInicio() != null)
            {
                Auxiliar++;
            }

            return Auxiliar;
        }

        //Inserción

        //Insertar Nueva Ruta

        public void InsertarLugarListaSimpleRutas(ModeloRutas NuevoLugar)
        {
            //Declaraciones

            ListaSimpleRutasNodo NuevoNodoLugar = new ListaSimpleRutasNodo(NuevoLugar);

            if(getListaSimpleRutasInicio() == null)
            {
                NuevoNodoLugar.setSgte(null);
                setListaSimpleRutasInicio(NuevoNodoLugar);
            }
            else
            {
                NuevoNodoLugar.setSgte(getListaSimpleRutasInicio());
                setListaSimpleRutasInicio(NuevoNodoLugar);
            }
        }

    }

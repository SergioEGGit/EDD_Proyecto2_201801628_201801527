
//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Modelos;

    import Estructuras.ArbolBAutosNodo;
    import Estructuras.ListaDobleCircularConductoresNodo;
    import Estructuras.ListaSimpleClientesNodo;
    import Estructuras.ListaSimpleRutas;

//-------------------------------------------------Principal------------------------------------------------------------

    public class ModeloViajes
    {
        //Atributos
        String IdentificadorViaje;
        String LugarOrigenViaje;
        String LugaDestinoViaje;
        String FechaViaje;
        String HoraViaje;
        ListaSimpleClientesNodo ClienteViaje;
        ListaDobleCircularConductoresNodo ConductorViaje;
        ArbolBAutosNodo VehiculoViaje;
        int PosicionArray;
        ListaSimpleRutas ListaRutaViaje;

        //------------------------------------------------Constructor---------------------------------------------------

        //Constructor Nuevo Viaje

        public ModeloViajes(String identificadorViaje, String lugarOrigenViaje, String lugaDestinoViaje, String fechaViaje, String horaViaje, ListaSimpleClientesNodo clienteViaje, ListaDobleCircularConductoresNodo conductorViaje, ArbolBAutosNodo vehiculoViaje, int posicionArray, ListaSimpleRutas listaRutaViaje)
        {
            IdentificadorViaje = identificadorViaje;
            LugarOrigenViaje = lugarOrigenViaje;
            LugaDestinoViaje = lugaDestinoViaje;
            FechaViaje = fechaViaje;
            HoraViaje = horaViaje;
            ClienteViaje = clienteViaje;
            ConductorViaje = conductorViaje;
            VehiculoViaje = vehiculoViaje;
            PosicionArray = posicionArray;
            ListaRutaViaje = listaRutaViaje;
        }

        //Constructor Vacia

        public ModeloViajes()
        {

        }

        //Gets And Sets

        public int getPosicionArray()
        {
            return PosicionArray;
        }

        public void setPosicionArray(int posicionArray)
        {
            PosicionArray = posicionArray;
        }

        public String getIdentificadorViaje()
        {
            return IdentificadorViaje;
        }

        public void setIdentificadorViaje(String identificadorViaje)
        {
            IdentificadorViaje = identificadorViaje;
        }

        public String getLugarOrigenViaje()
        {
            return LugarOrigenViaje;
        }

        public void setLugarOrigenViaje(String lugarOrigenViaje)
        {
            LugarOrigenViaje = lugarOrigenViaje;
        }

        public String getLugaDestinoViaje()
        {
            return LugaDestinoViaje;
        }

        public void setLugaDestinoViaje(String lugaDestinoViaje)
        {
            LugaDestinoViaje = lugaDestinoViaje;
        }

        public String getFechaViaje()
        {
            return FechaViaje;
        }

        public void setFechaViaje(String fechaViaje)
        {
            FechaViaje = fechaViaje;
        }

        public String getHoraViaje()
        {
            return HoraViaje;
        }

        public void setHoraViaje(String horaViaje)
        {
            HoraViaje = horaViaje;
        }

        public ListaSimpleClientesNodo getClienteViaje()
        {
            return ClienteViaje;
        }

        public void setClienteViaje(ListaSimpleClientesNodo clienteViaje)
        {
            ClienteViaje = clienteViaje;
        }

        public ListaDobleCircularConductoresNodo getConductorViaje()
        {
            return ConductorViaje;
        }

        public void setConductorViaje(ListaDobleCircularConductoresNodo conductorViaje)
        {
            ConductorViaje = conductorViaje;
        }

        public ArbolBAutosNodo getVehiculoViaje()
        {
            return VehiculoViaje;
        }

        public void setVehiculoViaje(ArbolBAutosNodo vehiculoViaje)
        {
            VehiculoViaje = vehiculoViaje;
        }

        public ListaSimpleRutas getListaRutaViaje()
        {
            return ListaRutaViaje;
        }

        public void setListaRutaViaje(ListaSimpleRutas listaRutaViaje)
        {
            ListaRutaViaje = listaRutaViaje;
        }
    }

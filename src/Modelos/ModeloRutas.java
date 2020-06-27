
//-----------------------------------------------Paquetes E Imports-----------------------------------------------------

    package Modelos;

//----------------------------------------------------Principal---------------------------------------------------------

    public class ModeloRutas
    {
        //Atributos
        String Lugar;
        int Tiempo;

        //--------------------------------------------Constructores-----------------------------------------------------

        //Constructor Nueva Ruta

        public ModeloRutas(String lugar, int tiempo)
        {
            Lugar = lugar;
            Tiempo = tiempo;
        }

        //Constructor Vacio

        public ModeloRutas()
        {

        }

        //------------------------------------------------Métodos-------------------------------------------------------

        //Gets And Sets

        public String getLugar()
        {
            return Lugar;
        }

        public void setLugar(String lugar)
        {
            Lugar = lugar;
        }

        public int getTiempo()
        {
            return Tiempo;
        }

        public void setTiempo(int tiempo)
        {
            Tiempo = tiempo;
        }

    }

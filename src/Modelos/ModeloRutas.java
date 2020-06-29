
//-----------------------------------------------Paquetes E Imports-----------------------------------------------------

    package Modelos;

//----------------------------------------------------Principal---------------------------------------------------------

    public class ModeloRutas
    {
        //Atributos
        String Lugar;
        double Tiempo;

        //--------------------------------------------Constructores-----------------------------------------------------

        //Constructor Nueva Ruta

        public ModeloRutas(String lugar, double tiempo)
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

        public double getTiempo()
        {
            return Tiempo;
        }

        public void setTiempo(double tiempo)
        {
            Tiempo = tiempo;
        }

    }

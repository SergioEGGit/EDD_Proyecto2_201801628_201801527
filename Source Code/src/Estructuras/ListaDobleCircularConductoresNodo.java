
//------------------------------------------------Paquetes E Imports----------------------------------------------------

    package Estructuras;

    import Modelos.ModeloConductores;

//----------------------------------------------------Principal---------------------------------------------------------

    public class ListaDobleCircularConductoresNodo
    {
        //Atributos

        //Modelo
        private ModeloConductores NuevoConductor;
        //Apuntadores
        private ListaDobleCircularConductoresNodo Sgte;
        private ListaDobleCircularConductoresNodo Ante;

        //----------------------------------------------Constructores---------------------------------------------------

        //Constructor Vacio

        public ListaDobleCircularConductoresNodo()
        {

        }

        //Constructor Nuevo Nodo

        public ListaDobleCircularConductoresNodo(ModeloConductores nuevoConductor)
        {
            this.NuevoConductor = nuevoConductor;
            Sgte = null;
            Ante = null;
        }

        //Métodos

        //Get Nuevo Conductor

        public ModeloConductores getNuevoConductor()
        {
            return NuevoConductor;
        }

        //Set Nuevo Conductor

        public void setNuevoConductor(ModeloConductores nuevoConductor)
        {
            NuevoConductor = nuevoConductor;
        }

        //Get Sgte

        public ListaDobleCircularConductoresNodo getSgte()
        {
            return Sgte;
        }

        //Set Sgte

        public void setSgte(ListaDobleCircularConductoresNodo sgte)
        {
            Sgte = sgte;
        }

        //Get Ante

        public ListaDobleCircularConductoresNodo getAnte()
        {
            return Ante;
        }

        //Set Ante

        public void setAnte(ListaDobleCircularConductoresNodo ante)
        {
            Ante = ante;
        }
    }

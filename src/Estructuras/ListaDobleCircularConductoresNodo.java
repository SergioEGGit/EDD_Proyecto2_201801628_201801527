
//---------------------------------------------Paquetes E Importaciones-------------------------------------------------

    package Estructuras;

    import Modelos.ModeloConductores;

    import java.util.ArrayList;

//----------------------------------------------------Principal---------------------------------------------------------

    public class ListaDobleCircularConductoresNodo
    {
        //Atributos
        private ModeloConductores NuevoConductor;
        private ListaDobleCircularConductoresNodo Sgte;
        private ListaDobleCircularConductoresNodo Ante;

        //Constructores

        //Constructor Nuevo Nodo
        public ListaDobleCircularConductoresNodo(ModeloConductores nuevoConductor)
        {
            this.NuevoConductor = nuevoConductor;
            Sgte = null;
            Ante = null;
        }

        public ModeloConductores getNuevoConductor()
        {
            return NuevoConductor;
        }

        public void setNuevoConductor(ModeloConductores nuevoConductor)
        {
            NuevoConductor = nuevoConductor;
        }

        public ListaDobleCircularConductoresNodo getSgte()
        {
            return Sgte;
        }

        public void setSgte(ListaDobleCircularConductoresNodo sgte)
        {
            Sgte = sgte;
        }

        public ListaDobleCircularConductoresNodo getAnte()
        {
            return Ante;
        }

        public void setAnte(ListaDobleCircularConductoresNodo ante)
        {
            Ante = ante;
        }
    }

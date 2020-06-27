
//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Estructuras;

    import Modelos.ModeloViajes;

//--------------------------------------------------Principal-----------------------------------------------------------

    public class BlockchainViajesNodo
    {
        //Atributos
        ModeloViajes NuevoViaje;
        //Apuntadores
        BlockchainViajesNodo Sgte;
        BlockchainViajesNodo Ante;

        //-------------------------------------------Constructor--------------------------------------------------------

        //Constructor Nuevo Viaje

        public BlockchainViajesNodo(ModeloViajes nuevoViaje)
        {
            NuevoViaje = nuevoViaje;
            Sgte = null;
            Ante = null;
        }

        //Constructor Vacio

        public BlockchainViajesNodo()
        {

        }

        //Gets And Sets

        public ModeloViajes getNuevoViaje()
        {
            return NuevoViaje;
        }

        public void setNuevoViaje(ModeloViajes nuevoViaje)
        {
            NuevoViaje = nuevoViaje;
        }

        public BlockchainViajesNodo getSgte()
        {
            return Sgte;
        }

        public void setSgte(BlockchainViajesNodo sgte)
        {
            Sgte = sgte;
        }

        public BlockchainViajesNodo getAnte()
        {
            return Ante;
        }

        public void setAnte(BlockchainViajesNodo ante)
        {
            Ante = ante;
        }
    }

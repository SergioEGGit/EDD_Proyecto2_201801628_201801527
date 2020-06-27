
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Estructuras;

    import Modelos.ModeloViajes;
    
//---------------------------------------------------Principal----------------------------------------------------------    

    public class BlockchainViajes 
    {
        //Atributos
        BlockchainViajesNodo BlockChainViajesInicio;
        
        //-------------------------------------------Métodos------------------------------------------------------------

        public BlockchainViajesNodo getBlockChainViajesInicio()
        {
            return BlockChainViajesInicio;
        }

        public void setBlockChainViajesInicio(BlockchainViajesNodo blockChainViajesInicio)
        {
            BlockChainViajesInicio = blockChainViajesInicio;
        }
        
        //Inserción
        
        //Insertar Nuevo Viaje
        
        public void InsertarViajeBlockchainViajes(ModeloViajes NuevoViaje)
        {
            //Declaraciones
            
            //Nuevo Nodo Lista Simple
            BlockchainViajesNodo NuevoViajeNodo = new BlockchainViajesNodo(NuevoViaje);
            
            if(getBlockChainViajesInicio() == null)
            {
                //Agregar Inicio Lista
                
                NuevoViajeNodo.setSgte(NuevoViajeNodo);
                NuevoViajeNodo.setAnte(NuevoViajeNodo);
                NuevoViajeNodo.setNuevoViaje(NuevoViaje);
            }
            else
            {
                //Ya Existen Viajes
                
                BlockchainViajesNodo Auxiliar = getBlockChainViajesInicio();
                
                while(Auxiliar.getSgte() != getBlockChainViajesInicio())
                {
                    Auxiliar = Auxiliar.getSgte();
                }

                Auxiliar.setSgte(NuevoViajeNodo);
                NuevoViajeNodo.setAnte(Auxiliar);
                NuevoViajeNodo.setSgte(getBlockChainViajesInicio());
                getBlockChainViajesInicio().setAnte(NuevoViajeNodo);
            }
            
        }
        
    }

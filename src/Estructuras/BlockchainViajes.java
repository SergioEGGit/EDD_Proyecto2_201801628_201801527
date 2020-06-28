
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Estructuras;

    import Modelos.ModeloViajes;
    import Variables.VariablesGlobales;

    import javax.swing.*;

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

        //Reportes

        //Top Viajes Mas Largos

        public void TopViajesLargosBlockchainViajes()
        {
            //Declaraciones

            //Auxiliar Lista Doble

            BlockchainViajesNodo Auxiliar = getBlockChainViajesInicio();

            VariablesGlobales.ListaDobleCircularTops.setListaDobleInicio(null);

            String Auxiliar2 = "";

            if(getBlockChainViajesInicio() == null)
            {
                JOptionPane.showMessageDialog(null, "La Estrcutura Se Encuentra Vacia", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                do
                {
                    Auxiliar2 = "Codigo: " + Auxiliar.getNuevoViaje().getIdentificadorViaje() + " Origen: " + Auxiliar.getNuevoViaje().getLugarOrigenViaje() + " Destino: " + Auxiliar.getNuevoViaje().getLugaDestinoViaje();
                    VariablesGlobales.ListaDobleCircularTops.InsertarTopFinalListaDobleCircularC(Auxiliar2, Auxiliar.getNuevoViaje().getListaRutaViaje().SizeListaSimpleRutas() - 1);
                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getBlockChainViajesInicio());
            }
        }
        
    }

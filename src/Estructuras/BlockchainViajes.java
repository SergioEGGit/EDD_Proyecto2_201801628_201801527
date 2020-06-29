
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Estructuras;

    import Metodos.GenerarReportes;
    import Modelos.ModeloClientes;
    import Modelos.ModeloViajes;
    import Variables.VariablesGlobales;

    import javax.swing.*;
    import java.util.ArrayList;

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
                setBlockChainViajesInicio(NuevoViajeNodo);

                JOptionPane.showMessageDialog(null, "Viaje Agregado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
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

                JOptionPane.showMessageDialog(null, "Viaje Agregado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }

        //Búsqueda

        //Verificar Conductor

        public boolean VerificarViajeBlockchainViaje(String Identificador)
        {
            BlockchainViajesNodo Auxiliar = getBlockChainViajesInicio();

            if(getBlockChainViajesInicio() != null)
            {
                do
                {
                    if(Identificador.equals(Auxiliar.getNuevoViaje().getIdentificadorViaje()))
                    {
                        return true;
                    }

                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getBlockChainViajesInicio());
            }

            return false;
        }

        //Buscar Nodo

        public BlockchainViajesNodo BuscarViajeBlockchainViaje(String Codigo)
        {
            BlockchainViajesNodo Auxiliar = getBlockChainViajesInicio();

            if(getBlockChainViajesInicio() != null)
            {
                do
                {
                    if(Codigo.equals(Auxiliar.getNuevoViaje().getIdentificadorViaje()))
                    {
                        return Auxiliar;
                    }

                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getBlockChainViajesInicio());
            }

            return null;
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

        //Reporte BlockChain

        public void GenerarReporteBlockchainViajes()
        {
            //Declaraciones

            //Variables Tipo Int

            int ContadorAuxiliar = 0;

            //Variables Tipo String

            String Cadena = "";
            String Asc = "";
            String Desc = "";
            String Same = "";
            String Modelos = "";
            String ModelosEnlace = "";
            String SubGraficaRutas = "";

            //Array String

            String[] Temporal = new String[100];

            //Auxiliar Tipo Lista Doble

            BlockchainViajesNodo Auxiliar = getBlockChainViajesInicio();

            Cadena += "digraph ListaDobleCircular" + "\n";
            Cadena += "{" + "\n";
            Cadena += "graph [charset=latin1]" + "\n";
            Cadena += "node [shape = box, style = rounded, color = brown1, fontcolor = darkslategray];" + "\n";

            if(getBlockChainViajesInicio() != null)
            {
                do
                {
                    Cadena += "A" + ContadorAuxiliar + " [label = \"Identificador: " + Auxiliar.getNuevoViaje().getIdentificadorViaje();
                    Cadena += "\\lOrigne: " + Auxiliar.getNuevoViaje().getLugarOrigenViaje();
                    Cadena += "\\lDestino: " + Auxiliar.getNuevoViaje().getLugaDestinoViaje();
                    Cadena += "\\lFecha Inicio" + Auxiliar.getNuevoViaje().getFechaViaje();
                    Cadena += "\\lHora Inicio: " + Auxiliar.getNuevoViaje().getHoraViaje();
                    Cadena += "\\l\"]" + "\n";

                    Modelos += "A" + ContadorAuxiliar + "Cliente[ label = \"Cliente: \\l DPI: " + Auxiliar.getNuevoViaje().getClienteViaje().getNuevoCliente().getDPICliente();
                    Modelos += "\\lNombres: " + Auxiliar.getNuevoViaje().getClienteViaje().getNuevoCliente().getNombresCliente();
                    Modelos += "\\lApellidos: " + Auxiliar.getNuevoViaje().getClienteViaje().getNuevoCliente().getApellidosCliente();
                    Modelos += "\\l\"]" + "\n";

                    Modelos += "A" + ContadorAuxiliar + "Conductor[ label = \"Conductor: \\l DPI: " + Auxiliar.getNuevoViaje().getConductorViaje().getNuevoConductor().getDPIConductor();
                    Modelos += "\\lNombres: " + Auxiliar.getNuevoViaje().getConductorViaje().getNuevoConductor().getNombresConductor();
                    Modelos += "\\lApellidos: " + Auxiliar.getNuevoViaje().getConductorViaje().getNuevoConductor().getApellidosConductor();
                    Modelos += "\\l\"]" + "\n";

                    Modelos += "A" + ContadorAuxiliar + "Vehiculo[ label = \"Vehiculo: \\l Placa: " + Auxiliar.getNuevoViaje().getVehiculoViaje().getVehiculos().get(Auxiliar.getNuevoViaje().getPosicionArray()).getPlaca();
                    Modelos += "\\lMarca: " + Auxiliar.getNuevoViaje().getVehiculoViaje().getVehiculos().get(Auxiliar.getNuevoViaje().getPosicionArray()).getMarca();
                    Modelos += "\\lModelo: " + Auxiliar.getNuevoViaje().getVehiculoViaje().getVehiculos().get(Auxiliar.getNuevoViaje().getPosicionArray()).getModelo();
                    Modelos += "\\l\"]" + "\n";

                    Modelos += Auxiliar.getNuevoViaje().getListaRutaViaje().GenerarSubGrafica("A" + ContadorAuxiliar);

                    Temporal[ContadorAuxiliar] = "A" + ContadorAuxiliar;
                    ContadorAuxiliar++;
                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getBlockChainViajesInicio());

                for(int i = 0; i < ContadorAuxiliar; i++)
                {
                    Same = Same + Temporal[i] + " ";

                    ModelosEnlace += Temporal[i] + "->" + Temporal[i] + "Cliente" + "\n";
                    ModelosEnlace += Temporal[i] + "->" + Temporal[i] + "Conductor" + "\n";
                    ModelosEnlace += Temporal[i] + "->" + Temporal[i] + "Vehiculo" + "\n";
                    ModelosEnlace += Temporal[i] + "->" + "A0" + Temporal[i] + "\n";

                    if(i < ContadorAuxiliar - 1)
                    {
                        Asc = Asc + Temporal[i] + "->";
                        Desc = Desc + Temporal[ContadorAuxiliar - i - 1] + "->";
                    }
                    else
                    {
                        Asc = Asc + Temporal[i];
                        Desc = Desc + Temporal[ContadorAuxiliar - i - 1];
                    }
                }

                Cadena += "{ rank = same " + Same + "}" + "\n";
                Cadena += Modelos + "\n";
                Cadena += " " + "\n";
                Cadena += ModelosEnlace + "\n";
                Cadena += Asc + "\n";
                Cadena += " " + "\n";
                Cadena += Desc + "\n";
                Cadena += "}" + "\n";

                GenerarReportes Reporte = new GenerarReportes("ReporteViajesBockChain", Cadena);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "La Lista Se Encuentra Vacia", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Recorridos

        //Todos Los Bloques

        public ArrayList<ModeloViajes> TodosLosBloquesBlockchainViajes()
        {
            //Declaracioens

            //Auxilair Lista Simple Clientes

            BlockchainViajesNodo AuxiliarNodo = getBlockChainViajesInicio();

            //Array Auxiliar

            ArrayList<ModeloViajes> ArrayAuxiliar = new ArrayList<ModeloViajes>();

            do
            {
                ArrayAuxiliar.add(AuxiliarNodo.getNuevoViaje());

                AuxiliarNodo = AuxiliarNodo.getSgte();
            }
            while(AuxiliarNodo != getBlockChainViajesInicio());

            return ArrayAuxiliar;
        }
        
    }

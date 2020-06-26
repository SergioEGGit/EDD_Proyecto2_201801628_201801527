
//---------------------------------------------Paquete E Imports--------------------------------------------------------

    package Estructuras;

    import Metodos.CargaMasiva;
    import Metodos.GenerarReportes;
    import Modelos.ModeloClientes;
    import Variables.VariablesGlobales;
    import javax.swing.*;
    import java.math.BigInteger;
    import java.util.ArrayList;

//-------------------------------------------------Principal------------------------------------------------------------

    public class TablaHashClientes
    {
        //Atributos
        private TablaHashClientesNodo[] Clientes;
        private int Size;

        //-------------------------------------------Constructor--------------------------------------------------------

        //Constructor Vacio

        public TablaHashClientes()
        {

        }

        //Constructor Nueva Tabla Hash

        public TablaHashClientes(int size)
       {
            Size = size;
            Clientes = new TablaHashClientesNodo[Size];
        }

        //Get And Sets

        public int getSize()
        {
            return Size;
        }

        public void setSize(int size)
        {
            Size = size;
        }

        public TablaHashClientesNodo[] getClientes()
        {
            return Clientes;
        }

        public void setClientes(TablaHashClientesNodo[] clientes)
        {
            Clientes = clientes;
        }

        //Funcion Hash

        public BigInteger FuncionCalcularHash(String DPI)
        {
            //Conversion

            BigInteger DPIAuxiliar = new BigInteger(DPI);
            BigInteger SizeMod = new BigInteger(String.valueOf(getSize()));

            return DPIAuxiliar.mod(SizeMod);
        }

        //Resize

        //Tamaño Tabla

        public int SizeTabla()
        {
            //Declaraciones

            int ContadorAuxiliar = 0;

            for(TablaHashClientesNodo Clave: Clientes)
            {
                if(Clave != null)
                {
                    ContadorAuxiliar++;
                }
            }

            return ContadorAuxiliar;
        }

        //Aumentar Tamaño Tabla Hash

        public void AumentarTamañoTabla()
        {
            //Declaraciones

            int NuevoSize = 0;

            int SizeActual = SizeTabla();

            int FactorAgregado = (int) (getSize() * 0.75);

            if(SizeActual >= FactorAgregado)
            {
                VariablesGlobales.EstoyEnRehashin = true;
                VariablesGlobales.ContadorCargaMasiva = 0;

                NuevoSize = getSize() + 37;

                setSize(NuevoSize);

                VariablesGlobales.SizeTabla = NuevoSize;

                ArrayList<ModeloClientes> ArrayAuxiliar = new ArrayList<ModeloClientes>();

                ArrayAuxiliar = ListarTodosLosClientesTablaHashClientes();

                setClientes(new TablaHashClientesNodo[NuevoSize]);

                for(ModeloClientes Cliente: ArrayAuxiliar)
                {
                    InsertarClienteTablaHashClientes(Cliente);
                }
            }

            VariablesGlobales.EstoyEnRehashin = false;
        }

        //Inserción

        //Insertar Nuevo Cliente

        public void InsertarClienteTablaHashClientes(ModeloClientes NuevoCliente)
        {
            AumentarTamañoTabla();

            //Declaraciones

            BigInteger PosicionHash = FuncionCalcularHash(NuevoCliente.getDPICliente());
            int PosicionHashInt = PosicionHash.intValue();
            boolean Bandera = VerificarClienteTablaHashClientes(NuevoCliente.getDPICliente());

            if(Clientes[PosicionHashInt] != null)
            {
                if(Bandera)
                {
                    JOptionPane.showMessageDialog(null, "El Usuario Indicado Ya Existe En El Sistema!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    Clientes[PosicionHashInt].InsertarClienteListaSimpleTablaHashNodo(NuevoCliente);

                    if(!VariablesGlobales.EstoyEnRehashin)
                    {
                        if(VariablesGlobales.EstoyEnCargaMasiva)
                        {
                            VariablesGlobales.ContadorCargaMasiva++;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Cliente Agregado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
            else
            {
                TablaHashClientesNodo NuevoNodoClientes = new TablaHashClientesNodo();
                Clientes[PosicionHashInt] = NuevoNodoClientes;
                Clientes[PosicionHashInt].InsertarClienteListaSimpleTablaHashNodo(NuevoCliente);

                if(!VariablesGlobales.EstoyEnRehashin)
                {
                    if(VariablesGlobales.EstoyEnCargaMasiva)
                    {
                        VariablesGlobales.ContadorCargaMasiva++;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Cliente Agregado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
        
        //Actualización

        //Modifcar Cliente

        public void ModificarClienteTablaHashClientes(String DPI, ModeloClientes ClienteActual)
        {
            //Declaraciones

            ListaSimpleClientesNodo UsuarioModificado = BuscarClienteTablaHashClientes(DPI);

            if(UsuarioModificado != null)
            {
                UsuarioModificado.setNuevoCliente(ClienteActual);

                JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Cliente No Existe En El Sistema!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //Eliminación
        
        //Eliminar Cliente
        
        public void EliminarClienteTablaHashClientes(String DPI)
        {
            //Declaraciones

            BigInteger PosicionHash = FuncionCalcularHash(DPI);
            int PosicionHashInt = PosicionHash.intValue();
            boolean Bandera = VerificarClienteTablaHashClientes(DPI);

            if(Bandera)
            {
                if(Clientes[PosicionHashInt] != null)
                {
                    Clientes[PosicionHashInt].EliminarClienteListaSimpleTablaHashNodo(DPI);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Cliente Indicado No Existe En El Sistema!", "Exito!", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Busqueda

        //Buscar Cliente Existente

        public boolean VerificarClienteTablaHashClientes(String DPI)
        {
            //Declaraciones

            //Variables Tipo Boolean

            boolean AuxiliarBool = false;

            BigInteger PosicionHash = FuncionCalcularHash(DPI);

            int PosicionHashInt = PosicionHash.intValue();

            if(Clientes[PosicionHashInt] != null)
            {
                ListaSimpleClientesNodo UsuarioBuscado = Clientes[PosicionHashInt].BuscarClienteListaSimpleTablaHashNodo(DPI);

                if(UsuarioBuscado != null)
                {
                    AuxiliarBool = true;
                    return AuxiliarBool;
                }
            }
            return AuxiliarBool;
        }

        //Buscar Cliente

        public ListaSimpleClientesNodo BuscarClienteTablaHashClientes(String DPI)
        {
            //Declaraciones

            BigInteger PosicionHash = FuncionCalcularHash(DPI);
            int PosicionHashInt = PosicionHash.intValue();

            if(Clientes[PosicionHashInt] != null)
            {
                ListaSimpleClientesNodo UsuarioBuscado = Clientes[PosicionHashInt].BuscarClienteListaSimpleTablaHashNodo(DPI);

                return UsuarioBuscado;
            }
            return null;
        }

        //Recorridos

        //Listar Todos Los Clientes

        public ArrayList<ModeloClientes> ListarTodosLosClientesTablaHashClientes()
        {
            //Declaraciones

            //Array Modelo Clientes

            ArrayList<ModeloClientes> ArrayAuxiliar = new ArrayList<ModeloClientes>();
            ArrayList<ModeloClientes> ArrayAuxiliarListaSimple = new ArrayList<ModeloClientes>();

            for(TablaHashClientesNodo Clave: Clientes)
            {
                if(Clave != null)
                {
                    if(Clave.getListaSimpleClientes() != null)
                    {
                        ArrayAuxiliarListaSimple = Clave.getListaSimpleClientes().ListarTodosLosClientesListaSimpleC();

                        ArrayAuxiliar.addAll(ArrayAuxiliarListaSimple);
                    }
                }
            }
            return ArrayAuxiliar;
        }
        
        //Cargar Masiva

        //Cargar Clientes

        public void CargaMasivaTablaHashClientes()
        {
            //Declaraciones

            //Variables Modelo Condcutores

            ModeloClientes NuevoCliente = new ModeloClientes();

            //Variable Tipo Carga Masiva

            CargaMasiva CM = new CargaMasiva();

            CM.CargaMasiva(';',',',"txt","Clientes",7);

            if(VariablesGlobales.ItemsArchivo != null)
            {
                for(String[] Datos: VariablesGlobales.ItemsArchivo)
                {
                    NuevoCliente = new ModeloClientes();
                    NuevoCliente.setDPICliente(Datos[0].trim());
                    NuevoCliente.setNombresCliente(Datos[1].trim());
                    NuevoCliente.setApellidosCliente(Datos[2].trim());
                    NuevoCliente.setFechaNacimentoCliente(Datos[4].trim());
                    NuevoCliente.setGeneroCliente(Datos[3].trim());
                    NuevoCliente.setTelefonoCliente(Integer.parseInt(Datos[5].trim()));
                    NuevoCliente.setDireccionCliente(Datos[6].trim());

                    InsertarClienteTablaHashClientes(NuevoCliente);
                }
                VariablesGlobales.ItemsArchivo=null;
            }
        }

        //Reporte

        //Generar Reporte

        public void GenerarReporteTablaHashClientes()
        {
            String Cadena = "";
            Cadena += "digraph G \n { \n    rankdir = \"LR\"; \n    node[shape = rect color = brown fontcolor = lightbrown]; \n";
            Cadena += "parent[label =<\n <table border = '0' color = 'orange' cellspacing = '0' style = 'rounded' cellborder = '1'> \n";

            int Contador = 1;

            for(TablaHashClientesNodo Clave: Clientes)
            {
                Cadena += "<tr><td bgcolor = \"lightblue\" port = 'port_" + Contador + "' HEIGHT = \"200\">" + Contador + "</td></tr>";
                Contador++;
            }

            Contador = 1;
            Cadena += "</table> \n >];";

            for(TablaHashClientesNodo Clave: Clientes)
            {
                if(Clave != null)
                {
                    if(Clave.getListaSimpleClientes() != null)
                    {
                        Cadena += Clave.getListaSimpleClientes().GenerarReporteListaSimple(Contador);

                        if(Clave.getListaSimpleClientes().getListaSimpleUsuariosInicio() != null)
                        {
                            Cadena += "parent:port_" + Contador + " -> " + Clave.getListaSimpleClientes().getListaSimpleUsuariosInicio().getNuevoCliente().getDPICliente() + " [lhead = Usuario" + Contador + "]; \n";
                        }
                    }
                }
                Contador++;
            }

            Cadena += "}";

            GenerarReportes Reporte = new GenerarReportes("ReporteClientesTablaHash", Cadena);
        }
    }

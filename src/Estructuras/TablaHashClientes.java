
//---------------------------------------------Paquete E Imports--------------------------------------------------------

    package Estructuras;

    import Metodos.CargaMasiva;
    import Modelos.ModeloClientes;
    import Modelos.ModeloConductores;
    import Variables.VariablesGlobales;

    import javax.swing.*;
    import java.math.BigInteger;
    import java.util.ArrayList;

//-------------------------------------------------Principal------------------------------------------------------------

    public class TablaHashClientes
    {
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

        //Funcion Hash

        public BigInteger FuncionCalcularHash(String DPI)
        {
            //Conversion

            BigInteger DPIAuxiliar = new BigInteger(DPI);
            BigInteger SizeMod = new BigInteger(String.valueOf(Size));

            return DPIAuxiliar.mod(SizeMod);
        }

        //Inserción

        //Insertar Nuevo Cliente

        public void InsertarClienteTablaHashClientes(ModeloClientes NuevoCliente)
        {
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
            else
            {
                TablaHashClientesNodo NuevoNodoClientes = new TablaHashClientesNodo();
                Clientes[PosicionHashInt] = NuevoNodoClientes;
                Clientes[PosicionHashInt].InsertarClienteListaSimpleTablaHashNodo(NuevoCliente);

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
    }

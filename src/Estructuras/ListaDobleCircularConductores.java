
//---------------------------------------------Paquetes E Importaciones-------------------------------------------------

    package Estructuras;

    import Metodos.CargaMasiva;
    import Metodos.GenerarReportes;
    import Modelos.ModeloConductores;
    import Variables.VariablesGlobales;
    import javax.swing.*;
    import java.util.ArrayList;

//---------------------------------------------------Principal----------------------------------------------------------

    public class ListaDobleCircularConductores
    {
        //Atributos
        private ListaDobleCircularConductoresNodo ListaDobleInicio;

        //Métodos

        //Get Inicio Lista

        public ListaDobleCircularConductoresNodo getListaDobleInicio()
        {
            return ListaDobleInicio;
        }

        //Set Inicio Lista

        public void setListaDobleInicio(ListaDobleCircularConductoresNodo listaDobleInicio)
        {
            ListaDobleInicio = listaDobleInicio;
        }

        //Tamaño Lista Circular

        private int SizeListaDobleCircularC()
        {
            //Declaraciones

            //Variable Tipo Lista Doble Circular

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            //Variables Tipo Int

            int Size = 0;

            if(Auxiliar != null)
            {
                do
                {
                    Size++;
                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getListaDobleInicio());
            }

            return Size;
        }

        //Inserción

        //Insertar Nuevo Conductor

        public void InsertarConductorFinalListaDobleCircularC(ModeloConductores NuevoConductor)
        {
            //Declaraciones
         
            //Variable Tipo Boolean

            boolean ExisteConductor = false;

            if(getListaDobleInicio() != null)
            {
                ExisteConductor = VerificarConductorListaDobleCircularC(NuevoConductor.getDPIConductor());
            }

            if(ExisteConductor)
            {
                JOptionPane.showMessageDialog(null, "El Conductor Indicado Ya Existe En El Sistema", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                //Nuevo Nodo Lista Simple
                ListaDobleCircularConductoresNodo NuevoNodoConductor = new ListaDobleCircularConductoresNodo(NuevoConductor);

                //Verificar Si La Lista Esta Vacia

                if(getListaDobleInicio() == null)
                {
                    //Agrego Al Inicio

                    NuevoNodoConductor.setSgte(NuevoNodoConductor);
                    NuevoNodoConductor.setAnte(NuevoNodoConductor);
                    setListaDobleInicio(NuevoNodoConductor);
                }
                else
                {
                    //Agrego Al Final

                    ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

                    while(Auxiliar.getSgte() != getListaDobleInicio())
                    {
                        Auxiliar = Auxiliar.getSgte();
                    }

                    Auxiliar.setSgte(NuevoNodoConductor);
                    NuevoNodoConductor.setAnte(Auxiliar);
                    NuevoNodoConductor.setSgte(getListaDobleInicio());
                    getListaDobleInicio().setAnte(NuevoNodoConductor);

                    //Ordenar Lista

                    OrdenamientoBurbujaListaDobleCircularC();
                }

                if(VariablesGlobales.EstoyEnCargaMasiva)
                {
                    VariablesGlobales.ContadorCargaMasiva++;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Conductor Agregado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                }
            }             
        }

        //Actualización

        //Modificar Usuario

        public void ModificarConductorListaDobleCircularC(ModeloConductores ConductorModificar)
        {
            //Declaraciones

            //Auxiliar Lista Doble

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            if(getListaDobleInicio() != null)
            {
                do
                {
                    if(ConductorModificar.getDPIConductor().equals(Auxiliar.getNuevoConductor().getDPIConductor()))
                    {
                        Auxiliar.getNuevoConductor().setNombresConductor(ConductorModificar.getNombresConductor());
                        Auxiliar.getNuevoConductor().setApellidosConductor(ConductorModificar.getApellidosConductor());
                        Auxiliar.getNuevoConductor().setFechaNacimientoConductor(ConductorModificar.getFechaNacimientoConductor());
                        Auxiliar.getNuevoConductor().setTipoLicenciaConductor(ConductorModificar.getTipoLicenciaConductor());
                        Auxiliar.getNuevoConductor().setGeneroConductor(ConductorModificar.getGeneroConductor());
                        Auxiliar.getNuevoConductor().setTelefonoConductor(ConductorModificar.getTelefonoConductor());
                        Auxiliar.getNuevoConductor().setDireccionConductor(ConductorModificar.getDireccionConductor());

                        JOptionPane.showMessageDialog(null, "Usuario Modificado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    }

                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getListaDobleInicio());
            }
        }

        //Eliminación

        //Eliminar Conductor

        public void EliminarConductorListaDobleCircularC(String DPI)
        {
            //Declaraciones

            //Variables Tipo Int

            int PosicionConductor = 0;

            if(SizeListaDobleCircularC() != 0)
            {
                PosicionConductor = EncontrarPosicionConductorListaDobleCircularC(DPI);

                if(PosicionConductor <= SizeListaDobleCircularC())
                {
                    if(PosicionConductor == 1)
                    {
                        if(SizeListaDobleCircularC() == 1)
                        {
                            setListaDobleInicio(null);

                            JOptionPane.showMessageDialog(null, "Conductor Eliminado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            ListaDobleCircularConductoresNodo Ultimo = getListaDobleInicio().getAnte();

                            setListaDobleInicio(getListaDobleInicio().getSgte());
                            Ultimo.setSgte(getListaDobleInicio());
                            getListaDobleInicio().setAnte(Ultimo);

                            JOptionPane.showMessageDialog(null, "Conductor Eliminado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else
                    {
                        ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

                        for(int i = 1; i <= PosicionConductor - 1; i++)
                        {
                            Auxiliar = Auxiliar.getSgte();
                        }

                        ListaDobleCircularConductoresNodo Anterior = Auxiliar.getAnte();
                        Auxiliar = Auxiliar.getSgte();
                        Anterior.setSgte(Auxiliar);
                        Auxiliar.setAnte(Anterior);

                        JOptionPane.showMessageDialog(null, "Conductor Eliminado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El Usuario Indicado No Existe En El Sistema", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Aún No Existen Usuarios En El Sistema", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        //Ordenamientos

        //Ordenamiento Burbuja Lista Doble

        private void OrdenamientoBurbujaListaDobleCircularC()
        {
             //Declaraciones

             //Auxiliares Lista Doble Circular
            
             ListaDobleCircularConductoresNodo Primero;
             ListaDobleCircularConductoresNodo Segundo;

             //Variables Tipo String
            
            String CodigoAuxiliar;
            String Nombres;
            String Apellidos;
            String FechaNacimiento;
            String TipoLicencia;
            String Genero;
            String Direccion;

            //Variables Tipo Int

            int Telefono;

            //Asignacion Variables

            Primero = getListaDobleInicio();

            if(getListaDobleInicio() != null)
            {
                while(Primero.getSgte() != getListaDobleInicio())
                {
                    //Asignacion Segundo

                    Segundo = Primero.getSgte();

                    //Comienzo Valor A Comparar

                    while(Segundo != getListaDobleInicio())
                    {
                        if(Primero.getNuevoConductor().getDPIConductor().compareTo(Segundo.getNuevoConductor().getDPIConductor()) > 0)
                        {
                            CodigoAuxiliar = Segundo.getNuevoConductor().getDPIConductor();
                            Nombres = Segundo.getNuevoConductor().getNombresConductor();
                            Apellidos = Segundo.getNuevoConductor().getApellidosConductor();
                            FechaNacimiento = Segundo.getNuevoConductor().getFechaNacimientoConductor();
                            TipoLicencia = Segundo.getNuevoConductor().getTipoLicenciaConductor();
                            Genero = Segundo.getNuevoConductor().getGeneroConductor();
                            Telefono = Segundo.getNuevoConductor().getTelefonoConductor();
                            Direccion = Segundo.getNuevoConductor().getDireccionConductor();

                            //Segundos
                            Segundo.getNuevoConductor().setDPIConductor(Primero.getNuevoConductor().getDPIConductor());
                            Segundo.getNuevoConductor().setNombresConductor(Primero.getNuevoConductor().getNombresConductor());
                            Segundo.getNuevoConductor().setApellidosConductor(Primero.getNuevoConductor().getApellidosConductor());
                            Segundo.getNuevoConductor().setFechaNacimientoConductor(Primero.getNuevoConductor().getFechaNacimientoConductor());
                            Segundo.getNuevoConductor().setTipoLicenciaConductor(Primero.getNuevoConductor().getTipoLicenciaConductor());
                            Segundo.getNuevoConductor().setGeneroConductor(Primero.getNuevoConductor().getGeneroConductor());
                            Segundo.getNuevoConductor().setTelefonoConductor(Primero.getNuevoConductor().getTelefonoConductor());
                            Segundo.getNuevoConductor().setDireccionConductor(Primero.getNuevoConductor().getDireccionConductor());

                            //Primeros
                            Primero.getNuevoConductor().setDPIConductor(CodigoAuxiliar);
                            Primero.getNuevoConductor().setNombresConductor(Nombres);
                            Primero.getNuevoConductor().setApellidosConductor(Apellidos);
                            Primero.getNuevoConductor().setFechaNacimientoConductor(FechaNacimiento);
                            Primero.getNuevoConductor().setTipoLicenciaConductor(TipoLicencia);
                            Primero.getNuevoConductor().setGeneroConductor(Genero);
                            Primero.getNuevoConductor().setTelefonoConductor(Telefono);
                            Primero.getNuevoConductor().setDireccionConductor(Direccion);
                        }
                        Segundo = Segundo.getSgte();
                    }
                    Primero = Primero.getSgte();
                }    
            }           
        }

        //Búsqueda

        //Verificar Conductor

        public boolean VerificarConductorListaDobleCircularC(String DPIUsuario)
        {
            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            do
            {
                if(DPIUsuario.equals(Auxiliar.getNuevoConductor().getDPIConductor()))
                {
                    return true;
                }
                Auxiliar = Auxiliar.getSgte();
            }
            while(Auxiliar != getListaDobleInicio());
            
            return false;
        }

        //Buscar Conductor

        public ModeloConductores BuscarUsuarioListaDobleCircularC(String DPIUsuario)
        {
            //Declaraciones

            //Auxiliar Lista Doble

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            //Variables Tipo Modelo Conductores

            ModeloConductores ConductorEncontrado = new ModeloConductores();

            do
            {
                if(DPIUsuario.equals(Auxiliar.getNuevoConductor().getDPIConductor()))
                {
                    ConductorEncontrado = Auxiliar.getNuevoConductor();
                    return ConductorEncontrado;
                }
                Auxiliar = Auxiliar.getSgte();
            }
            while(Auxiliar != getListaDobleInicio());

            return null;
        }

        //Buscar Nodo Condcutro

        public ListaDobleCircularConductoresNodo BuscarNododCondcutoresListaDobleCircularC(String DPIConductor)
        {
            //Declaraciones

            //Auxiliar Lista Doble

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            do
            {
                if(DPIConductor.equals(Auxiliar.getNuevoConductor().getDPIConductor()))
                {
                    return Auxiliar;
                }
                Auxiliar = Auxiliar.getSgte();
            }
            while(Auxiliar != getListaDobleInicio());

            return null;
        }

        //Encontrar Posicion Conductor

        private int EncontrarPosicionConductorListaDobleCircularC(String DPI)
        {
            //Declaraciones

            //Variable Tipo Lista Doble Circular

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            //Variables Tipo Int

            int Posicion = 0;

            if(Auxiliar != null)
            {
                do
                {
                    Posicion++;

                    if(Auxiliar.getNuevoConductor().getDPIConductor().equals(DPI))
                    {
                        return Posicion;
                    }
                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getListaDobleInicio());
            }

            return 0;
        }

        //Recorridos

        //Obtener Todos Los Conductores

        public ArrayList<ModeloConductores> ObtenerTodosLosConductoresListaDobleCircularC()
        {
            //Declaraciones

            //Auxilair Lista Doble

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            //Array Tipo Modelo Conductor

            ArrayList<ModeloConductores> ArrayConductores = new ArrayList<ModeloConductores>();

            if(getListaDobleInicio() != null)
            {
                do
                {
                    ArrayConductores.add(Auxiliar.getNuevoConductor());
                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getListaDobleInicio());
            }

            return ArrayConductores;
        }

        //Reportes

        //Generar Reporte Conductores

        public void GenerarReporteListaDobleCircularC()
        {
            //Declaraciones

            //Variables Tipo Int

            int ContadorAuxiliar = 0;

            //Variables Tipo String

            String Cadena = "";
            String Asc = "";
            String Desc = "";
            String Same = "";

            //Array String

            String[] Temporal = new String[100];

            //Auxiliar Tipo Lista Doble

            ListaDobleCircularConductoresNodo Auxiliar = getListaDobleInicio();

            Cadena += "digraph ListaDobleCircular" + "\n";
            Cadena += "{" + "\n";
            Cadena += "graph [charset=latin1]" + "\n";
            Cadena += "node [shape = box, style = rounded, color = brown1, fontcolor = darkslategray];" + "\n";

            if(getListaDobleInicio() != null)
            {
                do
                {
                    Cadena += "A" + ContadorAuxiliar + " [label = \"DPI: " + Auxiliar.getNuevoConductor().getDPIConductor();
                    Cadena += "\\lNombres: " + Auxiliar.getNuevoConductor().getNombresConductor();
                    Cadena += "\\lApellidos: " + Auxiliar.getNuevoConductor().getApellidosConductor();
                    Cadena += "\\lFecha Nacimiento" + Auxiliar.getNuevoConductor().getFechaNacimientoConductor();
                    Cadena += "\\lTipo De Licencia: " + Auxiliar.getNuevoConductor().getTipoLicenciaConductor();
                    Cadena += "\\lGenero: " + Auxiliar.getNuevoConductor().getGeneroConductor();
                    Cadena += "\\lTelefono: " + Auxiliar.getNuevoConductor().getTelefonoConductor();
                    Cadena += "\\lDireccion: " + Auxiliar.getNuevoConductor().getDireccionConductor();
                    Cadena += "\\l\"]" + "\n";

                    Temporal[ContadorAuxiliar] = "A" + ContadorAuxiliar;
                    ContadorAuxiliar++;
                    Auxiliar = Auxiliar.getSgte();
                }
                while(Auxiliar != getListaDobleInicio());

                for(int i = 0; i < ContadorAuxiliar; i++)
                {
                    Same = Same + Temporal[i] + " ";

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

                if(ContadorAuxiliar > 1)
                {
                    Asc = Asc + "->" + "A0" + "->" + "A" + (ContadorAuxiliar - 1) + "\n";
                }

                Cadena += "{ rank = same " + Same + "}" + "\n";
                Cadena += Asc + "\n";
                Cadena += " " + "\n";
                Cadena += Desc + "\n";
                Cadena += "}" + "\n";

                GenerarReportes Reporte = new GenerarReportes("ReporteConductoresListaDobleCircular", Cadena);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "La Lista Se Encuentra Vacia", "Error!", JOptionPane.ERROR_MESSAGE);
            }


        }

        //Carga Masiva

        //Cargar Conductores

        public void CargaMasivaListaDobleCircularC()
        {
            //Declaraciones

            //Variables Modelo Condcutores

            ModeloConductores NuevoConductor = new ModeloConductores();

            //Variable Tipo Carga Masiva

            CargaMasiva CM = new CargaMasiva();

            CM.CargaMasiva(';','%',"txt","Conductores",8);

            if(VariablesGlobales.ItemsArchivo != null)
            {
                for(String[] Datos: VariablesGlobales.ItemsArchivo)
                {
                    NuevoConductor = new ModeloConductores();
                    NuevoConductor.setDPIConductor(Datos[0].trim());
                    NuevoConductor.setNombresConductor(Datos[1].trim());
                    NuevoConductor.setApellidosConductor(Datos[2].trim());
                    NuevoConductor.setFechaNacimientoConductor(Datos[5].trim());
                    NuevoConductor.setTipoLicenciaConductor(Datos[3].trim());
                    NuevoConductor.setGeneroConductor(Datos[4].trim());
                    NuevoConductor.setTelefonoConductor(Integer.parseInt(Datos[6].trim()));
                    NuevoConductor.setDireccionConductor(Datos[7].trim());

                    InsertarConductorFinalListaDobleCircularC(NuevoConductor);
                }
                VariablesGlobales.ItemsArchivo=null;
            }
        }
    }

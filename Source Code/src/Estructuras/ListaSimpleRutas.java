
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Estructuras;

    import Metodos.GenerarReportes;
    import Modelos.ModeloRutas;

    import javax.swing.*;

//--------------------------------------------------Principal-----------------------------------------------------------

    public class ListaSimpleRutas
    {
        //Atributos
        private ListaSimpleRutasNodo ListaSimpleRutasInicio;

        //-------------------------------------------Métodos------------------------------------------------------------

        //Gets And Sets

        public ListaSimpleRutasNodo getListaSimpleRutasInicio()
        {
            return ListaSimpleRutasInicio;
        }

        public void setListaSimpleRutasInicio(ListaSimpleRutasNodo listaSimpleRutasInicio)
        {
            ListaSimpleRutasInicio = listaSimpleRutasInicio;
        }

        //Tamaño Lista

        //Size

        public int SizeListaSimpleRutas()
        {
            //Declaraciones

            ListaSimpleRutasNodo NodoAuxiliar = getListaSimpleRutasInicio();

            int Auxiliar = 0;

            while(NodoAuxiliar != null)
            {
                Auxiliar++;

                NodoAuxiliar = NodoAuxiliar.getSgte();
            }

            return Auxiliar;
        }

        //Inserción

        //Insertar Nueva Ruta

        public void InsertarLugarListaSimpleRutas(ModeloRutas NuevoLugar)
        {
            //Declaraciones

            ListaSimpleRutasNodo NuevoNodoLugar = new ListaSimpleRutasNodo(NuevoLugar);

            if(getListaSimpleRutasInicio() == null)
            {
                NuevoNodoLugar.setSgte(null);
                setListaSimpleRutasInicio(NuevoNodoLugar);
            }
            else
            {
                ListaSimpleRutasNodo Auxiliar = getListaSimpleRutasInicio();

                while(Auxiliar.getSgte() != null)
                {
                    Auxiliar = Auxiliar.getSgte();
                }
                Auxiliar.setSgte(NuevoNodoLugar);
            }
        }

        //Reporte

        //Reporte Lista Simple

        public void GenerarReporteListaSimpleRutas()
        {
            //Declaraciones

            //Variables Tipo Int

            int ContadorAuxiliar = 0;

            //Variables Tipo String

            String Cadena = "";
            String Asc = "";
            String Same = "";

            //Array String

            String[] Temporal = new String[100];

            //Auxiliar Tipo Lista Doble

            ListaSimpleRutasNodo AuxiliarNodo = getListaSimpleRutasInicio();

            Cadena += "digraph ListaDobleCircular" + "\n";
            Cadena += "{" + "\n";
            Cadena += "graph [charset=latin1]" + "\n";
            Cadena += "node [shape = box, style = rounded, color = brown1, fontcolor = darkslategray];" + "\n";

            if(getListaSimpleRutasInicio() != null)
            {
                while(AuxiliarNodo != null)
                {
                    Cadena += "A" + ContadorAuxiliar + " [label = \"Lugar: " + AuxiliarNodo.getNuevaRuta().getLugar();
                    Cadena += "\\lTiempo: " + AuxiliarNodo.getNuevaRuta().getTiempo();
                    Cadena += "\\l\"]" + "\n";

                    Temporal[ContadorAuxiliar] = "A" + ContadorAuxiliar;
                    ContadorAuxiliar++;

                    AuxiliarNodo = AuxiliarNodo.getSgte();
                }

                for(int i = 0; i < ContadorAuxiliar; i++)
                {
                    Same = Same + Temporal[i] + " ";

                    if(i < ContadorAuxiliar - 1)
                    {
                        Asc = Asc + Temporal[i] + "->";
                    }
                    else
                    {
                        Asc = Asc + Temporal[i];
                    }
                }

                Cadena += "{ rank = same " + Same + "}" + "\n";
                Cadena += Asc + "\n";
                Cadena += " " + "\n";
                Cadena += "}" + "\n";

                GenerarReportes Reporte = new GenerarReportes("ReporteViajesListaSimple", Cadena);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "La Lista Se Encuentra Vacia", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        public String GenerarSubGrafica(String AuxiliarGrafica)
        {
            //Declaraciones

            //Variables Tipo Int

            int ContadorAuxiliar = 0;

            //Variables Tipo String

            String Cadena = "";
            String Asc = "";
            String Same = "";

            //Array String

            String[] Temporal = new String[100];

            //Auxiliar Tipo Lista Doble

            ListaSimpleRutasNodo AuxiliarNodo = getListaSimpleRutasInicio();

            if(getListaSimpleRutasInicio() != null)
            {
                while (AuxiliarNodo != null)
                {
                    Cadena += "A" + ContadorAuxiliar + AuxiliarGrafica +  " [label = \"Lugar: " + AuxiliarNodo.getNuevaRuta().getLugar();
                    Cadena += "\\lTiempo: " + AuxiliarNodo.getNuevaRuta().getTiempo();
                    Cadena += "\\l\"]" + "\n";

                    Temporal[ContadorAuxiliar] = "A" + ContadorAuxiliar + AuxiliarGrafica;
                    ContadorAuxiliar++;

                    AuxiliarNodo = AuxiliarNodo.getSgte();
                }

                for (int i = 0; i < ContadorAuxiliar; i++)
                {
                    if (i < ContadorAuxiliar - 1) {
                        Asc = Asc + Temporal[i] + "->";
                    } else {
                        Asc = Asc + Temporal[i];
                    }
                }

                Cadena += Asc + "\n";
                Cadena += " " + "\n";

            }

            return Cadena;
        }

    }

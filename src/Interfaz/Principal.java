
//-----------------------------------------------Paquetes E Imports-----------------------------------------------------

    package Interfaz;

    import java.awt.event.*;
    import java.awt.*;
    import java.util.ArrayList;
    import java.util.Objects;
    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;

<<<<<<< HEAD
    import Estructuras.HuffmanNodo;
    import Estructuras.ListaDobleCircularTopsNodo;
=======
    import Estructuras.BlockchainViajesNodo;
>>>>>>> 0ac3cb877cbbd5a7aaa60e996b177feb11a36077
    import Interfaz.Clientes.ClientesInterfaz;
    import Interfaz.Conductores.*;
    import Interfaz.Huffman.Comprecion_Descomprecion;
    import Interfaz.Rutas.Rutas;
    import Interfaz.Vehiculos.VehiculosInterfaz;
    import Interfaz.Viajes.ViajesInterfaz;
    import Modelos.ModeloViajes;
    import Variables.VariablesGlobales;

//-----------------------------------------------------Author-----------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//----------------------------------------------------Principal---------------------------------------------------------

    public class Principal extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //--------------------------------------------Constructor-------------------------------------------------------

        public Principal()
        {
            initComponents();
            ButtonGroup MenuConductor = new ButtonGroup();
            MenuConductor.add(RBT_Clientes);
            MenuConductor.add(RBT_Vehiculos);
            MenuConductor.add(RBT_Conductores);
            MenuConductor.add(RBT_Rutas);
            MenuConductor.add(RBT_Viajes);
            RBT_Clientes.setSelected(true);
        }

        //----------------------------------------------Métodos---------------------------------------------------------

        //Validar Opcion RadioButton

        public void ValidarRadioButton()
        {
            if(RBT_Clientes.isSelected())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new ClientesInterfaz().setVisible(true);
                    }
                });
            }
            else if(RBT_Vehiculos.isSelected())
            {
                new VehiculosInterfaz().setVisible(true);
            }
            else if(RBT_Conductores.isSelected())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new ConductoresInterfaz().setVisible(true);
                    }
                });
            }
            else if(RBT_Rutas.isSelected())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new Rutas().setVisible(true);
                    }
                });

            }
            else if(RBT_Viajes.isSelected())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new ViajesInterfaz().setVisible(true);
                    }
                });
            }
        }

        public void ObtenerBloques(JTable NuevaTabla, ArrayList<ModeloViajes> ListaViajes)
        {
            Modelo = new DefaultTableModel();
            Modelo.addColumn("Codigo");
            Modelo.addColumn("Origne");
            Modelo.addColumn("Destino");

            for(ModeloViajes Viaje: ListaViajes)
            {
                if (Viaje != null)
                {
                    Object[] Fila = new Object[]
                            {
                                    Viaje.getIdentificadorViaje(),
                                    Viaje.getLugarOrigenViaje(),
                                    Viaje.getLugaDestinoViaje()
                            };
                    Modelo.addRow(Fila);
                }
            }
            NuevaTabla.setModel(Modelo);
            NuevaTabla.getColumnModel().getColumn(0).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(1).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(2).setPreferredWidth(400);
            NuevaTabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }

        //-----------------------------------------------Events---------------------------------------------------------

        private void BT_AcercaDEActionPerformed(ActionEvent e)
        {
            //Declaraciones

            //Variables Tipo String

            String Cadena = "";

            Cadena += "                           Proyecto 2 \n";
            Cadena += "                         Llega Rapidito \n";
            Cadena += "      Integrantes: \n";
            Cadena += "      1.Sergio Alexander Echigoyen Gomez 201801628 \n";
            Cadena += "      2.Randy Alexander Can Ajuchan 201801527 \n";

            JOptionPane.showMessageDialog(null, Cadena, "Información!", JOptionPane.INFORMATION_MESSAGE);
        }

        private void BT_CargaMConductoresActionPerformed(ActionEvent e)
        {
            VariablesGlobales.EstoyEnCargaMasiva = true;
            VariablesGlobales.ContadorCargaMasiva = 0;
            VariablesGlobales.ListaDobleCircularConductores.CargaMasivaListaDobleCircularC();

            JOptionPane.showMessageDialog(null, "Se Agregaron " + VariablesGlobales.ContadorCargaMasiva + " Conductores Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);

            VariablesGlobales.EstoyEnCargaMasiva = false;
        }

        private void BT_CargaMClientesActionPerformed(ActionEvent e)
        {
            VariablesGlobales.EstoyEnCargaMasiva = true;
            VariablesGlobales.ContadorCargaMasiva = 0;
            VariablesGlobales.TablaHashClientes.CargaMasivaTablaHashClientes();

            JOptionPane.showMessageDialog(null, "Se Agregaron " + VariablesGlobales.ContadorCargaMasiva + " Clientes Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);

            VariablesGlobales.EstoyEnCargaMasiva = false;
        }

        private void RBT_ClientesActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void RBT_VehiculosActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void RBT_ConductoresActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void RBT_RutasActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void RBT_ViajesActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void CargaMasivaVehiculosActionPerformed(ActionEvent e)
        {
            VariablesGlobales.ArbolBAutomoviles.CargaMasiva();
        }

        private void CargaMasivaVehiculos(ActionEvent e)
        {
            // TODO add your code here
        }

        private void BT_TopViajesLargosActionPerformed(ActionEvent e)
        {
            VariablesGlobales.BlockchainViajes.TopViajesLargosBlockchainViajes();
                   
            if(VariablesGlobales.ListaDobleCircularTops != null)
            {
                VariablesGlobales.ListaDobleCircularTops.OrdenamientoBurbujaListaDobleCircularT();
                
                String Cadena = VariablesGlobales.ListaDobleCircularTops.GenerarTopViajesLargos();
                
                JOptionPane.showMessageDialog(null, "Reporte Viajes Mas Largos: \n" + Cadena, "Exito!", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private void BT_RutaViajeActionPerformed(ActionEvent e)
        {
            //Declaraciones

            Modelo = new DefaultTableModel();
            ArrayList<ModeloViajes> ListaViajes = VariablesGlobales.BlockchainViajes.TodosLosBloquesBlockchainViajes();
            JTable Tabla = new JTable();
            Tabla.setFont(new Font("Arial", Font.BOLD, 16));
            Tabla.setForeground(new Color(255, 51, 102));
            Tabla.setBounds(10, 5, 50, 50);
            ObtenerBloques(Tabla, ListaViajes);

            int Mensaje = JOptionPane.showConfirmDialog(null, new JScrollPane(Tabla), "Seleccione Un Viaje", JOptionPane.OK_CANCEL_OPTION);

            if(Mensaje == JOptionPane.OK_OPTION)
            {
                int Fila = Tabla.getSelectedRow();
                String Valor = (String) Tabla.getValueAt(Fila, 0);

                if(!Valor.equals(""))
                {
                    BlockchainViajesNodo NodoViajes = VariablesGlobales.BlockchainViajes.BuscarViajeBlockchainViaje(Valor);

                    VariablesGlobales.NombreReporte = "ReporteViajesListaSimple.png";
                    NodoViajes.getNuevoViaje().getListaRutaViaje().GenerarReporteListaSimpleRutas();

                    if(VariablesGlobales.GenereReporte)
                    {
                        JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                        java.awt.EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run()
                            {
                                new Reportes().setVisible(true);
                            }
                        });
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "El Reporte No Se Pudo Generar Con Exito \nVerifique Que Graphviz Se Encuentre Configurado De Manera Correcta", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

        private void BT_TopClientesActionPerformed(ActionEvent e)
        {
            VariablesGlobales.BlockchainViajes.TopClientesConMasViajes();

            if(VariablesGlobales.ListaDobleCircularTops != null)
            {
                VariablesGlobales.ListaDobleCircularTops.OrdenamientoBurbujaListaDobleCircularT();

                String Cadena = VariablesGlobales.ListaDobleCircularTops.GenerarTopClientesConMasViajes();

                JOptionPane.showMessageDialog(null, "Reporte Clientes Con Mayor Cantidad De Viajes: \n" + Cadena, "Exito!", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private void BT_TopConductoresActionPerformed(ActionEvent e)
        {
            VariablesGlobales.BlockchainViajes.TopConductoresConMasViajes();

            if(VariablesGlobales.ListaDobleCircularTops != null)
            {
                VariablesGlobales.ListaDobleCircularTops.OrdenamientoBurbujaListaDobleCircularT();

                String Cadena = VariablesGlobales.ListaDobleCircularTops.GenerarTopConductoresConMasViajes();

                JOptionPane.showMessageDialog(null, "Reporte Conductors Que Generan Mas Ingresos: \n" + Cadena, "Exito!", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private void BT_TopVehiculosActionPerformed(ActionEvent e)
        {
            VariablesGlobales.BlockchainViajes.TopVehiculosConMasViaje();

            if(VariablesGlobales.ListaDobleCircularTops != null)
            {
                VariablesGlobales.ListaDobleCircularTops.OrdenamientoBurbujaListaDobleCircularT();

                String Cadena = VariablesGlobales.ListaDobleCircularTops.GenerarTopVehiculosConMasViajes();

                JOptionPane.showMessageDialog(null, "Reporte Vehiculos Con Mayor Cantidad De Viajes: \n" + Cadena, "Exito!", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private void BT_ComprimirActionPerformed(ActionEvent e)
        {
            //Declaraciones

            JComboBox<String> Cat = new JComboBox<String>();
            Cat.setEditable(true);
            Cat.setFont(new Font("Arial", Font.BOLD, 16));
            Cat.setForeground(new Color(0, 153, 255));
            Cat.addItem("1.Top Viajes");
            Cat.addItem(("2.Top Clientes"));
            Cat.addItem("3.Top Conductores");
            Cat.addItem("4.Top Vehiculos");

            int Mensaje = JOptionPane.showConfirmDialog(null, Cat, "Seleccione Un Top", JOptionPane.OK_CANCEL_OPTION);

            if(Mensaje == JOptionPane.OK_OPTION)
            {
                String Texto = (String) Cat.getSelectedItem();

                if(Texto != null)
                {
                    switch (Texto)
                    {
                        case "1.Top Viajes":
                            VariablesGlobales.BlockchainViajes.TopViajesLargosBlockchainViajes();

                            if (VariablesGlobales.ListaDobleCircularTops != null)
                            {
                                VariablesGlobales.ListaDobleCircularTops.OrdenamientoBurbujaListaDobleCircularT();

                                String Cadena = VariablesGlobales.ListaDobleCircularTops.GenerarTopViajesLargos();

                                //Aqui Comprimis Cadena Tiene Todo El Top
                            }
                            break;
                        case "2.Top Clientes":
                            VariablesGlobales.BlockchainViajes.TopClientesConMasViajes();

                            if (VariablesGlobales.ListaDobleCircularTops != null) {
                                VariablesGlobales.ListaDobleCircularTops.OrdenamientoBurbujaListaDobleCircularT();

                                String Cadena = VariablesGlobales.ListaDobleCircularTops.GenerarTopClientesConMasViajes();

                                //Aqui Comprimis Cadena Tiene Todo El Top
                            }
                            break;
                        case "3.Top Conductoress":
                            VariablesGlobales.BlockchainViajes.TopConductoresConMasViajes();

                            if (VariablesGlobales.ListaDobleCircularTops != null) {
                                VariablesGlobales.ListaDobleCircularTops.OrdenamientoBurbujaListaDobleCircularT();

                                String Cadena = VariablesGlobales.ListaDobleCircularTops.GenerarTopConductoresConMasViajes();

                                //Aqui Comprimis Cadena Tiene Todo El Top
                            }
                            break;
                        case "4.Top Vehiculos":
                            VariablesGlobales.BlockchainViajes.TopVehiculosConMasViaje();

                            if (VariablesGlobales.ListaDobleCircularTops != null) {
                                VariablesGlobales.ListaDobleCircularTops.OrdenamientoBurbujaListaDobleCircularT();

                                String Cadena = VariablesGlobales.ListaDobleCircularTops.GenerarTopVehiculosConMasViajes();

                                //Aqui Comprimis Cadena Tiene Todo El Top
                            }
                            break;
                    }
                }
            }
        }

        private void BT_DescomprimirActionPerformed(ActionEvent e)
        {
            //Aqui Descomprimis jajaja xD
        }

        //---------------------------------------------Main-------------------------------------------------------------

        public static void main(String[] args)
        {
            java.awt.EventQueue.invokeLater(new Runnable()
            {
                @Override
                public void run()
                {
                    new Principal().setVisible(true);
                }
            });
        }

        private void button1ActionPerformed(ActionEvent e) {
            new Comprecion_Descomprecion().setVisible(true);
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - unknown
            menuBar1 = new JMenuBar();
            menu2 = new JMenu();
            menu3 = new JMenu();
            BT_CargaMClientes = new JMenuItem();
            CargaMasivaVehiculos = new JMenuItem();
            BT_CargaMConductores = new JMenuItem();
            menu4 = new JMenu();
            BT_TopViajesLargos = new JMenuItem();
            BT_TopClientes = new JMenuItem();
            BT_TopConductores = new JMenuItem();
            BT_TopVehiculos = new JMenuItem();
            BT_RutaViaje = new JMenuItem();
            BT_Comprimir = new JMenuItem();
            BT_Descomprimir = new JMenuItem();
            menu5 = new JMenu();
            BT_AcercaDE = new JMenuItem();
            label2 = new JLabel();
            label1 = new JLabel();
            RBT_Vehiculos = new JRadioButton();
            RBT_Conductores = new JRadioButton();
            RBT_Clientes = new JRadioButton();
            RBT_Rutas = new JRadioButton();
            RBT_Viajes = new JRadioButton();
            label3 = new JLabel();
            button1 = new JButton();

            //======== this ========
            setTitle("Proyecto 2");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //======== menuBar1 ========
            {

                //======== menu2 ========
                {
                    menu2.setText("Archivo");
                    menu2.setFont(new Font("Arial", Font.BOLD, 14));
                    menu2.setForeground(new Color(51, 51, 255));
                    menu2.setIcon(new ImageIcon(getClass().getResource("/Assets/Archivo.png")));

                    //======== menu3 ========
                    {
                        menu3.setText("Carga Masiva");
                        menu3.setFont(new Font("Arial", Font.BOLD, 12));
                        menu3.setForeground(new Color(153, 51, 255));
                        menu3.setIcon(new ImageIcon(getClass().getResource("/Assets/CargaMasiva.png")));

                        //---- BT_CargaMClientes ----
                        BT_CargaMClientes.setText("Clientes");
                        BT_CargaMClientes.setFont(new Font("Arial", Font.BOLD, 12));
                        BT_CargaMClientes.setForeground(new Color(255, 51, 51));
                        BT_CargaMClientes.setIcon(new ImageIcon(getClass().getResource("/Assets/Clientes.jpg")));
                        BT_CargaMClientes.addActionListener(e -> BT_CargaMClientesActionPerformed(e));
                        menu3.add(BT_CargaMClientes);

                        //---- CargaMasivaVehiculos ----
                        CargaMasivaVehiculos.setText("Vehiculos");
                        CargaMasivaVehiculos.setFont(new Font("Arial", Font.BOLD, 12));
                        CargaMasivaVehiculos.setForeground(new Color(255, 51, 51));
                        CargaMasivaVehiculos.setIcon(new ImageIcon(getClass().getResource("/Assets/Vehiculos.png")));
                        CargaMasivaVehiculos.addActionListener(e -> {
			CargaMasivaVehiculos(e);
			CargaMasivaVehiculosActionPerformed(e);
		});
                        menu3.add(CargaMasivaVehiculos);

                        //---- BT_CargaMConductores ----
                        BT_CargaMConductores.setText("Conductores");
                        BT_CargaMConductores.setFont(new Font("Arial", Font.BOLD, 12));
                        BT_CargaMConductores.setForeground(new Color(255, 51, 51));
                        BT_CargaMConductores.setIcon(new ImageIcon(getClass().getResource("/Assets/Conductores.png")));
                        BT_CargaMConductores.addActionListener(e -> BT_CargaMConductoresActionPerformed(e));
                        menu3.add(BT_CargaMConductores);
                    }
                    menu2.add(menu3);
                }
                menuBar1.add(menu2);

                //======== menu4 ========
                {
                    menu4.setText("Herramientas");
                    menu4.setFont(new Font("Arial", Font.BOLD, 14));
                    menu4.setForeground(new Color(51, 51, 255));
                    menu4.setIcon(new ImageIcon(getClass().getResource("/Assets/Herramientas.jpg")));

                    //---- BT_TopViajesLargos ----
                    BT_TopViajesLargos.setText("Top Viajes: Viajes Mas Largos");
                    BT_TopViajesLargos.setFont(new Font("Arial", Font.BOLD, 12));
                    BT_TopViajesLargos.setForeground(new Color(153, 51, 255));
                    BT_TopViajesLargos.setIcon(new ImageIcon(getClass().getResource("/Assets/Top10.jpg")));
                    BT_TopViajesLargos.addActionListener(e -> BT_TopViajesLargosActionPerformed(e));
                    menu4.add(BT_TopViajesLargos);

                    //---- BT_TopClientes ----
                    BT_TopClientes.setText("Top Clientes: Clientes Con Mayor Cantidad De Viajes");
                    BT_TopClientes.setForeground(new Color(153, 51, 255));
                    BT_TopClientes.setFont(new Font("Arial", Font.BOLD, 12));
                    BT_TopClientes.setIcon(new ImageIcon(getClass().getResource("/Assets/Top10.jpg")));
                    BT_TopClientes.addActionListener(e -> BT_TopClientesActionPerformed(e));
                    menu4.add(BT_TopClientes);

                    //---- BT_TopConductores ----
                    BT_TopConductores.setText("Top Conductores: Conductores Con Mayor Cantidad De Ingresos");
                    BT_TopConductores.setForeground(new Color(153, 51, 255));
                    BT_TopConductores.setFont(new Font("Arial", Font.BOLD, 12));
                    BT_TopConductores.setIcon(new ImageIcon(getClass().getResource("/Assets/Top10.jpg")));
                    BT_TopConductores.addActionListener(e -> BT_TopConductoresActionPerformed(e));
                    menu4.add(BT_TopConductores);

                    //---- BT_TopVehiculos ----
                    BT_TopVehiculos.setText("Top Vehiculos: Vehiculos Con Mayor Cantidad De Viajes");
                    BT_TopVehiculos.setFont(new Font("Arial", Font.BOLD, 12));
                    BT_TopVehiculos.setForeground(new Color(153, 51, 255));
                    BT_TopVehiculos.setIcon(new ImageIcon(getClass().getResource("/Assets/Top10.jpg")));
                    BT_TopVehiculos.addActionListener(e -> BT_TopVehiculosActionPerformed(e));
                    menu4.add(BT_TopVehiculos);

                    //---- BT_RutaViaje ----
                    BT_RutaViaje.setText("Ruta De Un Viaje");
                    BT_RutaViaje.setForeground(new Color(153, 51, 255));
                    BT_RutaViaje.setFont(new Font("Arial", Font.BOLD, 12));
                    BT_RutaViaje.setIcon(new ImageIcon(getClass().getResource("/Assets/ListaRuta.jpg")));
                    BT_RutaViaje.addActionListener(e -> BT_RutaViajeActionPerformed(e));
                    menu4.add(BT_RutaViaje);

                    //---- BT_Comprimir ----
                    BT_Comprimir.setText("Comprimir Top");
                    BT_Comprimir.setFont(new Font("Arial", Font.BOLD, 12));
                    BT_Comprimir.setForeground(new Color(153, 51, 255));
                    BT_Comprimir.setIcon(new ImageIcon(getClass().getResource("/Assets/Comprimir.png")));
                    BT_Comprimir.addActionListener(e -> BT_ComprimirActionPerformed(e));
                    menu4.add(BT_Comprimir);

                    //---- BT_Descomprimir ----
                    BT_Descomprimir.setText("Descomprimir Top");
                    BT_Descomprimir.setForeground(new Color(153, 51, 255));
                    BT_Descomprimir.setFont(new Font("Arial", Font.BOLD, 12));
                    BT_Descomprimir.setIcon(new ImageIcon(getClass().getResource("/Assets/Comprimir.png")));
                    BT_Descomprimir.addActionListener(e -> BT_DescomprimirActionPerformed(e));
                    menu4.add(BT_Descomprimir);
                }
                menuBar1.add(menu4);

                //======== menu5 ========
                {
                    menu5.setText("Ayuda");
                    menu5.setFont(new Font("Arial", Font.BOLD, 14));
                    menu5.setForeground(new Color(51, 51, 255));
                    menu5.setIcon(new ImageIcon(getClass().getResource("/Assets/Ayuda.png")));

                    //---- BT_AcercaDE ----
                    BT_AcercaDE.setText("Acerca De...");
                    BT_AcercaDE.setForeground(new Color(153, 51, 255));
                    BT_AcercaDE.setFont(new Font("Arial", Font.BOLD, 12));
                    BT_AcercaDE.setIcon(new ImageIcon(getClass().getResource("/Assets/AcercaDe.png")));
                    BT_AcercaDE.addActionListener(e -> BT_AcercaDEActionPerformed(e));
                    menu5.add(BT_AcercaDE);
                }
                menuBar1.add(menu5);
            }
            setJMenuBar(menuBar1);

            //---- label2 ----
            label2.setText("Seleccione Una Opci\u00f3n:");
            label2.setForeground(new Color(0, 102, 255));
            label2.setFont(new Font("Arial", Font.BOLD, 20));
            contentPane.add(label2);
            label2.setBounds(260, 105, 226, 24);

            //---- label1 ----
            label1.setText("Proyecto 2: Llega Rapidito");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(235, 60, 275, 26);

            //---- RBT_Vehiculos ----
            RBT_Vehiculos.setText("Vehiculos");
            RBT_Vehiculos.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Vehiculos.setForeground(new Color(102, 102, 255));
            RBT_Vehiculos.addActionListener(e -> RBT_VehiculosActionPerformed(e));
            contentPane.add(RBT_Vehiculos);
            RBT_Vehiculos.setBounds(310, 200, 135, 28);

            //---- RBT_Conductores ----
            RBT_Conductores.setText("Conductores");
            RBT_Conductores.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Conductores.setForeground(new Color(102, 102, 255));
            RBT_Conductores.addActionListener(e -> RBT_ConductoresActionPerformed(e));
            contentPane.add(RBT_Conductores);
            RBT_Conductores.setBounds(310, 240, 135, 28);

            //---- RBT_Clientes ----
            RBT_Clientes.setText("Clientes");
            RBT_Clientes.setForeground(new Color(102, 102, 255));
            RBT_Clientes.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Clientes.addActionListener(e -> RBT_ClientesActionPerformed(e));
            contentPane.add(RBT_Clientes);
            RBT_Clientes.setBounds(310, 155, 135, 28);

            //---- RBT_Rutas ----
            RBT_Rutas.setText("Rutas");
            RBT_Rutas.setForeground(new Color(102, 102, 255));
            RBT_Rutas.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Rutas.addActionListener(e -> RBT_RutasActionPerformed(e));
            contentPane.add(RBT_Rutas);
            RBT_Rutas.setBounds(310, 280, 135, 28);

            //---- RBT_Viajes ----
            RBT_Viajes.setText("Viajes");
            RBT_Viajes.setForeground(new Color(102, 102, 255));
            RBT_Viajes.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Viajes.addActionListener(e -> RBT_ViajesActionPerformed(e));
            contentPane.add(RBT_Viajes);
            RBT_Viajes.setBounds(310, 320, 135, 28);
            contentPane.add(label3);
            label3.setBounds(670, 370, 45, 40);

            //---- button1 ----
            button1.setText("Comprecion");
            button1.addActionListener(e -> button1ActionPerformed(e));
            contentPane.add(button1);
            button1.setBounds(new Rectangle(new Point(320, 360), button1.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < contentPane.getComponentCount(); i++) {
                    Rectangle bounds = contentPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = contentPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                contentPane.setMinimumSize(preferredSize);
                contentPane.setPreferredSize(preferredSize);
            }
            pack();
            setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        }

        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        // Generated using JFormDesigner Evaluation license - unknown
        private JMenuBar menuBar1;
        private JMenu menu2;
        private JMenu menu3;
        private JMenuItem BT_CargaMClientes;
        private JMenuItem CargaMasivaVehiculos;
        private JMenuItem BT_CargaMConductores;
        private JMenu menu4;
        private JMenuItem BT_TopViajesLargos;
        private JMenuItem BT_TopClientes;
        private JMenuItem BT_TopConductores;
        private JMenuItem BT_TopVehiculos;
        private JMenuItem BT_RutaViaje;
        private JMenuItem BT_Comprimir;
        private JMenuItem BT_Descomprimir;
        private JMenu menu5;
        private JMenuItem BT_AcercaDE;
        private JLabel label2;
        private JLabel label1;
        private JRadioButton RBT_Vehiculos;
        private JRadioButton RBT_Conductores;
        private JRadioButton RBT_Clientes;
        private JRadioButton RBT_Rutas;
        private JRadioButton RBT_Viajes;
        private JLabel label3;
        private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

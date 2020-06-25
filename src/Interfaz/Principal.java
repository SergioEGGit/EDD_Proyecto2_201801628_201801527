
//-----------------------------------------------Paquetes E Imports-----------------------------------------------------

    package Interfaz;

    import java.awt.event.*;
    import java.awt.*;
    import javax.swing.*;
    import Interfaz.Clientes.ClientesInterfaz;
    import Interfaz.Conductores.*;
    import Interfaz.Rutas.Rutas;
    import Interfaz.Vehiculos.VehiculosInterfaz;
    import Variables.VariablesGlobales;

//-----------------------------------------------------Author-----------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//----------------------------------------------------Principal---------------------------------------------------------

    public class Principal extends JFrame
    {
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
                new Rutas().setVisible(true);
            }
            else if(RBT_Viajes.isSelected())
            {

            }
        }

        //-----------------------------------------------Events---------------------------------------------------------

        private void BT_AcercaDEActionPerformed(ActionEvent e)
        {
            //Declaraciones

            //Variables Tipo String

            String Cadena = "";

            Cadena += "                           Proyecto 2 \n";
            Cadena += "                    Laboratorio De Estructuras \n";
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

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            menuBar1 = new JMenuBar();
            menu2 = new JMenu();
            menu3 = new JMenu();
            BT_CargaMClientes = new JMenuItem();
            menuItem4 = new JMenuItem();
            BT_CargaMConductores = new JMenuItem();
            menu4 = new JMenu();
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

                        //---- menuItem4 ----
                        menuItem4.setText("Vehiculos");
                        menuItem4.setFont(new Font("Arial", Font.BOLD, 12));
                        menuItem4.setForeground(new Color(255, 51, 51));
                        menuItem4.setIcon(new ImageIcon(getClass().getResource("/Assets/Vehiculos.png")));
                        menu3.add(menuItem4);

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
        // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
        private JMenuBar menuBar1;
        private JMenu menu2;
        private JMenu menu3;
        private JMenuItem BT_CargaMClientes;
        private JMenuItem menuItem4;
        private JMenuItem BT_CargaMConductores;
        private JMenu menu4;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

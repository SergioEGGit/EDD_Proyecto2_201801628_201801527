
//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Interfaz.Clientes;

    import Interfaz.Conductores.AgregarConductor;
    import Interfaz.Conductores.BuscarConductor;
    import Interfaz.Conductores.EliminarConductor;
    import Interfaz.Conductores.ModificarConductor;
    import Interfaz.Reportes;
    import Variables.VariablesGlobales;

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

//--------------------------------------------------Author--------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//-----------------------------------------------------Principal--------------------------------------------------------

    public class ClientesInterfaz extends JFrame
    {
        //------------------------------------------Constructor---------------------------------------------------------

        public ClientesInterfaz()
        {
            initComponents();
            ButtonGroup MenuConductor = new ButtonGroup();
            MenuConductor.add(RBT_Agregar);
            MenuConductor.add(RBT_Modificar);
            MenuConductor.add(RBT_Eliminar);
            MenuConductor.add(RBT_Buscar);
            MenuConductor.add(RBT_Mostrar);
            RBT_Agregar.setSelected(true);
        }

        //----------------------------------------------Métodos---------------------------------------------------------

        //Validar Opcion RadioButton

        public void ValidarRadioButton()
        {
            if(RBT_Agregar.isSelected())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new AgregarCliente().setVisible(true);
                    }
                });
            }
            else if(RBT_Modificar.isSelected())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new ModificarConductor().setVisible(true);
                    }
                });
            }
            else if(RBT_Eliminar.isSelected())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new EliminarCliente().setVisible(true);
                    }
                });
            }
            else if(RBT_Buscar.isSelected())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new BuscarConductor().setVisible(true);
                    }
                });
            }
            else if(RBT_Mostrar.isSelected())
            {
                VariablesGlobales.NombreReporte = "ReporteConductoresListaDobleCircular.png";
                VariablesGlobales.ListaDobleCircularConductores.GenerarReporteListaDobleCircularC();

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

        //-----------------------------------------------Events---------------------------------------------------------

        private void RBT_MostrarActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void RBT_AgregarActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void RBT_ModificarActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void RBT_EliminarActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void RBT_BuscarActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            RBT_Mostrar = new JRadioButton();
            label1 = new JLabel();
            label2 = new JLabel();
            RBT_Agregar = new JRadioButton();
            RBT_Modificar = new JRadioButton();
            RBT_Eliminar = new JRadioButton();
            RBT_Buscar = new JRadioButton();
            label3 = new JLabel();

            //======== this ========
            setTitle("Clientes");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- RBT_Mostrar ----
            RBT_Mostrar.setText("Mostrar Cliente");
            RBT_Mostrar.setForeground(new Color(102, 102, 255));
            RBT_Mostrar.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Mostrar.addActionListener(e -> RBT_MostrarActionPerformed(e));
            contentPane.add(RBT_Mostrar);
            RBT_Mostrar.setBounds(255, 335, 174, 28);

            //---- label1 ----
            label1.setText("Men\u00fa Clientes");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(265, 60, 150, 26);

            //---- label2 ----
            label2.setText("Seleccione Una Opci\u00f3n:");
            label2.setForeground(new Color(0, 102, 255));
            label2.setFont(new Font("Arial", Font.BOLD, 20));
            contentPane.add(label2);
            label2.setBounds(235, 115, 226, 24);

            //---- RBT_Agregar ----
            RBT_Agregar.setText("Agregar Cliente");
            RBT_Agregar.setForeground(new Color(102, 102, 255));
            RBT_Agregar.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Agregar.addActionListener(e -> RBT_AgregarActionPerformed(e));
            contentPane.add(RBT_Agregar);
            RBT_Agregar.setBounds(255, 165, 179, 28);

            //---- RBT_Modificar ----
            RBT_Modificar.setText("Modificar Cliente");
            RBT_Modificar.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Modificar.setForeground(new Color(102, 102, 255));
            RBT_Modificar.addActionListener(e -> RBT_ModificarActionPerformed(e));
            contentPane.add(RBT_Modificar);
            RBT_Modificar.setBounds(255, 210, 188, 28);

            //---- RBT_Eliminar ----
            RBT_Eliminar.setText("Eliminar Cilente");
            RBT_Eliminar.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Eliminar.setForeground(new Color(102, 102, 255));
            RBT_Eliminar.addActionListener(e -> RBT_EliminarActionPerformed(e));
            contentPane.add(RBT_Eliminar);
            RBT_Eliminar.setBounds(255, 250, 180, 28);

            //---- RBT_Buscar ----
            RBT_Buscar.setText("Buscar Cliente");
            RBT_Buscar.setForeground(new Color(102, 102, 255));
            RBT_Buscar.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Buscar.addActionListener(e -> RBT_BuscarActionPerformed(e));
            contentPane.add(RBT_Buscar);
            RBT_Buscar.setBounds(255, 290, 173, 28);
            contentPane.add(label3);
            label3.setBounds(615, 420, 35, 30);

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
        private JRadioButton RBT_Mostrar;
        private JLabel label1;
        private JLabel label2;
        private JRadioButton RBT_Agregar;
        private JRadioButton RBT_Modificar;
        private JRadioButton RBT_Eliminar;
        private JRadioButton RBT_Buscar;
        private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

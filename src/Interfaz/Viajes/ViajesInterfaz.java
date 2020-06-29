
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Interfaz.Viajes;

    import Interfaz.Conductores.BuscarConductor;
    import Interfaz.Reportes;
    import Variables.VariablesGlobales;
    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

//----------------------------------------------------Author------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//--------------------------------------------------Principal-----------------------------------------------------------

    public class ViajesInterfaz extends JFrame
    {
        //-------------------------------------------------Constructor--------------------------------------------------

        public ViajesInterfaz()
        {
            initComponents();
            ButtonGroup MenuConductor = new ButtonGroup();
            MenuConductor.add(RBT_Agregar);
            MenuConductor.add(RBT_Buscar);
            MenuConductor.add(RBT_Mostrar);
            RBT_Agregar.setSelected(true);
        }

        //-------------------------------------------------Métodos------------------------------------------------------

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
                        new AgregarViaje().setVisible(true);
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
                VariablesGlobales.NombreReporte = "ReporteViajesBockChain.png";
                VariablesGlobales.BlockchainViajes.GenerarReporteBlockchainViajes();

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

        //-------------------------------------------------Events-------------------------------------------------------

        private void RBT_AgregarActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void RBT_MostrarActionPerformed(ActionEvent e)
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
        label3 = new JLabel();
        RBT_Agregar = new JRadioButton();
        RBT_Mostrar = new JRadioButton();
        RBT_Buscar = new JRadioButton();
        label2 = new JLabel();
        label1 = new JLabel();

        //======== this ========
        setTitle("Viajes");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(label3);
        label3.setBounds(580, 350, 35, 30);

        //---- RBT_Agregar ----
        RBT_Agregar.setText("Agregar Viaje");
        RBT_Agregar.setForeground(new Color(102, 102, 255));
        RBT_Agregar.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_Agregar.addActionListener(e -> RBT_AgregarActionPerformed(e));
        contentPane.add(RBT_Agregar);
        RBT_Agregar.setBounds(235, 145, 179, 28);

        //---- RBT_Mostrar ----
        RBT_Mostrar.setText("Mostrar Estructura");
        RBT_Mostrar.setForeground(new Color(102, 102, 255));
        RBT_Mostrar.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_Mostrar.addActionListener(e -> RBT_MostrarActionPerformed(e));
        contentPane.add(RBT_Mostrar);
        RBT_Mostrar.setBounds(235, 240, 174, 28);

        //---- RBT_Buscar ----
        RBT_Buscar.setText("Buscar Viaje");
        RBT_Buscar.setForeground(new Color(102, 102, 255));
        RBT_Buscar.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_Buscar.addActionListener(e -> RBT_BuscarActionPerformed(e));
        contentPane.add(RBT_Buscar);
        RBT_Buscar.setBounds(235, 190, 173, 28);

        //---- label2 ----
        label2.setText("Seleccione Una Opci\u00f3n:");
        label2.setForeground(new Color(0, 102, 255));
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(label2);
        label2.setBounds(215, 95, 226, 24);

        //---- label1 ----
        label1.setText("Men\u00fa Viajes");
        label1.setFont(new Font("Arial", Font.BOLD, 22));
        label1.setForeground(new Color(153, 153, 255));
        contentPane.add(label1);
        label1.setBounds(260, 40, 130, 26);

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
    private JLabel label3;
    private JRadioButton RBT_Agregar;
    private JRadioButton RBT_Mostrar;
    private JRadioButton RBT_Buscar;
    private JLabel label2;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

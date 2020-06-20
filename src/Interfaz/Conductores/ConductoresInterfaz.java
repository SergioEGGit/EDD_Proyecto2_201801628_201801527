
//-----------------------------------------------Paquetes E Imports-----------------------------------------------------

    package Interfaz.Conductores;

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

//-----------------------------------------------------Author-----------------------------------------------------------

    /**
     * @author SergioEG
     */

//---------------------------------------------------Principal----------------------------------------------------------

    public class ConductoresInterfaz extends JFrame
    {
        //-------------------------------------------------Constructor--------------------------------------------------

        public ConductoresInterfaz()
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
                        new AgregarConductor().setVisible(true);
                    }
                });
            }
            else if(RBT_Modificar.isSelected())
            {

            }
            else if(RBT_Eliminar.isSelected())
            {
                java.awt.EventQueue.invokeLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new EliminarConductor().setVisible(true);
                    }
                });
            }
            else if(RBT_Buscar.isSelected())
            {

            }
            else if(RBT_Mostrar.isSelected())
            {

            }
        }

        //-----------------------------------------------Button Event---------------------------------------------------

        private void BT_SeleccionarActionPerformed(ActionEvent e)
        {
            ValidarRadioButton();
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            label1 = new JLabel();
            label2 = new JLabel();
            RBT_Agregar = new JRadioButton();
            RBT_Modificar = new JRadioButton();
            RBT_Eliminar = new JRadioButton();
            RBT_Buscar = new JRadioButton();
            RBT_Mostrar = new JRadioButton();
            BT_Seleccionar = new JButton();
            label3 = new JLabel();

            //======== this ========
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Conductores");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- label1 ----
            label1.setText("Men\u00fa Conductores");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(275, 40), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("Seleccione Una Opci\u00f3n:");
            label2.setForeground(new Color(0, 102, 255));
            label2.setFont(new Font("Arial", Font.BOLD, 20));
            contentPane.add(label2);
            label2.setBounds(new Rectangle(new Point(260, 90), label2.getPreferredSize()));

            //---- RBT_Agregar ----
            RBT_Agregar.setText("Agregar Conductor");
            RBT_Agregar.setForeground(new Color(102, 102, 255));
            RBT_Agregar.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(RBT_Agregar);
            RBT_Agregar.setBounds(new Rectangle(new Point(280, 140), RBT_Agregar.getPreferredSize()));

            //---- RBT_Modificar ----
            RBT_Modificar.setText("Modificar Conductor");
            RBT_Modificar.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Modificar.setForeground(new Color(102, 102, 255));
            contentPane.add(RBT_Modificar);
            RBT_Modificar.setBounds(new Rectangle(new Point(280, 185), RBT_Modificar.getPreferredSize()));

            //---- RBT_Eliminar ----
            RBT_Eliminar.setText("Eliminar Conductor");
            RBT_Eliminar.setFont(new Font("Arial", Font.BOLD, 16));
            RBT_Eliminar.setForeground(new Color(102, 102, 255));
            contentPane.add(RBT_Eliminar);
            RBT_Eliminar.setBounds(new Rectangle(new Point(280, 225), RBT_Eliminar.getPreferredSize()));

            //---- RBT_Buscar ----
            RBT_Buscar.setText("Buscar Conductor");
            RBT_Buscar.setForeground(new Color(102, 102, 255));
            RBT_Buscar.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(RBT_Buscar);
            RBT_Buscar.setBounds(new Rectangle(new Point(280, 265), RBT_Buscar.getPreferredSize()));

            //---- RBT_Mostrar ----
            RBT_Mostrar.setText("Mostrar Estructura");
            RBT_Mostrar.setForeground(new Color(102, 102, 255));
            RBT_Mostrar.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(RBT_Mostrar);
            RBT_Mostrar.setBounds(new Rectangle(new Point(280, 305), RBT_Mostrar.getPreferredSize()));

            //---- BT_Seleccionar ----
            BT_Seleccionar.setText("Seleccionar");
            BT_Seleccionar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Seleccionar.setForeground(new Color(51, 51, 255));
            BT_Seleccionar.addActionListener(e -> BT_SeleccionarActionPerformed(e));
            contentPane.add(BT_Seleccionar);
            BT_Seleccionar.setBounds(new Rectangle(new Point(300, 360), BT_Seleccionar.getPreferredSize()));
            contentPane.add(label3);
            label3.setBounds(680, 435, 35, 30);

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
        private JLabel label1;
        private JLabel label2;
        private JRadioButton RBT_Agregar;
        private JRadioButton RBT_Modificar;
        private JRadioButton RBT_Eliminar;
        private JRadioButton RBT_Buscar;
        private JRadioButton RBT_Mostrar;
        private JButton BT_Seleccionar;
        private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }


//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Interfaz.Vehiculos;

    import Modelos.ModeloVehiculo;
    import Variables.VariablesGlobales;

    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.*;

//---------------------------------------------------Author-------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//---------------------------------------------------Principal----------------------------------------------------------

    public class EliminarVehiculo extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //-------------------------------------------Constructor--------------------------------------------------------

        public EliminarVehiculo()
        {
            initComponents();
            Modelo = new DefaultTableModel();
            ArrayList<ModeloVehiculo> ListaVehiculos = VariablesGlobales.ArbolBAutomoviles.TodosLosVehiculos();
            ObtenerVehiculos(ListaVehiculos);
        }

        //-----------------------------------------------Métodos--------------------------------------------------------

        public void ObtenerVehiculos(ArrayList<ModeloVehiculo> ListaVehiculos)
        {
            Modelo = new DefaultTableModel();
            Modelo.addColumn("Placa");
            Modelo.addColumn("Modelo");
            Modelo.addColumn("Marca");

            for(ModeloVehiculo Vehiculo: ListaVehiculos)
            {
                if (Vehiculo != null)
                {
                    Object[] Fila = new Object[]
                            {
                                    Vehiculo.getPlaca(),
                                    Vehiculo.getModelo(),
                                    Vehiculo.getMarca()
                            };
                    Modelo.addRow(Fila);
                }
            }
            TB_Vehiculos.setModel(Modelo);
            TB_Vehiculos.getColumnModel().getColumn(0).setPreferredWidth(400);
            TB_Vehiculos.getColumnModel().getColumn(1).setPreferredWidth(400);
            TB_Vehiculos.getColumnModel().getColumn(2).setPreferredWidth(400);
            TB_Vehiculos.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }

        //---------------------------------------------Events-----------------------------------------------------------

        private void BT_EliminarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            boolean Bandera = false;

            ArrayList<ModeloVehiculo> ArrayVehiculos = new ArrayList<ModeloVehiculo>();

            Bandera = VariablesGlobales.ArbolBAutomoviles.EliminarVehiculo(TextField_Eliminar.getText());

            if(Bandera)
            {
                JOptionPane.showMessageDialog(null, "Vehiculo Eliminado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                Modelo = new DefaultTableModel();

                ArrayVehiculos = VariablesGlobales.ArbolBAutomoviles.TodosLosVehiculos();

                ObtenerVehiculos(ArrayVehiculos);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Vehiculo Indicado No Se Puede Eliminar", "Error!", JOptionPane.ERROR_MESSAGE);
            }

            TextField_Eliminar.setText("");
        }

        private void TB_VehiculosMouseClicked(MouseEvent e)
        {
            int Columna = 0;
            int Fila = TB_Vehiculos.getSelectedRow();

            String Valor = TB_Vehiculos.getValueAt(Fila, Columna).toString();

            TextField_Eliminar.setText(Valor);
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - unknown
            label2 = new JLabel();
            BT_Eliminar = new JButton();
            TextField_Eliminar = new JTextField();
            label3 = new JLabel();
            label1 = new JLabel();
            scrollPane1 = new JScrollPane();
            TB_Vehiculos = new JTable();

            //======== this ========
            setTitle("Eliminar Vehiculo");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);
            contentPane.add(label2);
            label2.setBounds(625, 620, 50, 50);

            //---- BT_Eliminar ----
            BT_Eliminar.setText("Eliminar");
            BT_Eliminar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Eliminar.setForeground(new Color(51, 51, 255));
            BT_Eliminar.addActionListener(e -> BT_EliminarActionPerformed(e));
            contentPane.add(BT_Eliminar);
            BT_Eliminar.setBounds(285, 135, 115, 30);

            //---- TextField_Eliminar ----
            TextField_Eliminar.setForeground(new Color(0, 0, 204));
            TextField_Eliminar.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(TextField_Eliminar);
            TextField_Eliminar.setBounds(355, 85, 180, 29);

            //---- label3 ----
            label3.setText("Seleccione Un Vehiculo:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(115, 85, 235, 24);

            //---- label1 ----
            label1.setText("Eliminar Vehiculos");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(230, 35, 220, 26);

            //======== scrollPane1 ========
            {

                //---- TB_Vehiculos ----
                TB_Vehiculos.setModel(new DefaultTableModel());
                TB_Vehiculos.setFont(new Font("Arial", Font.BOLD, 14));
                TB_Vehiculos.setForeground(new Color(255, 51, 102));
                TB_Vehiculos.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TB_VehiculosMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(TB_Vehiculos);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(120, 185, scrollPane1.getPreferredSize().width, 450);

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
        private JLabel label2;
        private JButton BT_Eliminar;
        private JTextField TextField_Eliminar;
        private JLabel label3;
        private JLabel label1;
        private JScrollPane scrollPane1;
        private JTable TB_Vehiculos;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

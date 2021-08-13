
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Interfaz.Vehiculos;

import java.awt.event.*;
    import Modelos.ModeloVehiculo;
    import Variables.VariablesGlobales;

import java.awt.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;

//-----------------------------------------------------Author-----------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//------------------------------------------------------Principal-------------------------------------------------------

    public class BuscarVehiculo extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //-------------------------------------------Constructor--------------------------------------------------------

        public BuscarVehiculo()
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

        private void BT_BuscarActionPerformed(ActionEvent e)
        {
            //Declarciones

            ModeloVehiculo VehiculoBuscado = VariablesGlobales.ArbolBAutomoviles.BuscarVehiculoNodo(TextField_Buscar.getText());

            if(VehiculoBuscado != null)
            {
                String Cadena = "";

                Cadena += "Vehiculo Encontrado \n";
                Cadena += "Placa: " + VehiculoBuscado.getPlaca() + "\n";
                Cadena += "Marca: " + VehiculoBuscado.getMarca()+ "\n";
                Cadena += "Modelo: " + VehiculoBuscado.getModelo() + "\n";
                Cadena += "Año: " + VehiculoBuscado.getAnio() + "\n";
                Cadena += "Color: " + VehiculoBuscado.getColor() + "\n";
                Cadena += "Precio: " + VehiculoBuscado.getPrecio() + "\n";

                if(VehiculoBuscado.isTipoTransmicion())
                {
                    Cadena += "Transmisión: Mecánica \n";
                }
                else
                {
                    Cadena += "Transmisión: Automática \n";
                }

                JOptionPane.showMessageDialog(null, Cadena, "Encontrado!", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No Existe El Vehiculo Indicado", "Error!", JOptionPane.ERROR_MESSAGE);
            }

            TextField_Buscar.setText("");
        }

        private void TB_VehiculosMouseClicked(MouseEvent e)
        {
            int Columna = 0;
            int Fila = TB_Vehiculos.getSelectedRow();

            String Valor = TB_Vehiculos.getValueAt(Fila, Columna).toString();

            TextField_Buscar.setText(Valor);
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            label2 = new JLabel();
            BT_Buscar = new JButton();
            TextField_Buscar = new JTextField();
            label3 = new JLabel();
            label1 = new JLabel();
            scrollPane1 = new JScrollPane();
            TB_Vehiculos = new JTable();

            //======== this ========
            Container contentPane = getContentPane();
            contentPane.setLayout(null);
            contentPane.add(label2);
            label2.setBounds(650, 625, 50, 50);

            //---- BT_Buscar ----
            BT_Buscar.setText("Buscar");
            BT_Buscar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Buscar.setForeground(new Color(51, 51, 255));
            BT_Buscar.addActionListener(e -> BT_BuscarActionPerformed(e));
            contentPane.add(BT_Buscar);
            BT_Buscar.setBounds(305, 140, 115, 30);

            //---- TextField_Buscar ----
            TextField_Buscar.setForeground(new Color(0, 0, 204));
            TextField_Buscar.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(TextField_Buscar);
            TextField_Buscar.setBounds(380, 90, 180, 29);

            //---- label3 ----
            label3.setText("Seleccione Un Vehiculo:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(140, 90, 235, 24);

            //---- label1 ----
            label1.setText("Buscar Vehiculo");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(255, 40, 220, 26);

            //======== scrollPane1 ========
            {

                //---- TB_Vehiculos ----
                TB_Vehiculos.setModel(new DefaultTableModel());
                TB_Vehiculos.setForeground(new Color(255, 51, 102));
                TB_Vehiculos.setFont(new Font("Arial", Font.BOLD, 14));
                TB_Vehiculos.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TB_VehiculosMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(TB_Vehiculos);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(new Rectangle(new Point(150, 200), scrollPane1.getPreferredSize()));

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
        private JLabel label2;
        private JButton BT_Buscar;
        private JTextField TextField_Buscar;
        private JLabel label3;
        private JLabel label1;
        private JScrollPane scrollPane1;
        private JTable TB_Vehiculos;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

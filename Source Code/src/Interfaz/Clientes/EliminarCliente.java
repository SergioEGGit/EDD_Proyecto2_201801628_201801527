
//--------------------------------------------Paquetes E Imports--------------------------------------------------------

    package Interfaz.Clientes;

    import Modelos.ModeloClientes;
    import Variables.VariablesGlobales;
    import java.awt.*;
    import java.awt.event.*;
    import java.math.BigInteger;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.*;

//---------------------------------------------------Author-------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//--------------------------------------------------Principal-----------------------------------------------------------

    public class EliminarCliente extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //--------------------------------------------Constructor-------------------------------------------------------

        public EliminarCliente()
        {
            initComponents();
            Modelo = new DefaultTableModel();
            ArrayList<ModeloClientes> ListaClientes = VariablesGlobales.TablaHashClientes.ListarTodosLosClientesTablaHashClientes();
            ObtenerClientes(ListaClientes);
        }

        //-----------------------------------------------Métodos--------------------------------------------------------

        public void ObtenerClientes(ArrayList<ModeloClientes> ListaClientes)
        {
            Modelo = new DefaultTableModel();
            Modelo.addColumn("DPI");
            Modelo.addColumn("Nombre");
            Modelo.addColumn("Apellidos");

            for(ModeloClientes Clientes: ListaClientes)
            {
                if (Clientes != null)
                {
                    Object[] Fila = new Object[]
                            {
                                    Clientes.getDPICliente(),
                                    Clientes.getNombresCliente(),
                                    Clientes.getApellidosCliente()
                            };
                    Modelo.addRow(Fila);
                }
            }
            TB_Clientes.setModel(Modelo);
            TB_Clientes.getColumnModel().getColumn(0).setPreferredWidth(400);
            TB_Clientes.getColumnModel().getColumn(1).setPreferredWidth(400);
            TB_Clientes.getColumnModel().getColumn(2).setPreferredWidth(400);
            TB_Clientes.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }

        //------------------------------------------------Events--------------------------------------------------------

        //Boton Eliminar

        private void BT_EliminarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            //Variables Tipo String

            String DPI = TextField_Eliminar.getText();

            //Array Tipo String

            ArrayList<ModeloClientes> ArrayClientes = new ArrayList<ModeloClientes>();

            if(TextField_Eliminar.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Debe De Seleccionar Un Cliente!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                //Variables Tipo Int

                int Button = JOptionPane.YES_NO_OPTION;
                int Result = JOptionPane.showConfirmDialog(this, "Seguro Que Desea Eliminar El Conductor", "Pregunta!", Button);

                if(Result == 0)
                {
                    VariablesGlobales.TablaHashClientes.EliminarClienteTablaHashClientes(DPI);

                    Modelo = new DefaultTableModel();

                    ArrayClientes = VariablesGlobales.TablaHashClientes.ListarTodosLosClientesTablaHashClientes();

                    ObtenerClientes(ArrayClientes);
                }
            }

            TextField_Eliminar.setText("");
        }

        //Tabla Click

        private void TB_ClientesMouseClicked(MouseEvent e)
        {
            int Columna = 0;
            int Fila = TB_Clientes.getSelectedRow();

            String Valor = TB_Clientes.getValueAt(Fila, Columna).toString();

            TextField_Eliminar.setText(Valor);
        }

        private void TextField_EliminarKeyTyped(KeyEvent e)
        {
            //Declaraciones

            //Variable Tipo String

            String DPI = TextField_Eliminar.getText();

            if (DPI.length() > 12)
            {
                e.consume();
            }
            else
            {
                char Caracter = e.getKeyChar();

                if ((Caracter < '0' || Caracter > '9'))
                {
                    e.consume();
                }
            }
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            label2 = new JLabel();
            BT_Eliminar = new JButton();
            label3 = new JLabel();
            TextField_Eliminar = new JTextField();
            label1 = new JLabel();
            scrollPane1 = new JScrollPane();
            TB_Clientes = new JTable();

            //======== this ========
            setTitle("Eliminar Cliente");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);
            contentPane.add(label2);
            label2.setBounds(620, 605, 50, 50);

            //---- BT_Eliminar ----
            BT_Eliminar.setText("Eliminar");
            BT_Eliminar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Eliminar.setForeground(new Color(51, 51, 255));
            BT_Eliminar.addActionListener(e -> BT_EliminarActionPerformed(e));
            contentPane.add(BT_Eliminar);
            BT_Eliminar.setBounds(275, 135, 115, 30);

            //---- label3 ----
            label3.setText("Seleccione Un Cliente:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(105, 85, 235, 24);

            //---- TextField_Eliminar ----
            TextField_Eliminar.setForeground(new Color(0, 0, 204));
            TextField_Eliminar.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Eliminar.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_EliminarKeyTyped(e);
                }
            });
            contentPane.add(TextField_Eliminar);
            TextField_Eliminar.setBounds(345, 85, 180, 29);

            //---- label1 ----
            label1.setText("Eliminar Clientes");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(235, 35, 175, 26);

            //======== scrollPane1 ========
            {

                //---- TB_Clientes ----
                TB_Clientes.setForeground(new Color(255, 51, 102));
                TB_Clientes.setFont(new Font("Arial", Font.BOLD, 14));
                TB_Clientes.setModel(new DefaultTableModel());
                TB_Clientes.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TB_ClientesMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(TB_Clientes);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(105, 200, 467, 400);

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
        private JButton BT_Eliminar;
        private JLabel label3;
        private JTextField TextField_Eliminar;
        private JLabel label1;
        private JScrollPane scrollPane1;
        private JTable TB_Clientes;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

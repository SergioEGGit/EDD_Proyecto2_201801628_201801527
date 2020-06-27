
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Interfaz.Viajes;

    import Modelos.ModeloClientes;
    import Variables.VariablesGlobales;
    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;

//-----------------------------------------------------Author-----------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//---------------------------------------------------Principal----------------------------------------------------------

     public class AgregarViaje extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //-------------------------------------------Constructor--------------------------------------------------------

        public AgregarViaje()
        {
            initComponents();
        }

        //-----------------------------------------------Métodos--------------------------------------------------------

        public void ObtenerClientes(JTable NuevaTabla, ArrayList<ModeloClientes> ListaClientes)
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
            NuevaTabla.setModel(Modelo);
            NuevaTabla.getColumnModel().getColumn(0).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(1).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(2).setPreferredWidth(400);
            NuevaTabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }

        //---------------------------------------------Events-----------------------------------------------------------


        private void BT_RegistrarActionPerformed(ActionEvent e)
        {
            // TODO add your code here
        }

        private void TextField_DpiClienteMouseClicked(MouseEvent e)
        {
            //Declaraciones

            Modelo = new DefaultTableModel();
            ArrayList<ModeloClientes> ListaClientes = VariablesGlobales.TablaHashClientes.ListarTodosLosClientesTablaHashClientes();
            JTable Tabla = new JTable();
            Tabla.setFont(new Font("Arial", Font.BOLD, 16));
            Tabla.setForeground(new Color(255, 51, 102));
            Tabla.setBounds(10, 5, 50, 50);
            ObtenerClientes(Tabla, ListaClientes);

            int Mensaje = JOptionPane.showConfirmDialog(null, new JScrollPane(Tabla), "Seleccione Un Cliente", JOptionPane.OK_CANCEL_OPTION);

            if(Mensaje == JOptionPane.OK_OPTION)
            {
                int Fila = Tabla.getSelectedRow();
                String Valor = (String) Tabla.getValueAt(Fila, 0);
                TextField_DpiCliente.setText(Valor);
            }
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
        label3 = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label11 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        BT_Registrar = new JButton();
        label1 = new JLabel();
        TextField_DpiCliente = new JTextField();

        //======== this ========
        setTitle("Agregar Viaje");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label3 ----
        label3.setText("Ingrese Los Siguientes Datos:");
        label3.setForeground(new Color(0, 102, 255));
        label3.setFont(new Font("Arial", Font.BOLD, 18));
        contentPane.add(label3);
        label3.setBounds(200, 65, 270, 24);

        //---- label2 ----
        label2.setText("Registro Viajes");
        label2.setFont(new Font("Arial", Font.BOLD, 22));
        label2.setForeground(new Color(153, 153, 255));
        contentPane.add(label2);
        label2.setBounds(255, 25, 160, 26);

        //---- label4 ----
        label4.setText("Lugar Origen:");
        label4.setFont(new Font("Arial", Font.BOLD, 16));
        label4.setForeground(new Color(102, 102, 255));
        contentPane.add(label4);
        label4.setBounds(215, 120, 120, 19);

        //---- label5 ----
        label5.setText("Lugar Destino:");
        label5.setFont(new Font("Arial", Font.BOLD, 16));
        label5.setForeground(new Color(102, 102, 255));
        contentPane.add(label5);
        label5.setBounds(215, 160, 120, 19);

        //---- label6 ----
        label6.setText("Fecha Inicio:");
        label6.setFont(new Font("Arial", Font.BOLD, 16));
        label6.setForeground(new Color(102, 102, 255));
        contentPane.add(label6);
        label6.setBounds(215, 200, 120, 19);

        //---- label11 ----
        label11.setText("Hora Inicio:");
        label11.setFont(new Font("Arial", Font.BOLD, 16));
        label11.setForeground(new Color(102, 102, 255));
        contentPane.add(label11);
        label11.setBounds(215, 245, 120, 19);

        //---- label7 ----
        label7.setText("DPI Cliente:");
        label7.setFont(new Font("Arial", Font.BOLD, 16));
        label7.setForeground(new Color(102, 102, 255));
        contentPane.add(label7);
        label7.setBounds(215, 290, 95, 19);

        //---- label8 ----
        label8.setText("DPI Conductor:");
        label8.setFont(new Font("Arial", Font.BOLD, 16));
        label8.setForeground(new Color(102, 102, 255));
        contentPane.add(label8);
        label8.setBounds(215, 335, 125, 19);

        //---- label9 ----
        label9.setText("Placa Vehiculo:");
        label9.setFont(new Font("Arial", Font.BOLD, 16));
        label9.setForeground(new Color(102, 102, 255));
        contentPane.add(label9);
        label9.setBounds(215, 375, 125, 19);

        //---- BT_Registrar ----
        BT_Registrar.setText("Registrar");
        BT_Registrar.setForeground(new Color(51, 51, 255));
        BT_Registrar.setFont(new Font("Arial", Font.BOLD, 18));
        BT_Registrar.addActionListener(e -> BT_RegistrarActionPerformed(e));
        contentPane.add(BT_Registrar);
        BT_Registrar.setBounds(260, 430, 145, 30);
        contentPane.add(label1);
        label1.setBounds(600, 455, 50, 40);

        //---- TextField_DpiCliente ----
        TextField_DpiCliente.setEditable(false);
        TextField_DpiCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TextField_DpiClienteMouseClicked(e);
            }
        });
        contentPane.add(TextField_DpiCliente);
        TextField_DpiCliente.setBounds(350, 290, 145, TextField_DpiCliente.getPreferredSize().height);

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
    private JLabel label2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label11;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JButton BT_Registrar;
    private JLabel label1;
    private JTextField TextField_DpiCliente;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

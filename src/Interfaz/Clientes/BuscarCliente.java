
//--------------------------------------------Paquetes E Imports--------------------------------------------------------

    package Interfaz.Clientes;

    import Estructuras.ListaSimpleClientesNodo;
    import Modelos.ModeloClientes;
    import Modelos.ModeloConductores;
    import Variables.VariablesGlobales;

    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.*;

//--------------------------------------------------Author--------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//--------------------------------------------------Principal-----------------------------------------------------------

    public class BuscarCliente extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //-------------------------------------------Constructor--------------------------------------------------------

        public BuscarCliente()
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

        private void BT_BuscarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            //Variables Tipo String

            String DPI = TextField_Buscar.getText();
            String Cadena = "";

            //Variables Tipo Modelo Conductores

            ModeloClientes ClienteBuscado =  new ModeloClientes();

            //Variables Tipo Boolean

            if(TextField_Buscar.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Debe Rellenar Todos Los Campos", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                boolean ExisteConductor = VariablesGlobales.TablaHashClientes.VerificarClienteTablaHashClientes(TextField_Buscar.getText());

                if(ExisteConductor)
                {
                    ListaSimpleClientesNodo ClienteBuscadoNodo = VariablesGlobales.TablaHashClientes.BuscarClienteTablaHashClientes(TextField_Buscar.getText());

                    ClienteBuscado = ClienteBuscadoNodo.getNuevoCliente();

                    Cadena += "Información Cliente \n";
                    Cadena += "DPI: " + ClienteBuscado.getDPICliente() + "\n";
                    Cadena += "Nombres: " + ClienteBuscado.getNombresCliente() + "\n";
                    Cadena += "Apellidos: " + ClienteBuscado.getApellidosCliente() + "\n";
                    Cadena += "Fecha Nacimiento: " + ClienteBuscado.getFechaNacimentoCliente() + "\n";
                    Cadena += "Género: " + ClienteBuscado.getGeneroCliente() + "\n";
                    Cadena += "Teléfono: " + ClienteBuscado.getTelefonoCliente() + "\n";
                    Cadena += "Dirección: " + ClienteBuscado.getDireccionCliente() + "\n";

                    JOptionPane.showMessageDialog(null, Cadena, "Encontrado!" , JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El Cliente Indicado No Existe En El Sistema!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }

            TextField_Buscar.setText("");
        }

        private void TextField_BuscarKeyTyped(KeyEvent e)
        {
            //Declaraciones

            //Variable Tipo String

            String DPI = TextField_Buscar.getText();

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

        private void TB_ClientesMouseClicked(MouseEvent e)
        {
            int Columna = 0;
            int Fila = TB_Clientes.getSelectedRow();

            String Valor = TB_Clientes.getValueAt(Fila, Columna).toString();

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
            TB_Clientes = new JTable();

            //======== this ========
            setTitle("Buscar Clientes");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);
            contentPane.add(label2);
            label2.setBounds(610, 625, 50, 50);

            //---- BT_Buscar ----
            BT_Buscar.setText("Buscar");
            BT_Buscar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Buscar.setForeground(new Color(51, 51, 255));
            BT_Buscar.addActionListener(e -> BT_BuscarActionPerformed(e));
            contentPane.add(BT_Buscar);
            BT_Buscar.setBounds(265, 140, 115, 30);

            //---- TextField_Buscar ----
            TextField_Buscar.setForeground(new Color(0, 0, 204));
            TextField_Buscar.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Buscar.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_BuscarKeyTyped(e);
                }
            });
            contentPane.add(TextField_Buscar);
            TextField_Buscar.setBounds(340, 90, 180, 29);

            //---- label3 ----
            label3.setText("Seleccione Un Cliente:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(100, 90, 235, 24);

            //---- label1 ----
            label1.setText("Buscar Clientes");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(250, 40, 180, 26);

            //======== scrollPane1 ========
            {

                //---- TB_Clientes ----
                TB_Clientes.setModel(new DefaultTableModel());
                TB_Clientes.setForeground(new Color(255, 51, 102));
                TB_Clientes.setFont(new Font("Arial", Font.BOLD, 14));
                TB_Clientes.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TB_ClientesMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(TB_Clientes);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(100, 195, scrollPane1.getPreferredSize().width, 445);

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
        private JTable TB_Clientes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

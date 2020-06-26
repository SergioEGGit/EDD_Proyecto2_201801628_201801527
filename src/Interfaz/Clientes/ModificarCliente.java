
//------------------------------------------Paquetes E Imports----------------------------------------------------------

    package Interfaz.Clientes;

    import Estructuras.ListaSimpleClientesNodo;
    import Modelos.ModeloClientes;
    import Variables.VariablesGlobales;
    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.*;

//-------------------------------------------------Author---------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//------------------------------------------------Principal-------------------------------------------------------------

    public class ModificarCliente extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //-------------------------------------------Constructor--------------------------------------------------------

        public ModificarCliente()
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

        //--------------------------------------------Events------------------------------------------------------------

        //Verificación Solo Números

        private void TextField_DPIKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if((Caracter < '0' || Caracter > '9'))
            {
                e.consume();
            }
        }

        private void TextField_TelefonoKeyTyped(KeyEvent e)
        {
            //Declaraciones

            //Variable Tipo String

            String DPI = TextField_Telefono.getText();

            if(DPI.length() > 7)
            {
                e.consume();
            }
            else
            {
                char Caracter = e.getKeyChar();

                if((Caracter < '0' || Caracter > '9'))
                {
                    e.consume();
                }
            }
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

        //Verificación Solo Letras

        private void TextField_ApellidosKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void TextField_NombresKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void BT_ModificarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            //Array Tipo String

            ArrayList<ModeloClientes> ArrayClientes = new ArrayList<ModeloClientes>();

            //Variables Tipo Boolean

            boolean ExisteConductor = VariablesGlobales.TablaHashClientes.VerificarClienteTablaHashClientes(TextField_DPI.getText());

            if(ExisteConductor)
            {
                //Variables Tipo Int

                int Button = JOptionPane.YES_NO_OPTION;
                int Result = JOptionPane.showConfirmDialog(this, "Seguro Que Desea Modificar El Cliente", "Pregunta!", Button);

                //Variables Tipo Lista Doble

                ModeloClientes ClienteModificar = new ModeloClientes();

                if(Result == 0)
                {
                    ClienteModificar.setDPICliente(TextField_DPI.getText());
                    ClienteModificar.setNombresCliente(TextField_Nombres.getText());
                    ClienteModificar.setApellidosCliente(TextField_Apellidos.getText());
                    ClienteModificar.setFechaNacimentoCliente(TextField_Fecha.getText());
                    ClienteModificar.setGeneroCliente((String) CB_Genero.getSelectedItem());
                    ClienteModificar.setTelefonoCliente(Integer.parseInt(TextField_Telefono.getText()));
                    ClienteModificar.setDireccionCliente(TextField_Direccion.getText());

                    VariablesGlobales.TablaHashClientes.ModificarClienteTablaHashClientes(TextField_DPI.getText(), ClienteModificar);

                    Modelo = new DefaultTableModel();

                    ArrayClientes = VariablesGlobales.TablaHashClientes.ListarTodosLosClientesTablaHashClientes();

                    ObtenerClientes(ArrayClientes);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Conductor Indicado No Existe En El Sistema!", "Error!", JOptionPane.ERROR_MESSAGE);
            }

            TextField_DPI.setText("");
            TextField_Nombres.setText("");
            TextField_Apellidos.setText("");
            TextField_Fecha.setText("");
            CB_Genero.setSelectedIndex(0);
            TextField_Telefono.setText("");
            TextField_Direccion.setText("");
        }

        private void BT_BuscarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            ModeloClientes ClienteModificar = new ModeloClientes();
            ListaSimpleClientesNodo ClienteModificarNodo = new ListaSimpleClientesNodo();

            if(TextField_Buscar.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Debe De Seleccionar Un Cliente!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                ClienteModificarNodo = VariablesGlobales.TablaHashClientes.BuscarClienteTablaHashClientes(TextField_Buscar.getText());

                if(ClienteModificarNodo != null)
                {
                    ClienteModificar = ClienteModificarNodo.getNuevoCliente();

                    TextField_DPI.setText(ClienteModificar.getDPICliente());
                    TextField_Nombres.setText(ClienteModificar.getNombresCliente());
                    TextField_Apellidos.setText(ClienteModificar.getApellidosCliente());
                    TextField_Fecha.setText(ClienteModificar.getFechaNacimentoCliente());

                    if(ClienteModificar.getGeneroCliente().equals("Masculino"))
                    {
                        CB_Genero.setSelectedIndex(0);
                    }
                    else if(ClienteModificar.getGeneroCliente().equals("Femenino"))
                    {
                        CB_Genero.setSelectedIndex(1);
                    }

                    TextField_Telefono.setText("" + ClienteModificar.getTelefonoCliente());
                    TextField_Direccion.setText(ClienteModificar.getDireccionCliente());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El Cliente No Existe En El Sistema", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }

            TextField_Buscar.setText("");
        }

        private void TB_ClientesMouseClicked(MouseEvent e)
        {
            //Declaraciones

            ModeloClientes ClienteModificar = new ModeloClientes();
            ListaSimpleClientesNodo ClienteModificarNodo = new ListaSimpleClientesNodo();

            //Variables Tipo Int

            int Columna = 0;
            int Fila = TB_Clientes.getSelectedRow();

            //Variables Tipo Modelo Conductor

            String Valor = TB_Clientes.getValueAt(Fila, Columna).toString();

            ClienteModificarNodo = VariablesGlobales.TablaHashClientes.BuscarClienteTablaHashClientes(Valor);

            ClienteModificar = ClienteModificarNodo.getNuevoCliente();

            TextField_DPI.setText(ClienteModificar.getDPICliente());
            TextField_Nombres.setText(ClienteModificar.getNombresCliente());
            TextField_Apellidos.setText(ClienteModificar.getApellidosCliente());
            TextField_Fecha.setText(ClienteModificar.getFechaNacimentoCliente());

            if(ClienteModificar.getGeneroCliente().equals("Masculino"))
            {
                CB_Genero.setSelectedIndex(0);
            }
            else if(ClienteModificar.getGeneroCliente().equals("Femenino"))
            {
                CB_Genero.setSelectedIndex(1);
            }

            TextField_Telefono.setText("" + ClienteModificar.getTelefonoCliente());
            TextField_Direccion.setText(ClienteModificar.getDireccionCliente());
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            label1 = new JLabel();
            BT_Modificar = new JButton();
            TextField_Direccion = new JTextField();
            label10 = new JLabel();
            TextField_Telefono = new JTextField();
            label9 = new JLabel();
            CB_Genero = new JComboBox<>();
            label8 = new JLabel();
            TextField_Fecha = new JTextField();
            label11 = new JLabel();
            TextField_Apellidos = new JTextField();
            label6 = new JLabel();
            TextField_Nombres = new JTextField();
            label5 = new JLabel();
            TextField_DPI = new JTextField();
            label4 = new JLabel();
            label3 = new JLabel();
            label12 = new JLabel();
            TextField_Buscar = new JTextField();
            BT_Buscar = new JButton();
            label2 = new JLabel();
            scrollPane1 = new JScrollPane();
            TB_Clientes = new JTable();

            //======== this ========
            Container contentPane = getContentPane();
            contentPane.setLayout(null);
            contentPane.add(label1);
            label1.setBounds(705, 565, 50, 40);

            //---- BT_Modificar ----
            BT_Modificar.setText("Modificar");
            BT_Modificar.setForeground(new Color(51, 51, 255));
            BT_Modificar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Modificar.addActionListener(e -> BT_ModificarActionPerformed(e));
            contentPane.add(BT_Modificar);
            BT_Modificar.setBounds(490, 475, 135, 30);

            //---- TextField_Direccion ----
            TextField_Direccion.setForeground(new Color(0, 0, 204));
            TextField_Direccion.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(TextField_Direccion);
            TextField_Direccion.setBounds(495, 415, 200, 29);

            //---- label10 ----
            label10.setText("Direcci\u00f3n:");
            label10.setFont(new Font("Arial", Font.BOLD, 16));
            label10.setForeground(new Color(102, 102, 255));
            contentPane.add(label10);
            label10.setBounds(410, 415, 80, 19);

            //---- TextField_Telefono ----
            TextField_Telefono.setForeground(new Color(0, 0, 204));
            TextField_Telefono.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Telefono.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_TelefonoKeyTyped(e);
                }
            });
            contentPane.add(TextField_Telefono);
            TextField_Telefono.setBounds(495, 375, 200, 29);

            //---- label9 ----
            label9.setText("T\u00e9lefono:");
            label9.setFont(new Font("Arial", Font.BOLD, 16));
            label9.setForeground(new Color(102, 102, 255));
            contentPane.add(label9);
            label9.setBounds(410, 375, 75, 19);

            //---- CB_Genero ----
            CB_Genero.setModel(new DefaultComboBoxModel<>(new String[] {
                "Masculino",
                "Femenino"
            }));
            CB_Genero.setFont(new Font("Arial", Font.BOLD, 16));
            CB_Genero.setForeground(new Color(0, 0, 204));
            contentPane.add(CB_Genero);
            CB_Genero.setBounds(495, 320, 205, 38);

            //---- label8 ----
            label8.setText("G\u00e9nero:");
            label8.setFont(new Font("Arial", Font.BOLD, 16));
            label8.setForeground(new Color(102, 102, 255));
            contentPane.add(label8);
            label8.setBounds(410, 330, 75, 19);

            //---- TextField_Fecha ----
            TextField_Fecha.setText("DD/MM/YYYY");
            TextField_Fecha.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Fecha.setForeground(new Color(0, 0, 204));
            contentPane.add(TextField_Fecha);
            TextField_Fecha.setBounds(585, 280, 115, 29);

            //---- label11 ----
            label11.setText("Fecha De Nacimiento:");
            label11.setFont(new Font("Arial", Font.BOLD, 16));
            label11.setForeground(new Color(102, 102, 255));
            contentPane.add(label11);
            label11.setBounds(410, 280, 170, 19);

            //---- TextField_Apellidos ----
            TextField_Apellidos.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Apellidos.setForeground(new Color(0, 0, 204));
            TextField_Apellidos.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_ApellidosKeyTyped(e);
                }
            });
            contentPane.add(TextField_Apellidos);
            TextField_Apellidos.setBounds(500, 240, 200, 29);

            //---- label6 ----
            label6.setText("Apellidos:");
            label6.setFont(new Font("Arial", Font.BOLD, 16));
            label6.setForeground(new Color(102, 102, 255));
            contentPane.add(label6);
            label6.setBounds(410, 240, 85, 19);

            //---- TextField_Nombres ----
            TextField_Nombres.setForeground(new Color(0, 0, 204));
            TextField_Nombres.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Nombres.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_NombresKeyTyped(e);
                }
            });
            contentPane.add(TextField_Nombres);
            TextField_Nombres.setBounds(500, 200, 200, 29);

            //---- label5 ----
            label5.setText("Nombres:");
            label5.setFont(new Font("Arial", Font.BOLD, 16));
            label5.setForeground(new Color(102, 102, 255));
            contentPane.add(label5);
            label5.setBounds(410, 200, 85, 19);

            //---- TextField_DPI ----
            TextField_DPI.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_DPI.setForeground(new Color(0, 0, 204));
            TextField_DPI.setEditable(false);
            TextField_DPI.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_DPIKeyTyped(e);
                }
            });
            contentPane.add(TextField_DPI);
            TextField_DPI.setBounds(500, 165, 200, 29);

            //---- label4 ----
            label4.setText("DPI:");
            label4.setFont(new Font("Arial", Font.BOLD, 16));
            label4.setForeground(new Color(102, 102, 255));
            contentPane.add(label4);
            label4.setBounds(410, 165, 33, 19);

            //---- label3 ----
            label3.setText("Seleccione Un Cliente:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(20, 155, 235, 24);

            //---- label12 ----
            label12.setText("Buscar Cliente:");
            label12.setForeground(new Color(0, 102, 255));
            label12.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label12);
            label12.setBounds(120, 95, 170, 24);

            //---- TextField_Buscar ----
            TextField_Buscar.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Buscar.setForeground(new Color(0, 0, 204));
            TextField_Buscar.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_BuscarKeyTyped(e);
                }
            });
            contentPane.add(TextField_Buscar);
            TextField_Buscar.setBounds(290, 95, 195, 29);

            //---- BT_Buscar ----
            BT_Buscar.setText("Buscar");
            BT_Buscar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Buscar.setForeground(new Color(51, 51, 255));
            BT_Buscar.addActionListener(e -> BT_BuscarActionPerformed(e));
            contentPane.add(BT_Buscar);
            BT_Buscar.setBounds(510, 95, 115, 30);

            //---- label2 ----
            label2.setText("Modificar Clientes:");
            label2.setFont(new Font("Arial", Font.BOLD, 22));
            label2.setForeground(new Color(153, 153, 255));
            contentPane.add(label2);
            label2.setBounds(290, 40, 195, 26);

            //======== scrollPane1 ========
            {

                //---- TB_Clientes ----
                TB_Clientes.setModel(new DefaultTableModel());
                TB_Clientes.setFont(new Font("Arial", Font.BOLD, 14));
                TB_Clientes.setForeground(new Color(255, 51, 102));
                TB_Clientes.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TB_ClientesMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(TB_Clientes);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(15, 195, 350, 378);

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
        private JButton BT_Modificar;
        private JTextField TextField_Direccion;
        private JLabel label10;
        private JTextField TextField_Telefono;
        private JLabel label9;
        private JComboBox<String> CB_Genero;
        private JLabel label8;
        private JTextField TextField_Fecha;
        private JLabel label11;
        private JTextField TextField_Apellidos;
        private JLabel label6;
        private JTextField TextField_Nombres;
        private JLabel label5;
        private JTextField TextField_DPI;
        private JLabel label4;
        private JLabel label3;
        private JLabel label12;
        private JTextField TextField_Buscar;
        private JButton BT_Buscar;
        private JLabel label2;
        private JScrollPane scrollPane1;
        private JTable TB_Clientes;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

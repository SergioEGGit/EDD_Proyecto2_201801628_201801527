
//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Interfaz.Vehiculos;

    import Modelos.ModeloClientes;
    import Modelos.ModeloConductores;
    import Modelos.ModeloVehiculo;
    import Variables.VariablesGlobales;
    import com.sun.org.apache.xpath.internal.operations.Variable;

    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.*;

//--------------------------------------------------Author--------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//-------------------------------------------------Principal------------------------------------------------------------

    public class ModificarVehiculo extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //------------------------------------------Constructor---------------------------------------------------------

        public ModificarVehiculo()
        {
            initComponents();
            Modelo = new DefaultTableModel();
            ArrayList<ModeloVehiculo> ListaVehiculos = VariablesGlobales.ArbolBAutomoviles.TodosLosVehiculos();
            ObtenerVehiculos(ListaVehiculos);
        }

        //---------------------------------------------Métodos----------------------------------------------------------

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

        //Verificación Solo Números

        private void TextField_AnioKeyTyped(KeyEvent e)
        {
            //Declaraciones

            //Variable Tipo String

            String DPI = TextField_Anio.getText();

            if (DPI.length() > 3)
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

        private void TextField_PrecioKeyTyped(KeyEvent e)
        {
            //Declaraciones

            char Caracter = e.getKeyChar();

            if((Caracter < '0' || Caracter > '9'))
            {
                e.consume();
            }
        }

        //Verificación Solo Letras

        private void TextField_MarcaKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void TextField_ModeloKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void TextField_ColorKeyTyped(KeyEvent e)
        {
            char Caracter = e.getKeyChar();

            if (!(Character.isLetter(Caracter) || Character.isSpaceChar(Caracter)))
            {
                e.consume();
            }
        }

        private void BT_BuscarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            ModeloVehiculo VehiculoModificar = new ModeloVehiculo();

            VehiculoModificar = VariablesGlobales.ArbolBAutomoviles.BuscarVehiculoNodo(TextField_Buscar.getText());

            if(VehiculoModificar != null)
            {
                TextField_Placa.setText(VehiculoModificar.getPlaca());
                TextField_Marca.setText(VehiculoModificar.getMarca());
                TextField_Modelo.setText(VehiculoModificar.getModelo());
                TextField_Anio.setText("" + VehiculoModificar.getAnio());
                TextField_Color.setText(VehiculoModificar.getColor());
                TextField_Precio.setText("" + VehiculoModificar.getPrecio());

                if(VehiculoModificar.isTipoTransmicion())
                {
                    CB_TipoTrans.setSelectedIndex(1);
                }
                else
                {
                    CB_TipoTrans.setSelectedIndex(0);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Vehiculo No Existe En El Sistema", "Error!", JOptionPane.ERROR_MESSAGE);
            }

            TextField_Buscar.setText("");
        }

        private void TB_VehiculosMouseClicked(MouseEvent e)
        {
            //Declaraciones

            //Variables Tipo Int

            int Columna = 0;
            int Fila = TB_Vehiculos.getSelectedRow();

            //Variables Tipo Modelo Conductor

            ModeloVehiculo VehiculoModificar = new ModeloVehiculo();

            String Valor = TB_Vehiculos.getValueAt(Fila, Columna).toString();

            VehiculoModificar = VariablesGlobales.ArbolBAutomoviles.BuscarVehiculoNodo(Valor);

            TextField_Placa.setText(VehiculoModificar.getPlaca());
            TextField_Marca.setText(VehiculoModificar.getMarca());
            TextField_Modelo.setText(VehiculoModificar.getModelo());
            TextField_Anio.setText("" + VehiculoModificar.getAnio());
            TextField_Color.setText(VehiculoModificar.getColor());
            TextField_Precio.setText("" + VehiculoModificar.getPrecio());

            if(VehiculoModificar.isTipoTransmicion())
            {
                CB_TipoTrans.setSelectedIndex(1);
            }
            else
            {
                CB_TipoTrans.setSelectedIndex(0);
            }
        }

        private void BT_ModidficarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            //Array Tipo String

            ArrayList<ModeloVehiculo> ArrayVehiculos = new ArrayList<ModeloVehiculo>();

            //Variables Tipo Boolean

            boolean ExisteConductor = VariablesGlobales.ArbolBAutomoviles.BuscarVehiculoBoolean(TextField_Placa.getText());

            if(ExisteConductor)
            {
                //Variables Tipo Int

                int Button = JOptionPane.YES_NO_OPTION;
                int Result = JOptionPane.showConfirmDialog(this, "Seguro Que Desea Modificar El Conductor", "Pregunta!", Button);

                //Variables Tipo Lista Doble

                ModeloVehiculo VehiculoModificar = VariablesGlobales.ArbolBAutomoviles.BuscarVehiculoNodo(TextField_Placa.getText());

                if(Result == 0)
                {
                    VehiculoModificar.setPlaca(TextField_Placa.getText());
                    VehiculoModificar.setMarca(TextField_Marca.getText());
                    VehiculoModificar.setModelo(TextField_Modelo.getText());
                    VehiculoModificar.setAnio(Integer.parseInt(TextField_Anio.getText()));
                    VehiculoModificar.setColor(TextField_Color.getText());
                    VehiculoModificar.setPrecio(Double.parseDouble(TextField_Precio.getText()));

                    String Trans = (String) CB_TipoTrans.getSelectedItem();

                    if(Trans.equals("Automática") || Trans.equals("Automatica"))
                    {
                        VehiculoModificar.setTipoTransmicion(false);
                    }
                    else if(Trans.equals("Mecánica") || Trans.equals("Mecanica"))
                    {
                        VehiculoModificar.setTipoTransmicion(true);
                    }

                    JOptionPane.showMessageDialog(null, "Vehiculo Modificado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);

                    Modelo = new DefaultTableModel();

                    ArrayVehiculos = VariablesGlobales.ArbolBAutomoviles.TodosLosVehiculos();

                    ObtenerVehiculos(ArrayVehiculos);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Conductor Indicado No Existe En El Sistema!", "Error!", JOptionPane.ERROR_MESSAGE);
            }

            TextField_Placa.setText("");
            TextField_Marca.setText("");
            TextField_Modelo.setText("");
            TextField_Anio.setText("");
            TextField_Color.setText("");
            TextField_Precio.setText("");
            CB_TipoTrans.setSelectedIndex(0);
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            CB_TipoTrans = new JComboBox<>();
            label9 = new JLabel();
            TextField_Precio = new JTextField();
            label8 = new JLabel();
            TextField_Color = new JTextField();
            label7 = new JLabel();
            TextField_Anio = new JTextField();
            label11 = new JLabel();
            TextField_Modelo = new JTextField();
            label6 = new JLabel();
            TextField_Marca = new JTextField();
            label5 = new JLabel();
            TextField_Placa = new JTextField();
            label4 = new JLabel();
            label2 = new JLabel();
            BT_Buscar = new JButton();
            TextField_Buscar = new JTextField();
            label12 = new JLabel();
            label3 = new JLabel();
            label10 = new JLabel();
            scrollPane1 = new JScrollPane();
            TB_Vehiculos = new JTable();
            BT_Modidficar = new JButton();

            //======== this ========
            setTitle("Modificar Vehiculo");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- CB_TipoTrans ----
            CB_TipoTrans.setFont(new Font("Arial", Font.BOLD, 16));
            CB_TipoTrans.setForeground(new Color(0, 0, 204));
            CB_TipoTrans.setModel(new DefaultComboBoxModel<>(new String[] {
                "Autom\u00e1tica",
                "Mec\u00e1nica"
            }));
            contentPane.add(CB_TipoTrans);
            CB_TipoTrans.setBounds(595, 395, 120, 38);

            //---- label9 ----
            label9.setText("Tipo Transmisi\u00f3n:");
            label9.setFont(new Font("Arial", Font.BOLD, 16));
            label9.setForeground(new Color(102, 102, 255));
            contentPane.add(label9);
            label9.setBounds(445, 405, 150, 19);

            //---- TextField_Precio ----
            TextField_Precio.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Precio.setForeground(new Color(0, 0, 204));
            TextField_Precio.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_PrecioKeyTyped(e);
                }
            });
            contentPane.add(TextField_Precio);
            TextField_Precio.setBounds(530, 350, 184, 29);

            //---- label8 ----
            label8.setText("Precio:");
            label8.setFont(new Font("Arial", Font.BOLD, 16));
            label8.setForeground(new Color(102, 102, 255));
            contentPane.add(label8);
            label8.setBounds(445, 350, 75, 19);

            //---- TextField_Color ----
            TextField_Color.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Color.setForeground(new Color(0, 0, 204));
            TextField_Color.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_ColorKeyTyped(e);
                }
            });
            contentPane.add(TextField_Color);
            TextField_Color.setBounds(530, 305, 184, 29);

            //---- label7 ----
            label7.setText("Color:");
            label7.setFont(new Font("Arial", Font.BOLD, 16));
            label7.setForeground(new Color(102, 102, 255));
            contentPane.add(label7);
            label7.setBounds(445, 305, 80, 19);

            //---- TextField_Anio ----
            TextField_Anio.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Anio.setForeground(new Color(0, 0, 204));
            TextField_Anio.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_AnioKeyTyped(e);
                }
            });
            contentPane.add(TextField_Anio);
            TextField_Anio.setBounds(530, 260, 184, 29);

            //---- label11 ----
            label11.setText("A\u00f1o:");
            label11.setFont(new Font("Arial", Font.BOLD, 16));
            label11.setForeground(new Color(102, 102, 255));
            contentPane.add(label11);
            label11.setBounds(445, 260, 80, 19);

            //---- TextField_Modelo ----
            TextField_Modelo.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Modelo.setForeground(new Color(0, 0, 204));
            TextField_Modelo.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_ModeloKeyTyped(e);
                }
            });
            contentPane.add(TextField_Modelo);
            TextField_Modelo.setBounds(530, 215, 184, 29);

            //---- label6 ----
            label6.setText("Modelo:");
            label6.setFont(new Font("Arial", Font.BOLD, 16));
            label6.setForeground(new Color(102, 102, 255));
            contentPane.add(label6);
            label6.setBounds(445, 215, 80, 19);

            //---- TextField_Marca ----
            TextField_Marca.setForeground(new Color(0, 0, 204));
            TextField_Marca.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Marca.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_MarcaKeyTyped(e);
                }
            });
            contentPane.add(TextField_Marca);
            TextField_Marca.setBounds(530, 175, 184, 29);

            //---- label5 ----
            label5.setText("Marca:");
            label5.setFont(new Font("Arial", Font.BOLD, 16));
            label5.setForeground(new Color(102, 102, 255));
            contentPane.add(label5);
            label5.setBounds(445, 175, 80, 19);

            //---- TextField_Placa ----
            TextField_Placa.setForeground(new Color(0, 0, 204));
            TextField_Placa.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Placa.setEditable(false);
            contentPane.add(TextField_Placa);
            TextField_Placa.setBounds(530, 135, 184, 29);

            //---- label4 ----
            label4.setText("Placa:");
            label4.setFont(new Font("Arial", Font.BOLD, 16));
            label4.setForeground(new Color(102, 102, 255));
            contentPane.add(label4);
            label4.setBounds(445, 135, 80, 19);
            contentPane.add(label2);
            label2.setBounds(720, 545, 50, 50);

            //---- BT_Buscar ----
            BT_Buscar.setText("Buscar");
            BT_Buscar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Buscar.setForeground(new Color(51, 51, 255));
            BT_Buscar.addActionListener(e -> BT_BuscarActionPerformed(e));
            contentPane.add(BT_Buscar);
            BT_Buscar.setBounds(535, 80, 115, 30);

            //---- TextField_Buscar ----
            TextField_Buscar.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Buscar.setForeground(new Color(0, 0, 204));
            contentPane.add(TextField_Buscar);
            TextField_Buscar.setBounds(315, 80, 195, 29);

            //---- label12 ----
            label12.setText("Buscar Vehiculo:");
            label12.setForeground(new Color(0, 102, 255));
            label12.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label12);
            label12.setBounds(145, 80, 170, 24);

            //---- label3 ----
            label3.setText("Modificar Vehiculo");
            label3.setFont(new Font("Arial", Font.BOLD, 22));
            label3.setForeground(new Color(153, 153, 255));
            contentPane.add(label3);
            label3.setBounds(285, 25, 240, 26);

            //---- label10 ----
            label10.setText("Seleccione Un Vehiculo:");
            label10.setForeground(new Color(0, 102, 255));
            label10.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label10);
            label10.setBounds(20, 140, 235, 24);

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
            scrollPane1.setBounds(15, 180, 390, 400);

            //---- BT_Modidficar ----
            BT_Modidficar.setText("Modificar");
            BT_Modidficar.setForeground(new Color(51, 51, 255));
            BT_Modidficar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Modidficar.addActionListener(e -> BT_ModidficarActionPerformed(e));
            contentPane.add(BT_Modidficar);
            BT_Modidficar.setBounds(new Rectangle(new Point(550, 465), BT_Modidficar.getPreferredSize()));

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
        private JComboBox<String> CB_TipoTrans;
        private JLabel label9;
        private JTextField TextField_Precio;
        private JLabel label8;
        private JTextField TextField_Color;
        private JLabel label7;
        private JTextField TextField_Anio;
        private JLabel label11;
        private JTextField TextField_Modelo;
        private JLabel label6;
        private JTextField TextField_Marca;
        private JLabel label5;
        private JTextField TextField_Placa;
        private JLabel label4;
        private JLabel label2;
        private JButton BT_Buscar;
        private JTextField TextField_Buscar;
        private JLabel label12;
        private JLabel label3;
        private JLabel label10;
        private JScrollPane scrollPane1;
        private JTable TB_Vehiculos;
        private JButton BT_Modidficar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

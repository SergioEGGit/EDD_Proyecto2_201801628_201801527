
//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Interfaz.Conductores;

    import Modelos.ModeloConductores;
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

//--------------------------------------------------Principal-----------------------------------------------------------

    public class ModificarConductor extends JFrame
    {
        //------------------------------------------Variables-----------------------------------------------------------

        DefaultTableModel Modelo;

        //-----------------------------------------Constructor----------------------------------------------------------

        public ModificarConductor()
        {
            initComponents();
            Modelo = new DefaultTableModel();
            ArrayList<ModeloConductores> ListaConductores = VariablesGlobales.ListaDobleCircularConductores.ObtenerTodosLosConductoresListaDobleCircularC();
            ObtenerConductores(ListaConductores);
        }

        //--------------------------------------------Métodos-----------------------------------------------------------

        public void ObtenerConductores(ArrayList<ModeloConductores> ListaConductores)
        {
            Modelo = new DefaultTableModel();
            Modelo.addColumn("DPI");
            Modelo.addColumn("Nombre");
            Modelo.addColumn("Apellidos");

            for(ModeloConductores Conductor: ListaConductores)
            {
                if (Conductor != null)
                {
                    Object[] Fila = new Object[]
                            {
                                    Conductor.getDPIConductor(),
                                    Conductor.getNombresConductor(),
                                    Conductor.getApellidosConductor()
                            };
                    Modelo.addRow(Fila);
                }
            }
            TB_Conductores.setModel(Modelo);
            TB_Conductores.getColumnModel().getColumn(0).setPreferredWidth(400);
            TB_Conductores.getColumnModel().getColumn(1).setPreferredWidth(400);
            TB_Conductores.getColumnModel().getColumn(2).setPreferredWidth(400);
            TB_Conductores.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
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

        //Boton Modificar

        private void BT_ModificarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            //Array Tipo String

            ArrayList<ModeloConductores> ArrayConductores = new ArrayList<ModeloConductores>();

            //Variables Tipo Int

            int Button = JOptionPane.YES_NO_OPTION;
            int Result = JOptionPane.showConfirmDialog(this, "Seguro Que Desea Modificar El Conductor", "Pregunta!", Button);

            //Variables Tipo Lista Doble

            ModeloConductores ConductorModificar = new ModeloConductores();

            if(Result == 0)
            {
                ConductorModificar.setDPIConductor(TextField_DPI.getText());
                ConductorModificar.setNombresConductor(TextField_Nombres.getText());
                ConductorModificar.setApellidosConductor(TextField_Apellidos.getText());
                ConductorModificar.setFechaNacimientoConductor(TextField_Fecha.getText());
                ConductorModificar.setTipoLicenciaConductor((String) CB_TipoLicencia.getSelectedItem());
                ConductorModificar.setGeneroConductor((String) CB_Genero.getSelectedItem());
                ConductorModificar.setTelefonoConductor(Integer.parseInt(TextField_Telefono.getText()));
                ConductorModificar.setDireccionConductor(TextField_Direccion.getText());

                VariablesGlobales.ListaDobleCircularConductores.ModificarConductorListaDobleCircularC(ConductorModificar);

                Modelo = new DefaultTableModel();

                ArrayConductores = VariablesGlobales.ListaDobleCircularConductores.ObtenerTodosLosConductoresListaDobleCircularC();

                ObtenerConductores(ArrayConductores);

                TextField_DPI.setText("");
                TextField_Nombres.setText("");
                TextField_Apellidos.setText("");
                TextField_Fecha.setText("");
                CB_TipoLicencia.setSelectedIndex(0);
                CB_Genero.setSelectedIndex(1);
                TextField_Telefono.setText("");
                TextField_Direccion.setText("");
            }
            else
            {
                TextField_DPI.setText("");
                TextField_Nombres.setText("");
                TextField_Apellidos.setText("");
                TextField_Fecha.setText("");
                CB_TipoLicencia.setSelectedIndex(0);
                CB_Genero.setSelectedIndex(1);
                TextField_Telefono.setText("");
                TextField_Direccion.setText("");
            }
        }

        //Tabla Click

        private void TB_ConductoresMouseClicked(MouseEvent e)
        {
            //Declaraciones

            //Variables Tipo Int

            int Columna = 0;
            int Fila = TB_Conductores.getSelectedRow();

            //Variables Tipo Modelo Conductor

            ModeloConductores ConductorModificar = new ModeloConductores();

            String Valor = TB_Conductores.getValueAt(Fila, Columna).toString();

            ConductorModificar = VariablesGlobales.ListaDobleCircularConductores.BuscarUsuarioListaDobleCircularC(Valor);

            TextField_DPI.setText(ConductorModificar.getDPIConductor());
            TextField_Nombres.setText(ConductorModificar.getNombresConductor());
            TextField_Apellidos.setText(ConductorModificar.getApellidosConductor());
            TextField_Fecha.setText(ConductorModificar.getFechaNacimientoConductor());

            if(ConductorModificar.getTipoLicenciaConductor().equals("A"))
            {
                CB_TipoLicencia.setSelectedIndex(0);
            }
            else if(ConductorModificar.getTipoLicenciaConductor().equals("B"))
            {
                CB_TipoLicencia.setSelectedIndex(1);
            }
            else if(ConductorModificar.getTipoLicenciaConductor().equals("C"))
            {
                CB_TipoLicencia.setSelectedIndex(2);
            }

            if(ConductorModificar.getGeneroConductor().equals("Masculino"))
            {
                CB_Genero.setSelectedIndex(0);
            }
            else if(ConductorModificar.getGeneroConductor().equals("Femenino"))
            {
                CB_Genero.setSelectedIndex(1);
            }

            TextField_Telefono.setText("" + ConductorModificar.getTelefonoConductor());
            TextField_Direccion.setText(ConductorModificar.getDireccionConductor());
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            BT_Modificar = new JButton();
            TextField_Direccion = new JTextField();
            label10 = new JLabel();
            TextField_Telefono = new JTextField();
            label9 = new JLabel();
            CB_Genero = new JComboBox<>();
            label8 = new JLabel();
            CB_TipoLicencia = new JComboBox<>();
            label7 = new JLabel();
            TextField_Fecha = new JTextField();
            label11 = new JLabel();
            TextField_Apellidos = new JTextField();
            label6 = new JLabel();
            TextField_Nombres = new JTextField();
            label5 = new JLabel();
            label4 = new JLabel();
            TextField_DPI = new JTextField();
            label1 = new JLabel();
            scrollPane1 = new JScrollPane();
            TB_Conductores = new JTable();
            label2 = new JLabel();
            label3 = new JLabel();

            //======== this ========
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- BT_Modificar ----
            BT_Modificar.setText("Modificar");
            BT_Modificar.setForeground(new Color(51, 51, 255));
            BT_Modificar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Modificar.addActionListener(e -> BT_ModificarActionPerformed(e));
            contentPane.add(BT_Modificar);
            BT_Modificar.setBounds(485, 475, 135, 30);

            //---- TextField_Direccion ----
            TextField_Direccion.setForeground(new Color(0, 0, 204));
            TextField_Direccion.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(TextField_Direccion);
            TextField_Direccion.setBounds(490, 415, 200, 29);

            //---- label10 ----
            label10.setText("Direcci\u00f3n:");
            label10.setFont(new Font("Arial", Font.BOLD, 16));
            label10.setForeground(new Color(102, 102, 255));
            contentPane.add(label10);
            label10.setBounds(405, 415, 80, 19);

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
            TextField_Telefono.setBounds(490, 375, 200, 29);

            //---- label9 ----
            label9.setText("T\u00e9lefono:");
            label9.setFont(new Font("Arial", Font.BOLD, 16));
            label9.setForeground(new Color(102, 102, 255));
            contentPane.add(label9);
            label9.setBounds(405, 375, 75, 19);

            //---- CB_Genero ----
            CB_Genero.setModel(new DefaultComboBoxModel<>(new String[] {
                "Masculino",
                "Femenino"
            }));
            CB_Genero.setFont(new Font("Arial", Font.BOLD, 16));
            CB_Genero.setForeground(new Color(0, 0, 204));
            contentPane.add(CB_Genero);
            CB_Genero.setBounds(490, 320, 205, 38);

            //---- label8 ----
            label8.setText("G\u00e9nero:");
            label8.setFont(new Font("Arial", Font.BOLD, 16));
            label8.setForeground(new Color(102, 102, 255));
            contentPane.add(label8);
            label8.setBounds(405, 330, 75, 19);

            //---- CB_TipoLicencia ----
            CB_TipoLicencia.setModel(new DefaultComboBoxModel<>(new String[] {
                "A",
                "B",
                "C"
            }));
            CB_TipoLicencia.setForeground(new Color(0, 0, 204));
            CB_TipoLicencia.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(CB_TipoLicencia);
            CB_TipoLicencia.setBounds(545, 270, 150, 38);

            //---- label7 ----
            label7.setText("Tipo De Licencia:");
            label7.setFont(new Font("Arial", Font.BOLD, 16));
            label7.setForeground(new Color(102, 102, 255));
            contentPane.add(label7);
            label7.setBounds(405, 275, 135, 19);

            //---- TextField_Fecha ----
            TextField_Fecha.setText("DD/MM/YYYY");
            TextField_Fecha.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Fecha.setForeground(new Color(0, 0, 204));
            contentPane.add(TextField_Fecha);
            TextField_Fecha.setBounds(580, 230, 115, 29);

            //---- label11 ----
            label11.setText("Fecha De Nacimiento:");
            label11.setFont(new Font("Arial", Font.BOLD, 16));
            label11.setForeground(new Color(102, 102, 255));
            contentPane.add(label11);
            label11.setBounds(405, 230, 170, 19);

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
            TextField_Apellidos.setBounds(495, 190, 200, 29);

            //---- label6 ----
            label6.setText("Apellidos:");
            label6.setFont(new Font("Arial", Font.BOLD, 16));
            label6.setForeground(new Color(102, 102, 255));
            contentPane.add(label6);
            label6.setBounds(405, 190, 85, 19);

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
            TextField_Nombres.setBounds(495, 150, 200, 29);

            //---- label5 ----
            label5.setText("Nombres:");
            label5.setFont(new Font("Arial", Font.BOLD, 16));
            label5.setForeground(new Color(102, 102, 255));
            contentPane.add(label5);
            label5.setBounds(405, 150, 85, 19);

            //---- label4 ----
            label4.setText("DPI:");
            label4.setFont(new Font("Arial", Font.BOLD, 16));
            label4.setForeground(new Color(102, 102, 255));
            contentPane.add(label4);
            label4.setBounds(405, 115, 33, 19);

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
            TextField_DPI.setBounds(495, 115, 200, 29);
            contentPane.add(label1);
            label1.setBounds(685, 490, 50, 40);

            //======== scrollPane1 ========
            {

                //---- TB_Conductores ----
                TB_Conductores.setModel(new DefaultTableModel());
                TB_Conductores.setForeground(new Color(255, 51, 102));
                TB_Conductores.setFont(new Font("Arial", Font.BOLD, 14));
                TB_Conductores.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TB_ConductoresMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(TB_Conductores);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(15, 145, 345, 355);

            //---- label2 ----
            label2.setText("Modificar Conductores");
            label2.setFont(new Font("Arial", Font.BOLD, 22));
            label2.setForeground(new Color(153, 153, 255));
            contentPane.add(label2);
            label2.setBounds(275, 20, 240, 26);

            //---- label3 ----
            label3.setText("Seleccione Un Conductor:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(15, 105, 235, 24);

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
        private JButton BT_Modificar;
        private JTextField TextField_Direccion;
        private JLabel label10;
        private JTextField TextField_Telefono;
        private JLabel label9;
        private JComboBox<String> CB_Genero;
        private JLabel label8;
        private JComboBox<String> CB_TipoLicencia;
        private JLabel label7;
        private JTextField TextField_Fecha;
        private JLabel label11;
        private JTextField TextField_Apellidos;
        private JLabel label6;
        private JTextField TextField_Nombres;
        private JLabel label5;
        private JLabel label4;
        private JTextField TextField_DPI;
        private JLabel label1;
        private JScrollPane scrollPane1;
        private JTable TB_Conductores;
        private JLabel label2;
        private JLabel label3;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

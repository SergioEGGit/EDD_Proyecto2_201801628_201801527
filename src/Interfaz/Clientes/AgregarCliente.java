
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Interfaz.Clientes;

    import Modelos.ModeloClientes;
    import Variables.VariablesGlobales;
    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

//----------------------------------------------------Author------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//---------------------------------------------------Principal----------------------------------------------------------

    public class AgregarCliente extends JFrame
    {
        //-------------------------------------------Constructor--------------------------------------------------------

        public AgregarCliente()
        {
            initComponents();
        }

        //----------------------------------------------Métodos---------------------------------------------------------

        private boolean ValidarCamposVacios()
        {
            String DPI = TextField_DPI.getText();
            String Nombres = TextField_Nombres.getText();
            String Apellidos = TextField_Apellidos.getText();
            String FechaNacimento = TextField_Fecha.getText();
            String Telefono = TextField_Telefono.getText();
            String Direccion = TextField_Direccion.getText();

            if(DPI.equals("") || Nombres.equals("") || Apellidos.equals("") || FechaNacimento.equals("") || Telefono.equals("") || Direccion.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Debe Rellenar Todos Los Campos", "Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
        }

        //-----------------------------------------------Events---------------------------------------------------------

        ///Verificación Solo Números

        private void TextField_DPIKeyTyped(KeyEvent e)
        {
            //Declaraciones

            //Variable Tipo String

            String DPI = TextField_DPI.getText();

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

        private void BT_RegistrarActionPerformed(ActionEvent e)
        {
            boolean Bandera = ValidarCamposVacios();

            if(Bandera)
            {
                String DPI = TextField_DPI.getText();
                String Nombres = TextField_Nombres.getText();
                String Apellidos = TextField_Apellidos.getText();
                String FechaNacimiento = TextField_Fecha.getText();
                String Genero = (String) CB_Genero.getSelectedItem();
                int Telefono = Integer.parseInt(TextField_Telefono.getText());
                String Direccion = TextField_Direccion.getText();

                ModeloClientes NuevoCliente = new ModeloClientes(DPI, Nombres, Apellidos, FechaNacimiento, Genero, Telefono, Direccion);

                VariablesGlobales.TablaHashClientes.InsertarClienteTablaHashClientes(NuevoCliente);

                TextField_DPI.setText("");
                TextField_Nombres.setText("");
                TextField_Apellidos.setText("");
                TextField_Fecha.setText("");
                TextField_Telefono.setText("");
                TextField_Direccion.setText("");
            }
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            BT_Registrar = new JButton();
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
            label2 = new JLabel();
            label1 = new JLabel();

            //======== this ========
            setTitle("Registro Clientes");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- BT_Registrar ----
            BT_Registrar.setText("Registrar");
            BT_Registrar.setForeground(new Color(51, 51, 255));
            BT_Registrar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Registrar.addActionListener(e -> BT_RegistrarActionPerformed(e));
            contentPane.add(BT_Registrar);
            BT_Registrar.setBounds(265, 465, 130, 30);

            //---- TextField_Direccion ----
            TextField_Direccion.setForeground(new Color(0, 0, 204));
            TextField_Direccion.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(TextField_Direccion);
            TextField_Direccion.setBounds(265, 400, 200, 29);

            //---- label10 ----
            label10.setText("Direcci\u00f3n:");
            label10.setFont(new Font("Arial", Font.BOLD, 16));
            label10.setForeground(new Color(102, 102, 255));
            contentPane.add(label10);
            label10.setBounds(180, 400, 80, 19);

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
            TextField_Telefono.setBounds(265, 360, 200, 29);

            //---- label9 ----
            label9.setText("T\u00e9lefono:");
            label9.setFont(new Font("Arial", Font.BOLD, 16));
            label9.setForeground(new Color(102, 102, 255));
            contentPane.add(label9);
            label9.setBounds(180, 360, 75, 19);

            //---- CB_Genero ----
            CB_Genero.setModel(new DefaultComboBoxModel<>(new String[] {
                "Masculino",
                "Femenino"
            }));
            CB_Genero.setFont(new Font("Arial", Font.BOLD, 16));
            CB_Genero.setForeground(new Color(0, 0, 204));
            contentPane.add(CB_Genero);
            CB_Genero.setBounds(265, 305, 205, 38);

            //---- label8 ----
            label8.setText("G\u00e9nero:");
            label8.setFont(new Font("Arial", Font.BOLD, 16));
            label8.setForeground(new Color(102, 102, 255));
            contentPane.add(label8);
            label8.setBounds(180, 315, 75, 19);

            //---- TextField_Fecha ----
            TextField_Fecha.setText("DD/MM/YYYY");
            TextField_Fecha.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Fecha.setForeground(new Color(0, 0, 204));
            contentPane.add(TextField_Fecha);
            TextField_Fecha.setBounds(355, 255, 115, 29);

            //---- label11 ----
            label11.setText("Fecha De Nacimiento:");
            label11.setFont(new Font("Arial", Font.BOLD, 16));
            label11.setForeground(new Color(102, 102, 255));
            contentPane.add(label11);
            label11.setBounds(180, 255, 170, 19);

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
            TextField_Apellidos.setBounds(270, 215, 200, 29);

            //---- label6 ----
            label6.setText("Apellidos:");
            label6.setFont(new Font("Arial", Font.BOLD, 16));
            label6.setForeground(new Color(102, 102, 255));
            contentPane.add(label6);
            label6.setBounds(180, 215, 85, 19);

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
            TextField_Nombres.setBounds(270, 175, 200, 29);

            //---- label5 ----
            label5.setText("Nombres:");
            label5.setFont(new Font("Arial", Font.BOLD, 16));
            label5.setForeground(new Color(102, 102, 255));
            contentPane.add(label5);
            label5.setBounds(180, 175, 85, 19);

            //---- TextField_DPI ----
            TextField_DPI.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_DPI.setForeground(new Color(0, 0, 204));
            TextField_DPI.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    TextField_DPIKeyTyped(e);
                }
            });
            contentPane.add(TextField_DPI);
            TextField_DPI.setBounds(270, 140, 200, 29);

            //---- label4 ----
            label4.setText("DPI:");
            label4.setFont(new Font("Arial", Font.BOLD, 16));
            label4.setForeground(new Color(102, 102, 255));
            contentPane.add(label4);
            label4.setBounds(180, 140, 33, 19);

            //---- label3 ----
            label3.setText("Ingrese Los Siguientes Datos:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(200, 85, 270, 24);

            //---- label2 ----
            label2.setText("Registro Clientes");
            label2.setFont(new Font("Arial", Font.BOLD, 22));
            label2.setForeground(new Color(153, 153, 255));
            contentPane.add(label2);
            label2.setBounds(240, 45, 180, 26);
            contentPane.add(label1);
            label1.setBounds(600, 505, 50, 40);

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
        private JButton BT_Registrar;
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
        private JLabel label2;
        private JLabel label1;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }


//--------------------------------------------Paquetes E Imports--------------------------------------------------------

    package Interfaz.Conductores;

    import Modelos.ModeloConductores;
    import Variables.VariablesGlobales;
    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

//-------------------------------------------------Author---------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//------------------------------------------------Principal-------------------------------------------------------------

    public class AgregarConductor extends JFrame
    {
        //-----------------------------------------Constructor----------------------------------------------------------

        public AgregarConductor()
        {
            initComponents();
        }

        //-------------------------------------------Métodos------------------------------------------------------------

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

        //---------------------------------------------Events-----------------------------------------------------------

        //Verificación Solo Números

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

        //Boton Registrar

        private void BT_RegistrarActionPerformed(ActionEvent e)
        {
            boolean Bandera = ValidarCamposVacios();

            if(Bandera)
            {
                String DPI = TextField_DPI.getText();
                String Nombres = TextField_Nombres.getText();
                String Apellidos = TextField_Apellidos.getText();
                String FechaNacimiento = TextField_Fecha.getText();
                String TipoLicencia = (String) CB_TipoLicencia.getSelectedItem();
                String Genero = (String) CB_Genero.getSelectedItem();
                int Telefono = Integer.parseInt(TextField_Telefono.getText());
                String Direccion = TextField_Direccion.getText();

                ModeloConductores NuevoConductor = new ModeloConductores(DPI, Nombres, Apellidos, FechaNacimiento, TipoLicencia, Genero, Telefono, Direccion);

                VariablesGlobales.ListaDobleCircularConductores.InsertarConductorFinalListaDobleCircularC(NuevoConductor);

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
            label1 = new JLabel();
            label2 = new JLabel();
            label3 = new JLabel();
            label4 = new JLabel();
            label5 = new JLabel();
            label6 = new JLabel();
            label7 = new JLabel();
            label8 = new JLabel();
            label9 = new JLabel();
            label10 = new JLabel();
            TextField_DPI = new JTextField();
            TextField_Nombres = new JTextField();
            TextField_Apellidos = new JTextField();
            TextField_Telefono = new JTextField();
            TextField_Direccion = new JTextField();
            BT_Registrar = new JButton();
            label11 = new JLabel();
            TextField_Fecha = new JTextField();
            CB_TipoLicencia = new JComboBox<>();
            CB_Genero = new JComboBox<>();

            //======== this ========
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Registro Usuario");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);
            contentPane.add(label1);
            label1.setBounds(610, 510, 50, 40);

            //---- label2 ----
            label2.setText("Registro Conductor");
            label2.setFont(new Font("Arial", Font.BOLD, 22));
            label2.setForeground(new Color(153, 153, 255));
            contentPane.add(label2);
            label2.setBounds(new Rectangle(new Point(245, 25), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("Ingrese Los Siguientes Datos:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(215, 65, 270, 24);

            //---- label4 ----
            label4.setText("DPI:");
            label4.setFont(new Font("Arial", Font.BOLD, 16));
            label4.setForeground(new Color(102, 102, 255));
            contentPane.add(label4);
            label4.setBounds(new Rectangle(new Point(195, 120), label4.getPreferredSize()));

            //---- label5 ----
            label5.setText("Nombres:");
            label5.setFont(new Font("Arial", Font.BOLD, 16));
            label5.setForeground(new Color(102, 102, 255));
            contentPane.add(label5);
            label5.setBounds(195, 155, 85, 19);

            //---- label6 ----
            label6.setText("Apellidos:");
            label6.setFont(new Font("Arial", Font.BOLD, 16));
            label6.setForeground(new Color(102, 102, 255));
            contentPane.add(label6);
            label6.setBounds(195, 195, 85, 19);

            //---- label7 ----
            label7.setText("Tipo De Licencia:");
            label7.setFont(new Font("Arial", Font.BOLD, 16));
            label7.setForeground(new Color(102, 102, 255));
            contentPane.add(label7);
            label7.setBounds(195, 280, 135, 19);

            //---- label8 ----
            label8.setText("G\u00e9nero:");
            label8.setFont(new Font("Arial", Font.BOLD, 16));
            label8.setForeground(new Color(102, 102, 255));
            contentPane.add(label8);
            label8.setBounds(195, 335, 75, 19);

            //---- label9 ----
            label9.setText("T\u00e9lefono:");
            label9.setFont(new Font("Arial", Font.BOLD, 16));
            label9.setForeground(new Color(102, 102, 255));
            contentPane.add(label9);
            label9.setBounds(195, 380, 75, 19);

            //---- label10 ----
            label10.setText("Direcci\u00f3n:");
            label10.setFont(new Font("Arial", Font.BOLD, 16));
            label10.setForeground(new Color(102, 102, 255));
            contentPane.add(label10);
            label10.setBounds(195, 420, 80, 19);

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
            TextField_DPI.setBounds(285, 120, 200, TextField_DPI.getPreferredSize().height);

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
            TextField_Nombres.setBounds(285, 155, 200, TextField_Nombres.getPreferredSize().height);

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
            TextField_Apellidos.setBounds(285, 195, 200, TextField_Apellidos.getPreferredSize().height);

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
            TextField_Telefono.setBounds(280, 380, 200, TextField_Telefono.getPreferredSize().height);

            //---- TextField_Direccion ----
            TextField_Direccion.setForeground(new Color(0, 0, 204));
            TextField_Direccion.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(TextField_Direccion);
            TextField_Direccion.setBounds(280, 420, 200, TextField_Direccion.getPreferredSize().height);

            //---- BT_Registrar ----
            BT_Registrar.setText("Registrar");
            BT_Registrar.setForeground(new Color(51, 51, 255));
            BT_Registrar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Registrar.addActionListener(e -> BT_RegistrarActionPerformed(e));
            contentPane.add(BT_Registrar);
            BT_Registrar.setBounds(new Rectangle(new Point(280, 480), BT_Registrar.getPreferredSize()));

            //---- label11 ----
            label11.setText("Fecha De Nacimiento:");
            label11.setFont(new Font("Arial", Font.BOLD, 16));
            label11.setForeground(new Color(102, 102, 255));
            contentPane.add(label11);
            label11.setBounds(195, 235, 170, 19);

            //---- TextField_Fecha ----
            TextField_Fecha.setText("DD/MM/YYYY");
            TextField_Fecha.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Fecha.setForeground(new Color(0, 0, 204));
            contentPane.add(TextField_Fecha);
            TextField_Fecha.setBounds(370, 235, 115, TextField_Fecha.getPreferredSize().height);

            //---- CB_TipoLicencia ----
            CB_TipoLicencia.setModel(new DefaultComboBoxModel<>(new String[] {
                "A",
                "B",
                "C"
            }));
            CB_TipoLicencia.setForeground(new Color(0, 0, 204));
            CB_TipoLicencia.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(CB_TipoLicencia);
            CB_TipoLicencia.setBounds(335, 275, 150, CB_TipoLicencia.getPreferredSize().height);

            //---- CB_Genero ----
            CB_Genero.setModel(new DefaultComboBoxModel<>(new String[] {
                "Masculino",
                "Femenino"
            }));
            CB_Genero.setFont(new Font("Arial", Font.BOLD, 16));
            CB_Genero.setForeground(new Color(0, 0, 204));
            contentPane.add(CB_Genero);
            CB_Genero.setBounds(280, 325, 205, CB_Genero.getPreferredSize().height);

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
        private JLabel label3;
        private JLabel label4;
        private JLabel label5;
        private JLabel label6;
        private JLabel label7;
        private JLabel label8;
        private JLabel label9;
        private JLabel label10;
        private JTextField TextField_DPI;
        private JTextField TextField_Nombres;
        private JTextField TextField_Apellidos;
        private JTextField TextField_Telefono;
        private JTextField TextField_Direccion;
        private JButton BT_Registrar;
        private JLabel label11;
        private JTextField TextField_Fecha;
        private JComboBox<String> CB_TipoLicencia;
        private JComboBox<String> CB_Genero;
        // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

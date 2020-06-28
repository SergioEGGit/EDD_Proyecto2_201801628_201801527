/*
 * Created by JFormDesigner on Sat Jun 27 08:04:11 CDT 2020
 */

//---------------------------------------------Paquetes E Imports-------------------------------------------------------

    package Interfaz.Vehiculos;

    import Modelos.ModeloConductores;
    import Modelos.ModeloVehiculo;
    import Variables.VariablesGlobales;

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

//---------------------------------------------------Author-------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//---------------------------------------------------Principal----------------------------------------------------------

    public class AgregarVehiculo extends JFrame
    {
        //-------------------------------------------Constructor--------------------------------------------------------

        public AgregarVehiculo()
        {
            initComponents();
        }
        
        //----------------------------------------------Métodos---------------------------------------------------------

        private boolean ValidarCamposVacios()
        {
            String Placa = TextField_Placa.getText();
            String Marca = TextField_Marca.getText();
            String Modelo = TextField_Modelo.getText();
            String Anio = TextField_Anio.getText();
            String Color = TextField_Color.getText();
            String Precio = TextField_Precio.getText();

            if(Placa.equals("") || Marca.equals("") || Modelo.equals("") || Anio.equals("") || Color.equals("") || Precio.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Debe Rellenar Todos Los Campos", "Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
        }

        //---------------------------------------------Events-----------------------------------------------------------

        private void BT_RegistrarActionPerformed(ActionEvent e)
        {
            boolean Bandera = ValidarCamposVacios();

            if(Bandera)
            {
                String Placa = TextField_Placa.getText();
                String Marca = TextField_Marca.getText();
                String Modelo = TextField_Modelo.getText();
                int Anio = Integer.parseInt(TextField_Anio.getText());
                String Color = TextField_Color.getText();
                double Precio = Double.parseDouble(TextField_Precio.getText());
                String TipoTrasn = (String) CB_TipoTrans.getSelectedItem();
                boolean Trans = false;

                boolean Bandera2 = false;

                if(TipoTrasn.equals("Automática") || TipoTrasn.equals("Automatica"))
                {
                    Trans = false;
                }
                else if(TipoTrasn.equals("Mecánica") || TipoTrasn.equals("Mecanica"))
                {
                    Trans = true;
                }

                ModeloVehiculo NuevoVehiculo = new ModeloVehiculo(Placa, Marca, Modelo, Anio, Color, Precio, Trans);

                Bandera2 = VariablesGlobales.ArbolBAutomoviles.AgregarVehiculo(NuevoVehiculo);

                if(Bandera2)
                {
                    JOptionPane.showMessageDialog(null, "Vehiculo Agregado Con Exito!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El Vehiculo Indicado Ya Existe En El Sistema!", "Error!", JOptionPane.ERROR_MESSAGE);
                }

               /* TextField_Placa.setText("");
                TextField_Marca.setText("");
                TextField_Modelo.setText("");
                TextField_Anio.setText("");
                TextField_Color.setText("");
                TextField_Precio.setText("");
                CB_TipoTrans.setSelectedIndex(0);
                */
            }
        }

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
        
        private void initComponents() 
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            label9 = new JLabel();
            label8 = new JLabel();
            label7 = new JLabel();
            label11 = new JLabel();
            label6 = new JLabel();
            label5 = new JLabel();
            label4 = new JLabel();
            label3 = new JLabel();
            label2 = new JLabel();
            BT_Registrar = new JButton();
            label1 = new JLabel();
            TextField_Placa = new JTextField();
            TextField_Marca = new JTextField();
            TextField_Modelo = new JTextField();
            TextField_Anio = new JTextField();
            TextField_Color = new JTextField();
            TextField_Precio = new JTextField();
            CB_TipoTrans = new JComboBox<>();

            //======== this ========
            setTitle("Registro Vehiculo");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- label9 ----
            label9.setText("Tipo Transmisi\u00f3n:");
            label9.setFont(new Font("Arial", Font.BOLD, 16));
            label9.setForeground(new Color(102, 102, 255));
            contentPane.add(label9);
            label9.setBounds(180, 400, 150, 19);

            //---- label8 ----
            label8.setText("Precio:");
            label8.setFont(new Font("Arial", Font.BOLD, 16));
            label8.setForeground(new Color(102, 102, 255));
            contentPane.add(label8);
            label8.setBounds(180, 345, 75, 19);

            //---- label7 ----
            label7.setText("Color:");
            label7.setFont(new Font("Arial", Font.BOLD, 16));
            label7.setForeground(new Color(102, 102, 255));
            contentPane.add(label7);
            label7.setBounds(180, 300, 80, 19);

            //---- label11 ----
            label11.setText("A\u00f1o:");
            label11.setFont(new Font("Arial", Font.BOLD, 16));
            label11.setForeground(new Color(102, 102, 255));
            contentPane.add(label11);
            label11.setBounds(180, 255, 80, 19);

            //---- label6 ----
            label6.setText("Modelo:");
            label6.setFont(new Font("Arial", Font.BOLD, 16));
            label6.setForeground(new Color(102, 102, 255));
            contentPane.add(label6);
            label6.setBounds(180, 210, 80, 19);

            //---- label5 ----
            label5.setText("Marca:");
            label5.setFont(new Font("Arial", Font.BOLD, 16));
            label5.setForeground(new Color(102, 102, 255));
            contentPane.add(label5);
            label5.setBounds(180, 170, 80, 19);

            //---- label4 ----
            label4.setText("Placa:");
            label4.setFont(new Font("Arial", Font.BOLD, 16));
            label4.setForeground(new Color(102, 102, 255));
            contentPane.add(label4);
            label4.setBounds(180, 130, 80, 19);

            //---- label3 ----
            label3.setText("Ingrese Los Siguientes Datos:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(200, 75, 270, 24);

            //---- label2 ----
            label2.setText("Registro Conductor");
            label2.setFont(new Font("Arial", Font.BOLD, 22));
            label2.setForeground(new Color(153, 153, 255));
            contentPane.add(label2);
            label2.setBounds(230, 35, 200, 26);

            //---- BT_Registrar ----
            BT_Registrar.setText("Registrar");
            BT_Registrar.setForeground(new Color(51, 51, 255));
            BT_Registrar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Registrar.addActionListener(e -> BT_RegistrarActionPerformed(e));
            contentPane.add(BT_Registrar);
            BT_Registrar.setBounds(260, 450, 145, 30);
            contentPane.add(label1);
            label1.setBounds(565, 465, 50, 40);

            //---- TextField_Placa ----
            TextField_Placa.setForeground(new Color(0, 0, 204));
            TextField_Placa.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(TextField_Placa);
            TextField_Placa.setBounds(266, 130, 184, TextField_Placa.getPreferredSize().height);

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
            TextField_Marca.setBounds(266, 170, 184, TextField_Marca.getPreferredSize().height);

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
            TextField_Modelo.setBounds(266, 210, 184, TextField_Modelo.getPreferredSize().height);

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
            TextField_Anio.setBounds(266, 255, 184, TextField_Anio.getPreferredSize().height);

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
            TextField_Color.setBounds(266, 300, 184, TextField_Color.getPreferredSize().height);

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
            TextField_Precio.setBounds(266, 345, 184, TextField_Precio.getPreferredSize().height);

            //---- CB_TipoTrans ----
            CB_TipoTrans.setFont(new Font("Arial", Font.BOLD, 16));
            CB_TipoTrans.setForeground(new Color(0, 0, 204));
            CB_TipoTrans.setModel(new DefaultComboBoxModel<>(new String[] {
                "Autom\u00e1tica",
                "Mec\u00e1nica"
            }));
            contentPane.add(CB_TipoTrans);
            CB_TipoTrans.setBounds(330, 390, 120, CB_TipoTrans.getPreferredSize().height);

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
        private JLabel label9;
        private JLabel label8;
        private JLabel label7;
        private JLabel label11;
        private JLabel label6;
        private JLabel label5;
        private JLabel label4;
        private JLabel label3;
        private JLabel label2;
        private JButton BT_Registrar;
        private JLabel label1;
        private JTextField TextField_Placa;
        private JTextField TextField_Marca;
        private JTextField TextField_Modelo;
        private JTextField TextField_Anio;
        private JTextField TextField_Color;
        private JTextField TextField_Precio;
        private JComboBox<String> CB_TipoTrans;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }


//------------------------------------------------Paquetes E Imports----------------------------------------------------

    package Interfaz.Conductores;

    import Modelos.ModeloConductores;
    import Variables.VariablesGlobales;

    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.*;

//------------------------------------------------------Author----------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//------------------------------------------------------Principal-------------------------------------------------------

    public class BuscarConductor extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //---------------------------------------------Constructor------------------------------------------------------

        public BuscarConductor()
        {
            initComponents();
            Modelo = new DefaultTableModel();
            ArrayList<ModeloConductores> ListaConductores = VariablesGlobales.ListaDobleCircularConductores.ObtenerTodosLosConductoresListaDobleCircularC();
            ObtenerConductores(ListaConductores);
        }

        //-----------------------------------------------Métodos--------------------------------------------------------

        public void ObtenerConductores(ArrayList<ModeloConductores> ListaConductores)
        {
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

        //------------------------------------------------Events--------------------------------------------------------

        //Boton Buscar

        private void BT_BuscarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            //Variables Tipo String

            String DPI = TextField_Buscar.getText();
            String Cadena = "";

            //Variables Tipo Modelo Conductores

            ModeloConductores ConductorBuscado = new ModeloConductores();

            //Variables Tipo Boolean

            boolean ExisteConductor = VariablesGlobales.ListaDobleCircularConductores.VerificarConductorListaDobleCircularC(TextField_Buscar.getText());

            if(ExisteConductor)
            {
                ConductorBuscado = VariablesGlobales.ListaDobleCircularConductores.BuscarUsuarioListaDobleCircularC(DPI);

                Cadena += "Información Conductor \n";
                Cadena += "DPI: " + ConductorBuscado.getDPIConductor() + "\n";
                Cadena += "Nombres: " + ConductorBuscado.getNombresConductor() + "\n";
                Cadena += "Apellidos: " + ConductorBuscado.getApellidosConductor() + "\n";
                Cadena += "Fecha Nacimiento: " + ConductorBuscado.getFechaNacimientoConductor() + "\n";
                Cadena += "Tipo De Licencia: " + ConductorBuscado.getTipoLicenciaConductor() + "\n";
                Cadena += "Género: " + ConductorBuscado.getGeneroConductor() + "\n";
                Cadena += "Teléfono: " + ConductorBuscado.getTelefonoConductor() + "\n";
                Cadena += "Dirección: " + ConductorBuscado.getDireccionConductor() + "\n";

                JOptionPane.showMessageDialog(null, Cadena, "Encontrado!" , JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Conductor Indicado No Existe En El Sistema!", "Error!", JOptionPane.ERROR_MESSAGE);
            }

            TextField_Buscar.setText("");
        }

        //Tabla Click

        private void TB_ConductoresMouseClicked(MouseEvent e)
        {
            int Columna = 0;
            int Fila = TB_Conductores.getSelectedRow();

            String Valor = TB_Conductores.getValueAt(Fila, Columna).toString();

            TextField_Buscar.setText(Valor);
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

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            BT_Buscar = new JButton();
            TextField_Buscar = new JTextField();
            label3 = new JLabel();
            label1 = new JLabel();
            label2 = new JLabel();
            scrollPane1 = new JScrollPane();
            TB_Conductores = new JTable();

            //======== this ========
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Buscar Conductor");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- BT_Buscar ----
            BT_Buscar.setText("Buscar");
            BT_Buscar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Buscar.setForeground(new Color(51, 51, 255));
            BT_Buscar.addActionListener(e -> BT_BuscarActionPerformed(e));
            contentPane.add(BT_Buscar);
            BT_Buscar.setBounds(285, 125, 115, 30);

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
            TextField_Buscar.setBounds(360, 75, 180, 29);

            //---- label3 ----
            label3.setText("Seleccione Un Conductor:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(120, 75, 235, 24);

            //---- label1 ----
            label1.setText("Buscar Conductores");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(235, 25, 220, 26);
            contentPane.add(label2);
            label2.setBounds(630, 610, 50, 50);

            //======== scrollPane1 ========
            {

                //---- TB_Conductores ----
                TB_Conductores.setFont(new Font("Arial", Font.BOLD, 14));
                TB_Conductores.setForeground(new Color(255, 51, 102));
                TB_Conductores.setModel(new DefaultTableModel());
                TB_Conductores.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TB_ConductoresMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(TB_Conductores);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(115, 190, scrollPane1.getPreferredSize().width, 410);

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
        private JButton BT_Buscar;
        private JTextField TextField_Buscar;
        private JLabel label3;
        private JLabel label1;
        private JLabel label2;
        private JScrollPane scrollPane1;
        private JTable TB_Conductores;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

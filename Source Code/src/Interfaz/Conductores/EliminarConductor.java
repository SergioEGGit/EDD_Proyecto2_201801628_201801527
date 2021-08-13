
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Interfaz.Conductores;

    import java.awt.event.*;
    import Modelos.ModeloConductores;
    import Variables.VariablesGlobales;
    import java.awt.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.*;

//----------------------------------------------------Author------------------------------------------------------------    
    
    /**
     * @author Sergio Echigoyen
     */

//----------------------------------------------------Principal---------------------------------------------------------    
    
    public class EliminarConductor extends JFrame 
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //--------------------------------------------Constructor-------------------------------------------------------
        
        public EliminarConductor()
        {
            initComponents();
            Modelo = new DefaultTableModel();
            ArrayList<ModeloConductores> ListaConductores = VariablesGlobales.ListaDobleCircularConductores.ObtenerTodosLosConductoresListaDobleCircularC();
            ObtenerConductores(ListaConductores);
        }

        //-----------------------------------------------Métodos--------------------------------------------------------

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

        //------------------------------------------------Events--------------------------------------------------------

        //Boton Eliminar

        private void BT_EliminarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            //Variables Tipo String

            String DPI = TextField_Eliminar.getText();

            //Array Tipo String

            ArrayList<ModeloConductores> ArrayConductores = new ArrayList<ModeloConductores>();

            //Variables Tipo Boolean

            boolean ExisteConductor = VariablesGlobales.ListaDobleCircularConductores.VerificarConductorListaDobleCircularC(DPI);

            if(ExisteConductor)
            {
                int Button = JOptionPane.YES_NO_OPTION;
                int Result = JOptionPane.showConfirmDialog(this, "Seguro Que Desea Eliminar El Conductor", "Pregunta!", Button);

                if(Result == 0)
                {
                    VariablesGlobales.ListaDobleCircularConductores.EliminarConductorListaDobleCircularC(DPI);

                    Modelo = new DefaultTableModel();

                    ArrayConductores = VariablesGlobales.ListaDobleCircularConductores.ObtenerTodosLosConductoresListaDobleCircularC();

                    ObtenerConductores(ArrayConductores);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El Conductor Indicado No Existe En El Sistema!", "Error!", JOptionPane.ERROR_MESSAGE);
            }

            TextField_Eliminar.setText("");
        }

        //Tabla Click

        private void TB_ConductoresMouseClicked(MouseEvent e)
        {
            int Columna = 0;
            int Fila = TB_Conductores.getSelectedRow();

            String Valor = TB_Conductores.getValueAt(Fila, Columna).toString();

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
            label1 = new JLabel();
            label3 = new JLabel();
            TextField_Eliminar = new JTextField();
            scrollPane1 = new JScrollPane();
            TB_Conductores = new JTable();
            label2 = new JLabel();
            BT_Eliminar = new JButton();

            //======== this ========
            setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Eliminar Conductor");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- label1 ----
            label1.setText("Eliminar Conductores");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(285, 20), label1.getPreferredSize()));

            //---- label3 ----
            label3.setText("Seleccione Un Conductor:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(170, 70, 235, 24);

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
            TextField_Eliminar.setBounds(410, 70, 180, TextField_Eliminar.getPreferredSize().height);

            //======== scrollPane1 ========
            {

                //---- TB_Conductores ----
                TB_Conductores.setModel(new DefaultTableModel(1, 0));
                TB_Conductores.setFont(new Font("Arial", Font.BOLD, 14));
                TB_Conductores.setForeground(new Color(255, 51, 102));
                TB_Conductores.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        TB_ConductoresMouseClicked(e);
                    }
                });
                scrollPane1.setViewportView(TB_Conductores);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(new Rectangle(new Point(160, 170), scrollPane1.getPreferredSize()));
            contentPane.add(label2);
            label2.setBounds(680, 605, 50, 50);

            //---- BT_Eliminar ----
            BT_Eliminar.setText("Eliminar");
            BT_Eliminar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Eliminar.setForeground(new Color(51, 51, 255));
            BT_Eliminar.addActionListener(e -> BT_EliminarActionPerformed(e));
            contentPane.add(BT_Eliminar);
            BT_Eliminar.setBounds(new Rectangle(new Point(340, 120), BT_Eliminar.getPreferredSize()));

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
        private JLabel label3;
        private JTextField TextField_Eliminar;
        private JScrollPane scrollPane1;
        private JTable TB_Conductores;
        private JLabel label2;
        private JButton BT_Eliminar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

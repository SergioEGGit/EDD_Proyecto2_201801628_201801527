
//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Interfaz.Conductores;

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
        
        private void initComponents() 
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            label1 = new JLabel();
            label3 = new JLabel();
            textField1 = new JTextField();
            scrollPane1 = new JScrollPane();
            TB_Conductores = new JTable();
            label2 = new JLabel();

            //======== this ========
            setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- label1 ----
            label1.setText("Eliminar Conductores");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(new Rectangle(new Point(245, 20), label1.getPreferredSize()));

            //---- label3 ----
            label3.setText("Seleccione Un Conductor:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(120, 70, 235, 24);

            //---- textField1 ----
            textField1.setForeground(new Color(0, 0, 204));
            textField1.setFont(new Font("Arial", Font.BOLD, 16));
            contentPane.add(textField1);
            textField1.setBounds(360, 70, 180, textField1.getPreferredSize().height);

            //======== scrollPane1 ========
            {

                //---- TB_Conductores ----
                TB_Conductores.setModel(new DefaultTableModel(1, 0));
                scrollPane1.setViewportView(TB_Conductores);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(new Rectangle(new Point(160, 170), scrollPane1.getPreferredSize()));
            contentPane.add(label2);
            label2.setBounds(680, 605, 50, 50);

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
        private JTextField textField1;
        private JScrollPane scrollPane1;
        private JTable TB_Conductores;
        private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

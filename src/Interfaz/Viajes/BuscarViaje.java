
//--------------------------------------------Paquetes E Imports--------------------------------------------------------

    package Interfaz.Viajes;

    import Estructuras.BlockchainViajesNodo;
    import Modelos.ModeloViajes;
    import Variables.VariablesGlobales;
    import org.apache.commons.codec.digest.DigestUtils;
    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.*;

//----------------------------------------------------Author------------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//----------------------------------------------------Principal---------------------------------------------------------

    public class BuscarViaje extends JFrame
    {
        //----------------------------------------------Variables-------------------------------------------------------
        
        DefaultTableModel Modelo;
        
        //--------------------------------------------Constructor-------------------------------------------------------

        public BuscarViaje()
        {
            initComponents();
            Modelo = new DefaultTableModel();
            ArrayList<ModeloViajes> ListaViajes = VariablesGlobales.BlockchainViajes.TodosLosBloquesBlockchainViajes();
            ObtenerLugares(ListaViajes);
        }
        
        //----------------------------------------------Metodos---------------------------------------------------------

        public void ObtenerLugares(ArrayList<ModeloViajes> ListaViajes)
        {
            Modelo = new DefaultTableModel();
            Modelo.addColumn("Codigo");
            Modelo.addColumn("Placa");
            Modelo.addColumn("Origen");
            Modelo.addColumn("Destino");
            Modelo.addColumn("Fecha Inicio");
            Modelo.addColumn("HoraInicio");

            for(ModeloViajes Viaje: ListaViajes)
            {
                if (Viaje != null)
                {
                    Object[] Fila = new Object[]
                            {
                                    Viaje.getIdentificadorViaje(),
                                    Viaje.getVehiculoViaje().getVehiculos().get(Viaje.getPosicionArray()).getPlaca(),
                                    Viaje.getLugarOrigenViaje(),
                                    Viaje.getLugaDestinoViaje(),
                                    Viaje.getFechaViaje(),
                                    Viaje.getHoraViaje()
                            };
                    Modelo.addRow(Fila);
                }
            }
            TB_Viajes.setModel(Modelo);
            TB_Viajes.getColumnModel().getColumn(0).setPreferredWidth(400);
            TB_Viajes.getColumnModel().getColumn(1).setPreferredWidth(400);
            TB_Viajes.getColumnModel().getColumn(2).setPreferredWidth(400);
            TB_Viajes.getColumnModel().getColumn(3).setPreferredWidth(400);
            TB_Viajes.getColumnModel().getColumn(4).setPreferredWidth(400);
            TB_Viajes.getColumnModel().getColumn(5).setPreferredWidth(400);
            TB_Viajes.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }

        //-----------------------------------------------Events---------------------------------------------------------

        private void BT_BuscarActionPerformed(ActionEvent e)
        {
            if(TextField_Fecha.getText().equals("") || TextField_Hora.getText().equals("") || TextField_Placa.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Debe Rellenar Todos Los Campos", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String Placa = TextField_Placa.getText();
                String Fecha = TextField_Fecha.getText();
                String Hora = TextField_Hora.getText();

                String Identificador = Placa + Fecha + Hora;

                String Codificado = DigestUtils.md5Hex(Identificador);

                BlockchainViajesNodo NodoBuscado = VariablesGlobales.BlockchainViajes.BuscarViajeBlockchainViaje(Codificado);

                if(NodoBuscado != null)
                {
                    String Cadena = "";
                    Cadena += "Viaje Encontrado!" + "\n";
                    Cadena += "Codigo: " + NodoBuscado.getNuevoViaje().getIdentificadorViaje() + "\n";
                    Cadena += "Origen: " + NodoBuscado.getNuevoViaje().getLugarOrigenViaje() + "\n";
                    Cadena += "Destino: " + NodoBuscado.getNuevoViaje().getLugaDestinoViaje() + "\n";
                    Cadena += "Fecha: " + NodoBuscado.getNuevoViaje().getFechaViaje() + "\n";
                    Cadena += "Hora: " + NodoBuscado.getNuevoViaje().getHoraViaje() + "\n";

                    JOptionPane.showMessageDialog(null, Cadena, "Encontrado!", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El Viaje Indicado No Existe En El Sistema");
                }
            }

            TextField_Placa.setText("");
            TextField_Hora.setText("HH:MM");
            TextField_Fecha.setText("DD/MM/YYYY");
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            label1 = new JLabel();
            label3 = new JLabel();
            BT_Buscar = new JButton();
            label2 = new JLabel();
            label11 = new JLabel();
            TextField_Hora = new JTextField();
            TextField_Fecha = new JTextField();
            label6 = new JLabel();
            label7 = new JLabel();
            TextField_Placa = new JTextField();
            scrollPane1 = new JScrollPane();
            TB_Viajes = new JTable();

            //======== this ========
            setTitle("Buscar Viaje");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- label1 ----
            label1.setText("Buscar Viajes");
            label1.setFont(new Font("Arial", Font.BOLD, 22));
            label1.setForeground(new Color(153, 153, 255));
            contentPane.add(label1);
            label1.setBounds(300, 40, 150, 26);

            //---- label3 ----
            label3.setText("Seleccione Un Viaje");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(280, 90, 185, 24);

            //---- BT_Buscar ----
            BT_Buscar.setText("Buscar");
            BT_Buscar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Buscar.setForeground(new Color(51, 51, 255));
            BT_Buscar.addActionListener(e -> BT_BuscarActionPerformed(e));
            contentPane.add(BT_Buscar);
            BT_Buscar.setBounds(135, 295, 115, 30);
            contentPane.add(label2);
            label2.setBounds(740, 615, 45, 35);

            //---- label11 ----
            label11.setText("Hora Inicio:");
            label11.setFont(new Font("Arial", Font.BOLD, 16));
            label11.setForeground(new Color(102, 102, 255));
            contentPane.add(label11);
            label11.setBounds(45, 230, 120, 19);

            //---- TextField_Hora ----
            TextField_Hora.setForeground(new Color(0, 0, 204));
            TextField_Hora.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Hora.setText("HH:MM");
            contentPane.add(TextField_Hora);
            TextField_Hora.setBounds(175, 230, 180, 29);

            //---- TextField_Fecha ----
            TextField_Fecha.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Fecha.setForeground(new Color(0, 0, 204));
            TextField_Fecha.setText("DD/MM/YYYY");
            contentPane.add(TextField_Fecha);
            TextField_Fecha.setBounds(175, 185, 180, 29);

            //---- label6 ----
            label6.setText("Fecha Inicio:");
            label6.setFont(new Font("Arial", Font.BOLD, 16));
            label6.setForeground(new Color(102, 102, 255));
            contentPane.add(label6);
            label6.setBounds(45, 185, 120, 19);

            //---- label7 ----
            label7.setText("Placa:");
            label7.setFont(new Font("Arial", Font.BOLD, 16));
            label7.setForeground(new Color(102, 102, 255));
            contentPane.add(label7);
            label7.setBounds(45, 140, 120, 19);

            //---- TextField_Placa ----
            TextField_Placa.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Placa.setForeground(new Color(0, 0, 204));
            contentPane.add(TextField_Placa);
            TextField_Placa.setBounds(175, 140, 180, TextField_Placa.getPreferredSize().height);

            //======== scrollPane1 ========
            {

                //---- TB_Viajes ----
                TB_Viajes.setModel(new DefaultTableModel());
                TB_Viajes.setFont(new Font("Arial", Font.BOLD, 14));
                TB_Viajes.setForeground(new Color(255, 51, 102));
                scrollPane1.setViewportView(TB_Viajes);
            }
            contentPane.add(scrollPane1);
            scrollPane1.setBounds(385, 145, 380, scrollPane1.getPreferredSize().height);

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
        private JButton BT_Buscar;
        private JLabel label2;
        private JLabel label11;
        private JTextField TextField_Hora;
        private JTextField TextField_Fecha;
        private JLabel label6;
        private JLabel label7;
        private JTextField TextField_Placa;
        private JScrollPane scrollPane1;
        private JTable TB_Viajes;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }


//----------------------------------------------Paquetes E Imports------------------------------------------------------

    package Interfaz.Viajes;

    import Estructuras.*;
    import Modelos.ModeloClientes;
    import Modelos.ModeloConductores;
    import Modelos.ModeloVehiculo;
    import Modelos.ModeloViajes;
    import Variables.VariablesGlobales;
    import org.apache.commons.codec.cli.Digest;
    import org.apache.commons.codec.digest.DigestUtils;

    import java.awt.*;
    import java.awt.event.*;
    import java.util.ArrayList;
    import javax.swing.*;
    import javax.swing.table.DefaultTableModel;

//-----------------------------------------------------Author-----------------------------------------------------------

    /**
     * @author Sergio Echigoyen
     */

//---------------------------------------------------Principal----------------------------------------------------------

     public class AgregarViaje extends JFrame
    {
        //---------------------------------------------Variables--------------------------------------------------------

        DefaultTableModel Modelo;

        //-------------------------------------------Constructor--------------------------------------------------------

        public AgregarViaje()
        {
            initComponents();
        }

        //-----------------------------------------------Métodos--------------------------------------------------------

        public void ObtenerClientes(JTable NuevaTabla, ArrayList<ModeloClientes> ListaClientes)
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
            NuevaTabla.setModel(Modelo);
            NuevaTabla.getColumnModel().getColumn(0).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(1).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(2).setPreferredWidth(400);
            NuevaTabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }

        public void ObtenerConductores(JTable NuevaTabla, ArrayList<ModeloConductores> ListaConductores)
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
            NuevaTabla.setModel(Modelo);
            NuevaTabla.getColumnModel().getColumn(0).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(1).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(2).setPreferredWidth(400);
            NuevaTabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }

        public void ObtenerVehiculos(JTable NuevaTabla, ArrayList<ModeloVehiculo> ListaVehiculos)
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
            NuevaTabla.setModel(Modelo);
            NuevaTabla.getColumnModel().getColumn(0).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(1).setPreferredWidth(400);
            NuevaTabla.getColumnModel().getColumn(2).setPreferredWidth(400);
            NuevaTabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        }

        public boolean ValidarCamposVacios()
        {
            //Declaraciones

            boolean Bandera = false;

            String Origen = TextField_Origen.getText();
            String Destino = TextField_Destino.getText();
            String Fecha = TextField_Fecha.getText();
            String Hora = TextField_Hora.getText();
            String DpiCliente = TextField_DpiCliente.getText();
            String DpiConductor = TextField_DpiConductor.getText();
            String PlacaVehiculo = TextField_Vehiculos.getText();

            if(Origen.equals("") || Destino.equals("") || Fecha.equals("") || Hora.equals("") || DpiCliente.equals("") || DpiConductor.equals("") || PlacaVehiculo.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Debe Rellenar Todos Los Campos", "Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            return true;
        }

        //---------------------------------------------Events-----------------------------------------------------------

        private void BT_RegistrarActionPerformed(ActionEvent e)
        {
            //Declaraciones

            boolean Bandera = ValidarCamposVacios();

            if(Bandera)
            {
                String Origen = TextField_Origen.getText();
                String Destino = TextField_Destino.getText();
                String Fecha = TextField_Fecha.getText();
                String Hora = TextField_Hora.getText();
                ListaDobleCircularConductoresNodo NodoConductor = VariablesGlobales.ListaDobleCircularConductores.BuscarNododCondcutoresListaDobleCircularC(TextField_DpiConductor.getText());
                ListaSimpleClientesNodo NodoClietnes = VariablesGlobales.TablaHashClientes.BuscarClienteTablaHashClientes(TextField_DpiCliente.getText());
                //Arbol B Nodo
                ArbolBAutosNodo NodoArbol = new ArbolBAutosNodo();
                int PosicionArray = 0;
                ListaSimpleRutas NuevaLista = new ListaSimpleRutas();

                String Identificador = Fecha + Hora;
                String Llave = DigestUtils.md5Hex(Identificador);

                ModeloViajes NuevoViaje = new ModeloViajes(Identificador, Origen, Destino, Fecha, Hora, NodoClietnes, NodoConductor, NodoArbol, 0, NuevaLista);

                VariablesGlobales.BlockchainViajes.InsertarViajeBlockchainViajes(NuevoViaje);

            }
        }

        private void TextField_DpiClienteMouseClicked(MouseEvent e)
        {
            //Declaraciones

            Modelo = new DefaultTableModel();
            ArrayList<ModeloClientes> ListaClientes = VariablesGlobales.TablaHashClientes.ListarTodosLosClientesTablaHashClientes();
            JTable Tabla = new JTable();
            Tabla.setFont(new Font("Arial", Font.BOLD, 16));
            Tabla.setForeground(new Color(255, 51, 102));
            Tabla.setBounds(10, 5, 50, 50);
            ObtenerClientes(Tabla, ListaClientes);

            int Mensaje = JOptionPane.showConfirmDialog(null, new JScrollPane(Tabla), "Seleccione Un Cliente", JOptionPane.OK_CANCEL_OPTION);

            if(Mensaje == JOptionPane.OK_OPTION)
            {
                int Fila = Tabla.getSelectedRow();
                String Valor = (String) Tabla.getValueAt(Fila, 0);

                if(!Valor.equals(""))
                {
                    TextField_DpiCliente.setText(Valor);
                }
            }
        }

        private void TextField_DpiConductorMouseClicked(MouseEvent e)
        {
            //Declaraciones

            Modelo = new DefaultTableModel();
            ArrayList<ModeloConductores> ListaConductores = VariablesGlobales.ListaDobleCircularConductores.ObtenerTodosLosConductoresListaDobleCircularC();
            JTable Tabla = new JTable();
            Tabla.setFont(new Font("Arial", Font.BOLD, 16));
            Tabla.setForeground(new Color(255, 51, 102));
            Tabla.setBounds(10, 5, 50, 50);
            ObtenerConductores(Tabla, ListaConductores);

            int Mensaje = JOptionPane.showConfirmDialog(null, new JScrollPane(Tabla), "Seleccione Un Conductor", JOptionPane.OK_CANCEL_OPTION);

            if(Mensaje == JOptionPane.OK_OPTION)
            {
                int Fila = Tabla.getSelectedRow();
                String Valor = (String) Tabla.getValueAt(Fila, 0);

                if(!Valor.equals(""))
                {
                    TextField_DpiConductor.setText(Valor);
                }
            }
        }

        private void TextField_VehiculosMouseClicked(MouseEvent e)
        {
            //Declaraciones

            Modelo = new DefaultTableModel();
            ArrayList<ModeloVehiculo> ListaVehiculos = VariablesGlobales.ArbolBAutomoviles.TodosLosVehiculos();
            JTable Tabla = new JTable();
            Tabla.setFont(new Font("Arial", Font.BOLD, 16));
            Tabla.setForeground(new Color(255, 51, 102));
            Tabla.setBounds(10, 5, 50, 50);
            ObtenerVehiculos(Tabla, ListaVehiculos);

            int Mensaje = JOptionPane.showConfirmDialog(null, new JScrollPane(Tabla), "Seleccione Un Vehiculo", JOptionPane.OK_CANCEL_OPTION);

            if(Mensaje == JOptionPane.OK_OPTION)
            {
                int Fila = Tabla.getSelectedRow();
                String Valor = (String) Tabla.getValueAt(Fila, 0);

                if(!Valor.equals(""))
                {
                    TextField_Vehiculos.setText(Valor);
                }
            }
        }

        private void initComponents()
        {
            // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
            // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
            label3 = new JLabel();
            label2 = new JLabel();
            label4 = new JLabel();
            label5 = new JLabel();
            label6 = new JLabel();
            label11 = new JLabel();
            label7 = new JLabel();
            label8 = new JLabel();
            label9 = new JLabel();
            BT_Registrar = new JButton();
            label1 = new JLabel();
            TextField_DpiCliente = new JTextField();
            TextField_Origen = new JTextField();
            TextField_Destino = new JTextField();
            TextField_Fecha = new JTextField();
            TextField_Hora = new JTextField();
            TextField_DpiConductor = new JTextField();
            TextField_Vehiculos = new JTextField();

            //======== this ========
            setTitle("Agregar Viaje");
            Container contentPane = getContentPane();
            contentPane.setLayout(null);

            //---- label3 ----
            label3.setText("Ingrese Los Siguientes Datos:");
            label3.setForeground(new Color(0, 102, 255));
            label3.setFont(new Font("Arial", Font.BOLD, 18));
            contentPane.add(label3);
            label3.setBounds(200, 65, 270, 24);

            //---- label2 ----
            label2.setText("Registro Viajes");
            label2.setFont(new Font("Arial", Font.BOLD, 22));
            label2.setForeground(new Color(153, 153, 255));
            contentPane.add(label2);
            label2.setBounds(255, 25, 160, 26);

            //---- label4 ----
            label4.setText("Lugar Origen:");
            label4.setFont(new Font("Arial", Font.BOLD, 16));
            label4.setForeground(new Color(102, 102, 255));
            contentPane.add(label4);
            label4.setBounds(215, 120, 120, 19);

            //---- label5 ----
            label5.setText("Lugar Destino:");
            label5.setFont(new Font("Arial", Font.BOLD, 16));
            label5.setForeground(new Color(102, 102, 255));
            contentPane.add(label5);
            label5.setBounds(215, 165, 120, 19);

            //---- label6 ----
            label6.setText("Fecha Inicio:");
            label6.setFont(new Font("Arial", Font.BOLD, 16));
            label6.setForeground(new Color(102, 102, 255));
            contentPane.add(label6);
            label6.setBounds(215, 210, 120, 19);

            //---- label11 ----
            label11.setText("Hora Inicio:");
            label11.setFont(new Font("Arial", Font.BOLD, 16));
            label11.setForeground(new Color(102, 102, 255));
            contentPane.add(label11);
            label11.setBounds(215, 255, 120, 19);

            //---- label7 ----
            label7.setText("DPI Cliente:");
            label7.setFont(new Font("Arial", Font.BOLD, 16));
            label7.setForeground(new Color(102, 102, 255));
            contentPane.add(label7);
            label7.setBounds(215, 305, 95, 19);

            //---- label8 ----
            label8.setText("DPI Conductor:");
            label8.setFont(new Font("Arial", Font.BOLD, 16));
            label8.setForeground(new Color(102, 102, 255));
            contentPane.add(label8);
            label8.setBounds(215, 355, 125, 19);

            //---- label9 ----
            label9.setText("Placa Vehiculo:");
            label9.setFont(new Font("Arial", Font.BOLD, 16));
            label9.setForeground(new Color(102, 102, 255));
            contentPane.add(label9);
            label9.setBounds(215, 410, 125, 19);

            //---- BT_Registrar ----
            BT_Registrar.setText("Registrar");
            BT_Registrar.setForeground(new Color(51, 51, 255));
            BT_Registrar.setFont(new Font("Arial", Font.BOLD, 18));
            BT_Registrar.addActionListener(e -> BT_RegistrarActionPerformed(e));
            contentPane.add(BT_Registrar);
            BT_Registrar.setBounds(260, 465, 145, 30);
            contentPane.add(label1);
            label1.setBounds(600, 485, 50, 40);

            //---- TextField_DpiCliente ----
            TextField_DpiCliente.setEditable(false);
            TextField_DpiCliente.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_DpiCliente.setForeground(new Color(0, 0, 204));
            TextField_DpiCliente.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    TextField_DpiClienteMouseClicked(e);
                }
            });
            contentPane.add(TextField_DpiCliente);
            TextField_DpiCliente.setBounds(345, 300, 145, TextField_DpiCliente.getPreferredSize().height);

            //---- TextField_Origen ----
            TextField_Origen.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Origen.setForeground(new Color(0, 0, 204));
            contentPane.add(TextField_Origen);
            TextField_Origen.setBounds(345, 115, 145, TextField_Origen.getPreferredSize().height);

            //---- TextField_Destino ----
            TextField_Destino.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Destino.setForeground(new Color(0, 0, 204));
            contentPane.add(TextField_Destino);
            TextField_Destino.setBounds(345, 160, 145, TextField_Destino.getPreferredSize().height);

            //---- TextField_Fecha ----
            TextField_Fecha.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Fecha.setForeground(new Color(0, 0, 204));
            TextField_Fecha.setText("DD/MM/YYYY");
            contentPane.add(TextField_Fecha);
            TextField_Fecha.setBounds(345, 210, 145, TextField_Fecha.getPreferredSize().height);

            //---- TextField_Hora ----
            TextField_Hora.setForeground(new Color(0, 0, 204));
            TextField_Hora.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Hora.setText("HH:MM");
            contentPane.add(TextField_Hora);
            TextField_Hora.setBounds(345, 255, 145, TextField_Hora.getPreferredSize().height);

            //---- TextField_DpiConductor ----
            TextField_DpiConductor.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_DpiConductor.setForeground(new Color(0, 0, 204));
            TextField_DpiConductor.setEditable(false);
            TextField_DpiConductor.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    TextField_DpiConductorMouseClicked(e);
                }
            });
            contentPane.add(TextField_DpiConductor);
            TextField_DpiConductor.setBounds(345, 350, 145, TextField_DpiConductor.getPreferredSize().height);

            //---- TextField_Vehiculos ----
            TextField_Vehiculos.setFont(new Font("Arial", Font.BOLD, 16));
            TextField_Vehiculos.setForeground(new Color(0, 0, 204));
            TextField_Vehiculos.setEditable(false);
            TextField_Vehiculos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    TextField_VehiculosMouseClicked(e);
                }
            });
            contentPane.add(TextField_Vehiculos);
            TextField_Vehiculos.setBounds(345, 405, 145, TextField_Vehiculos.getPreferredSize().height);

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
        private JLabel label3;
        private JLabel label2;
        private JLabel label4;
        private JLabel label5;
        private JLabel label6;
        private JLabel label11;
        private JLabel label7;
        private JLabel label8;
        private JLabel label9;
        private JButton BT_Registrar;
        private JLabel label1;
        private JTextField TextField_DpiCliente;
        private JTextField TextField_Origen;
        private JTextField TextField_Destino;
        private JTextField TextField_Fecha;
        private JTextField TextField_Hora;
        private JTextField TextField_DpiConductor;
        private JTextField TextField_Vehiculos;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    }

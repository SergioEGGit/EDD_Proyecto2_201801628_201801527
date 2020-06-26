/*
 * Created by JFormDesigner on Wed Jun 24 18:56:06 CST 2020
 */

package Interfaz.Vehiculos;

import Interfaz.Reportes;
import Modelos.ModeloVehiculo;
import Variables.VariablesGlobales;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class VehiculosInterfaz extends JFrame {
    public VehiculosInterfaz() {
        initComponents();
    }

    private void AgregarVehiculo(ActionEvent e) {
        ModeloVehiculo Nuevo=new ModeloVehiculo(textField1.getText(),textField2.getText(),textField3.getText(),
                Integer.parseInt(textField4.getText()),textField5.getText(),Double.parseDouble(textField6.getText()),true);
        VariablesGlobales.ArbolBAutomoviles.AgregarVehiculo(Nuevo);
        VariablesGlobales.ArbolBAutomoviles.ImprimirArbol();
    }

    private void BuscarVehiculo(ActionEvent e) {
        ModeloVehiculo Vehiculo= VariablesGlobales.ArbolBAutomoviles.BuscarVehiculoNodo(textField1.getText());
        if(Vehiculo!=null){
            JOptionPane.showMessageDialog(null,Vehiculo.toString());
            Vehiculo.setMarca("CAMBIADO DESDE FORM");
        }
    }

    private void MostarEstructura(ActionEvent e) {
        VariablesGlobales.NombreReporte="ReporteArbolBVehiculos.png";
        VariablesGlobales.ArbolBAutomoviles.GenerarReporteArbolB();
        if(VariablesGlobales.GenereReporte){
            JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            new Reportes().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "El Reporte No Se Pudo Generar Con Exito \nVerifique Que Graphviz Se Encuentre Configurado De Manera Correcta", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        textField1 = new JTextField();
        label1 = new JLabel();
        textField2 = new JTextField();
        label2 = new JLabel();
        textField3 = new JTextField();
        label3 = new JLabel();
        textField4 = new JTextField();
        label4 = new JLabel();
        textField5 = new JTextField();
        label5 = new JLabel();
        textField6 = new JTextField();
        label6 = new JLabel();
        textField7 = new JTextField();
        label7 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(100, 30, 245, textField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Placa");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(45, 35), label1.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(100, 65, 245, 30);

        //---- label2 ----
        label2.setText("Marca");
        contentPane.add(label2);
        label2.setBounds(45, 70, 45, 16);
        contentPane.add(textField3);
        textField3.setBounds(100, 105, 245, 30);

        //---- label3 ----
        label3.setText("Modelo");
        contentPane.add(label3);
        label3.setBounds(45, 110, 50, 15);
        contentPane.add(textField4);
        textField4.setBounds(100, 145, 245, 30);

        //---- label4 ----
        label4.setText("A\u00f1o");
        contentPane.add(label4);
        label4.setBounds(45, 150, 28, 16);
        contentPane.add(textField5);
        textField5.setBounds(100, 185, 245, 30);

        //---- label5 ----
        label5.setText("Color");
        contentPane.add(label5);
        label5.setBounds(45, 190, 45, 16);
        contentPane.add(textField6);
        textField6.setBounds(100, 225, 245, 30);

        //---- label6 ----
        label6.setText("Precio");
        contentPane.add(label6);
        label6.setBounds(45, 230, 50, 16);
        contentPane.add(textField7);
        textField7.setBounds(100, 260, 245, 30);

        //---- label7 ----
        label7.setText("Transmicion");
        contentPane.add(label7);
        label7.setBounds(40, 265, 50, 16);

        //---- button1 ----
        button1.setText("Agregar");
        button1.addActionListener(e -> AgregarVehiculo(e));
        contentPane.add(button1);
        button1.setBounds(140, 315, 175, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("Buscar Vehiculo");
        button2.addActionListener(e -> BuscarVehiculo(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(145, 350), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("Estructura");
        button3.addActionListener(e -> MostarEstructura(e));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(150, 390), button3.getPreferredSize()));

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
    // Generated using JFormDesigner Evaluation license - unknown
    private JTextField textField1;
    private JLabel label1;
    private JTextField textField2;
    private JLabel label2;
    private JTextField textField3;
    private JLabel label3;
    private JTextField textField4;
    private JLabel label4;
    private JTextField textField5;
    private JLabel label5;
    private JTextField textField6;
    private JLabel label6;
    private JTextField textField7;
    private JLabel label7;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

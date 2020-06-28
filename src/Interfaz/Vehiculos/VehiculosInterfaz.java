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

    /*private void AgregarVehiculo(ActionEvent e) {
        ModeloVehiculo Nuevo=new ModeloVehiculo(textField1.getText(),textField2.getText(),textField3.getText(),
                Integer.parseInt(textField4.getText()),textField5.getText(),Double.parseDouble(textField6.getText()),true);
        VariablesGlobales.ArbolBAutomoviles.AgregarVehiculo(Nuevo);
        VariablesGlobales.ArbolBAutomoviles.ImprimirArbol();
    }*/

    /*private void BuscarVehiculo(ActionEvent e) {
        ModeloVehiculo Vehiculo= VariablesGlobales.ArbolBAutomoviles.BuscarVehiculoNodo(textField1.getText());
        if(Vehiculo!=null){
            JOptionPane.showMessageDialog(null,Vehiculo.toString());
            Vehiculo.setMarca("CAMBIADO DESDE FORM");
        }
    }*/

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

    /*private void Eliminar(ActionEvent e) {
        VariablesGlobales.ArbolBAutomoviles.EliminarVehiculo(textField1.getText());
    }*/

    private void RBT_AgregarActionPerformed(ActionEvent e) {
        // TODO add your code here
        new AgregarVehiculo().setVisible(true);
    }

    private void RBT_ModificarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void RBT_EliminarActionPerformed(ActionEvent e) {
        // TODO add your code here
        new EliminarVehiculo().setVisible(true);
    }

    private void RBT_BuscarActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void RBT_MostrarActionPerformed(ActionEvent e) {
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
        label1 = new JLabel();
        label2 = new JLabel();
        RBT_Agregar = new JRadioButton();
        RBT_Modificar = new JRadioButton();
        RBT_Eliminar = new JRadioButton();
        RBT_Buscar = new JRadioButton();
        RBT_Mostrar = new JRadioButton();
        label3 = new JLabel();

        //======== this ========
        setTitle("Vehiculos");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Men\u00fa Vehiculos");
        label1.setFont(new Font("Arial", Font.BOLD, 22));
        label1.setForeground(new Color(153, 153, 255));
        contentPane.add(label1);
        label1.setBounds(265, 75, 185, 26);

        //---- label2 ----
        label2.setText("Seleccione Una Opci\u00f3n:");
        label2.setForeground(new Color(0, 102, 255));
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        contentPane.add(label2);
        label2.setBounds(235, 125, 226, 24);

        //---- RBT_Agregar ----
        RBT_Agregar.setText("Agregar Vehiculo");
        RBT_Agregar.setForeground(new Color(102, 102, 255));
        RBT_Agregar.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_Agregar.addActionListener(e -> RBT_AgregarActionPerformed(e));
        contentPane.add(RBT_Agregar);
        RBT_Agregar.setBounds(255, 175, 179, 28);

        //---- RBT_Modificar ----
        RBT_Modificar.setText("Modificar Vehiculo");
        RBT_Modificar.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_Modificar.setForeground(new Color(102, 102, 255));
        RBT_Modificar.addActionListener(e -> RBT_ModificarActionPerformed(e));
        contentPane.add(RBT_Modificar);
        RBT_Modificar.setBounds(255, 220, 188, 28);

        //---- RBT_Eliminar ----
        RBT_Eliminar.setText("Eliminar Vehiculo");
        RBT_Eliminar.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_Eliminar.setForeground(new Color(102, 102, 255));
        RBT_Eliminar.addActionListener(e -> RBT_EliminarActionPerformed(e));
        contentPane.add(RBT_Eliminar);
        RBT_Eliminar.setBounds(255, 260, 180, 28);

        //---- RBT_Buscar ----
        RBT_Buscar.setText("Buscar Vehiculo");
        RBT_Buscar.setForeground(new Color(102, 102, 255));
        RBT_Buscar.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_Buscar.addActionListener(e -> RBT_BuscarActionPerformed(e));
        contentPane.add(RBT_Buscar);
        RBT_Buscar.setBounds(255, 300, 173, 28);

        //---- RBT_Mostrar ----
        RBT_Mostrar.setText("Mostrar Estructura");
        RBT_Mostrar.setForeground(new Color(102, 102, 255));
        RBT_Mostrar.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_Mostrar.addActionListener(e -> RBT_MostrarActionPerformed(e));
        contentPane.add(RBT_Mostrar);
        RBT_Mostrar.setBounds(255, 340, 174, 28);
        contentPane.add(label3);
        label3.setBounds(655, 470, 35, 30);

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
    private JLabel label1;
    private JLabel label2;
    private JRadioButton RBT_Agregar;
    private JRadioButton RBT_Modificar;
    private JRadioButton RBT_Eliminar;
    private JRadioButton RBT_Buscar;
    private JRadioButton RBT_Mostrar;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

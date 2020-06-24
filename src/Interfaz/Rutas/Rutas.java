/*
 * Created by JFormDesigner on Tue Jun 23 16:33:06 CST 2020
 */

package Interfaz.Rutas;

import java.awt.event.*;
import Interfaz.Reportes;
import Metodos.CargaMasiva;
import Variables.VariablesGlobales;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Rutas extends JFrame {
    public Rutas() {
        initComponents();
        ButtonGroup MenuConductor = new ButtonGroup();
        MenuConductor.add(RBT_CargaMasiva);
        MenuConductor.add(RBT_Grafo);
        RBT_CargaMasiva.setSelected(true);
    }

    private void RBT_CargaMasivaActionPerformed(ActionEvent e) { ValidarRadioButton(); }

    private void RBT_GrafoActionPerformed(ActionEvent e) { ValidarRadioButton(); }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        RBT_CargaMasiva = new JRadioButton();
        RBT_Grafo = new JRadioButton();

        //======== this ========
        setTitle("Rutas");
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Rutas de Llega Rapidito");
        label1.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setForeground(new Color(153, 153, 255));
        contentPane.add(label1);
        label1.setBounds(75, 35, 240, 20);

        //---- RBT_CargaMasiva ----
        RBT_CargaMasiva.setText("Cargar Rutas");
        RBT_CargaMasiva.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_CargaMasiva.setForeground(new Color(102, 102, 255));
        RBT_CargaMasiva.addActionListener(e -> RBT_CargaMasivaActionPerformed(e));
        contentPane.add(RBT_CargaMasiva);
        RBT_CargaMasiva.setBounds(new Rectangle(new Point(120, 90), RBT_CargaMasiva.getPreferredSize()));

        //---- RBT_Grafo ----
        RBT_Grafo.setText("Grafo de Rutas");
        RBT_Grafo.setFont(new Font("Arial", Font.BOLD, 16));
        RBT_Grafo.setForeground(new Color(102, 102, 255));
        RBT_Grafo.addActionListener(e -> RBT_GrafoActionPerformed(e));
        contentPane.add(RBT_Grafo);
        RBT_Grafo.setBounds(new Rectangle(new Point(120, 130), RBT_Grafo.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(375, 250));
        setSize(375, 250);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public void CargaMasivaRutas(){
        CargaMasiva CMR=new CargaMasiva();
        CMR.CargaMasiva('%','/',"txt","RUTAS",3);
        int contador=0;
        for (String[] Ruta: VariablesGlobales.ItemsArchivo){
            try{
                boolean Existe =VariablesGlobales.ListaAdyacenciaRutas.InsertarNodo(Ruta[0].trim().toUpperCase(),Ruta[1].trim().toUpperCase(),Double.parseDouble(Ruta[2].trim()));
                if(Existe==false){
                    JOptionPane.showMessageDialog(null,
                            "Texto: "+Ruta[0]+"\n"+
                                    "Texto: "+Ruta[1]+"\n"+
                                    "Tiempo: "+Ruta[2],
                            "LA RUTA YA EXISTE",
                            JOptionPane.ERROR_MESSAGE);
                }else{contador++;}
            }
            catch(Exception E){
                JOptionPane.showMessageDialog(null,
                        "Texto: "+Ruta[0]+"\n"+
                                "Texto: "+Ruta[1]+"\n"+
                                "Tiempo: "+Ruta[2],
                        "ERROR AL INSERTAR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null,"SE AGREGARON "+contador+" CON EXITO","AGREGADOS",JOptionPane.INFORMATION_MESSAGE);
        VariablesGlobales.ListaAdyacenciaRutas.ImprimirLista();
        VariablesGlobales.ListaAdyacenciaRutas.AlgoritmoDijkstra();
    }

    void GenerarReporte(){
        VariablesGlobales.NombreReporte="ReporteGrafoRutas.png";
        VariablesGlobales.ListaAdyacenciaRutas.GenerarGrafoRutas();
        if(VariablesGlobales.GenereReporte){
            JOptionPane.showMessageDialog(null, "Reporte Generado Con Exito", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            new Reportes().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "El Reporte No Se Pudo Generar Con Exito \nVerifique Que Graphviz Se Encuentre Configurado De Manera Correcta", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ValidarRadioButton(){
        if(RBT_CargaMasiva.isSelected()){
            CargaMasivaRutas();
        }else if(RBT_Grafo.isSelected()){
            GenerarReporte();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JRadioButton RBT_CargaMasiva;
    private JRadioButton RBT_Grafo;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

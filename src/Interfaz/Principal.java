/*
 * Created by JFormDesigner on Fri Jun 19 15:17:58 CDT 2020
 */

package Interfaz;

import java.awt.event.*;
import Interfaz.Conductores.ConductoresInterfaz;

import java.awt.*;
import javax.swing.*;

import Estructuras.ListaAdyacencia;
import Metodos.CargaMasiva;
import Variables.VariablesGlobales;

/**
 * @author Sergio Echigoyen
 */
public class Principal extends JFrame {
    public Principal() {
        initComponents();
    }

    private void CargaMasivaRutas(ActionEvent e)
    {
        CargaMasiva CMR=new CargaMasiva();
        CMR.CargaMasiva('%','/',"txt","RUTAS",3);
        int contador=0;
        for (String[] Ruta: VariablesGlobales.ItemsArchivo){
            try{
                boolean Existe =VariablesGlobales.ListaAdyacenciaRutas.InsertarNodo(Ruta[0].trim(),Ruta[1].trim(),Double.parseDouble(Ruta[2].trim()));
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
    }

    private void GrafoRuta(ActionEvent e) {
        VariablesGlobales.ListaAdyacenciaRutas.GenerarGrafoRutas();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("CARGA MASIVA");

                //---- menuItem1 ----
                menuItem1.setText("RUTAS");
                menuItem1.addActionListener(e -> CargaMasivaRutas(e));
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- button1 ----
        button1.setText("GRAFO RUTAS");
        button1.addActionListener(e -> GrafoRuta(e));
        contentPane.add(button1);
        button1.setBounds(75, 65, 325, 140);

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
    
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ConductoresInterfaz().setVisible(true);
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

/*
 * Created by JFormDesigner on Sun Jun 28 15:33:10 CST 2020
 */

package Interfaz.Huffman;

import Variables.VariablesGlobales;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Comprecion_Descomprecion extends JFrame {
    public Comprecion_Descomprecion() {
        initComponents();
    }

    private void ComprimirTexto(ActionEvent e) {
        VariablesGlobales.huffman.Compresion(textArea1.getText(),"NADA");
    }

    private void Descomprimir(ActionEvent e) {
        VariablesGlobales.huffman.Descomprimir("NADA",textArea1.getText());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 25, 560, 270);

        //---- button1 ----
        button1.setText("Comprimir");
        button1.addActionListener(e -> ComprimirTexto(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(485, 310), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("Descomprimir");
        button2.addActionListener(e -> Descomprimir(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(320, 315), button2.getPreferredSize()));

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
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

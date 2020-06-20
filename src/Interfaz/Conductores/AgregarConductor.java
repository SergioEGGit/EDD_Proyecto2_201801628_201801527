/*
 * Created by JFormDesigner on Fri Jun 19 18:18:35 CDT 2020
 */

package Interfaz.Conductores;

import java.awt.*;
import javax.swing.*;

/**
 * @author Sergio Echigoyen
 */
public class AgregarConductor extends JFrame {
    public AgregarConductor() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sergio Echigoyen
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(label1);
        label1.setBounds(620, 425, 50, 40);

        //---- label2 ----
        label2.setText("text");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(325, 20), label2.getPreferredSize()));

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
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

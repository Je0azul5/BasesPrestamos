/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Busqueda;
import vista.General;

/**
 *
 * @author je0azul5
 */
public class ControladorBusqueda implements ActionListener{
    private Busqueda b;

    public ControladorBusqueda(Busqueda b) {
        this.b = b;
        b.jButton1.addActionListener(this);
        b.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
           ControladorGeneral g = new ControladorGeneral(new General());
         //   JOptionPane.showMessageDialog(null, "");
            b.dispose();
        }
    
    }
    
    
}

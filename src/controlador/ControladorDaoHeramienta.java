/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.CrearHerramienta;
import vista.General;

/**
 *
 * @author je0azul5
 */
public class ControladorDaoHeramienta implements ActionListener{
    private CrearHerramienta h;

    public ControladorDaoHeramienta(CrearHerramienta h) {
        this.h = h;
        h.jButton1.addActionListener(this);
        h.jButton2.addActionListener(this);
        h.jButton3.addActionListener(this);
        h.jButton4.addActionListener(this);
        h.jButton5.addActionListener(this);
        h.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
           ControladorGeneral g = new ControladorGeneral(new General());
           h.dispose();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.CrearEstudiante;
import vista.General;

/**
 *
 * @author je0azul5
 */
public class ControladorDaoEstudiante implements ActionListener {

    private CrearEstudiante ce;

    public ControladorDaoEstudiante(CrearEstudiante ce) {
        this.ce = ce;
        ce.jButton1.addActionListener(this);
        ce.jButton2.addActionListener(this);
        ce.jButton3.addActionListener(this);
        ce.jButton4.addActionListener(this);
        ce.jButton5.addActionListener(this);
        ce.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
            ControladorGeneral g = new ControladorGeneral(new General());
            ce.dispose();
        }

    }

}

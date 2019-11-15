/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.CrearEstudiante;
import vista.Estudiantes;
import vista.General;

/**
 *
 * @author je0azul5
 */
public class ControladorEstudiante implements ActionListener {

    private Estudiantes estudiante;

    public ControladorEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
        estudiante.jButton1.addActionListener(this);
        estudiante.jButton2.addActionListener(this);
        estudiante.jButton3.addActionListener(this);
        estudiante.jButton4.addActionListener(this);
        estudiante.jButton5.addActionListener(this);
        estudiante.jButton6.addActionListener(this);
        estudiante.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equalsIgnoreCase("crear")) {
            ControladorDaoEstudiante ce = new ControladorDaoEstudiante(new CrearEstudiante());
           // JOptionPane.showMessageDialog(null, "Se creo");
            estudiante.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("multar")) {
        //    JOptionPane.showMessageDialog(null, "Se multo");
            estudiante.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("desmultar")) {
         //   JOptionPane.showMessageDialog(null, "se desmulto");
            estudiante.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("buscar")) {
          

            ControladorDaoEstudiante ce = new ControladorDaoEstudiante(new CrearEstudiante());
        //    JOptionPane.showMessageDialog(null, " Buscado");
            estudiante.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("eliminar")) {
            
            ControladorDaoEstudiante ce = new ControladorDaoEstudiante(new CrearEstudiante());
          //  JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            estudiante.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
            ControladorGeneral g = new ControladorGeneral(new General());
            
            estudiante.dispose();
        }
    }

}

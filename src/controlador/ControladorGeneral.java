/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Busqueda;
import vista.Estudiantes;
import vista.General;
import vista.GeneralMultas;
import vista.Herramientas;
import vista.Inicio;

/**
 *
 * @author je0azul5
 */
public class ControladorGeneral implements ActionListener, Serializable {

    private General g;

    public ControladorGeneral(General g) {
        this.g = g;
        g.setVisible(true);
        g.jButton1.addActionListener(this);
        g.jButton2.addActionListener(this);
        g.jButton3.addActionListener(this);
        g.jButton4.addActionListener(this);
        g.jButton5.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("estudiante")) {
            ControladorEstudiante c = new ControladorEstudiante(new Estudiantes());
            g.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("salir")) {
            ControladorPrincipal in = new ControladorPrincipal(new Inicio());
            g.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("herramienta")) {
            ControladorHerramienta rr = new ControladorHerramienta(new Herramientas());
            g.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("busqueda")) {
            try {
                ControladorBusqueda r = new ControladorBusqueda(new Busqueda());
            } catch (SQLException ex) {
                System.out.println("Holi");
            }

            g.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("Multas")) {
            ControladorMulta x = new ControladorMulta(new GeneralMultas());
            g.dispose();
        }

    }

}

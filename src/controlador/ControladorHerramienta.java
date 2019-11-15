/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.CrearHerramienta;
import vista.Herramientas;

/**
 *
 * @author je0azul5
 */
public class ControladorHerramienta implements ActionListener {

    private Herramientas g;

    public ControladorHerramienta(Herramientas g) {
        this.g = g;
        g.jButton1.addActionListener(this);
        g.jButton2.addActionListener(this);
        g.jButton3.addActionListener(this);
        g.jButton4.addActionListener(this);
        g.jButton5.addActionListener(this);
        g.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
          //  ControladorDaoHeramienta o = new ControladorDaoHeramienta(new CrearHerramienta());
            g.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("crear")) {

            ControladorDaoHeramienta o = new ControladorDaoHeramienta(new CrearHerramienta());
           // JOptionPane.showMessageDialog(null, "Se creo");
            g.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("actualizar")) {

            ControladorDaoHeramienta o = new ControladorDaoHeramienta(new CrearHerramienta());
           // JOptionPane.showMessageDialog(null, "Actualizado correctamente");
            g.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("buscar")) {

            ControladorDaoHeramienta o = new ControladorDaoHeramienta(new CrearHerramienta());
            g.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("borrar")) {

            ControladorDaoHeramienta o = new ControladorDaoHeramienta(new CrearHerramienta());
         //   JOptionPane.showMessageDialog(null, "se borro correctamente");
            g.dispose();
        }
    }

}

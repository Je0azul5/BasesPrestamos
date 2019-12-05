/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Dao.DaoTabla;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JOptionPane;
import vista.*;

/**
 *
 * @author je0azul5
 */
public class ControladorBusqueda implements ActionListener, Serializable {

    private Busqueda b;

    //  DaoTabla dd= new DaoTabla();
    public ControladorBusqueda(Busqueda b) {
        this.b = b;
        b.jButton1.addActionListener(this);
        b.jButton2.addActionListener(this);
        b.jButton3.addActionListener(this);
        b.jButton4.addActionListener(this);
        b.jButton5.addActionListener(this);

        b.setVisible(true);
        //   dd.mostrar(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
            ControladorGeneral g = new ControladorGeneral(new General());
            //   JOptionPane.showMessageDialog(null, "");
            b.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("Cantidad Multas")) {
            ControladorMultasCantidad g = new ControladorMultasCantidad(new CantidadMultas());
            b.dispose();

        }
        if (e.getActionCommand().equalsIgnoreCase("Busqueda Pro")) {
            ControladorPro x = new ControladorPro(new Pro());
            b.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("Valor de Multas")) {
            ControladorValorMulta x = new ControladorValorMulta(new ValorMultas());
            b.dispose();
        }
        if (e.getActionCommand().equalsIgnoreCase("Estudiante Frecuente")) {
            ControladorClienteFrecuente k = new ControladorClienteFrecuente(new EstudianteFrecuente());
            b.dispose();
        }

    }

}

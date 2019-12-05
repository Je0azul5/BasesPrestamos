/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Busqueda;
import vista.EstudianteFrecuente;

/**
 *
 * @author je0azul5
 */
public class ControladorClienteFrecuente implements ActionListener {

    private EstudianteFrecuente x;

    public ControladorClienteFrecuente(EstudianteFrecuente x) {
        x.jButton1.addActionListener(this);
        x.setVisible(true);
        this.x = x;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("volver")) {
            try {
                ControladorBusqueda d = new ControladorBusqueda(new Busqueda());
                x.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorClienteFrecuente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}

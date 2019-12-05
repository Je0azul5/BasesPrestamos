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
import vista.General;
import vista.ValorMultas;

/**
 *
 * @author je0azul5
 */
public class ControladorValorMulta implements ActionListener {

    private ValorMultas x;

    public ControladorValorMulta(ValorMultas x) {
        x.jButton1.addActionListener(this);
        this.x = x;
        x.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Volver")) {
            try {
                ControladorBusqueda f = new ControladorBusqueda(new Busqueda());
                x.dispose();

            } catch (SQLException ex) {
                Logger.getLogger(ControladorValorMulta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}

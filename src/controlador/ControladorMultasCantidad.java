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
import vista.CantidadMultas;

/**
 *
 * @author je0azul5
 */
public class ControladorMultasCantidad implements ActionListener{
    private CantidadMultas x ;

    public ControladorMultasCantidad(CantidadMultas x) {
        x.jButton1.addActionListener(this);
        x.setVisible(true);
        this.x = x;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Volver")) {
            try {
                ControladorBusqueda c = new ControladorBusqueda(new Busqueda());
            } catch (SQLException ex) {
                Logger.getLogger(ControladorMultasCantidad.class.getName()).log(Level.SEVERE, null, ex);
            }
            x.dispose();
        }
    }
    
    
    
}

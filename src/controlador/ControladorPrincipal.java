/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.*;
/**
 *
 * @author je0azul5
 */
public class ControladorPrincipal implements ActionListener{
    
    private Inicio in;

    public ControladorPrincipal(Inicio in) {
        this.in = in;
        in.jButton1.addActionListener(this);
        in.setVisible(true);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equalsIgnoreCase("entrar")) {
            ControladorGeneral g = new ControladorGeneral(new General());
            
            in.dispose();
        }
    
    }
    
}

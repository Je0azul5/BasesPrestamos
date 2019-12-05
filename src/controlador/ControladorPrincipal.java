/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import vista.*;
import Dao.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.Administrador;
/**
 *
 * @author je0azul5
 */
public class ControladorPrincipal implements ActionListener, Serializable{
    
    private Inicio in;

    public ControladorPrincipal(Inicio in) {
        this.in = in;
        in.jButton1.addActionListener(this);
        in.setVisible(true);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
            
        DaoIn d = new DaoIn();
        
        if (e.getActionCommand().equalsIgnoreCase("entrar")) {
            Administrador f = null;
            try {
                f = d.buscar(in.jTextField1.getText(), in.jPasswordField1.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (f!=null) {
                
            ControladorGeneral g = new ControladorGeneral(new General());
                try {
                    d.Saludo();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            in.dispose();
            }else{
                in.jTextField1.setText("");
                in.jPasswordField1.setText("");
            }
        }
    
    }
    
}

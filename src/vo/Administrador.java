/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author je0azul5
 */
public class Administrador {
   
    private String id;
    private String pss;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPss() {
        return pss;
    }

    public void setPss(String pss) {
        this.pss = pss;
    }

    public Administrador(String id, String pss) {
        this.id = id;
        this.pss = pss;
    }
    
           
}

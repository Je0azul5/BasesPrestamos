
package vo;

import java.io.Serializable;

/**
 *
 * @author je0azul5
 */
public class Multa implements Serializable{
    
    private int id; 
    private double valor;
    private boolean blpagada;
    private int estudiante;

    public Multa(int id, double valor, boolean blpagada, int estudiante) {
        this.id = id;
        this.valor = valor;
        this.blpagada = blpagada;
        this.estudiante = estudiante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isBlpagada() {
        return blpagada;
    }

    public void setBlpagada(boolean blpagada) {
        this.blpagada = blpagada;
    }

    public int getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(int estudiante) {
        this.estudiante = estudiante;
    }

        
}


package vo;

/**
 *
 * @author je0azul5
 */
public class Multa {
    
    private int id;
    private String fehca;
    private double valor;
    private boolean blpagada;
    private int estudiante;

    public Multa(int id, String fehca, double valor, boolean blpagada, int estudiante) {
        this.id = id;
        this.fehca = fehca;
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

    public String getFehca() {
        return fehca;
    }

    public void setFehca(String fehca) {
        this.fehca = fehca;
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

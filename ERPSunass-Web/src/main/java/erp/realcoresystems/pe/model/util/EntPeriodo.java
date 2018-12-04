package erp.realcoresystems.pe.model.util;

public class EntPeriodo  implements java.io.Serializable {
    private int id;
    private String periodo;
    private String periodoDescripcion;
    private String tipo;
    private int dia;
    private int mes;
    private int anno;

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPeriodoDescripcion() {
        return periodoDescripcion;
    }

    public void setPeriodoDescripcion(String periodoDescripcion) {
        this.periodoDescripcion = periodoDescripcion;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
}

public class CentroSalud {

    private String codCentro;
    private int tipo;

    public CentroSalud(String codCentro, int tipo) {
        this.codCentro = codCentro;
        this.tipo = tipo;
    }

    public String getCodCentro() {
        return codCentro;
    }
    public void setCodCentro(String codCentro) {
        this.codCentro = codCentro;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}

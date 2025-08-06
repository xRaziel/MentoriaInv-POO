public class Hospitalizacion {

    private String fechaIngreso;
    private String fechaAlta;
    private CentroSalud centroSalud;

    public Hospitalizacion(String fechaIngreso, String fechaAlta, CentroSalud centroSalud) {
        this.fechaIngreso = fechaIngreso;
        this.fechaAlta = fechaAlta;
        this.centroSalud = centroSalud;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public CentroSalud getCentroSalud() {
        return centroSalud;
    }

    public void setCentroSalud(CentroSalud centroSalud) {
        this.centroSalud = centroSalud;
    }
}

public abstract class Trabajador {

    protected String nombre;
    protected String rut;

    public Trabajador(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public abstract int calcularBono();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}

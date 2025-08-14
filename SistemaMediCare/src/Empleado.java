public abstract class Empleado {
    protected String nombre;
    protected String rut;
    protected Double sueldoBase;

    public Empleado(String nombre, String rut, Double sueldoBase) {
        this.nombre = nombre;
        this.rut = rut;
        this.sueldoBase = sueldoBase;
    }

    public abstract void accept(Visitor visitor);

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

    public Double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(Double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
}

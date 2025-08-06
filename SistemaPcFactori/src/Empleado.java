public abstract class Empleado {
    private String rut;
    private String nombre;
    private double sueldo;

    public Empleado(String rut, String nombre, double sueldo) {
        this.rut = rut;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public abstract double calcularSueldo();
    public abstract String getTipoEmpleado();

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}

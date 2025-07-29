import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {

    private Usuario usuario;
    private MaterialBibliografico material;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;

    public Prestamo(Usuario usuario, MaterialBibliografico material) {
        this.usuario = usuario;
        this.material = material;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(material.getDiasMaximoPrestamo());
        this.devuelto = false;
    }

    public int calcularDiasRetraso(){
        if(devuelto) return 0;

        LocalDate hoy = LocalDate.now();
        if(hoy.isAfter(fechaDevolucion)){
            return (int) ChronoUnit.DAYS.between(fechaDevolucion, hoy);
        }
        return 0;
    }

    public double calcularMulta(){
        int diasRetraso = calcularDiasRetraso();
        if(diasRetraso > 0){
            return material.calcularMultaPorRetraso(diasRetraso);
        }
        return 0.0; // No hay multa si no hay retraso
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MaterialBibliografico getMaterial() {
        return material;
    }

    public void setMaterial(MaterialBibliografico material) {
        this.material = material;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
}

public class Guia extends Trabajador {

    private int categoria;

    public Guia(String nombre, String rut, int categoria) {
        super(nombre, rut);
        this.categoria = categoria;
    }

    @Override
    public int calcularBono() {
        return categoria * 25000;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}

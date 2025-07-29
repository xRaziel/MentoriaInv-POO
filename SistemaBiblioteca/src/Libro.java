public class Libro extends MaterialBibliografico{

    public Libro(String codigo, String titulo, String autor, int añoPublicacion, boolean disponible) {
        super(codigo, titulo, autor, añoPublicacion, disponible);
    }

    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        return diasRetraso * 500.0; // Multa de 500 por día de retraso
    }

    @Override
    public int getDiasMaximoPrestamo() {
        return 14; // Días máximos de préstamo para un libro
    }
}

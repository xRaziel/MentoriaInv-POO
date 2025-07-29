public class Revista extends MaterialBibliografico{

    public Revista(String codigo, String titulo, String autor, int añoPublicacion, boolean disponible) {
        super(codigo, titulo, autor, añoPublicacion, disponible);
    }

    @Override
    public double calcularMultaPorRetraso(int diasRetraso) {
        return diasRetraso * 300.0; // Multa de 300 por día de retraso
    }

    @Override
    public int getDiasMaximoPrestamo() {
        return 7; // Días máximos de préstamo para un libro
    }
}

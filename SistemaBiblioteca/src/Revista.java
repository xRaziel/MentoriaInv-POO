public class Revista extends MaterialBibliografico{

    public Revista(String codigo, String titulo, String autor, int añoPublicacion ) {
        super(codigo, titulo, autor, añoPublicacion);
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

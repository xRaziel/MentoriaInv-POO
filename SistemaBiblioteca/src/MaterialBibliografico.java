public abstract class MaterialBibliografico {

    protected String codigo;
    protected String titulo;
    protected String autor;
    protected int añoPublicacion;
    protected boolean disponible;

    public MaterialBibliografico(String codigo, String titulo, String autor, int añoPublicacion, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.disponible = disponible;
    }

    public abstract double calcularMultaPorRetraso(int diasRetraso);
    public abstract int getDiasMaximoPrestamo();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

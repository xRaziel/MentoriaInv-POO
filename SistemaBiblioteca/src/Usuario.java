import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

    protected String id;
    protected String nombre;
    protected String email;
    protected List<MaterialBibliografico> materialesPrestados;

    public Usuario(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.materialesPrestados = new ArrayList<>();
    }

    public abstract int getMaximoMaterialesPermitidos();
    public abstract String getTipoUsuario();

    public boolean agregarPrestamo(MaterialBibliografico material) {
        if (materialesPrestados.size() < getMaximoMaterialesPermitidos()) {
            return materialesPrestados.add(material);
        }
        return false;
    }

    public boolean removerPrestamo(MaterialBibliografico material) {
        return materialesPrestados.remove(material);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MaterialBibliografico> getMaterialesPrestados() {
        return materialesPrestados;
    }

    public void setMaterialesPrestados(List<MaterialBibliografico> materialesPrestados) {
        this.materialesPrestados = materialesPrestados;
    }
}

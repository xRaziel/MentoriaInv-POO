import java.util.ArrayList;
import java.util.List;

public class Comuna {

    private String nombreComuna;
    private List<CentroSalud> centrosSalud;

    public Comuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
        this.centrosSalud = new ArrayList<>();
    }

    public String getNombreComuna() {
        return nombreComuna;
    }

    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    public List<CentroSalud> getCentrosSalud() {
        return centrosSalud;
    }

    public void agregarCentroSalud(CentroSalud centroSalud) {
        this.centrosSalud.add(centroSalud);
    }
}

import java.util.ArrayList;
import java.util.List;

public class IntervencionesVisitor implements RestauranteVisitor {
    private List<Restaurante> restaurantes = new ArrayList<>();
    private CalcularIntervencion calcularIntervencion = new CalcularIntervencion();


    @Override
    public void visit(Pizzeria pizzeria) {
        calcularIntervencion.setIntervencionStrategy(new IntervencionPizzeria());
        if (calcularIntervencion.ejecutarIntervencion(pizzeria)) {
            restaurantes.add(pizzeria);
        }
    }

    @Override
    public void visit(SushiBar sushiBar) {
        calcularIntervencion.setIntervencionStrategy(new IntervencionSushi());
        if (calcularIntervencion.ejecutarIntervencion(sushiBar)) {
            restaurantes.add(sushiBar);
        }
    }

    @Override
    public void visit(AsadorCarnes asador) {
        calcularIntervencion.setIntervencionStrategy(new IntervencionAsador());
        if (calcularIntervencion.ejecutarIntervencion(asador)) {
            restaurantes.add(asador);
        }
    }

    @Override
    public void visit(CafeteriaGourmet cafeteria) {
        calcularIntervencion.setIntervencionStrategy(new IntervencionCafeteria());
        if (calcularIntervencion.ejecutarIntervencion(cafeteria)) {
            restaurantes.add(cafeteria);
        }
    }

    public void imprimirResultados() {
        System.out.println("Restaurantes que necesitan intervención:");
        for (Restaurante restaurante : restaurantes) {
            System.out.println("Restaurante " + restaurante.getCodigo() + " necesita intervención.");
        }
    }
}

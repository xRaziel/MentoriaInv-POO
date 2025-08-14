import java.util.HashMap;
import java.util.Map;

public class BonificacionesVisitor implements RestauranteVisitor{
    private Map<String, Double> bonificacionesPorRestaurante = new HashMap<>();
    private CalcularBonificaciones calculador = new CalcularBonificaciones();

    @Override
    public void visit(Pizzeria pizzeria) {
        calculador.setBonificacionesStrategy(new BonificacionPizzeria());
        double bonificacion = calculador.ejecutarCalculo(pizzeria);
        bonificacionesPorRestaurante.put(pizzeria.getCodigo(), bonificacion);
    }

    @Override
    public void visit(SushiBar sushiBar) {
        calculador.setBonificacionesStrategy(new BonificacionSushi());
        double bonificacion = calculador.ejecutarCalculo(sushiBar);
        bonificacionesPorRestaurante.put(sushiBar.getCodigo(), bonificacion);
    }

    @Override
    public void visit(AsadorCarnes asador) {
        calculador.setBonificacionesStrategy(new BonificacionAsador());
        double bonificacion = calculador.ejecutarCalculo(asador);
        bonificacionesPorRestaurante.put(asador.getCodigo(), bonificacion);
    }

    @Override
    public void visit(CafeteriaGourmet cafeteria) {
        calculador.setBonificacionesStrategy(new BonificacionCafeteria());
        double bonificacion = calculador.ejecutarCalculo(cafeteria);
        bonificacionesPorRestaurante.put(cafeteria.getCodigo(), bonificacion);
    }

    public void imprimirResultados() {
        System.out.println("Bonificaciones por restaurante:");
        for (String codigo : bonificacionesPorRestaurante.keySet()) {
            double bonificacion = bonificacionesPorRestaurante.get(codigo);
            System.out.println("Restaurante " + codigo + ": Bonificación de $" + bonificacion);
        }
    }

}

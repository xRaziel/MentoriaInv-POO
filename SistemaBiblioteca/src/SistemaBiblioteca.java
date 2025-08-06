import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {
    private List<MaterialBibliografico> materiales;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;
    private List<Prestamo> historialPrestamos;

    public SistemaBiblioteca() {
        this.materiales = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.historialPrestamos = new ArrayList<>();
    }

    public boolean agregarMaterial(MaterialBibliografico material) {
        // Verificar si ya existe un material con el mismo código
        for (MaterialBibliografico m : materiales) {
            if (m.getCodigo().equals(material.getCodigo())) {
                return false;
            }
        }
        materiales.add(material);
        return true;
    }

    public boolean registrarUsuario(Usuario usuario) {
        // Verificar si ya existe un usuario con el mismo ID
        for (Usuario u : usuarios) {
            if (u.getId().equals(usuario.getId())) {
                return false;
            }
        }
        usuarios.add(usuario);
        return true;
    }

    private Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    private MaterialBibliografico buscarMaterialPorCodigo(String codigo) {
        for (MaterialBibliografico material : materiales) {
            if (material.getCodigo().equals(codigo)) {
                return material;
            }
        }
        return null;
    }

    public String realizarPrestamo(String idUsuario, String codigoMaterial) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        MaterialBibliografico material = buscarMaterialPorCodigo(codigoMaterial);

        // Validaciones
        if (usuario == null) {
            return "Error: Usuario no encontrado";
        }
        if (material == null) {
            return "Error: Material no encontrado";
        }
        if (!material.isDisponible()) {
            return "Error: Material no disponible";
        }
        if (!usuario.agregarPrestamo(material)) {
            return "Error: Usuario ha alcanzado el límite de préstamos";
        }

        // Realizar préstamo
        material.setDisponible(false);
        Prestamo prestamo = new Prestamo(usuario, material);
        prestamos.add(prestamo);
        historialPrestamos.add(prestamo);

        return String.format("Préstamo realizado exitosamente. Fecha de devolución: %s",
                prestamo.getFechaDevolucion());
    }

    public String procesarDevolucion(String idUsuario, String codigoMaterial) {
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        MaterialBibliografico material = buscarMaterialPorCodigo(codigoMaterial);

        if (usuario == null || material == null) {
            return "Error: Usuario o material no encontrado";
        }

        // Buscar préstamo activo
        Prestamo prestamoActivo = null;
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto() &&
                    p.getUsuario().equals(usuario) &&
                    p.getMaterial().equals(material)) {
                prestamoActivo = p;
                break;
            }
        }

        if (prestamoActivo == null) {
            return "Error: No se encontró préstamo activo para este usuario y material";
        }

        // Procesar devolución
        prestamoActivo.setDevuelto(true);
        material.setDisponible(true);
        usuario.removerPrestamo(material);
        prestamos.remove(prestamoActivo);

        double multa = prestamoActivo.calcularMulta();
        String mensaje = "Devolución procesada exitosamente";
        if (multa > 0) {
            mensaje += String.format(". Multa por retraso: $%.2f", multa);
        }

        return mensaje;
    }

    public List<MaterialBibliografico> buscarMaterialesPorAutor(String autor) {
        List<MaterialBibliografico> resultado = new ArrayList<>();
        for (MaterialBibliografico material : materiales) {
            if (material.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultado.add(material);
            }
        }
        return resultado;
    }

    public List<Usuario> obtenerUsuariosConRetrasos() {
        List<Usuario> usuariosConRetraso = new ArrayList<>();

        for (Prestamo prestamo : prestamos) {
            if (!prestamo.isDevuelto() && prestamo.calcularDiasRetraso() > 0) {
                // Verificar que el usuario no esté ya en la lista
                boolean yaEstaEnLista = false;
                for (Usuario u : usuariosConRetraso) {
                    if (u.equals(prestamo.getUsuario())) {
                        yaEstaEnLista = true;
                        break;
                    }
                }
                if (!yaEstaEnLista) {
                    usuariosConRetraso.add(prestamo.getUsuario());
                }
            }
        }

        return usuariosConRetraso;
    }

    public String generarReporteEstadisticas() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=== REPORTE ESTADÍSTICAS BIBLIOTECA ===\n\n");

        // 1. Total de materiales por tipo
        int totalLibros = 0, totalRevistas = 0, totalTesis = 0;

        for (MaterialBibliografico material : materiales) {
            if (material instanceof Libro) {
                totalLibros++;
            } else if (material instanceof Revista) {
                totalRevistas++;
            } else if (material instanceof Tesis) {
                totalTesis++;
            }
        }

        reporte.append("1. MATERIALES POR TIPO:\n");
        reporte.append(String.format("   Libro: %d\n", totalLibros));
        reporte.append(String.format("   Revista: %d\n", totalRevistas));
        reporte.append(String.format("   Tesis: %d\n", totalTesis));

        // 2. Usuario con más préstamos activos
        reporte.append("\n2. USUARIO CON MÁS PRÉSTAMOS ACTIVOS:\n");
        Usuario usuarioConMasPrestamos = null;
        int maxPrestamos = 0;

        for (Usuario usuario : usuarios) {
            int prestamosActivos = usuario.getMaterialesPrestados().size();
            if (prestamosActivos > maxPrestamos) {
                maxPrestamos = prestamosActivos;
                usuarioConMasPrestamos = usuario;
            }
        }

        if (usuarioConMasPrestamos != null) {
            reporte.append(String.format("   %s - %d préstamos activos\n",
                    usuarioConMasPrestamos.getNombre(), maxPrestamos));
        } else {
            reporte.append("   No hay usuarios con préstamos activos\n");
        }

        // 3. Material más prestado
        reporte.append("\n3. MATERIAL MÁS PRESTADO:\n");
        MaterialBibliografico materialMasPrestado = null;
        int maxVecesPrestado = 0;

        // Contar préstamos por material
        for (MaterialBibliografico material : materiales) {
            int vecesPrestado = 0;
            for (Prestamo prestamo : historialPrestamos) {
                if (prestamo.getMaterial().equals(material)) {
                    vecesPrestado++;
                }
            }
            if (vecesPrestado > maxVecesPrestado) {
                maxVecesPrestado = vecesPrestado;
                materialMasPrestado = material;
            }
        }

        if (materialMasPrestado != null && maxVecesPrestado > 0) {
            reporte.append(String.format("   %s - %d préstamos\n",
                    materialMasPrestado.getTitulo(), maxVecesPrestado));
        } else {
            reporte.append("   No hay historial de préstamos\n");
        }

        // 4. Total de multas pendientes por tipo de usuario
        reporte.append("\n4. MULTAS PENDIENTES POR TIPO DE USUARIO:\n");

        double multasEstudiantes = 0, multasProfesores = 0, multasInvestigadores = 0;

        for (Prestamo prestamo : prestamos) {
            if (!prestamo.isDevuelto()) {
                double multa = prestamo.calcularMulta();
                if (multa > 0) {
                    String tipoUsuario = prestamo.getUsuario().getTipoUsuario();
                    if (tipoUsuario.equals("Estudiante")) {
                        multasEstudiantes += multa;
                    } else if (tipoUsuario.equals("Profesor")) {
                        multasProfesores += multa;
                    } else if (tipoUsuario.equals("Investigador")) {
                        multasInvestigadores += multa;
                    }
                }
            }
        }

        if (multasEstudiantes == 0 && multasProfesores == 0 && multasInvestigadores == 0) {
            reporte.append("   No hay multas pendientes\n");
        } else {
            if (multasEstudiantes > 0) {
                reporte.append(String.format("   Estudiante: $%.2f\n", multasEstudiantes));
            }
            if (multasProfesores > 0) {
                reporte.append(String.format("   Profesor: $%.2f\n", multasProfesores));
            }
            if (multasInvestigadores > 0) {
                reporte.append(String.format("   Investigador: $%.2f\n", multasInvestigadores));
            }
        }

        return reporte.toString();
    }

}

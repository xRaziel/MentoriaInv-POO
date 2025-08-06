import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int[][] sensores;
    private static int[][] calidadAire, trafico, actividadComercial;
    private static double[][] indiceHabitabilidad;
    private static int filas, columnas;

    public static void main(String[] args) {
        // Inicializar con datos de ejemplo
        inicializarDatos();

        System.out.println("=== SISTEMA DE ANÁLISIS DE SENSORES URBANOS ===\n");

        // 1. Decodificación y análisis básico
        decodificarSensores();
        mostrarAnalisisBasico();

        // 2. Detección de zonas problemáticas
        detectarZonasProblematicas();

        // 3. Cálculo de índice de habitabilidad
        calcularIndiceHabitabilidad();
        mostrarClasificacionSectores();

    }

    private static void inicializarDatos() {
        // Matriz de ejemplo 6x6
        sensores = new int[][]{
                {827, 143, 695, 412, 738, 264},
                {591, 376, 248, 853, 167, 429},
                {635, 782, 914, 346, 521, 708},
                {158, 627, 483, 795, 312, 864},
                {749, 285, 536, 671, 924, 158},
                {413, 568, 297, 184, 635, 472}
        };

        filas = sensores.length;
        columnas = sensores[0].length;

        calidadAire = new int[filas][columnas];
        trafico = new int[filas][columnas];
        actividadComercial = new int[filas][columnas];
        indiceHabitabilidad = new double[filas][columnas];

        System.out.println("Matriz de sensores inicializada (" + filas + "x" + columnas + ")");
        mostrarMatriz(sensores, "Datos de Sensores");
    }

    private static void decodificarSensores() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int valor = sensores[i][j];
                calidadAire[i][j] = valor / 100;  // centenas
                trafico[i][j] = (valor / 10) % 10;  // decenas
                actividadComercial[i][j] = valor % 10;  // unidades
            }
        }

        System.out.println("\n=== DECODIFICACIÓN COMPLETADA ===");
        mostrarMatriz(calidadAire, "Calidad del Aire");
        mostrarMatriz(trafico, "Tráfico");
        mostrarMatriz(actividadComercial, "Actividad Comercial");
    }

    private static void mostrarAnalisisBasico() {
        // Calcular promedios
        double promCalidad = calcularPromedio(calidadAire);
        double promTrafico = calcularPromedio(trafico);
        double promActividad = calcularPromedio(actividadComercial);

        System.out.println("\n=== ANÁLISIS BÁSICO ===");
        System.out.printf("Promedio Calidad del Aire: %.2f\n", promCalidad);
        System.out.printf("Promedio Tráfico: %.2f\n", promTrafico);
        System.out.printf("Promedio Actividad Comercial: %.2f\n", promActividad);

        // Identificar sectores críticos
        System.out.println("\nSectores Críticos (Calidad del Aire >= 7):");
        boolean hayCriticos = false;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (calidadAire[i][j] >= 7) {
                    System.out.printf("Sector (%d,%d): Calidad=%d\n",
                            i, j, calidadAire[i][j]);
                    hayCriticos = true;
                }
            }
        }
        if (!hayCriticos) {
            System.out.println("No se encontraron sectores críticos.");
        }
    }

    private static void detectarZonasProblematicas() {
        System.out.println("\n=== DETECCIÓN DE ZONAS PROBLEMÁTICAS ===");

        // Detectar zonas rojas (2x2 con al menos 3 sensores calidad >= 6)
        List<String> zonasRojas = new ArrayList<>();
        for (int i = 0; i < filas - 1; i++) {
            for (int j = 0; j < columnas - 1; j++) {
                int contadorCriticos = 0;
                if (calidadAire[i][j] >= 6) contadorCriticos++;
                if (calidadAire[i][j+1] >= 6) contadorCriticos++;
                if (calidadAire[i+1][j] >= 6) contadorCriticos++;
                if (calidadAire[i+1][j+1] >= 6) contadorCriticos++;

                if (contadorCriticos >= 3) {
                    zonasRojas.add(String.format("Zona Roja en (%d,%d)-(%d,%d)",
                            i, j, i+1, j+1));
                }
            }
        }

        System.out.println("Zonas Rojas encontradas: " + zonasRojas.size());
        for (String zona : zonasRojas) {
            System.out.println("- " + zona);
        }

        // Detectar corredores de tráfico
        List<String> corredores = new ArrayList<>();

        // Revisar filas
        for (int i = 0; i < filas; i++) {
            int contadorTrafico = 0;
            for (int j = 0; j < columnas; j++) {
                if (trafico[i][j] >= 7) contadorTrafico++;
            }
            if (contadorTrafico >= (int)(columnas * 0.6)) {
                corredores.add("Fila " + i);
            }
        }

        // Revisar columnas
        for (int j = 0; j < columnas; j++) {
            int contadorTrafico = 0;
            for (int i = 0; i < filas; i++) {
                if (trafico[i][j] >= 7) contadorTrafico++;
            }
            if (contadorTrafico >= (int)(filas * 0.6)) {
                corredores.add("Columna " + j);
            }
        }

        System.out.println("\nCorredores de Tráfico encontrados: " + corredores.size());
        for (String corredor : corredores) {
            System.out.println("- " + corredor);
        }
    }

    private static void calcularIndiceHabitabilidad() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                double indice = 10.0 - (calidadAire[i][j] * 0.5) -
                        (trafico[i][j] * 0.3) +
                        (actividadComercial[i][j] * 0.2);
                indiceHabitabilidad[i][j] = Math.max(0, indice); // No negativo
            }
        }

        System.out.println("\n=== ÍNDICE DE HABITABILIDAD ===");
        mostrarMatrizDouble(indiceHabitabilidad, "Índice de Habitabilidad");
    }

    private static void mostrarClasificacionSectores() {
        int excelente = 0, bueno = 0, regular = 0, deficiente = 0;

        System.out.println("\nClasificación de Sectores:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                double indice = indiceHabitabilidad[i][j];
                String categoria;

                if (indice >= 7) {
                    categoria = "Excelente";
                    excelente++;
                } else if (indice >= 5) {
                    categoria = "Bueno";
                    bueno++;
                } else if (indice >= 3) {
                    categoria = "Regular";
                    regular++;
                } else {
                    categoria = "Deficiente";
                    deficiente++;
                }

                System.out.printf("Sector (%d,%d): %.2f - %s\n",
                        i, j, indice, categoria);
            }
        }

        System.out.println("\nResumen de Clasificación:");
        System.out.println("Excelente: " + excelente + " sectores");
        System.out.println("Bueno: " + bueno + " sectores");
        System.out.println("Regular: " + regular + " sectores");
        System.out.println("Deficiente: " + deficiente + " sectores");
    }


    // Métodos auxiliares
    private static double calcularPromedio(int[][] matriz) {
        int suma = 0;
        int total = matriz.length * matriz[0].length;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                suma += matriz[i][j];
            }
        }

        return (double) suma / total;
    }




    private static void mostrarMatriz(int[][] matriz, String titulo) {
        System.out.println("\n" + titulo + ":");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println();
        }
    }

    private static void mostrarMatrizDouble(double[][] matriz, String titulo) {
        System.out.println("\n" + titulo + ":");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("%6.2f ", matriz[i][j]);
            }
            System.out.println();
        }
    }

}
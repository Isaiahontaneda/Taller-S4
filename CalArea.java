import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CalArea {

    private static BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        boolean continuar = true;
        System.out.println("¡Bienvenido al programa de cálculo de áreas y perímetros!");

        while (continuar) {
            mostrarMenu();
            int opcion = Integer.parseInt(lector.readLine());

            switch (opcion) {
                case 1 -> calcularTriangulo();
                case 2 -> calcularCuadrado();
                case 3 -> calcularRectangulo();
                default -> System.out.println("Opción no válida. Inténtelo nuevamente.");
            }
            System.out.print("¿Desea realizar otro cálculo? (s/n): ");
            continuar = lector.readLine().equalsIgnoreCase("s");
        }
        System.out.println("¡Gracias por usar el programa!");
    }

    private static void mostrarMenu() {
        System.out.println("\nSeleccione la figura para calcular:");
        System.out.println("1. Triángulo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Rectángulo");
        System.out.print("Elija una opción (1-3): ");
    }

    private static void calcularTriangulo() throws IOException {
        System.out.print("Ingrese la base del triángulo: ");
        double base = Double.parseDouble(lector.readLine());
        System.out.print("Ingrese la altura del triángulo: ");
        double altura = Double.parseDouble(lector.readLine());
        double area = (base * altura) / 2;
        double perimetro = base * 3; // Asumiendo triángulo equilátero
        System.out.printf("Área del triángulo: %.2f\n", area);
        System.out.printf("Perímetro del triángulo: %.2f\n", perimetro);
    }

    private static void calcularCuadrado() throws IOException {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = Double.parseDouble(lector.readLine());
        double area = lado * lado;
        double perimetro = 4 * lado;
        System.out.printf("Área del cuadrado: %.2f\n", area);
        System.out.printf("Perímetro del cuadrado: %.2f\n", perimetro);
    }

    private static void calcularRectangulo() throws IOException {
        System.out.print("Ingrese el largo del rectángulo: ");
        double largo = Double.parseDouble(lector.readLine());
        System.out.print("Ingrese el ancho del rectángulo: ");
        double ancho = Double.parseDouble(lector.readLine());
        double area = largo * ancho;
        double perimetro = 2 * (largo + ancho);
        System.out.printf("Área del rectángulo: %.2f\n", area);
        System.out.printf("Perímetro del rectángulo: %.2f\n", perimetro);
    }
}



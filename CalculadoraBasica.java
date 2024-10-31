import java.util.Scanner;

public class CalculadoraBasica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.print("Ingrese el primer número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double num2 = scanner.nextDouble();

            System.out.println("Seleccione la operación (+, -, *, /): ");
            char operacion = scanner.next().charAt(0);

            double resultado = realizarOperacion(num1, num2, operacion);
            System.out.printf("El resultado es: %.2f\n", resultado);

            System.out.print("¿Desea realizar otra operación? (s/n): ");
            continuar = scanner.next().equalsIgnoreCase("s");
        }
        System.out.println("Gracias por usar la calculadora.");
        scanner.close();
    }

    private static double realizarOperacion(double num1, double num2, char operacion) {
        return switch (operacion) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> (num2 != 0) ? num1 / num2 : Double.NaN;
            default -> {
                System.out.println("Operación no válida.");
                yield Double.NaN;
            }
        };
    }
}

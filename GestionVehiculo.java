import javax.swing.JOptionPane;

public class GestionVehiculo {

    public static void main(String[] args) {
        String motor = JOptionPane.showInputDialog("Número de motor:");
        String ventanas = JOptionPane.showInputDialog("Número de ventanas:");
        String puertas = JOptionPane.showInputDialog("Cantidad de puertas:");
        String marca = JOptionPane.showInputDialog("Marca del vehículo:");
        String modelo = JOptionPane.showInputDialog("Modelo del vehículo:");

        int kmInicial = solicitarKilometraje("Ingrese el kilometraje inicial:");
        int kmFinal = solicitarKilometraje("Ingrese el kilometraje final:");

        if (kmFinal >= kmInicial) {
            int kmRecorridos = kmFinal - kmInicial;
            mostrarDatos(motor, ventanas, puertas, marca, modelo, kmInicial, kmFinal, kmRecorridos);
        } else {
            JOptionPane.showMessageDialog(null, "Error: el kilometraje final debe ser mayor o igual al inicial.");
        }
    }

    private static int solicitarKilometraje(String mensaje) {
        int km;
        while (true) {
            try {
                km = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                if (km >= 0) break;
                JOptionPane.showMessageDialog(null, "El kilometraje debe ser un número positivo.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
            }
        }
        return km;
    }

    private static void mostrarDatos(String motor, String ventanas, String puertas, String marca, String modelo, int kmInicial, int kmFinal, int kmRecorridos) {
        JOptionPane.showMessageDialog(null, String.format("Información del vehículo:\nMotor: %s\nVentanas: %s\nPuertas: %s\nMarca: %s\nModelo: %s\nKilometraje inicial: %d km\nKilometraje final: %d km\nKilómetros recorridos: %d km", motor, ventanas, puertas, marca, modelo, kmInicial, kmFinal, kmRecorridos));
    }
}

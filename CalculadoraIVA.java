import javax.swing.JOptionPane;

public class CalculadoraIVA {

    public static void main(String[] args) {
        String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        double precio = solicitarPrecio();
        boolean tieneIva = JOptionPane.showConfirmDialog(null, "¿El producto tiene IVA?", "IVA", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        double valorIva = calcularIva(precio, tieneIva);
        double total = precio + valorIva;

        mostrarResumen(nombreProducto, precio, valorIva, total);
    }

    private static double solicitarPrecio() {
        double precio = 0.0;
        while (true) {
            try {
                precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto:"));
                if (precio >= 0) break;
                JOptionPane.showMessageDialog(null, "El precio debe ser positivo.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido.");
            }
        }
        return precio;
    }

    private static double calcularIva(double precio, boolean tieneIva) {
        if (!tieneIva) return 0;
        return (precio <= 500) ? precio * 0.12 : (precio <= 1500) ? precio * 0.14 : precio * 0.15;
    }

    private static void mostrarResumen(String nombre, double precio, double iva, double total) {
        String mensaje = String.format("Producto: %s\nPrecio original: $%.2f\nIVA: $%.2f\nTotal a pagar: $%.2f", nombre, precio, iva, total);
        JOptionPane.showMessageDialog(null, mensaje);
    }
}

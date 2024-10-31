import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;

public class Empleado {

    private String id;
    private String nombre;
    private String apellido;
    private String genero;
    private double salario;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    public Empleado(String id, String nombre, String apellido, String genero, double salario, LocalDate fechaNacimiento, LocalDate fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public void modificarSalario(double nuevoSalario) {
        this.salario = nuevoSalario;
    }

    public int obtenerEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public int calcularAntiguedad() {
        return Period.between(fechaIngreso, LocalDate.now()).getYears();
    }

    public double calcularPrestaciones() {
        return (calcularAntiguedad() * salario) / 12;
    }

    public void mostrarInformacion() {
        String info = String.format("Empleado:\nID: %s\nNombre: %s %s\nGénero: %s\nSalario: $%.2f\nEdad: %d años\nAntigüedad: %d años\nPrestaciones: $%.2f",
                id, nombre, apellido, genero, salario, obtenerEdad(), calcularAntiguedad(), calcularPrestaciones());
        JOptionPane.showMessageDialog(null, info);
    }

    public static void main(String[] args) {
        Empleado empleado = crearEmpleado();
        while (true) {
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Empleado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Modificar Salario", "Calcular Edad", "Calcular Prestaciones", "Mostrar Información", "Salir"}, "Salir");
            switch (opcion) {
                case 0 -> modificarSalario(empleado);
                case 1 -> JOptionPane.showMessageDialog(null, "Edad: " + empleado.obtenerEdad() + " años");
                case 2 -> JOptionPane.showMessageDialog(null, "Prestaciones: $" + empleado.calcularPrestaciones());
                case 3 -> empleado.mostrarInformacion();
                case 4, -1 -> {
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    return;
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static Empleado crearEmpleado() {
        String id = JOptionPane.showInputDialog("ID del empleado:");
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String apellido = JOptionPane.showInputDialog("Apellido:");
        String genero = JOptionPane.showInputDialog("Género:");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salario mensual:"));
        LocalDate fechaNacimiento = LocalDate.parse(JOptionPane.showInputDialog("Fecha de nacimiento (aaaa-mm-dd):"));
        LocalDate fechaIngreso = LocalDate.parse(JOptionPane.showInputDialog("Fecha de ingreso (aaaa-mm-dd):"));
        return new Empleado(id, nombre, apellido, genero, salario, fechaNacimiento, fechaIngreso);
    }

    private static void modificarSalario(Empleado empleado) {
        double nuevoSalario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo salario:"));
        empleado.modificarSalario(nuevoSalario);
        JOptionPane.showMessageDialog(null, "Salario actualizado.");
    }
}

import java.util.Scanner;

public class Boletos {
    private String pelicula;
    private double precioEntrada;

    public Boletos(String pelicula, double precioEntrada) {
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
    }

    public void venderEntrada(Cliente cliente) {
        if (!cliente.getCorreo().contains("@")) {
            System.out.println("Correo electrónico inválido. No se puede vender la entrada.");
        } else if (cliente.getEdad() < 18) {
            System.out.println("Lo sentimos, debes tener al menos 18 años para ver esta película.");
        } else {
            System.out.println("Entrada vendida a: " + cliente.getNombre());
            System.out.println("Película: " + pelicula);
            System.out.println("Precio: $" + precioEntrada);
            System.out.println("Confirmación enviada a: " + cliente.getCorreo());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Cine");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("¿Qué película quiere ver? ");
        String pelicula = scanner.nextLine();

        double precio = 6.50;

        Cliente cliente = new Cliente(nombre, correo, edad);
        Boletos entrada = new Boletos(pelicula, precio);

        entrada.venderEntrada(cliente);
    }
}

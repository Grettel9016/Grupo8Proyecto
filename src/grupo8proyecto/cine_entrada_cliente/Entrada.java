import java.util.Scanner;

public class Entrada {
    private String pelicula;
    private double precioEntrada;

    public Entrada(String pelicula, double precioEntrada) {
        this.pelicula = pelicula;
        this.precioEntrada = precioEntrada;
    }

    public void venderEntrada(Cliente cliente) {
        if (cliente.getCorreo().equals("correo_no_valido")) {
            System.out.println("Correo electrónico inválido. No se puede vender la entrada.");
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

        System.out.print("¿Qué película quiere ver? ");
        String pelicula = scanner.nextLine();

        
        double precio = 6.50;

        Cliente cliente = new Cliente(nombre, correo);
        Entrada entrada = new Entrada(pelicula, precio);

        entrada.venderEntrada(cliente);
    }
}

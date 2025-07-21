import java.util.Scanner;

public class Cine_Entradas_Cliente {


    static class Cliente {
        String nombre;
        String correo;

        Cliente(String nombre, String correo) {
            this.nombre = nombre;
            setCorreo(correo);
        }

        void setCorreo(String correo) {
            if (correo.contains("@") && correo.contains(".")) {
                this.correo = correo;
            } else {
                System.out.println("Correo inválido. Se asignó un correo por defecto.");
                this.correo = "correo_invalido@error.com";
            }
        }

        void mostrarCliente() {
            System.out.println("Nombre: " + nombre + " | Correo: " + correo);
        }
    }

   
    static class Entrada {
        Cliente cliente;
        String pelicula;
        int asiento;
        double precio;

        Entrada(Cliente cliente, String pelicula, int asiento, double precio) {
            this.cliente = cliente;
            this.pelicula = pelicula;
            this.asiento = asiento;
            this.precio = precio;
        }

        void mostrarEntrada() {
            System.out.println("Cliente: " + cliente.nombre +
                    " | Película: " + pelicula +
                    " | Asiento: " + asiento +
                    " | Precio: ₡" + precio);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX_CLIENTES = 150;
        final int MAX_ENTRADAS = 150;

        Cliente[] clientes = new Cliente[MAX_CLIENTES];
        Entrada[] entradas = new Entrada[MAX_ENTRADAS];

        int cantClientes = 0;
        int cantEntradas = 0;

        boolean[] asientosOcupados = new boolean[MAX_ENTRADAS];

        int opcion;

        do {
            System.out.println("\n--- MENÚ CINE ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Comprar entrada");
            System.out.println("3. Ver clientes");
            System.out.println("4. Ver entradas");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    if (cantClientes >= MAX_CLIENTES) {
                        System.out.println("No se pueden registrar más clientes.");
                        break;
                    }
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();

                    String correo;
                    do {
                        System.out.print("Ingrese correo: ");
                        correo = sc.nextLine();
                        if (!(correo.contains("@") && correo.contains("."))) {
                            System.out.println("Correo inválido. Intente de nuevo.");
                        }
                    } while (!(correo.contains("@") && correo.contains(".")));

                    clientes[cantClientes] = new Cliente(nombre, correo);
                    cantClientes++;
                    System.out.println("Cliente registrado.");
                    break;

                case 2:
                    if (cantClientes == 0) {
                        System.out.println("Debe registrar clientes primero.");
                        break;
                    }
                    if (cantEntradas >= MAX_ENTRADAS) {
                        System.out.println("No hay más asientos disponibles.");
                        break;
                    }

                    System.out.print("Ingrese nombre de la película: ");
                    String pelicula = sc.nextLine();

                    System.out.print("Ingrese precio de la entrada: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Seleccione cliente:");
                    for (int i = 0; i < cantClientes; i++) {
                        System.out.println(i + ". " + clientes[i].nombre);
                    }
                    System.out.print("Número cliente: ");
                    int indexCliente = sc.nextInt();
                    sc.nextLine();

                    if (indexCliente < 0 || indexCliente >= cantClientes) {
                        System.out.println("Cliente inválido.");
                        break;
                    }

                    int asiento;
                    do {
                        System.out.print("Ingrese número de asiento (1 a " + MAX_ENTRADAS + "): ");
                        asiento = sc.nextInt();
                        sc.nextLine();
                        if (asiento < 1 || asiento > MAX_ENTRADAS) {
                            System.out.println("Número de asiento inválido.");
                        } else if (asientosOcupados[asiento - 1]) {
                            System.out.println("Asiento ya ocupado, elija otro.");
                        } else {
                            break;
                        }
                    } while (true);

                    entradas[cantEntradas] = new Entrada(clientes[indexCliente], pelicula, asiento, precio);
                    asientosOcupados[asiento - 1] = true;
                    cantEntradas++;
                    System.out.println("Entrada registrada.");
                    break;

                case 3:
                    if (cantClientes == 0) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        System.out.println("Lista de clientes:");
                        for (int i = 0; i < cantClientes; i++) {
                            clientes[i].mostrarCliente();
                        }
                    }
                    break;

                case 4:
                    if (cantEntradas == 0) {
                        System.out.println("No hay entradas registradas.");
                    } else {
                        System.out.println("Lista de entradas:");
                        for (int i = 0; i < cantEntradas; i++) {
                            entradas[i].mostrarEntrada();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
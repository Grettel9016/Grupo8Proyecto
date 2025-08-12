
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo8proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author grett
 */
public class Grupo8Proyecto {
    
    private static boolean esNumero(String s) {
        if (s == null) return false;
            s = s.trim();
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
            return true;
        }
    
    private static boolean esNumeroDecimal(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.isEmpty()) return false;
        return s.matches("\\d+(?:[\\.,]\\d+)?"); // acepta enteros y decimales
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cine cine = new Cine();
        
        //  carga de datos 
        cine.agregarPelicula(new Pelicula("Los 4 Fantasticos", 93, Genero.CienciaFiccion, Clasificacion.TP));
        cine.agregarPelicula(new Pelicula("Tipos malos2", 87, Genero.Animada, Clasificacion.TP));
        cine.agregarPelicula(new Pelicula("Shadow Force", 87, Genero.Accion, Clasificacion.M18));
        cine.agregarSala(new Sala(0, 50));
        cine.agregarSala(new Sala(1, 30));
        cine.agregarSala(new Sala(2, 100));
        // cliente para poder comprar de una vez
        cine.agregarCliente(new Cliente("Maria Solis", "102340568", "maria@mail.com", 20));
        cine.agregarCliente(new Cliente("Carlos Gomez", "304560789", "carlos@mail.com", 17));
        // funciones base (usa las pelis y salas precargadas)

        
        cine.agregarFuncion(new Funcion("13-08-2025","18:30",cine.getPelicula(0),cine.getSala(0),true,Tipo.Sala2D));
        cine.agregarFuncion(new Funcion("13-08-2025","20:00",cine.getPelicula(1),cine.getSala(1),true,Tipo.SalaVIP));
        cine.agregarFuncion(new Funcion("13-08-2025","15:00",cine.getPelicula(1),cine.getSala(1),true,Tipo.Sala3D));
        
       
        
        // ==== MENÚ PRINCIPAL ====
        while (true) {
            String entrada = JOptionPane.showInputDialog(
                "===== MENÚ PRINCIPAL =====\n" +
                "Seleccione una opción:\n" +
                "1. Ver Cartelera\n" +
                "2. Comprar Entradas\n" +
                "3. Funciones Administrativas\n" +
                "0. Salir");

            if (entrada == null) break;
            if (!esNumero(entrada)) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese solo números.");
                continue;
            }

            int opcion = Integer.parseInt(entrada);
            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, cine.listarPeliculas());
                    JOptionPane.showMessageDialog(null, cine.listarFunciones());
                    break;
                case 2:
                    subMenuComprar(cine);
                    break;

                case 3:
                    //subMenuAdministrativas(cine);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Se a salido del sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.Ingrese del 1 al 3 o 0 para salir");
            }

            if (opcion == 0) break;
        }
    }
    
    private static void subMenuComprar(Cine cine) {
        int funcionSeleccionada = 0; // 0 = sin seleccionar; 1..N
        int asientoSeleccionado = 0; // 0 = sin seleccionar; 1..capacidad

        while (true) {
            String estado = "Función: " + (funcionSeleccionada == 0 ? "(sin seleccionar)" : funcionSeleccionada) +
                            " | Asiento: " + (asientoSeleccionado == 0 ? "(sin seleccionar)" : asientoSeleccionado);

            String entradaMenu = JOptionPane.showInputDialog(
                "====== COMPRAR ENTRADAS ======\n" +
                estado + "\n\n" +
                "1. Seleccionar película/función\n" +
                "2. Confirmar compra\n" +
                "0. Volver"
            );

            if (entradaMenu == null) return;
            if (!esNumero(entradaMenu)) {
                JOptionPane.showMessageDialog(null, "Ingrese solo números.");
                continue;
            }

            int opcion = Integer.parseInt(entradaMenu);
            switch (opcion) {
                case 1: { // Elegir función
                    JOptionPane.showMessageDialog(null, cine.listarFunciones());

                    String entradaFuncion = JOptionPane.showInputDialog("Ingrese el # de función (1..N):");
                    if (entradaFuncion == null || !esNumero(entradaFuncion)) break;

                    int numeroFuncion = Integer.parseInt(entradaFuncion); // 1..N
                    Funcion funcion = (numeroFuncion >= 1) ? cine.getFuncion(numeroFuncion - 1) : null;
                    if (funcion == null) {
                        JOptionPane.showMessageDialog(null, "Función no válida.");
                        break;
                    }

                    funcionSeleccionada = numeroFuncion;
                    asientoSeleccionado = 0; // reinicia asiento al cambiar función
                    JOptionPane.showMessageDialog(null, "Función seleccionada: #" + funcionSeleccionada);
                    break;
                }
            case 2: { 
                if (funcionSeleccionada == 0) {
                    JOptionPane.showMessageDialog(null, "Falta seleccionar la función.");
                    break;
                }

                // 1) Cédula (si no está, se crea cliente nuevo pidiendo NOMBRE y EDAD)
                String cedula = JOptionPane.showInputDialog("Cédula del cliente:");
                if (cedula == null || cedula.trim().isEmpty()) break;

                int indiceCliente = cine.buscarClientePorCedula(cedula);
                if (indiceCliente == -1) {
                    String nombre = JOptionPane.showInputDialog("Nombre del cliente (dejar vacío para 'Invitado'):");
                    if (nombre == null) break;
                    if (nombre.trim().isEmpty()) {
                        nombre = "Invitado";
                    }

                    String entradaEdad = JOptionPane.showInputDialog("Edad del cliente (en años):");
                    if (entradaEdad == null || !esNumero(entradaEdad)) {
                        JOptionPane.showMessageDialog(null, "Edad inválida.");
                        break;
                    }
                    int edad = Integer.parseInt(entradaEdad);
                    if (edad < 0 || edad > 120) {
                        JOptionPane.showMessageDialog(null, "Edad fuera de rango.");
                        break;
                    }

                    Cliente nuevo = new Cliente(nombre, cedula.trim(), "", edad);
                    if (!cine.agregarCliente(nuevo)) {
                        JOptionPane.showMessageDialog(null, "No hay espacio para nuevos clientes.");
                        break;
                    }
                    indiceCliente = cine.getCantClientes() - 1;
                }
                
                // VALIDACIÓN DE EDAD ANTES DE COMPRAR
                int idxFuncion = funcionSeleccionada - 1;    
                Funcion funcion = cine.getFuncion(idxFuncion);
                if (funcion == null) {                        
                    JOptionPane.showMessageDialog(null, "Función inválida.");
                    break;
                }
                
                Cliente cliente = cine.getCliente(indiceCliente);
                int edadMinima = cine.edadMinimaPorClasificacion(
                    funcion.getPelicula().getClasificacion()
                );

                if (cliente.getEdad() < edadMinima) {
                    JOptionPane.showMessageDialog(null,
                        "No se puede completar la compra.\n" +
                        "Clasificación: " + funcion.getPelicula().getClasificacion() + "\n" +
                        "Edad mínima requerida: " + edadMinima + " años\n" +
                        "Edad del cliente: " + cliente.getEdad() + " años"
                    );
                    break; // salir sin comprar
                }
    
                // 2) Cantidad de boletos (entero)
                String entradaCantidad = JOptionPane.showInputDialog("Cantidad de boletos:");
                if (entradaCantidad == null || !esNumero(entradaCantidad)) {
                    JOptionPane.showMessageDialog(null, "Cantidad inválida.");
                    break;
                }
                int cantidad = Integer.parseInt(entradaCantidad);
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor que 0.");
                    break;
                }



                // 3) Precio unitario automático desde el sistema (nada de pedir precio)
                double precioUnitario = cine.obtenerPrecioUnitario(idxFuncion);
                if (precioUnitario <= 0) {
                    JOptionPane.showMessageDialog(null, "Precio no disponible para esta función.");
                    break;
                }

                // 4) Emitir boletos pidiendo asientos uno a uno (sin usar arreglos aquí)
                String resumen = "";
                double total = 0.0;

                // Si ya había asiento seleccionado y cantidad=1, úsalo
                if (cantidad == 1 && asientoSeleccionado != 0) {
                    Boletos boleto = cine.confirmarCompra(idxFuncion, asientoSeleccionado, indiceCliente, precioUnitario);
                    if (boleto == null) {
                        JOptionPane.showMessageDialog(null, "No se pudo completar la compra (clasificación/asiento).");
                        break;
                    }
                    resumen= resumen + boleto.mostrarDetalleEntrada() + "\n";
                    total = total + precioUnitario;
                } else {
                    int capacidad = funcion.getSala().getCapacidad();
                    boolean error = false;

                    for (int k = 1; k <= cantidad; k++) {
                        String entradaAsiento = JOptionPane.showInputDialog(
                            "Asiento #" + k + " (1.." + capacidad + "):"
                        );
                        if (entradaAsiento == null || !esNumero(entradaAsiento)) {
                            JOptionPane.showMessageDialog(null, "Asiento inválido. Se cancela la compra.");
                            error = true;
                            break;
                        }
                        int numAsiento = Integer.parseInt(entradaAsiento);
                        if (numAsiento < 1 || numAsiento > capacidad) {
                            JOptionPane.showMessageDialog(null, "Asiento fuera de rango. Se cancela la compra.");
                            error = true;
                            break;
                        }

                        Boletos boleto = cine.confirmarCompra(idxFuncion, numAsiento, indiceCliente, precioUnitario);
                        if (boleto == null) {
                            JOptionPane.showMessageDialog(null, "No se pudo reservar el asiento " + numAsiento + ". Se cancela la compra.");
                            error = true;
                            break;
                        }

                        resumen = resumen + boleto.mostrarDetalleEntrada() + "\n";
                        total = total + precioUnitario;
                    }

                    if (error) break;
                }

                if (resumen.length() > 0) {
                    resumen = resumen + "\nTotal a pagar: " + String.format("%.2f", total);
                    JOptionPane.showMessageDialog(null, "Compra exitosa:\n" + resumen);
                    funcionSeleccionada = 0;
                    asientoSeleccionado = 0;
                }
                break;
            }
            case 0:
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}

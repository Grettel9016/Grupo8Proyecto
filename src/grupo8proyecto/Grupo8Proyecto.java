
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

    public static void main(String[] args) {
        Cine cine = new Cine();
        cargarDatosIniciales(cine);
        mostrarMenuPrincipal(cine);
    }

    private static void cargarDatosIniciales(Cine cine) {
        // Películas
        cine.agregarPelicula(new Pelicula("Los 4 Fantasticos", 93, Genero.CienciaFiccion, Clasificacion.TP));
        cine.agregarPelicula(new Pelicula("Tipos malos2", 87, Genero.Animada, Clasificacion.TP));
        cine.agregarPelicula(new Pelicula("Shadow Force", 87, Genero.Accion, Clasificacion.M18));
        
        // Salas
        cine.agregarSala(new Sala(1, 50, Tipo.Sala2D, null));
        cine.agregarSala(new Sala(2, 30, Tipo.SalaVIP, null));
        cine.agregarSala(new Sala(3, 100, Tipo.Sala3D, null));
        
        // Clientes
        cine.agregarCliente(new Cliente("Maria Solis", "102340568", "maria@mail.com", 20));
        cine.agregarCliente(new Cliente("Carlos Gomez", "304560789", "carlos@mail.com", 17));
        
        // Funciones
        cine.agregarFuncion(new Funcion("13-08-2025", "18:30", cine.getPelicula(0), cine.getSala(0), true, Tipo.Sala2D));
        cine.agregarFuncion(new Funcion("13-08-2025", "20:00", cine.getPelicula(1), cine.getSala(1), true, Tipo.SalaVIP));
        cine.agregarFuncion(new Funcion("13-08-2025", "15:00", cine.getPelicula(1), cine.getSala(1), true, Tipo.Sala3D));
    }

    private static void mostrarMenuPrincipal(Cine cine) {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                "CINE POLI\n" +
                "1. Ver Cartelera\n" +
                "2. Comprar Entradas\n" +
                "3. Administración\n" +
                "0. Salir\n\n" +
                "Seleccione una opción:");
            
            if (opcion == null) opcion = "0";
            
            switch (opcion) {
                case "1":
                    mostrarCartelera(cine);
                    break;
                case "2":
                    procesoCompra(cine);
                    break;
                case "3":
                    menuAdministracion(cine);
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static void mostrarCartelera(Cine cine) {
        String cartelera = "CARTELERA\n\n" + 
                          cine.listarPeliculas() + "\n\n" + 
                          "FUNCIONES\n" + 
                          cine.listarFunciones();
        JOptionPane.showMessageDialog(null, cartelera);
    }

    private static void procesoCompra(Cine cine) {
        // Funciones disponibles
        String listaFunciones = cine.listarFunciones();
        if (listaFunciones.contains("No hay")) {
            JOptionPane.showMessageDialog(null, "No hay funciones disponibles.");
            return;
        }
        
        // Seleccionar función
        String seleccionFuncion = JOptionPane.showInputDialog(
            listaFunciones + "\nIngrese el número de la función:");
        if (seleccionFuncion == null || !esNumero(seleccionFuncion)) return;
        
        int idxFuncion = Integer.parseInt(seleccionFuncion) - 1;
        Funcion funcion = cine.getFuncion(idxFuncion);
        if (funcion == null) {
            JOptionPane.showMessageDialog(null, "Función no válida.");
            return;
        }
        
        // Seleccionar cliente
        String listaClientes = cine.listarClientes();
        String seleccionCliente = JOptionPane.showInputDialog(
            listaClientes + "\nIngrese el número del cliente:");
        if (seleccionCliente == null || !esNumero(seleccionCliente)) return;
        
        int idxCliente = Integer.parseInt(seleccionCliente) - 1;
        Cliente cliente = cine.getCliente(idxCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no válido.");
            return;
        }
        
        // Seleccionar asiento
        String seleccionAsiento = JOptionPane.showInputDialog(
            "Ingrese el número de asiento (1-" + funcion.getSala().getCapacidad() + "):");
        if (seleccionAsiento == null || !esNumero(seleccionAsiento)) return;
        
        int asiento = Integer.parseInt(seleccionAsiento);
        
        // Confirmar compra
        double precio = cine.obtenerPrecioUnitario(idxFuncion);
        Boletos boleto = cine.confirmarCompra(idxFuncion, asiento, idxCliente, precio);
        
        if (boleto != null) {
            JOptionPane.showMessageDialog(null, 
                "¡Compra exitosa!\n" +
                boleto.mostrarDetalleEntrada());
        } else {
            JOptionPane.showMessageDialog(null, 
                "No se pudo completar la compra.\n" +
                "Posibles causas:\n" +
                "- Asiento ocupado\n" +
                "- Cliente no cumple clasificación de edad\n" +
                "- Límite de boletos alcanzado");
        }
    }

    private static void menuAdministracion(Cine cine) {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                "ADMINISTRACIÓN\n" +
                "1. Registrar película\n" +
                "2. Registrar sala\n" +
                "3. Programar función\n" +
                "4. Registrar cliente\n" +
                "0. Volver\n\n" +
                "Seleccione una opción:");
            
            if (opcion == null) opcion = "0";
            
            switch (opcion) {
                case "1":
                    registrarPelicula(cine);
                    break;
                case "2":
                    registrarSala(cine);
                    break;
                case "3":
                    programarFuncion(cine);
                    break;
                case "4":
                    registrarCliente(cine);
                    break;
                case "0":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static void registrarPelicula(Cine cine) {
        String titulo = JOptionPane.showInputDialog("Título de la película:");
        if (titulo == null || titulo.trim().isEmpty()) return;
        
        String duracionStr = JOptionPane.showInputDialog("Duración en minutos:");
        if (duracionStr == null || !esNumero(duracionStr)) {
            JOptionPane.showMessageDialog(null, "Duración inválida.");
            return;
        }
        int duracion = Integer.parseInt(duracionStr);
        
        // Géneros disponibles
        String generos = listarOpciones(Genero.values());
        String generoStr = JOptionPane.showInputDialog(
            "Género (" + generos + "):");
        try {
            Genero genero = Genero.valueOf(generoStr);
            
            // Clasificaciones disponibles
            String clasifs = listarOpciones(Clasificacion.values());
            String clasifStr = JOptionPane.showInputDialog(
                "Clasificación (" + clasifs + "):");
            Clasificacion clasificacion = Clasificacion.valueOf(clasifStr);
            
            Pelicula nueva = new Pelicula(titulo, duracion, genero, clasificacion);
            if (cine.agregarPelicula(nueva)) {
                JOptionPane.showMessageDialog(null, "Película registrada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la película.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Género o clasificación inválidos.");
        }
    }

    private static void registrarSala(Cine cine) {
        String numStr = JOptionPane.showInputDialog("Número de sala:");
        if (numStr == null || !esNumero(numStr)) {
            JOptionPane.showMessageDialog(null, "Número inválido.");
            return;
        }
        int numero = Integer.parseInt(numStr);
        
        String capStr = JOptionPane.showInputDialog("Capacidad:");
        if (capStr == null || !esNumero(capStr)) {
            JOptionPane.showMessageDialog(null, "Capacidad inválida.");
            return;
        }
        int capacidad = Integer.parseInt(capStr);
        
        // Tipos de sala
        String tipos = listarOpciones(Tipo.values());
        String tipoStr = JOptionPane.showInputDialog(
            "Tipo de sala (" + tipos + "):");
        try {
            Tipo tipo = Tipo.valueOf(tipoStr);
            
            Sala nueva = new Sala(numero, capacidad, tipo, null);
            if (cine.agregarSala(nueva)) {
                JOptionPane.showMessageDialog(null, "Sala registrada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo registrar la sala.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Tipo de sala inválido.");
        }
    }

    private static void programarFuncion(Cine cine) {
        if (cine.getCantidadPeliculas() == 0 || cine.getCantidadSalas() == 0) {
            JOptionPane.showMessageDialog(null, 
                "Debe registrar al menos una película y una sala primero.");
            return;
        }
        
        String fecha = JOptionPane.showInputDialog("Fecha (dd-mm-aaaa):");
        if (fecha == null || fecha.trim().isEmpty()) return;
        
        String hora = JOptionPane.showInputDialog("Hora (HH:mm):");
        if (hora == null || hora.trim().isEmpty()) return;
        
        // Seleccionar película
        String listaPelis = cine.listarPeliculas();
        String selPeli = JOptionPane.showInputDialog(listaPelis + "\nSeleccione película:");
        if (selPeli == null || !esNumero(selPeli)) return;
        
        int idxPeli = Integer.parseInt(selPeli) - 1;
        Pelicula pelicula = cine.getPelicula(idxPeli);
        if (pelicula == null) {
            JOptionPane.showMessageDialog(null, "Película no válida.");
            return;
        }
        
        // Seleccionar sala
        String listaSalas = cine.listarSalas();
        String selSala = JOptionPane.showInputDialog(listaSalas + "\nSeleccione sala:");
        if (selSala == null || !esNumero(selSala)) return;
        
        int idxSala = Integer.parseInt(selSala) - 1;
        Sala sala = cine.getSala(idxSala);
        if (sala == null) {
            JOptionPane.showMessageDialog(null, "Sala no válida.");
            return;
        }
        
        // Seleccionar tipo de función
        String tipos = listarOpciones(Tipo.values());
        String tipoStr = JOptionPane.showInputDialog(
            "Tipo de función (" + tipos + "):");
        try {
            Tipo tipo = Tipo.valueOf(tipoStr);
            
            Funcion nueva = new Funcion(fecha, hora, pelicula, sala, true, tipo);
            if (cine.agregarFuncion(nueva)) {
                JOptionPane.showMessageDialog(null, "Función programada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo programar la función.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Tipo de función inválido.");
        }
    }

    private static void registrarCliente(Cine cine) {
        String nombre = JOptionPane.showInputDialog("Nombre completo:");
        if (nombre == null || nombre.trim().isEmpty()) return;
        
        String cedula = JOptionPane.showInputDialog("Cédula:");
        if (cedula == null || cedula.trim().isEmpty()) return;
        
        String correo = JOptionPane.showInputDialog("Correo electrónico:");
        if (correo == null || correo.trim().isEmpty()) return;
        
        String edadStr = JOptionPane.showInputDialog("Edad:");
        if (edadStr == null || !esNumero(edadStr)) {
            JOptionPane.showMessageDialog(null, "Edad inválida.");
            return;
        }
        int edad = Integer.parseInt(edadStr);
        
        Cliente nuevo = new Cliente(nombre, cedula, correo, edad);
        if (cine.agregarCliente(nuevo)) {
            JOptionPane.showMessageDialog(null, "Cliente registrado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente.");
        }
    }

    // Métodos auxiliares
    private static String listarOpciones(Enum<?>[] valores) {
        StringBuilder sb = new StringBuilder();
        for (Enum<?> valor : valores) {
            sb.append(valor.name()).append(", ");
        }
        return sb.substring(0, sb.length()-2);
    }

    private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

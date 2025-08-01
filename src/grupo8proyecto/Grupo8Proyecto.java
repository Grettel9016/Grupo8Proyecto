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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // menu
        String entrada = JOptionPane.showInputDialog(
                "===== MENÚ PRINCIPAL =====\n" +
                "Seleccione una opción:\n"+
                "1. Ver Cartelera\n" +
                "2. Comprar Entradas\n" +
                "3. Funciones Administrativas\n" +
                "0. Salir");
      
        boolean esNumero = true;
        for (int i = 0; i < entrada.length(); i++) {
            if (!Character.isDigit(entrada.charAt(i))) {
                esNumero = false;
                break;
                }
        }

        if (esNumero && !entrada.isEmpty()) {
            int opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Mostrando cartelera.");
                    //llamar metodo
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Proceso de compra iniciado.");
                    String subCompra = JOptionPane.showInputDialog(
                            "===== COMPRAR ENTRADAS =====\n" +
                            "Seleccione una opción:\n" +
                            "1. Seleccionar película\n" +
                            "2. Seleccionar asiento\n" +
                            "3. Confirmar compra\n" +
                            "0. Volver al menú principal");

                    if (subCompra != null && subCompra.matches("\\d")) {
                        int opcionCompra = Integer.parseInt(subCompra);
                        switch (opcionCompra) {
                            case 1 -> JOptionPane.showMessageDialog(null, "Seleccionando película...");
                            case 2 -> JOptionPane.showMessageDialog(null, "Seleccionando asiento...");
                            case 3 -> JOptionPane.showMessageDialog(null, "Compra confirmada.");
                            case 0 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal.");
                            default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Entrada inválida.");
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Accediendo a administración.");
                    String subAdmin = JOptionPane.showInputDialog(
                            "Seleccione una opción:\n" +
                            "1. Registrar película\n" +
                            "2. Registrar sala\n" +
                            "3. Programar función\n" +
                            "0. Volver al menú principal");

                    if (subAdmin != null && subAdmin.matches("\\d")) {
                        int opcionAdmin = Integer.parseInt(subAdmin);
                        switch (opcionAdmin) {
                            case 1 -> JOptionPane.showMessageDialog(null, "Registrando nueva película...");
                            case 2 -> JOptionPane.showMessageDialog(null, "Registrando nueva sala...");
                            case 3 -> JOptionPane.showMessageDialog(null, "Programando función...");
                            case 0 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal.");
                            default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Entrada inválida.");
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
                }
        } else {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Ingrese solo números.");
        }

        } 
    
}
    


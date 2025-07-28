/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo8proyecto;

/**
 *
 * @author omarv
 */
   
public class Funcion {
    
    // Atributos
    private String fecha;
    private String nombrePelicula;
    private int sala;
    private boolean[] asientos; 
    private final String hora;

    // Constructor 
    public Funcion(String hora, String fecha, String nombrePelicula, int sala, int capacidad) {
        this.hora = hora;
        this.fecha = fecha;
        this.nombrePelicula = nombrePelicula;
        this.sala = sala;
        this.asientos = new boolean[capacidad]; // Inicializa todos en false (libres)
    }

    // Reservar asiento
    public boolean reservarAsiento(int numeroAsiento) {
        if (numeroAsiento >= 0 && numeroAsiento < asientos.length && !asientos[numeroAsiento]) {
            asientos[numeroAsiento] = true;
            System.out.println("Asiento " + numeroAsiento + " reservado.");
            return true;
        } else {
            System.out.println("Asiento " + numeroAsiento + " no disponible o inválido.");
            return false;
        }
    }

    // Info
    public void mostrarInfoFuncion() {
        System.out.println(
            "Película: " + nombrePelicula + 
            "\nFecha: " + fecha + 
            "\nHora: " + hora + 
            "\nSala: " + sala
        );
    }

    // Encapsuladores
    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public int getSala() {
        return sala;
    }
}

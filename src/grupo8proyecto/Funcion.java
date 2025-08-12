/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo8proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author omarv
 */
   
public class Funcion {
    private String fecha;
    private String hora;
    private Pelicula pelicula;
    private Sala sala;
    private boolean activa;
    private Tipo tipo;
    private boolean[] asientos;

    // Constructor
    public Funcion(String fecha, String hora, Pelicula pelicula, Sala sala, boolean activa, Tipo tipo) {
        if (sala == null || pelicula == null) {
            throw new IllegalArgumentException("Sala y Película no pueden ser nulas");
        }
        this.fecha = fecha;
        this.hora = hora;
        this.pelicula = pelicula;
        this.sala = sala;
        this.activa = activa;
        this.tipo = tipo;
        this.asientos = new boolean[sala.getCapacidad()];
    }

    // Métodos de asientos
    public boolean asientoDisponible(int asiento) {
        if (asiento < 0 || asiento >= asientos.length) {
            return false;
        }
        return !asientos[asiento];
    }

    public boolean reservarAsiento(int asiento) {
        if (asiento >= 0 && asiento < asientos.length && !asientos[asiento]) {
            asientos[asiento] = true;
            return true;
        }
        return false;
    }

    // Getters
    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public boolean isActiva() { return activa; }
    public Tipo getTipo() { return tipo; }

    public String mostrarFuncion() {
        return pelicula.getTitulo() + " - " + fecha + " " + hora + 
               " (Sala " + sala.getNumero() + ", " + tipo + ")";
    }
}


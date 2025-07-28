/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo8proyecto;

/**
 *
 * @author omarv
 */
public class Cine {
    
    // Atributos
    private String nombre;
    private String direccion;
    private int[] salas; 

    // Constructor
    public Cine(String nombre, String direccion, int capacidadSalas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.salas = new int[capacidadSalas]; 
    }

    // Agregar sala
    public void agregarSala(int numeroSala, int posicion) {
        if (posicion >= 0 && posicion < salas.length) {
            salas[posicion] = numeroSala;
        }
    }
}

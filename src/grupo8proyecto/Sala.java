/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo8proyecto;

/**
 *
 * @author grett
 */
public class Sala {
    private int numero;
    private int capacidad;
    private Tipo tipo;
    private Funcion funcion;

    public Sala(int numero, int capacidad, Tipo tipo, Funcion funcion) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.funcion = funcion;
    }

    // Getters
    public int getNumero() { return numero; }
    public int getCapacidad() { return capacidad; }
    public Tipo getTipo() { return tipo; }
    public Funcion getFuncion() { return funcion; }

    // Setters
    public void setNumero(int numero) { this.numero = numero; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }
    public void setFuncion(Funcion funcion) { this.funcion = funcion; }

    public String mostrarSala() {
        return "Sala #" + numero + " (" + tipo + ") - Capacidad: " + capacidad;
    }
}
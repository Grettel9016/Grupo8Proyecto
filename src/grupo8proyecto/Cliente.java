/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo8proyecto;

/**
 *
 * @author grett
 */
public class Cliente {
    private String nombre;
    private String cedula;
    private String correo;
    private int edad;

    public Cliente(String nombre, String cedula, String correo, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.edad = edad;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getCorreo() { return correo; }
    public int getEdad() { return edad; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setEdad(int edad) { this.edad = edad; }

    public String mostrarCliente() {
        return "Nombre: " + nombre + ", Cédula: " + cedula + ", Edad: " + edad;
    }
}
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
    
    // Atributos
    private String fecha;
    public Pelicula pelicula;
    public Sala sala;
    private boolean[] asientos; 
    private boolean esDoblada;
    private Tipo tipo;
    private String hora;
    
    

    // Constructor 
    public Funcion(String fecha,String hora,Pelicula pelicula, Sala sala, boolean esDoblada, Tipo tipo) {
        this.fecha = fecha;
        this.hora= hora;
        this.pelicula = pelicula;
        this.sala = sala;
        this.esDoblada = esDoblada;
        this.tipo = tipo;
        this.asientos = new boolean[sala.getCapacidad()]; // OK porque tengo el objeto Sala
    }
    
    // ¿Asiento disponible?
    public boolean asientoDisponible(int numeroAsiento) {
        return numeroAsiento >= 0
                && numeroAsiento < asientos.length
                && !asientos[numeroAsiento];
    }

    // Reservar asiento
    public boolean reservarAsiento(int numeroAsiento) {
        if (numeroAsiento >= 0 && numeroAsiento < asientos.length && !asientos[numeroAsiento]) {
            asientos[numeroAsiento] = true;
            JOptionPane.showMessageDialog(null, "Asiento:"+ (numeroAsiento+ 1)+ "reservado correctamente");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Asiento:"+ (numeroAsiento+ 1)+ "no disponible");
            return false;
        }
    }

     // Mapa de asientos: "_" libre, "X" ocupado
    public String mostrarMapaAsientos() {
        String mapa = "Mapa de Asientos (Sala " + sala.getNumero() + "):\n";
        for (int i = 0; i < asientos.length; i++) {
            mapa += (asientos[i] ? "X" : "_");
            // salto de línea cada 10 para que sea más legible (ajústalo si quieres)
            if ((i + 1) % 10 == 0) mapa += "  " + (i - 8) + "-" + (i + 1) + "\n";
        }
        // si la capacidad no cae exacta en múltiplos de 10, agrega un salto final
        if (asientos.length % 10 != 0) mapa += "\n";
        return mapa;
    }
    
    // Info
    public String mostrarFuncion() {
        return "Información de la Función:\n" +
                "Película: " + pelicula.getTitulo() + "\n" +
                "Sala: " + sala.getNumero() + "\n" +
                "Fecha: " + fecha + "\n" +
                "Hora: " + hora + "\n" +
                "Tipo: " + tipo + "\n" +
                "Idioma: " + (esDoblada ? "Doblada" : "Subtitulada");
    }
   

    // Encapsuladores
    public String getHora() {
        return hora;
    }
    public String getFecha() {
        return fecha;
    }
    public Pelicula getPelicula() {
        return pelicula;
    }
    public Sala getSala() {
        return sala;
    }
    public boolean[] getAsientos(){
        return asientos;
    }
    public boolean isEsDoblada(){
        return esDoblada;
    }
    public Tipo getTipo(){
        return tipo;
    }
    
    public void setFecha(String fecha){
        this.fecha= fecha;
    }
    public void setPelicula(Pelicula pelicula){
        this.pelicula= pelicula;
    }
    public void setSala(Sala sala){
        this.sala= sala;
        this.asientos= new boolean[sala.getCapacidad()];// reinicia los asientos a la nueva capacidad
    }
    public void setTipo(Tipo tipo){
        this.tipo= tipo;
    }
    public void setEsDoblada(boolean esDoblada){
        this.esDoblada= esDoblada;
    }
    public void setHora(String hora){
        this.hora= hora;
    }   
    
}


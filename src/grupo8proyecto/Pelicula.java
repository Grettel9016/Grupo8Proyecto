/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo8proyecto;

/**
 *
 * @author grett
 */
public class Pelicula {
    // Atributos
    private String titulo;
    private int duracion;  
    private String genero;

    // Constructores
    
    public Pelicula(){
    }
    
    public Pelicula(String titulo, int duracion, String genero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getGenero() {
        return genero;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
   
    public void mostrarFichaTecnica() {
        String ficha = "Ficha Técnica:\n" +
                       "Título: " + titulo + "\n" +
                       "Duración: " + duracion + " minutos\n" +
                       "Género: " + genero;
        System.out.println(ficha);
    }
    
}

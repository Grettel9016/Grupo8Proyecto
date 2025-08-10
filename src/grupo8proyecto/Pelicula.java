/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo8proyecto;

///**

public class Pelicula {
    // Atributos
    private String titulo;
    private int duracion;  
    private Genero genero;
    private Clasificacion clasificacion;

    // Constructores
    
    public Pelicula(){
    }
    
    public Pelicula(String titulo, int duracion, Genero genero, Clasificacion clasificacion) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.clasificacion= clasificacion;
    }
    //get
    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public Genero getGenero() {
        return genero;
    }
    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }
   
    public String mostrarFichaTecnica() {
        return "Ficha Técnica:\n" +
                "Título: " + titulo + "\n" +
                "Duración: " + duracion + " minutos\n" +
                "Género: " + genero+ "\n"+
                "Clasificacion"+ clasificacion;
    }

    
}

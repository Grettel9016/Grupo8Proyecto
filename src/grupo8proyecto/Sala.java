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
    private double capacidad;
    private Tipo tipo;
    public Funcion funcion;
    
    //contructores
    public Sala(){
        
    }
    
    public Sala(int numero,double capacidad, Tipo tipo, Funcion funcion){
        this.numero=numero;
        this.capacidad= capacidad;
        this.tipo= tipo;
        this.funcion= funcion;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public double getCapacidad(){
        return capacidad;
    }
    public Tipo getTipo(){
        return tipo;
    }
    public Funcion getFuncion(){
        return funcion;
    }  
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setCapacidad(double capacidad){
        this.capacidad= capacidad;
    }
    public void setTipo(Tipo tipo){
        this.tipo=tipo;
    }
    public void setFuncion(Funcion funcion){
        this.funcion=funcion;
    }
    public void mostraSala(){
        String infoSala= "Inforacion de la sala:" + "\n" +
                       "Numero: " + numero + "\n" +
                       "Tipo: " + tipo +"\n"+
                       "Capacidad: " + capacidad+ "\n"+
                       "Capacidad"+ capacidad;
                       
    }
    
}

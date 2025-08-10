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
    
    //contructores
    public Sala(){
        
    }
    
    public Sala(int numero,int capacidad){
        this.numero=numero;
        this.capacidad= capacidad;

    }
    
    public int getNumero() {
        return numero;
    }
    
    public int getCapacidad(){
        return capacidad;
    }
   
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setCapacidad(int capacidad){
        this.capacidad= capacidad;
    }
 
    public String mostrarSala(){
        return "Informacion de la sala: \n" +
                "Numero: " + numero + "\n" +
                "Capacidad: " + capacidad+ "asientos";
                       
    }
    
}

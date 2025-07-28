/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo8proyecto;

/**
 *
 * @author grett
 */
public class Boletos {
    private String codigo;
    private Funcion funcion;
    private Cliente cliente;
    private String asiento;
    private double precio;
    
    public Boletos (String codigo, Funcion funcion, Cliente cliente, String asiento, double precio){
        this.codigo = codigo;
        this.funcion = funcion;
        this.cliente = cliente;
        this.asiento = asiento;
        this.precio = precio;
    }
    //get
     public String getCodigo() {
        return codigo;
    }
    
    public Funcion getFuncion() {
        return funcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getAsiento() {
        return asiento;
    }

    public double getPrecio() {
        return precio;
    }
    
    // Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    // Mostrar detalle del boleto
    public String mostrarDetalleEntrada() {
        return "===== BOLETO =====\n" +
               "Código: " + codigo + "\n" +
               funcion.mostrarInfoFuncion()+ "\n" +
               cliente.mostrarInfoCliente()+ "\n" +
               "Asiento: " + asiento + "\n" +
               "Precio: ₡" + precio;
    }
    
    
}

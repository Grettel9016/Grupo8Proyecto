public class Cliente {
    private String nombre;
    private String cedula;
    private String correo;
    private int edad;

    public Cliente(String nombre, String cedula; String correo, int edad) {
        this.nombre = nombre;
        this.cedula= cedula;
        this.correo = correo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    private String getCedula(){
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }
}

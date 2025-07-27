public class Cliente {
    private String nombre;
    private String correo;

    public Cliente(String nombre, String correo) {
        this.nombre = nombre;
        setCorreo(correo);
    }

    // Verificación básica: el correo debe contener "@" y "."
    private boolean verificarCorreo(String correo) {
        return correo != null && correo.contains("@") && correo.contains(".");
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        if (verificarCorreo(correo)) {
            this.correo = correo;
        } else {
            this.correo = "correo_no_valido";
        }
    }
}

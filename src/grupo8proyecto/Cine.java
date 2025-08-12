
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo8proyecto;

/**
 *
 * @author omarv
 */
public class Cine {
    private Pelicula[] peliculas;
    private Sala[] salas;
    private Funcion[] funciones;
    private Cliente[] clientes;
    private Boletos[] boletos;

    //Contadores
    private int cantPeliculas;
    private int cantSalas;
    private int cantFunciones;
    private int cantClientes;
    private int cantBoletos;
    private int contadorCodigo;

    //Constructor
    public Cine() {
        // Capacidades fijas
        peliculas = new Pelicula[10];
        salas = new Sala[5];
        funciones = new Funcion[20];
        clientes = new Cliente[50];
        boletos = new Boletos[100];
        
        cantPeliculas = 0;
        cantSalas = 0;
        cantFunciones = 0;
        cantClientes = 0;
        cantBoletos = 0;
        contadorCodigo=0;
    }
    
    public int getCantSalas() {
        return cantSalas;
    }
    public int getCantFunciones() {
        return cantFunciones;
    }
    public int getCantClientes() {
        return cantClientes;
    }
    public int getCantBoletos() {
        return cantBoletos;
    }
    
    public int getCantidadPeliculas() {
        return cantPeliculas;
    }

    public int getCantidadSalas() {
        return cantSalas;
    }

    
    // Métodos
    
    
    public boolean agregarPelicula(Pelicula p) {
        if (p == null || cantPeliculas >= peliculas.length) {
            return false;
        }
        peliculas[cantPeliculas] = p;
        cantPeliculas++;
        return true;
    // Verificar si hay espacio disponible en el arreglo
        
    }
    
    public String listarPeliculas() {
    // Verificar si hay películas registradas
        if (cantPeliculas == 0) {
            return "No hay películas registradas.";
        }
    // Construir la lista
        String res = "=== Cartelera ===\n";

    // Recorrer el arreglo de películas
        for (int i = 0; i < cantPeliculas; i++) {
            res += (i + 1) + ") " + peliculas[i].mostrarFichaTecnica() + "\n";
        }
    // Retornar la lista como texto
        return res;
    }
    
    public int buscarPeliculaPorTitulo(String titulo) {
    // Verificar que el título no sea nulo
        if (titulo == null) {
            return -1;
        }
    // Recorrer el arreglo de películas
        for (int i = 0; i < cantPeliculas; i++) {
        // Comparar ignorando mayúsculas/minúsculas
            if (peliculas[i] != null && peliculas[i].getTitulo().equalsIgnoreCase(titulo)) {
                return i; // Devuelve el índice encontrado
            }
        }
    // Si no se encontró, devolver -1
        return -1;
    }
    // este metodo es para saber en q posicion esta la peli y luego pordela seleccionar
    public Pelicula getPelicula(int indice) {  
    // Validar que el índice esté en el rango correcto
        if (indice >= 0 && indice < cantPeliculas) {
            return peliculas[indice];
        }
         return null; // Si no está en el rango, devolver null
    }
    
    public boolean agregarSala(Sala s) {
        if (s == null) {
            return false;
        }
        if (cantSalas >= salas.length) {
            return false; // No hay más espacio
        }
        salas[cantSalas] = s;
        cantSalas++;
        return true;
    }

    public String listarSalas() {
        if (cantSalas == 0) {
            return "No hay salas registradas.";
        }
        String res = "=== Salas ===\n";
        for (int i = 0; i < cantSalas; i++) {
            res += (i + 1) + ") " + salas[i].mostrarSala() + "\n";
        }
        return res;
    }

    public int buscarSalaPorNumero(int numero) {
        for (int i = 0; i < cantSalas; i++) {
            if (salas[i] != null && salas[i].getNumero() == numero) {
                return i; // Devuelve el índice encontrado
            }
        }
        return -1;// Si no se encontró, devolver -1
    }
    public Sala getSala(int indice) {
        if (indice >= 0 && indice < cantSalas) {
            return salas[indice];
        }
        return null;
    }
    public boolean agregarFuncion(Funcion f) {
        if (f == null) {
            return false;
        }
        if (cantFunciones >= funciones.length) {
            return false; // No hay más espacio
        }
        funciones[cantFunciones] = f;
        cantFunciones++;
        return true;
    }

    public String listarFunciones() {
        if (cantFunciones == 0) {
            return "No hay funciones registradas.";
        }
        String res = "=== Funciones ===\n";
        for (int i = 0; i < cantFunciones; i++) {
            res += (i + 1) + ") " + funciones[i].mostrarFuncion() + "\n";
        }
        return res;
    }

    public String listarFuncionesPorTitulo(String titulo) {
        if (titulo == null || cantFunciones == 0) {
            return "No hay funciones registradas.";
        }
        String res = "=== Funciones para: " + titulo + " ===\n";
        boolean encontrado = false;
        for (int i = 0; i < cantFunciones; i++) {
            Funcion f = funciones[i];
            if (f != null && f.getPelicula() != null) {
                String t = f.getPelicula().getTitulo();
                if (t != null && t.equalsIgnoreCase(titulo)) {
                    res += (i + 1) + ") " + f.mostrarFuncion() + "\n";
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            return "No hay funciones para esa película.";
        }
        return res;
    }

    public Funcion getFuncion(int indice) {
        if (indice >= 0 && indice < cantFunciones) {
            return funciones[indice];
        }
        return null;
    }
    public boolean agregarBoleto(Boletos b) {
        if (b == null) {
            return false;
        }
        if (cantBoletos >= boletos.length) {
            return false; // No hay más espacio
        }
        boletos[cantBoletos] = b;
        cantBoletos++;
        return true;
    }
    public String listarBoletos() {
        if (cantBoletos == 0) {
            return "No hay boletos emitidos.";
        }
        String res = "=== Boletos ===\n";
        for (int i = 0; i < cantBoletos; i++) {
            res += (i + 1) + ") " + boletos[i].mostrarDetalleEntrada() + "\n";
        }
        return res;
    }
    public int buscarBoletoPorCodigo(String codigo) {
        if (codigo == null) {
            return -1;
        }
        for (int i = 0; i < cantBoletos; i++) {
            if (boletos[i] != null &&
                boletos[i].getCodigo() != null &&
                boletos[i].getCodigo().trim().equalsIgnoreCase(codigo.trim())) {
                return i; // índice 0-based
            }
        }
        return -1;
    }
    public Boletos getBoleto(int indice) {
        if (indice >= 0 && indice < cantBoletos) {
            return boletos[indice];
        }
        return null;
    }
    
    //Validación de clasificación por edad 

    private boolean cumpleClasificacion(Cliente cliente, Pelicula pelicula) {
        // Verificar nulos
        if (cliente == null) {
            return false;
        }
        if (pelicula == null) {
            return false;
        }
        if (pelicula.getClasificacion() == null) {
            return false;
        }

        // Obtener edad del cliente
        int edadCliente = cliente.getEdad();

        // Determinar edad mínima según clasificación
        int edadMinima = edadMinimaPorClasificacion(pelicula.getClasificacion());

        // Comparar edad del cliente contra la edad mínima
        if (edadCliente >= edadMinima) {
            return true;
        } else {
            return false;
        }
    }

    int edadMinimaPorClasificacion(Clasificacion clasif) {
        switch (clasif) {
            case TP:
                return 0;
            case TP12:
                return 12;
            case M15:
                return 15;
            default:
                return 18;
        }
    }
    private String generarCodigoBoleto() {
        contadorCodigo++; // aumenta en 1
        return "BOL-" + contadorCodigo; // genera el código
    }
    
    //reservar asiento y emitir boleto 
    public Boletos confirmarCompra(int indiceFuncion, int asiento1Based, int indiceCliente, double precio) {
    // Validar índice de función
    if (indiceFuncion < 0 || indiceFuncion >= cantFunciones) {
        return null;
    }

    // Validar índice de cliente
    if (indiceCliente < 0 || indiceCliente >= cantClientes) {
        return null;
    }

    // Obtener función y cliente
    Funcion f = funciones[indiceFuncion];
    Cliente c = clientes[indiceCliente];

    // Validar nulos
    if (f == null) {
        return null;
    }
    if (c == null) {
        return null;
    }

    // Validar clasificación/edad ANTES de reservar asiento
    Pelicula peli = f.getPelicula();
    if (!cumpleClasificacion(c, peli)) {
        // Si no cumple, no continuar con la compra
        return null;
    }

    // Validar asiento (1..capacidad)
    int capacidad = f.getSala().getCapacidad();
    if (asiento1Based < 1 || asiento1Based > capacidad) {
        return null;
    }

    // Convertir a 0-based
    int asiento0 = asiento1Based - 1;

    // Verificar disponibilidad y reservar
    if (!f.asientoDisponible(asiento0)) {
        return null;
    }
    boolean reservado = f.reservarAsiento(asiento0);
    if (!reservado) {
        return null;
    }

    // Verificar espacio en arreglo de boletos
    if (cantBoletos >= boletos.length) {
        return null;
    }

    // Generar código
    String codigo = generarCodigoBoleto();

    // Crear y almacenar boleto
    Boletos nuevo = new Boletos(codigo, f, c, asiento0, precio);
    boletos[cantBoletos] = nuevo;
    cantBoletos++;

    // Devolver boleto emitido
    return nuevo;
    }
    
    public double obtenerPrecioUnitario(int indiceFuncion) {
        Funcion f = getFuncion(indiceFuncion);
        if (f == null) return 0;
        switch (f.getTipo()) {
            case Sala2D:  return 3500;
            case SalaVIP: return 5000;
            default:      return 4000;
        }
    }
    
    public boolean agregarCliente(Cliente c) {
    // Verificar si el objeto es nulo
    if (c == null) {
        return false;
    }
    // Verificar si hay espacio disponible en el arreglo
    if (cantClientes >= clientes.length) {
        return false; // No hay más espacio
    }
    // Guardar el cliente en la posición libre
    clientes[cantClientes] = c;

    // Aumentar el contador de clientes
    cantClientes++;

    // Devolver true indicando que se agregó con éxito
    return true;
    }

    public String listarClientes() {
        // Verificar si hay clientes registrados
        if (cantClientes == 0) {
            return "No hay clientes registrados.";
        }

    // Construir la lista
    String res = "=== Clientes ===\n";

    // Recorrer el arreglo de clientes (solo posiciones usadas)
    for (int i = 0; i < cantClientes; i++) {
        res += (i + 1) + ") " + clientes[i].mostrarCliente() + "\n";
    }

    // Retornar la lista como texto
    return res;
}

    public int buscarClientePorCedula(String cedula) {
        // Verificar que la cédula no sea nula
        if (cedula == null) {
            return -1;
        }

    // Recorrer el arreglo de clientes (solo posiciones usadas)
    for (int i = 0; i < cantClientes; i++) {
        // Comparar ignorando espacios y mayúsculas/minúsculas
        if (clientes[i] != null &&
            clientes[i].getCedula() != null &&
            clientes[i].getCedula().trim().equalsIgnoreCase(cedula.trim())) {
            return i; // índice 0-based
        }
    }

    // Si no se encontró, devolver -1
    return -1;
}

    public Cliente getCliente(int indice) {
        // Validar que el índice esté en el rango correcto
        if (indice >= 0 && indice < cantClientes) {
            return clientes[indice];
        }

        // Si no está en el rango, devolver null
        return null;
    }


}




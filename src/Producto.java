import java.util.ArrayList;

public class Producto {
    private int id; // identificador único
    private String nombre; // ej: "Leche", "Carne de res", "Refresco", etc.
    private double precio; // en dólares
    private String categoria; // ej: "Lácteos", "Carnes", "Bebidas", etc.
    private String fechaVencimiento; // formato "YYYY-MM-DD", puede ser null si no aplica
    private int cantidad; // cantidad en inventario
    private ArrayList<String> listaImagenes; // rutas de imágenes asociadas al producto

    public Producto(int id, String nombre, double precio, String categoria, String fechaVencimiento, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.fechaVencimiento = fechaVencimiento;
        this.cantidad = cantidad;
        this.listaImagenes = new ArrayList<>();
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public String getCategoria() {
        return categoria;
    }
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
    public int getCantidad() {
        return cantidad;
    }
    public ArrayList<String> getListaImagenes() {
        return listaImagenes;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Producto" +
                "id: " + id +
                ", nombre: '" + nombre + '\'' +
                ", precio: " + precio +
                ", categoria: '" + categoria + '\'' +
                ", fechaVencimiento: '" + fechaVencimiento + '\'' +
                ", cantidad: " + cantidad +
                ", listaImagenes: " + listaImagenes;
    }
}
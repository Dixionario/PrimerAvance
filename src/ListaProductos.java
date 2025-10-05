public class ListaProductos {
    private Nodo cabeza;

    public ListaProductos() {
        this.cabeza = null;
    }

    public Nodo getCabeza() { // Getter para la cabeza de la lista
        return cabeza;
    }

    // Inserta un producto al inicio de la lista
    public void insertarAlInicio(Producto p) {
        Nodo nuevoNodo = new Nodo(p);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        System.out.println("Producto '" + p.getNombre() + "' insertado al inicio.");
    }

    // Inserta un producto al final de la lista
    public void insertarAlFinal(Producto p) {
        Nodo nuevoNodo = new Nodo(p);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        System.out.println("Producto '" + p.getNombre() + "' insertado al final.");
    }

    // Modifica un producto buscándolo por id
    public boolean modificarProducto(int id, Producto nuevoProducto) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.getId() == id) {
                actual.dato.setNombre(nuevoProducto.getNombre());
                actual.dato.setPrecio(nuevoProducto.getPrecio());
                actual.dato.setCategoria(nuevoProducto.getCategoria());
                actual.dato.setFechaVencimiento(nuevoProducto.getFechaVencimiento());
                actual.dato.setCantidad(nuevoProducto.getCantidad());
                System.out.println("Producto con ID " + id + " modificado.");
                return true;
            }
            actual = actual.siguiente;
        }
        System.out.println("Producto con ID " + id + " no encontrado. No se realizó ninguna modificación.");
        return false;
    }

    // Añade una ruta de imagen a un producto (buscado por nombre)
    public boolean agregarImagenAProducto(String nombre, String rutaImagen) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.getNombre().equals(nombre)) {
                actual.dato.getListaImagenes().add(rutaImagen);
                System.out.println("Imagen '" + rutaImagen + "' añadida al producto '" + nombre + "'.");
                return true;
            }
            actual = actual.siguiente;
        }
        System.out.println("Producto '" + nombre + "' no encontrado. No se añadió la imagen.");
        return false;
    }

    // Genera e imprime el reporte de costos
    public void generarReporteCostos() {
        if (cabeza == null) {
            System.out.println("La lista de productos está vacía.");
            return;
        }

        System.out.println("\n=== REPORTE DE COSTOS ===");
        double totalAcumulado = 0.0;

        Nodo actual = cabeza;
        while (actual != null) {
            Producto p = actual.dato;
            double costoProducto = p.getPrecio() * p.getCantidad();
            totalAcumulado += costoProducto;

            System.out.printf("ID: %d | Nombre: %s | Precio Unitario: $%.2f | Cantidad: %d | Costo Total: $%.2f%n",
                    p.getId(), p.getNombre(), p.getPrecio(), p.getCantidad(), costoProducto);

            actual = actual.siguiente;
        }

        System.out.printf("Costo total acumulado de la lista: $%.2f%n", totalAcumulado);
        System.out.println("==========================\n");
    }

    // Muestra todos los productos en la lista
    public void mostrarTodos() {
        if (cabeza == null) {
            System.out.println("Lista vacía.");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}

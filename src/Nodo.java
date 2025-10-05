public class Nodo {
    Producto dato; // dato del nodo (un producto)
    Nodo siguiente; // referencia al siguiente nodo

    public Nodo(Producto dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

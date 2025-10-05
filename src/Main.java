import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        ListaProductos lista = new ListaProductos();
        int opcion;

        do {
            System.out.println("\n=== MENÚ - GESTIÓN DE PRODUCTOS ===");
            System.out.println("1. Insertar producto al inicio");
            System.out.println("2. Insertar producto al final");
            System.out.println("3. Modificar producto");
            System.out.println("4. Agregar imagen a un producto");
            System.out.println("5. Generar reporte de costos");
            System.out.println("6. mostrar productos");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar el buffer

            switch (opcion) {
                case 1:
                case 2:
                    System.out.print("id: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // limpiar el buffer después de nextInt()
                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio $: ");
                    double precio = sc.nextDouble();
                    sc.nextLine(); // limpiar
                    System.out.print("Categoría: ");
                    String categoria = sc.nextLine();
                    System.out.print("Fecha de vencimiento (deja vacío si no aplica): ");
                    String fv = sc.nextLine(); //fv = fecha de vencimiento
                    if (fv.isEmpty()) fv = null; // manejar sin fecha
                    System.out.print("Cantidad en inventario: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    Producto p = new Producto(id, nombre, precio, categoria, fv, cantidad);
                    if (opcion == 1) {
                        lista.insertarAlInicio(p); //p = producto
                    } else {
                        lista.insertarAlFinal(p);
                    }
                    break;

                case 3:
                    System.out.print("id del producto a modificar: ");
                    int idMod = sc.nextInt();

                    // Buscar el producto por nombre para obtener su id
                    Nodo actual = lista.getCabeza();
                    while (actual != null) {
                        if (actual.dato.getNombre().equals(idMod)) {
                            idMod = actual.dato.getId();
                            break;
                        }
                        actual = actual.siguiente;
                    }
                    if (idMod == -1) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }

                    // Pedir los nuevos datos
                    sc.nextLine(); // limpiar el buffer después de nextInt()
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo precio $: ");
                    double nuevoPrecio = sc.nextDouble();
                    sc.nextLine(); // limpiar despues de nextDouble()
                    System.out.print("Nueva categoría: ");
                    String nuevaCat = sc.nextLine();
                    System.out.print("Nueva fecha de vencimiento (vacío = sin fecha): ");
                    String nuevaFv = sc.nextLine();
                    if (nuevaFv.isEmpty()) nuevaFv = null;
                    System.out.print("Nueva cantidad: ");
                    int nuevaCant = sc.nextInt();

                    Producto nuevoProducto = new Producto(idMod, nuevoNombre, nuevoPrecio, nuevaCat, nuevaFv, nuevaCant);
                    lista.modificarProducto(idMod, nuevoProducto); // idMod = id a modificar
                    break;

                case 4:
                    System.out.print("Nombre del producto al que añadir imagen: ");
                    String nomImg = sc.nextLine();
                    System.out.print("Ruta de la imagen (ej: imagenes/leche.jpg): ");
                    String ruta = sc.nextLine();
                    lista.agregarImagenAProducto(nomImg, ruta);
                    break;

                case 5:
                    lista.generarReporteCostos();
                    break;

                case 6:
                    lista.mostrarTodos();
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 7);

        sc.close();
    }
}
import java.util.Scanner;

class Nodo {
    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

public class ArbolBinarioBusqueda {
    Nodo raiz;

    // --- MÉTODOS LÓGICOS ---
    public void insertar(int valor) { raiz = insertarRec(raiz, valor); }
    private Nodo insertarRec(Nodo raiz, int valor) {
        if (raiz == null) return new Nodo(valor);
        if (valor < raiz.valor) raiz.izquierdo = insertarRec(raiz.izquierdo, valor);
        else if (valor > raiz.valor) raiz.derecho = insertarRec(raiz.derecho, valor);
        return raiz;
    }

    public boolean buscar(int valor) { return buscarRec(raiz, valor); }
    private boolean buscarRec(Nodo raiz, int valor) {
        if (raiz == null) return false;
        if (raiz.valor == valor) return true;
        return valor < raiz.valor ? buscarRec(raiz.izquierdo, valor) : buscarRec(raiz.derecho, valor);
    }

// Método público: Es el que llamamos desde el menú. 
    // Inicia la recursividad desde la raíz y actualiza la raíz con el resultado.
    public void eliminar(int valor) { 
        raiz = eliminarRec(raiz, valor); 
    }

    // Método privado recursivo: Es el "corazón" de la lógica de eliminación.
    private Nodo eliminarRec(Nodo raiz, int valor) {
        // CASO BASE: Si llegamos a un nodo nulo, el valor no existe en el árbol.
        if (raiz == null) return null;

        // FASE DE BÚSQUEDA: Navegamos por el árbol comparando valores.
        if (valor < raiz.valor) {
            // Si el valor es menor, buscamos por la izquierda.
            raiz.izquierdo = eliminarRec(raiz.izquierdo, valor);
        } 
        else if (valor > raiz.valor) {
            // Si el valor es mayor, buscamos por la derecha.
            raiz.derecho = eliminarRec(raiz.derecho, valor);
        } 
        else {
            // ¡NODO ENCONTRADO! Aquí aplicamos los 3 casos de la guía:

            // CASO 1 y 2: El nodo tiene 0 hijos (hoja) o solo 1 hijo.
            // Si no tiene hijo izquierdo, devolvemos el derecho (que puede ser nulo o un nodo).
            if (raiz.izquierdo == null) 
                return raiz.derecho;
            
            // Si no tiene hijo derecho, devolvemos el izquierdo.
            else if (raiz.derecho == null) 
                return raiz.izquierdo;

            // CASO 3: El nodo tiene 2 hijos.
            // No podemos simplemente borrarlo. Necesitamos un sustituto.
            
            // 1. Buscamos el "Sucesor In-Order": el valor más pequeño del subárbol derecho.
            raiz.valor = encontrarMin(raiz.derecho);

            // 2. Copiamos ese valor mínimo a este nodo (el que queremos "eliminar").
            // 3. Ahora eliminamos físicamente el nodo sucesor original en el subárbol derecho.
            raiz.derecho = eliminarRec(raiz.derecho, raiz.valor);
        }

        // Devolvemos la raíz (actualizada) para reconstruir los enlaces del árbol.
        return raiz;
    }

    private int encontrarMin(Nodo raiz) {
        int min = raiz.valor;
        while (raiz.izquierdo != null) {
            min = raiz.izquierdo.valor;
            raiz = raiz.izquierdo;
        }
        return min;
    }

    // --- RECORRIDOS ---
    public void inOrder(Nodo n) { if (n != null) { inOrder(n.izquierdo); System.out.print(n.valor + " "); inOrder(n.derecho); } }
    public void preOrder(Nodo n) { if (n != null) { System.out.print(n.valor + " "); preOrder(n.izquierdo); preOrder(n.derecho); } }
    public void postOrder(Nodo n) { if (n != null) { postOrder(n.izquierdo); postOrder(n.derecho); System.out.print(n.valor + " "); } }

    // --- VISUALIZACIÓN GRÁFICA EN CONSOLA ---
    public void mostrarArbol(Nodo nodo, int espacio) {
        if (nodo == null) return;
        espacio += 10;
        mostrarArbol(nodo.derecho, espacio);
        System.out.println();
        for (int i = 10; i < espacio; i++) System.out.print(" ");
        System.out.println(nodo.valor);
        mostrarArbol(nodo.izquierdo, espacio);
    }

    // --- MENÚ PRINCIPAL ---
    public static void main(String[] args) {
        ArbolBinarioBusqueda bst = new ArbolBinarioBusqueda();
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n========= MENÚ ÁRBOL BINARIO (Examen Final) =========");
            System.out.println("1. Insertar Nodos (Múltiples)");
            System.out.println("2. Buscar Nodo");
            System.out.println("3. Eliminar Nodo");
            System.out.println("4. Ver Recorridos (In, Pre, Post)");
            System.out.println("5. Ver Estructura del Árbol (Gráfica)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese los valores separados por espacios o comas: ");
                    String input = sc.nextLine();
                    // Separar por espacios o comas
                    String[] partes = input.split("[,\\s]+");
                    for (String p : partes) {
                        try {
                            int val = Integer.parseInt(p.trim());
                            bst.insertar(val);
                            System.out.println("-> " + val + " insertado.");
                        } catch (NumberFormatException e) {
                            System.out.println("! '" + p + "' no es un número válido.");
                        }
                    }
                    break;
                case "2":
                    System.out.print("Ingrese valor a buscar: ");
                    int bVal = Integer.parseInt(sc.nextLine());
                    System.out.println("¿Existe " + bVal + "?: " + bst.buscar(bVal));
                    break;
                case "3":
                    System.out.print("Ingrese valor a eliminar: ");
                    int eVal = Integer.parseInt(sc.nextLine());
                    bst.eliminar(eVal);
                    System.out.println("Proceso de eliminación completado para: " + eVal);
                    break;
                case "4":
                    System.out.print("\nIn-Order: "); bst.inOrder(bst.raiz);
                    System.out.print("\nPre-Order: "); bst.preOrder(bst.raiz);
                    System.out.print("\nPost-Order: "); bst.postOrder(bst.raiz);
                    System.out.println();
                    break;
                case "5":
                    System.out.println("\nEstructura actual del árbol (rotada 90°):");
                    if (bst.raiz == null) System.out.println("[Árbol Vacío]");
                    else bst.mostrarArbol(bst.raiz, 0);
                    break;
            }
        } while (!opcion.equals("6"));
        System.out.println("Saliendo del programa...");
        sc.close();
    }
}
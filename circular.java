class Elemento<T> {
    T contenido;
    Elemento<T> siguiente;

    public Elemento(T valor) {
        this.contenido = valor;
        this.siguiente = null;
    }
}

class CicloEncadenado<T> {
    private Elemento<T> puntero;

    public void insertar(T dato) {
        Elemento<T> nuevo = new Elemento<>(dato);
        if (puntero == null) {
            puntero = nuevo;
            puntero.siguiente = puntero;
        } else {
            Elemento<T> temporal = puntero;
            while (temporal.siguiente != puntero) {
                temporal = temporal.siguiente;
            }
            temporal.siguiente = nuevo;
            nuevo.siguiente = puntero;
        }
    }

    public void eliminar(T objetivo) {
        if (puntero == null) return;

        Elemento<T> actual = puntero;
        Elemento<T> anterior = null;

        do {
            if (actual.contenido.equals(objetivo)) {
                if (anterior == null) {
                    Elemento<T> temp = puntero;
                    while (temp.siguiente != puntero) {
                        temp = temp.siguiente;
                    }
                    if (puntero == puntero.siguiente) {
                        puntero = null;
                    } else {
                        temp.siguiente = puntero.siguiente;
                        puntero = puntero.siguiente;
                    }
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != puntero);
    }

    public void mostrar() {
        if (puntero == null) {
            System.out.println("📭 Lista vacía");
            return;
        }
        Elemento<T> actual = puntero;
        do {
            System.out.print("🔹 " + actual.contenido + " ");
            actual = actual.siguiente;
        } while (actual != puntero);
        System.out.println();
    }

    public int contar() {
        if (puntero == null) return 0;
        int contador = 0;
        Elemento<T> temp = puntero;
        do {
            contador++;
            temp = temp.siguiente;
        } while (temp != puntero);
        return contador;
    }

    public boolean buscar(T valor) {
        if (puntero == null) return false;
        Elemento<T> actual = puntero;
        do {
            if (actual.contenido.equals(valor)) return true;
            actual = actual.siguiente;
        } while (actual != puntero);
        return false;
    }
}

public class ListaCircular {
    public static void main(String[] args) {
        CicloEncadenado<String> ciclo = new CicloEncadenado<>();

        ciclo.insertar("Sol");
        ciclo.insertar("Luna");
        ciclo.insertar("Estrella");

        ciclo.mostrar();

        System.out.println("🔍 ¿Está 'Luna'? " + ciclo.buscar("Luna"));
        System.out.println("🔢 Total elementos: " + ciclo.contar());

        ciclo.eliminar("Luna");

        ciclo.mostrar();
        System.out.println("🔍 ¿Está 'Luna'? " + ciclo.buscar("Luna"));
    }
}

class NodoGemelo {
    int componente;
    NodoGemelo siguiente, anterior;

    public NodoGemelo(int valor) {
        componente = valor;
        siguiente = anterior = null;
    }
}

class DuplicadoPurgador {
    NodoGemelo cabeza;

    public void introducir(int elemento) {
        NodoGemelo recien = new NodoGemelo(elemento);
        if (cabeza == null) {
            cabeza = recien;
        } else {
            NodoGemelo p = cabeza;
            while (p.siguiente != null) {
                p = p.siguiente;
            }
            p.siguiente = recien;
            recien.anterior = p;
        }
    }

    public void visualizar() {
        NodoGemelo x = cabeza;
        System.out.print("🧾 Lista: ");
        while (x != null) {
            System.out.print(x.componente + " ");
            x = x.siguiente;
        }
        System.out.println();
    }

    public void quitarDuplicados() {
        NodoGemelo base = cabeza;
        while (base != null) {
            NodoGemelo corredor = base.siguiente;
            while (corredor != null) {
                if (base.componente == corredor.componente) {
                    if (corredor.anterior != null) {
                        corredor.anterior.siguiente = corredor.siguiente;
                    }
                    if (corredor.siguiente != null) {
                        corredor.siguiente.anterior = corredor.anterior;
                    }
                }
                corredor = corredor.siguiente;
            }
            base = base.siguiente;
        }
    }
}

public class ejercicio04 {
    public static void main(String[] args) {
        DuplicadoPurgador trama = new DuplicadoPurgador();
        trama.introducir(2);
        trama.introducir(3);
        trama.introducir(2);
        trama.introducir(5);
        trama.introducir(3);

        trama.visualizar();
        trama.quitarDuplicados();
        System.out.print("🧹 Sin duplicados: ");
        trama.visualizar();
    }
}


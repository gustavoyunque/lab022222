class NodoBidireccional {
    int simbolo;
    NodoBidireccional izquierdo, derecho;

    public NodoBidireccional(int pieza) {
        simbolo = pieza;
        izquierdo = derecho = null;
    }
}

class EsqueletoDoble {
    private NodoBidireccional raiz = null;

    public void anexarInicio(int dato) {
        NodoBidireccional brote = new NodoBidireccional(dato);
        if (raiz == null) {
            raiz = brote;
        } else {
            brote.derecho = raiz;
            raiz.izquierdo = brote;
            raiz = brote;
        }
    }

    public void anexarFinal(int dato) {
        NodoBidireccional brote = new NodoBidireccional(dato);
        if (raiz == null) {
            raiz = brote;
        } else {
            NodoBidireccional cursor = raiz;
            while (cursor.derecho != null) {
                cursor = cursor.derecho;
            }
            cursor.derecho = brote;
            brote.izquierdo = cursor;
        }
    }

    public void recorrerDesdeInicio() {
        NodoBidireccional pivote = raiz;
        System.out.print("➡️ Orden normal: ");
        while (pivote != null) {
            System.out.print(pivote.simbolo + " ");
            if (pivote.derecho == null) break;
            pivote = pivote.derecho;
        }
        System.out.println();
    }

    public void recorrerDesdeFinal() {
        NodoBidireccional pivote = raiz;
        if (pivote == null) return;

        while (pivote.derecho != null) {
            pivote = pivote.derecho;
        }

        System.out.print("⬅️ Orden reverso: ");
        while (pivote != null) {
            System.out.print(pivote.simbolo + " ");
            pivote = pivote.izquierdo;
        }
        System.out.println();
    }
}

public class ejercicio01 {
    public static void main(String[] args) {
        EsqueletoDoble cadena = new EsqueletoDoble();
        cadena.anexarInicio(9);
        cadena.anexarFinal(2);
        cadena.anexarInicio(4);
        cadena.anexarFinal(7);

        cadena.recorrerDesdeInicio();
        cadena.recorrerDesdeFinal();
    }
}

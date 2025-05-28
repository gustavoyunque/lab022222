class NodoInvertido {
    int huella;
    NodoInvertido previo, proximo;

    public NodoInvertido(int cifra) {
        huella = cifra;
        previo = proximo = null;
    }
}

class EnlaceReversible {
    NodoInvertido principio;

    public void añadir(int carga) {
        NodoInvertido brote = new NodoInvertido(carga);
        if (principio == null) {
            principio = brote;
        } else {
            NodoInvertido caminante = principio;
            while (caminante.proximo != null) {
                caminante = caminante.proximo;
            }
            caminante.proximo = brote;
            brote.previo = caminante;
        }
    }

    public void mostrar() {
        NodoInvertido paso = principio;
        System.out.print("🔸 Lista directa: ");
        while (paso != null) {
            System.out.print(paso.huella + " ");
            paso = paso.proximo;
        }
        System.out.println();
    }

    public void invertir() {
        NodoInvertido actual = principio, auxiliar = null;

        while (actual != null) {
            auxiliar = actual.previo;
            actual.previo = actual.proximo;
            actual.proximo = auxiliar;
            actual = actual.previo;
        }

        if (auxiliar != null) {
            principio = auxiliar.previo;
        }
    }
}

public class ejercicio03 {
    public static void main(String[] args) {
        EnlaceReversible grupo = new EnlaceReversible();
        grupo.añadir(1);
        grupo.añadir(2);
        grupo.añadir(3);
        grupo.añadir(4);

        grupo.mostrar();
        grupo.invertir();
        System.out.print("🔁 Lista invertida: ");
        grupo.mostrar();
    }
}

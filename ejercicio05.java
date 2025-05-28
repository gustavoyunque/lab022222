class NodoClasificado {
    int registro;
    NodoClasificado adelante, atras;

    public NodoClasificado(int cifra) {
        registro = cifra;
        adelante = atras = null;
    }
}

class OrdenadorDeInserciones {
    NodoClasificado cabecera;

    public void insertarOrdenado(int dato) {
        NodoClasificado nodoNuevo = new NodoClasificado(dato);

        if (cabecera == null || dato < cabecera.registro) {
            nodoNuevo.adelante = cabecera;
            if (cabecera != null) cabecera.atras = nodoNuevo;
            cabecera = nodoNuevo;
        } else {
            NodoClasificado actual = cabecera;
            while (actual.adelante != null && actual.adelante.registro < dato) {
                actual = actual.adelante;
            }

            nodoNuevo.adelante = actual.adelante;
            if (actual.adelante != null) actual.adelante.atras = nodoNuevo;
            actual.adelante = nodoNuevo;
            nodoNuevo.atras = actual;
        }
    }

    public void mostrar() {
        NodoClasificado paso = cabecera;
        System.out.print("📈 Lista ordenada: ");
        while (paso != null) {
            System.out.print(paso.registro + " ");
            paso = paso.adelante;
        }
        System.out.println();
    }
}

public class InsercionOrdenada {
    public static void main(String[] args) {
        OrdenadorDeInserciones lista = new OrdenadorDeInserciones();
        int[] datos = {4, 1, 3, 2};
        for (int x : datos) {
            lista.insertarOrdenado(x);
        }
        lista.mostrar();
    }
}

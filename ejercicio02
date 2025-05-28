import java.util.Scanner;

class NodoEntrelazado {
    int datoNucleo;
    NodoEntrelazado alFrente, haciaAtras;

    public NodoEntrelazado(int contenido) {
        datoNucleo = contenido;
        alFrente = haciaAtras = null;
    }
}

class CadenaManipulable {
    private NodoEntrelazado origen;

    public void insertarFinal(int valor) {
        NodoEntrelazado nuevoNodo = new NodoEntrelazado(valor);
        if (origen == null) {
            origen = nuevoNodo;
        } else {
            NodoEntrelazado cursor = origen;
            while (cursor.alFrente != null) {
                cursor = cursor.alFrente;
            }
            cursor.alFrente = nuevoNodo;
            nuevoNodo.haciaAtras = cursor;
        }
    }

    public void visualizar() {
        NodoEntrelazado paso = origen;
        System.out.print("📋 Lista actual: ");
        while (paso != null) {
            System.out.print(paso.datoNucleo + " ");
            paso = paso.alFrente;
        }
        System.out.println();
    }

    public void eliminarPorValor(int objetivo) {
        if (origen == null) return;

        NodoEntrelazado punto = origen;
        while (punto != null && punto.datoNucleo != objetivo) {
            punto = punto.alFrente;
        }

        if (punto == null) return;

        if (punto.haciaAtras != null) punto.haciaAtras.alFrente = punto.alFrente;
        else origen = punto.alFrente;

        if (punto.alFrente != null) punto.alFrente.haciaAtras = punto.haciaAtras;
    }

    public void eliminarPorPosicion(int lugar) {
        if (origen == null || lugar < 0) return;

        NodoEntrelazado explorador = origen;
        int índice = 0;

        while (explorador != null && índice < lugar) {
            explorador = explorador.alFrente;
            índice++;
        }

        if (explorador == null) return;

        if (explorador.haciaAtras != null) explorador.haciaAtras.alFrente = explorador.alFrente;
        else origen = explorador.alFrente;

        if (explorador.alFrente != null) explorador.alFrente.haciaAtras = explorador.haciaAtras;
    }

    public void eliminarPrimero() {
        if (origen == null) return;
        origen = origen.alFrente;
        if (origen != null) origen.haciaAtras = null;
    }

    public void eliminarUltimo() {
        if (origen == null) return;

        NodoEntrelazado paso = origen;
        while (paso.alFrente != null) {
            paso = paso.alFrente;
        }

        if (paso.haciaAtras != null) paso.haciaAtras.alFrente = null;
        else origen = null;
    }
}

public class ejercicio02 {
    public static void main(String[] args) {
        CadenaManipulable hilera = new CadenaManipulable();
        Scanner teclado = new Scanner(System.in);

        System.out.print("🧮 ¿Cuántos elementos desea insertar? ");
        int cantidad = teclado.nextInt();

        for (int i = 0; i < cantidad; i++) {
            System.out.print("🔹 Valor " + (i + 1) + ": ");
            hilera.insertarFinal(teclado.nextInt());
        }

        hilera.visualizar();

        System.out.print("🗑️ Valor a eliminar: ");
        hilera.eliminarPorValor(teclado.nextInt());
        hilera.visualizar();

        System.out.print("📍 Posición a eliminar: ");
        hilera.eliminarPorPosicion(teclado.nextInt());
        hilera.visualizar();

        System.out.println("⏱️ Eliminando primero y último...");
        hilera.eliminarPrimero();
        hilera.eliminarUltimo();
        hilera.visualizar();

        teclado.close();
    }
}

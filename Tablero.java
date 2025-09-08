// Luis Eduardo Gutierrez Oliva
//  POO SEC 10
// JUEGO DE MEMORIA
import java.util.Random;

public class Tablero {
    private Ficha[][] fichas;
    private int filas;
    private int columnas;
    private int paresRestantes;

    private String[] simbolosDisponibles = {"@", "#", "$", "%", "&", "?", "!", "+"};

    public Tablero(int filas, int columnas) { // Constructor del tablero
        this.filas = filas;
        this.columnas = columnas;
        this.fichas = new Ficha[filas][columnas];
        inicializarTablero();
    }

    private void inicializarTablero() {
        int total = filas * columnas;
        paresRestantes = total / 2;
        String[] simbolos = new String[total];

        // llenar array con pares
        for (int i = 0; i < total / 2; i++) {
            simbolos[i * 2] = simbolosDisponibles[i];
            simbolos[i * 2 + 1] = simbolosDisponibles[i];
        }

        // mezclar
        Random rand = new Random();
        for (int i = 0; i < simbolos.length; i++) {
            int j = rand.nextInt(simbolos.length);
            String temp = simbolos[i];
            simbolos[i] = simbolos[j];
            simbolos[j] = temp;
        }

        // colocar en tablero
        int k = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                fichas[i][j] = new Ficha(simbolos[k]);
                k++;
            }
        }
    }

    public Ficha getFicha(int fila, int columna) {
        return fichas[fila][columna];
    }

    public void mostrarTablero() { // Método para mostrar el tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(fichas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean quedanPares() {
        return paresRestantes > 0;
    }

    public void restarPar() {
        paresRestantes--;
    }
}


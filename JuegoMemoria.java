// Luis Eduardo Gutierrez Oliva
//  POO SEC 10
// JUEGO DE MEMORIA
import java.util.Scanner;

public class JuegoMemoria {
    private Tablero tablero;
    private Jugador[] jugadores;
    private int turnoActual;

    public JuegoMemoria(int filas, int columnas, String nombre1, String nombre2) {
        tablero = new Tablero(filas, columnas);
        jugadores = new Jugador[2];
        jugadores[0] = new Jugador(nombre1);
        jugadores[1] = new Jugador(nombre2);
        turnoActual = 0;
    }

    public void iniciarJuego() { // Método para iniciar el juego
        Scanner sc = new Scanner(System.in);

        while (tablero.quedanPares()) {
            System.out.println("\nLe toca a: " + jugadores[turnoActual].getNombre());
            tablero.mostrarTablero();

            System.out.print("Ingresa fila de la primera ficha: ");
            int f1 = sc.nextInt();
            System.out.print("Ingresa columna de la primera ficha: ");
            int c1 = sc.nextInt();

            Ficha ficha1 = tablero.getFicha(f1, c1);
            ficha1.mostrar();
            tablero.mostrarTablero();

            System.out.print("Ingresa fila de la segunda ficha: ");
            int f2 = sc.nextInt();
            System.out.print("Ingresa columna de la segunda ficha: ");
            int c2 = sc.nextInt();

            Ficha ficha2 = tablero.getFicha(f2, c2);
            ficha2.mostrar();
            tablero.mostrarTablero();

            if (ficha1.getSimbolo().equals(ficha2.getSimbolo())) { // Si las fichas son iguales
                System.out.println("Bien +1 punto");
                ficha1.setEmparejada(true);
                ficha2.setEmparejada(true);
                jugadores[turnoActual].subirPuntaje();
                tablero.restarPar();
            } else {
                System.out.println("No son iguales");
                ficha1.ocultar();
                ficha2.ocultar();
                cambiarTurno();
            }
        }

        mostrarGanador();
    }

    private void cambiarTurno() { // Método para cambiar el turno
        turnoActual = (turnoActual + 1) % 2;
    }

    private void mostrarGanador() {
        System.out.println("\n  Game Over");
        System.out.println(jugadores[0]);
        System.out.println(jugadores[1]);

        if (jugadores[0].getPuntaje() > jugadores[1].getPuntaje()) {
            System.out.println("Ganador: " + jugadores[0].getNombre());
        } else if (jugadores[1].getPuntaje() > jugadores[0].getPuntaje()) {
            System.out.println("Ganador: " + jugadores[1].getNombre());
        } else {
            System.out.println("Empate!");
        }
    }
}

// Luis Eduardo Gutierrez Oliva
//  POO SEC 10
// JUEGO DE MEMORIA
public class Jugador {
    private String nombre;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void subirPuntaje() {
        puntaje++;
    }

    public void resetearPuntaje() {
        puntaje = 0;
    }

    public String toString() {
        return nombre + " | Puntos: " + puntaje;
    }
}

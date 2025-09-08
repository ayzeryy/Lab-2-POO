// Luis Eduardo Gutierrez Oliva
//  POO SEC 10
// JUEGO DE MEMORIA
public class Ficha {
    private String simbolo;
    private boolean visible;
    private boolean emparejada;

    public Ficha(String simbolo) {
        this.simbolo = simbolo;
        this.visible = false;
        this.emparejada = false;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isEmparejada() {
        return emparejada;
    }

    public void setEmparejada(boolean emparejada) {
        this.emparejada = emparejada;
    }

    public void mostrar() {
        this.visible = true;
    }

    public void ocultar() {
        if (!emparejada) {
            this.visible = false;
        }
    }

    public String toString() {
        if (visible || emparejada) {
            return simbolo;
        } else {
            return "X"; // casilla oculta
        }
    }
}

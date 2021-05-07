/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manospoker;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sergio
 */
public class Juego {

    private Baraja baraja_;
    private List<Jugador> jugadores_;
    private Jugador ganador_;

    public Juego() {
        baraja_ = new Baraja();
        jugadores_ = new ArrayList();
        baraja_.inicializar();
        ganador_ = new Jugador();
    }

    public void addJugador(Jugador jugador) {
        jugadores_.add(jugador);
    }

    public void repartirCartas() {
        int nCartas = 5;
        for (int i = 0; i < jugadores_.size(); i++) {
            for (int j = 0; j < nCartas; j++) {
                jugadores_.get(i).darCarta(baraja_.getCarta());
            }
        }
    }

    public void jugadorGanador() {
        for (int j = 0; j < jugadores_.size(); j++) {
            jugadores_.get(j).asignacionPuntos();
        }
        Jugador ganador = jugadores_.get(0);
        for (int i = 1; i < jugadores_.size(); i++) {
            if (ganador.getPuntuacion() < jugadores_.get(i).getPuntuacion()) {
                ganador = jugadores_.get(i);
            } else if (ganador.getPuntuacion() == jugadores_.get(i).getPuntuacion()) {
                if (ganador.getPuntuacionDesempate() < jugadores_.get(i).getPuntuacionDesempate()) {
                    ganador = jugadores_.get(i);
                }
            }
        }
        ganador_ = ganador;
    }

    public void nuevoJuego() {

        for (int i = 0; i < jugadores_.size(); i++) {
            jugadores_.get(i).retirarCartas();
        }
        baraja_.inicializar();

    }

    public Jugador getGanador() {
        return ganador_;
    }

    public int nJugadores() {
        return jugadores_.size();
    }

    public Jugador getJugador(int i) {
        return jugadores_.get(i);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manospoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Sergio López
 */
public class Jugador {

    private String id_;
    private List<Carta> mano_;
    private int puntuacion_;
    private int puntuacionDesempate_;

    public Jugador() {
        id_ = new String("");
        mano_ = new ArrayList();
        puntuacion_ = 0;
        puntuacionDesempate_ = 0;

    }

    public Jugador(String id) {
        id_ = new String(id);
        mano_ = new ArrayList();
        puntuacion_ = 0;
        puntuacionDesempate_ = 0;

    }

    public void darCarta(Carta carta) {
        mano_.add(carta);
    }

    public void retirarCartas() {
        mano_.clear();
    }

    public void printMano() {
        System.out.println("Jugador: " + id_);
        for (int i = 0; i < mano_.size(); i++) {
            mano_.get(i).printCarta();
        }
        System.out.println("-----------------");
    }

    public void ordenarCartas() {
        Collections.sort(mano_);
    }

    public boolean escalera() {
        this.ordenarCartas();
        boolean salida = true;
        for (int i = 1; i < mano_.size(); i++) {
            if (mano_.get(i).getValor() != (mano_.get(i - 1).getValor() - 1)) {
                salida = false;
            }
        }
        puntuacionDesempate_ = mano_.get(0).getValor();//Ordenando de mayor a menor

        return salida;
    }

    public boolean color() {
        boolean salida = true;
        for (int i = 0; i < (mano_.size() - 1); i++) {
            if (!(mano_.get(i).getPalo().equals(mano_.get(i + 1).getPalo()))) {
                salida = false;
            }
        }
        puntuacionDesempate_ = mano_.get(0).getValor();
        return salida;
    }

    public boolean escaleraColor() {
        boolean salida = (this.escalera()) && (this.color());

        return (salida);
    }

    /*
     *    
     6=Poker, 4=Full, 3=trio, 2=Dobles Parejas, 1=Pareja, 0=Carta Alta
     *
     */
    public int repetidas() {
        int contador = 0;
        for (int i = 0; i < mano_.size(); i++) {
            for (int j = 0; j < mano_.size(); j++) {
                if (i != j) {
                    if (mano_.get(i).getValor() == mano_.get(j).getValor()) {
                        contador++;
                        if (mano_.get(i).getValor() > puntuacionDesempate_) {
                            puntuacionDesempate_ = mano_.get(i).getValor();
                        }
                    }
                }
            }
        }
        return (contador / 2);
    }

    public void asignacionPuntos() {
        if (this.escaleraColor()) {
            puntuacion_ = 8;
        } else if (this.repetidas() == 6) {
            puntuacion_ = 7;
        } else if (this.repetidas() == 4) {
            puntuacion_ = 6;
        } else if (this.color()) {
            puntuacion_ = 5;
        } else if (this.escalera()) {
            puntuacion_ = 4;
        } else if (this.repetidas() == 3) {
            puntuacion_ = 3;
        } else if (this.repetidas() == 2) {
            puntuacion_ = 2;
        } else if (this.repetidas() == 1) {
            puntuacion_ = 1;
        } else {
            puntuacion_ = 0;
        }
    }

    public int getPuntuacion() {
        return puntuacion_;
    }

    public int getPuntuacionDesempate() {
        return puntuacionDesempate_;
    }

    public String getId() {
        return id_;
    }

    public String getCombinacion() {
        String combo = new String("");
        switch (puntuacion_) {
            case 8:
                combo = "Escalera color";
                break;
            case 7:
                combo = "Poker";
                break;
            case 6:
                combo = "Full";
                break;
            case 5:
                combo = "Color";
                break;
            case 4:
                combo = "Escalera";
                break;
            case 3:
                combo = "Trio";
                break;
            case 2:
                combo = "Doble pareja";
                break;
            case 1:
                combo = "Pareja";
                break;
            case 0:
                combo = "Carta alta";
                break;
            default:
                combo = "error o trampa";

        }
        return combo;
    }

}

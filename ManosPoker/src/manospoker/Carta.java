/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manospoker;

/**
 *
 * @author Sergio López
 */
public class Carta implements Comparable<Carta> {

    private int valor_;

    private String palo_;

    public Carta() {
        valor_ = 0;
        palo_ = new String("");
    }

    public Carta(int valor, String palo) {

        valor_ = valor;
        palo_ = new String(palo);

    }

    public int getValor() {
        return valor_;
    }

    public String getPalo() {
        return palo_;
    }

    public void setValor(int valor) {
        this.valor_ = valor;
    }

    public void setPalo(String palo) {
        this.palo_ = palo;
    }

    public void printCarta() {
        String valor;
        switch (valor_) {
            case 2:
                valor = "Dos";
                break;
            case 3:
                valor = "Tres";
                break;
            case 4:
                valor = "Cuatro";
                break;
            case 5:
                valor = "Cinco";
                break;
            case 6:
                valor = "Seis";
                break;
            case 7:
                valor = "Siete";
                break;
            case 8:
                valor = "Ocho";
                break;
            case 9:
                valor = "Nueve";
                break;
            case 10:
                valor = "Diez";
                break;
            case 11:
                valor = "J";
                break;
            case 12:
                valor = "Q";
                break;
            case 13:
                valor = "K";
                break;
            case 14:
                valor = "As";
                break;
            default:
                valor = "error";

        }
        System.out.println(valor + " de " + palo_);
    }

    @Override
    public int compareTo(Carta c) {
        if (c.getValor() < valor_) {
            return -1;
        } else if (c.getValor() == valor_) {
            return 0;
        } else {
            return 1;
        }
    }

}

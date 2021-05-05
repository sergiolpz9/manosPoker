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
public class Baraja {
    
    private List<Carta> cartas_;
    
    public Baraja(){
        
        cartas_=new ArrayList();
        this.inicializar();
    }
    
    public void inicializar(){
        cartas_.clear();
        String palos[]={"corazones","diamantes","picas","treboles"};
        String valores[]={"As","Uno","Dos","Tres","Cuatro","Cinco","Seis",
                          "Siete","Ocho","Nueve","J","Q","K"};
        for (int i=0;i<13;i++){
            for (int k=0;k<4;k++){
                Carta c= new Carta(valores[i],palos[k]);
                cartas_.add(c);
            }
        }
    }
    public Carta getCarta(){
        int sizeBaraja=cartas_.size();
        int aleatorio = (int) Math.floor(Math.random()*(sizeBaraja-0+1)+0);
        Carta carta = cartas_.get(aleatorio);
        cartas_.remove(aleatorio);
        return carta;
    }
    
}
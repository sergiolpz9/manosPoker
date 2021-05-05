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
public class Jugador {
    
    private String id_;
    private List<Carta> mano_;
    
    public Jugador(String id, int nCartas){
        id_=new String(id);
        mano_= new ArrayList();
        
    }
    
    public void darCarta(Carta carta){
      mano_.add(carta);
    }
    
    public void retirarCartas(){
      mano_.clear();
    }
    
}

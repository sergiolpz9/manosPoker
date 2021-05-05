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
    private int puntuacion_;
    private int puntuacionDesempate_;
    
    public Jugador(String id){
        id_=new String(id);
        mano_= new ArrayList();
        puntuacion_=0;
        puntuacionDesempate_=0;
        
    }
    
    public void darCarta(Carta carta){
      mano_.add(carta);
    }
    
    public void retirarCartas(){
      mano_.clear();
    }
    
   public void printMano(){
       //método para imprimir en pantalla la mano del jugador
   }
   public void ordenarCartas(){
       //método para ordenar las cartas de mayor a menor valor
           
       
   }
   public boolean escalera(){
       this.ordenarCartas();
       boolean salida=true;
       for(int i=1;i<mano_.size();i++){
           if(mano_.get(i).getValor()!=(mano_.get(i-1).getValor()+1)){
               salida=false;
           }
       }
       
       return salida;
   }
   
   public boolean color(){
       boolean salida=true;
       for (int i=0; i<(mano_.size()-1); i++) {
            if (!(mano_.get(i).getPalo().equals(mano_.get(i+1).getPalo()))) {
                salida=false;
            }
        }
       return salida;
   }
   
   public boolean escaleraColor(){
        return ((this.escalera()) && (this.color()));
   }


}

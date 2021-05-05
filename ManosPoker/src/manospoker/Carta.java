/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manospoker;

/**
 *
 * @author sergio
 */
public class Carta {
    
    private String valor_;
    
    private String palo_;
    
    
    public Carta(){ 
        valor_=new String("");
        palo_=new String("");
    }
    public Carta(String valor, String palo){
        
        valor_=new String(valor);
        palo_=new String(palo);
        
    }

    public String getValor() {
        return valor_;
    }

    public String getPalo() {
        return palo_;
    }

    public void setValor(String valor) {
        this.valor_ = valor;
    }

    public void setPalo(String palo) {
        this.palo_ = palo;
    }
    
    
        
    
}

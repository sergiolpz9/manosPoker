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
public class ManosPoker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Juego juego=new Juego();
        Jugador ganador=new Jugador();
        Jugador paco= new Jugador("paco");
        Jugador pepe= new Jugador("pepe");
        
        juego.addJugador(paco);
        juego.addJugador(pepe);
        
        juego.repartirCartas();
        ganador=juego.jugadorGanador();
        paco.printMano();
        pepe.printMano();
        System.out.println("El ganador es: "+ganador.getId());
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manospoker;

import java.util.Scanner;

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
        Scanner sc=new Scanner(System.in);
        Juego juego=new Juego();
        int nJugadores;
        String nombreJugador;
        String siNo;
        boolean continuar=true;
        boolean aux;
           
        System.out.print("Inserte el número de jugadores: ");
        nJugadores=sc.nextInt();
        
        for(int i=0;i<nJugadores;i++){
            System.out.print("Nombre del jugador: ");
            nombreJugador=sc.next();
            Jugador jugador=new Jugador(nombreJugador);
            juego.addJugador(jugador);
        }
        while(continuar){
        System.out.println("-----------------");
        System.out.println("COMIENZA EL JUEGO");
        System.out.println("-----------------");
        
         juego.repartirCartas();
         juego.jugadorGanador();
         
        for(int j=0;j<nJugadores;j++){
            juego.getJugador(j).printMano();
        }
            
        System.out.println("El ganador es: "+juego.getGanador().getId());
        System.out.println("por: "+juego.getGanador().getCombinacion());
        aux=true;
        while(aux){
        System.out.print("¿Desean jugar otra ronda? [S/N]: ");
        siNo=sc.next();
            
        
        if(siNo.equals("s")||siNo.equals("S")){
            juego.nuevoJuego();
            aux=false;
        }
        else if(siNo.equals("n")||siNo.equals("N")){
            continuar=false;
            aux=false;
        }
        }
    }
    }
    
}

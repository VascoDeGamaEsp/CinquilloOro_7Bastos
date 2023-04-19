/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega).
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.core;


import es.uvigo.esei.aed1.iu.IU;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Juego {

    private final IU iu;
    private Baraja baraja;
    private List<Jugador> jugadores;
    //private Mesa mesa;

    public Juego(IU iu) {
        this.iu = iu;
        this.baraja = new Baraja();
        this.jugadores = new LinkedList<>();
        //this.mesa = new Mesa();

    }

    public void jugar() {
        baraja.barajar();
        /*System.out.println("tamaño baraja = " + baraja.getBaraja().tamaño());
        while (!baraja.getBaraja().esVacio()) {
            System.out.println(baraja.getBaraja().pop());
            
        }*/
        crearJugadores();
        repartir();
        iu.mostrarJugadores(jugadores);
        
         

    }

    private Jugador jugadorInicial(){
        Random random = new Random();
        return jugadores.get(random.nextInt(jugadores.size()));     
    }
    
    private void crearJugadores(){
        Collection<String> nombres = iu.pedirDatosJugadores(); 
        for(String n: nombres){
             jugadores.add(new Jugador(n, new ArrayList<Carta>() ));
         }
    }
    
    
    private void repartir() {
        while (!baraja.esVacia()) {
            for (Jugador jugador : jugadores) {
                jugador.recogerCarta(baraja.sacarCarta());
            }
        }
    }
    
    private void turnoJugador() {
        Jugador turno = jugadorInicial();
        iu.mostrarJugador(turno);
        boolean finalizada = false;
        int opcion=0;
        int total=0;
        while (finalizada == false) {
            int i = 0;
            for (i=0; i < jugadores.size()+1; i++) {
                
                opcion = iu.leeNum("Escoge una carta");
                Carta carta = jugadores.get(i).sacarCarta(opcion);
                if (i == jugadores.size()){
                    i=0;
                    total++;
                }
                
            }
            
        }
    }
}

    

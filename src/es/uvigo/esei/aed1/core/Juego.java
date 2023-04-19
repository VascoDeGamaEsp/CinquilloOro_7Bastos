/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega).
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.core;


import es.uvigo.esei.aed1.iu.IU;
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
        Jugador turno = jugadorInicial();
        iu.mostrarJugador(turno);
         

    }

    private Jugador jugadorInicial(){
        Random random = new Random();
        return jugadores.get(random.nextInt(jugadores.size()));     
    }
    
    private void crearJugadores(){
        Collection<String> nombres = iu.pedirDatosJugadores(); 
        for(String n: nombres){
            jugadores.add(new Jugador(n));
        }
    }
    
    
    private void repartir() {
        while (!baraja.esVacia()) {
            for (Jugador jugador : jugadores) {
                jugador.recogerCarta(baraja.sacarCarta());
            }
        }
    }
}


    

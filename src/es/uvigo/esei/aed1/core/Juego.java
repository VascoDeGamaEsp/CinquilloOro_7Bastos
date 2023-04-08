/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega).
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.core;

import cola.Cola;
import cola.EnlazadaCola;
import es.uvigo.esei.aed1.core.Baraja;
import es.uvigo.esei.aed1.core.Carta;
import es.uvigo.esei.aed1.iu.IU;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pila.EnlazadaPila;
import pila.Pila;

public class Juego {

    private final IU iu;

    public Juego(IU iu) {
        this.iu = iu;

    }

    public void jugar() {
        Baraja baraja = new Baraja();
         
        
        // baraja.setBaraja(crearBaraja());
        baraja.setBaraja(Baraja.barajar(Baraja.crearBaraja()));
        System.out.println("\nBaraja barajada; ");
//        for (int i = 0; i < cartas.length; i++) {
//            System.out.println(cartas[i].toString());
//
//        }
//        System.out.println("Tamaño baraja = " + cartas.length);
        /*preguntar cuanto jugadores
    crear juegadores
    repartir las cartas entre los jugadores
    mostrar estado de la partida
    mostras a quien le toca jugar*/
        int numJugadores = 0;
        do {
            try {

                numJugadores = Integer.parseInt(iu.leeString("Introduzca numero de jugadores ( 3 o 4):"));

            } catch (NumberFormatException e) {
                System.out.println("No a introducido un numero");
            }
        } while (numJugadores > 4 || numJugadores < 3);
        Jugador[] jugadores = new Jugador[numJugadores];
        String nombre = "";

        for (int i = 0; i < numJugadores; i++) {

            do {
                nombre = iu.leeString("Introduzca el nombre del jugador " + (i + 1) + ":  ");
                if (nombre.length() > 0) {
                    jugadores[i] = new Jugador(nombre, new ArrayList<Carta>());
                }
            } while (nombre.length() == 0);
        }
        repartir(baraja, jugadores);
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
         Random random = new Random();
        
        System.out.println("Empieza el jugador: " + jugadores[random.nextInt(jugadores.length)].getNombre());

    }

    

    private void repartir(Baraja baraja, Jugador[] jugadores) {
        while (!baraja.getBaraja().esVacio()) {
            for (Jugador jugador : jugadores) {

                jugador.getManoCartas().add((Carta) baraja.getBaraja().pop());
            }
        }
    }

}

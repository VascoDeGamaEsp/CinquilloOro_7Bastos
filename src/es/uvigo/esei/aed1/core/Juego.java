/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega).
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.core;

import cola.Cola;
import cola.EnlazadaCola;
import es.uvigo.esei.aed1.iu.IU;
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
        Carta[] cartas = crearBaraja();
        boolean fallo = false;
        // baraja.setBaraja(crearBaraja());
        barajar(cartas);
        System.out.println("\nBaraja barajada; ");
        for (int i = 0; i < cartas.length; i++) {
            System.out.println(cartas[i].toString());

        }
        System.out.println("Tamaño baraja = " + cartas.length);
        /*preguntar cuanto jugadores
    crear juegadores
    repartir las cartas entre los jugadores
    mostrar estado de la partida
    mostras a quien le toca jugar*/
        int numJugadores = 0;
        String nombre ="";
        try {
            do {
                numJugadores = Integer.parseInt(iu.leeString("Introduzca numero de jugadores ( 3 o 4):"));
            } while (numJugadores > 4 || numJugadores < 3);
            
            // DE MOMENTO NO TIENEN MANNO DE CARTAS...
            
            if (numJugadores == 3){
                nombre = iu.leeString("Introduce el nombre del jugador 1");
                Jugador jugador1 = new Jugador (nombre, barajar(cartas));
                nombre = iu.leeString("Introduce el nombre del jugador 2");
                Jugador jugador2 = new Jugador (nombre,barajar(cartas));
                nombre = iu.leeString("Introduce el nombre del jugador 3");
                Jugador jugador3 = new Jugador (nombre,barajar(cartas));
            }
            
            else{
               nombre = iu.leeString("Introduce el nombre del jugador 1");
               Jugador jugador1 = new Jugador (nombre, barajar(cartas));
               nombre = iu.leeString("Introduce el nombre del jugador 2");
               Jugador jugador2 = new Jugador (nombre,barajar(cartas));
               nombre = iu.leeString("Introduce el nombre del jugador 3");
               Jugador jugador3 = new Jugador (nombre,barajar(cartas));
               nombre = iu.leeString("Introduce el nombre del jugador 4");
               Jugador jugador4 = new Jugador (nombre,barajar(cartas)); 
            }
            
        } catch (NumberFormatException e) {
            System.out.println("No a introducido un numero");
        }
    }

    private Carta[] crearBaraja() {
        Carta[] baraja = new Carta[48];
        String[] palo = {"oros", "espadas", "bastos", "copas"};
        int it = 0;
        System.out.println("\nBaraja sin barajar:");
        for (int i = 0; i < palo.length; i++) {
            for (int j = 1; j <= 12; j++) {

                baraja[it] = new Carta(j, palo[i]);
                System.out.println("Pos: " + it + "     " + baraja[it]);
                it++;

            }
        }
        return baraja;
    }

    private void barajar(Carta[] cartas) {
        Random random = new Random();
        int i = 0;

        //genera posiciones a intercambiar en orden
        int[] prueba = random.ints(cartas.length, 0, cartas.length).toArray();
        //System.out.println("\nNumeros generados automaticamente:");
        for (int j : prueba) {
            //System.out.println(j);

            //Mezcla cartas
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }

    }

}

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
import pila.PilaVaciaExcepcion;

public class Juego {

    private final IU iu;

    public Juego(IU iu) {
        this.iu = iu;

    }

    public void jugar() {
        
        try {
            Baraja baraja = new Baraja();
        } catch (PilaVaciaExcepcion e) {
            System.out.println("La baraja no tiene cartas");
        }
        catch(NullPointerException e){
            System.out.println("La baraja no tiene cartas");
        }
//        Carta[] cartas = crearBaraja();
//        boolean fallo = false;
//        // baraja.setBaraja(crearBaraja());
//        barajar(cartas);
//        System.out.println("\nBaraja barajada; ");
//        for (int i = 0; i < cartas.length; i++) {
//            System.out.println(cartas[i].toString());
//
//        }
//        System.out.println("Tamaño baraja = " + cartas.length);
//        /*preguntar cuanto jugadores
//    crear juegadores
//    repartir las cartas entre los jugadores
//    mostrar estado de la partida
//    mostras a quien le toca jugar*/
//        int numJugadores = 0;
//        try {
//            do {
//                numJugadores = Integer.parseInt(iu.leeString("Introduzca numero de jugadores ( 3 o 4):"));
//            } while (numJugadores > 4 || numJugadores < 3);
//        } catch (NumberFormatException e) {
//            System.out.println("No a introducido un numero");
//        }
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

/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */

package es.uvigo.esei.aed1.core;

import cola.Cola;
import java.util.Random;
import pila.EnlazadaPila;
import pila.Pila;


public class Baraja {

    private Pila baraja;

    public Baraja() {
    }

    public Pila getBaraja() {
        return baraja;
    }

    public void setBaraja(Pila baraja) {
        this.baraja = baraja;
    }
    
    protected static Pila barajar(Carta[] cartas) {
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
        Pila baraja = new EnlazadaPila();
        baraja.push(cartas);
        return baraja;
    }
    protected static Carta[] crearBaraja() {
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
}

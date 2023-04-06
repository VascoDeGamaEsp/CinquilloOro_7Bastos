/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */

package es.uvigo.esei.aed1.core;

import cola.Cola;
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
    
   
}

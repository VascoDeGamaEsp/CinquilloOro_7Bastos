/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */

package es.uvigo.esei.aed1.core;

import cola.Cola;
import pila.Pila;
import pila.PilaVaciaExcepcion;


public class Baraja {

    EnlazadaBaraja  baraja = new EnlazadaBaraja();

    public Baraja() throws PilaVaciaExcepcion{ 
        
        String[] palo = {"oros", "espadas", "bastos", "copas"}; 
        
        for (int i = 0; i < palo.length; i++) { 
            for (int j = 1; j <= 12; j++) { 
                                            
                this.insertarCarta( new NodoCarta( new Carta( j, palo[i]), null) );

            }
            
        }
        
    }

    public EnlazadaBaraja getBaraja() {
        return baraja;
    }

    public void setBaraja(EnlazadaBaraja baraja) {
        this.baraja = baraja;
    }
    
    public void insertarCarta(NodoCarta carta){
        baraja.push(carta);
    }
     
}

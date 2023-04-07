/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */

package es.uvigo.esei.aed1.core;

import cola.Cola;
import java.util.Random;
import pila.Pila;
import pila.PilaVaciaExcepcion;


public class Baraja {
    final static int CARTAS_POR_PALO = 12;
    final static int NUMERO_PALOS = 4;
    EnlazadaBaraja  baraja = new EnlazadaBaraja();

    public Baraja() throws PilaVaciaExcepcion{ 
        
        String[] palo = {"oros", "espadas", "bastos", "copas"}; 
        
        for (int i = 0; i < palo.length; i++) { 
            for (int j = 1; j <= CARTAS_POR_PALO; j++) { 
                                            
                this.insertarCarta( new NodoCarta( new Carta( j, palo[i]), null) );

            }
            
        }
        
    }
    
    public void barajar(){
        //atributos
        int NUMERO_CARTAS = CARTAS_POR_PALO * NUMERO_PALOS;
        int posicionAIntroducir;
        
        
        Carta[] arrayCarta = new Carta[NUMERO_CARTAS];
        Random aleatorio = new Random(System.currentTimeMillis());
        
        
        //inicio
        for (int i = 0; i < arrayCarta.length; i++) {
            arrayCarta[i] = baraja.pop().getElemento();    
        }
        
        int i = NUMERO_CARTAS - 1;
        while ( i >= 0 ) {
            
            posicionAIntroducir = aleatorio.nextInt(NUMERO_CARTAS);
            baraja.push( new NodoCarta( arrayCarta[posicionAIntroducir], null));
            arrayCarta[posicionAIntroducir] = arrayCarta[i];
            i--;
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
    
    public NodoCarta sacarCarta(){
        return baraja.pop();
    }
    
    private void mostrarBaraja(){
        int i = 1;
        while (!baraja.esVacio()) {
            System.out.println(baraja.pop().mostrarCarta());
            System.out.println(i);
            i++;
        }
    }
     
}

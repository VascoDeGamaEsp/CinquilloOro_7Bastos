/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */

package es.uvigo.esei.aed1.core;


import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import pila.EnlazadaPila;
import pila.Pila;


public class Baraja {

    private static  Pila baraja = new EnlazadaPila();

    

    public Pila getBaraja() {
        return baraja;
    }

   
    
   /* public static Pila barajar(Carta[] cartas) {
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
    }*/
    public static void crearBaraja() {
        
        String[] palo = {"oros", "espadas", "bastos", "copas"};
        
        System.out.println("\nBaraja sin barajar:");
        for (int i = 0; i < palo.length; i++) {
            for (int j = 1; j <= 12; j++) {

                baraja.push( new Carta(j, palo[i]));
                //System.out.println("Pos: " + it + "     " + cartas[it]);
               

            }
        }
        
        
    }

    public void barajar() {
        crearBaraja();
       int NUMERO_CARTAS =48;
        int posicionAIntroducir;
        
        
        Carta[] arrayCarta = new Carta[NUMERO_CARTAS];
        Random aleatorio = new Random(System.currentTimeMillis());
        
        
        //inicio
        for (int i = 0; i < arrayCarta.length; i++) {
            arrayCarta[i] = (Carta) baraja.pop();    
        }
        
        int i = NUMERO_CARTAS - 1;
        while ( i >= 0 ) {
            
            posicionAIntroducir = aleatorio.nextInt(NUMERO_CARTAS);
            baraja.push(arrayCarta[posicionAIntroducir]);
            arrayCarta[posicionAIntroducir] = arrayCarta[i];
            i--;
        }
    }
   

  public  boolean esVacia() {
       return baraja.esVacio();
    }
  public  Carta sacarCarta() {
       return (Carta) baraja.pop();
    }
}

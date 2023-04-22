/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */
package es.uvigo.esei.aed1.core;

import java.util.Random;
import pila.EnlazadaPila;
import pila.Pila;

public class Baraja {

    private static final int CARTAS_POR_PALO = 12;
    private static final String[] palo = {"oros", "espadas", "bastos", "copas"};
    private static Pila<Carta> pilaBaraja = new EnlazadaPila<>();
    

    public Baraja() { 
        
        for (int i = 0; i < palo.length; i++) {
            for (int j = 1; j <= CARTAS_POR_PALO; j++) {
                pilaBaraja.push(new Carta(j, palo[i]));

            }
        }

//        mostrarBaraja();
    }

    public Pila getBaraja() {
        return pilaBaraja;
    }

    public void barajar() {
        int NUMERO_CARTAS = CARTAS_POR_PALO * palo.length;
        int posicionAIntroducir;

        Carta[] arrayCarta = new Carta[NUMERO_CARTAS];
        Random aleatorio = new Random(System.currentTimeMillis());

        for (int i = 0; i < arrayCarta.length; i++) {
            arrayCarta[i] = pilaBaraja.pop();
        }

        int i = NUMERO_CARTAS - 1;
        while (i >= 0) {

            posicionAIntroducir = aleatorio.nextInt(NUMERO_CARTAS);
            pilaBaraja.push(arrayCarta[posicionAIntroducir]);
            arrayCarta[posicionAIntroducir] = arrayCarta[i];
            i--;
        }
        
        mostrarBaraja();
    }

    public boolean esVacia() {
        return pilaBaraja.esVacio();
    }

    public Carta pop() {
        return pilaBaraja.pop();
    }

    private void mostrarBaraja() {
        Pila<Carta> copia = copiaBaraja(pilaBaraja);
        int i = 1;
        while (!copia.esVacio()) {
            System.out.println(copia.pop());
            System.out.println("Pos: " + i);
            i++;
        }
        
        System.out.println("\n-------------\n");

    }

    private Pila<Carta> copiaBaraja(Pila<Carta> p) {
        Pila<Carta> copia = new EnlazadaPila<>();
        Pila<Carta> auxiliar = new EnlazadaPila<>();

        while (!p.esVacio()) {
            auxiliar.push(p.pop());
        }

        while (!auxiliar.esVacio()) {
            p.push(auxiliar.top());
            copia.push(auxiliar.pop());
        }
        
//        System.out.println("\nCopia hecha\n");

        return copia;
    }

}

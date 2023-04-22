/*
* Representa la Mesa de juego. 
* Estructura: se utilizara un TAD adecuado. Piensa que hay 4 palos y de cada palo se pueden colocar cartas 
* por cualquiera de los dos extremos (un array con 4 doblescolas parece lo mas adecuado). La DobleCola se comenta en clase de teoria
* Funcionalidad: saber si es posible colocar una carta en la mesa, colocar una carta en la mesa, mostrar la mesa
 */
package es.uvigo.esei.aed1.core;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import lista.Lista;

public class Mesa {

    private Deque<Carta>[] montones;

    //constructor
    public Mesa() {

        for (int i = 0; i < 4; i++) {

            montones[i] = new ArrayDeque<Carta>();
        }

    }

    //a�adir mas funcionalidades
    public void añadirCarta(Carta carta) {
        for (Deque<Carta> monton : montones) {
            if(monton.isEmpty()){
                monton.add(carta);
            }else if (monton.element().getPalo().equals(carta.getPalo())) {
                if (monton.element().getNumero() > carta.getNumero()) {
                    monton.addFirst(carta);
                } else {
                    monton.addLast(carta);
                }
            }

        }

    }

    // mostrar el estado de la mesa
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Deque<Carta> monton : montones) {
            str.append("Monton de ").append(monton.element().getPalo());
            for (Carta carta : monton) {

            }

        }
        return str.toString();
    }

    

}

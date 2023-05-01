/*
* Representa la Mesa de juego. 
* Estructura: se utilizara un TAD adecuado. Piensa que hay 4 palos y de cada palo se pueden colocar cartas 
* por cualquiera de los dos extremos (un array con 4 doblescolas parece lo mas adecuado). La DobleCola se comenta en clase de teoria
* Funcionalidad: saber si es posible colocar una carta en la mesa, colocar una carta en la mesa, mostrar la mesa
 */
package es.uvigo.esei.aed1.core;

import java.util.LinkedList;
import java.util.List;

public class Mesa {

    private Monton[] montones;

    //constructor
    public Mesa() {
        montones = new Monton[Baraja.PALOS.length];

        for (int i = 0; i < 4; i++) {

            montones[i] = new Monton(Baraja.PALOS[i]);
        }

    }

    public void añadirCarta(Carta carta) {
        int i = 0;
        while (i < Baraja.PALOS.length
                && !carta.getPalo().equalsIgnoreCase(Baraja.PALOS[i])) {
            i++;
        }
        if (i < Baraja.PALOS.length) {
            montones[i].añadirCarta(carta);
        }
    }

    public Monton getMonton(String palo) {
        Monton montonDevolver = null;

        int i = 0;
        while (i < montones.length
                && !montones[i].getPalo().equals(palo)) {
            i++;
        }
        if (montones[i].getPalo().equals(palo)) {
            montonDevolver = montones[i];
        }

        return montonDevolver;

    }

    public List mirarPosibilidades(Jugador jugador) {
        List<Carta> manoJugador = jugador.getManoCartas();
        List<Carta> cartasJugables = new LinkedList();
        Monton montonActual;
        
        for (Carta i : manoJugador) {
            montonActual = getMonton(i.getPalo());
            try {
                if (i.getNumero() == 5) {
                    cartasJugables.add(i);
                }
                else if (!montonActual.esVacio()
                        && i.getNumero() + 1 == montonActual.verPrimero().getNumero()) { // mirar cartas por debajo del 5
                    cartasJugables.add(i);
                }
                else if(!montonActual.esVacio()
                        &&i.getNumero() - 1 == montonActual.verUltimo().getNumero()){ // mirar cartas por encima del 5
                    cartasJugables.add(i);
                }
                
            } catch (Exception e) {
                System.err.println("Error. " + e.getMessage());
            }

        }
        return cartasJugables;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nESTADO DE LA MESA\n\n");
        for (Monton monton : montones) {
            str.append(monton);
        }
        str.append("\n");
        return str.toString();
    }
}

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

    public LinkedList mirarPosibilidades(Jugador jugador) {
        List<Carta> manoJugador = jugador.getManoCartas();

        LinkedList<Carta> cartasPosibles = new LinkedList();
        LinkedList<Carta> cartasJugables = new LinkedList();

        Carta cartaAntes;
        Carta cartaDespues;

        int i;

        i = 0;
        while (i < Baraja.PALOS.length) {

            if (montones[i].esVacio()) {
                cartasPosibles.add(new Carta(5, Baraja.PALOS[i]));
            } else {
                try {
                    cartaAntes = montones[i].verPrimero();

                    cartasPosibles.add(new Carta(
                            cartaAntes.getNumero() - 1,
                            Baraja.PALOS[i]));

                    cartaDespues = montones[i].verUltimo();

                    cartasPosibles.add(new Carta(
                            cartaDespues.getNumero() + 1,
                            Baraja.PALOS[i]));

                } catch (Exception e) {
                    System.err.println("Error. " + e.getMessage());
                }

            }
            i++;
        }

        for (Carta carta : manoJugador) {

            i = 0;

            while (i < cartasPosibles.size()
                    && !cartasPosibles.get(i).esIgual(carta)) {
                i++;
            }
            if (i < cartasPosibles.size()) {
                cartasJugables.add(carta);
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

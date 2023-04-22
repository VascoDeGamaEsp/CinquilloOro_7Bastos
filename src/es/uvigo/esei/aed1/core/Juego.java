/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega).
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Juego {

    private final IU iu;
    private Baraja baraja;
    private List<Jugador> jugadores;
    private Mesa mesa;

    public Juego(IU iu) {
        this.iu = iu;
        this.baraja = new Baraja();
        this.jugadores = new LinkedList<>();
        this.mesa = new Mesa();

    }

    public void jugar() {
        int posicionTurno;
        boolean acaboPartida = false;

        baraja.barajar();
        crearJugadores();
        repartir();
        iu.mostrarJugadores(jugadores);
        Jugador turno = jugadorInicial();
        iu.mostrarJugador(turno);

        posicionTurno = jugadores.indexOf(turno);
        Carta carta ;
        do {
            
            carta = leerOpciones(turno);
            if (carta != null) {
                mesa.añadirCarta(carta);
            } 
            
            // Hacer el cambio de turno
            

        } while (turno.manoEsVacio());

    }

    private Jugador jugadorInicial() {
        Random random = new Random();
        return jugadores.get(random.nextInt(jugadores.size()));
    }

    private void crearJugadores() {
        Collection<String> nombres = iu.pedirDatosJugadores();
        for (String n : nombres) {
            jugadores.add(new Jugador(n));
        }
    }

    private void repartir() {
        while (!baraja.esVacia()) {
            for (Jugador jugador : jugadores) {
                jugador.recogerCarta(baraja.pop());
            }
        }
    }

    private Carta leerOpciones(Jugador jugador) {
        int opcion = 0;
        LinkedList<Carta> cartasJugables = mesa.mirarPosibilidades(jugador);

        if (cartasJugables.size() == 0) {
            System.out.println("No puedes colocar ninguna carta");
            return null;
        } else {
            for (int i = 0; i < cartasJugables.size(); i++) {
                System.out.println("( " + (i + 1) + ") "
                        + cartasJugables.get(i).toString());

            }

            opcion = iu.leeNum("Escoge tu carta a jugar: ") - 1;
            return cartasJugables.get(opcion);
        }

        
    }
}

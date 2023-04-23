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
            if (!turno.manoEsVacio()) {
                posicionTurno++;
                if (posicionTurno >= jugadores.size()){
                    posicionTurno = 0;
                }
            }  
            
            turno = jugadores.get(posicionTurno);

        } while (!turno.manoEsVacio());
        

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
    
    private void turnoJugador() {
        Jugador turno = jugadorInicial();
        System.out.println("Jugador inicial: \n");
        iu.mostrarJugador(turno);
        boolean finalizada = false;
        int opcion=0;
        int total=0;
        while (finalizada == false) {
            int i = 0;
            for (i=0; i < jugadores.size()+1; i++) {
                
                Carta cartaEscogida = leerOpciones(jugadores.get(i));
//                Carta cartaEscogida = leerOpciones(jugadores.get(i));
//                Carta cartaMesa = jugadores.get(i).sacarCarta(cartaEscogida);
                mesa.añadirCarta(cartaEscogida);

                if (i == jugadores.size()){
                    i=0;
                    total++;
                }
                
            }
            
        }
    }
}

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
    private boolean asOros = false;
    private int puntosPartida = 4;
    private int puntosAsOros = 2;
    Jugador ganador;
    public Juego(IU iu) {
        this.iu = iu;
        this.baraja = new Baraja();
        this.jugadores = new LinkedList<>();
        this.mesa = new Mesa();

    }

    public void jugar() {
        int posicionTurno;

        crearJugadores();
        repartir();
        iu.mostrarJugadores(jugadores);
        Jugador turno = jugadorInicial();

        posicionTurno = jugadores.indexOf(turno);

        iu.mostrarMensaje("COMIEZA EL JUEGO\n");
        do {
            partida();
//            mesa.vaciarMesa();
        } while (asOros == false);

//            iu.mostrarMensaje(mesa.toString());
//            iu.mostrarMensaje("----------------------------------------");
//
//            iu.mostrarMensaje("Turno de:");
//            iu.mostrarJugador(turno);
//            leerOpciones(turno);
//
//            if (!turno.manoEsVacio()) {
//                posicionTurno++;
//                if (posicionTurno >= jugadores.size()) {
//                    posicionTurno = 0;
//                }
//
//                turno = jugadores.get(posicionTurno);
//            }
//
//        } while (!turno.manoEsVacio());
         ganador = devolverGanador();
         
         
        
        iu.mostrarMensaje("Acabo el juego");
        iu.mostrarMensaje("Ganador: ");
        iu.mostrarMensaje(ganador.getNombre());
        iu.mostrarMensaje("Puntuaciones");
        for (Jugador jugador : jugadores) {
            iu.mostrarMensaje(jugador.getNombre());
            iu.mostrarMensaje(String.valueOf(jugador.getPuntuacion()));
           
        }
            
        

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
        baraja.barajar();
        while (!baraja.esVacia()) {
            for (Jugador jugador : jugadores) {
                jugador.recogerCarta(baraja.pop());
            }
        }
    }

    private void jugada(Jugador jugador) {
        int opcion;
        List<Carta> cartasJugables = mesa.mirarPosibilidades(jugador);
        if (cartasJugables.isEmpty()) {
            do {
                opcion = iu.leeNum("No puedes colocar ninguna carta."
                        + " Pulsa 1 para continuar:\n");
            } while (opcion != 1);

        } else {
            for (int i = 0; i < cartasJugables.size(); i++) {
                iu.mostrarMensaje("( " + (i + 1) + ") "
                        + cartasJugables.get(i).toString());
            }
            do {
                opcion = iu.leeNum("Escoge tu carta a jugar: ") - 1;
            } while (opcion < 0 || opcion >= cartasJugables.size());
            if (!asOros) {
                asOros = mesa.esAsOros(cartasJugables.get(opcion));
                jugador.sumarPuntos(puntosAsOros);
            }
            mesa.añadirCarta(cartasJugables.get(opcion));
            jugador.eliminarCarta(cartasJugables.get(opcion));

        }

    }

    private void partida() {
        Jugador turno = jugadorInicial();
        int posicionTurno = jugadores.indexOf(turno);
        repartir();
        do {

            iu.mostrarMensaje("COMIEZA LA PARTIDA\n");
            iu.mostrarMensaje(mesa.toString());
            iu.mostrarMensaje("----------------------------------------");
            iu.mostrarMensaje("Turno de:");
            iu.mostrarJugador(turno);

            jugada(turno);
            if (!turno.manoEsVacio()) {
                posicionTurno++;
                if (posicionTurno >= jugadores.size()) {
                    posicionTurno = 0;
                }
                if (!asOros) {
                    puntosAsOros += 2;
                    turno.sumarPuntos(puntosAsOros);
                }
                turno = jugadores.get(posicionTurno);
            }

        } while (!turno.manoEsVacio());
        turno.sumarPuntos(puntosPartida);
        iu.mostrarMensaje("Acabo la partida");
        iu.mostrarMensaje("Ganador: ");
        iu.mostrarMensaje(turno.getNombre());
    }

    private Jugador devolverGanador() {
        Jugador max = jugadores.get(0);
        for (Jugador jugador : jugadores) {
            if (jugador.getPuntuacion() > max.getPuntuacion()) {
                max = jugador;
            }

        }
        return max;
    
    }
}

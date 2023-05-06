/**
 * Representa la interfaz del juego del Cinquillo-Oro, en este proyecto va a ser una entrada/salida en modo texto
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Carta;
import es.uvigo.esei.aed1.core.Jugador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class IU {

    private final Scanner teclado;

    public IU() {
        teclado = new Scanner(System.in).useDelimiter("\r?\n");
    }

    /**
     * Lee un num. de teclado
     *
     * @param msg El mensaje a visualizar.
     * @return El num., como entero
     */
    public int leeNum(String msg) {
        do {
            System.out.print(msg);

            try {
                return teclado.nextInt();
            } catch (InputMismatchException exc) {
                teclado.next();
                System.out.println("Entrada no válida. Debe ser un entero.");
            }
        } while (true);
    }

    public String leeString(String msg) {
        System.out.print(msg);
        return teclado.next();
    }

    public String leeString(String msg, Object... args) {
        System.out.printf(msg, args);
        return teclado.next();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarMensaje(String msg, Object... args) {
        System.out.printf(msg, args);
    }

    public void mostrarJugador(Jugador jugador) {
        System.out.println(jugador.toString());
    }

    public void mostrarJugadores(Collection<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.toString());
        }
    }

    public void mostrarTurno(Jugador jugador) {
        System.out.print("Turno de: " + jugador.getNombre());
        mostrarMensaje(jugador.manoToString());

    }

    public void mostrarPuntuaciones(List<Jugador> jugadores) {
        mostrarMensaje("Puntuaciones:");
        for (Jugador jugador : jugadores) {
            mostrarMensaje(jugador.getNombre() + ": "
                    + String.valueOf(jugador.getPuntuacion()));
        }
    }

    public void mostrarClasificacion(List<Jugador> jugadores) {
        List<Jugador> jugadoresOrdenados = jugadores;
        int vueltas = 0;
        int i = 0;
        
        //ordenar de mayor a menor a los jugadores segun su puntuacion
        //con el metodo de la burbuja bidireccional
        
        
        while (vueltas < jugadoresOrdenados.size() / 2) {
            
            while (i < (jugadoresOrdenados.size() - 1 - vueltas)) {
                System.out.println("i: "+i);
                if (jugadoresOrdenados.get(i).getPuntuacion()
                        < jugadoresOrdenados.get(i + 1).getPuntuacion()) {
                    
                    jugadoresOrdenados.add(i,
                            jugadoresOrdenados.remove(i + 1));
                }
                i++;
            }

            while (i > vueltas) {
                if (jugadoresOrdenados.get(i).getPuntuacion()
                        > jugadoresOrdenados.get(i - 1).getPuntuacion()) {
                    
                    jugadoresOrdenados.add(i - 1,
                            jugadoresOrdenados.get(i - 1));
                }

                i--;
            }

            vueltas++;
        }
        
        for (int k = 0; k < jugadoresOrdenados.size(); k++) {
            System.out.println(jugadoresOrdenados.get(k).toString());
            
        }
        
        //mostrar por pantalla a los jugadores ordenados
        mostrarMensaje("Puntuaciones:");

        for (int j = 0; j < jugadoresOrdenados.size(); j++) {
            mostrarMensaje((j + 1) + ". " + jugadoresOrdenados.get(j).getNombre()
                    + ": " + jugadoresOrdenados.get(j).getPuntuacion());
        }
    }

    public Collection<String> pedirDatosJugadores() {
        Collection<String> nombres = new ArrayList<>();
        int numJugadores = 0;
        do {
            try {

                numJugadores = Integer.parseInt(leeString(
                        "Introduzca numero de jugadores (3 o 4):"));

            } catch (NumberFormatException e) {
                System.out.println("No a introducido un numero");
            }
        } while (numJugadores > 4 || numJugadores < 3);
        Jugador[] jugadores = new Jugador[numJugadores];
        String nombre = "";

        for (int i = 0; i < numJugadores; i++) {

            do {
                nombre = leeString("Introduzca el nombre del jugador " + (i + 1) + ":  ");
                if (nombre.length() > 0) {
                    nombres.add(nombre);
                }
            } while (nombre.length() == 0);
        }
        return nombres;
    }

}

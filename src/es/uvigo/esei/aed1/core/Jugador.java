/*
 * Representa a un jugador, identificado por el nombre y sus cartas de la mano
 * Estructura mano: se utilizará un TAD adecuado
 * Funcionalidad: Añadir carta a la mano, convertir a String el objeto Jugador (toString)
 */
package es.uvigo.esei.aed1.core;

import java.util.List;

public class Jugador {

    private String nombre;
    private Carta[] manoCartas;

    public Jugador(String nombre, int numJugadores) {
        this.nombre = nombre;
        this.manoCartas = new Carta[48 / numJugadores];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getManoCartas(int numJugadores) {
        StringBuilder sb = new StringBuilder ();
        for (int i=0; i< manoCartas.length; i++){
            sb.append(i+1).append(". ").append(manoCartas[i]).append("\n");
        }
        return sb.toString();
    }

    public void setManoCartas(Carta [] manoCartas) {
        this.manoCartas = manoCartas;
    }

}

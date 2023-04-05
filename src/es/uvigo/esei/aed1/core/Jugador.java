/*
 * Representa a un jugador, identificado por el nombre y sus cartas de la mano
 * Estructura mano: se utilizará un TAD adecuado
 * Funcionalidad: Añadir carta a la mano, convertir a String el objeto Jugador (toString)
 */

package es.uvigo.esei.aed1.core;

import java.util.List;



public class Jugador {
    private String nombre;
    private List<Carta> manoCartas;

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Carta> getManoCartas() {
        return manoCartas;
    }

    public void setManoCartas(List<Carta> manoCartas) {
        this.manoCartas = manoCartas;
    }
    
    
}
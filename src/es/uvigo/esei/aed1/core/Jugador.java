/*
 * Representa a un jugador, identificado por el nombre y sus cartas de la mano
 * Estructura mano: se utilizará un TAD adecuado
 * Funcionalidad: Añadir carta a la mano, convertir a String el objeto Jugador (toString)
 */
package es.uvigo.esei.aed1.core;

import java.util.LinkedList;
import java.util.List;

public class Jugador {

    private String nombre;
    private List<Carta> manoCartas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.manoCartas = new LinkedList<>();
    }

    public Jugador(String nombre, List<Carta> manoCartas) {
        this.nombre = nombre;
        this.manoCartas = manoCartas;
    }

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
    
    public void eliminarCarta(Carta c){
        manoCartas.remove(c);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Nombre: ").append(nombre);
        str.append("\nMano: ");
        for (Carta carta : manoCartas) {
            str.append(carta.toString());
        }
        str.append("\n\n\n");

        return str.toString();
    }
    
    public boolean manoEsVacio(){
        return manoCartas.isEmpty();
    }
    

    public void recogerCarta(Carta c) {
        manoCartas.add(c);
    }
    
    public Carta sacarCarta (int pos){
        Carta c = manoCartas.get(pos);
        Carta c2 = manoCartas.get(pos);
        manoCartas.remove(c);
        
        return c2;
    }
    
    

}

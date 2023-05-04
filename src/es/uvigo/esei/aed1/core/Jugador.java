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
    private int puntuacion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.manoCartas = new LinkedList<>();
        this.puntuacion = 0;
    }

//    public Jugador(String nombre, List<Carta> manoCartas) {
//        this.nombre = nombre;
//        this.manoCartas = manoCartas;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
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

    public void sumarPuntos(int puntos){
        setPuntuacion(this.puntuacion + puntos);
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
    
    public void vaciarMano(){
        manoCartas.clear();
    }
    
    public String manoToString(){
        StringBuilder str = new StringBuilder();
        str.append("\nMano: ");
        for (Carta carta : manoCartas) {
            str.append(carta.toString());
        }
        str.append("\n\n");
        return str.toString();
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

}

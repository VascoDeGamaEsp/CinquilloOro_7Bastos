/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uvigo.esei.aed1.core;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Usuario
 */
public class Monton {
    private  Deque<Carta> monton;
    private  String palo;
    
    public  Monton(String palo){
        this.monton = new ArrayDeque<Carta>();
        this.palo = palo;
    }
    
    public String getPalo(){
        return palo;
    }
    
    public void añadirCarta(Carta carta){
        
        if (carta.getNumero() < 5) {
            monton.addFirst(carta);
        } else{
            monton.addLast(carta);
        }
    }
    
    public Carta verPrimero(){
        return monton.getFirst();
    }
    
    public Carta verUltimo(){
        return monton.getLast();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monton de ");
        sb.append(palo).append("\n");
        
        for (Carta carta: monton) {
            sb.append(carta);
        }
        sb.append("\n");
        return sb.toString();
    }

    
    
    
}

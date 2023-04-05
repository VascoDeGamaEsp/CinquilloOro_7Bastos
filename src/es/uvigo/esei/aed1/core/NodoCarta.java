/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uvigo.esei.aed1.core;

/**
 *
 * @author Usuario
 */
public class NodoCarta{
    private Carta elemento;
    private NodoCarta sig;
    
    public NodoCarta(Carta elemento, NodoCarta sig){
        this.elemento = elemento;
        this.sig = sig;
    }

    public Carta getElemento() {
        return elemento;
    }

    public void setElemento(Carta elemento) {
        this.elemento = elemento;
    }

    public NodoCarta getSig() {
        return sig;
    }

    public void setSig(NodoCarta sig) {
        this.sig = sig;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uvigo.esei.aed1.core;

import pila.PilaVaciaExcepcion;

/**
 *
 * @author Usuario
 */
public class EnlazadaBaraja extends PilaVaciaExcepcion{
    private NodoCarta tope;
    private int contador;
    
    public EnlazadaBaraja(){
        tope = null;
        contador = 0;
    }
    
    public int Tamaño(){
        return contador;
    }
    
    public boolean esVacio(){
        return contador == 0;
    }
    
    public NodoCarta top() throws PilaVaciaExcepcion {
        if(esVacio()){
            throw new PilaVaciaExcepcion();
        }
        return tope;
    }
    
    public void push(NodoCarta carta) {
        carta.setSig(tope);
        tope = carta;
    }
    
    public NodoCarta pop() throws PilaVaciaExcepcion {
        if(esVacio()){
            throw new PilaVaciaExcepcion();
        }
        
        NodoCarta NodoDevolver = tope;
        tope = tope.getSig();
        
        return NodoDevolver;
    }

}

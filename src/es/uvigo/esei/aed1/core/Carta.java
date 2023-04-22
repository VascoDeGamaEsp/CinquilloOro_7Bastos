/*
 * Representa una carta, formada por un número y su palo correspondiente
 */
package es.uvigo.esei.aed1.core;

public class Carta {

    private int numero;
    private String palo;

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }

  

    public String getPalo() {
        return palo;
    }

    

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{ ").append(numero);
        str.append(" : ").append(palo).append(" }");
        return str.toString();
    }

}

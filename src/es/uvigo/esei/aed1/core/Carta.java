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
    
    public boolean esAsOros() {
        return this.getNumero() == 1
                && this.getPalo().equalsIgnoreCase("oros");
    }

    public boolean esIgual(Carta c) {
        return c.getNumero() == numero && c.getPalo().equalsIgnoreCase(palo);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[ ").append(numero);
        str.append(" ");
        str.append(palo).append("]");
        return str.toString();
    }

}

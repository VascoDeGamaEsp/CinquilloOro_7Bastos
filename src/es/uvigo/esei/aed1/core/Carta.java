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

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nNumero = ").append(numero);
        str.append("\nPalo = ").append(palo);
        return str.toString();
    }

}

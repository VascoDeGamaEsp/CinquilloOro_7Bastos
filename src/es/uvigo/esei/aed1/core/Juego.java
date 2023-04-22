/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega).
 * Se recomienda una implementación modular.
 */
package es.uvigo.esei.aed1.core;


import es.uvigo.esei.aed1.iu.IU;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Juego {

    private final IU iu;
    private Baraja baraja;
    private List<Jugador> jugadores;
    private Mesa mesa;

    public Juego(IU iu) {
        this.iu = iu;
        this.baraja = new Baraja();
        this.jugadores = new LinkedList<>();
        //this.mesa = new Mesa();

    }

    public void jugar() {
        boolean finalizar_Partida = false;
        baraja.barajar();
        /*System.out.println("tamaño baraja = " + baraja.getBaraja().tamaño());
        while (!baraja.getBaraja().esVacio()) {
            System.out.println(baraja.getBaraja().pop());
            
        }*/
        crearJugadores();
        repartir();
        iu.mostrarJugadores(jugadores);
        Jugador turno = jugadorInicial();
        iu.mostrarJugador(turno);
        
        
        mostrarOpcionesPrimera(turno);
        
        do{
            cambiarTurno(turno);
            mostrarOpciones(turno);
        }while(finalizar_Partida==false);
         

    }

    private Jugador jugadorInicial(){
        Random random = new Random();
        return jugadores.get(random.nextInt(jugadores.size()));     
    }
    
    private void crearJugadores(){
        Collection<String> nombres = iu.pedirDatosJugadores(); 
        for(String n: nombres){
             jugadores.add(new Jugador(n, new ArrayList<Carta>() ));
         }
    }
    
    
    private void repartir() {
        while (!baraja.esVacia()) {
            for (Jugador jugador : jugadores) {
                jugador.recogerCarta(baraja.sacarCarta());
            }
        }
    }

    private void mostrarOpcionesPrimera(Jugador turno) {
        for (int i = 0; i < turno.getManoCartas().size(); i++) {
            System.out.println( (i+1) + " : " + turno.getManoCartas().get(i).toString() );
            
        }
        int opcion = 0;
        do{
            try {
                opcion = iu.leeNum(" Elija un acarta para poner en la mesa: ");
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
           
        }while(opcion<1 || opcion > turno.getManoCartas().size());
       
        mesa.añadirCarta(turno.getManoCartas().get(opcion));
        
    }

    private void cambiarTurno(Jugador turno) {
        Iterator it = jugadores.iterator();
        Jugador primeroLista = (Jugador) it.next();
        Jugador j = (Jugador) it.next();
        while(it.hasNext()){
           if(j.equals(turno) && !it.hasNext()) {
               turno = primeroLista;
               break;
           }
           if(j.equals(turno) && it.hasNext()) {
               turno = (Jugador) it.next();
               break;
           }
           j=(Jugador) it.next(); 
        }
    }

    private void mostrarOpciones(Jugador turno) {
        
    }
}


    

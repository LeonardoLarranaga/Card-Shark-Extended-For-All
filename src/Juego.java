import java.util.ArrayList;
import java.util.Random;

public class Juego {
	private ArrayList<Jugador> jugadores;
	private Baraja baraja;
	
	public Juego() {
		baraja = new Baraja();
		jugadores = new ArrayList<Jugador>();
	}
	
	public void agregarMazosExtra(int cantidadJugadores) {
		if (cantidadJugadores > 3) {
			int barajasExtras = (int) Math.ceil((double) (cantidadJugadores) / 3);
			
			for (int i = 0; i < barajasExtras; i++) {
				baraja.getMazo().addAll(new Baraja().getMazo());
			}
		}
	}
	
	public void asignarCartasAJugadores(int cantidadJugadores) {
		
		for (int i = 0; i < cantidadJugadores; i++) {
			Random random = new Random();
			
			jugadores.add(new Jugador(baraja.repartir(5)));
			
			System.out.println("\nJugador " + (i + 1) + ": Tirando dado...");
			int extras = random.nextInt(5) + 1;
			System.out.println("Se añadieron " + extras + " cartas extras.");
			
			jugadores.get(i).anadirCartas(baraja.repartir(extras));
		}
	}
	
	public void comprobarCantidadCartasJugador(int i) {
		Random random = new Random();
		
		if (jugadores.get(i).getCartas().isEmpty()) {
			System.out.println("¡Te quedaste sin cartas!\nSe tirará el dado y perderás 3 puntos...");
			
			int extras = random.nextInt(5) + 1;
			System.out.println("Se te añadieron " + extras + " cartas nuevas.\n");
			
			jugadores.get(i).getCartas().addAll(baraja.repartir(extras));
			jugadores.get(i).aumentarPuntaje(-3);
			
			System.out.println(jugadores.get(i).toString(i + 1));
		}
	}
	
	private int obtenerMayorPuntaje() {
		int mayorPuntaje = 0;
		
		for (Jugador jugador : jugadores) {
			if (jugador.getCartaTirada().getValor() > mayorPuntaje) {
				mayorPuntaje = jugador.getCartaTirada().getValor();
			}
		}
		
		return mayorPuntaje;
	}
	
	private int obtenerMayorPuntaje(ArrayList<Integer> jugadores) {
		int mayorPuntaje = 0;
		
		for (Integer integer : jugadores) {
			if (this.jugadores.get(integer).getCartaTirada().getValor() > mayorPuntaje) {
				mayorPuntaje = this.jugadores.get(integer).getCartaTirada().getValor();
			}
		}
		
		return mayorPuntaje;
	}
	
	public ArrayList<Integer> obtenerJugadoresMayorPuntaje() {
		ArrayList<Integer> jugadoresMayores = new ArrayList<Integer>();
		
		for (int i = 0; i < this.jugadores.size(); i++) {
			if (jugadores.get(i).getCartaTirada().getValor() == obtenerMayorPuntaje()) {
				jugadoresMayores.add(i);
			}
		}
		
		return jugadoresMayores;
	}
	
	public ArrayList<Integer> obtenerJugadoresMayorPuntaje(ArrayList<Integer> integers) {
		ArrayList<Integer> jugadoresMayores = new ArrayList<Integer>();
		
		for (Integer integer : integers) {
			if (jugadores.get(integer).getCartaTirada().getValor() == obtenerMayorPuntaje(integers)) {
				jugadoresMayores.add(integer);
			}
		}
		
		return jugadoresMayores;
	}
	
	public ArrayList<Integer> obtenerGanadores() {
		int puntajeGanador = 0;
		
		for (int i = 1; i < jugadores.size(); i++) {
			if (jugadores.get(i).getPuntaje() > jugadores.get(puntajeGanador).getPuntaje()) {
				puntajeGanador = i;
			}
		}
		
		ArrayList<Integer> ganadores = new ArrayList<Integer>();
				
		for (int i = 0; i < jugadores.size(); i++) {
			if (jugadores.get(i).getPuntaje() == puntajeGanador) {
				ganadores.add(i);
			}
		}
		
		return ganadores;
	}

	public Baraja getBaraja() {
		return baraja;
	}
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
}

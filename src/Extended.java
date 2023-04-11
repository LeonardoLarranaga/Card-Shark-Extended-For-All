import java.util.Scanner;
import java.util.ArrayList;

public class Extended {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner stringScanner = new Scanner(System.in);
		
		Juego juego = new Juego();
		
		System.out.println("\t\t\t\tCard Shark Extended for All");
		
		System.out.println("Ingesa la cantida de jugadores:");
		int cantidadJugadores = scanner.nextInt();
		
		while (cantidadJugadores < 2 || cantidadJugadores > 100) {
			System.out.println("La cantidad de jugadores debe ser entre 2 y 100.");
			System.out.println("Ingesa la cantida de jugadores:");
			cantidadJugadores = scanner.nextInt();
		}
		
		juego.agregarMazosExtra(cantidadJugadores);
		juego.getBaraja().barajar();
		
		juego.asignarCartasAJugadores(cantidadJugadores);
		
		System.out.println("\n\nPresionen enter para comenzar el juego...");
		stringScanner.nextLine();
		
		// rondas.
		
		for (int i = 0; i < 10; i++) {	
			for (int j = 0; j < juego.getJugadores().size(); j++) {
				limpiarPantalla();
				
				System.out.println("Ronda " + (i + 1) + " / 10");
				
				System.out.println(juego.getJugadores().get(j).toString(j + 1));
				
				juego.comprobarCantidadCartasJugador(j);
				
				juego.getJugadores().get(j).tirarCarta(scanner);
			}
			
			limpiarPantalla();
			
			// comparar jugadores.
			
			ArrayList<Integer> jugadoresMayores = juego.obtenerJugadoresMayorPuntaje();
			
			if (jugadoresMayores.size() > 1) {
				System.out.println("¡Hubo un empate entre varios jugadores! Cada uno ingresará otra carta.");
				
				for (Integer integer : jugadoresMayores) {
					System.out.println(juego.getJugadores().get(integer).toString(integer + 1));
					juego.getJugadores().get(integer).tirarCarta(scanner);
					limpiarPantalla();
				}
				
				jugadoresMayores = juego.obtenerJugadoresMayorPuntaje(jugadoresMayores);
				
				if (jugadoresMayores.size() > 1) {
					System.out.println("¡Hubo un empate! Los siguientes jugadores ganaron la ronda:");
					
					for (Integer integer : jugadoresMayores) {
						System.out.println("Jugador " + integer);
						juego.getJugadores().get(integer).aumentarPuntaje(1);
					}
					
				} else {
					System.out.println("¡Jugador " + (jugadoresMayores.get(0) + 1) + " ganó está ronda!");
					juego.getJugadores().get(jugadoresMayores.get(0)).aumentarPuntaje(2);
				}
				
			} else {
				System.out.println("¡Jugador " + (jugadoresMayores.get(0) + 1) + " ganó está ronda!");
				juego.getJugadores().get(jugadoresMayores.get(0)).aumentarPuntaje(2);
			}
			
			System.out.println("Presionen enter para continuar...");
			stringScanner.nextLine();
			limpiarPantalla();
		}
		
		System.out.println("RESULTADOS:\n");
		
		for (int i = 0; i < cantidadJugadores; i++) {
			System.out.println("Jugador " + (i + 1) + ": " + juego.getJugadores().get(i).getPuntaje() + " puntos.");
		}
		
		if (juego.obtenerGanadores().size() > 1) {
			System.out.println("\n¡Hubo varios ganadores!");
		} 
		
		for (Integer ganador: juego.obtenerGanadores()) {
			System.out.println("\n✰✰✰✰✰ ¡Ganó el Jugador " + (ganador + 1) + "! ✰✰✰✰✰");
		}
		
		scanner.close();
		stringScanner.close();
	}
	
	private static void limpiarPantalla() {
		for (int i = 0; i < 50; i++) System.out.println();
	}
}
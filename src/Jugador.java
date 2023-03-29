import java.util.ArrayList;
import java.util.Scanner;

public class Jugador {
	private ArrayList<Carta> cartas;
	private Carta cartaTirada;
	private int puntaje;
	
	public Jugador(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
	public void anadirCartas(ArrayList<Carta> cartas) {
		this.cartas.addAll(cartas);
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void aumentarPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}
	
	public void tirarCarta(Scanner scanner) {
		System.out.println("Elige el número de la carta que quieres tirar:");
		int carta = scanner.nextInt();
		
		while (carta < 1 && carta > cartas.size() + 1) {
			System.out.println("Carta inválida.");
			System.out.println("Elige el número de la carta que quieres tirar:");
			carta = scanner.nextInt();
		}
		
		cartaTirada = cartas.get(carta - 1);
		cartas.remove(carta - 1);
	}
	
	public Carta getCartaTirada() {
		return cartaTirada;
	}
	
	public String toString(int numeroJugador) {
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("Jugador " + numeroJugador + "\nCartas:\n");
		
		for (int i = 0; i < cartas.size(); i++) {
			stringBuffer.append((i + 1) + ". " + cartas.get(i).toString() + "\n");
		}
		
		return stringBuffer.toString();
	}
}

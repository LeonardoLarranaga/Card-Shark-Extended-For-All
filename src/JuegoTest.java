import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JuegoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAgregarMazosExtra() {
		Juego instance = new Juego();
		
		instance.agregarMazosExtra(4);
		int result = instance.getBaraja().getMazo().size();
		
		assertEquals(52 * 3, result);
	}

	@Test
	public void testAsignarCartasAJugadores() {
		Juego instance = new Juego();
		instance.asignarCartasAJugadores(1);
		
		int cantidad = instance.getJugadores().get(0).getCartas().size();
		boolean result = cantidad > 1 && cantidad <= 10;
		
		assertEquals(true, result);
	}

	@Test
	public void testComprobarCantidadCartasJugador() {
		Juego instance = new Juego();
		
		instance.getJugadores().add(new Jugador(new ArrayList<Carta>()));
		
		instance.comprobarCantidadCartasJugador(0);
		
		int result = instance.getJugadores().get(0).getPuntaje();
		
		assertEquals(-3, result);
	}

	@Test
	public void testObtenerJugadoresMayorPuntaje() throws FueraDeRangoException {
		Juego instance = new Juego();
		
		instance.getJugadores().add(new Jugador(new ArrayList<Carta>()));
		instance.getJugadores().add(new Jugador(new ArrayList<Carta>()));
		
		instance.getJugadores().get(0).getCartas().add(new Carta("K", Figura.TREBOLES));
		System.out.println("Introduce 1.");
		instance.getJugadores().get(0).tirarCarta(new Scanner(System.in));
		
		instance.getJugadores().get(1).getCartas().add(new Carta(7, Figura.TREBOLES));
		System.out.println("Introduce 1.");
		instance.getJugadores().get(1).tirarCarta(new Scanner(System.in));
		
		ArrayList<Integer> result = instance.obtenerJugadoresMayorPuntaje();
		
		ArrayList<Integer> expResult = new ArrayList<Integer>();
		expResult.add(0);
		
		assertEquals(expResult.get(0), result.get(0));
	}

	@Test
	public void testObtenerGanadores() {
		Juego instance = new Juego();
		
		instance.getJugadores().add(new Jugador(new ArrayList<Carta>()));
		instance.getJugadores().add(new Jugador(new ArrayList<Carta>()));
		
		instance.getJugadores().get(0).aumentarPuntaje(-5);
		instance.getJugadores().get(1).aumentarPuntaje(9);
		
		ArrayList<Integer> result = instance.obtenerGanadores();
		
		ArrayList<Integer> expResult = new ArrayList<Integer>();
		expResult.add(1);
		
		assertEquals(expResult, result);
	}

	@Test
	public void testGetBaraja() {
		Juego instance = new Juego();
		Baraja result = instance.getBaraja();
		Baraja expResult = new Baraja();
		
		assertEquals(expResult.toString(), result.toString());
	}

	@Test
	public void testGetJugadores() {
		Juego instance = new Juego();
		ArrayList<Jugador> result = instance.getJugadores();
		ArrayList<Jugador> expResult = new ArrayList<Jugador>();
		
		assertEquals(result, expResult);
	}

}

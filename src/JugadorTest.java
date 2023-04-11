import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JugadorTest {

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
	public void testJugador() {
		Jugador instance = new Jugador(new ArrayList<Carta>());
		
		ArrayList<String> results = new ArrayList<String>();
		results.add(instance.getPuntaje() + "");
		results.add(instance.getCartas().toString());
		
		ArrayList<String> expResults = new ArrayList<String>();
		expResults.add("0");
		expResults.add(new ArrayList<Carta>().toString());
		
		assertEquals(expResults, results);
	}

	@Test
	public void testGetCartas() throws FueraDeRangoException {
		Jugador instance = new Jugador(new ArrayList<Carta>());
		instance.getCartas().add(new Carta("A", Figura.CORAZONES));
		
		ArrayList<Carta> expResult = new ArrayList<Carta>();
		expResult.add(new Carta("A", Figura.CORAZONES));
		
		ArrayList<Carta> result = instance.getCartas();
		
		assertEquals(expResult.toString(), result.toString());
	}

	@Test
	public void testAnadirCartas() throws FueraDeRangoException {
		Jugador instance = new Jugador(new ArrayList<Carta>());
		
		ArrayList<Carta> expResult = new ArrayList<Carta>();
		expResult.add(new Carta("A", Figura.CORAZONES));
		
		instance.anadirCartas(expResult);
		
		ArrayList<Carta> result = instance.getCartas();
		
		assertEquals(expResult.toString(), result.toString());
	}

	@Test
	public void testGetPuntaje() {
		testAumentarPuntaje();
	}

	@Test
	public void testAumentarPuntaje() {
		Jugador instance = new Jugador(new ArrayList<Carta>());
		instance.aumentarPuntaje(2);
		
		int result = instance.getPuntaje();
		
		assertEquals(2, result);
	}

	@Test
	public void testTirarCarta() throws FueraDeRangoException {
		Jugador instance = new Jugador(new ArrayList<Carta>());
		instance.getCartas().add(new Carta("A", Figura.CORAZONES));
		
		System.out.println("Escribe 1 para completar el JTest.");
		instance.tirarCarta(new Scanner(System.in));
		
		int result = instance.getCartas().size();
		
		assertEquals(0, result);
	}

	@Test
	public void testGetCartaTirada() throws FueraDeRangoException {
		Jugador instance = new Jugador(new ArrayList<Carta>());
		instance.getCartas().add(new Carta("A", Figura.CORAZONES));
		
		System.out.println("Escribe 1 para completar el JTest.");
		instance.tirarCarta(new Scanner(System.in));
		Carta result = instance.getCartaTirada();
		Carta expResult = new Carta("A", Figura.CORAZONES);
		
		assertEquals(result.toString(), expResult.toString());
	}

	@Test
	public void testToStringInt() throws FueraDeRangoException {
		Jugador instance = new Jugador(new ArrayList<Carta>());
		instance.getCartas().add(new Carta("A", Figura.CORAZONES));
		
		String result = instance.toString(1);
		
		String expResult = "Jugador 1\nCartas:\n1. " + new Carta("A", Figura.CORAZONES).toString() + "\n";
		
		assertEquals(result, expResult);
	}

}

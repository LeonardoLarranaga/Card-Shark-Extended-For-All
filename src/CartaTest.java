import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CartaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Probando clase Carta");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando pruebas de la clase Carta");
	}

	@Test
	public void testGetValor() throws FueraDeRangoException {
		System.out.println("getValor");
		
		Carta instance = new Carta("k", Figura.DIAMANTES);
		int expResult = 13;
		int result = instance.getValor();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testGetFigura() throws FueraDeRangoException {
		System.out.println("getFigura");
		
		Carta instance = new Carta("k", Figura.DIAMANTES);
		Figura expResult = Figura.DIAMANTES;
		Figura result = instance.getFigura();
		
		assertEquals(expResult, result);
	}

	@Test
	public void testGetColor() throws FueraDeRangoException {
		System.out.println("getColor");
		
		Carta instance = new Carta("k", Figura.DIAMANTES);
		Color expResult = Color.ROJO;
		Color result = instance.getColor();
		
		assertEquals(expResult, result);
	}
}

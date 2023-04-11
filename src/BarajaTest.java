import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BarajaTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Probando clase Baraja.");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Terminando pruebas de la clase Baraja.");
	}

	@Test
	public void testGetMazo() throws FueraDeRangoException {
		Baraja instance = new Baraja();
		
		Carta expResult = new Carta(1, Figura.CORAZONES);
		Carta result = instance.getMazo().get(0);
		
		assertEquals(expResult.toString(), result.toString());
	}

	@Test
	public void testRepartir() throws FueraDeRangoException {
		Baraja instance = new Baraja();
		
		Baraja expResult = new Baraja();
		expResult.getMazo().remove(0);
		
		instance.repartir(1);
		String result = instance.toString();
		
		assertEquals(expResult.toString(), result);
	}
}

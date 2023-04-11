package tp9;

import outils.*;

import static org.junit.Assert.*;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class testVerifierPixel {
	private TP9 obj = new TP9();
	private Method m;
	private static String METHOD_NAME = "verifierPixel";


	@Before
	public void init() throws Exception {
		m = obj.getClass().getMethod(METHOD_NAME, Pixel.class);
	}

	@Test
	public void testSaturation1() throws Exception {
		outils.Pixel p = new outils.Pixel(300, 256, 43);
		outils.Pixel goodP = new outils.Pixel(255, 255, 43);
		m.invoke(obj, p);
		assertEquals(p.toString(), goodP.toString());
	}

	@Test
	public void testSaturation2() throws Exception {
		outils.Pixel p = new outils.Pixel(-13, 54, 345);
		outils.Pixel goodP = new outils.Pixel(0, 54, 255);
		m.invoke(obj, p);
		assertEquals(p.toString(), goodP.toString());
	}

	@Test
	public void testNoSaturation() throws Exception {
		outils.Pixel p = new outils.Pixel(12, 24, 54);
		outils.Pixel goodP = new outils.Pixel(12, 24, 54);
		m.invoke(obj, p);
		assertEquals(p.toString(), goodP.toString());
	}

}
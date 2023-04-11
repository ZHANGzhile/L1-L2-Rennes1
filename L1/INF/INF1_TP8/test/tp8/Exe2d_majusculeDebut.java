package tp8;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe2d_majusculeDebut {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "majusculeDebut";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, String.class);
    }

	@Test
	public void test1() throws Exception {
		assertEquals(m.invoke(obj, "l'eXamen ne sera pas TROP dur"), "L'examen Ne Sera Pas Trop Dur");
	}

	@Test
	public void test2() throws Exception {
		assertEquals(m.invoke(obj, "aujOUrd'huI, Il fAIT beAu !"), "Aujourd'hui, Il Fait Beau !");
	}

	@Test
	public void test3() throws Exception {
		assertEquals(m.invoke(obj, "Abcd"), "Abcd");
	}

	@Test
	public void test4() throws Exception {
		assertEquals(m.invoke(obj, "z"), "Z");
	}

}

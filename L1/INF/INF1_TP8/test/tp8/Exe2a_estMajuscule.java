package tp8;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe2a_estMajuscule {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "estMajuscule";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, char.class);
    }

	@Test
	public void testA() throws Exception {
		assertEquals(m.invoke(obj, 'A'), true);
	}

	@Test
	public void testZ() throws Exception {
		assertEquals(m.invoke(obj, 'Z'), true);
	}

	@Test
	public void testN() throws Exception {
		assertEquals(m.invoke(obj, 'N'), true);
	}

	@Test
	public void testa() throws Exception {
		assertEquals(m.invoke(obj, 'a'), false);
	}

	@Test
	public void testz() throws Exception {
		assertEquals(m.invoke(obj, 'z'), false);
	}

	@Test
	public void testr() throws Exception {
		assertEquals(m.invoke(obj, 'r'), false);
	}

	@Test
	public void test() throws Exception {
		assertEquals(m.invoke(obj, ' '), false);
	}
}

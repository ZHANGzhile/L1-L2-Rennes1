package tp8;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe2a_estLettre {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "estLettre";

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
		assertEquals(m.invoke(obj, 'a'), true);
	}

	@Test
	public void testz() throws Exception {
		assertEquals(m.invoke(obj, 'z'), true);
	}

	@Test
	public void testr() throws Exception {
		assertEquals(m.invoke(obj, 'r'), true);
	}

	@Test
	public void test() throws Exception {
		assertEquals(m.invoke(obj, ' '), false);
	}

	@Test
	public void test2() throws Exception {
		assertEquals(m.invoke(obj, '?'), false);
	}

	@Test
	public void test3() throws Exception {
		assertEquals(m.invoke(obj, ','), false);
	}


}

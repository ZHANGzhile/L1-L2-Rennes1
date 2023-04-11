package tp8;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe1d_remplacer {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "remplacer";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, String.class, char.class, char.class);
    }

	@Test
	public void test1() throws Exception {
		assertEquals(m.invoke(obj, "gramme", 'm', 'p'), "grappe");
	}

	@Test
	public void test2() throws Exception {
		assertEquals(m.invoke(obj, "Bonjour", 'o', 'x'), "Bxnjxur");
	}

	@Test
	public void test3() throws Exception {
		assertEquals(m.invoke(obj, "CeciXestXunXtest", 'X', ' '), "Ceci est un test");
	}

	@Test
	public void test4() throws Exception {
		assertEquals(m.invoke(obj, "", 'a', 'b'), "");
	}

	@Test
	public void test5() throws Exception {
		assertEquals(m.invoke(obj, "aaaa", 'a', 'b'), "bbbb");
	}

	@Test
	public void test6() throws Exception {
		assertEquals(m.invoke(obj, "identique", 'x', 'y'), "identique");
	}
}

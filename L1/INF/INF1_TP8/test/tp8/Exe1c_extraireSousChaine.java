package tp8;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe1c_extraireSousChaine {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "extraireSousChaine";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, String.class, int.class, int.class);
    }

	@Test
	public void test1() throws Exception {
		assertEquals(m.invoke(obj, "Bonjour", 0, 2), "Bon");
	}

	@Test
	public void test2() throws Exception {
		assertEquals(m.invoke(obj, "Bonjour", 2, 5), "njou");
	}


	@Test
	public void test3() throws Exception {
		assertEquals(m.invoke(obj, "Ceci est un test", 12, 15), "test");
	}


	@Test
	public void test4() throws Exception {
		assertEquals(m.invoke(obj, "Est-ce que ca marche ?", 11, 19), "ca marche");
	}

	@Test
	public void test5() throws Exception {
		assertEquals(m.invoke(obj, "AAA", 2, 1), "");
	}
}

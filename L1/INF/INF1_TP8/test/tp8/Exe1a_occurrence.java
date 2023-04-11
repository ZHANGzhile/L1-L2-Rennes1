package tp8;

import static org.junit.Assert.*;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe1a_occurrence {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "occurrence";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, String.class, char.class);
    }
	

	@Test
	public void test1() throws Exception {
		assertEquals(m.invoke(obj, "Bonjour", 'o'), 2);
	}

	@Test
	public void test2() throws Exception {
		assertEquals(m.invoke(obj, "Un test", 'a'), 0);
	}

	@Test
	public void test3() throws Exception {
		assertEquals(m.invoke(obj, "Pour qui sont ces serpents qui sifflent sur vos tetes?", 's'), 8);
	}

	@Test
	public void test4() throws Exception {
		assertEquals(m.invoke(obj, "                       ", ' '), 23);
	}

	@Test
	public void test5() throws Exception {
		assertEquals(m.invoke(obj, "", 'X'), 0);
	}
}

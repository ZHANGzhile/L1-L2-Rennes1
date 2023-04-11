package tp8;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe2c_minusculeChaine {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "minusculeChaine";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, String.class);
    }

	@Test
	public void test1() throws Exception {
		assertEquals(m.invoke(obj, "l’eXamen ne sera pas TROP dur"), "l’examen ne sera pas trop dur");
	}

	@Test
	public void test2() throws Exception {
		assertEquals(m.invoke(obj, ""), "");
	}
	
	@Test
	public void test3() throws Exception {
		assertEquals(m.invoke(obj, "zzzzzz"), "zzzzzz");
	}
	
	@Test
	public void test4() throws Exception {
		assertEquals(m.invoke(obj, "ZZZZZZ"), "zzzzzz");
	}

	@Test
	public void test5() throws Exception {
		assertEquals(m.invoke(obj, "abc.,;:!ABC*/?- "), "abc.,;:!abc*/?- ");
	}

}

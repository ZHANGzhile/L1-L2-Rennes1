package tp8;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe2b_majusculeChar {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "majusculeChar";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, char.class);
    }

	@Test
	public void test1() throws Exception {
		assertEquals(m.invoke(obj, 'a'), 'A');
	}

	@Test
	public void test2() throws Exception {
		assertEquals(m.invoke(obj, 'z'), 'Z');
	}
	
	@Test
	public void test3() throws Exception {
		assertEquals(m.invoke(obj, 'B'), 'B');
	}
	
	@Test
	public void test4() throws Exception {
		assertEquals(m.invoke(obj, 'Y'), 'Y');
	}

	@Test
	public void test5() throws Exception {
		assertEquals(m.invoke(obj, '?'), '?');
	}

	@Test
	public void test6() throws Exception {
		assertEquals(m.invoke(obj, ' '), ' ');
	}

}
package tp8;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe3b_comptageMot {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "comptageMot";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, String.class, int.class);
    }

	@Test
	public void test1() throws Exception {
		assertEquals(m.invoke(obj, "Aujourd'hui, il a plu!", 3), 2);
	}
	
	@Test
	public void test2() throws Exception {
		assertEquals(m.invoke(obj, "aa-b;ccc?d:ee,fff.gg", 1), 2);
	}
	
	@Test
	public void test3() throws Exception {
		assertEquals(m.invoke(obj, "aa-b;ccc?d:ee,fff.gg", 2), 3);
	}
	
	
	@Test
	public void test4() throws Exception {
		assertEquals(m.invoke(obj, "aa-b;ccc?d:ee,fff.gg", 3), 2);
	}

	@Test
	public void test5() throws Exception {
		assertEquals(m.invoke(obj, "A", 10), 0);
	}

	@Test
	public void test6() throws Exception {
		assertEquals(m.invoke(obj, "", 100), 0);
	}
}

package tp8;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class Exe1b_estPalindrome {
	
	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "estPalindrome";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, String.class);
    }
	
	@Test
	public void test1() throws Exception {
		assertEquals(m.invoke(obj, "palindrome"), false);
	}

	@Test
	public void test2() throws Exception {
		assertEquals(m.invoke(obj, "radar"), true);
	}

	@Test
	public void test3() throws Exception {
		assertEquals(m.invoke(obj, "ressasser"), true);
	}

	@Test
	public void test4() throws Exception {
		assertEquals(m.invoke(obj, "abcdeedcba"), true);
	}

	@Test
	public void test5() throws Exception {
		assertEquals(m.invoke(obj, ""), true);
	}

	@Test
	public void test6() throws Exception {
		assertEquals(m.invoke(obj, "A"), true);
	}
}

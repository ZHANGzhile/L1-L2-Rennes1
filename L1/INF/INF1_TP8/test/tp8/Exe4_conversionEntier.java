package tp8;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class Exe4_conversionEntier {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "conversionEntier";

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, String.class);
    }

	@Test
	public void test123() throws Exception {
		assertEquals(m.invoke(obj, "123"), 123);
	}

	@Test
	public void test0() throws Exception {
		assertEquals(m.invoke(obj, "0"), 0);
	}

	@Test
	public void test1() throws Exception {
		assertEquals(m.invoke(obj, "1"), 1);
	}

	@Test
	public void test1000000() throws Exception {
		assertEquals(m.invoke(obj, "1000000"), 1000000);
	}

	@Test
	public void test8817301() throws Exception {
		assertEquals(m.invoke(obj, "8817301"), 8817301);
	}

	@Test
	public void test9448252() throws Exception {
		assertEquals(m.invoke(obj, "9448252"), 9448252);
	}

	@Test
	public void test159557469() throws Exception {
		assertEquals(m.invoke(obj, "159557469"), 159557469);
	}

	@Test
	public void test736735708() throws Exception {
		assertEquals(m.invoke(obj, "736735708"), 736735708);
	}

	@Test
	public void test506608269() throws Exception {
		assertEquals(m.invoke(obj, "506608269"), 506608269);
	}

	@Test
	public void test688474133() throws Exception {
		assertEquals(m.invoke(obj, "688474133"), 688474133);
	}

	@Test
	public void test129524154() throws Exception {
		assertEquals(m.invoke(obj, "129524154"), 129524154);
	}

	@Test
	public void test79886814() throws Exception {
		assertEquals(m.invoke(obj, "79886814"), 79886814);
	}
}

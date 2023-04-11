package tp8;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Exe1e_enumererSousChaines {

	private TP8 obj = new TP8();
    private Method m;
    private static String METHOD_NAME = "enumererSousChaines";
    
	private final PrintStream systemOut = System.out;
	private ByteArrayOutputStream testOut;

    @Before
	public void init() throws Exception {
    	m = obj.getClass().getMethod(METHOD_NAME, String.class);

	    testOut = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(testOut));
    }


	@After
	public void restoreSystemOutput() {
		System.setOut(systemOut);
	}


	@Test
	public void test0() throws Exception {
		m.invoke(obj, "");
		String expected = "";

		assertEquals(expected, testOut.toString());
	}


	@Test
	public void test1() throws Exception {
		m.invoke(obj, "a");
		String expected = "a\n";

		assertEquals(expected, testOut.toString());
	}


	@Test
	public void test2() throws Exception {
		m.invoke(obj, "ab");
		String expected = 
				"a\n" +
				"b\n" +
				"ab\n";

		assertEquals(expected, testOut.toString());
	}

	@Test
	public void test3() throws Exception {
		m.invoke(obj, "abc");
		String expected = 
				"a\n" +  
				"b\n" +  
				"c\n" +  
				"ab\n" +  
				"bc\n" +  
				"abc\n";

		assertEquals(expected, testOut.toString());
	}


	@Test
	public void test4() throws Exception {
		m.invoke(obj, "abcd");
		String expected = 
				"a\n" +  
				"b\n" +  
				"c\n" +  
				"d\n" +  
				"ab\n" +  
				"bc\n" +  
				"cd\n" +  
				"abc\n" +  
				"bcd\n" +  
				"abcd\n";

		assertEquals(expected, testOut.toString());
	}


	@Test
	public void test5() throws Exception {
		m.invoke(obj, "abcde");
		String expected = 
				"a\n" +  
				"b\n" +  
				"c\n" +  
				"d\n" +  
				"e\n" +  
				"ab\n" +  
				"bc\n" +  
				"cd\n" +  
				"de\n" +  
				"abc\n" +  
				"bcd\n" +  
				"cde\n" +  
				"abcd\n" + 
				"bcde\n" +  
				"abcde\n";

		assertEquals(expected, testOut.toString());
	}

}

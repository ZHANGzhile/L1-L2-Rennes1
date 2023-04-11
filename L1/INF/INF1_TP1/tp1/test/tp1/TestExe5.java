package tp1;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestExe5 {

	  private final InputStream systemIn = System.in;
	  private final PrintStream systemOut = System.out;
	  private ByteArrayInputStream testIn;
	  private ByteArrayOutputStream testOut;

	  @Before
	  public void setUpOutput() {
	    testOut = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(testOut));
	  }

	  @After
	  public void restoreSystemInputOutput() {
	    System.setIn(systemIn);
	    System.setOut(systemOut);
	  }

	  private void provideInput(String data) {
	    testIn = new ByteArrayInputStream(data.getBytes());
	    System.setIn(testIn);
	  }

	//@Ignore("commenter pour tester l'Exe5, enlever le commentaire à la fin du test de l'Exe5")
	@Test
	public void testConversionSecondCasImpaire() {
		String expected = "La somme des trois entiers est impaire.\n"; 
		String input = 5 + System.lineSeparator() + 5 + System.lineSeparator() + 5 + System.lineSeparator();
	    provideInput(input);
		Exe5.main(null);
		assertEquals(expected, testOut.toString());
	}
	
	//@Ignore("commenter pour tester l'Exe5, enlever le commentaire à la fin du test de l'Exe5")
	@Test
	public void testConversionSecondCasPaire() {
		String expected = "La somme des trois entiers est paire.\n"; 
		String input = 5 + System.lineSeparator() + 6 + System.lineSeparator() + 5 + System.lineSeparator();
		provideInput(input);
		Exe5.main(null);
		assertEquals(expected, testOut.toString());
	}

}

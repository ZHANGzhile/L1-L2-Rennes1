package tp9;

import outils.*;

import static org.junit.Assert.*;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class testSepia {
	TP9 obj = new TP9();
	private Method mat;
    private static String NAME_MAT = "calculSepia";

    @Before
    public void initMat() throws Exception {
    	mat = obj.getClass().getMethod(NAME_MAT, Pixel.class);
    }

	@Test
	public void testCalculSepia() throws Exception {
		Pixel p = new Pixel(135, 64, 84);
		mat.invoke(obj, p);
		Pixel res = new Pixel(118, 105, 82);
		assertEquals(p.toString(), res.toString());
	}

}
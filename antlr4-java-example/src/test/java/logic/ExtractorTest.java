package logic;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Simple test of {@link Extractor}.
 * 
 * @author Sven Meyer
 * @version 1.0.0
 * @since 1.0.0
 */
public class ExtractorTest {

	@Test
	public void test() throws Exception {
		/** Prepare. */
		// String = clazzName, Integer = methodCount
		Map<String, Integer> result = new HashMap<>();

		/** Execute. */
		Extractor e = new Extractor();
		result = e.extract(new File("src/main/resources/Cat.java"));

		/** Test. */
		// clazzName should be Cat
		assertTrue(result.keySet().contains("Cat"));
		// count of methods should be 4
		assertEquals(new Integer(4), result.get("Cat"));
	}
}
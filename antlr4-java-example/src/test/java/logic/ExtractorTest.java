/**
 * Copyright (c) 2015 Sven Meyer, Leotas Software Solutions, Germany
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
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
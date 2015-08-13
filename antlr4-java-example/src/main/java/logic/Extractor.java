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

import generated.JavaLexer;
import generated.JavaParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Reads one file and extracts metrics using ANTLR.
 * 
 * @author Sven Meyer
 * @version 1.0.0
 * @since 1.0.0
 * 
 * @see https://theantlrguy.atlassian.net/wiki/display/ANTLR4/Parse+Tree+Listeners
 */
public class Extractor {

	/**
	 * Returns a map, containing clazzName and count of methods, for the given
	 * file.
	 * 
	 * Based upon the <a href=
	 * "https://theantlrguy.atlassian.net/wiki/display/ANTLR4/Parse+Tree+Listeners">ANTLR-Tutorial</a>
	 * 
	 * @param importFile
	 *            The file to import.
	 * @return A map containing the clazzName and count of methods, extracted
	 *         from {@code importFile}.
	 * @throws Exception
	 *             IO- and ANTLR-Exceptions, not catched for simplicity.
	 */
	public Map<String, Integer> extract(File importFile) throws Exception {

		/** Prepare input for ANTLR. */
		InputStream is = new FileInputStream(importFile.getAbsolutePath());
		ANTLRInputStream input = new ANTLRInputStream(is);
		JavaLexer lexer = new JavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JavaParser parser = new JavaParser(tokens);

		/** Parse. */
		ParseTree tree = parser.compilationUnit();

		/** Create standard walker. */
		ParseTreeWalker walker = new ParseTreeWalker();

		/** Initiate walk of tree with listener. */
		Listener listener = new Listener(parser);
		walker.walk(listener, tree);

		/** Save the results. */
		Map<String, Integer> result = new HashMap<>();
		result.put(listener.getClazzName(), listener.getMethodCount());

		return result;
	}
}
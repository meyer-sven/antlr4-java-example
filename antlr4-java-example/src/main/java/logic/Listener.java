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

import generated.JavaBaseListener;
import generated.JavaParser;

/**
 * Listens to Events, if ANTLR walks a parse tree.
 *
 * @author Sven Meyer
 * @version 1.0.0
 * @since 1.0.0
 */
public class Listener extends JavaBaseListener {

	/** Observable. */
	JavaParser parser;

	/** The clazzName of the imported file. */
	private String clazzName;

	/** The count of methdos of the imported file. */
	private int methodCount;

	public Listener(JavaParser parser) {
		this.parser = parser;
	}

	/** Listen to matches of classDeclaration */
	@Override
	public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
		setClazzName(ctx.Identifier().toString());
	}

	/** Listen to matches of methodDeclaration */
	@Override
	public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
		methodCount++;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public int getMethodCount() {
		return methodCount;
	}

	public void setMethodCount(int methodCount) {
		this.methodCount = methodCount;
	}
}
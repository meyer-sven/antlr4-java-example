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
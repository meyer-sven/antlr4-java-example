/**
 * A cat is a cat is a cat.
 * 
 */
public class Cat {

	private String name;

	private int height;

	public Cat(String name, int height) {
		setName(name);
		setHeight(height);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
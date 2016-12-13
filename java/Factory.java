class Factory {
	public Shape getit(String ty) {
		if ( ty == "One" )
			return new One();
		else if ( ty == "Two" )
			return new Two();
		else
			return null;
	}
}

interface Shape {
	void draw();
}

class One implements Shape {
	@Override
	public void draw() {
		System.out.println("One here");
	}
}

class Two implements Shape {
	@Override
	public void draw() {
		System.out.println("Two here");
	}
}

class Test {
	public static void main(String[] args) {
		Factory f = new Factory();
		Shape s1 = f.getit("One");
		s1.draw();
		Shape s2 = f.getit("Two");
		s2.draw();
}}

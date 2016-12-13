class Sing {
	private static Sing instance = new Sing();

	private Sing() {}

	public static Sing getIns() {
		return instance;
}}

class Test {
	public static void main(String[] args) {
		Sing obj = Sing.getIns();
}}

	

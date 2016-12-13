import java.util.ArrayList;
import java.util.List;

class Books {
	private List<Obser> obs = new ArrayList<Obser>();
	private int state;

	public int get() {
		return state;
	}
	
	public void set(int i){
		this.state = i;
		try {
			notifiyAll();
		} catch ( Exception e) {
			System.err.println("Excpetion: " + e.getMessage());
		}
	}

	public void add(Obser obser) {
		obs.add(obser);
	}

	public void notifiyAll() {
		for(Obser o : obs) {
			o.gotit();
		}
	}
}

class Obser {
	public String name;	
	private Books books;

	public Obser(String s, Books b) {
		this.name = s;
		this.books = b;
		this.books.add(this);
	}

	public void gotit() {
		System.out.println(name + " got it: " + books.get());
	}
}	

class TestIt {
	public static void main(String [] args){
		Books b = new Books();

		Obser o1 = new Obser("one", b);
		Obser o2 = new Obser("two", b);

		b.set(12);
		b.set(210);
		
}}	

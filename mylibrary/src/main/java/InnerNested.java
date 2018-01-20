
public class InnerNested {
	
	String test1;
	int test2;
	Inner inner;
	Nested nested;
	
	
	public InnerNested(){
		inner = new Inner();
		inner.ineerTest = "";
		nested = new Nested();
		nested.nested1 = "";
	}
	
	class Inner{
		String ineerTest;
		public Inner() {
			super();
			// TODO Auto-generated constructor stub
			ineerTest = test1;
		}
		
		
		
	}
	
	static class Nested{
		String nested1;
		public Nested() {
			super();
			// TODO Auto-generated constructor stub
			
		}
		
	}
	
	public static void main(String args[]){
		InnerNested innerNested = new InnerNested();
		Inner inner = innerNested.new Inner();
		Nested nested = new Nested();
	}
	

}

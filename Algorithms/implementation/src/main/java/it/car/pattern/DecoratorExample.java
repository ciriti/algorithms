package it.car.pattern;

public class DecoratorExample {
	
	
	/**
	 * Component Interface – The interface or abstract class defining the methods that will be implemented. 
	 * In our case Car will be the component interface.
	 *
	 */
	public interface Car{
		public void costruisci();
	}
	
	
	/**
	 * Component Implementation – The basic implementation of the component interface. 
	 * We can have BasicCar class as our component implementation.
	 *
	 */
	public static class BasicCar implements Car{

		@Override
		public void costruisci() {
			// TODO Auto-generated method stub
			System.out.println("Costruisco basic car");
		}
		
	}
	
	/**
	 * Decorator – Decorator class implements the component interface and it has a HAS-A relationship with the component interface. 
	 * The component variable should be accessible to the child decorator classes, so we will make this variable protected.
	 *
	 */
	public static class DecoratorCar implements Car{
		
		protected Car car;

		public DecoratorCar(Car car) {
			super();
			this.car = car;
		}

		@Override
		public void costruisci() {
			this.car.costruisci();
		}
		
	}
	
	/**
	 * Concrete Decorators – Extending the base decorator functionality and modifying the component behavior accordingly. 
	 * We can have concrete decorator classes as LuxuryCar and SportsCar.
	 *
	 */
	public static class SportCar extends DecoratorCar{

		public SportCar(Car car) {
			super(car);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void costruisci() {
			// TODO Auto-generated method stub
			super.costruisci();
			System.out.println("aggiungi caratteristiche di sport");
		}
		
	}
	
	public static class Berlina extends DecoratorCar{

		public Berlina(Car car) {
			super(car);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void costruisci() {
			// TODO Auto-generated method stub
			super.costruisci();
			System.out.println("aggiungi caratteristiche di Berlina");
		}
		
	}
	
	public static void main(String[] args) {
        Car sportsCar = new SportCar(new BasicCar());
        sportsCar.costruisci();
        System.out.println("\n*****");
         
        Car sportsLuxuryCar = new SportCar(new Berlina(new BasicCar()));
        sportsLuxuryCar.costruisci();
    }

}

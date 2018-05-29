package designPattern.decoratorPattern;

public abstract class PizzaMakerExample{
	public static void main(String []args) {
		Pizza tomatinaPizza = (Pizza) new TomatoSauce(new Mozzarella(new PlainPizza()));

		System.out.println("Description: " + tomatinaPizza.getDescription());

		System.out.println("Cost: " + tomatinaPizza.getCost());
		
		
		Pizza MoziPizza = (Pizza) new Mozzarella(new PlainPizza());

		System.out.println("Description: " + MoziPizza.getDescription());

		System.out.println("Cost: " + MoziPizza.getCost());
		
	}
}

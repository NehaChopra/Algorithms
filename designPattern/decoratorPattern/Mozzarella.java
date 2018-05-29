package designPattern.decoratorPattern;

public class Mozzarella extends ToppingDecorator{

	public Mozzarella(Pizza newPizza) {
		super(newPizza);
	}
	public String getDescription() {
		return pizza.getDescription() + " , Mozzarella";
	}
	
	public double getCost() {
		return pizza.getCost() + 4.00;
	}
}

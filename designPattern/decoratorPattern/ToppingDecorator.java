package designPattern.decoratorPattern;

public abstract class ToppingDecorator implements Pizza{
	protected Pizza pizza;
	
	public ToppingDecorator(Pizza newPizza) {
		this.pizza = newPizza;
	}
	
	public String getDescription() {
		return pizza.getDescription();
		
	}
	
	public double getCost() {
		return pizza.getCost();
		
	}
}

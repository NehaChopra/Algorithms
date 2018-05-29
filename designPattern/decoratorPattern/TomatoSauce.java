package designPattern.decoratorPattern;

public class TomatoSauce extends ToppingDecorator{

	public TomatoSauce(Pizza newPizza) {
		super(newPizza);
	}
	public String getDescription() {
		return pizza.getDescription() + " , TomatoSauce";
	}
	
	public double getCost() {
		return pizza.getCost() + 5.00;
	}
}
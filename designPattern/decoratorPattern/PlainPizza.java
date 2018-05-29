package designPattern.decoratorPattern;

public class PlainPizza implements Pizza{

	@Override
	public String getDescription() {
		return "Plain Base Pizza";
	}

	@Override
	public double getCost() {
		return 10.00;
	}
}

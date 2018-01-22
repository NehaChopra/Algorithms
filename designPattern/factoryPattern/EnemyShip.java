package designPattern.factoryPattern;

abstract class EnemyShip {
	protected String name;
	protected double amtDamage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmtDamage() {
		return amtDamage;
	}
	public void setAmtDamage(double amtDamage) {
		this.amtDamage = amtDamage;
	}
	
	public void followHeroShip(){
		System.out.println(this.name + " following the hero ship");
	}
	public void displayHeroShip(){
		System.out.println(this.name + " displaying the hero ship");
	}
	public void enemyShipShoots(){
		System.out.println(this.name + " damaged caused by the ship " + this.amtDamage);
	}
}

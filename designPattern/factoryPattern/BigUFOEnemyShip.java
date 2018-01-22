package designPattern.factoryPattern;

class BigUFOEnemyShip extends UFOEnemyShip{
	BigUFOEnemyShip(String name, double amtDamage){
		super(name, amtDamage);
		this.name = name;
		this.amtDamage = amtDamage;
	}
}


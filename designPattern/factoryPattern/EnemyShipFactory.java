package designPattern.factoryPattern;

class EnemyShipFactory{
	public static EnemyShip createObject(String type){
		if(type.equals("UFOEnemyShip")){
			return new UFOEnemyShip("UFOEnemyShip", 20.00);
		}else if(type.equals("RocketEnemyShip")){
			return new UFOEnemyShip("RocketEnemyShip", 10.00);
		}else if(type.equals("BigUFOEnemyShip")){
			return new BigUFOEnemyShip("BigUFOEnemyShip", 40.00);
		}else{
			return null;
		}
	}
}

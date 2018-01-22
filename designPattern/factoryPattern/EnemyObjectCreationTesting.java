package designPattern.factoryPattern;

import java.util.Scanner;

class EnemyObjectCreationTesting {
	public static void main(String []args){
		EnemyShip theEnemy = null;
		System.out.println("Select type of the EnemyShip UFOEnemyShip / RocketEnemyShip / BigUFOEnemyShip / exit");
		Scanner input = new Scanner(System.in);
		String typeOfEnemy = "";
		while((typeOfEnemy = input.nextLine()) != null){
			if(typeOfEnemy.equals("exit")){
				System.out.println("-------------------END-----------------------");
				break;
			}
			theEnemy = EnemyShipFactory.createObject(typeOfEnemy);
			if(theEnemy != null){
				doStuffWithEnemyShip(theEnemy);
			}
		}
	}
	public static void doStuffWithEnemyShip(EnemyShip theEnemy){
		theEnemy.displayHeroShip();
		theEnemy.followHeroShip();
		theEnemy.enemyShipShoots();
	}
}

package designPattern.factoryPattern;

import java.util.Scanner;


/*
 * Types of Design Patterns
 * There are mainly three types of design patterns:
 * 
 * Creational (Class-creational patterns and object-creational patterns)
 * Creational design patterns are Factory Method, Abstract Factory, Builder, Singleton, Object Pool and Prototype.
 * 
 * Structural
 * organizing different classes and objects to form larger structures and provide new functionality.
 * Structural design patterns are Adapter, Bridge, Composite, Decorator, Facade, Flyweight, Private Class Data and Proxy.
 * 
 * Behavioral
 * identifying common communication patterns between objects 
 * Behavioral patterns are Chain of responsibility, Command, Interpreter, Iterator, Mediator, Memento, Null Object, Observer, State, Strategy, Template method, Visitor
 * 
 */
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

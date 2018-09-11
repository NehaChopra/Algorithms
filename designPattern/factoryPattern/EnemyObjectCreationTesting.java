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
 * 
 * Real world examples:
 * 1. java.util.Calendar --- public static Calendar getInstance(), public static Calendar getInstance(TimeZone zone), public static Calendar getInstance(Locale aLocale), public static Calendar getInstance(TimeZone zone,
                                   Locale aLocale)
                                   
 * 2. java.text.NumberFormat ----- public static final NumberFormat getInstance(), ublic static NumberFormat getInstance(Locale inLocale), 
 * public static final NumberFormat getNumberInstance(),  public static final NumberFormat getIntegerInstance(), 
 * public static final NumberFormat getCurrencyInstance(), public static NumberFormat getPercentInstance(Locale inLocale)
 * 
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

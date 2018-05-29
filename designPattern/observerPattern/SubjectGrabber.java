package designPattern.observerPattern;

import java.util.ArrayList;

public class SubjectGrabber implements Subject{
	private ArrayList<Observer> observers;
	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;
	
	public SubjectGrabber() {
		observers = new ArrayList<Observer>();
	}
	public double getIbmPrice() {
		return ibmPrice;
	}
	public void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObserver();
	}
	public double getAaplPrice() {
		return aaplPrice;
	}
	public void setAaplPrice(double aaplPrice) {
		this.aaplPrice = aaplPrice;
		notifyObserver();
	}
	public double getGoogPrice() {
		return googPrice;
	}
	public void setGoogPrice(double googPrice) {
		this.googPrice = googPrice;
		notifyObserver();
	}
	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}
	@Override
	public void unregister(Observer observer) {
		observers.remove(observer);
	}
	@Override
	public void notifyObserver() {
		for(Observer ob : observers) {
			ob.update(ibmPrice, aaplPrice, googPrice);
		}
	}
}

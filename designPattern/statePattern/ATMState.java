package designPattern.statePattern;

public interface ATMState {
	public void insertCard();
	public void ejectCard();
	public void insertPin(int pin);
	public void requestCash(int withdrawCash);
}

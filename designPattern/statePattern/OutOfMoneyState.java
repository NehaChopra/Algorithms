package designPattern.statePattern;

public class OutOfMoneyState implements ATMState{

	ATMMachine atmMachine;
	public OutOfMoneyState(ATMMachine atmMachine) {
		this.atmMachine = atmMachine;
	}
	@Override
	public void insertCard() {
		System.out.println("We don't have any money");
		System.out.println("Your card is ejected");
	}

	@Override
	public void ejectCard() {
		System.out.println("We don't have any money");
		System.out.println("Your card is ejected");
	}

	@Override
	public void insertPin(int pin) {
		System.out.println("We don't have any money");
		System.out.println("Your card is ejected");
	}

	@Override
	public void requestCash(int withdrawCash) {
		System.out.println("We don't have any money");
		System.out.println("Your card is ejected");
	}
}

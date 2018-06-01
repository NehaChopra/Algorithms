package designPattern.statePattern;

public class NoCardState implements ATMState{
	ATMMachine atmMachine;
	public NoCardState(ATMMachine atmMachine) {
		this.atmMachine = atmMachine;
	}
	@Override
	public void insertCard() {
		System.out.println("Card is inserted into the machine !!");
		atmMachine.setAtmState(atmMachine.hasCardState());
	}

	@Override
	public void ejectCard() {
		System.out.println("Card is ejected from the machine !!");
	}

	@Override
	public void insertPin(int pin) {
		System.out.println("Pin is inserted into the machine !!");
	}

	@Override
	public void requestCash(int withdrawCash) {
		System.out.println("Request for a cash from the machine !!");
	}
}

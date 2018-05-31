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
		atmMachine.setAtmState(atmMachine.hasNoCardState());
	}

	@Override
	public void insertPin(int pin) {
		System.out.println("Pin is inserted into the machine !!");
		if(pin == 123) {
			System.out.println("Correct Pin is inserted into the machine !!");
			atmMachine.setAtmState(atmMachine.hasCorrectPinState());
		}else {
			System.out.println("Incorrrect Pin is inserted into the machine !!");
			atmMachine.setAtmState(atmMachine.hasNoCardState());
		}
	}

	@Override
	public void requestCash(int withdrawCash) {
		System.out.println("Request for a cash from the machine !!");
		atmMachine.setAtmState(atmMachine.hasNoCardState());
	}
}

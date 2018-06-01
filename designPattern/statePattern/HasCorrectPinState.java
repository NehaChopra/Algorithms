package designPattern.statePattern;

public class HasCorrectPinState implements ATMState{

	ATMMachine atmMachine;
	public HasCorrectPinState(ATMMachine atmMachine) {
		this.atmMachine = atmMachine;
	}
	@Override
	public void insertCard() {
		System.out.println("Card is inserted into the machine !!");
	}

	@Override
	public void ejectCard() {
		System.out.println("Card is ejected from the machine !!");
		atmMachine.setAtmState(atmMachine.hasNoCardState());
	}

	@Override
	public void insertPin(int pin) {
		System.out.println("Pin is inserted into the machine !!");
	}

	@Override
	public void requestCash(int withdrawCash) {
		System.out.println("Request for a cash from the machine !!");
		if(withdrawCash > atmMachine.availableCashInMachine) {
			System.out.println("Not a sufficient cash in the machine !!");
			atmMachine.setAtmState(atmMachine.hasNoCardState());
		}else {
			System.out.println("Requesting for a cash from the machine !!");
			atmMachine.setCashInMachine(atmMachine.availableCashInMachine - withdrawCash);
			atmMachine.setAtmState(atmMachine.hasNoCardState());
		}
	}
}

package designPattern.statePattern;

public class ATMMachine {
	ATMState atmState;
	
	ATMState hasCard;
	ATMState noCard;
	ATMState hasCorrectPin;
	ATMState outOfMoney;
	
	int availableCashInMachine = 2000;
	
	
	public ATMMachine() {
		hasCard = new HasCardState(this);
		noCard = new NoCardState(this);
		hasCorrectPin = new HasCorrectPinState(this);
		outOfMoney = new OutOfMoneyState(this);
		
		
		/*
		 * Initial State of the machine
		 */
		atmState = noCard;
		
		if(availableCashInMachine <= 0) {
			atmState = outOfMoney;
		}
	}
	
	public void setCashInMachine(int newAvailabeCashInMachine) {
		this.availableCashInMachine = newAvailabeCashInMachine;
	}

	public ATMState getAtmState() {
		return atmState;
	}

	public void setAtmState(ATMState atmState) {
		this.atmState = atmState;
	}
	
	public void insertCard() {
		atmState.insertCard();
	}
	public void ejectCard() {
		atmState.ejectCard();
	}
	public void insertATMPin(int pinCode) {
		atmState.insertPin(pinCode);
	}
	public void requestForCash(int withdrawCash) {
		atmState.requestCash(withdrawCash);
	}
	
	public ATMState hasCardState() {
		return hasCard;
	}
	public ATMState hasCorrectPinState() {
		return noCard;
	}
	public ATMState hasNoCardState() {
		return hasCorrectPin;
	}
	public ATMState outOfMoneyState() {
		return outOfMoney;
	}
}

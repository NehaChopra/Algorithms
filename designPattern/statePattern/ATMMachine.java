package designPattern.statePattern;

public class ATMMachine {
	ATMState atmState;
	
	ATMState hasCard;
	ATMState noCard;
	ATMState hasCorrectPin;
	ATMState outOfMoney;
	
	int availableCashInMachine = 2000;
	
	
	public ATMMachine() {
		hasCard = new HasCardState();
		noCard = new NoCardState();
		hasCorrectPin = new HasCorrectPinState();
		outOfMoney = new OutOfMoneyState();
		
		
		/*
		 * Initial State of the machine
		 */
		atmState = noCard;
		
		if(availableCashInMachine < 0) {
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
	public void insertATMPin() {
		atmState.insertPin();
	}
	public void requestForCash() {
		atmState.requestCash();
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

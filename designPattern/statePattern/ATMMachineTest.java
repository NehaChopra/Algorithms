package designPattern.statePattern;

public class ATMMachineTest {
	public static void main(String []args) {
		ATMMachine atmMachine = new ATMMachine();
		atmMachine.insertCard();
		atmMachine.ejectCard();
		atmMachine.insertCard();
		atmMachine.insertATMPin(1234);
		atmMachine.requestForCash(2000);
		atmMachine.insertCard();
		atmMachine.insertATMPin(1234);
	}
}

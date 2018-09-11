package designPattern.statePattern;

/*
 * Real world examples:
 * 1. FacesServlet is a servlet that manages the request processing lifecycle for web applications that are utilizing JavaServer Faces to construct the user interface.
 * 
 * JSF pages for user interface
 * 
 * Restore view -> apply request values -> process validation -> update model values -> invoke application serve -> render response
 * 
 * 2. Threads in java
 * 
 * 
 */
public interface ATMState {
	public void insertCard();
	public void ejectCard();
	public void insertPin(int pin);
	public void requestCash(int withdrawCash);
}

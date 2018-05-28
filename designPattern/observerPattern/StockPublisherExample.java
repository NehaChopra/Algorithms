package designPattern.observerPattern;

/*
 * Basically any state change notification of a Subject to all observable (registered) participants for the Subject 
 * 
 * Use Case:
 * Splitwise group : Anyone adds or updates any entry in the group - all members of group get a notification .
 * 
 * Facebook : If one follows a post , he gets added to the observers & any further comments on the same post , 
 * send a notification to all the other observers ; same as twitter or any other social media follow use case .
 * 
 * 
 */
public class StockPublisherExample {
	public static void main(String []args) {
		SubjectGrabber stockGrabber = new SubjectGrabber();
		StockObserver observer1 = new StockObserver(stockGrabber);
		
		stockGrabber.setIbmPrice(197.00);
		stockGrabber.setAaplPrice(677.60);
		stockGrabber.setGoogPrice(676.40); 
	}
}

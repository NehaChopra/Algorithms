package designPattern.observerPattern;

public class StockObserver implements Observer{

	private double ibmPrice;
	private double aaplPrice;
	private double googPrice;

	private Subject stockGrabber;
	private int observerID;
	
	private static int observerIdTracker = 0;

	public StockObserver(SubjectGrabber subjectGrabber) {
		this.stockGrabber = subjectGrabber;
		this.observerID = ++observerIdTracker;
		
		System.out.println("New Observer " + this.observerID);

		stockGrabber.register(this);
	}
	@Override
	public void update(double ibmPrice, double aaplPrice, double googPrice) {
		this.ibmPrice = ibmPrice;
		this.aaplPrice = aaplPrice;
		this.googPrice = googPrice;
		
		printPrices();
	}

	public void printPrices() {
		System.out.println(observerID + "\nIBM: " + ibmPrice + "\nAAPL: " +
				aaplPrice + "\nGOOG: " + googPrice + "\n"
				);
	}
}

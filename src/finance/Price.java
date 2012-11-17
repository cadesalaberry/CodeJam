package finance;

public class Price {
	
	
	private double initialPrice = 0.0;
	private double paidPrice = 0.0;
	private int timeFlagged;
	private int timePaid;
	
	/**
	 * Records the price and the time at which it has been noticed.
	 * 
	 * @param price
	 * @param time
	 */
	public Price(double price, int time) {
		this.initialPrice = price;
		this.timeFlagged = time;
	}
	
	/**
	 * Gets the value of the price.
	 * @return
	 */
	public double getPrice() {
		return (paidPrice == 0.0) ? initialPrice : paidPrice;
	}

	/**
	 * Records the price which we ended up paying.
	 * (Not the same as initial price due to latency)
	 * @param price
	 */
	public void paid(double price, int time) {
		this.paidPrice = price;
		this.timePaid = time;
		
	}
	
	/**
	 * Returns a String representation of the price.
	 */
	@Override
	public String toString() {
		return "" + this.getPrice();
	}
}

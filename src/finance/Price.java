package finance;

public class Price {
	private double currentPrice;
	
	public Price(double price){
		this.currentPrice = price;
	}
	
	public double getPrice() {
		return currentPrice;
	}
	public void updatePrice(double price) {
		currentPrice = price;
	}
}

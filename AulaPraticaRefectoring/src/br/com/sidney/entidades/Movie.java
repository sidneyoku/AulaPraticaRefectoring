package br.com.sidney.entidades;

public class Movie {

	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;

	private String title;
	private Price price;

	public Movie(String title, int price) {
		this.title = title;
		this.setPrice(price);
	}

	public int getPrice() {
		return price.getPriceCode();
	}

	public void setPrice(int arg) {
		switch (arg) {
		case REGULAR:
			price = new RegularPrice();
			break;
		case CHILDRENS:
			price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle() {
		return title;
	};

	int getFrequentRenterPoints(int daysRented) {
		if ((getPrice() == Movie.NEW_RELEASE) && daysRented > 1)
			return 2;
		else
			return 1;
	}

	double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

}
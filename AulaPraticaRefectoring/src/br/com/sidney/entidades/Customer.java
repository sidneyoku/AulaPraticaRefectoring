package br.com.sidney.entidades;

import java.util.Enumeration;
import java.util.Vector;

// git config --global user.email "email"
// git config --global user.name "name"
public class Customer {
	private String _name;
	private Vector rentalVector = new Vector();

	public Customer(String name) {
		_name = name;
	};

	public void addRental(Rental arg) {
		rentalVector.addElement(arg);
	}

	public String getName() {
		return _name;
	};

	public String statement() {
		Enumeration rentals = rentalVector.elements();
		String result = "Rental Record for " + getName() + "\n";

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}

		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		
		return result;
	}
	
	public String htmlStatement() {
		Enumeration rentals = rentalVector.elements();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();

			// show figures for this rental
			result += each.getMovie().getTitle()+ ": " +
	                String.valueOf(each.getCharge()) + "<BR>\n";
		}

		// add footer lines
		result +=  "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "On this rental you earned " 
					+ "<EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM>"
					+ " frequent renter points<P>";
		
		return result;
	}

	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = rentalVector.elements();
		
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		
		return result;
	}

	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals = rentalVector.elements();
		
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		
		return result;
	}

}

package com.labz.cabinvoiceGenerator;

public class CabInvoiceSummary {
	public double totalFare;
	 public int noOFRides;
	 public double averageFarePerRide;

	 public CabInvoiceSummary(double totalFare, int noOFRides, double averageFarePerRide) {
	 this.totalFare=totalFare;
	 this.noOFRides=noOFRides;
	 this.averageFarePerRide=averageFarePerRide;
	    }
}



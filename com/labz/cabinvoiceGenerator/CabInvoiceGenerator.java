package com.labz.cabinvoiceGenerator;

public class CabInvoiceGenerator {
	 private static final double costPerKm = 10.0;
	 private static final double costPerMinute = 1;
	 private static final double minFare = 5;

	 public double calculateFare(double distance, int time) {
		 double totalFare= ((distance *costPerKm) + (time * costPerMinute));
	     if (totalFare<minFare){
	    	 return  minFare;
	     }
	        return totalFare;
	}
}
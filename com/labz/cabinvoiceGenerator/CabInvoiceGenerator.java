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
	 public double calculateFare1(Ride[] rides) {
	        double totalFare=0;
	        for (Ride ride:rides){
	           totalFare += calculateFare(ride.distance,ride.time);
	        }
	        return totalFare;
	    }
	 public CabInvoiceSummary generateInvoiceForMultipleRides(Ride[] rides, double totalFare) {
	        for (Ride ride : rides) {
	            totalFare += calculateFare(ride.distance, ride.time);
	        }
	        CabInvoiceSummary summary = new CabInvoiceSummary(totalFare, rides.length, (totalFare / rides.length));

	        return summary;
	    }
	    public static double calculateFare(double distance, int time, String string) {
	        if (string == "normal") {
	            double fare = 10 * distance + 1 * time;
	            if (fare < 5) {
	                return 5;
	            } else {
	                return fare;
	            }
	        } else {
	            double fare = 15 * distance + 2 * time;
	            if (fare < 20) {
	                return 20;
	            } else {
	                return fare;
	            }

	        }

	    }
}

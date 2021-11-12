package com.labz.cabinvoice;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.labz.cabinvoiceGenerator.CabInvoiceGenerator;
import com.labz.cabinvoiceGenerator.CabInvoiceSummary;
import com.labz.cabinvoiceGenerator.Ride;

public class CabInvoiceGeneratorTest {
	CabInvoiceGenerator generator = new CabInvoiceGenerator();

	@Test
	public void givenDistanceTime_ShouldReturnTotalFare(){
        double distance=2.0;
        int time=5;
        double fare= generator.calculateFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }


	@Test
    public void totalFareForMultipleRides() {
        Ride[] rides = { new Ride(1.0, 20), new Ride(50, 52), new Ride(85, 100) };

        double totalFare = generator.calculateFare1(rides);
        Assert.assertEquals(1532, totalFare,0.0);
    }
	
	@Test
    public void EnhancedInvoice() {
        Ride[] rides = { new Ride(1.0, 20), new Ride(50, 52), new Ride(85, 100) };

        CabInvoiceSummary invoiceSummery = generator.generateInvoiceForMultipleRides(rides, 0);
        assertEquals(1532, invoiceSummery.totalFare,0.0);
        assertEquals(3, invoiceSummery.noOFRides);
        assertEquals(510, (int) invoiceSummery.averageFarePerRide);
    }
	
	 @Test
	   public void InvoiceService() {
	        Map<Integer,CabInvoiceSummary> map= new HashMap<Integer, CabInvoiceSummary>();

	        Ride[] rides = { new Ride(1.0, 20), new Ride(50, 52), new Ride(85, 100) };
	        CabInvoiceSummary invoiceSummery = generator.generateInvoiceForMultipleRides(rides, 0);
	        map.put(1, invoiceSummery);

	        CabInvoiceSummary invoiceSummery1 = generator.generateInvoiceForMultipleRides(rides, 0);
	        map.put(1, invoiceSummery1);

	        CabInvoiceSummary invoiceSummery2 = generator.generateInvoiceForMultipleRides(rides, 0);
	        map.put(1, invoiceSummery2);
	        CabInvoiceSummary invoiceSummery3=map.get(1);
	        assertEquals(4596, invoiceSummery3.totalFare,0.0);
	        assertEquals(3, invoiceSummery3.noOFRides);
	        assertEquals(1532, (int)invoiceSummery3.averageFarePerRide);
	    }
	 @Test
	    void calculateFareForRides() {
	        double distance = 10;
	        int time = 60;
	        double getFareForNormalRide = generator.calculateFare(distance, time, "normal");
	        assertEquals(160, getFareForNormalRide,0.0);
	        double getFareForPremiumRide= generator.calculateFare(distance, time, "premium");
	        assertEquals(270, getFareForPremiumRide,0.0);
	    }

}



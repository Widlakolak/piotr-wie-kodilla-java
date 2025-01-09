package com.kodilla;

import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.FlightFinder;
import com.kodilla.exception.test.RouteNotFoundException;

public class Main {
    public static void main(String[] args) {

        FlightFinder flightFinder = new FlightFinder();
        flightFinder.addFlight("Lodz", "Warszawa");
        flightFinder.addFlight("Lodz", "Alicante");
        flightFinder.addFlight("Lodz", "Mediolan");
        flightFinder.addFlight("Lodz", "Bruksela");

        try {
            flightFinder.findFlight(new Flight("Wrocław", "Warszawa"));
            System.out.println("Flight route found.");
        } catch (RouteNotFoundException e) {
            System.out.println("Exception= " + e + "\nRoute not found.");
        }   finally {
            System.out.println("Flight Finder wish you have a nice day.");
        }
    }
}
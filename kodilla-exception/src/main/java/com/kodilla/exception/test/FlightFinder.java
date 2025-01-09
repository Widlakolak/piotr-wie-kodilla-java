package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    private Map<String, Boolean> flights = new HashMap<>();

    public void addFlight(String departureAirport, String arrivalAirport) {
        flights.put(departureAirport, true);
        flights.put(arrivalAirport, true);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        String departureAirport = flight.getDepartureAirport();
        String arrivalAirport = flight.getArrivalAirport();

        if (flights.containsKey(departureAirport) && flights.containsKey(arrivalAirport)) {
            return true;
        } else {
            throw new RouteNotFoundException();
        }
    }

}

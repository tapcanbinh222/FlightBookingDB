/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author trums
 */
public class Flights {

    private AircraftTypes aircraftTypes;
    private Airlines airlines;
    private Airports airports;
    private AllFlight allFlight;
    private Seats seats;
    private FlightPrices flightPrices;

    public Flights(AircraftTypes aircraftTypes, Airlines airlines, Airports airports, FlightPrices flightPrices) {
        this.aircraftTypes = aircraftTypes;
        this.airlines = airlines;
        this.flightPrices = flightPrices;
        this.aircraftTypes = new AircraftTypes();
        this.allFlight = new AllFlight();
        this.airports = new Airports();
        this.flightPrices = new FlightPrices();

    }

    public Flights() {
        this.aircraftTypes = new AircraftTypes();
        this.airlines = new Airlines();
        this.airports = new Airports();
        this.allFlight = new AllFlight();
        this.flightPrices = new FlightPrices();
        this.seats = new Seats();
    }

    
    public int getFlightId() {
        return allFlight.getFlightId();
    }

    public void setFlightId(int flightId) {
        allFlight.setFlightId(flightId);
    }
    
    public String getAirlineCode() {
        return airlines.getAirlineCode();
    }

    public void setAirlineCode(String airlineCode) {
        airlines.setAirlineCode(airlineCode);
    }

    public int getAirlineId() {
        return airlines.getAirlineId();
    }

    public void setAirlineId(int airlineId) {
        airlines.setAirlineId(airlineId);
    }

    public String getAirlineName() {
        return airlines.getAirlineName();
    }

    public void setAirlineName(String airlineName) {
        airlines.setAirlineName(airlineName);
    }

    public int getAircraftTypeId() {
        return aircraftTypes.getAircraftTypeId();
    }

    public void setAircraftTypeId(int aircraftTypesId) {
        aircraftTypes.setAircraftTypeId(aircraftTypesId);
    }

    public String getFlightNumber() {
        return allFlight.getFlightNumber();
    }

    public void setFlightNumber(String flightNumber) {
        allFlight.setFlightNumber(flightNumber);
    }

    public String getOriginAirportCode() {
        return allFlight.getOriginAirportCode();
    }

    public void setOriginAirportCode(String originAirportCode) {
        allFlight.setOriginAirportCode(originAirportCode);
    }

    public String getDestinationAirportCode() {
        return allFlight.getDestinationAirportCode();
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        allFlight.setDestinationAirportCode(destinationAirportCode);
    }

    public String getFlightStatus() {
        return allFlight.getFlightStatus();
    }

    public void setFlightStatus(String flightStatus) {
        allFlight.setFlightStatus(flightStatus);
    }

    public LocalTime getDepartureTime() {
        return allFlight.getDepartureTime();
    }

    public void setDepartureTime(LocalTime departureTime) {
        allFlight.setDepartureTime(departureTime);
    }

    public LocalTime getArrivalTime() {
        return allFlight.getArrivalTime();
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        allFlight.setArrivalTime(arrivalTime);
    }

    public LocalDate getFlightDate() {
        return allFlight.getFlightDate();
    }

    public void setFlightDate(LocalDate flightDate) {
        allFlight.setFlightDate(flightDate);
    }

    public LocalDate getArrivalDate() {
        return allFlight.getArrivalDate();
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        allFlight.setArrivalDate(arrivalDate);
    }

    public String getGateNumber() {
        return allFlight.getGateNumber();
    }

    public void setGateNumber(String gateNumber) {
        allFlight.setGateNumber(gateNumber);
    }

    public String getAircraftTypeName() {
        return aircraftTypes.getAircraftTypeName();
    }

    public void setAircraftTypeName(String aircraftTypeName) {
        aircraftTypes.setAircraftTypeName(aircraftTypeName);
    }
    

    public double getEconomyPrice() {
        return flightPrices.getEconomyPrice();
    }

    public void setEconomyPrice(double economyPrice) {
        flightPrices.setEconomyPrice(economyPrice);
    }

    public double getBusinessPrice() {
        return flightPrices.getBusinessPrice();
    }

    public void setBusinessPrice(double businessPrice) {
        flightPrices.setBusinessPrice(businessPrice);
    }

    public double getFirstClassPrice() {
        return flightPrices.getFirstClassPrice();
    }

    public void setFirstClassPrice(double firstClassPrice) {
        flightPrices.setFirstClassPrice(firstClassPrice);
    }

    public String getFormattedDepartureTime() {
        return allFlight.getFormattedDepartureTime();
    }

    public String getFormattedArrivalTime() {
        return allFlight.getFormattedArrivalTime();
    }

    public String getFormattedFlightDate() {
        return allFlight.getFormattedFlightDate();
    }

    public String getFormattedArrivalDate() {
        return allFlight.getFormattedArrivalDate();
    }

    @Override
    public String toString() {
        return "AddFlight{" + "aircraftTypes=" + aircraftTypes + ", airlines=" + airlines + ", airports=" + airports + ", allFlight=" + allFlight + ", seats=" + seats + ", flightPrices=" + flightPrices + '}';
    }

}

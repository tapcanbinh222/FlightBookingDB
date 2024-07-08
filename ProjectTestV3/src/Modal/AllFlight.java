package Modal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AllFlight {

    private int flightId;
    private int airlineId;
    private int aircraftTypeId;
    private String flightNumber;
    private String originAirportCode;
    private String destinationAirportCode;
    private String flightStatus;
    private LocalTime departureTime; // Thời gian khởi hành (dạng chuỗi HH:mm)
    private LocalTime arrivalTime;   // Thời gian đến (dạng chuỗi HH:mm)
    private LocalDate flightDate;    // Ngày bay
    private LocalDate arrivalDate;   // Ngày đến
    private String gateNumber;       // Số cổng ra máy bay
    public AllFlight() {
        // Constructor mặc định, thường dùng khi lấy dữ liệu từ cơ sở dữ liệu
    }

    public AllFlight(int flightId, int airlineId, int aircraftTypeId, String flightNumber, String originAirportCode, String destinationAirportCode, String flightStatus, LocalTime departureTime, LocalTime arrivalTime, LocalDate flightDate, LocalDate arrivalDate, String gateNumber, double price) {
        this.flightId = flightId;
        this.airlineId = airlineId;
        this.aircraftTypeId = aircraftTypeId;
        this.flightNumber = flightNumber;
        this.originAirportCode = originAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.flightStatus = flightStatus;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightDate = flightDate;
        this.arrivalDate = arrivalDate;
        this.gateNumber = gateNumber;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public int getAircraftTypeId() {
        return aircraftTypeId;
    }

    public void setAircraftTypeId(int aircraftTypeId) {
        this.aircraftTypeId = aircraftTypeId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOriginAirportCode() {
        return originAirportCode;
    }

    public void setOriginAirportCode(String originAirportCode) {
        this.originAirportCode = originAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

 
 // Format methods
    public String getFormattedDepartureTime() {
        return departureTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getFormattedArrivalTime() {
        return arrivalTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getFormattedFlightDate() {
        return flightDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    public String getFormattedArrivalDate() {
        return arrivalDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    
}

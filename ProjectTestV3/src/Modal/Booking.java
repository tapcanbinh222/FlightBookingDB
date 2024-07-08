package Modal;

import java.time.LocalDate;

public class Booking {

    private int bookingID;           // Thay đổi tên biến để phù hợp với Java naming conventions
    private String passengerID;
    private int flightID;
    private int seatId;
    private String email;
    private String phone;
    private LocalDate bookingDate;
    private int seatNumber;
    private String paymentStatus;
    private double totalPrice;
    private String bookingStatus;
    private String paymentMethod;
    private Seats seat;
    private Passenger pass;

    // Constructor đầy đủ tham số

    public Booking(int bookingID, String passengerID, int flightID, int seatId, String email, String phone, LocalDate bookingDate, int seatNumber, String paymentStatus, double totalPrice, String bookingStatus, String paymentMethod) {
        this.bookingID = bookingID;
        this.passengerID = passengerID;
        this.flightID = flightID;
        this.seatId = seatId;
        this.email = email;
        this.phone = phone;
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
        this.paymentStatus = paymentStatus;
        this.totalPrice = totalPrice;
        this.bookingStatus = bookingStatus;
        this.paymentMethod = paymentMethod;
    }
    

    // Constructor mặc định (default), thường dùng khi lấy dữ liệu từ database
    public Booking() {
    }

    // Getter và setter cho các trường dữ liệu
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID + ", passengerID=" + passengerID + ", flightID=" + flightID + ", seatId=" + seatId + ", email=" + email + ", phone=" + phone + ", bookingDate=" + bookingDate + ", seatNumber=" + seatNumber + ", paymentStatus=" + paymentStatus + ", totalPrice=" + totalPrice + ", bookingStatus=" + bookingStatus + ", paymentMethod=" + paymentMethod + '}';
    }

}

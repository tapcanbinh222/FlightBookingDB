package Modal;

public class Seats {

    private int seatId;
    private int aicraftTypeID;
    private String seatNumber;
    private String seatClass;
    private String aicraftTypeName;
    private int flightId;
    private boolean isAvailable;

    public Seats() {}

    public Seats(int seatId, int aicraftTypeID, String seatNumber, String seatClass, String aicraftTypeName, boolean isAvailable, int flightId) {
        this.seatId = seatId;
        this.aicraftTypeID = aicraftTypeID;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.aicraftTypeName = aicraftTypeName;
        this.isAvailable = isAvailable;
        this.flightId = flightId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    
    public String getAicraftTypeName() {
        return aicraftTypeName;
    }

    public void setAicraftTypeName(String aicraftTypeName) {
        this.aicraftTypeName = aicraftTypeName;
    }

 public boolean getIsAvailable() { // Phương thức getter cho isAvailable
        return isAvailable;
    }

    public void setIsAvailable(boolean available) { // Phương thức setter cho isAvailable
        isAvailable = available;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getAicraftTypeID() {
        return aicraftTypeID;
    }

    public void setAicraftTypeID(int aicraftTypeID) {
        this.aicraftTypeID = aicraftTypeID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

   

    
}

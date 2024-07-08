package Modal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Passenger {

    private int passengerID;         // Thay đổi tên biến để phù hợp với Java naming conventions
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String passportID;
    private String nationality;

    // Constructors
    public Passenger() {
    }

    public Passenger(int passengerID, String firstName, String lastName, LocalDate dateOfBirth, String gender, String passportID, String nationality) {
        this.passengerID = passengerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.passportID = passportID;
        this.nationality = nationality;
    }

    // Getter và setter cho các trường dữ liệu
    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFormattedFlightDate() {
        return dateOfBirth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    @Override
    public String toString() {
        return "Passenger{"
                + "passengerID=" + passengerID
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", dateOfBirth=" + dateOfBirth
                + ", gender='" + gender + '\''
                + ", passportNumber='" + passportID + '\''
                + ", nationality='" + nationality + '\''
                + '}';
    }
}

/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package project;

import Database.AirportsDAO;
import Database.AllFlightDAO;
import Modal.Airports;
import Modal.AllFlight;
import Modal.Flights;
import Modal.Passenger;
import Modal.Seats;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ProjectController implements Initializable {

    @FXML
    private TableColumn<Flights, String> tcFlightNumber;
    @FXML
    private TableColumn<Flights, String> tcOrigin;
    @FXML
    private TableColumn<Flights, String> tcDestination;
    @FXML
    private TableColumn<Flights, String> tcFlightStatus;
    @FXML
    private TableColumn<Flights, LocalTime> tcDepartureTime;
    @FXML
    private TableColumn<Flights, LocalTime> tcArrivalTime;
    @FXML
    private TableColumn<Flights, LocalDate> tcFlightDate;
    @FXML
    private TableColumn<Flights, LocalDate> tcArrivalDate;
    @FXML
    private TableColumn<Flights, String> tcAirlineName;
    @FXML
    private TableColumn<Flights, String> tcAircraftType;
    @FXML
    private TableColumn<Flights, String> tcGateNumber;
    @FXML
    private TableView<Flights> tvFlight;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnBack;
    @FXML
    private TableColumn<Flights, Double> tcEconomyPrice;
    @FXML
    private TableColumn<Flights, Double> tcBusinessPrice;
    @FXML
    private TableColumn<Flights, Double> tcFirstClassPrice;
    @FXML
    ComboBox<String> comboBoxAircraftName;
    @FXML
    private TextField txtFlightNumber;
    @FXML
    private TextField txtDepartureTime;
    @FXML
    private TextField txtArrivalTime;
    @FXML
    private TextField txtFlightStatus;
    @FXML
    private TextField txtGateNumber;
    @FXML
    private TextField txtEconomyPrice;
    @FXML
    private TextField txtFirtsClassPice;
    @FXML
    private DatePicker dpArrivalDate;
    @FXML
    private DatePicker dpDepartureDate;
    @FXML
    private TextField txtBusinessPrice;
    @FXML
    private AnchorPane apAdd;
    @FXML
    private ComboBox<String> comboBoxAirlineName;
    @FXML
    private ComboBox<String> comboBoxDestination;
    @FXML
    private ComboBox<String> comboBoxOrigin;
    @FXML
    private Button btnchangeUpdate;
    @FXML
    private Button btnChangeAdd;
    @FXML
    private AnchorPane apButonCRUD;
    @FXML
    private AnchorPane apBooking;
    @FXML
    private Label lbBusinessPrice;
    @FXML
    private Label lbEconomyPrice;
    @FXML
    private Label lbFirtsClassPrice;
    @FXML
    private TextField txtGetFlightNumber;
    @FXML
    private TextField txtGetDepartureTime;
    @FXML
    private TextField txtGetArrivalTime;
    @FXML
    private TextField txtGetFlightStatus;
    @FXML
    private DatePicker dpGetDepartureDate;
    @FXML
    private TextField txtGetBusinessPrice;
    @FXML
    private Button btnBack1;
    @FXML
    private Button btnBooking;
    @FXML
    private DatePicker dpDOB;
    @FXML
    private ComboBox<String> comboBoxGender;
    @FXML
    private ComboBox<String> comboBoxNational;
    @FXML
    private ComboBox<String> comboBoxSeatType;
    @FXML
    private ComboBox<String> comboBoxSeat;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private Button btnChangeBooking;
    @FXML
    private Button btnchangeAllBooking;
    @FXML
    private TextField txtGetFirtsClassPrice;
    @FXML
    private TextField txtGetEconomyPrice;
    @FXML
    private TableColumn<?, ?> tcFirstName;
    @FXML
    private TableColumn<?, ?> tcLastName;
    @FXML
    private TableColumn<?, ?> tcDOB;
    @FXML
    private TableColumn<?, ?> tcGender;
    @FXML
    private TableColumn<?, ?> tcPassportID;
    @FXML
    private TableColumn<?, ?> tcNationality;
    @FXML
    private TableColumn<?, ?> tcSeatNumber;
    @FXML
    private TableColumn<?, ?> tcSeatClass;
    @FXML
    private TableColumn<?, ?> tcEmail;
    @FXML
    private TableColumn<?, ?> tcPhone;
    @FXML
    private TableColumn<?, ?> tcBookingDate;
    @FXML
    private TextField txtGetAirlineName;
    @FXML
    private TextField txtGetGateNumber;
    @FXML
    private TableColumn<?, ?> tcGateNumber_Booking;
    @FXML
    private TableColumn<?, ?> tcFlightStatus_Passenger;
    ObservableList<String> options = FXCollections.observableArrayList(
            "Boeing 787 Dreamliner",
            "Airbus A321neo"
    );
    ObservableList<String> optionsAirlineName = FXCollections.observableArrayList(
            "Vietnam Airlines",
            "VietJet Air",
            "Bamboo Airways"
    );
    ObservableList<String> optionsOrigin = FXCollections.observableArrayList(
            "SGN",
            "DAD",
            "HAN"
    );
    ObservableList<String> optionsDestination = FXCollections.observableArrayList(
            "SGN",
            "DAD",
            "HAN"
    );
    ObservableList<String> optionsGender = FXCollections.observableArrayList(
            "Male",
            "Female"
    );
    ObservableList<String> optionsSeatType = FXCollections.observableArrayList(
            "Economy",
            "Business",
            "First Class"
    );

    ObservableList<String> optionsNational = FXCollections.observableArrayList(
            "VietNam",
            "Canada",
            "China"
    );
    AllFlightDAO allFlightDAO = new AllFlightDAO();
    ObservableList<Flights> allFlightList = FXCollections.observableArrayList(allFlightDAO.listAllFlight());
    @FXML
    private TextField txtGetOrigin;
    @FXML
    private TextField txtGetDestination;
    @FXML
    private TextField txtPassportID;
    @FXML
    private TableView<?> tvPassengerFlight;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Flights();
        loadFlightData();
        comboBoxAircraftName.setValue("Choose Aircraft");
        comboBoxAircraftName.setItems(options);
        comboBoxAirlineName.setValue("Choose Airline");
        comboBoxAirlineName.setItems(optionsAirlineName);
        comboBoxOrigin.setValue("Origin");
        comboBoxOrigin.setItems(optionsOrigin);
        comboBoxDestination.setValue("Destination");
        comboBoxDestination.setItems(optionsDestination);
        comboBoxGender.setItems(optionsGender);
        comboBoxNational.setItems(optionsNational);
        comboBoxSeatType.setItems(optionsSeatType);

    }

    private void loadFlightData() {
        ObservableList<Flights> allFlightList = FXCollections.observableArrayList(allFlightDAO.listAllFlight());
        System.out.println("Data Loaded: " + allFlightList.size());

    }

    public void Flights() {
        try {
            tcFlightNumber.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
            tcOrigin.setCellValueFactory(new PropertyValueFactory<>("originAirportCode"));
            tcDestination.setCellValueFactory(new PropertyValueFactory<>("destinationAirportCode"));
            tcFlightStatus.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));
            tcDepartureTime.setCellValueFactory(new PropertyValueFactory<>("formattedDepartureTime"));
            tcArrivalTime.setCellValueFactory(new PropertyValueFactory<>("formattedArrivalTime"));
            tcFlightDate.setCellValueFactory(new PropertyValueFactory<>("formattedFlightDate"));
            tcArrivalDate.setCellValueFactory(new PropertyValueFactory<>("formattedArrivalDate"));
            tcAirlineName.setCellValueFactory(new PropertyValueFactory<>("airlineName"));
            tcAircraftType.setCellValueFactory(new PropertyValueFactory<>("aircraftTypeName"));
            tcGateNumber.setCellValueFactory(new PropertyValueFactory<>("gateNumber"));
            tcEconomyPrice.setCellValueFactory(new PropertyValueFactory<>("economyPrice"));
            tcBusinessPrice.setCellValueFactory(new PropertyValueFactory<>("businessPrice"));
            tcFirstClassPrice.setCellValueFactory(new PropertyValueFactory<>("firstClassPrice"));
            tvFlight.setItems(allFlightList);
        } catch (Exception e) {
        }

    }

    @FXML
    private void btnHandleAdd(ActionEvent event) {
        AllFlightDAO dao = new AllFlightDAO();
        Flights flights = new Flights();
        StringBuilder errorMessage = new StringBuilder();
        if (txtFlightNumber.getText() == null || txtFlightNumber.getText().isEmpty()
                || comboBoxOrigin.getValue() == null || comboBoxOrigin.getValue().isEmpty()
                || comboBoxDestination.getValue() == null || comboBoxDestination.getValue().isEmpty()
                || txtDepartureTime.getText() == null || txtDepartureTime.getText().isEmpty()
                || txtArrivalTime.getText() == null || txtArrivalTime.getText().isEmpty()
                || comboBoxAirlineName.getValue() == null || comboBoxAirlineName.getValue().isEmpty()
                || txtFlightStatus.getText() == null || txtFlightStatus.getText().isEmpty()
                || txtGateNumber.getText() == null || txtGateNumber.getText().isEmpty()
                || txtEconomyPrice.getText() == null || txtEconomyPrice.getText().isEmpty()
                || txtBusinessPrice.getText() == null || txtBusinessPrice.getText().isEmpty()
                || txtFirtsClassPice.getText() == null || txtFirtsClassPice.getText().isEmpty()
                || dpArrivalDate.getValue() == null
                || dpDepartureDate.getValue() == null
                || comboBoxAircraftName.getValue() == null || comboBoxAircraftName.getValue().isEmpty()) {

            showAlert("Invalid Fields", "Please fill in all required fields.");
            return;
        } else {

            try {
                flights.setFlightNumber(txtFlightNumber.getText());
                flights.setDestinationAirportCode(comboBoxDestination.getValue());
                flights.setOriginAirportCode(comboBoxOrigin.getValue());
                flights.setDepartureTime(LocalTime.parse(txtDepartureTime.getText()));
                flights.setArrivalTime(LocalTime.parse(txtArrivalTime.getText()));
                String selectedAirlineNames = comboBoxAirlineName.getValue();
                int airlineId;
                switch (selectedAirlineNames) {
                    case "Vietnam Airlines":
                        airlineId = 1;
                        break;
                    case "VietJet Air":
                        airlineId = 2;
                        break;
                    case "Bamboo Airways":
                        airlineId = 3;
                        break;
                    default:
                        airlineId = 0;
                        break;
                }
                flights.setAirlineId(airlineId);
                flights.setFlightStatus(txtFlightStatus.getText());
                flights.setGateNumber(txtGateNumber.getText());
                String selectedAircraft = comboBoxAircraftName.getValue();
                int aircraftTypeId;
                switch (selectedAircraft) {
                    case "Boeing 787 Dreamliner":
                        aircraftTypeId = 1;
                        break;
                    case "Airbus A321neo":
                        // Hoặc các loại máy bay khác
                        aircraftTypeId = 2; // Giá trị tương ứng với Airbus A321neo
                        break;
                    default:
                        // Xử lý trường hợp không có lựa chọn hoặc lựa chọn không hợp lệ
                        aircraftTypeId = 0; // Hoặc giá trị mặc định khác
                        break;
                }
                flights.setAircraftTypeId(aircraftTypeId);
                flights.setFlightDate(dpDepartureDate.getValue());
                flights.setArrivalDate(dpArrivalDate.getValue());
                flights.setEconomyPrice(Double.parseDouble(txtEconomyPrice.getText()));
                flights.setBusinessPrice(Double.parseDouble(txtBusinessPrice.getText()));
                flights.setFirstClassPrice(Double.parseDouble(txtFirtsClassPice.getText()));

                dao.AddDB(flights);
                allFlightList.add(flights);
                clearInputFields();
                tvFlight.refresh();
                System.out.println("Add Success");
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Please enter a valid number for price.");
                alert.showAndWait();
            } catch (DateTimeParseException e) {
                showAlert("Error", "Invalid time or date format.");
            } catch (Exception e) {
                showAlert("Error", "Unknow error: " + e.getMessage());
            }
        }
        clearInputFields();
    }

    private void showAlert(String message, String toString) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Category Selected");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void btnHandleUpdate(ActionEvent event) {
        Flights flightsSelected = tvFlight.getSelectionModel().getSelectedItem();

        // Kiểm tra các trường nhập liệu
        StringBuilder errorMessage = new StringBuilder("Missing Fields:\n");

        if (isEmpty(txtFlightNumber) || isEmpty(comboBoxOrigin) || isEmpty(comboBoxDestination)
                || isEmpty(txtDepartureTime) || isEmpty(txtArrivalTime) || isEmpty(comboBoxAirlineName)
                || isEmpty(txtFlightStatus) || isEmpty(txtGateNumber) || isEmpty(txtEconomyPrice)
                || isEmpty(txtBusinessPrice) || isEmpty(txtFirtsClassPice) || dpArrivalDate.getValue() == null
                || dpDepartureDate.getValue() == null || isEmpty(comboBoxAircraftName)) {

            if (isEmpty(txtFlightNumber)) {
                errorMessage.append("Flight Number\n");
            }
            if (isEmpty(comboBoxOrigin)) {
                errorMessage.append("Origin\n");
            }
            if (isEmpty(comboBoxDestination)) {
                errorMessage.append("Destination\n");
            }
            if (isEmpty(txtDepartureTime)) {
                errorMessage.append("Departure Time\n");
            }
            if (isEmpty(txtArrivalTime)) {
                errorMessage.append("Arrival Time\n");
            }
            if (isEmpty(comboBoxAirlineName)) {
                errorMessage.append("Airline Name\n");
            }
            if (isEmpty(txtFlightStatus)) {
                errorMessage.append("Flight Status\n");
            }
            if (isEmpty(txtGateNumber)) {
                errorMessage.append("Gate Number\n");
            }
            if (isEmpty(txtEconomyPrice)) {
                errorMessage.append("Economy Price\n");
            }
            if (isEmpty(txtBusinessPrice)) {
                errorMessage.append("Business Price\n");
            }
            if (isEmpty(txtFirtsClassPice)) {
                errorMessage.append("First Class Price\n");
            }
            if (dpArrivalDate.getValue() == null) {
                errorMessage.append("Arrival Date\n");
            }
            if (dpDepartureDate.getValue() == null) {
                errorMessage.append("Departure Date\n");
            }
            if (isEmpty(comboBoxAircraftName)) {
                errorMessage.append("Aircraft Name\n");
            }

            showAlert("Invalid Fields", errorMessage.toString());
            return;
        }

        try {
            flightsSelected.setFlightNumber(txtFlightNumber.getText());
            flightsSelected.setOriginAirportCode(comboBoxOrigin.getValue());
            flightsSelected.setDestinationAirportCode(comboBoxDestination.getValue());
            flightsSelected.setDepartureTime(LocalTime.parse(txtDepartureTime.getText()));
            flightsSelected.setArrivalTime(LocalTime.parse(txtArrivalTime.getText()));
            int airlineId = getAirlineIdByName(comboBoxAirlineName.getValue());
            flightsSelected.setAirlineId(airlineId);
            System.out.println(airlineId);
            flightsSelected.setFlightStatus(txtFlightStatus.getText());
            flightsSelected.setGateNumber(txtGateNumber.getText());
            int aircraftTypeId = getAircraftTypeIdByName(comboBoxAircraftName.getValue());
            flightsSelected.setAircraftTypeId(aircraftTypeId);
            flightsSelected.setFlightDate(dpDepartureDate.getValue());
            flightsSelected.setArrivalDate(dpArrivalDate.getValue());
            flightsSelected.setEconomyPrice(Double.parseDouble(txtEconomyPrice.getText()));
            flightsSelected.setBusinessPrice(Double.parseDouble(txtBusinessPrice.getText()));
            flightsSelected.setFirstClassPrice(Double.parseDouble(txtFirtsClassPice.getText()));
            allFlightDAO.EditFlight(flightsSelected);
            // Cập nhật chuyến bay vào cơ sở dữ liệu
            AllFlightDAO dao = new AllFlightDAO();

            int index = allFlightList.indexOf(flightsSelected);
            if (index != -1) {
                Flights updatedFlight = allFlightDAO.getFlightById(flightsSelected.getFlightId());
                allFlightList.set(index, updatedFlight); // Thay thế đối tượng cũ bằng đối tượng mới
                tvFlight.refresh();
            }
            // Cập nhật chuyến bay trong danh sách quan sát
            // Xóa dữ liệu nhập trên giao diện
            clearInputFields();
            tvFlight.setVisible(true);
            apButonCRUD.setVisible(true);
            apAdd.setVisible(false);
            tvFlight.refresh();
            showAlert("Success", "Flight added successfully.");
        } catch (NumberFormatException e) {
            showAlert("Error", "Please enter a valid number for price.");
        } catch (DateTimeParseException e) {
            showAlert("Error", "Invalid time or date format.");
        } catch (SQLException e) {
            showAlert("Error", "Unknown error: " + e.getMessage());
        }

    }

    private boolean isEmpty(TextField textField) {
        return textField.getText() == null || textField.getText().isEmpty();
    }

    private boolean isEmpty(ComboBox<String> comboBox) {
        return comboBox.getValue() == null || comboBox.getValue().isEmpty();
    }

    private int getAirlineIdByName(String airlineName) {
        switch (airlineName) {
            case "Vietnam Airlines":
                return 1;
            case "VietJet Air":
                return 2;
            case "Bamboo Airways":
                return 3;
            default:
                return 0;
        }
    }

    private String getAirlineNameById(int airlineId) {
        switch (airlineId) {
            case 1:
                return "Vietnam Airlines";
            case 2:
                return "VietJet Air";
            case 3:
                return "Bamboo Airways";
            default:
                return null;
        }
    }

    private boolean isAirlineIdValid(int airlineId) {
        // Kiểm tra tính hợp lệ của airlineId
        return airlineId != 0;
    }

    private int getAircraftTypeIdByName(String aircraftName) {
        switch (aircraftName) {
            case "Boeing 787 Dreamliner":
                return 1;
            case "Airbus A321neo":
                return 2;
            default:
                return 0;
        }
    }

    private String getAircraftNameById(int aircraftTypeId) {
        switch (aircraftTypeId) {
            case 1:
                return "Boeing 787 Dreamliner";
            case 2:
                return "Airbus A321neo";
            default:
                return null;
        }
    }

    private void clearInputFields() {
        txtFlightNumber.clear();
        txtFlightNumber.setEditable(true); // Cho phép chỉnh sửa mã chuyến bay khi thêm mới
        txtDepartureTime.clear();
        txtArrivalTime.clear();
        txtFlightStatus.clear();
        txtGateNumber.clear();
        txtEconomyPrice.clear();
        txtBusinessPrice.clear();
        txtFirtsClassPice.clear();
        dpArrivalDate.setValue(null);
        dpDepartureDate.setValue(null);
        comboBoxOrigin.setValue(null);
        comboBoxDestination.setValue(null);
        comboBoxAirlineName.setValue(null);
        comboBoxAircraftName.setValue(null);
    }

    @FXML
    private void btnHandleDelete(ActionEvent event) {
        Flights flightSelected = tvFlight.getSelectionModel().getSelectedItem();
        AllFlightDAO dao = new AllFlightDAO();
        if (flightSelected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Delete Product");
            alert.setContentText("Are you sure you want to delete the product: " + flightSelected.getFlightId() + "?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Xóa sản phẩm khỏi cơ sở dữ liệu
                dao.DeleteDB(flightSelected);

                // Xóa sản phẩm khỏi danh sách prolist
                allFlightList.remove(flightSelected);
                tvFlight.refresh();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("No Selection");
            alert.setContentText("Please select a product in the table.");
            alert.showAndWait();
        }

    }

    @FXML
    private void btnHandleBack(ActionEvent event) {
        tvFlight.setVisible(true);
        apButonCRUD.setVisible(true);
        apAdd.setVisible(false);
        apBooking.setVisible(false);
        clearInputFields();
    }

    @FXML
    private void btnChangeUpdate(ActionEvent event) {
        Flights flightsSelected = tvFlight.getSelectionModel().getSelectedItem();
        if (flightsSelected == null) {
            showAlert("Error", "No flight selected.");
            tvFlight.setVisible(true);
            apButonCRUD.setVisible(true);
            apAdd.setVisible(false);
        } else {
            tvFlight.setVisible(false);
            apButonCRUD.setVisible(false);
            apAdd.setVisible(true);
            btnAdd.setVisible(false);
            btnUpdate.setVisible(true);
            txtFlightNumber.setText(flightsSelected.getFlightNumber());
            txtFlightNumber.setEditable(false); // Không cho phép chỉnh sửa mã chuyến bay
            comboBoxOrigin.setValue(flightsSelected.getOriginAirportCode());
            comboBoxDestination.setValue(flightsSelected.getDestinationAirportCode());
            txtDepartureTime.setText(flightsSelected.getDepartureTime().toString());
            txtArrivalTime.setText(flightsSelected.getArrivalTime().toString());
            comboBoxAirlineName.setValue(flightsSelected.getAirlineName());
            txtFlightStatus.setText(flightsSelected.getFlightStatus());
            txtGateNumber.setText(flightsSelected.getGateNumber());
            txtEconomyPrice.setText(Double.toString(flightsSelected.getEconomyPrice()));
            txtBusinessPrice.setText(Double.toString(flightsSelected.getBusinessPrice()));
            txtFirtsClassPice.setText(Double.toString(flightsSelected.getFirstClassPrice()));
            dpArrivalDate.setValue(flightsSelected.getArrivalDate());
            dpDepartureDate.setValue(flightsSelected.getFlightDate());
            comboBoxAircraftName.setValue(flightsSelected.getAircraftTypeName());
        }
    }

    @FXML
    private void btnHandleChangeAdd(ActionEvent event) {
        tvFlight.setVisible(false);
        apButonCRUD.setVisible(false);
        apAdd.setVisible(true);
        btnAdd.setVisible(true);
        btnUpdate.setVisible(false);

    }

    // In ra danh sách ObservableList
    @FXML

    private void btnHandleChangeBooking(ActionEvent event) throws SQLException {
        try {
            Flights flightsSelected = tvFlight.getSelectionModel().getSelectedItem();

            if (flightsSelected == null) {
                showAlert("Error", "Selected Flight to Booking.");
                tvFlight.setVisible(true);
                apButonCRUD.setVisible(true);
                apAdd.setVisible(false);
            } else {
                AllFlightDAO dao = new AllFlightDAO();
                try {
                int flightId = flightsSelected.getFlightId();
                ArrayList<Seats> seats = dao.getSeatsByFlightId(flightId);
                ObservableList<String> seatNumbers = FXCollections.observableArrayList();

                String selectedSeatType = comboBoxSeatType.getValue();
                for (Seats seat : seats) {
                    if ("Business".equals(selectedSeatType)) {
                        if (seat.getSeatNumber().startsWith("B")) {
                            seatNumbers.add(seat.getSeatNumber());
                        }
                    } else if ("Economy".equals(selectedSeatType)) {
                        if (seat.getSeatNumber().startsWith("C")) {
                            seatNumbers.add(seat.getSeatNumber());
                        }
                    } else if ("First Class".equals(selectedSeatType)) {
                        if (seat.getSeatNumber().startsWith("A")) {
                            seatNumbers.add(seat.getSeatNumber());
                        }
                    } else {
                        seatNumbers.add(seat.getSeatNumber());
                    }
                }
                comboBoxSeat.setItems(seatNumbers);
            } catch (SQLException e) {
                e.printStackTrace();
            }
              
                tvFlight.setVisible(false);
                apButonCRUD.setVisible(false);
                apBooking.setVisible(true);

                txtGetFlightNumber.setText(flightsSelected.getFlightNumber());
                txtGetFlightNumber.setEditable(false);
                txtGetOrigin.setText(flightsSelected.getOriginAirportCode());
                txtGetOrigin.setEditable(false);
                txtGetDestination.setText(flightsSelected.getDestinationAirportCode());
                txtGetDestination.setEditable(false);
                txtGetDepartureTime.setText(flightsSelected.getDepartureTime().toString());
                txtGetDepartureTime.setEditable(false);
                txtGetArrivalTime.setText(flightsSelected.getArrivalTime().toString());
                txtGetArrivalTime.setEditable(false);
                txtGetAirlineName.setText(flightsSelected.getAirlineName());
                txtGetAirlineName.setEditable(false);
                txtGetFlightStatus.setText(flightsSelected.getFlightStatus());
                txtGetFlightStatus.setEditable(false);
                txtGetGateNumber.setText(flightsSelected.getGateNumber());
                txtGetGateNumber.setEditable(false);
                txtGetEconomyPrice.setText(Double.toString(flightsSelected.getEconomyPrice()));
                txtGetEconomyPrice.setEditable(false);
                txtGetBusinessPrice.setText(Double.toString(flightsSelected.getBusinessPrice()));
                txtGetBusinessPrice.setEditable(false);
                txtGetFirtsClassPrice.setText(Double.toString(flightsSelected.getFirstClassPrice()));
                dpGetDepartureDate.setValue(flightsSelected.getFlightDate());

                // Hiển thị danh sách ghế
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Unexpected error: " + e.getMessage());
        }
    }

    @FXML
    private void btnHandleBooking(ActionEvent event) {
        
        Flights flightsSelected = tvFlight.getSelectionModel().getSelectedItem();
//        StringBuilder errorMessage = new StringBuilder("Missing Fields:\n");
//        boolean isFieldMissing = false;
        Seats seat = new Seats();
        Passenger pass  = new Passenger();
        AllFlightDAO dao = new AllFlightDAO();
        try{
          pass.setFirstName(txtFirstName.getText());
          pass.setLastName(txtLastName.getText());
          pass.setDateOfBirth(dpDOB.getValue());
          pass.setGender(comboBoxGender.getValue());
          pass.setPassportID(txtPassportID.getText());
          pass.setNationality(comboBoxNational.getValue());
//          seat.setSeatNumber(comboBoxSeat.getValue());
          dao.AddPassenger(pass);
         
        }catch(SQLException e){
        e.printStackTrace();
        }
    }

    @FXML
    private void btnHandleChangeAllBooking(ActionEvent event) {
        tvPassengerFlight.setVisible(true);
    }
}

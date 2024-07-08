/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Modal.AircraftTypes;
import Modal.Airlines;
import Modal.Booking;
import Modal.Flights;
import Modal.Passenger;
import Modal.Seats;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author trums
 */
public class AllFlightDAO {

    static ConnectDB connect = new ConnectDB();
    static Connection cn = null;
    static Statement stm = null;
    static ResultSet rs = null;
    static Scanner sc;
    static PreparedStatement pStm = null;
//

    public ArrayList<Flights> listAllFlight() {
        ArrayList<Flights> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "    flights.flight_id, \n"
                + "    flights.flight_number, \n"
                + "    flights.origin_airport_code,\n"
                + "    flights.destination_airport_code,\n"
                + "    flights.departure_time, \n"
                + "    flights.arrival_time, \n"
                + "    flights.flight_date,\n"
                + "    flights.arrival_date,\n"
                + "    flights.flight_status, \n"
                + "    flights.gate_number,\n"
                + "    airlines.airline_name, \n"
                + "    aircraft_types.aircraft_type_name,\n"
                + "    flight_prices.economy_price, \n"
                + "	flight_prices.business_price, \n"
                + "	flight_prices.first_class_price\n"
                + "\n"
                + "FROM \n"
                + "    flights\n"
                + "JOIN \n"
                + "    flight_prices ON flights.flight_id = flight_prices.flight_id\n"
                + "JOIN \n"
                + "    airlines ON flights.airline_id = airlines.airline_id \n"
                + "JOIN \n"
                + "    aircraft_types ON flights.aircraft_type_id = aircraft_types.aircraft_type_id ;";
        try {
            cn = connect.GetConnectDB();
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Flights flight = new Flights();
                flight.setFlightId(rs.getInt("flight_id"));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setOriginAirportCode(rs.getString("origin_airport_code"));
                flight.setDestinationAirportCode(rs.getString("destination_airport_code"));
                flight.setDepartureTime(rs.getTime("departure_time").toLocalTime());
                flight.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
                flight.setFlightDate(rs.getDate("flight_date").toLocalDate());
                flight.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
                flight.setFlightStatus(rs.getString("flight_status"));
                flight.setGateNumber(rs.getString("gate_number"));
                flight.setAirlineName(rs.getString("airline_name"));
                flight.setAircraftTypeName(rs.getString("aircraft_type_name"));
                flight.setEconomyPrice(rs.getDouble("economy_price"));
                flight.setBusinessPrice(rs.getDouble("business_price"));
                flight.setFirstClassPrice(rs.getDouble("first_class_price"));

                list.add(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
                stm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public void AddDB(Flights flights) throws SQLException {
        String sqlFlights = "INSERT INTO flights (airline_id, aircraft_type_id, flight_number, origin_airport_code, destination_airport_code, departure_time, arrival_time, flight_date, flight_status, arrival_date, gate_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlPrices = "INSERT INTO flight_prices (flight_id, economy_price, business_price, first_class_price) VALUES (?, ?, ?, ?)";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStmFlights = cn.prepareStatement(sqlFlights, PreparedStatement.RETURN_GENERATED_KEYS); PreparedStatement pStmPrices = cn.prepareStatement(sqlPrices)) {

            // Bắt đầu một giao dịch
            cn.setAutoCommit(false);

            // Thiết lập các tham số cho câu lệnh INSERT vào bảng flights
            pStmFlights.setInt(1, flights.getAirlineId());
            pStmFlights.setInt(2, flights.getAircraftTypeId());
            pStmFlights.setString(3, flights.getFlightNumber());
            pStmFlights.setString(4, flights.getOriginAirportCode());
            pStmFlights.setString(5, flights.getDestinationAirportCode());
            pStmFlights.setTime(6, java.sql.Time.valueOf(flights.getDepartureTime()));
            pStmFlights.setTime(7, java.sql.Time.valueOf(flights.getArrivalTime()));
            pStmFlights.setDate(8, java.sql.Date.valueOf(flights.getFlightDate()));
            pStmFlights.setString(9, flights.getFlightStatus());
            pStmFlights.setDate(10, java.sql.Date.valueOf(flights.getArrivalDate()));
            pStmFlights.setString(11, flights.getGateNumber());

            pStmFlights.executeUpdate();

            // Lấy flight_id vừa thêm
            int flightId;
            try (ResultSet generatedKeys = pStmFlights.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    flightId = generatedKeys.getInt(1);

                    // Thiết lập các tham số cho câu lệnh INSERT vào bảng flight_prices
                    pStmPrices.setInt(1, flightId);
                    pStmPrices.setDouble(2, flights.getEconomyPrice());
                    pStmPrices.setDouble(3, flights.getBusinessPrice());
                    pStmPrices.setDouble(4, flights.getFirstClassPrice());

                    pStmPrices.executeUpdate();

                    // Commit giao dịch
                    cn.commit();
                } else {
                    cn.rollback();
                    throw new SQLException("Creating flight failed, no ID obtained.");
                }
            } catch (SQLException e) {
                cn.rollback();
                throw e;
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu cần
            throw new SQLException("Error in AddDB method", e);
        }
    }

    public void EditFlight(Flights flights) throws SQLException {
        String sqlFlights = "UPDATE flights SET airline_id = ?, aircraft_type_id = ?, flight_number = ?, origin_airport_code = ?, destination_airport_code = ?, departure_time = ?, arrival_time = ?, flight_date = ?, flight_status = ?, arrival_date = ?, gate_number = ? WHERE flight_id = ?";
        String sqlPrices = "UPDATE flight_prices SET economy_price = ?, business_price = ?, first_class_price = ? WHERE flight_id = ?";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStmFlights = cn.prepareStatement(sqlFlights); PreparedStatement pStmPrices = cn.prepareStatement(sqlPrices)) {

            // Bắt đầu một giao dịch
            cn.setAutoCommit(false);

            // Thiết lập các tham số cho câu lệnh UPDATE vào bảng flights
            pStmFlights.setInt(1, flights.getAirlineId());
            pStmFlights.setInt(2, flights.getAircraftTypeId());
            pStmFlights.setString(3, flights.getFlightNumber());
            pStmFlights.setString(4, flights.getOriginAirportCode());
            pStmFlights.setString(5, flights.getDestinationAirportCode());
            pStmFlights.setTime(6, java.sql.Time.valueOf(flights.getDepartureTime()));
            pStmFlights.setTime(7, java.sql.Time.valueOf(flights.getArrivalTime()));
            pStmFlights.setDate(8, java.sql.Date.valueOf(flights.getFlightDate()));
            pStmFlights.setString(9, flights.getFlightStatus());
            pStmFlights.setDate(10, java.sql.Date.valueOf(flights.getArrivalDate()));
            pStmFlights.setString(11, flights.getGateNumber());
            pStmFlights.setInt(12, flights.getFlightId());

            pStmFlights.executeUpdate();

            // Thiết lập các tham số cho câu lệnh UPDATE vào bảng flight_prices
            pStmPrices.setDouble(1, flights.getEconomyPrice());
            pStmPrices.setDouble(2, flights.getBusinessPrice());
            pStmPrices.setDouble(3, flights.getFirstClassPrice());
            pStmPrices.setInt(4, flights.getFlightId());

            pStmPrices.executeUpdate();

            // Commit giao dịch
            cn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void DeleteDB(Flights flights) {
        String deleteFlightPricesSQL = "DELETE FROM flight_prices WHERE flight_id = ?";
        String deleteFlightSQL = "DELETE FROM flights WHERE flight_id = ?";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement deleteFlightPricesStmt = cn.prepareStatement(deleteFlightPricesSQL); PreparedStatement deleteFlightStmt = cn.prepareStatement(deleteFlightSQL)) {

            // Bắt đầu một giao dịch
            cn.setAutoCommit(false);

            // Xóa dữ liệu từ bảng flight_prices
            deleteFlightPricesStmt.setInt(1, flights.getFlightId());
            deleteFlightPricesStmt.executeUpdate();

            // Xóa dữ liệu từ bảng flights
            deleteFlightStmt.setInt(1, flights.getFlightId());
            deleteFlightStmt.executeUpdate();

            // Commit giao dịch
            cn.commit();

        } catch (SQLException e) {
            // Xử lý ngoại lệ nếu cần thiết
            e.printStackTrace();
            try {
                if (cn != null) {
                    cn.rollback(); // Rollback giao dịch nếu có lỗi
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Seats> getSeatsByFlightId(int flightId) throws SQLException {
        ArrayList<Seats> seats = new ArrayList<>();
        String sql = "SELECT s.*, flight_id FROM seats s \n"
                + "                 JOIN aircraft_types at ON s.aircraft_type_id = at.aircraft_type_id \n"
                + "                 JOIN flights f ON at.aircraft_type_id = f.aircraft_type_id \n"
                + "                 WHERE f.flight_id = ?";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStm = cn.prepareStatement(sql)) {

            pStm.setInt(1, flightId);
            ResultSet rs = pStm.executeQuery();

            while (rs.next()) {
                Seats seat = new Seats();
                seat.setSeatId(rs.getInt("seat_id"));
                seat.setSeatNumber(rs.getString("seat_number"));
                seat.setIsAvailable(rs.getBoolean("is_available"));
                seats.add(seat);
            }
        }
        return seats;
    }

    public ArrayList<Seats> getAllSeats() throws SQLException {
        ArrayList<Seats> list = new ArrayList<>();
        String sql = "select seats.seat_number ,seats.is_available,aircraft_types.aircraft_type_name from seats \n"
                + "	JOIN aircraft_types ON seats.aircraft_type_id =aircraft_types.aircraft_type_id\n"
                + "	JOIN flights ON aircraft_types.aircraft_type_id= flights.aircraft_type_id where flight_id = 3";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStm = cn.prepareStatement(sql); ResultSet rs = pStm.executeQuery()) {

            while (rs.next()) {
                Seats seats = new Seats();
                seats.setSeatId(rs.getInt("seat_id"));
                seats.setAicraftTypeID(rs.getInt("aicraft_type_id"));
                seats.setSeatNumber(rs.getString("seat_number"));
                seats.setSeatClass(rs.getString("seat_class"));
                seats.setIsAvailable(rs.getBoolean("is_available"));
                list.add(seats);
            }
        }
        return list;
    }

    public Flights getFlightById(int flightId) throws SQLException {
        String sql = "SELECT f.*, fp.economy_price, fp.business_price, fp.first_class_price, a.airline_name, at.aircraft_type_name "
                + "FROM flights f "
                + "JOIN flight_prices fp ON f.flight_id = fp.flight_id "
                + "JOIN airlines a ON f.airline_id = a.airline_id "
                + "JOIN aircraft_types at ON f.aircraft_type_id = at.aircraft_type_id "
                + "WHERE f.flight_id = ?";

        try (Connection cn = connect.GetConnectDB(); PreparedStatement pStm = cn.prepareStatement(sql)) {

            pStm.setInt(1, flightId);
            ResultSet rs = pStm.executeQuery();

            if (rs.next()) {
                Flights flight = new Flights();
                flight.setFlightId(rs.getInt("flight_id"));
                flight.setFlightNumber(rs.getString("flight_number"));
                flight.setOriginAirportCode(rs.getString("origin_airport_code"));
                flight.setDestinationAirportCode(rs.getString("destination_airport_code"));
                flight.setDepartureTime(rs.getTime("departure_time").toLocalTime());
                flight.setArrivalTime(rs.getTime("arrival_time").toLocalTime());
                flight.setFlightDate(rs.getDate("flight_date").toLocalDate());
                flight.setArrivalDate(rs.getDate("arrival_date").toLocalDate());
                flight.setFlightStatus(rs.getString("flight_status"));
                flight.setGateNumber(rs.getString("gate_number"));
                flight.setAirlineName(rs.getString("airline_name"));
                flight.setAircraftTypeName(rs.getString("aircraft_type_name"));
                flight.setEconomyPrice(rs.getDouble("economy_price"));
                flight.setBusinessPrice(rs.getDouble("business_price"));
                flight.setFirstClassPrice(rs.getDouble("first_class_price"));

                return flight;
            }
        }

        return null; // Hoặc ném một ngoại lệ nếu không tìm thấy chuyến bay
    }

    public void AddPassenger(Passenger pass) throws SQLException {
        String sqlAddPass = "INSERT INTO passengers (first_name, last_name, date_of_birth, gender, passport_number, nationality) VALUES (?, ?, ?, ?, ?, ?)";
        Connection cn = null;
        PreparedStatement pStmAddPass = null;

        try {
            // Mở kết nối
            cn = connect.GetConnectDB();

            // Kiểm tra xem kết nối có mở không
            if (cn == null || cn.isClosed()) {
                throw new SQLException("The connection to the database is closed.");
            }

            // Bắt đầu một giao dịch
            cn.setAutoCommit(false);

            // Chuẩn bị câu lệnh SQL
            pStmAddPass = cn.prepareStatement(sqlAddPass);

            // Thiết lập các tham số cho câu lệnh INSERT vào bảng passengers
            pStmAddPass.setString(1, pass.getFirstName());
            pStmAddPass.setString(2, pass.getLastName());
            pStmAddPass.setDate(3, java.sql.Date.valueOf(pass.getDateOfBirth()));
            pStmAddPass.setString(4, pass.getGender());
            pStmAddPass.setString(5, pass.getPassportID());
            pStmAddPass.setString(6, pass.getNationality());

            // Thực thi câu lệnh SQL
            pStmAddPass.executeUpdate();

            // Commit giao dịch
            cn.commit();

            System.out.println("Success");
        } catch (SQLException e) {
            // Rollback giao dịch nếu có lỗi
            if (cn != null) {
                try {
                    cn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // Xử lý ngoại lệ nếu cần
            throw new SQLException("Error in passsengerDB method", e);
        } finally {
            // Đóng PreparedStatement
            if (pStmAddPass != null) {
                try {
                    pStmAddPass.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // Đảm bảo rằng auto-commit được bật trở lại sau giao dịch và đóng kết nối
            if (cn != null) {
                try {
                    cn.setAutoCommit(true);
                    cn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public void AddBooking(Booking booking, Passenger pass) throws SQLException {
    String sqlAddBooking = "INSERT INTO bookings (passenger_id, flight_id, seat_id, email, phone, booking_date_time, booking_status, total_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection cn = connect.GetConnectDB(); PreparedStatement pStmAddBooking = cn.prepareStatement(sqlAddBooking)) {
        // Kiểm tra xem kết nối có mở không
        if (cn == null || cn.isClosed()) {
            throw new SQLException("The connection to the database is closed.");
        }

        // Bắt đầu một giao dịch
        cn.setAutoCommit(false);

        // Thiết lập các tham số cho câu lệnh INSERT vào bảng bookings
        pStmAddBooking.setInt(1, pass.getPassengerID());
        pStmAddBooking.setInt(2, booking.getFlightId());
        pStmAddBooking.setInt(3, booking.getSeatId());
        pStmAddBooking.setString(4, booking.getEmail());
        pStmAddBooking.setString(5, booking.getPhone());
        pStmAddBooking.setTimestamp(6, java.sql.Timestamp.valueOf(booking.getBookingDateTime()));
        pStmAddBooking.setString(7, booking.getBookingStatus());
        pStmAddBooking.setDouble(8, booking.getTotalPrice());

        // Thực thi câu lệnh SQL
        pStmAddBooking.executeUpdate();

        // Commit giao dịch
        cn.commit();

        System.out.println("Booking added successfully");
    } catch (SQLException e) {
        // Rollback giao dịch nếu có lỗi
        throw new SQLException("Error in AddBooking method", e);
    } finally {
        // Đảm bảo rằng auto-commit được bật trở lại sau giao dịch và đóng kết nối
        if (cn != null) {
            try {
                cn.setAutoCommit(true);
                cn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

}

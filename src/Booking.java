
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Armin
 */
public class Booking {

    private static final String URL = "jdbc:derby://localhost:1527/FlightSchedulerChengminZoucvz5138";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";

    private Connection connection;
    private PreparedStatement getFlightByDay;
    private PreparedStatement insertBooking;
    private PreparedStatement cancelBooking;
    private PreparedStatement getInfoByCustomer;
    private PreparedStatement getFlightBooking;
    private PreparedStatement selectFlightBooking;
    private PreparedStatement deleteFlightBooking;

    public Booking() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            getFlightByDay = connection.prepareStatement("SELECT * FROM BOOKING WHERE FLIGHT = ? AND DAY = ?");

            getInfoByCustomer = connection.prepareStatement("SELECT * FROM BOOKING WHERE CUSTOMER = ?");

            // Get customer and day from Booking
            getFlightBooking = connection.prepareStatement("SELECT * FROM BOOKING WHERE CUSTOMER = ? AND DAY = ?");
            // Delete from Booking
            cancelBooking = connection.prepareStatement("DELETE FROM BOOKING WHERE CUSTOMER = ? AND DAY = ?");
            // Insert into Booking
            insertBooking = connection.prepareStatement("INSERT INTO BOOKING" + "(CUSTOMER,FLIGHT,DAY)" + "VALUES (?,?,?)");
            // Select flight from Booking
            selectFlightBooking = connection.prepareStatement("SELECT * FROM BOOKING WHERE FLIGHT = ?");
            // Delete flight from Booking
            deleteFlightBooking = connection.prepareStatement("DELETE FROM BOOKING WHERE FLIGHT = ?");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public List<BookingEntry> getFlightByDay(String flight, String holiday) {
        List<BookingEntry> results = null;
        ResultSet resultSet = null;

        try {
            getFlightByDay.setString(1, flight);
            getFlightByDay.setString(2, holiday);

            resultSet = getFlightByDay.executeQuery();

            results = new ArrayList<BookingEntry>();

            while (resultSet.next()) {
                results.add(new BookingEntry(resultSet.getString("CUSTOMER"),
                        resultSet.getString("FLIGHT"),
                        resultSet.getString("DAY")));

            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }

    public List<BookingEntry> getInfoByCustomer(String customer) {
        List<BookingEntry> results = null;
        ResultSet resultSet = null;

        try {
            getInfoByCustomer.setString(1, customer);

            resultSet = getInfoByCustomer.executeQuery();

            results = new ArrayList<BookingEntry>();

            while (resultSet.next()) {
                results.add(new BookingEntry(
                        resultSet.getString("CUSTOMER"),
                        resultSet.getString("FLIGHT"),
                        resultSet.getString("DAY")));

            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }

    public List<BookingEntry> getFlightBooking(String customer, String holiday) {
        List<BookingEntry> results = null;
        ResultSet resultSet = null;

        try {
            getFlightBooking.setString(1, customer);
            getFlightBooking.setString(2, holiday);

            resultSet = getFlightBooking.executeQuery();

            results = new ArrayList<BookingEntry>();

            while (resultSet.next()) {
                results.add(new BookingEntry(
                        resultSet.getString("CUSTOMER"),
                        resultSet.getString("FLIGHT"),
                        resultSet.getString("DAY")));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }

    public int cancelBooking(String customer, String holiday) {
        int result = 0;
        try {

            cancelBooking.setString(1, customer);
            cancelBooking.setString(2, holiday);
            result = cancelBooking.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    public int addBooking(String customer, String flight, String holiday) {

        int result = 0;
        try {

            insertBooking.setString(1, customer);
            insertBooking.setString(2, flight);
            insertBooking.setString(3, holiday);

            result = insertBooking.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    public List<BookingEntry> selectFlightBooking(String flight) {
        List<BookingEntry> results = null;
        ResultSet resultSet = null;

        try {
            selectFlightBooking.setString(1, flight);

            resultSet = selectFlightBooking.executeQuery();

            results = new ArrayList<BookingEntry>();

            while (resultSet.next()) {
                results.add(new BookingEntry(
                        resultSet.getString("CUSTOMER"),
                        resultSet.getString("FLIGHT"),
                        resultSet.getString("DAY")));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            }
        }
        return results;
    }

    public int deleteFlightBooking(String flight) {
        int result = 0;
        try {

            deleteFlightBooking.setString(1, flight);
            result = deleteFlightBooking.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    private void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}

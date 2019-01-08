
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class Flights {

    private static final String URL = "jdbc:derby://localhost:1527/FlightSchedulerChengminZoucvz5138";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";

    private Connection connection;
    private PreparedStatement getFlightNames;
    private PreparedStatement getFlightSeats;
    private PreparedStatement getFlightSeatsCount;
    private PreparedStatement addFlight;
    private PreparedStatement dropFlight;

    public Flights() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            getFlightNames = connection.prepareStatement("SELECT FLIGHTNAME FROM FLIGHT");
            getFlightSeatsCount = connection.prepareStatement("SELECT COUNT(FLIGHT) FROM BOOKING WHERE FLIGHT = ? AND DAY = ?");
            getFlightSeats = connection.prepareStatement("SELECT SEAT FROM FLIGHT WHERE FLIGHTNAME = ?");
            addFlight = connection.prepareStatement(
                    "INSERT INTO FLIGHT" + "(FLIGHTNAME,SEAT)" + "VALUES (?,?)");
            dropFlight = connection.prepareStatement("DELETE FROM FLIGHT WHERE FLIGHTNAME = ?");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public ArrayList<String> getFlightNames() {
        Connection connection = null;
        ResultSet resultSet = null;
        ArrayList<String> flightList = new ArrayList<String>();
        try {

            resultSet = getFlightNames.executeQuery();

            while (resultSet.next()) {
                flightList.add(resultSet.getString("FLIGHTNAME"));

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
        return flightList;
    }

    public int getFlightSeat(String flightName) {
        Connection connection = null;
        ResultSet resultSet = null;
        int seat = 0;
        try {
            getFlightSeats.setString(1, flightName);

            resultSet = getFlightSeats.executeQuery();
            while (resultSet.next()) {
                seat = resultSet.getInt("SEAT");

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
        return seat;
    }

    public int getFlightSeatsCount(String flightName, String day) {

        Connection connection = null;
        ResultSet resultSet = null;
        int seatsBooked = 0;
        try {

            getFlightSeatsCount.setString(1, flightName);
            getFlightSeatsCount.setString(2, day);

            resultSet = getFlightSeatsCount.executeQuery();

            while (resultSet.next()) {
                seatsBooked = resultSet.getInt(1);

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
        return seatsBooked;
    }

    public int addFlight(String flight, int seats) {

        int result = 0;
        try {
            addFlight.setString(1, flight);
            addFlight.setInt(2, seats);

            result = addFlight.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    public int dropFlight(String flight) {
        int result = 0;
        try {

            dropFlight.setString(1, flight);

            result = dropFlight.executeUpdate();

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

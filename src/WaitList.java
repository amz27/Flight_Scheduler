
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Armin
 */
public class WaitList {

    private static final String URL = "jdbc:derby://localhost:1527/FlightSchedulerChengminZoucvz5138";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";

    private Connection connection;
    private PreparedStatement getWaitListByDay;
    private PreparedStatement insertWaitList;
    private PreparedStatement getWaitListInfoByCustomer;
    private PreparedStatement cancelWaitList;
    private PreparedStatement deleteWaitList;
    private PreparedStatement deleteFlightWaitList;
    private PreparedStatement checkWaitList;
    private PreparedStatement checkWaitListForCustomer;
    private PreparedStatement deleteCustomer;

    public WaitList() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            getWaitListByDay = connection.prepareStatement("SELECT * FROM WAITLIST WHERE DAY = ?");
            insertWaitList = connection.prepareStatement(
                    "INSERT INTO WAITLIST" + "(CUSTOMER,FLIGHT,TIMESTAMP,DAY)" + "VALUES (?,?,?,?)");
            getWaitListInfoByCustomer = connection.prepareStatement("SELECT * FROM WAITLIST WHERE CUSTOMER = ?");

            deleteFlightWaitList = connection.prepareStatement("DELETE FROM WAITLIST WHERE FLIGHT = ?");

            // Check customer and day in Waitlist 
            checkWaitList = connection.prepareStatement("SELECT * FROM WAITLIST WHERE FLIGHT = ? AND DAY = ? ORDER BY TIMESTAMP");
            // Delete from Waitlist 
            cancelWaitList = connection.prepareStatement("DELETE FROM WAITLIST WHERE CUSTOMER = ? AND DAY = ?");
            // Check Waitlist for other customer waiting for the flight and day
            checkWaitListForCustomer = connection.prepareStatement("SELECT CUSTOMER, DAY FROM WAITLIST WHERE CUSTOMER = ? AND DAY = ?");
            // Delete the customer from Waitlist
            deleteCustomer = connection.prepareStatement("DELETE FROM WAITLIST WHERE CUSTOMER = ?");
            // Delete the customer in waitlist with that flight for that day
            deleteWaitList = connection.prepareStatement("DELETE FROM WAITLIST WHERE CUSTOMER = ? AND FLIGHT = ? AND DAY = ?");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public List<WaitListEntry> getWaitListByDay(String holiday) {
        List<WaitListEntry> results = null;
        ResultSet resultSet = null;
        try {
            getWaitListByDay.setString(1, holiday);

            resultSet = getWaitListByDay.executeQuery();

            results = new ArrayList<WaitListEntry>();

            while (resultSet.next()) {
                results.add(new WaitListEntry(
                        resultSet.getString("CUSTOMER"),
                        resultSet.getString("FLIGHT"),
                        resultSet.getTimestamp("TIMESTAMP"),
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

    public int addWaitList(String customer, String flight, java.sql.Timestamp timeStamp, String day) {
        int result = 0;
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

        try {
            insertWaitList.setString(1, customer);
            insertWaitList.setString(2, flight);
            insertWaitList.setTimestamp(3, currentTimestamp);
            insertWaitList.setString(4, day);

            result = insertWaitList.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    public int deleteFlightWaitList(String flight) {
        int result = 0;
        try {

            deleteFlightWaitList.setString(1, flight);

            result = deleteFlightWaitList.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    public List<WaitListEntry> getWaitListInfoByCustomer(String customer) {
        List<WaitListEntry> results = null;
        ResultSet resultSet = null;

        try {
            getWaitListInfoByCustomer.setString(1, customer);

            resultSet = getWaitListInfoByCustomer.executeQuery();

            results = new ArrayList<WaitListEntry>();

            while (resultSet.next()) {
                results.add(new WaitListEntry(
                        resultSet.getString("CUSTOMER"),
                        resultSet.getString("FLIGHT"),
                        resultSet.getTimestamp("TIMESTAMP"),
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

    public List<WaitListEntry> checkWaitList(String flight, String holiday) {
        List<WaitListEntry> results = null;
        ResultSet resultSet = null;
        try {
            checkWaitList.setString(1, flight);
            checkWaitList.setString(2, holiday);

            resultSet = checkWaitList.executeQuery();

            results = new ArrayList<WaitListEntry>();

            if (resultSet.next()) {
                results.add(new WaitListEntry(
                        resultSet.getString("CUSTOMER"),
                        resultSet.getString("FLIGHT"),
                        resultSet.getTimestamp("TIMESTAMP"),
                        resultSet.getString("DAY")
                ));
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

    public int cancelWaitList(String customer, String holiday) {
        int result = 0;
        try {

            cancelWaitList.setString(1, customer);
            cancelWaitList.setString(2, holiday);
            result = cancelWaitList.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    public int deleteWaitList(String customer, String flight, String holiday) {
        int result = 0;
        try {

            deleteWaitList.setString(1, customer);
            deleteWaitList.setString(2, flight);
            deleteWaitList.setString(3, holiday);
            result = deleteWaitList.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        }
        return result;
    }

    public List<WaitListEntry> checkWaitListForCustomer(String customer, String holiday) {
        List<WaitListEntry> results = null;
        ResultSet resultSet = null;
        try {
            checkWaitListForCustomer.setString(1, customer);
            checkWaitListForCustomer.setString(2, holiday);

            resultSet = checkWaitList.executeQuery();

            results = new ArrayList<WaitListEntry>();

            if (resultSet.next()) {
                results.add(new WaitListEntry(
                        resultSet.getString("CUSTOMER"),
                        resultSet.getString("FLIGHT"),
                        resultSet.getTimestamp("TIMESTAMP"),
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

    public int deleteCustomer(String customer) {
        int result = 0;
        try {

            deleteCustomer.setString(1, customer);

            result = deleteCustomer.executeUpdate();

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

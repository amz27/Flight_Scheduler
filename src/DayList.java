
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Armin
 */
public class DayList {

    private static final String URL = "jdbc:derby://localhost:1527/FlightSchedulerChengminZoucvz5138";
    private static final String USERNAME = "java";
    private static final String PASSWORD = "java";

    private Connection connection;
    private PreparedStatement getDays;
    private PreparedStatement addDay;

    public DayList() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            getDays = connection.prepareStatement("SELECT * FROM DAY");
            addDay = connection.prepareStatement("INSERT INTO DAY" + "(HOLIDAY)" + "VALUES (?)");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public List<DayEntry> getDays(String holiday) {
        List<DayEntry> results = null;
        ResultSet resultSet = null;
        try {
            getDays.setString(1, holiday);
            resultSet = getDays.executeQuery();
            results = new ArrayList<DayEntry>();
            while (resultSet.next()) {
                results.add(new DayEntry(
                        resultSet.getString("holiday")));
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

    public int addDay(String holiday) {

        int result = 0;
        try {

            addDay.setString(1, holiday);
            result = addDay.executeUpdate();

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

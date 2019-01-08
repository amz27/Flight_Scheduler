/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Armin
 */
public class WaitListEntry {

    private String customer;
    private String flight;
    private String holiday;
    private java.sql.Timestamp timeStamp;

    public WaitListEntry() {
    }

    public WaitListEntry(String customer, String flight, java.sql.Timestamp timeStamp, String holiday) {
        setCustomer(customer);
        setFlight(flight);
        setHoliday(holiday);
        setTimeStamp(timeStamp);
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getFlight() {
        return flight;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setTimeStamp(java.sql.Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public java.sql.Timestamp timeStamp() {
        return timeStamp;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getHoliday() {
        return holiday;
    }

}

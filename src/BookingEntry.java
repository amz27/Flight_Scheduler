/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Armin
 */
class BookingEntry {

    private String customer;
    private String flight;
    private String holiday;

    public BookingEntry() {
    }

    public BookingEntry(String customer, String flight, String holiday) {
        setCustomer(customer);
        setFlight(flight);
        setDay(holiday);

    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public String getFlight() {
        return flight;
    }

    public void setDay(String holiday) {
        this.holiday = holiday;
    }

    public String getDay() {
        return holiday;
    }

}

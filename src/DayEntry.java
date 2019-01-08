/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Armin
 */
public class DayEntry {

    private String holiday;

    public DayEntry() {
    }

    public DayEntry(String holiday) {
        setHoliday(holiday);
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

    public String getHoliday() {
        return holiday;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalDate;

//This class represents a trigger based on a specific day 
//of the month. It allows users to set a trigger for a 
//particular day within a month.
public class TriggerDayMonth implements Trigger {
    private int dayOfMonth;

    public TriggerDayMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
    /*Verifies if the trigger should activate based on the current day of the month.
    It compares the current day of the month with the set day for the trigger and
    return true if the trigger should activate*/
    @Override
    public boolean checkTrigger() {
        return LocalDate.now().getDayOfMonth() == dayOfMonth;
    }
    
    //Generates a description of the trigger
    @Override
    public String description() {
      return TriggerDayMonth.class.getSimpleName() + "\n" + "on day of month " + dayOfMonth;
    }
}

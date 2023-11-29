

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Ifttt_app.Model;
import java.time.DayOfWeek;
import java.time.LocalDate;


// This class represents a trigger based on a specific day of the week.
public class TriggerDay implements Trigger {
    private final DayOfWeek day;

    public TriggerDay(DayOfWeek day) {
        this.day = day;
    }
    // Checks if the trigger should activate based on the current day of the week
    @Override
    public boolean checkTrigger() {
      if(DayOfWeek.from(LocalDate.now()).compareTo(day) == 0)   
        return true;
      else
        return false;
    }
    
    //Generates a description of the trigger
    @Override
    public String description() {
      return TriggerDay.class.getSimpleName()+"\n"+"on day "+ day.toString();
    }
    
}

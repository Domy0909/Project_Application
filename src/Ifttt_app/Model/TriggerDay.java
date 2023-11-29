

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Ifttt_app.Model;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class TriggerDay implements Trigger {
    private final DayOfWeek day;

    public TriggerDay(DayOfWeek day) {
        this.day = day;
    }
    
    @Override
    public boolean checkTrigger() {
      if(DayOfWeek.from(LocalDate.now()).compareTo(day) == 0)   
        return true;
      else
        return false;
    }
    
    @Override
    public String description() {
      return TriggerDay.class.getSimpleName()+"\n"+"after "+ day.toString();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalDateTime;
import java.time.LocalTime;

/*this class TimeTrigger, implementing the Trigger interface, aims to verify if 
the current time is equal to or later than the time specified within the trigger.*/
public class TimeTrigger implements Trigger{
    
    private LocalTime timetrigger;
    
    /*The checkTrigger() function compares the current timestamp with the time 
    specified in the trigger. If the current time is equal to or later than the 
    trigger's time, it will return true; otherwise, it will return false.*/
    @Override
    public boolean checkTrigger() {
      if(LocalTime.now().compareTo(this.timetrigger) >= 0)   
        return true;
      else
        return false;
    }

    public TimeTrigger(LocalTime timetrigger) {
        this.timetrigger = timetrigger;
    }

    @Override
    public String description() {
      return TimeTrigger.class.getSimpleName()+"\n"+"after "+timetrigger.toString();
    }
  
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author aless
 */
public class TimeTrigger implements Trigger{
    
    LocalTime timetrigger;
    
    
    //questa funzione verifica se il
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

   
   
}

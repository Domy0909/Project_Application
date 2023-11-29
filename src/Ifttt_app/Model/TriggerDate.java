/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalDate;

// This class represents a trigger based on a specific date
public class TriggerDate implements Trigger{
    LocalDate date;

    public TriggerDate(LocalDate date) {
        this.date = date;
    }
    /* This method compares the current date with the date provided during the
    trigger's creation. It returns true if the two dates are equal; otherwise, it
    returns false, indicating whether the trigger should be activated based on
    the current date.*/
    @Override
    public boolean checkTrigger() {
            return LocalDate.now().isEqual(date); // Restituisce true se la data corrente è uguale alla data fornita
    };
        
    //Generates a description of the trigger
    @Override
    public String description() {
      return TriggerDate.class.getSimpleName() + "\n" + "on date " + date;
    }
}

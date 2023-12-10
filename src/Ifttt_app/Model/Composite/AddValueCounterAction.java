/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.Action;
import Ifttt_app.Model.Counter;
import Ifttt_app.Model.CounterSet;

/**
 *
 * @author aless
 */
/**
 * Represents an action to add a numeric value to a counter.
 * Implements the Action interface.
 */
public class AddValueCounterAction implements Action{
    private String a; //Counter name
    private Integer b; // Value to add

    
    
    public AddValueCounterAction(String a, Integer b) {
        this.a = a;
        this.b = b;
    }

    
    
    // Executes the action by adding the specified value to the counter.
    @Override
    public boolean execute() {
       Counter c=CounterSet.getInstance().getCounter(a);
       if(c!=null){
           c.setValue(c.getValue()+b); 
           return true;           // Action executed successfully
       }
      
       return false; // Counter with the specified name not found
           
    }
    //Provides a description of the action.
    @Override
    public String description() {
        return "Add to Counter:"+a+" this "+b.toString();
    }
}

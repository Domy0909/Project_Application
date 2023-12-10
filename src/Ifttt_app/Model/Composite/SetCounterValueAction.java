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
 * Represents an action to set the value of a counter.
 * Implements the Action interface.
 * 
 */

public class SetCounterValueAction implements Action {
    private String a;
    private Integer b;

    public SetCounterValueAction(String a, Integer b) {
        this.a = a;
        this.b = b;
    }

     /**
     * Executes the action by setting the value of the specified counter.
     *
     *
     */
    @Override
    public boolean execute() {
       Counter c=CounterSet.getInstance().getCounter(a);
       if(c!=null){
           c.setValue(b);
           return true;
       }
      
       return false;  // Counter with the specified name not found
           
    }

    @Override
    public String description() {
        return "Set Counter:"+a+" to "+b.toString();
    }
    
}

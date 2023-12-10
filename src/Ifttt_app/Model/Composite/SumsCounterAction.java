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
/*
 * Represents an action to sum the values of two counters.
 * Implements the Action interface.
 *
 */
public class SumsCounterAction implements Action {
    private String a;
    private String b;

    public SumsCounterAction(String a, String b) {
        this.a = a;
        this.b = b;
    }

    
    
    /**
     * Executes the action by summing the values of the specified counters.
     *
     * 
     */
    
    @Override
    public boolean execute() {
        Counter c=CounterSet.getInstance().getCounter(a);
        Counter d=CounterSet.getInstance().getCounter(b);
       if(c!=null && d!=null){
           c.setValue(c.getValue()+d.getValue());
           return true;
       }
       
       return false;  // One or both counters not found
           
    }

    @Override
    public String description() {
        return "Sum of Counter:"+a+'\n'+"and Counter:" +b;
    }
   
    
}

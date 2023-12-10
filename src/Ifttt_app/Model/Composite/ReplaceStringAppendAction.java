/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.Action;
import Ifttt_app.Model.Composite.SpecifiedStringAction;
import Ifttt_app.Model.CounterSet;

/**
 *
 * @author aless
 */
/**
 * Represents an action to replace placeholders in a SpecifiedStringAction with counter values
 * for appending content.
 * Implements the Action interface.
 * Provides methods to execute the action and obtain a description of the action.
 */
public class ReplaceStringAppendAction implements Action{
    SpecifiedStringAction action;
    String c;
    
    
    /**
     * Executes the action by replacing placeholders in the SpecifiedStringAction for appending content
     * with counter values. If the specified counter exists, it replaces placeholders in the content
     * to be appended and executes the action.
     *
     * 
     */
    
    @Override
    public boolean execute() {
       if(CounterSet.getInstance().counter_set.contains(CounterSet.getInstance().getCounter(c))){
         action.setContentToAppend(action.getContentToAppend().replaceAll("\\$", 
                CounterSet.getInstance().getCounter(c).getValue().toString()));
        return action.execute();  
       }
        
       
       return false;
    }

    public ReplaceStringAppendAction(SpecifiedStringAction action, String c) {
        this.action = action;
        this.c = c;
    }
    
    //Provides a description of the ReplaceStringAppendAction.
    
    @Override
    public String description() {
          return action.description()+'\n'+"substitution of $ \n with value of "+c;
    }
    
}

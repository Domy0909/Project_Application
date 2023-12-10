/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.Action;
import Ifttt_app.Model.Composite.ShowDialogAction;
import Ifttt_app.Model.CounterSet;

/**
 *
 * @author aless
 */
/**
 * Represents an action to replace placeholders in a ShowDialogAction with counter values.
 * Implements the Action interface.
 * 
 */
public class ReplaceShowDialogAction implements Action{
    ShowDialogAction action;
    String c;
     
      /**
     * Executes the action by replacing placeholders in the ShowDialogAction with counter values.
     * If the specified counter exists, it replaces placeholders in the specific string
     * of the ShowDialogAction and executes it.
     *
     *@return True if the action was executed successfully, false otherwise.
     */
    @Override
    public boolean execute() {
     if(CounterSet.getInstance().counter_set.contains(CounterSet.getInstance().getCounter(c))){
         action.setSpecificstring(action.getSpecificstring().replaceAll("\\$", 
                CounterSet.getInstance().getCounter(c).getValue().toString()));
        return action.execute();
     }   
        
       return false;
    }

    public ReplaceShowDialogAction(ShowDialogAction action, String c) {
        this.action = action;
        this.c = c;
    }
    
    @Override
    public String description() {
       return action.description()+'\n'+" substitution of $ \n with value of "+c;
    }
    
}

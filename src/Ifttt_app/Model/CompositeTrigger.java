/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

/**
 *This class represents a composite trigger that can hold two triggers (a and b)
 * and a boolean variable (c) determining the type of logical operation to 
 * perform between the two triggers (AND or OR).
 * 
 */
public class CompositeTrigger implements Trigger {
    
    private Trigger a;
    private Trigger b;
    private Boolean c;
 
    
    /*The checkTrigger() function evaluates whether the composite trigger is 
    activated or not. If c is true, it will return true only if both triggers 
    a and b are active (AND). If c is false, it will return true if at least one 
    of the triggers a or b is active (OR).*/
    @Override
    public boolean checkTrigger() {
     if(c)   
      return a.checkTrigger() && b.checkTrigger();
     else
      return a.checkTrigger() || b.checkTrigger();   
    }

    public CompositeTrigger(Trigger a, Trigger b, Boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public String description() {
        if(c)
            return" ( "+ a.description()+" ) \n AND \n( "+b.description()+" )";
        else
            return" ( "+ a.description()+" ) \n OR \n( "+b.description()+" )";
    }
    
}

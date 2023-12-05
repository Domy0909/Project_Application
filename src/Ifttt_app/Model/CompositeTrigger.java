/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

/**
 *
 * @author aless
 */
public class CompositeTrigger implements Trigger {
    
    Trigger a;
    Trigger b;
    Boolean c;

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

/**
 *The NotTrigger class implements the Trigger interface and reverses the 
 * behavior of another Trigger object passed as an argument in its constructor.
 */
public class NotTrigger implements Trigger {
    private Trigger trigger;

    @Override
    public boolean checkTrigger() {
        return !trigger.checkTrigger();
    }

    public NotTrigger(Trigger trigger) {
        this.trigger = trigger;
    }
    @Override
    public String description() {
       return "When this condition is not :"+trigger.description();
    }
    
}

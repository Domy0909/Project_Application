/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.time.LocalDateTime;

/**
 *
 * @author aless
 */
public class Rule {
    
    
    private Action action;
    private Trigger trigger;
    private boolean active;
    private boolean firedOnlyOnce;
    private boolean fired_oo;
    private boolean sleeping;
    private LocalDateTime sleepingDate;

    public void setAction(Action action) {
        this.action = action;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setFiredOnlyOnce(boolean firedOnlyOnce) {
        this.firedOnlyOnce = firedOnlyOnce;
    }

    public void setFired_oo(boolean fired_oo) {
        this.fired_oo = fired_oo;
    }

    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    public void setSleepingDate(LocalDateTime sleepingDate) {
        this.sleepingDate = sleepingDate;
    }

    public Action getAction() {
        return action;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isFiredOnlyOnce() {
        return firedOnlyOnce;
    }

    public boolean isFired_oo() {
        return fired_oo;
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public LocalDateTime getSleepingDate() {
        return sleepingDate;
    }
    
    
}

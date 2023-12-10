package Ifttt_app.Model;

import Ifttt_app.Model.Composite.ShowDialogAction;
import Ifttt_app.Model.Composite.Action;
import java.io.Serializable;
import java.time.LocalDateTime;


public class Rule implements Serializable{
    
    
    private Action action;
    private Trigger trigger;
    private boolean active;
    private boolean firedOnlyOnce; //this variable tells me if the rule must be fired only once.
    private boolean fired_oo; //this variable tells me if the rule has already been executed once.
    private boolean sleeping; //this variable tells me if the rule has a sleepig period.
    private int day; //this variable indicates the number of days the rule must sleep.
    private int hours; //this variable indicates the number of hours the rule must sleep.
    private int minutes; //this variable indicates the number of minutes the rule must sleep.
    private LocalDateTime awake; //this variable tells me when the rule ends its sleeping period.

    public Rule(Action action, Trigger trigger) {
        this.action = action;
        this.trigger = trigger;
        this.active=true;
        this.firedOnlyOnce=false;
        this.fired_oo=false;
        this.sleeping=false;
    }
    /*
    Used for testing
    */
    public Rule(){
       this.fired_oo = false;
       this.awake = LocalDateTime.of(0, 1, 1, 0, 0, 0, 0);
       this.hours = 0;
       this.day = 0;
       this.minutes = 5;
    
    }
    /*
    Used for testing
    */
    public Rule(Action action,Trigger trigger, boolean active, int day, int hours, int minutes){
        this.action = action;
        this.trigger = trigger;
        this.active = active;
        this.firedOnlyOnce = false;
        this.sleeping = false;
        this.awake = LocalDateTime.of(0, 1, 1, 0, 0, 0, 0);
        this.fired_oo = false;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
    }
    
    public void setDay(int day){
        this.day = day;
    }
    
    public int getDay(){
        return day;
    }
    
    public void setHours(int hours){
        this.hours = hours;
    }
    
    public int getHours(){
        return hours;
    }
    
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    
    public int getMinutes(){
        return minutes;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    
    public void setAction(ShowDialogAction action) {
        this.action = action;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }
    
     public void setTrigger(TimeTrigger trigger) {
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
    
    public void setAwake(LocalDateTime awake){
        this.awake = awake;
    }
    
    public LocalDateTime getAwake(){
        return awake;
    
    }
    /*
    The whenAwake function is used when you need to calculate the awakening date of the rules.
    Adds days hours and minutes set by the user to the date when the rule is invoked and calculates
    the awakening date, then set the awake variable to the date calculated.
    */
    public void whenAwake(){
        LocalDateTime today = LocalDateTime.now();
        int d,h,m;
        d = this.getDay();
        h = this.getHours();
        m = this.getMinutes();
        LocalDateTime plus = today.plusDays(d).plusHours(h).plusMinutes(m);
        this.setAwake(plus);
    }
    /*
    The isAwake function tells me if the rule is in his sleep period or not.
    Performs a simple check between the date when the rule is invoked and the awakening date.
    */
    public boolean isAwake(){
        LocalDateTime today = LocalDateTime.now();
        if(this.getAwake() == null)
            return true;
        int compare = today.compareTo(this.getAwake());
        return compare > 0 || compare == 0;
        
    }
    
}
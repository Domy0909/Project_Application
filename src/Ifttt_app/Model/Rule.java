/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author aless
 */
public class Rule implements Serializable{
    
    
    private Action action;
    private Trigger trigger;
    private boolean active;
    private boolean firedOnlyOnce; //variabile che mi dice se la regola deve essere eseguita solo una volta
    private boolean fired_oo; //variabile che mi dice se la regola è stata eseguita già una volta
    private boolean sleeping; //variabile che indica se la regola ha un periodo di "sonno"
    private int day; //variabile che indiaca il numero di giorni che la regola deve dormire
    private int hours; //variabile che indiaca il numero di ore che la regola deve dormire
    private int minutes; //variabile che indiaca il numero di minuti che la regola deve dormire
    private LocalDateTime awake; //variabile che mi dice quando la regola si sveglia dopo il periodo di "sonno"

    public Rule(Action action, Trigger trigger) {
        this.action = action;
        this.trigger = trigger;
        this.active=true;
        this.firedOnlyOnce=true;
        this.fired_oo=false;
        this.sleeping=false;
    }
    /*
    Costruttore usato per i testing
    */
    public Rule(){
       this.fired_oo = false;
       this.awake = LocalDateTime.of(0, 1, 1, 0, 0, 0, 0);
       this.hours = 0;
       this.day = 0;
       this.minutes = 5;
    
    }
    
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
    La funzione whenAwake viene usata quando bisogna calcolare la data di risveglio della regole.
    Aggiunge alla data di quando viene invocata i giorno le ore e i minuti impostati dall'utente e si calcola
    la data di risveglio, poi setta la variabile awake a quella data.
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
    La funzione isAwake mi dice se la regola sta nel suo periodo di sonno oppure no.
    Esegue un semplice controllo fra la data di quando viene invocata e la data di risveglio.
    */
    public boolean isAwake(){
        LocalDateTime today = LocalDateTime.now();
        if(this.getAwake() == null)
            return true;
        int compare = today.compareTo(this.getAwake());
        return compare > 0 || compare == 0;
        
    }
    
}

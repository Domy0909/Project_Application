/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class RuleSet extends Thread{
    private static RuleSet instance;
    public ObservableList<Rule> ruleSet;
    private boolean running;

    private RuleSet() {
        this.ruleSet = FXCollections.observableArrayList();
    }

    public RuleSet(ObservableList<Rule> ruleSet, boolean running) {
        this.ruleSet = ruleSet;
        this.running = running;
    }
     
    
    public static RuleSet getInstance() {
        if (instance == null) { 
            instance = new RuleSet();
        }
        return instance;
    }
    
    public ObservableList<Rule> getRules(){
        return this.ruleSet;
    }
    
   public void addRule(Rule r){
       this.ruleSet.add(r);
    }
    public void removeRule(Rule r){
       this.ruleSet.remove(r);
    }
    
    public void removeallRule(){
       this.ruleSet.removeAll(this.ruleSet);
    }
    public void stopRuleChecking() {
     running = false;
    }
   /*
  
 * Starts rule checking in a separate thread.
 * For each rule in the list, periodically checks if the rule is active,
 * if its trigger is active, and if it has already been executed.
 * If the rule meets the conditions, it executes the associated action.
 * The check is performed every second.
 */
    public void runRuleChecking() {
        Thread checkingThread;
        checkingThread = new Thread(() -> {
            while (!running) {
                for (Rule rule : ruleSet) {
                    if(rule.isSleeping() && rule.isActive()){
                        if(rule.isAwake()){
                           if(rule.getTrigger().checkTrigger()){
                               rule.getAction().execute();
                               rule.whenAwake();
                           }
                           
                        }
                    }
                    if (rule.isActive() && rule.isFired_oo()==false) {
                       if(rule.getTrigger().checkTrigger()){
                         rule.setFired_oo(true); 
                         rule.getAction().execute();  
                       } 
                       
                    }
                }  
               
                try { 
                    Thread.sleep(1000);
                
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } 
           });
        checkingThread.setDaemon(true);
        checkingThread.start();
    }
}

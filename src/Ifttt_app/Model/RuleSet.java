/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author aless
 */
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
   
    public void runRuleChecking() {
        /* Crea un nuovo thread per eseguire
        il controllo delle regole*/
        Thread checkingThread;
        checkingThread = new Thread(() -> {
            while (!running) {
                for (Rule rule : ruleSet) {
                    /* Verifica se la regola è attiva,
                    se il trigger è attivo e se non è 
                    già stata eseguita*/
                    if (rule.isActive() && rule.getTrigger().checkTrigger() && rule.isFired_oo()==false) {
                       rule.setFired_oo(true); 
                       rule.getAction().execute();
                    }
                }  
               
                try { 
                    // Controllo ogni 5 secondi
                    Thread.sleep(5000);
                
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } 
           });
        checkingThread.setDaemon(true);
        checkingThread.start();
    }
}

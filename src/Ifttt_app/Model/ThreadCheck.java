/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import Ifttt_app.Model.ChainOfResponsability.*;

/**
 *
 * @author marco
 */
public class ThreadCheck extends Thread{
    
        private boolean running;
        private RuleSet ruleSet;
        
        public ThreadCheck(RuleSet ruleSet, boolean running){
            this.ruleSet = ruleSet;
            this.running = running;
        }
        
        public void stopRuleChecking() {
            running = true;
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
            RuleHandler firedOnlyOnceHandler=new FiredOnlyOnceHandler();
            RuleHandler sleepingPeriodHandler=new SleepingPeriodHandler();
            
            while (!running) {
                for (Rule rule : ruleSet.getRules()) {
                    //Configures handler succession
                    firedOnlyOnceHandler.setSuccessor(sleepingPeriodHandler);
                    
                    firedOnlyOnceHandler.handle(rule);
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

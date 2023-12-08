/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import Ifttt_app.Model.ChainOfResponsability.*;
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

}

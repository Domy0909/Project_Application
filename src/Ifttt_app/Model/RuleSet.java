/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import javafx.collections.ObservableList;

/**
 *
 * @author aless
 */
public class RuleSet {
    private static RuleSet instance;
    public ObservableList<Rule> ruleSet;

    private RuleSet(ObservableList<Rule> ruleSet) {
        this.ruleSet = ruleSet;
    }
     
    
    public static RuleSet getInstance(ObservableList<Rule> ruleSet) {
        if (instance == null) { 
            instance = new RuleSet(ruleSet);
        }
        return instance;
    }
    
   public void addRule(Rule r){
       this.ruleSet.add(r);
    }
    public void removeRule(Rule r){
       this.ruleSet.remove(r);
    }
    
}

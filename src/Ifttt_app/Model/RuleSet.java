/*
This class contains a set of rules create by the user. 
The Singleton pattern was employed in designing this class,
ensuring the existence of only a single instance of the class.
 */
package Ifttt_app.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class RuleSet {
    private static RuleSet instance;
    private ObservableList<Rule> ruleSet;
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

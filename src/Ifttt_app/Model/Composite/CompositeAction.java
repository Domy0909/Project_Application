/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.Action;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
/**
 * Represents a composite action that consists of a sequence of individual actions.
 * Implements the Action interface.
 * The overall result of the composite action reflects whether all individual actions
 * were executed successfully or not.
 *
 */
public class CompositeAction implements Action{
    private List<Action> actions;
    private boolean overallResult=false;

    public CompositeAction() {
        this.actions = new ArrayList<>();
    }

    public CompositeAction(List<Action> actions) {
        this.actions = actions;
    }
    
    public void addAction(Action action) {
        actions.add(action);
    }
    public void removeAction(Action action) {
        actions.remove(action);
    }

    public boolean isOverallResult() {
        return overallResult;
    }

    public void setOverallResult(boolean overallResult) {
        this.overallResult = overallResult;
    }
    
    /*Executes a sequence of actions contained within the CompositeAction.
     It iterates through the list of actions, executes each action, and 
     calculates the overall result.
     The overall result reflects whether all actions were executed successfully 
     or not.
     Note: If the list of actions is empty, the overall result remains 'true' 
    by default.
    */
    @Override
    public boolean execute() {
        if(!actions.isEmpty()){
            this.overallResult=true; 
            for (Action action : actions) {
                boolean result = action.execute();
                this.setOverallResult(this.isOverallResult() && result);
            }
        }
        return this.isOverallResult();
        
    }
//the overall description of the sequence of action is the sum of the description of the singular actions
    @Override
    public String description() {
        StringBuilder descriptionBuilder = new StringBuilder("Composite Action:\n");
        for (Action action : actions) {
            descriptionBuilder.append(action.description()).append("\n");
        }
        return descriptionBuilder.toString();
    }
}
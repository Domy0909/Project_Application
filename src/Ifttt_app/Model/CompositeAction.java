/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class CompositeAction implements Action{
    private List<Action> actions;

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
    
    @Override
    public boolean execute() {
        boolean overallResult = true; 

        for (Action action : actions) {
            boolean result = action.execute();
            overallResult = overallResult && result;
        }
        return overallResult;
    }

    @Override
    public String description() {
        StringBuilder descriptionBuilder = new StringBuilder("Composite Action:\n");
        for (Action action : actions) {
            descriptionBuilder.append(action.description()).append("\n");
        }
        return descriptionBuilder.toString();
    }
}
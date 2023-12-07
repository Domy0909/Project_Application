/*
 * The SleepingPeriodHandler class is designed to handle rules associated with sleeping periods.
 * It overrides the handle method to check if the rule is in a sleeping state, is active, awake, and the trigger condition is met.
 * If all conditions are true, it invokes the whenAwake method on the rule, executes the associated action, and does not pass the rule further in the chain.
 * If the rule does not meet the criteria, it continues to the next handler in the chain.
 */

package Ifttt_app.Model.ChainOfResponsability;

import Ifttt_app.Model.Rule;

public class SleepingPeriodHandler extends BaseHandler{
    
    @Override
    public void handle(Rule rule) {
        if (rule.isSleeping()) {
            if(rule.isActive() && rule.isAwake() && rule.getTrigger().checkTrigger()){
                rule.whenAwake();
                rule.getAction().execute();
            }
        }
        
    }
}

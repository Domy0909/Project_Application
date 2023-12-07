/*
 * The FiredOnlyOnceHandler class is designed to handle rules that should only fire once.
 * It overrides the handle method to check if the rule is flagged as "fired only once," is active, has not been previously fired, and the trigger condition is met.
 * If all conditions are true, it marks the rule as fired, executes the associated action, and prevents further handling.
 * If the rule does not meet the criteria, it passes the rule to the next handler in the chain.
 */

package Ifttt_app.Model.ChainOfResponsability;

import Ifttt_app.Model.Rule;

public class FiredOnlyOnceHandler extends BaseHandler{
   
    
    @Override
    public void handle(Rule rule) {
        if (rule.isFiredOnlyOnce()) {
              if(rule.isActive() && rule.isFired_oo()==false && rule.getTrigger().checkTrigger()){
                  rule.setFired_oo(true);
                  rule.getAction().execute();
              }
              
        }else {
            super.handle(rule);
        }
            
    
    }
  
}

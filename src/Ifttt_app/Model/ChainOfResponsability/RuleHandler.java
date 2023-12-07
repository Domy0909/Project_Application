
package Ifttt_app.Model.ChainOfResponsability;

import Ifttt_app.Model.Rule;


public interface RuleHandler {
    
    public void handle(Rule rule);

    public void setSuccessor(RuleHandler successor);
    
}

/*
 * The BaseHandler class implements the RuleHandler interface and serves as the base class for rule handling in a chain of responsibility.
 * It contains a reference to the next handler in the chain, allowing for the sequential processing of rules.
 * The handle method is overridden to pass the rule to the next handler if one exists.
 * The setSuccessor method is used to set the successor handler in the chain.
 */
package Ifttt_app.Model.ChainOfResponsability;

import Ifttt_app.Model.Rule;


public class BaseHandler implements RuleHandler{
    private RuleHandler successor;

    @Override
    public void handle(Rule rule) {
        if (successor != null) {
            successor.handle(rule);
        }
    }

    @Override
    public void setSuccessor(RuleHandler successor) {
       this.successor=successor;
    }
    
}

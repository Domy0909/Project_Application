/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

/**
 * This class represents a trigger for comparing two counter values.
 * It implements the Trigger interface and provides methods to check the trigger condition
 * and retrieve a description of the trigger.
 */
public class TriggerCountersCompare implements Trigger{
    private final String countername1;
    private final String countername2;
    private final String condition;

    public TriggerCountersCompare(String countername1, String countername2, String condition) {
        this.countername1 = countername1;
        this.countername2 = countername2;
        this.condition = condition;
    }

  

    public String getCondition() {
        return condition;
    }
    
    @Override
    public boolean checkTrigger() {
        Integer counterValue1=CounterSet.getInstance().getCounter(countername1).getValue();
        Integer counterValue2=CounterSet.getInstance().getCounter(countername2).getValue();
        
        switch (condition) {
            case "GreaterThan":
                return counterValue1 > counterValue2;
            case "LessThan":
                return counterValue1 < counterValue2;
            case "EqualTo":
                return counterValue1 == counterValue2;
            default:
                return false;
        }
    }
    
    

    @Override
    public String description() {
        switch(condition){
            case "GreaterThan":
                return " ( "+ countername1+" value) \n GreaterThan \n( "+countername2+" value)";
            
            case "LessThan":
                return " ( "+ countername1+" value) \n LessThan \n( "+countername2+" value)";
            case "EqualTo":
                return " ( "+ countername1+" value) \n EqualTo \n( "+countername2+" value )";
        }
        return condition;
            
    }
    
}

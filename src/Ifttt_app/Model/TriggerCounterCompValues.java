
package Ifttt_app.Model;

/**
 * This class represents a trigger for comparing a counter value to a specified integer value.
 * It implements the Trigger interface and provides methods to check the trigger condition
 * and retrieve a description of the trigger.
 */
public class TriggerCounterCompValues implements Trigger{
    
    private final String condition;
    private final String countername;
    private Integer value;

    public TriggerCounterCompValues(String countername, Integer value, String condition) {
        this.countername=countername;
        this.value = value;
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public String getCountername() {
        return countername;
    }
   
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    
    

    @Override
    public boolean checkTrigger() {
       Integer counterValue=CounterSet.getInstance().getCounter(countername).getValue();
       switch (condition) {
            case "GreaterThan":
                return counterValue > value;
            case "LessThan":
                return counterValue < value;
            case "EqualTo":
                return counterValue == value;
            default:
                return false;
        }
    }

    @Override
    public String description() {
      switch(condition){
            case "GreaterThan":
                return " ( "+ countername+" value ) \n GreaterThan \n( "+value+" )";
            
            case "LessThan":
                return " ( "+ countername+" value ) \n LessThan \n( "+value+" )";
            case "EqualTo":
                return " ( "+ countername+" value ) \n EqualTo \n( "+value+" )";
        }
        return condition;
    }
    
}

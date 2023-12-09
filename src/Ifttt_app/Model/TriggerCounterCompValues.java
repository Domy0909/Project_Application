
package Ifttt_app.Model;

/**
 * The TriggerValue class represents a value-based trigger that activates based on comparisons between a given value and a threshold.
 * It allows the user to specify a condition for the trigger (GreaterThan, LessThan, EqualTo) and a threshold value.
 * The class provides methods to retrieve the condition and threshold, as well as check whether the trigger should be activated
 * for a given input value based on the specified condition and threshold.
 */
public class TriggerCounterCompValues {
    
    private final String condition;
    private final int threshold_value;
    
    public TriggerCounterCompValues(String condition, int threshold_value) {
        this.condition = condition;
        this.threshold_value = threshold_value;
    }
    
    public String getCondition() {
        return condition;
    }

    public double getThreshold() {
        return threshold_value;
    }

    public boolean isTriggerActivated(int value) {
        switch (condition) {
            case "GreaterThan":
                return value > threshold_value;
            case "LessThan":
                return value < threshold_value;
            case "EqualTo":
                return value == threshold_value;
            default:
                return false;
        }
    }
    
}

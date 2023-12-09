
package Ifttt_app.Model;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

public class SaveLoadCountersTest {
    
    // Verifies if rules are correctly saved to a file.
    @Test
    public void testSaveCounters() {
        CounterSet counterset= createSampleCounterSet();
        String filePath = "Counterset.bin";
        SaveLoadCounters.saveCounters(counterset);
        File file = new File(filePath);
        assertTrue(file.exists());
        assertTrue(file.length() > 0);
    }
    
    //Verifies the failure of rules saving by creating a file with a specific name.
    @Test
    public void testSaveCountersFailure() {
        CounterSet counterset= createSampleCounterSet();
        String filePath = "CountersetFailure.bin";
        
        File file = new File(filePath);
        assertFalse(file.exists());
        counterset.removeallCounter();
    }

    //Verifies the proper loading of rules from a file and their integrity.
    @Test
    public void testLoadCounters() {
        CounterSet counterset= createSampleCounterSet();
        String filePath = "Counterset.bin";
        File file = new File(filePath);
        assertTrue(file.exists());
        counterset.removeallCounter();
        SaveLoadCounters.loadCounters(counterset);
        assertEquals(1, counterset.getCounter_set().size());  
    }


        private CounterSet createSampleCounterSet() {
        CounterSet counterset = CounterSet.getInstance();
        counterset.addCounter(new Counter("Software",23));
       
        return counterset;
    }
    
}

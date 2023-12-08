/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.ShowDialogAction;
import Ifttt_app.Model.Composite.CompositeAction;
import Ifttt_app.Model.Composite.ActionPlayAudio;
import Ifttt_app.Model.Composite.Action;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class CompositeActionTest {
    //Verifies the behavior when the CompositeAction is empty
    @Test
    public void testEmptyCompositeActionExecution() {
        CompositeAction compositeAction = new CompositeAction();
        assertFalse(compositeAction.execute());
    }
    
    /* Tests the execution of a CompositeAction containing multiple actions, 
    such as ShowDialogAction and ActionPlayAudio.
    Attempts to run CompositeAction in a separate thread using Platform.startup(),
    synchronizing with CountDownLatch.
    Check that the "isOverallResult" of CompositeAction is "false", as the audio
    has an invalid path.
    Note: Using Platform.startup() may cause problems in JUnit tests to its 
    UI-related nature.*/
    @Test
    public void testExecuteCompositeFailure() throws InterruptedException {
        
        Action successfulAction1 = new ShowDialogAction("test");
        Action successfulAction2 = new ActionPlayAudio("hello.wav");

        CompositeAction compositeAction = new CompositeAction();
        compositeAction.addAction(successfulAction1);
        compositeAction.addAction(successfulAction2);

        CountDownLatch latch = new CountDownLatch(1);

        Platform.startup(()->{
            compositeAction.execute();
            latch.countDown();
        });
        latch.await();
        
        assertEquals(false, compositeAction.isOverallResult());
    }   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ifttt_app.Controller;

import Ifttt_app.Controller.ConfigureTextFieldController;
import Ifttt_app.Controller.ErrorDialogController;
import Ifttt_app.Model.Composite.RunExternalProgramAction;
import Ifttt_app.Model.Composite.ShowDialogAction;
import Ifttt_app.Model.Composite.SpecifiedStringAction;
import Ifttt_app.Model.Composite.MoveFileAction;
import Ifttt_app.Model.Composite.DeleteFileAction;
import Ifttt_app.Model.Composite.CopyFileAction;
import Ifttt_app.Model.Composite.CompositeAction;
import Ifttt_app.Model.Composite.ActionPlayAudio;
import Ifttt_app.Model.Composite.Action;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import Ifttt_app.Model.*;
import Ifttt_app.Model.Composite.AddValueCounterAction;
import Ifttt_app.Model.Composite.SetCounterValueAction;
import Ifttt_app.Model.Composite.ReplaceShowDialogAction;
import Ifttt_app.Model.Composite.ReplaceStringAppendAction;
import Ifttt_app.Model.Composite.SumsCounterAction;
import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.SubScene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author aless
 */
public class FXMLDocumentController implements Initializable {
    
    RuleSet rset=RuleSet.getInstance(); 
    CounterSet cset=CounterSet.getInstance();
    
    @FXML
    private AnchorPane ruleCreationPane;
    @FXML
    private ComboBox<String> comboTrigger;
    @FXML
    private ComboBox<String> comboAction;
    @FXML
    private Button addRuleButton;
    @FXML
    private AnchorPane ruleTablePane;
    @FXML
    private Button createRuleButton;
    @FXML
    private TableView<Rule> ruleTable;
    @FXML
    private TableColumn<Rule, String> triggercol;
    @FXML
    private TableColumn<Rule, String> actioncol;
    @FXML
    private Spinner<Integer> hspin;
    @FXML
    private Spinner<Integer> msp;
    @FXML
    private Spinner<Integer> ssp;
    @FXML
    private TextField messagefield;
    @FXML
    private Button saveRuleButton;
    @FXML
    private Button deleteRuleButton;
    @FXML
    private Button selectAudio;
    @FXML
    private ContextMenu tmenu;
    @FXML
    private MenuItem tdelete;
    @FXML
    private RadioButton firedradiobutton;
    @FXML
    private RadioButton sleepingradiobutton;
  
    @FXML
    private TextField sleepingdays;
    @FXML
    private TextField sleepinghours;
    @FXML
    private TextField sleepingminutes;
    @FXML
    private Label Lhours;
    @FXML
    private Label Lmin;
    @FXML
    private Label Lsec;
    @FXML
    private Label Lday;
    @FXML
    private Label Lmonth;
    @FXML
    private Label LdayDate;
    @FXML
    private Label LmonthDate;
    @FXML
    private Label LyearDate;
    
    private String FilePath;
    private String textFilePath;
    private String ProgramPath;
    private String directoryPath;
    private String sizeFilePath;
    private String copyFilePath;
    private String directoryPathFile;
    private ObservableList<String> triggerCommandList = FXCollections.observableArrayList();
    private ObservableList<String> actionCommandList  = FXCollections.observableArrayList();
    private ObservableList<Trigger> triggertbList= FXCollections.observableArrayList();
    private ObservableList<Action> actiontbList= FXCollections.observableArrayList();
    private ObservableList<Action> actionseq= FXCollections.observableArrayList();
    private Trigger a;
    private Trigger b;
    private Counter counter1;
    private Counter counter2;
            
            
    @FXML
    private Text ruleWarning;
    @FXML
    private TableColumn<Rule, Boolean> activecol;
    @FXML
    private MenuItem tactiveDeactive;
    @FXML
    private Button selectTextFileButton;
    @FXML
    private Button selectDirectoryButton;
    @FXML
    private TextField fileTextField;
    @FXML
    private Button fileSizeSelectorButton;
    @FXML
    private TextField fileSizeTextField;
    @FXML
    private TableColumn<Rule, String> repcolumn;
    @FXML
    private ComboBox<String> daySelector;
    @FXML
    private Spinner<Integer> daySpinner;
    @FXML
    private Spinner<Integer> daySpn;
    @FXML
    private Spinner<Integer> monthSpn;
    @FXML
    private Spinner<Integer> yearSpn;
    @FXML
    private TextField externalTxt;
    @FXML
    private Button selectProgram1;
    @FXML
    private Button selectFileButton;
    @FXML
    private Button ButtonDirectory;
    @FXML
    private ListView<String> commandlinelistTrigger;
    @FXML
    private Button addcommandLineTriggerButton;
    @FXML
    private TextField commandLineTextfieldTrigger;
    @FXML
    private ListView<String> commandlinelistAction;
    @FXML
    private Button addcommandLineButtonAction;
    @FXML
    private TextField commandLineTextfieldAction;
    @FXML
    private Button selectProgramAction;
    @FXML
    private TabPane tabpaneRuleCreation;
    @FXML
    private Tab tabTrigger;
    @FXML
    private AnchorPane triggerpane;
    @FXML
    private AnchorPane actionpane;
    @FXML
    private AnchorPane rulepane;
    @FXML
    private TableView<Trigger> triggertable;
    @FXML
    private Button createTrigger;
    @FXML
    private TextArea fristTriggerFieldTA;
    @FXML
    private TableColumn<Trigger, String> triggerList;
    @FXML
    private TextArea secondTriggerFieldTA;
    @FXML
    private ComboBox<String> logicalbox;
    @FXML
    private MenuItem selectTrigger;
    @FXML
    private MenuItem triggerfield1;
    @FXML
    private MenuItem triggerfield2;
    @FXML
    private MenuItem delete;
    @FXML
    private TableView<Action> actionTable;
    @FXML
    private TableColumn<Action, String> actionList;
    @FXML
    private Button createActionButton;
    
    private Trigger triggerselected;
    private Action actionselected;
    private CompositeAction compaction=new CompositeAction();
    @FXML
    private MenuItem SelectAction;
    @FXML
    private TextArea triggerTA;
    @FXML
    private TextArea actionTA;
    @FXML
    private CheckBox notcheck;
    @FXML
    private MenuItem addseqmenu;
    @FXML
    private TableView<Action> actionseqTA;
    @FXML
    private ContextMenu deleteActionmenu;
    @FXML
    private MenuItem deleteSqaction;
    @FXML
    private TableColumn<Action, String> actionseqcol;
    @FXML
    private TabPane ruleTabPane;
    @FXML
    private AnchorPane ruleView;
    @FXML
    private AnchorPane counterView;
    @FXML
    private TableView<Counter> counterTable;
    @FXML
    private TableColumn<Counter, String> counterNameCol;
    @FXML
    private TableColumn<Counter,String> counterValueCol;
    @FXML
    private Button create_counter_button;
    @FXML
    private TextField namecounter_TF;
    @FXML
    private TextField valuecounter_TF;
    @FXML
    private MenuItem modify_menucounter;
    @FXML
    private ComboBox<String> combo_counterT1;
    @FXML
    private ComboBox<String> combo_counterT2;
    @FXML
    private ComboBox<String> combo_counterA1;
    @FXML
    private ComboBox<String> combo_counterA2;
    @FXML
    private MenuItem delete_menucounter;
    @FXML
    private Button go_back_button;
    @FXML
    private Button saveCounters;
    @FXML
    private TextField valueTF;
    @FXML
    private CheckBox counter_cb;
    @FXML
    private ComboBox<String> operationBox;
    @FXML
    private TextField valueTrigger;
    @FXML
    private SubScene faqtrigger;
    @FXML
    private SubScene faqaction;
    @FXML
    private Button faqtbutton;
    @FXML
    private Button faqtbutton1;
    @FXML
    private Button buttonRefresh;
    @FXML
    private Button buttonRefresh1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SaveRules.loadRules(rset); //load the saved rules
        SaveLoadCounters.loadCounters(cset); //load the saved counters
        
        //Add the names of the loaded counters to the following comboboxes located in the trigger creation pane and action creation pane
        for(Counter c : cset.getCounter_set()){
              combo_counterT1.getItems().addAll(c.getName()); 
              combo_counterT2.getItems().addAll(c.getName()); 
              combo_counterA1.getItems().addAll(c.getName()); 
              combo_counterA2.getItems().addAll(c.getName()); 
        }
        
       
        // Set the items in the counterTable by retrieving the counter set from the CounterSet singleton instance
        counterTable.setItems(cset.getCounter_set());
        // Configure the counterNameCol to display the name of each counter in the table
        counterNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        // Configure the counterValueCol to display the value of each counter in the table
        counterValueCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue().toString()));
        
       
       //Set the items of the triggertable the created triggers
        triggertable.setItems(triggertbList);
        //display the description of each trigger
        triggerList.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().description()));
        
        //Set the table for the created actions
        actionTable.setItems(actiontbList);
        //Set the table for the actions that will form a sequence
        actionseqTA.setItems(actionseq);
        
        
        triggerList.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().description()));
        actionList.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().description()));
        actionseqcol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().description()));
        
        
       
        // Instantiate a ConfigureTextFieldController for configuring text fields.
        ConfigureTextFieldController tfedit=new ConfigureTextFieldController();
        
        // Configure text fields to only accept negative numeric input.
        tfedit.configureNegativeNumericTextField(valuecounter_TF);
        tfedit.configureNegativeNumericTextField(valueTF);
        tfedit.configureNegativeNumericTextField(valueTrigger);
        
        // Configure text fields to only accept positive numeric input.
        tfedit.configurePositiveNumericTextField(sleepingdays);
        tfedit.configurePositiveNumericTextField(sleepinghours);
        tfedit.configurePositiveNumericTextField(sleepingminutes);

        tfedit.configurePositiveNumericTextField(hspin.getEditor());
        tfedit.configurePositiveNumericTextField(msp.getEditor());
        tfedit.configurePositiveNumericTextField(ssp.getEditor());
        
        tfedit.configurePositiveNumericTextField(fileSizeTextField);
        
        tfedit.configurePositiveNumericTextField(daySpinner.getEditor());
        tfedit.configurePositiveNumericTextField(daySpn.getEditor());
        tfedit.configurePositiveNumericTextField(monthSpn.getEditor());
        tfedit.configurePositiveNumericTextField(yearSpn.getEditor());
        
       
        
        ruleTable.setItems(rset.getRules()); 
        actioncol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAction().description()) );
        triggercol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrigger().description()));
        
        //this column display the repetition of a rule
        repcolumn.setCellValueFactory(cellData -> {
        Rule rowData = cellData.getValue();
        
        
       //the data
       if (!rowData.isSleeping()) {
        // If isSleeping() returns false, set the value as isfoo
        return new SimpleStringProperty("Can only be triggered once"+"\nhas been fired: "+Boolean.toString(rowData.isFired_oo()));
       } else {
        // If isSleeping() returns true, set the value as getday + gethour + +getminutes
        return new SimpleStringProperty("when triggered sleeps for :\n"+rowData.getDay()+" days\n"+rowData.getHours()+" hours \n"+rowData.getMinutes()+" minutes");
       }
      });
        
        // Configure visibility and settings for the "activecol" TableColumn.        
        activecol.setCellValueFactory(new PropertyValueFactory<>("active"));
        
        // Configure visibility and settings for the time-related Spinners and Labels.
        Lhours.setVisible(false);
        hspin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,23,1));
        Lmin.setVisible(false);
        msp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,59,1));
        Lsec.setVisible(false);
        ssp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,59,1));
        
        // Set initial values for the Spinners based on the current local time.
        hspin.getValueFactory().setValue(LocalTime.now().getHour());
        msp.getValueFactory().setValue(LocalTime.now().getMinute());
        ssp.getValueFactory().setValue(LocalTime.now().getSecond());
        
        // Disable Spinners based on the selected trigger not being "CurrentTime."
        hspin.disableProperty().bind(Bindings.notEqual(comboTrigger.valueProperty(), "CurrentTime"));
        msp.disableProperty().bind(Bindings.notEqual(comboTrigger.valueProperty(), "CurrentTime"));
        ssp.disableProperty().bind(Bindings.notEqual(comboTrigger.valueProperty(), "CurrentTime"));
        
        // Set Spinners and Labels visibility based on the selected trigger being "CurrentTime."
        hspin.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        msp.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        ssp.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        
        // Configure visibility and initial settings for "daySelector" based on the selected trigger being "Day Of Week."
        daySelector.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Day Of Week"));
        Lday.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Day Of Week"));
        daySelector.setValue(LocalDate.now().getDayOfWeek().toString());
        
        // Configure visibility and initial settings for "daySpinner" based on the selected trigger being "Day Of Month."
        daySpinner.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Day Of Month"));
        Lmonth.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Day Of Month"));
        daySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
        1,
        YearMonth.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue()).lengthOfMonth(),
        LocalDate.now().getDayOfMonth()));
        
        
        // Configure visibility and settings for date-related components based on the selected trigger being "Date."
        LdayDate.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Date"));
        LmonthDate.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Date"));
        LyearDate.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Date"));
        daySpn.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Date"));
        monthSpn.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Date"));
        yearSpn.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Date"));
        daySpn.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
        1,
        YearMonth.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue()).lengthOfMonth(),
        LocalDate.now().getDayOfMonth()));
        monthSpn.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
        1,12,LocalDate.now().getMonthValue()));
        yearSpn.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
        LocalDate.now().getYear(), LocalDate.now().plusYears(50).getYear() ,LocalDate.now().getYear()));
        
        // Configure visibility for components related to file existence and size based on the selected trigger.
        selectDirectoryButton.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "FileExistence"));
        fileTextField.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "FileExistence"));
                
        
        fileSizeSelectorButton.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "FileSize"));
        fileSizeTextField.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "FileSize"));
                
        // Configure visibility for components related to audio playback and text file manipulation based on the selected action.
        selectAudio.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "PlayAudio"));
        selectTextFileButton.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "AppendStringAtFile"));
        messagefield.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "ShowDialog").or(Bindings.equal(comboAction.valueProperty(), "AppendStringAtFile")));
        
        // Configure visibility for time-related labels based on the selected trigger being "CurrentTime."
        Lhours.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        Lmin.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        Lsec.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        
        // Configure items for ListView based on the selected trigger or action being "RunExternalProgramTrigger" or "RunExternalProgramAction."
        commandlinelistAction.setItems(actionCommandList);
        commandlinelistTrigger.setItems(triggerCommandList);
        commandlinelistTrigger.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
        commandlinelistAction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "RunExternalProgramAction"));
        addcommandLineButtonAction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "RunExternalProgramAction"));
        addcommandLineTriggerButton.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
        commandLineTextfieldAction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "RunExternalProgramAction"));
        commandLineTextfieldTrigger.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
        
        // Configure visibility for components related to external program execution based on the selected action and trigger.
        selectProgramAction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "RunExternalProgramAction"));
        selectProgram1.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
        externalTxt.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
        // Configure visibility for components related to composite triggers.
        fristTriggerFieldTA.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        secondTriggerFieldTA.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        logicalbox.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        triggerfield1.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        triggerfield2.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        
        // Control the visibility of "operationBox" based on the selected value in "comboTrigger".
// The box is visible if the selected trigger is "Compare Counter to Counter" or "Compare Counter to Value".
        operationBox.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboTriggerValue = comboTrigger.valueProperty().getValue();
            return ("Compare Counter to Counter".equals(comboTriggerValue) || "Compare Counter to Value".equals(comboTriggerValue) );
        },
        comboTrigger.valueProperty()  
        )
        );
        
        // Control the visibility of "counter_cb" based on the selected value in "comboAction".
// The checkbox is visible if the selected action is "ShowDialog" or "AppendStringAtFile".
        counter_cb.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboActionValue = comboAction.valueProperty().getValue();
            return ("ShowDialog".equals( comboActionValue) || "AppendStringAtFile".equals( comboActionValue));
        },
        comboAction.valueProperty()  
        )
        );
        
        // Control the visibility of "combo_counterT1" based on the selected value in "comboTrigger".
// The combo box is visible if the selected trigger is "Compare Counter to Value" or "Compare Counter to Counter".
        combo_counterT1.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboTriggerValue = comboTrigger.valueProperty().getValue();
            return ("Compare Counter to Value".equals( comboTriggerValue) || "Compare Counter to Counter".equals( comboTriggerValue));
        },
        comboTrigger.valueProperty()  
        )
        );
        
        
        // Control the visibility of "combo_counterT2" based on the selected value in "comboTrigger".
// The combo box is visible if the selected trigger is "Compare Counter to Counter".
        combo_counterT2.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboTriggerValue = comboTrigger.valueProperty().getValue();
            return ("Compare Counter to Counter".equals( comboTriggerValue));
        },
        comboTrigger.valueProperty()  
        )
        );
        
        
       // These items are visible if the selected action is "Action Sequence". 
        addseqmenu.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Action Sequence"));
        deleteSqaction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Action Sequence"));  
        actionseqTA.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Action Sequence"));  
        
        
 // This binding controls the visibility of "combo_counterA1" based on the selected value in "comboAction".
// The visibility is determined by the conditions specified in the lambda expression:
// The combo box is visible if the selected action is one of the following:
// - SetCounterValue
// - Add Value to Counter
// - Sum two Counters
// - ShowDialog
// - AppendStringAtFile
        combo_counterA1.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboActionValue = comboAction.valueProperty().getValue();
            return ("SetCounterValue".equals(comboActionValue) || "Add Value to Counter".equals(comboActionValue) || "Sum two Counters".equals(comboActionValue) ||
                    "ShowDialog".equals( comboActionValue) || "AppendStringAtFile".equals( comboActionValue));
        },
        comboAction.valueProperty()  
        )
        );
        
        
 // This binding controls the visibility of "combo_counterA2" based on the selected value in "comboAction".
// The combo box is visible if the selected action is "Sum two Counters".
        combo_counterA2.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboActionValue = comboAction.valueProperty().getValue();
            return ("Sum two Counters".equals(comboActionValue));
        },
        comboAction.valueProperty()  
        )
        ); 
        

// This binding controls the visibility of "valueTF" based on the selected value in "comboAction".
// The visibility is determined by the conditions specified in the lambda expression:
// The text field is visible if the selected action is one of the following:
// - SetCounterValue
// - Add Value to Counter        
        valueTF.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboActionValue = comboAction.valueProperty().getValue();
            return ("SetCounterValue".equals(comboActionValue) || "Add Value to Counter".equals(comboActionValue) );
        },
        comboAction.valueProperty()  
        )
        );
       
  // This binding controls the visibility of "valueTrigger" based on the selected value in "comboTrigger".
// The text field is visible if the selected trigger is "Compare Counter to Value".
      
       valueTrigger.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Compare Counter to Value"));
       
        // Create a ToggleGroup for radio buttons to ensure that only one can be selected at a time.
        ToggleGroup toggleGroup = new ToggleGroup();
        firedradiobutton.setToggleGroup(toggleGroup);
        sleepingradiobutton.setToggleGroup(toggleGroup);
        firedradiobutton.setSelected(true);
        
        // Disable the "sleepingdays," "sleepinghours," and "sleepingminutes" TextFields when "firedradiobutton" is selected.
        sleepingdays.disableProperty().bind(firedradiobutton.selectedProperty());
        sleepinghours.disableProperty().bind(firedradiobutton.selectedProperty());
        sleepingminutes.disableProperty().bind(firedradiobutton.selectedProperty());
        
        // Control the visibility of "sleepingdays," "sleepinghours," and "sleepingminutes" based on the selected radio button.
// These components are visible only when "sleepingradiobutton" is selected.
        sleepingdays.visibleProperty().bind(sleepingradiobutton.selectedProperty());
        sleepinghours.visibleProperty().bind(sleepingradiobutton.selectedProperty());
        sleepingminutes.visibleProperty().bind(sleepingradiobutton.selectedProperty());
        
 // Control the visibility of "selectFileButton" based on the selected value in "comboAction".
// The button is visible if the selected action is "Copy File," "Move File," or "Delete File."
        selectFileButton.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Copy File").
                or(Bindings.equal(comboAction.valueProperty(), "Move File")).
                or(Bindings.equal(comboAction.valueProperty(), "Delete File")));
        
   // Control the visibility of "ButtonDirectory" based on the selected value in "comboAction."
// The button is visible if the selected action is "Copy File" or "Move File."         
        ButtonDirectory.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Copy File").
                or(Bindings.equal(comboAction.valueProperty(), "Move File")));
       
        comboTrigger.getItems().addAll(
        "CurrentTime",
        "Day Of Week",
        "Day Of Month",
        "Date",
        "FileExistence",
        "FileSize",
        "RunExternalProgramTrigger",
        "CompositeTrigger",
        "Compare Counter to Value",
        "Compare Counter to Counter"
);

comboAction.getItems().addAll(
        "ShowDialog",
        "PlayAudio",
        "AppendStringAtFile",
        "RunExternalProgramAction",
        "Copy File",
        "Move File",
        "Delete File",
        "Action Sequence",
        "SetCounterValue",
        "Add Value to Counter",
        "Sum two Counters"
);

daySelector.getItems().addAll(
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
);
        
        logicalbox.getItems().addAll("AND","OR");
        
        operationBox.getItems().addAll("EqualsTo","GreaterThan","LessThan");
       
        
        
    
 // This binding is used to disable the "addRuleButton" based on certain conditions.
// It is bound to the combined Boolean result of various properties, including
// the text properties of trigger and action TextAreas, and the selected properties
// of the "sleepingradiobutton" along with the text properties of associated TextFields.
// The button will be disabled if any of the specified conditions are met:
// 1. Trigger TextArea is empty
// 2. Action TextArea is empty
// 3. If "sleepingradiobutton" is selected, then any of the following:
//    a. Sleeping Days TextField is empty
//    b. Sleeping Hours TextField is empty
//    c. Sleeping Minutes TextField is empty    
    addRuleButton.disableProperty().bind(
    Bindings.createBooleanBinding(() ->
        triggerTA.getText().isEmpty() ||
        actionTA.getText().isEmpty() ||
        (sleepingradiobutton.isSelected() &&
            (sleepingdays.getText().isEmpty() ||
             sleepinghours.getText().isEmpty() ||
             sleepingminutes.getText().isEmpty())),
        triggerTA.textProperty(),
        actionTA.textProperty(),
        sleepingradiobutton.selectedProperty(),
        sleepingdays.textProperty(),
        sleepinghours.textProperty(),
        sleepingminutes.textProperty()
     )
    );
        
     
 // This binding is used to disable the "create_counter_button" based on certain conditions.
// It is bound to the combined Boolean result of the text properties of the name and value
// counter TextFields. The button will be disabled if either the name or value counter
// TextField is empty.
    create_counter_button.disableProperty().bind(
               Bindings.createBooleanBinding(()-> namecounter_TF.getText().isEmpty() || valuecounter_TF.getText().isEmpty()
                       , namecounter_TF.textProperty(),
                       valuecounter_TF.textProperty()
               )
       );
               
       
    
        // TODO
        
    }
    
 /**
 * Handles the addition of a new rule by retrieving selected trigger and action, creating a rule instance,
 * configuring rule properties based on UI inputs, adding the rule to a rule set, and updating the UI elements accordingly.
 */ 
    @FXML
    private void addRuleButton(ActionEvent event) {
        
        ruleWarning.setText("");
        Trigger trigger=triggerselected;
        Action action=actionselected;
        Rule r=null;
        
        if ((action!=null) && (trigger!=null) ){
            r=new Rule(action,trigger);
        }
        
        if(r!=null & firedradiobutton.isSelected())
            r.setFiredOnlyOnce(true);
        if(r!=null && sleepingradiobutton.isSelected()){
            r.setSleeping(true);
            r.setDay(Integer.parseInt(sleepingdays.getText()));
            r.setHours(Integer.parseInt(sleepinghours.getText()));
            r.setMinutes(Integer.parseInt(sleepingminutes.getText()));
            
        }
        
        if((r!=null)){
         rset.addRule(r);
         FilePath=null;
         triggerCommandList.clear();
         actionCommandList.clear();
         ruleCreationPane.setDisable(true);
         ruleCreationPane.setVisible(false);
         ruleTablePane.setDisable(false);
         ruleTablePane.setVisible(true);
         actionselected=null;
         triggerselected=null;
         triggerTA.setText("");
         actionTA.setText("");
         counterTable.refresh();
        }
        
        
        
        
    }

    
 /*This method manages various tasks related to the user interface, facilitating the 
transition from the rule display interface to the rule creation interface, reset certain 
variables, and update the counter table display as part of the rule creation process.*/
    @FXML
    private void CreateRuleButtonEvent(ActionEvent event) {
        ruleTablePane.setDisable(true);
        ruleTablePane.setVisible(false);
        ruleCreationPane.setDisable(false);
        ruleCreationPane.setVisible(true);
        FilePath=null;
        ruleWarning.setText("");
        counterTable.refresh();
    }
     // Save the rules
    @FXML
    private void Save(ActionEvent event) {
        SaveRules.saveRules(rset);
    }
     //Save the counter  
    @FXML
    void SaveCounters(ActionEvent event) {
         SaveLoadCounters.saveCounters(cset);
    }
    
/* 
Deletes the selected rule from the rule table.
Retrieves the selected rule, removes it from the rule set, and updates the rule table.
*/
    
    @FXML
    private void Delete(ActionEvent event) {
         // Ottieni la regola selezionata dalla tabella
        Rule selectedRule = ruleTable.getSelectionModel().getSelectedItem();

        if (selectedRule != null) {
          // Rimuovi la regola dalla ruleSet
           rset.removeRule(selectedRule);
          // Aggiorna la tabella
          ruleTable.refresh();
        }   
    }
    
    /**
 * Opens a file chooser dialog to select a WAV file.
 * Sets initial directory and filters for WAV files, storing the selected file path.
 */ 
    
    @FXML
    void selectAudio(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

    
        fileChooser.setTitle("Select a File");


        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        fileChooser.setInitialDirectory(initialDirectory);

    
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("WAV files (.wav)", "*.wav");
        fileChooser.getExtensionFilters().add(extFilter);

     
        File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                FilePath = selectedFile.getAbsolutePath();
            }
    }

    
   /**
 * Toggles the active status of the selected rule in the rule table.
 * Updates the active status of the selected rule and refreshes the rule table display.
 */
    @FXML
    private void activeDeactive(ActionEvent event) {
     
        Rule selectedRule = ruleTable.getSelectionModel().getSelectedItem();
        selectedRule.setActive(!selectedRule.isActive());
        ruleTable.refresh();
    }
    
    
    // Method for selecting a text file using FileChooser
    // Sets initial directory and extension filter for .txt files
    // Updates the textFilePath variable with the selected file path

    @FXML
    private void selectTextFile(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();


        fileChooser.setTitle("Select a File");

 
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        fileChooser.setInitialDirectory(initialDirectory);

   
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);


        File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                textFilePath = selectedFile.getAbsolutePath();
            }
    }

    
 // Method for selecting a directory using DirectoryChooser
// Sets initial directory and updates the directoryPath variable with the selected directory path
    @FXML
    private void selectDirectoryButton(ActionEvent event) throws IOException {
         
    
        DirectoryChooser directoryChooser = new DirectoryChooser();

      
        directoryChooser.setTitle("Select a Directory");

   
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        directoryChooser.setInitialDirectory( initialDirectory);

        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            System.out.println("Selected Directory: " + selectedDirectory.getAbsolutePath());
            directoryPath=selectedDirectory.getAbsolutePath();
        } else {
            System.out.println("No directory selected.");
        }
    }

    
 // Method for selecting a file for size-related operations using FileChooser
// Updates the sizeFilePath variable with the selected file path
    @FXML
    private void fileSizeSelector(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

       
        fileChooser.setTitle("Select a File");


        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        fileChooser.setInitialDirectory(initialDirectory);

      
        File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
               sizeFilePath = selectedFile.getAbsolutePath();
            }
    }
    
 // Method for selecting an external program file using FileChooser
// Invokes a method in the SelectProgramController and updates the ProgramPath variable
    @FXML
    void selectProgram(ActionEvent event) throws IOException {
        
        SelectProgramController selector=new SelectProgramController();
        selector.selectProgram();
        ProgramPath=selector.getProgramPath();
        
    }

 // Method for selecting a file using FileChooser
// Updates the copyFilePath variable with the selected file path
    @FXML
    private void selectFileButton(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        
        fileChooser.setTitle(FilePath);
        
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        
        fileChooser.setInitialDirectory(initialDirectory);
        
        File selectedFile = fileChooser.showOpenDialog(null);
        if(selectedFile != null)
           copyFilePath = selectedFile.getAbsolutePath();
    }

  // Method for selecting a directory using DirectoryChooser
 // Updates the directoryPathFile variable with the selected directory path
    @FXML
    private void buttonSelectDirectory(ActionEvent event) throws IOException {

        DirectoryChooser directoryChooser = new DirectoryChooser();

      
        directoryChooser.setTitle("Select a Directory");

      
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        directoryChooser.setInitialDirectory( initialDirectory);

       
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            System.out.println("Selected Directory: " + selectedDirectory.getAbsolutePath());
            directoryPathFile=selectedDirectory.getAbsolutePath();
        } else {
            System.out.println("No directory selected.");
        }
    }

    
    // Method for adding a command line to a list
    @FXML
    private void addCommandLine(ActionEvent event) {
        triggerCommandList.add(commandLineTextfieldTrigger.getText());
        commandLineTextfieldTrigger.setText("");
    }

    // Method for adding a command line action to a list
    @FXML
    private void addCommandLineAction(ActionEvent event) {
        actionCommandList.add(commandLineTextfieldAction.getText());
        commandLineTextfieldAction.setText("");
    }

    // Method for selecting an external program file for an action using FileChooser
// Updates the ProgramPath variable with the selected file path
    @FXML
    private void selectProgramAction(ActionEvent event) throws IOException {
          FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Select a File");

        File currentDirectory = new File(new File("./External Programs").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        fileChooser.setInitialDirectory(initialDirectory);
        fileChooser.setTitle("Open Executable File");
        // Define a list of executable file extensions
        List<String> executableExtensions = Arrays.asList(
                "*.exe", "*.com", "*.bat", "*.cmd", "*.msi",
                "*.vbs", "*.js", "*.jar", "*.ps1", "*.psm1",
                "*.py", "*.pyc", "*.ps1xml", "*.wsf"
        );

        // Create an ExtensionFilter that includes all executable extensions
        FileChooser.ExtensionFilter executableFilter = new FileChooser.ExtensionFilter(
                "Executable Files", executableExtensions
        );
        fileChooser.getExtensionFilters().add(executableFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                ProgramPath = selectedFile.getAbsolutePath();
            }
    }

    
    // Method for creating a trigger based on user inputs
   // Creates instances of various trigger classes based on user selection
    @FXML
    private void CreateTrigger(ActionEvent event) {
        
        String triggerValue = comboTrigger.getValue();
        Trigger trigger=null;
        ErrorDialogController error = new ErrorDialogController();

if (triggerValue != null) {
    switch (triggerValue) {
        case "CurrentTime":
            trigger = new TimeTrigger(LocalTime.of(hspin.getValue(), msp.getValue(), ssp.getValue()));
            break;

        case "FileExistence":
            if (directoryPath != null && !fileTextField.getText().isEmpty()) {
                trigger = new ExistenceTrigger(directoryPath, fileTextField.getText());
            } else {
                if (directoryPath == null) {
                    error.showErrorDialog( "No valid trigger directory selected.");
                    
                }
                if (fileTextField.getText().isEmpty()) {
                    error.showErrorDialog( "Empty name for file trigger existence.");
                }
            }
            break;

        case "Day Of Week":
            trigger = new TriggerDay(DayOfWeek.valueOf(daySelector.getValue().toUpperCase()));
            break;

        case "Day Of Month":
            trigger = new TriggerDayMonth(daySpinner.getValue());
            break;

        case "Date":
            trigger = new TriggerDate(LocalDate.of(yearSpn.getValue(), monthSpn.getValue(), daySpn.getValue()));
            break;

        case "FileSize":
            if (sizeFilePath != null) {
                if (fileSizeTextField.getText().isEmpty()) 
                     error.showErrorDialog( "0 bytes to size trigger");
                else{
                     trigger = new SizeFileTrigger(sizeFilePath, Integer.parseInt(fileSizeTextField.getText()));
                }
                   
            } else {
                  error.showErrorDialog( "No valid file selected");
                
            }
            break;

        case "RunExternalProgramTrigger":
            ArrayList<String> arguments = new ArrayList<>(triggerCommandList);
            if(ProgramPath!=null && !externalTxt.getText().isEmpty())
             trigger = new TriggerExternalProgram(ProgramPath, arguments, Integer.parseInt(externalTxt.getText()));
            else
                 error.showErrorDialog( "Select a program and an exitcode");
            break;
      
        case "CompositeTrigger":
          
            
            if ((a != null)&&(b != null) && !(logicalbox.getValue()==null)) {
                if(logicalbox.getValue().equals("AND"))
                    trigger = new CompositeTrigger(a,b,true);
                else
                    trigger = new CompositeTrigger(a,b,false);
             }
            else if((a == null)&&(b == null))
              error.showErrorDialog( "Select two triggers");
            else  if(logicalbox.getValue()==null)  
               error.showErrorDialog( "Select a logical operation");
            break;    
        case "Compare Counter to Counter":
            CounterSet counterset= CounterSet.getInstance();
   
            counter1=counterset.getCounter(combo_counterT1.getValue());
            counter2=counterset.getCounter(combo_counterT2.getValue());
            if(!(counter1==null)&& (!(counter2==null)) && !(operationBox.getValue()==null)){
                if(operationBox.getValue().equals("EqualsTo")){
                    trigger = new TriggerCountersCompare(counter1.getName(),counter2.getName(),"EqualTo");
                }if(operationBox.getValue().equals("GreaterThan")){
                  trigger = new TriggerCountersCompare(counter1.getName(),counter2.getName(),"GreaterThan");
             }if(operationBox.getValue().equals("LessThan")){
                    trigger = new TriggerCountersCompare(counter1.getName(),counter2.getName(),"LessThan");
                }
            }
            else
                 error.showErrorDialog( "Select two Counter and a logical operation");
            break;
        case "Compare Counter to Value":
            CounterSet counterset1= CounterSet.getInstance();
            counter1=counterset1.getCounter(combo_counterT1.getValue());
            //System.out.println(counter1.getName()+operationBox.getValue()+valueTrigger.getText());
            
            //valueTrigger.setText("");
            if (counter1 != null && operationBox.getValue()!=null && !valueTrigger.getText().isEmpty()) {
                Integer value1 =Integer.valueOf(valueTrigger.getText());
                 if(operationBox.getValue().equals("EqualsTo")){
                    trigger = new TriggerCounterCompValues(counter1.getName(),value1,"EqualTo");
                    valueTrigger.setText("");
                }if(operationBox.getValue().equals("GreaterThan")){
                  trigger = new TriggerCounterCompValues(counter1.getName(),value1,"GreaterThan");
                  valueTrigger.setText("");
             }if(operationBox.getValue().equals("LessThan")){
                    trigger = new TriggerCounterCompValues(counter1.getName(),value1,"LessThan");
                    valueTrigger.setText("");
                }
            } else {
                error.showErrorDialog( "Select a Counter, a logical operation and a value");
            }
            break;
    }
    if(trigger!=null){
     if(notcheck.isSelected()){
           trigger= new NotTrigger(trigger);
    
     }
      triggertbList.add(trigger);  
    }
     
}
    }
    
// Method for selecting a trigger from a table and displaying its description, this trigger will then be used for the creation of a rule
    @FXML
    private void SelectTrigger(ActionEvent event) {
        triggerselected=triggertable.getSelectionModel().getSelectedItem();
        triggerTA.setText(triggerselected.description());
    }
// Method for selecting the first trigger field in a composite trigger
    @FXML
    private void TriggerField1(ActionEvent event) {
        a=triggertable.getSelectionModel().getSelectedItem();
        fristTriggerFieldTA.setText(a.description());
        
    }
    
// Method for selecting the second trigger field in a composite trigger
    @FXML
    private void triggerField2(ActionEvent event) {
        b=triggertable.getSelectionModel().getSelectedItem();
        secondTriggerFieldTA.setText(b.description());
    }
    
// Method for deleting a selected trigger from the trigger table
    @FXML
    private void DeleteTrigger(ActionEvent event) {
           Trigger selectedTrigger= triggertable.getSelectionModel().getSelectedItem();

        if (selectedTrigger != null) {
         
           triggertbList.remove(selectedTrigger);
    
          triggertable.refresh();
        }  
    }
// Method for creating an action based on user inputs
// Creates instances of various action classes based on user selection
    @FXML
private void CreateAction(ActionEvent event) {
  if (comboAction.getValue() != null) {
    String actionType = comboAction.getValue();
    Action action=null;
    ErrorDialogController error = new ErrorDialogController();
    switch (actionType) {
        case "ShowDialog":

            if(counter_cb.isSelected() && !(combo_counterA1.getValue()==null)){
                action= new ReplaceShowDialogAction
                (new ShowDialogAction(messagefield.getText()),combo_counterA1.getValue());
            }
            if(counter_cb.isSelected() && (combo_counterA1.getValue()==null))
                 error.showErrorDialog("Select a counter to replace $ with its value.\n");
            else if(!counter_cb.isSelected())
                action = new ShowDialogAction(messagefield.getText());
            break;
        case "PlayAudio":
            if (FilePath != null) {
                action = new ActionPlayAudio(FilePath);
            } else {
                error.showErrorDialog("No valid audio file selected.\n");
                
            }
            break;
        case "AppendStringAtFile":
            if (textFilePath != null) {
                action = new SpecifiedStringAction(textFilePath, messagefield.getText());
               if(counter_cb.isSelected() && !(combo_counterA1.getValue()==null)){
                action= new ReplaceStringAppendAction
                (new SpecifiedStringAction(textFilePath, messagefield.getText()),combo_counterA1.getValue());
               }
            else if(counter_cb.isSelected() && (combo_counterA1.getValue()==null))
                error.showErrorDialog("Select a counter to replace $ with its value.\n");
            } else {
                error.showErrorDialog("No valid text file selected.\n");
 
            }
            break;
        case "RunExternalProgramAction":
            if (ProgramPath != null) {
                ArrayList<String> arguments = new ArrayList<>(actionCommandList);
                action = new RunExternalProgramAction(ProgramPath, arguments);
            } else {
                error.showErrorDialog("No valid program file selected.\n");
            }
            break;
        case "Copy File":
        case "Move File":
        case "Delete File":
            if (copyFilePath != null && directoryPathFile != null) {
                switch (actionType) {
                    case "Copy File":
                        action = new CopyFileAction(copyFilePath, directoryPathFile);
                        break;
                    case "Move File":
                        action = new MoveFileAction(copyFilePath, directoryPathFile);
                        break;
                    case "Delete File":
                        action = new DeleteFileAction(copyFilePath);
                        break;
                }
            } else {
                error.showErrorDialog("No valid file paths selected.\n");
                
            }
            break;
            case "Action Sequence":
           if (actionseq.size()>0) {
                ArrayList<Action> arguments = new ArrayList<>(actionseq);
                action = new CompositeAction(arguments);
            } else {
                 error.showErrorDialog("No actions in the sequence.\n");
            }

            break;
            
           case "SetCounterValue":
           if (combo_counterA1!=null && !valueTF.getText().isEmpty()) {
                Integer value=Integer.parseInt(valueTF.getText());
                action = new SetCounterValueAction( combo_counterA1.getValue(),value);
                valueTF.setText("");
            } else {
               error.showErrorDialog("Select a counter and set a value.\n");
            }
             break;
             
             
           case "Add Value to Counter":
           if (combo_counterA1!=null && !valueTF.getText().isEmpty()) {
                Integer value=Integer.parseInt(valueTF.getText());
                action = new AddValueCounterAction( combo_counterA1.getValue(),value);
                valueTF.setText("");
            } else {
                 error.showErrorDialog("Select a counter and set a value.\n");
            }
             break;
             
           case "Sum two Counters":
           if (combo_counterA1!=null && combo_counterA2!=null) {
               
                action = new SumsCounterAction( combo_counterA1.getValue(),combo_counterA2.getValue());
            } else {
                 error.showErrorDialog("Select a counter and a second counter.\n");
            }
            break;
            
        default:
            // Handle unknown action type
            break;
    }
    
    if(action!=null)
     actiontbList.add(action);
}
}


// Method for selecting an action from a table and displaying its description
// the action selected will be used for the creation of a rule
    @FXML
    private void SelectAction(ActionEvent event) {
        actionselected = actionTable.getSelectionModel().getSelectedItem();
        actionTA.setText(actionselected.description());
    }

    // Method for deleting a selected action from the action table
    @FXML
    private void DeleteAction(ActionEvent event) {
         Action selectedAction= actionTable.getSelectionModel().getSelectedItem();

        if ( selectedAction != null) {
          // Rimuovi la regola dalla ruleSet
          actiontbList.remove( selectedAction);
          // Aggiorna la tabella
          actionTable.refresh();
        }  
    }
    
// Method for adding an action to a sequence
    @FXML
    private void addSequenceAction(ActionEvent event) {
        actionseq.add(actionTable.getSelectionModel().getSelectedItem());
        actionseqTA.refresh();
        
    }
// Method for removing an action from a sequence
    private void removeSequenceAction(ActionEvent event) {
        compaction.removeAction(actionTable.getSelectionModel().getSelectedItem());
        actionseqTA.refresh();
      
    }
// Method for deleting an action from a sequence
    @FXML
    private void DeleteActionFromSequence(ActionEvent event) {
        actionseq.remove(actionseqTA.getSelectionModel().getSelectedItem());
        actionseqTA.refresh();
    }
// Method for creating or modifying a counter based on user input
    @FXML
    private void createCounter(ActionEvent event) {
        String name=namecounter_TF.getText();
        Integer value=Integer.parseInt(valuecounter_TF.getText());
        if((name!=null)&&(value!=null)){
            if(cset.getCounter(name)==null){
                cset.addCounter(new Counter(name,value));
                combo_counterT1.getItems().addAll(name); 
                combo_counterT2.getItems().addAll(name); 
                combo_counterA1.getItems().addAll(name); 
                combo_counterA2.getItems().addAll(name); 
            }
              
            else
                cset.getCounter(name).setValue(value);
        }
        namecounter_TF.setText("");
        valuecounter_TF.setText("");
       
      counterTable.refresh();
        
     }
     
    // Method for deleting a counter from the counter table

    @FXML
    private void deleteCounter(ActionEvent event) {
        Counter c=counterTable.getSelectionModel().getSelectedItem();
        String name=c.getName();
        cset.removeCounter(c);
        combo_counterT1.getItems().remove(name);
        combo_counterT2.getItems().remove(name);
        combo_counterA1.getItems().remove(name);
        combo_counterA2.getItems().remove(name);
        counterTable.refresh();
    }
// Method for navigating back to the rule table view
    @FXML
    private void goBack(ActionEvent event) {
         FilePath=null;
         triggerCommandList.clear();
         actionCommandList.clear();
         ruleCreationPane.setDisable(true);
         ruleCreationPane.setVisible(false);
         ruleTablePane.setDisable(false);
         ruleTablePane.setVisible(true);
         actionselected=null;
         triggerselected=null;
         counterTable.refresh();
         triggerTA.setText("");
         actionTA.setText("");
    }
    
    // Method for modifying the value of a selected counter
    @FXML
    private void modifyValue(ActionEvent event) {
        Counter selectedCounter = counterTable.getSelectionModel().getSelectedItem();
        if (selectedCounter != null) {
           CounterModify.modifyValue(selectedCounter);
           counterTable.refresh(); 
        }
    }
     // Method for displaying or hiding the trigger FAQ information
     @FXML
    void faqtriggerAction(ActionEvent event) {
     faqtrigger.setVisible(!faqtrigger.isVisible());
     
        FAQ faqtext = new FAQ("trigger");
        Text textNode = new Text();
        textNode.setText(faqtext.gettextFAQ());
        Pane background = new Pane();
        background.setStyle("-fx-background-color: lightgray;"); // Imposta il colore dello sfondo

        
        background.getChildren().add(textNode);

        background.setPrefWidth(528); 
        background.setPrefHeight(434); 

        faqtrigger.setRoot(background);
  }
    // Method for displaying or hiding the action FAQ information
    
 @FXML
    void faqactionAction(ActionEvent event) {
     faqaction.setVisible(!faqaction.isVisible());
     
        FAQ faqtext = new FAQ("action");
        Text textNode = new Text();
        textNode.setText(faqtext.gettextFAQ());
       
        Pane background = new Pane();
        background.setStyle("-fx-background-color: lightgray;"); // Imposta il colore dello sfondo

        
        background.getChildren().add(textNode);

        background.setPrefWidth(528); 
        background.setPrefHeight(434); 

        faqaction.setRoot(background);
  }
 // Method for refreshing the counter and rule tables
    @FXML
    private void refreshTables(ActionEvent event) {
        counterTable.refresh();
        ruleTable.refresh();
    }
}
 
  


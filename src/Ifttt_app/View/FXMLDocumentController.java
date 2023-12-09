/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ifttt_app.View;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter.Change;

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
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SaveRules.loadRules(rset);
        SaveLoadCounters.loadCounters(cset);
        for(Counter c : cset.getCounter_set()){
              combo_counterT1.getItems().addAll(c.getName()); 
              combo_counterT2.getItems().addAll(c.getName()); 
              combo_counterA1.getItems().addAll(c.getName()); 
              combo_counterA2.getItems().addAll(c.getName()); 
        }
        
        counterTable.setItems(cset.getCounter_set());
        counterNameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        counterValueCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue().toString()));
        configureNegativeNumericTextField(valuecounter_TF);
         configureNegativeNumericTextField(valueTF);
       
        triggertable.setItems(triggertbList);
        triggerList.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().description()));
        
        actionTable.setItems(actiontbList);
        actionseqTA.setItems(actionseq);
        
        triggerList.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().description()));
        actionList.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().description()));
        actionseqcol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().description()));
        
        
        //Crea un UnaryOperator per filtrare l'input e consentire solo numeri interi
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();

            if (newText.isEmpty()) {
                return change;
            }

            if (Pattern.matches("^\\d*$", newText)) {
                return change;
            } else {
                return null; // Reject the change
            }
        };
        
        sleepingdays.setTextFormatter(new TextFormatter<>(filter));
        sleepinghours.setTextFormatter(new TextFormatter<>(filter));
        sleepingminutes.setTextFormatter(new TextFormatter<>(filter));
        
        hspin.getEditor().setTextFormatter(new TextFormatter<>(filter));
        msp.getEditor().setTextFormatter(new TextFormatter<>(filter));
        ssp.getEditor().setTextFormatter(new TextFormatter<>(filter));
        
        fileSizeTextField.setTextFormatter(new TextFormatter<>(filter));
        
       
        
        ruleTable.setItems(rset.getRules()); 
        actioncol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAction().description()) );
        triggercol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrigger().description()));
        repcolumn.setCellValueFactory(cellData -> {
        Rule rowData = cellData.getValue();
        
        

       if (!rowData.isSleeping()) {
        // If isSleeping() returns false, set the value as isfoo
        return new SimpleStringProperty("Can only be triggered once"+"\nhas been fired: "+Boolean.toString(rowData.isFired_oo()));
       } else {
        // If isSleeping() returns true, set the value as getday + gethour
        return new SimpleStringProperty("when triggered sleeps for :\n"+rowData.getDay()+" days\n"+rowData.getHours()+" hours \n"+rowData.getMinutes()+" minutes");
       }
      });
                
        activecol.setCellValueFactory(new PropertyValueFactory<>("active"));
        
        Lhours.setVisible(false);
        hspin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,23,1));
        Lmin.setVisible(false);
        msp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,59,1));
        Lsec.setVisible(false);
        ssp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,59,1));
        
        
        hspin.getValueFactory().setValue(LocalTime.now().getHour());
        msp.getValueFactory().setValue(LocalTime.now().getMinute());
        ssp.getValueFactory().setValue(LocalTime.now().getSecond());
        
        
        hspin.disableProperty().bind(Bindings.notEqual(comboTrigger.valueProperty(), "CurrentTime"));
        msp.disableProperty().bind(Bindings.notEqual(comboTrigger.valueProperty(), "CurrentTime"));
        ssp.disableProperty().bind(Bindings.notEqual(comboTrigger.valueProperty(), "CurrentTime"));
        
        hspin.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        msp.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        ssp.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        
        daySelector.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Day Of Week"));
        Lday.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Day Of Week"));
        daySelector.setValue(LocalDate.now().getDayOfWeek().toString());
        
        daySpinner.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Day Of Month"));
        Lmonth.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "Day Of Month"));
        daySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
        1,
        YearMonth.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue()).lengthOfMonth(),
        LocalDate.now().getDayOfMonth()));
        
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
        
        selectDirectoryButton.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "FileExistence"));
        fileTextField.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "FileExistence"));
                
        
        fileSizeSelectorButton.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "FileSize"));
        fileSizeTextField.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "FileSize"));
                
        selectAudio.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "PlayAudio"));
        selectTextFileButton.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "AppendStringAtFile"));
        messagefield.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "ShowDialog").or(Bindings.equal(comboAction.valueProperty(), "AppendStringAtFile")));
        
        Lhours.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        Lmin.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        Lsec.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        
        commandlinelistAction.setItems(actionCommandList);
        commandlinelistTrigger.setItems(triggerCommandList);
        
        commandlinelistTrigger.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
        commandlinelistAction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "RunExternalProgramAction"));
        addcommandLineButtonAction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "RunExternalProgramAction"));
        addcommandLineTriggerButton.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
        commandLineTextfieldAction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "RunExternalProgramAction"));
        commandLineTextfieldTrigger.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
               
        selectProgramAction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "RunExternalProgramAction"));
        selectProgram1.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
        externalTxt.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "RunExternalProgramTrigger"));
        
        fristTriggerFieldTA.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        secondTriggerFieldTA.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        logicalbox.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        triggerfield1.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        triggerfield2.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CompositeTrigger"));
        
        
        counter_cb.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboActionValue = comboAction.valueProperty().getValue();
            return ("ShowDialog".equals( comboActionValue) || "AppendStringAtFile".equals( comboActionValue));
        },
        comboAction.valueProperty()  
        )
        );
        
        combo_counterT1.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboTriggerValue = comboTrigger.valueProperty().getValue();
            return ("Compare Counter to Value".equals( comboTriggerValue) || "Compare Counter to Counter".equals( comboTriggerValue));
        },
        comboTrigger.valueProperty()  
        )
        );
        
        combo_counterT2.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboTriggerValue = comboTrigger.valueProperty().getValue();
            return ("Compare Counter to Counter".equals( comboTriggerValue));
        },
        comboTrigger.valueProperty()  
        )
        );
        
        addseqmenu.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Action Sequence"));
        deleteSqaction.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Action Sequence"));  
        actionseqTA.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Action Sequence"));  
        
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
        
        
        combo_counterA2.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboActionValue = comboAction.valueProperty().getValue();
            return ("Sum two Counters".equals(comboActionValue));
        },
        comboAction.valueProperty()  
        )
        ); 
        
        valueTF.visibleProperty().bind(
     Bindings.createBooleanBinding(
        () -> {
            String comboActionValue = comboAction.valueProperty().getValue();
            return ("SetCounterValue".equals(comboActionValue) || "Add Value to Counter".equals(comboActionValue) );
        },
        comboAction.valueProperty()  
        )
        );
       
       
       
       
        
        ToggleGroup toggleGroup = new ToggleGroup();
        firedradiobutton.setToggleGroup(toggleGroup);
        sleepingradiobutton.setToggleGroup(toggleGroup);
        firedradiobutton.setSelected(true);
        
        sleepingdays.disableProperty().bind(firedradiobutton.selectedProperty());
        sleepinghours.disableProperty().bind(firedradiobutton.selectedProperty());
        sleepingminutes.disableProperty().bind(firedradiobutton.selectedProperty());
        
        
        sleepingdays.visibleProperty().bind(sleepingradiobutton.selectedProperty());
        sleepinghours.visibleProperty().bind(sleepingradiobutton.selectedProperty());
        sleepingminutes.visibleProperty().bind(sleepingradiobutton.selectedProperty());
        
        selectFileButton.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Copy File").or(Bindings.equal(comboAction.valueProperty(), "Move File")).or(Bindings.equal(comboAction.valueProperty(), "Delete File")));
        ButtonDirectory.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "Copy File").or(Bindings.equal(comboAction.valueProperty(), "Move File")));
        
        
        comboTrigger.getItems().addAll("CurrentTime");
        comboTrigger.getItems().addAll("Day Of Week");
        comboTrigger.getItems().addAll("Day Of Month");
        comboTrigger.getItems().addAll("Date");
        comboTrigger.getItems().addAll("FileExistence");
        comboTrigger.getItems().addAll("FileSize");
        comboTrigger.getItems().addAll("RunExternalProgramTrigger");
        comboTrigger.getItems().addAll("CompositeTrigger");
        comboTrigger.getItems().addAll("Compare Counter to Value");
        comboTrigger.getItems().addAll("Compare Counter to Counter");
        
        comboAction.getItems().addAll("ShowDialog");
        comboAction.getItems().addAll("PlayAudio");
        comboAction.getItems().addAll("AppendStringAtFile");
        comboAction.getItems().addAll("RunExternalProgramAction");
        comboAction.getItems().addAll("Copy File");
        comboAction.getItems().addAll("Move File");
        comboAction.getItems().addAll("Delete File");
        comboAction.getItems().addAll("Action Sequence");
        comboAction.getItems().addAll("SetCounterValue");
        comboAction.getItems().addAll("Add Value to Counter");
        comboAction.getItems().addAll("Sum two Counters");
       
        
        
        daySelector.getItems().addAll("Monday");
        daySelector.getItems().addAll("Tuesday");
        daySelector.getItems().addAll("Wednesday");
        daySelector.getItems().addAll("Thursday");
        daySelector.getItems().addAll("Friday");
        daySelector.getItems().addAll("Saturday");
        daySelector.getItems().addAll("Sunday");
        
        logicalbox.getItems().addAll("AND","OR");
        

       
        
        
       
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
        
       
       create_counter_button.disableProperty().bind(
               Bindings.createBooleanBinding(()-> namecounter_TF.getText().isEmpty() || valuecounter_TF.getText().isEmpty()
                       , namecounter_TF.textProperty(),
                       valuecounter_TF.textProperty()
               )
       );
               
       
    
        // TODO
        
    }
    
    
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
    
    @FXML
    private void Save(ActionEvent event) {
        SaveRules.saveRules(rset);
    }
    
    @FXML
    void SaveCounters(ActionEvent event) {
         SaveLoadCounters.saveCounters(cset);
    }
    
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
    
    @FXML
    void selectAudio(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        // Settare titolo file chooser
        fileChooser.setTitle("Select a File");

        // Settare directory iniziale
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        fileChooser.setInitialDirectory(initialDirectory);

        // Settare extension filter per file WAV
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("WAV files (.wav)", "*.wav");
        fileChooser.getExtensionFilters().add(extFilter);

        //Mostra finestra id dialogo quando il bottone viene premuto
        File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                FilePath = selectedFile.getAbsolutePath();
            }
    }

    @FXML
    private void activeDeactive(ActionEvent event) {
        //Prendo la regola selezionata
        Rule selectedRule = ruleTable.getSelectionModel().getSelectedItem();
        selectedRule.setActive(!selectedRule.isActive());
        ruleTable.refresh();
    }

    @FXML
    private void selectTextFile(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        // Settare titolo file chooser
        fileChooser.setTitle("Select a File");

        // Settare directory iniziale
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        fileChooser.setInitialDirectory(initialDirectory);

        // Settare extension filter per file text
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Mostra finestra id dialogo quando il bottone viene premuto
        File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                textFilePath = selectedFile.getAbsolutePath();
            }
    }

    @FXML
    private void selectDirectoryButton(ActionEvent event) throws IOException {
         
        // Creo un DirectoryChooser
        DirectoryChooser directoryChooser = new DirectoryChooser();

      
        directoryChooser.setTitle("Select a Directory");

        // Settare directory iniziale
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        directoryChooser.setInitialDirectory( initialDirectory);

        //Mostra finestra di dialogo quando il bottone viene premuto
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            System.out.println("Selected Directory: " + selectedDirectory.getAbsolutePath());
            directoryPath=selectedDirectory.getAbsolutePath();
        } else {
            System.out.println("No directory selected.");
        }
    }

    @FXML
    private void fileSizeSelector(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();

        // Settare titolo file chooser
        fileChooser.setTitle("Select a File");

        // Settare directory iniziale
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        fileChooser.setInitialDirectory(initialDirectory);

        //Mostra finestra id dialogo quando il bottone viene premuto
        File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
               sizeFilePath = selectedFile.getAbsolutePath();
            }
    }
    
    @FXML
    void selectProgram(ActionEvent event) throws IOException {
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

    @FXML
    private void buttonSelectDirectory(ActionEvent event) throws IOException {
        // Creo un DirectoryChooser
        DirectoryChooser directoryChooser = new DirectoryChooser();

      
        directoryChooser.setTitle("Select a Directory");

        // Settare directory iniziale
        File currentDirectory = new File(new File(".").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        directoryChooser.setInitialDirectory( initialDirectory);

        //Mostra finestra di dialogo quando il bottone viene premuto
        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            System.out.println("Selected Directory: " + selectedDirectory.getAbsolutePath());
            directoryPathFile=selectedDirectory.getAbsolutePath();
        } else {
            System.out.println("No directory selected.");
        }
    }

    @FXML
    private void addCommandLine(ActionEvent event) {
        triggerCommandList.add(commandLineTextfieldTrigger.getText());
        commandLineTextfieldTrigger.setText("");
    }

    @FXML
    private void addCommandLineAction(ActionEvent event) {
        actionCommandList.add(commandLineTextfieldAction.getText());
        commandLineTextfieldAction.setText("");
    }

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

    @FXML
    private void CreateTrigger(ActionEvent event) {
        
        String triggerValue = comboTrigger.getValue();
        Trigger trigger=null;

if (triggerValue != null) {
    switch (triggerValue) {
        case "CurrentTime":
            trigger = new TimeTrigger(LocalTime.of(hspin.getValue(), msp.getValue(), ssp.getValue()));
            break;

        case "FileExistence":
            if (directoryPath != null && fileTextField.getText() != null) {
                trigger = new ExistenceTrigger(directoryPath, fileTextField.getText());
            } else {
                if (directoryPath == null) {
                    ruleWarning.setText(ruleWarning.getText() + "No valid trigger directory selected." + "\n");
                }
                if (fileTextField.getText() == null) {
                    ruleWarning.setText(ruleWarning.getText() + "Empty name for file trigger existence." + "\n");
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
                trigger = new SizeFileTrigger(sizeFilePath, Integer.parseInt(fileSizeTextField.getText()));
            } else {
                if (directoryPath == null) {
                    ruleWarning.setText(ruleWarning.getText() + "No valid file selected." + "\n");
                }
                if (fileSizeTextField.getText() == null) {
                    ruleWarning.setText(ruleWarning.getText() + "0 bytes to size trigger" + "\n");
                }
            }
            break;

        case "RunExternalProgramTrigger":
            ArrayList<String> arguments = new ArrayList<>(triggerCommandList);
            trigger = new TriggerExternalProgram(ProgramPath, arguments, Integer.parseInt(externalTxt.getText()));
            break;
      
        case "CompositeTrigger":
          
            
            if ((a != null)&&(a != null) && !logicalbox.getValue().isEmpty()) {
                if(logicalbox.getValue().equals("AND"))
                    trigger = new CompositeTrigger(a,b,true);
                else
                    trigger = new CompositeTrigger(a,b,false);
             } 
            
            break;    
        default:
            // Handle unknown trigger value
            break;     
    }
    if(trigger!=null){
     if(notcheck.isSelected())
         trigger= new NotTrigger(trigger);
     else
      triggertbList.add(trigger);  
    }
     
}
    }

    @FXML
    private void SelectTrigger(ActionEvent event) {
        triggerselected=triggertable.getSelectionModel().getSelectedItem();
        triggerTA.setText(triggerselected.description());
    }

    @FXML
    private void TriggerField1(ActionEvent event) {
        a=triggertable.getSelectionModel().getSelectedItem();
        fristTriggerFieldTA.setText(a.description());
        
    }

    @FXML
    private void triggerField2(ActionEvent event) {
        b=triggertable.getSelectionModel().getSelectedItem();
        secondTriggerFieldTA.setText(b.description());
    }

    @FXML
    private void DeleteTrigger(ActionEvent event) {
           Trigger selectedTrigger= triggertable.getSelectionModel().getSelectedItem();

        if (selectedTrigger != null) {
          // Rimuovi la regola dalla ruleSet
           triggertbList.remove(selectedTrigger);
          // Aggiorna la tabella
          triggertable.refresh();
        }  
    }

    @FXML
    private void CreateAction(ActionEvent event) {
  if (comboAction.getValue() != null) {
    String actionType = comboAction.getValue();
    Action action=null;
    switch (actionType) {
        case "ShowDialog":

            if(counter_cb.isSelected() && !combo_counterA1.getValue().isEmpty()){
                action= new ReplaceShowDialogAction
                (new ShowDialogAction(messagefield.getText()),combo_counterA1.getValue());
            }
            else
                action = new ShowDialogAction(messagefield.getText());
            break;
        case "PlayAudio":
            if (FilePath != null) {
                action = new ActionPlayAudio(FilePath);
            } else {
                ruleWarning.setText(ruleWarning.getText() + "No valid audio file selected.\n");
            }
            break;
        case "AppendStringAtFile":
            if (textFilePath != null) {
                action = new SpecifiedStringAction(textFilePath, messagefield.getText());
               if(counter_cb.isSelected() && !combo_counterA1.getValue().isEmpty()){
                action= new ReplaceStringAppendAction
                (new SpecifiedStringAction(textFilePath, messagefield.getText()),combo_counterA1.getValue());
            }
            else
                action = new ShowDialogAction(messagefield.getText());
            } else {
                ruleWarning.setText(ruleWarning.getText() + "No valid text file selected.\n");
            }
            break;
        case "RunExternalProgramAction":
            if (ProgramPath != null) {
                ArrayList<String> arguments = new ArrayList<>(actionCommandList);
                action = new RunExternalProgramAction(ProgramPath, arguments);
            } else {
                ruleWarning.setText(ruleWarning.getText() + "No valid program file selected.\n");
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
                ruleWarning.setText(ruleWarning.getText() + "No valid file paths selected.\n");
            }
            break;
            case "Action Sequence":
           if (actionseq.size()>0) {
                ArrayList<Action> arguments = new ArrayList<>(actionseq);
                action = new CompositeAction(arguments);
            } else {
                ruleWarning.setText(ruleWarning.getText() + "No valid program file selected.\n");
            }

            break;
            
           case "SetCounterValue":
           if (combo_counterA1!=null && !valueTF.getText().isEmpty()) {
                Integer value=Integer.parseInt(valueTF.getText());
                action = new SetCounterValueAction( combo_counterA1.getValue(),value);
                valueTF.setText("");
            } else {
                ruleWarning.setText(ruleWarning.getText() + "No valid program file selected.\n");
            }
             break;
             
             
           case "Add Value to Counter":
           if (combo_counterA1!=null && !valueTF.getText().isEmpty()) {
                Integer value=Integer.parseInt(valueTF.getText());
                action = new AddValueCounterAction( combo_counterA1.getValue(),value);
                valueTF.setText("");
            } else {
                ruleWarning.setText(ruleWarning.getText() + "No valid program file selected.\n");
            }
             break;
             
           case "Sum two Counters":
           if (combo_counterA1!=null && combo_counterA2!=null) {
               
                action = new SumsCounterAction( combo_counterA1.getValue(),combo_counterA2.getValue());
            } else {
                ruleWarning.setText(ruleWarning.getText() + "No valid program file selected.\n");
            }
            break;
            
        default:
            // Handle unknown action type
            break;
    }
    
    
    actiontbList.add(action);
}
}

    @FXML
    private void SelectAction(ActionEvent event) {
        actionselected = actionTable.getSelectionModel().getSelectedItem();
        actionTA.setText(actionselected.description());
    }

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

    @FXML
    private void addSequenceAction(ActionEvent event) {
        actionseq.add(actionTable.getSelectionModel().getSelectedItem());
        actionseqTA.refresh();
        
    }

    private void removeSequenceAction(ActionEvent event) {
        compaction.removeAction(actionTable.getSelectionModel().getSelectedItem());
        actionseqTA.refresh();
      
    }

    @FXML
    private void DeleteActionFromSequence(ActionEvent event) {
        actionseq.remove(actionseqTA.getSelectionModel().getSelectedItem());
        actionseqTA.refresh();
    }

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
     
    
    
    private void configureNegativeNumericTextField(TextField textField) {
        Pattern validEditingState = Pattern.compile("-?\\d*");

        UnaryOperator<Change> filter = change -> {
            String text = change.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        textField.setTextFormatter(textFormatter);
    }

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
    @FXML
    private void modifyValue(ActionEvent event) {
        Counter selectedCounter = counterTable.getSelectionModel().getSelectedItem();
        if (selectedCounter != null) {
           CounterModify.modifyValue(selectedCounter);
           counterTable.refresh(); // Aggiorna la TableView se necessario
        }
    }
}
 
  


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ifttt_app.View;

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
import javafx.beans.value.ObservableStringValue;

/**
 * FXML Controller class
 *
 * @author aless
 */
public class FXMLDocumentController implements Initializable {
    
    RuleSet rset=RuleSet.getInstance(); 
    
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
    private Button selectProgram;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SaveRules.loadRules(rset);
        
        
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
        
        selectProgram.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "RunExternalProgramAction"));
        
        
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
        
        
        comboTrigger.getItems().addAll("CurrentTime");
        comboTrigger.getItems().addAll("Day Of Week");
        comboTrigger.getItems().addAll("Day Of Month");
        comboTrigger.getItems().addAll("Date");
        comboTrigger.getItems().addAll("FileExistence");
        comboTrigger.getItems().addAll("FileSize");
        
        comboAction.getItems().addAll("ShowDialog");
        comboAction.getItems().addAll("PlayAudio");
        comboAction.getItems().addAll("AppendStringAtFile");
        comboAction.getItems().addAll("RunExternalProgramAction");
        
        daySelector.getItems().addAll("Monday");
        daySelector.getItems().addAll("Tuesday");
        daySelector.getItems().addAll("Wednesday");
        daySelector.getItems().addAll("Thursday");
        daySelector.getItems().addAll("Friday");
        daySelector.getItems().addAll("Saturday");
        daySelector.getItems().addAll("Sunday");
        
        addRuleButton.disableProperty().bind(Bindings.isNull(comboTrigger.valueProperty()).or(Bindings.isNull(comboAction.valueProperty())).or(sleepingradiobutton.selectedProperty().and(sleepingdays.textProperty().isEmpty().or(sleepinghours.textProperty().isEmpty().or(sleepingminutes.textProperty().isEmpty())))));        
        
    
        // TODO
        
    }
    
    
    @FXML
    private void addRuleButton(ActionEvent event) {
        
        ruleWarning.setText("");
        Trigger trigger=null;
        Action action=null;
        Rule r=null;
        if (comboTrigger.getValue().equals("CurrentTime"))
            trigger=new TimeTrigger(LocalTime.of(hspin.getValue(), msp.getValue(), ssp.getValue()));
        if (comboTrigger.getValue().equals("FileExistence")){
           if(directoryPath!=null && fileTextField.getText()!=null)
             trigger=new ExistenceTrigger(directoryPath,fileTextField.getText());
           else if(directoryPath==null)
                ruleWarning.setText(ruleWarning.getText()+"No valid trigger directory selected."+"\n");
           else if(fileTextField.getText()!=null)
                ruleWarning.setText(ruleWarning.getText()+"empty name for file trigger existence."+"\n");
        }
        
        if (comboTrigger.getValue().equals("Day Of Week")){
            trigger= new TriggerDay(DayOfWeek.valueOf(daySelector.getValue().toUpperCase()));
        }
        if (comboTrigger.getValue().equals("Day Of Month")){
            trigger= new TriggerDayMonth(daySpinner.getValue());
        }
        if (comboTrigger.getValue().equals("Date")){
            trigger= new TriggerDate(LocalDate.of(yearSpn.getValue(), monthSpn.getValue(), daySpn.getValue()));
        }
        
        if (comboTrigger.getValue().equals("FileSize")){
           if(sizeFilePath!=null)
             trigger=new SizeFileTrigger(sizeFilePath,Integer.parseInt(fileSizeTextField.getText()));
           else if(directoryPath==null)
                ruleWarning.setText(ruleWarning.getText()+"No valid file selected."+"\n");
           else if(fileSizeTextField.getText()!=null)
                ruleWarning.setText(ruleWarning.getText()+"0 bytes to size trigger"+"\n");
        }
        if (comboAction.getValue().equals("ShowDialog"))
            action= new ShowDialogAction(messagefield.getText());
        if (comboAction.getValue().equals("PlayAudio")){
            if(FilePath!=null){
             action = new ActionPlayAudio(FilePath);
            }
            else
                ruleWarning.setText(ruleWarning.getText()+"No valid audio file selected."+"\n");
        }
        if (comboAction.getValue().equals("AppendStringAtFile")){
            if(textFilePath!=null){
             action = new SpecifiedStringAction(textFilePath,messagefield.getText());
            }
            else
                ruleWarning.setText(ruleWarning.getText()+"No valid text file selected."+"\n");
        }if (comboAction.getValue().equals("RunExternalProgramAction")) {
        if(FilePath!=null){
             action = new RunExternalProgramAction(FilePath);
            }
            else
                ruleWarning.setText(ruleWarning.getText()+"No valid program file selected."+"\n");
    
        }if(comboAction.getValue().equals("RunExternalProgramAction")){
            if(ProgramPath!=null){
                action = new RunExternalProgramAction(ProgramPath);
            }
        }
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
         ruleCreationPane.setDisable(true);
         ruleCreationPane.setVisible(false);
         ruleTablePane.setDisable(false);
         ruleTablePane.setVisible(true);
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
    }
    
    @FXML
    private void Save(ActionEvent event) {
        SaveRules.saveRules(rset);
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

        // Settare titolo file chooser
        fileChooser.setTitle("Select a File");

        // Settare directory iniziale
        File currentDirectory = new File(new File("./External Programs").getAbsolutePath());
        File initialDirectory = new File(currentDirectory.getCanonicalPath());
        fileChooser.setInitialDirectory(initialDirectory);

        // Settare extension filter per file WAV
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BAT files (.bat)", "*.bat");
        fileChooser.getExtensionFilters().add(extFilter);

        //Mostra finestra id dialogo quando il bottone viene premuto
        File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                ProgramPath = selectedFile.getAbsolutePath();
            }
            
    }
 
  }


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
import java.time.LocalTime;
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
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;

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
    
    private String FilePath;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SaveRules.loadRules(rset);
        
        
        ruleTable.setItems(rset.getRules());
        actioncol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAction().getClass().getSimpleName()) );
        triggercol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrigger().getClass().getSimpleName()));
        
        Lhours.setVisible(false);
        hspin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,23,1));
        Lmin.setVisible(false);
        msp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,59,1));
        Lsec.setVisible(false);
        ssp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,59,1));
        
        hspin.disableProperty().bind(Bindings.notEqual(comboTrigger.valueProperty(), "CurrentTime"));
        msp.disableProperty().bind(Bindings.notEqual(comboTrigger.valueProperty(), "CurrentTime"));
        ssp.disableProperty().bind(Bindings.notEqual(comboTrigger.valueProperty(), "CurrentTime"));
        
        hspin.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        msp.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        ssp.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        selectAudio.visibleProperty().bind(Bindings.equal(comboAction.valueProperty(), "PlayAudio"));
        
        Lhours.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        Lmin.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        Lsec.visibleProperty().bind(Bindings.equal(comboTrigger.valueProperty(), "CurrentTime"));
        
        
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
        comboAction.getItems().addAll("ShowDialog");
        comboAction.getItems().addAll("PlayAudio");
        
        addRuleButton.disableProperty().bind(Bindings.isNull(comboTrigger.valueProperty()).or(Bindings.isNull(comboAction.valueProperty())));
        
        if(comboTrigger.valueProperty().equals("CurrentTime")){
            
        }
        // TODO
        
    }
    
    
    @FXML
    private void addRuleButton(ActionEvent event) {
        
        
        Trigger trigger=null;
        Action action=null;
        Rule r=null;
        if (comboTrigger.getValue().equals("CurrentTime"))
            trigger=new TimeTrigger(LocalTime.of(hspin.getValue(), msp.getValue(), ssp.getValue()));
           
        if (comboAction.getValue().equals("ShowDialog"))
            action= new ShowDialogAction(messagefield.getText());
        if (comboAction.getValue().equals("PlayAudio")){
            
            action = new ActionPlayAudio(FilePath);
        }
        if ((action!=null) && (trigger!=null) ){
            r=new Rule(action,trigger);
        }
        
        rset.addRule(r);
        ruleCreationPane.setDisable(true);
        ruleCreationPane.setVisible(false);
        ruleTablePane.setDisable(false);
        ruleTablePane.setVisible(true);
    }

    @FXML
    private void CreateRuleButtonEvent(ActionEvent event) {
        ruleTablePane.setDisable(true);
        ruleTablePane.setVisible(false);
        ruleCreationPane.setDisable(false);
        ruleCreationPane.setVisible(true);
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
}

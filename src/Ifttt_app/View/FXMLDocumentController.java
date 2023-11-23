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
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author aless
 */
public class FXMLDocumentController implements Initializable {
    
    ObservableList<Rule> ruleList = FXCollections.observableArrayList();
    RuleSet rset=RuleSet.getInstance(ruleList); 
    
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ruleTable.setItems(ruleList);
        actioncol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAction().getClass().getSimpleName()) );
        triggercol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrigger().getClass().getSimpleName()));
        
        hspin.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,23,1));
        msp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,59,1));
        ssp.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory (0,59,1));
        
        

        
        comboTrigger.getItems().addAll("CurrentTime");
        comboAction.getItems().addAll("ShowDialog");
        
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
    
}

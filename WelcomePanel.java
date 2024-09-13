/**
 * WelcomePanel is the first introductory panel shown to the user, it describes how to use
 * the GUI and how to navigate and read through the data range chosen
 * 
 * @version: 3.1
 * @author: Mohammed Ahmed(K22026228), Shahriar Miah(K22023070), Christopher Herre(K22001776), Talal AlOhali(K21130307)
 */

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.Date;

import java.time.LocalDate;

public class WelcomePanel{
    @FXML private DatePicker toDate; // Variable for the "from" date, corresponding to fx:id on fxml
    @FXML private DatePicker fromDate; // Variable for the "to" date, corresponding to fx:id on fxml
    @FXML private Button prevButton;
    @FXML private Button nextButton;
    @FXML private Label errorLabel;
    
    // Methods return the date entered into the calender widget
    // system print for now to test
    @FXML
    private String returnToDate() throws NullPointerException{
        prevButton.setDisable(true);
        nextButton.setDisable(true);
        LocalDate date = toDate.getValue();
        if(date == null){
            errorLabel.setText("Enter a From/To date.");
        }
        String dateConv = toDate.getValue().toString();
        ProcessData.setToDate(dateConv);
        System.out.println("The date is " + dateConv);
        return dateConv;
    }
    
    @FXML
    private String returnFromDate() throws NullPointerException{
        prevButton.setDisable(true);
        nextButton.setDisable(true);
        LocalDate date = fromDate.getValue();
        if(date == null){
            errorLabel.setText("Enter a From/To date.");
        }
        String dateConv = fromDate.getValue().toString();
        ProcessData.setFromDate(dateConv);
        System.out.println("The date is " + dateConv);
        return dateConv;
    }
    
    /**
     * Checks whether the entered date is within the valid range, an error label will pop up
     * if the entry is invalid
     */
    @FXML
    private Boolean getValidity() throws NullPointerException{
        Integer from = Integer.valueOf(returnFromDate().replace("-",""));
        Integer to = Integer.valueOf(returnToDate().replace("-",""));
        if (from > to){
            errorLabel.setText("To Date is before the From Date");
            return false;
        }
        else if ((from > 20200215 && from < 20221015)&& (to < 20221015 && to > 20200215)){
            return true;
        }
        errorLabel.setText("The date range is: 15/02/2020 to 15/10/2022");
        return false;
    }
    
    /**
     * The button used to process the dates entered in order to allow access to the other panels by
     * the user, the dates reset upon returning back to the welcome panel as processing needs to occur before
     * moving between panels.
     */
    @FXML
    private Boolean processDates() throws IOException, NullPointerException{
        prevButton.setDisable(true);
        nextButton.setDisable(true);
        if(getValidity() == true){
            prevButton.setDisable(false);
            nextButton.setDisable(false);
            errorLabel.setText("");
            return true;
        }
        return false;
    }
    
    /**
     * Used by the next button in order to move from welcome panel to
     * the next panel to the right.
     */
    @FXML
    private void switchToBoroughs() throws IOException{
        if(processDates() == true){
            GUIManager.setRoot("Panel2");
        }
    }
    
    @FXML
    private void switchToAffectedBoroughs() throws IOException{
        if(processDates() == true){
            GUIManager.setRoot("Panel4");
        }
    }
}


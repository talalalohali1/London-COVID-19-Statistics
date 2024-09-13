/**
 * Panel used to display the Borough date within the specified date range
 * to the user. This opens a secondary window to display specific borough information
 * as well as a heat map to show the virility of the virus.
 * 
 * @version: 3.1
 * @author: Mohammed Ahmed(K22026228), Shahriar Miah(K22023070), Christopher Herre(K22001776), Talal AlOhali(K21130307)
 */
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class BoroughPanels{
    
    @FXML private Circle Hackney;
    @FXML private Circle Harrow;
    @FXML private Circle Brent;
    @FXML private Circle Camden;
    @FXML private Circle Islington;
    @FXML private Circle Havering;
    @FXML private Circle Greenwich;
    @FXML private Circle Newham;
    @FXML private Circle Barking_And_Dagenham;
    @FXML private Circle Westminster;
    @FXML private Circle Kensington_And_Chelsea;
    @FXML private Circle Ealing;
    @FXML private Circle Hillingdon;
    @FXML private Circle Tower_Hamlets;
    @FXML private Circle Redbridge;
    @FXML private Circle Enfield;
    @FXML private Circle Waltham_Forest;
    @FXML private Circle Haringey;
    @FXML private Circle Barnet;
    @FXML private Circle Bromley;
    @FXML private Circle Croydon;
    @FXML private Circle Sutton;
    @FXML private Circle Kingston_Upon_Thames;
    @FXML private Circle Southwark;
    @FXML private Circle Lambeth;
    @FXML private Circle Merton;
    @FXML private Circle Richmond_Upon_Thames;
    @FXML private Circle Lewisham;
    @FXML private Circle Bexley;
    @FXML private Circle City_Of_London;
    @FXML private Circle Wandsworth;
    @FXML private Circle Hammersmith_And_Fulham;
    @FXML private Circle Hounslow;

    private ArrayList<Circle> boroughObjects = new ArrayList<>();
    
    private void addToArrList(){
        boroughObjects.add(Hackney);
        boroughObjects.add(Harrow);
        boroughObjects.add(Brent);
        boroughObjects.add(Camden);
        boroughObjects.add(Islington);
        boroughObjects.add(Havering);
        boroughObjects.add(Greenwich);
        boroughObjects.add(Newham);
        boroughObjects.add(Barking_And_Dagenham);
        boroughObjects.add(Westminster);
        boroughObjects.add(Kensington_And_Chelsea);
        boroughObjects.add(Ealing);
        boroughObjects.add(Hillingdon);
        boroughObjects.add(Tower_Hamlets);
        boroughObjects.add(Redbridge);
        boroughObjects.add(Enfield);
        boroughObjects.add(Waltham_Forest);
        boroughObjects.add(Haringey);
        boroughObjects.add(Barnet);
        boroughObjects.add(Bromley);
        boroughObjects.add(Croydon);
        boroughObjects.add(Sutton);
        boroughObjects.add(Kingston_Upon_Thames);
        boroughObjects.add(Southwark);
        boroughObjects.add(Lambeth);
        boroughObjects.add(Merton);
        boroughObjects.add(Richmond_Upon_Thames);
        boroughObjects.add(Lewisham);
        boroughObjects.add(Bexley);
        boroughObjects.add(City_Of_London);
        boroughObjects.add(Wandsworth);
        boroughObjects.add(Hammersmith_And_Fulham);
        boroughObjects.add(Hounslow);
    }
    
    private ProcessData process;
    
    public BoroughPanels(){  
        process = new ProcessData();
        
    }
    
    @FXML
    private void switchToWelcome() throws IOException{
        GUIManager.setRoot("Panel1");
    }
    
    @FXML
    private void switchToStatistics() throws IOException{
        GUIManager.setRoot("Panel3");
    }
    
    /**
     * Changes the Circle colour of each borough according to the amount of deaths within the range.
     * Accesses ProcessData in order to get a hashmap of this data.
     */
    @FXML
    public void changeCircleColour(){
        HashMap<String, Integer> deaths = process.getTotalDeathsHashMap();
        addToArrList();
        for(Circle shape : boroughObjects){
            if(deaths.containsKey(shape.getId())){
                int deathRate = deaths.get(shape.getId());
                shape.setFill(colourGrade(deathRate));
                
            }
        }
    }
    
    /**
     * Determines the color depending on the value passed into the 
     * method
     */
    private Color colourGrade(int value){
        if(value < 60000){
            return Color.web("#ADFF2F40");
        } else if(value >= 60000 && value < 100000){
             return Color.web("#228B2240"); 
        } else if(value >= 100000){
            return Color.web("#556B2F40");
        }
        return Color.WHITE;
    }
    
    /**
     * Creates a new stage where the specific borough information is used in order to
     * display a table to the user
     * Calls upon the TableLoaderLayout class to get the GUI elements.
     */
    @FXML
    private void switchToSpecificBorough(MouseEvent event) throws IOException{
        Stage stageTwo = new Stage();
        TableLoaderLayout tableLoader = new TableLoaderLayout();
        stageTwo.setTitle(process.getFxidString(event));
        stageTwo.setScene(new Scene(tableLoader, 1031, 376));
        stageTwo.setMaxHeight(420);
        stageTwo.setMaxWidth(1060);
        tableLoader.initialize(event);
        stageTwo.show();
    }
}

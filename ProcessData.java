/**
 * Process Data is used to handle all the calculations by the CovidDataLoader class and
 * HandleClick class. It is then passed down to the other GUI classes to be presented to the
 * user. It also passes conversion methods to other  classes so it heavily reduces the amount of 
 * redundant code.
 *
 * @version: 3.1
 * @author: Mohammed Ahmed(K22026228), Shahriar Miah(K22023070), Christopher Herre(K22001776), Talal AlOhali(K21130307)
 */

// JavaFX imports used
import javafx.scene.input.MouseEvent;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

// Java Time imports used
import java.time.LocalDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Java Data Structure Imports used
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ProcessData{
    private static String fromDate; // Both fromDate and toDate are retrieved from WelcomePanel
    private static String toDate;

    private DateFormat form = new SimpleDateFormat("yyyy-MM-dd"); // Sets the format used
    private Date formattedDate = null;
    
    private HandleClick circleClick;
    private CovidDataLoader covidDataLoader;
    private ArrayList<CovidData> Coviddata;
    // Observable list used by the TableView to dynamically update data
    private ObservableList<CovidData> observeList = FXCollections.observableArrayList();
    private HashMap<String, Integer> boroughData;
    
    public ProcessData(){
        circleClick = new HandleClick();
        covidDataLoader = new CovidDataLoader();
        Coviddata = covidDataLoader.load();
        boroughData = new HashMap<>();
    }
    
    //Accessable arraylist to be used by other classes
    public ArrayList<CovidData> getCovidDataArr(){
        return Coviddata;
    }
    
    public static String getFromDate(){
        return fromDate;
    }
    
    public static String getToDate(){
        return toDate;
    }
    
    public static void setFromDate(String date){
        fromDate = date;
    }
    
    public static void setToDate(String date){
        toDate = date;
    }
    
    /**
     * This method return the ObjectId as a string.
     * Useful for identifying which borough was clicked
     * by the user.
     * idName is for visual use by removing "_" from the
     */
    public String getFxidString(MouseEvent event){
        String idName = circleClick.getObjectId(event);
        if(idName.contains("_") == true){
            idName = idName.replace("_", " "); 
        }
        return idName;
    }
    
    /**
     * This method is used to filter the CovidDataLoader ArrayList
     * It filters by borough and the specified date range given by the user
     * Thereafter, it returns an Observable list to be used by the TableView Class.
     */
    public ObservableList<CovidData> filterData(MouseEvent event){
        for(CovidData key : getCovidDataArr()){
            if(key.getBorough().equals(getFxidString(event))){
                if(!(convertDate(key.getDate()).before(convertDate(getFromDate())) || convertDate(key.getDate()).after(convertDate(getToDate())))){
                    observeList.add(key);
                }
            }
        }
        return observeList;
    }
    
    /**
     * This method is used to return the death statistic to another class
     * This had to be hard coded as introducing CovidData into the parameter arguments
     * would introduce tight coupling.
     */
    public HashMap<String, Integer> getTotalDeathsHashMap(){
        for(CovidData data : getCovidDataArr()){
            if(data.getDate().equals("2022-10-15")){
                boroughData.put(data.getBorough().replace(" ", "_"), data.getTotalDeaths());
            }
        }
        return boroughData;
    }
    
    /**
     * Converts the date from a string to
     * a Date Type to be compared in the above methods.
     */
    public Date convertDate(String date){
        try{
            formattedDate = form.parse(date);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return formattedDate;
    }
}

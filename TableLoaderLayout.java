/**
 * The TableLoaderLayout class is used to build the table so all the 
 * data can be sorted and displayed in an easy to read format.
 * SceneBuilder was used to make the GUI and it was manually converted to Java as
 * it was easier to call the column objects.
 * 
 * @version: 3.1
 * @author: Mohammed Ahmed(K22026228), Shahriar Miah(K22023070), Christopher Herre(K22001776), Talal AlOhali(K21130307)
 */

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;

public class TableLoaderLayout extends Pane {
    
    private ProcessData process = new ProcessData();
    
    private TableView table;
    private TableColumn dateCol;
    private TableColumn boroughCol;
    private TableColumn retailAndRecreationCol;
    private TableColumn groceryAndPharmacyCol;
    private TableColumn parksCol;
    private TableColumn transitStationsCol;
    private TableColumn workplacesCol;
    private TableColumn residentialCol;
    private TableColumn newCasesCol;
    private TableColumn totalCasesCol;
    private TableColumn newDeathsCol;
    private TableColumn totalDeathsCol;
    private Label boroughName;
    
    public TableLoaderLayout() {
        
        VBox root = new VBox();
        root.setPrefSize(1030, 380);
        
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefSize(1030, 51);
        
        boroughName = new Label("Borough Name");
        boroughName.setFont(new Font("System Bold", 18));
        boroughName.setPrefSize(1030, 58);
        boroughName.setLayoutX(-1);
        boroughName.setLayoutY(-1);
        boroughName.setAlignment(javafx.geometry.Pos.CENTER);
        anchorPane.getChildren().add(boroughName);
        
        table = new TableView();
        table.setPrefSize(1030, 306);
        
        dateCol = new TableColumn("Date");
        dateCol.setPrefWidth(100);
        
        boroughCol = new TableColumn("Borough");
        boroughCol.setPrefWidth(200);
        
        retailAndRecreationCol = new TableColumn("Retail and Recreation");
        retailAndRecreationCol.setPrefWidth(130.4);
        
        groceryAndPharmacyCol = new TableColumn("Grocery and Pharmacy");
        groceryAndPharmacyCol.setMinWidth(1.6);
        groceryAndPharmacyCol.setPrefWidth(139.2);
        
        parksCol = new TableColumn("Parks");
        parksCol.setMinWidth(0.0);
        parksCol.setPrefWidth(44.8);
        
        transitStationsCol = new TableColumn("Transit Stations");
        transitStationsCol.setPrefWidth(100.8);
        
        workplacesCol = new TableColumn("Workplaces");
        workplacesCol.setPrefWidth(79.2);
        
        residentialCol = new TableColumn("Residential");
        residentialCol.setPrefWidth(76.8);
        
        newCasesCol = new TableColumn("New Cases");
        newCasesCol.setPrefWidth(82.4);
        
        totalCasesCol = new TableColumn("Total Cases");
        
        newDeathsCol = new TableColumn("New Deaths");
        newDeathsCol.setPrefWidth(86.4);
        
        totalDeathsCol = new TableColumn("Total Deaths");
        totalDeathsCol.setPrefWidth(83.2);
        
        table.getColumns().addAll(dateCol, boroughCol, retailAndRecreationCol, groceryAndPharmacyCol, parksCol, transitStationsCol,
                                workplacesCol, residentialCol, newCasesCol, totalCasesCol, newDeathsCol, totalDeathsCol);
        
        root.getChildren().addAll(anchorPane, table);
        
        getChildren().add(root);
    
    }
    
    public void initialize(MouseEvent event){
        // sets up the default values for each column and adds it to the table
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        boroughCol.setCellValueFactory(new PropertyValueFactory<>("borough"));
        retailAndRecreationCol.setCellValueFactory(new PropertyValueFactory<>("retailRecreationGMR"));
        groceryAndPharmacyCol.setCellValueFactory(new PropertyValueFactory<>("groceryPharmacyGMR"));
        parksCol.setCellValueFactory(new PropertyValueFactory<>("parksGMR"));
        transitStationsCol.setCellValueFactory(new PropertyValueFactory<>("transitGMR"));
        workplacesCol.setCellValueFactory(new PropertyValueFactory<>("workplacesGMR"));
        residentialCol.setCellValueFactory(new PropertyValueFactory<>("residentialGMR"));
        newCasesCol.setCellValueFactory(new PropertyValueFactory<>("newCases"));
        totalCasesCol.setCellValueFactory(new PropertyValueFactory<>("totalCases"));
        newDeathsCol.setCellValueFactory(new PropertyValueFactory<>("newDeaths"));
        totalDeathsCol.setCellValueFactory(new PropertyValueFactory<>("totalDeaths"));
        
        boroughName.setText(process.getFxidString(event));
        table.setItems(process.filterData(event));
    }
}
        
        
        
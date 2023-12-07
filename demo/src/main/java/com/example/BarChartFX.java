import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class BarChartFX extends Application {
    final static String prod1 = "Αυγά";
    final static String prod2 = "Μήλα";
    final static String prod3 = "Γάλα";
    final static String prod4 = "Πορτοκάλια";
    final static String prod5 = "Σαλάτες";
 
    @Override public void start(Stage stage) {
        stage.setTitle("Ποσότητα Προϊόντων");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Ποσότητα Προϊόντων");
        xAxis.setLabel("Όνομα Προϊόντος");       
        yAxis.setLabel("Ποσότητα");     
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("");
        series2.getData().add(new XYChart.Data(prod1, 90));
        series2.getData().add(new XYChart.Data(prod2, 23));
        series2.getData().add(new XYChart.Data(prod3, 56));
        series2.getData().add(new XYChart.Data(prod4, 73));
        series2.getData().add(new XYChart.Data(prod5, 44));  
        
 
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series2);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}

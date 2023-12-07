import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class LineChart extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("DAYS");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Quantity Product Monitoring, 2023");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 230));
        series.getData().add(new XYChart.Data(2, 140));
        series.getData().add(new XYChart.Data(3, 150));
        series.getData().add(new XYChart.Data(4, 240));
        series.getData().add(new XYChart.Data(5, 300));
        series.getData().add(new XYChart.Data(6, 330));
        series.getData().add(new XYChart.Data(7, 250));
        series.getData().add(new XYChart.Data(8, 380));
        series.getData().add(new XYChart.Data(9, 400));
        series.getData().add(new XYChart.Data(10, 270));
        series.getData().add(new XYChart.Data(11, 290));
        series.getData().add(new XYChart.Data(12, 250));
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}

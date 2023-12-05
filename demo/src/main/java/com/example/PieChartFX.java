import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.PieChart;

public class PieChartFX extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("ΠΡΟΙΟΝΤΑ");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Πορτοκάλια", 30),
                new PieChart.Data("Σαλάτες", 40),
                new PieChart.Data("Αυγά", 23),
                new PieChart.Data("Γάλα", 67),
                new PieChart.Data("Μήλα", 90));

        // Calculate total sum for percentage calculation
        double total = pieChartData.stream().mapToDouble(PieChart.Data::getPieValue).sum();

        // Format and set the percentage labels
        pieChartData.forEach(data -> {
            double percentage = (data.getPieValue() / total) * 100;
            data.setName(String.format("%s (%.2f%%)", data.getName(), percentage));
        });

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("ΠΡΟΙΟΝΤΑ");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); 
    }
}

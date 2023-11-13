import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import java.io.File;
import java.io.IOException;

public class ChartFile {
    public static void main(String[] args) {
        // Δημιουργία παραδείγματος γραφήματος
        JFreeChart chart = ChartFactory.createBarChart(
                "Παράδειγμα Γραφήματος",
                "Κατηγορίες",
                "Τιμές",
                null);

        // Αποθήκευση ως εικόνα PNG
        try {
            ChartUtilities.saveChartAsPNG(new File("chart.png"), chart, 400, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

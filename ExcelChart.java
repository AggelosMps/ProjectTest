import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
//Πρέπει να κατεβάσουμε στο maven την βιβλιοθήκη apache
public class ExcelChart {

    public static void main(String[] args) {
        try {
            // Δημιουργία ενός νέου workbook
            Workbook workbook = new XSSFWorkbook();

            // Δημιουργία ενός νέου φύλλου εργασίας
            Sheet sheet = workbook.createSheet("Δεδομένα");

            // Προσθήκη δεδομένων στο φύλλο εργασίας
            Row row1 = sheet.createRow(0);
            Cell cellA1 = row1.createCell(0);
            cellA1.setCellValue("Κατηγορία");

            Row row2 = sheet.createRow(1);
            Cell cellA2 = row2.createCell(0);
            cellA2.setCellValue("Κατηγορία 1");

            Row row3 = sheet.createRow(2);
            Cell cellA3 = row3.createCell(0);
            cellA3.setCellValue("Κατηγορία 2");

            Row row4 = sheet.createRow(3);
            Cell cellA4 = row4.createCell(0);
            cellA4.setCellValue("Κατηγορία 3");

            Row row5 = sheet.createRow(4);
            Cell cellA5 = row5.createCell(0);
            cellA5.setCellValue("Κατηγορία 4");

            Row row6 = sheet.createRow(5);
            Cell cellA6 = row6.createCell(0);
            cellA6.setCellValue("Κατηγορία 5");

            Row row7 = sheet.createRow(6);
            Cell cellA7 = row7.createCell(0);
            cellA7.setCellValue("Κατηγορία 6");

            Row row8 = sheet.createRow(7);
            Cell cellA8 = row8.createCell(0);
            cellA8.setCellValue("Κατηγορία 7");

            // Προσθήκη δεδομένων για το διάγραμμα
            Row rowValue = sheet.createRow(0);
            Cell cellB1 = rowValue.createCell(1);
            cellB1.setCellValue("Τιμές");

            for (int i = 1; i <= 7; i++) {
                Row dataRow = sheet.getRow(i);
                Cell dataCell = dataRow.createCell(1);
                dataCell.setCellValue(Math.random() * 100); // Τυχαίες τιμές για το παράδειγμα
            }

            // Δημιουργία διαγράμματος
            Drawing<?> drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 2, 1, 10, 15);

            Chart chart = drawing.createChart(anchor);
            ChartLegend legend = chart.getOrCreateLegend();
            legend.setPosition(LegendPosition.TOP_RIGHT);

            LineChartData data = chart.getChartDataFactory().createLineChartData();

            // Επιλέγουμε το εύρος των δεδομένων για το διάγραμμα
            ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
            ChartAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

            // Δημιουργία της σειράς δεδομένων
            ChartDataSource<Number> xs = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 7, 0, 0));
            ChartDataSource<Number> ys = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, 7, 1, 1));
            data.addSeries(xs, ys);

            // Προσθήκη των δεδομένων στο διάγραμμα
            chart.plot(data, bottomAxis, leftAxis);

            // Αποθήκευση του αρχείου Excel
            try (FileOutputStream fileOut = new FileOutputStream("Διάγραμμα_Παράδειγμα.xlsx")) {
                workbook.write(fileOut);
            }

            // Κλείσιμο του workbook
            workbook.close();

            System.out.println("Το αρχείο Excel με το διάγραμμα δημιουργήθηκε επιτυχώς.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

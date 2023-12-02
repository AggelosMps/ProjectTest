import javax.swing.*;
import java.awt.*;

public class BarChartWithoutFrame { 
 

    private static class DynamicTitledBarChartPanel extends JPanel {
        private String[] labels;
        private int[] values;
        private String chartTitle;

        private static final Color[] COLORS = {
                Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA
        };

        public DynamicTitledBarChartPanel(String[] labels, int[] values, String chartTitle) {
            this.labels = labels;
            this.values = values;
            this.chartTitle = chartTitle;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int barWidth = getWidth() / values.length;
            int maxValue = getMaxValue();

            // Calculate available free space
            int titleHeight = g.getFontMetrics().getHeight();
            int availableSpace = getHeight() - values.length * titleHeight - 10; // Adjust for margins

            // Choose a dynamic title position based on available space
            int titleY = Math.min(availableSpace / 2, 30);

            // Draw the chart title
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            int titleX = getWidth() / 2 - g.getFontMetrics().stringWidth(chartTitle) / 2;
            g.drawString(chartTitle, titleX, titleY);

            for (int i = 0; i < values.length; i++) {
                int barHeight = (int) (((double) values[i] / maxValue) * availableSpace);
                int x = i * barWidth;
                int y = getHeight() - barHeight;

                // Use a different color for each bar
                g.setColor(COLORS[i % COLORS.length]);
                g.fillRect(x, y, barWidth, barHeight);

                g.setColor(Color.BLACK);
                g.drawRect(x, y, barWidth, barHeight);

                // Draw the value inside the bar
                String value = String.valueOf(values[i]);
                g.setFont(new Font("Arial", Font.PLAIN, 20)); // Set font size for labels
                int valueX = x + barWidth / 2 - g.getFontMetrics().stringWidth(value) / 2;
                int valueY = y + barHeight / 2 + g.getFontMetrics().getHeight() / 2;
                g.drawString(value, valueX, valueY);

                // Draw the title on top of each bar
                String title = labels[i];
                int titleXInBar = x + barWidth / 2 - g.getFontMetrics().stringWidth(title) / 2;
                int titleYInBar = getHeight() - 5; // Adjust the Y position for the title
                g.drawString(title, titleXInBar, titleYInBar);
            }
        }

        private int getMaxValue() {
            int max = Integer.MIN_VALUE;
            for (int value : values) {
                if (value > max) {
                    max = value;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] labels = {"Label1", "Label2", "Label3", "Label4", "Label5"};
            int[] data = {20, 50, 80, 30, 60};
            String chartTitle = "My Dynamic Bar Chart";

            JFrame frame = new JFrame("Dynamic Titled Bar Chart Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);

            DynamicTitledBarChartPanel chartPanel = new DynamicTitledBarChartPanel(labels, data, chartTitle);
            frame.setContentPane(chartPanel);

            frame.setVisible(true);
        });
    }
}
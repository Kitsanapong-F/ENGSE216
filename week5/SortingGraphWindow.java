package week5;

import java.awt.*;
import java.util.Map;
import javax.swing.*;

/**
 * หน้าต่าง GUI แสดงกราฟเส้นเปรียบเทียบเวลา (t) กับขนาดข้อมูล (n)
 * แก้ไขปัญหากล่องสี่เหลี่ยม และคำนวณสเกลตัวเลขอัตโนมัติ
 */
public class SortingGraphWindow extends JFrame {

    public SortingGraphWindow(int[] sizes, Map<String, double[]> results) {
        setTitle("Sorting Algorithms Performance - [t vs n]");
        setSize(960, 680);
        setMinimumSize(new Dimension(750, 520));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GraphPanel panel = new GraphPanel(sizes, results);
        add(panel);
    }

    private static class GraphPanel extends JPanel {
        private final int[] sizes;
        private final Map<String, double[]> results;

        private final Color[] colors = {
            new Color(239, 68, 68),   // Bubble Sort: Red
            new Color(16, 185, 129),  // Selection Sort: Green
            new Color(245, 158, 11),  // Insertion Sort: Amber
            new Color(59, 130, 246)   // Quick Sort: Blue
        };

        private final String[] complexities = {
            "O(n²)",
            "O(n²)",
            "O(n²)",
            "O(n log n)"
        };

        public GraphPanel(int[] sizes, Map<String, double[]> results) {
            this.sizes = sizes;
            this.results = results;
            setBackground(new Color(248, 250, 252));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            int width = getWidth();
            int height = getHeight();

            // 1. Header (ใช้ภาษาอังกฤษเพื่อความเข้ากันได้ 100% ไม่เกิดกล่องสี่เหลี่ยม)
            g2.setFont(new Font("Segoe UI", Font.BOLD, 20));
            g2.setColor(new Color(15, 23, 42));
            g2.drawString("Sorting Algorithms Performance Comparison", 45, 42);

            g2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            g2.setColor(new Color(100, 116, 139));
            g2.drawString("Input Size (n) vs Execution Time (t in milliseconds)", 45, 62);

            int padLeft = 100;
            int padRight = 50;
            int padTop = 95;
            int padBottom = 80;

            int plotX = padLeft;
            int plotY = padTop;
            int plotW = width - padLeft - padRight;
            int plotH = height - padTop - padBottom;

            if (plotW <= 0 || plotH <= 0 || sizes.length == 0) return;

            // การ์ดกราฟสีขาว
            g2.setColor(Color.WHITE);
            g2.fillRoundRect(plotX - 15, plotY - 15, plotW + 30, plotH + 30, 16, 16);
            g2.setColor(new Color(226, 232, 240));
            g2.setStroke(new BasicStroke(1.2f));
            g2.drawRoundRect(plotX - 15, plotY - 15, plotW + 30, plotH + 30, 16, 16);

            // หาค่าเวลาสูงสุด
            double maxTime = 0.001;
            for (double[] times : results.values()) {
                for (double t : times) {
                    if (t > maxTime) maxTime = t;
                }
            }
            maxTime = maxTime * 1.15;

            // 2. วาดเส้นกริดแนวนอน และตัวเลขกำกับแกน Y
            Stroke dashedStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{4, 4}, 0);
            int yTicks = 5;
            for (int i = 0; i <= yTicks; i++) {
                int y = plotY + (int) (plotH * (1.0 - (double) i / yTicks));

                g2.setColor(new Color(241, 245, 249));
                g2.setStroke(dashedStroke);
                g2.drawLine(plotX, y, plotX + plotW, y);

                double val = (maxTime * i) / yTicks;
                String label;
                if (maxTime >= 1000) {
                    label = String.format("%.2f s", val / 1000.0);
                } else if (maxTime < 5) {
                    label = String.format("%.2f ms", val);
                } else if (maxTime < 100) {
                    label = String.format("%.1f ms", val);
                } else {
                    label = String.format("%,.0f ms", val);
                }

                g2.setColor(new Color(100, 116, 139));
                g2.setFont(new Font("Segoe UI", Font.BOLD, 11));
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(label, plotX - fm.stringWidth(label) - 15, y + 4);
            }

            // แกน Y และ X
            g2.setColor(new Color(203, 213, 225));
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawLine(plotX, plotY, plotX, plotY + plotH);
            g2.drawLine(plotX, plotY + plotH, plotX + plotW, plotY + plotH);

            g2.setFont(new Font("Segoe UI", Font.BOLD, 12));
            g2.setColor(new Color(71, 85, 105));
            g2.drawString("↑ Time t (ms)", plotX - 60, plotY - 20);
            g2.drawString("Data Size (n) →", plotX + plotW - 80, plotY + plotH + 45);

            // พิกัดแกน X
            int[] xCoords = new int[sizes.length];
            for (int i = 0; i < sizes.length; i++) {
                if (sizes.length == 1) {
                    xCoords[i] = plotX + plotW / 2;
                } else {
                    xCoords[i] = plotX + (int) ((double) i / (sizes.length - 1) * plotW);
                }

                g2.setColor(new Color(203, 213, 225));
                g2.drawLine(xCoords[i], plotY + plotH, xCoords[i], plotY + plotH + 6);

                String label = String.format("%,d", sizes[i]);
                g2.setColor(new Color(51, 65, 85));
                g2.setFont(new Font("Segoe UI", Font.BOLD, 12));
                FontMetrics fm = g2.getFontMetrics();
                g2.drawString(label, xCoords[i] - fm.stringWidth(label) / 2, plotY + plotH + 24);
            }

            // 3. วาดเส้นกราฟ
            int algoIndex = 0;
            for (Map.Entry<String, double[]> entry : results.entrySet()) {
                double[] times = entry.getValue();
                Color color = colors[algoIndex % colors.length];

                int[] yCoords = new int[times.length];
                for (int i = 0; i < times.length; i++) {
                    yCoords[i] = plotY + (int) (plotH * (1.0 - (times[i] / maxTime)));
                }

                g2.setColor(color);
                g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                if (times.length > 1) {
                    for (int i = 0; i < times.length - 1; i++) {
                        g2.drawLine(xCoords[i], yCoords[i], xCoords[i + 1], yCoords[i + 1]);
                    }
                }

                // จุดข้อมูล
                for (int i = 0; i < times.length; i++) {
                    int x = xCoords[i];
                    int y = yCoords[i];

                    g2.setColor(color);
                    g2.fillOval(x - 6, y - 6, 12, 12);
                    g2.setColor(Color.WHITE);
                    g2.fillOval(x - 3, y - 3, 6, 6);

                    // แสดงตัวเลขเวลา
                    String timeText = String.format("%.2f ms", times[i]);
                    g2.setFont(new Font("Segoe UI", Font.BOLD, 11));
                    g2.setColor(color);
                    g2.drawString(timeText, x - 15, y - 10);
                }
                algoIndex++;
            }

            // 4. Legend Box
            int legendW = 210;
            int legendH = results.size() * 26 + 16;
            int legendX = plotX + 25;
            int legendY = plotY + 15;

            g2.setColor(new Color(241, 245, 249, 230));
            g2.fillRoundRect(legendX, legendY, legendW, legendH, 12, 12);
            g2.setColor(new Color(203, 213, 225));
            g2.setStroke(new BasicStroke(1));
            g2.drawRoundRect(legendX, legendY, legendW, legendH, 12, 12);

            algoIndex = 0;
            for (String algoName : results.keySet()) {
                Color color = colors[algoIndex % colors.length];
                String comp = complexities[algoIndex % complexities.length];
                int itemY = legendY + 22 + (algoIndex * 26);

                g2.setColor(color);
                g2.fillOval(legendX + 14, itemY - 9, 10, 10);

                g2.setColor(new Color(30, 41, 59));
                g2.setFont(new Font("Segoe UI", Font.BOLD, 12));
                g2.drawString(algoName, legendX + 32, itemY);

                g2.setColor(new Color(100, 116, 139));
                g2.setFont(new Font("Segoe UI", Font.ITALIC, 11));
                g2.drawString(comp, legendX + 140, itemY);

                algoIndex++;
            }
        }
    }
}

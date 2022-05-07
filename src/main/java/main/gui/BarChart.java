package main.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class BarChart extends JPanel {

    private Color[] COLOURS = new Color[]{
            new Color(245, 66, 87),
            new Color(155, 155, 0),
            new Color(66, 245, 150),
            new Color(66, 135, 245),
            new Color(156, 66, 245)
    };
    private Integer[] values;
    private String[] names;
    private String title;

    BarChart(Integer[] values, String[] names, String title){
        if(values.length > 6){
            this.values = Arrays.copyOfRange(values, 0, 6);
        }else {
            this.values = values;
        }
        if(names.length > 6){
            this.names = Arrays.copyOfRange(names, 0, 6);
        }else {
            this.names = names;
        }
        this.title = title;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (values == null || values.length == 0)
            return;

        double minValue = 0;
        double maxValue = 0;

        for (int i = 0; i < values.length; i++) {
            if (minValue > values[i])
                minValue = values[i];
            if (maxValue < values[i])
                maxValue = values[i];
        }

        Dimension d = getSize();
//        Dimension d = new Dimension(200, 400);
        int clientWidth = d.width;
        int clientHeight = d.height;
        int barWidth = clientWidth / values.length;

        Font titleFont = new Font("SansSerif", Font.BOLD, 20);
        FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
        FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

        int titleWidth = titleFontMetrics.stringWidth(title);
        int y = titleFontMetrics.getAscent();
        int x = (clientWidth - titleWidth) / 2;
        g.setFont(titleFont);
        g.drawString(title, x, y);

        int top = titleFontMetrics.getHeight();
        int bottom = labelFontMetrics.getHeight();
        if (maxValue == minValue)
            return;
        double scale = (clientHeight - top - bottom) / (maxValue - minValue);
        y = clientHeight - labelFontMetrics.getDescent();
        g.setFont(labelFont);

        for (int i = 0; i < values.length; i++) {
            int valueX = i * barWidth;
            int valueY = top;
            int height = (int) (values[i] * scale);
            if (values[i] >= 0)
                valueY += (int) ((maxValue - values[i]) * scale);
            else {
                valueY += (int) (maxValue * scale);
                height = -height;
            }

            g.setColor(COLOURS[i % 5]);
            g.fillRect(valueX, valueY, barWidth - 2, height);
            g.setColor(Color.black);
//            g.drawRect(valueX, valueY, barWidth - 2, height);
            int labelWidth = labelFontMetrics.stringWidth(names[i]);
            x = i * barWidth + (barWidth - labelWidth) / 2;
            g.drawString(names[i], x, y);
        }
    }

}


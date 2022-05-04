package main.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BasePanel extends JPanel {

    private final String resourcePath = "/Users/anastasiiamazur/IdeaProjects/cw2-software-group-proj/src/main/resources/";
    private JPanel headerPanel;
    private JPanel mainPanel;
    private JPanel footerPanel;

    private BufferedImage france, spain, germany;
    private JLabel franceLabel, spainLabel, germanyLabel;

    public BasePanel(){
        super();
        this.setLayout(new BorderLayout());

        headerPanel = new JPanel();
        mainPanel = new JPanel();
        footerPanel = new JPanel();

        try {
            france = ImageIO.read(new File(resourcePath + "france.png"));
            germany = ImageIO.read(new File(resourcePath + "germany.png"));
            spain = ImageIO.read(new File(resourcePath + "spain.jpeg"));
        } catch (IOException e) {
            System.out.println("Unable to load images from the file system...");
            throw new RuntimeException(e);
        }

        franceLabel = new JLabel(new ImageIcon(fitimage(france, 100, 50)));
        germanyLabel = new JLabel(new ImageIcon(fitimage(germany, 100, 50)));
        spainLabel = new JLabel(new ImageIcon(fitimage(spain, 100, 50)));

        franceLabel.setSize(200, 100);
        germanyLabel.setSize(200, 100);
        spainLabel.setSize(200, 100);

        headerPanel.setLayout(new FlowLayout());
        headerPanel.setBackground(new Color(73, 133, 245));

        headerPanel.add(germanyLabel);
        headerPanel.add(spainLabel);
        headerPanel.add(franceLabel);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);


    }

    private Image fitimage(Image img , int w , int h)
    {
        BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0,w,h,null);
        g2.dispose();
        return resizedimage;
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public void setHeaderPanel(JPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getFooterPanel() {
        return footerPanel;
    }

    public void setFooterPanel(JPanel footerPanel) {
        this.footerPanel = footerPanel;
    }
}
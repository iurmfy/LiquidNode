package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;

/**
 * 一般渲染器
 *
 * JComponent 可以使其透明
 */
public class LqRender extends JComponent
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image image = new ImageIcon("resources/Demo.JPG").getImage();
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(image, 0,0,100,100,this);
    }
}

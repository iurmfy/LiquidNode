package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;

/**
 * lq 渲染器
 * 对窗体内容对加载
 * 使用 Canvas 放置在JFrame
 *
 * 流式布局
 */
public class LqRender extends JPanel
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Image image = Toolkit.getDefaultToolkit().getImage("resources/Demo.JPG");
        g2.drawImage(image,50, 0,
                image.getWidth(this)/8 ,
                image.getHeight(this)/8,this);
    }
}

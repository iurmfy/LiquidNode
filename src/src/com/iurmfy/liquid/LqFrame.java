package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;

/*
 * Lq 展示窗体
 */
public class LqFrame extends JFrame
{
    public LqFrame()
    {
        int width = 400;
        int height = 400;

        setTitle("Liquid Node");
        setSize(width,height);
        //setUndecorated(true);

        // 获取屏幕尺寸
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        setLocation((screenWidth - width)/2,(screenHeight - height)/2);

        //add(new LqRender());
        LqRender render = new LqRender();
        //render.repaint();
        setUndecorated(true);

        this.setBackground(new Color(0,0,0,0));
        add(render);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * lq 的编辑器界面
 */
public class LqEditorFrame extends JFrame
{
    // 窗体初始化
    public LqEditorFrame()
    {
        // 窗体大小
        int width = 1200;
        int height = 700;

        setSize(width, height);
        setLocation(toMiddle(width, height));
        setTitle("Liquid Node Editor");

        // 加载渲染器
        LqRender render = new LqRender();

        render.addLqNode(new LqNode("resources/Demo.JPG", render));
        render.addLqNode(new LqNode("resources/people.png", render));

        //render.add(new JButton("HelloWorld"));

        //render.setLayout(new FlowLayout());
        // 为渲染器添加事件
        render.addMouseMotionListener(new LqNodeMotionListener());
        render.addMouseListener(new LqNodeMotionListener());

        add(render);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // 使窗体局中
    private Point toMiddle(int frameWidth, int frameHeight)
    {
        // 获取屏幕尺寸
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();

        return new Point((screenWidth - frameWidth)/2,(screenHeight - frameHeight)/2);
    }
}

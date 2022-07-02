package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;

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

        // 获取屏幕尺寸
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();
        // 使窗口居中
        setLocation((screenWidth - width)/2,(screenHeight - height)/2);

        setTitle("Liquid Node Editor");

        // 加载渲染器
        LqEditorRender render = new LqEditorRender();
        render.addLqNode(new LqNode("resources/Demo.JPG", render));
        render.setLqNodeDimension(0, 8);
        render.add(new JButton("HelloWorld"));

        //render.setLayout(new FlowLayout());
        // 为渲染器添加事件
        render.addMouseMotionListener(new LqNodeMotionListener());
        render.addMouseListener(new LqNodeMotionListener());

        add(render);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

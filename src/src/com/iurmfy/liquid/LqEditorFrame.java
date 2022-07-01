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
        int width = 450;
        int height = 350;

        setSize(width, height);
        setLocation(toMiddle(width, height));
        setTitle("Liquid Node Editor");

        // 加载渲染器
        LqRender render = new LqRender();
        render.setLayout(new FlowLayout());
        add(render);

        render.add(new JButton("G"));

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

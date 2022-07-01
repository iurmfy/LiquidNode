package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * lq 渲染器
 * 对窗体内容对加载
 * 使用 JPanel 放置在JFrame
 *
 * 因为不仅要放图片 还要放控件
 * 所以使用了JPanel
 */
public class LqRender extends JPanel
{
    private LqPart lqPart = new LqPart("resources/Demo.JPG",
            new Point(50,100), this);

    // 图片的当前位置
    private Point imageNowPoint = new Point();

    // 每次拖拽开始时图片的位置（也就是上次拖拽后的位置）
    private Point imageStartPoint = new Point();

    // 每次拖拽开始时鼠标的位置
    private Point mouseStartPoint = new Point();

    // 拖拽状态
    private enum DragStatus {Ready, Dragging}
    private DragStatus status = DragStatus.Ready;

    public LqRender()
    {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }
            // 按下鼠标时，更改状态，并且记录拖拽起始位置
            @Override
            public void mousePressed(MouseEvent e)
            {
                if (status == DragStatus.Ready)
                {
                    status = DragStatus.Dragging;
                    mouseStartPoint = e.getPoint();
                    imageStartPoint.setLocation(imageNowPoint.getLocation());
                }
            }
            // 松开鼠标时更改状态
            @Override
            public void mouseReleased(MouseEvent e)
            {
                if (status == DragStatus.Dragging)
                {
                    status = DragStatus.Ready;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

        //拖拽事件，在这个事件中移动图片位置
        addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                if (status == DragStatus.Dragging)
                {
                    moveImage(e.getPoint());
                }
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(lqPart.getImage(),
                lqPart.getImagePoint().x,
                lqPart.getImagePoint().y,
                lqPart.getDimension().width/8,
                lqPart.getDimension().height/8,
                this);
    }

    /**
     * 移动图片。实际上画图工作在 paintComponent() 中进行，这里只是计算图片位置，然后调用该方法。
     *
     * @param point 当前的鼠标位置
     */
    private void moveImage(Point point)
    {
        // 图片的当前位置等于图片的起始位置加上鼠标位置的偏移量。
        lqPart.getImagePoint().setLocation(
                imageStartPoint.getX() + (point.getX() - mouseStartPoint.getX()),
                imageStartPoint.getY() + (point.getY() - mouseStartPoint.getY())
        );
        repaint();
    }

}

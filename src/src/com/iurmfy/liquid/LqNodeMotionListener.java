package com.iurmfy.liquid;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * 节点移动事件
 *
 * 实现图像的移动
 */
public class LqNodeMotionListener implements MouseListener ,MouseMotionListener
{

    @Override
    public void mouseDragged(MouseEvent e)
    {
        System.out.println(e.getX());
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {

    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}

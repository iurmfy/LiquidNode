package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 编辑渲染器
 * 对窗体内容对加载
 * 使用 JPanel 放置在JFrame
 *
 * 因为不仅要放图片 还要放控件
 * 所以使用了JPanel
 * JPanel 无法透明
 */
public class LqEditorRender extends JPanel
{
    // 等待渲染的对象
    private final List<LqNode> renderBuffer;
    // 待渲染的物体与渲染器功能耦合
    // renderBuffer 需要一个单独类型

    public LqEditorRender()
    {
        renderBuffer = new ArrayList<>();
    }

    //public List<LqNode> getRenderBuffer()
    //{
    //    return renderBuffer;
    //}

    //public void setRenderBuffer(List<LqNode> renderBuffer)
    //{
    //    this.renderBuffer = renderBuffer;
    //}

    public void addLqNode(LqNode lqNode)
    {
        this.renderBuffer.add(lqNode);
    }

    //public void addLqNodeList(List<LqNode> lqNodes)
    //{
     //   this.renderBuffer.addAll(lqNodes);
    //}

    /**
     * 渲染对象放大/缩小 scale 倍
     * 当 scale > 1 缩小
     * 反之放大
     * @param scale 放大/缩小倍数
     */
    public void setLqNodeDimension(int index, double scale)
    {
        Dimension restDime = new Dimension(
                (int) (renderBuffer.get(index).getImageDimension().width/scale),
                (int) (renderBuffer.get(index).getImageDimension().height/scale));
        setLqNodeDimension(index, restDime);
    }

    public void setLqNodeDimension(int index, Dimension dimension)
    {
        LqNode rest = this.renderBuffer.get(index);
        rest.setImageDimension(dimension);
        this.renderBuffer.set(index, rest);
        repaint();
    }

    /*
     * 渲染对象平移 trans
     * 当 trans > 0 向右
     * 反之向左
     */
    /*public void setLqNodePoint(int index, int trans)
    {
        Point restPoint = new Point(
                renderBuffer.get(index).getImagePoint().x + trans,
                renderBuffer.get(index).getImagePoint().y + trans
        );
        setLqNodePoint(index, restPoint);
    }
    public void setLqNodePoint(int index, Point point)
    {
        LqNode rest = this.renderBuffer.get(index);
        rest.setImagePoint(point);
        this.renderBuffer.set(index, rest);
        repaint();
    }*/


    /**
     * 渲染主体
     *
     * 用于LqNode对象的渲染
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        this.setBackground(Color.BLACK);

        for (LqNode node : renderBuffer)
        {
            g2.drawImage(node.getImage(),
                    node.getImagePoint().x,
                    node.getImagePoint().y,
                    node.getImageDimension().width,
                    node.getImageDimension().height,
                    this);
        }
    }


}

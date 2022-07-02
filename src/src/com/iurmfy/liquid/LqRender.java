package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 渲染器
 * 对窗体内容对加载
 * 使用 JPanel 放置在JFrame
 *
 * 因为不仅要放图片 还要放控件
 * 所以使用了JPanel
 */
public class LqRender extends JPanel
{
    // 等待渲染的对象
    private List<LqNode> renderBuffer;

    public LqRender()
    {
        renderBuffer = new ArrayList<>();
    }

    public List<LqNode> getRenderBuffer()
    {
        return renderBuffer;
    }

    public void setRenderBuffer(List<LqNode> renderBuffer)
    {
        this.renderBuffer = renderBuffer;
    }

    public void addLqNode(LqNode lqNode)
    {
        this.renderBuffer.add(lqNode);
    }

    public void addLqNodeList(List<LqNode> lqNodes)
    {
        this.renderBuffer.addAll(lqNodes);
    }

    /**
     * 渲染对象放大/缩小 scale 倍
     * 当 scale > 1 放大
     * 反之缩小
     * @param scale 放大/缩小倍数
     */
    public void setLqNodeDimension(int index, int scale)
    {
        Dimension restDime = new Dimension(
                renderBuffer.get(index).getDimension().width/scale,
                renderBuffer.get(index).getDimension().height/scale
        );
        setLqNodeDimension(index, restDime);
    }

    /**
     * 渲染对象平移 trans
     * 当 trans > 0 向右
     * 反之向左
     * @param trans 平移大小
     */
    public void setLqNodePoint(int index, int trans)
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
    }

    public void setLqNodeDimension(int index, Dimension dimension)
    {
        LqNode rest = this.renderBuffer.get(index);
        rest.setDimension(dimension);
        this.renderBuffer.set(index, rest);
    }
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
                    node.getDimension().width,
                    node.getDimension().height,
                    this);
        }
    }


}

package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * lq 节点对象
 *
 * 在渲染器中渲染
 * 出现在窗体中
 */
public class LqNode
{
    // 图像内容
    private Image image;
    // 坐标
    private Point point = new Point();
    // 图像的范围
    private Dimension dimension = new Dimension();

    public LqNode(String filePath, ImageObserver imageObserver)
    {
        // 加载图片
        image = new ImageIcon(filePath).getImage();
        dimension.setSize(image.getWidth(imageObserver)
                ,image.getHeight(imageObserver));
        point.setLocation(new Point());
    }

    public LqNode(String filePath, Point imagePoint, ImageObserver imageObserver)
    {
        // 加载图片
        image = new ImageIcon(filePath).getImage();
        dimension.setSize(image.getWidth(imageObserver)
                ,image.getHeight(imageObserver));
        point.setLocation(imagePoint);
    }

    public void setDimension(Dimension dimension)
    {
        this.dimension = dimension;
    }

    public Dimension getDimension()
    {
        return dimension;
    }

    public void setImagePoint(Point imagePoint)
    {
        point = imagePoint;
    }

    public Point getImagePoint()
    {
        return point;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }
}

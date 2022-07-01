package com.iurmfy.liquid;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

/**
 * 在渲染器中渲染
 * 出现在窗体中
 *
 * 人物身体的一部分
 */
public class LqPart
{
    // 图像内容
    private Image image;
    // 坐标
    private Point point = new Point();
    // 图像的范围
    private Dimension dimension = new Dimension();

    public LqPart(String filePath, Point imagePoint, ImageObserver imageObserver)
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

    public void imageMoveTo(Point point)
    {
        point.x += point.x;
        point.y += point.y;
    }

    public void imageMoveTo(int pX, int pY)
    {
        point.x += pX;
        point.y += pY;
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

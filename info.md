# 目标实现



#### 7.1 

1. 窗体实现(编辑器)

2. 图像加载



窗体实现

```java
/*实现窗体居于中间*/

// 屏幕尺寸
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
int screenWidth = (int)screenSize.getWidth();
int screenHeight = (int)screenSize.getHeight();
// 确保窗口在屏幕中央
setLocation((screenWidth - WIDTH)/2,(screenHeight - HEIGHT)/2);

```

图片绘制

```java
/* Canvas 画布工具实现渲染 */

public class LqRender extends Canvas
{
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        Image image = Toolkit.getDefaultToolkit().getImage("resources/Demo.JPG");
        g2.drawImage(image, 0, 0, image.getWidth(this)/8, image.getHeight(this)/8, this);
    }
}
```


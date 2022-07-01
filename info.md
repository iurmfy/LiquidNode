

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

```java
/*JComponent*/

JPanel contentPane = new JPanel(); 
//把其它组件添加到Jpanel中; 
frame.setContentPane(contentPane); 
//把contentPane对象设置成为frame的内容面板 
```

建立一个Jpanel或 JDesktopPane之类的中间容器，把组件添加到容器中，用setContentPane()方法把该容器置为JFrame的内容面板

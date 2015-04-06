package cn.com.bugmanager.util;

import ch.qos.logback.core.joran.action.ActionConst;
import com.sun.java.util.jar.pack.*;

import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;

/**
 * Created by fcs on 2015/4/6.
 *
 * 图像裁剪工具，与Jcrop 合用
 */
public class ImageUtils {

    /**
     * 裁剪头像
     * @return
     */
    public String cutImage(){
       // HttpServletRequest  request = ActionContext.getContext()
        return null;
    }


    /**
     * 图片切割
     * @param imagePath 原图地址
     * @param x  目标切片坐标 X轴起点
     * @param y  目标切片坐标 y轴起点
     * @param w  目标切片 宽度
     * @param h  目标切片 高度
     */
    public void cutImage(String imagePath,int x, int y,int w,int h){
        try {
            Image img;
            ImageFilter  cropFilter;
            //读取源图片
            BufferedImage bi = ImageIO.read(new File(imagePath));
            int srcWidth = bi.getWidth();    //源图宽度
            int srcHeight = bi.getHeight();  //源图高度

            //若图片大小大于切片大小，则进行切割
            if(srcWidth >= w && srcHeight >=h){
                Image  image = bi.getScaledInstance(srcWidth,srcHeight,Image.SCALE_DEFAULT);
                int x1 = x*srcWidth/400;
                int y1 = y*srcHeight/270;
                int w1 = w*srcWidth/400;
                int h1 = h*srcHeight/270;
                cropFilter = new CropImageFilter(x1,y1,w1,h1);

                img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(),cropFilter));
                BufferedImage tag = new BufferedImage(w1,h1,BufferedImage.TYPE_INT_RGB);
                Graphics g= tag.getGraphics();
                g.drawImage(img,0,0,null);    //绘制缩小后的图
                g.dispose();

                //输出为文件

                ImageIO.write(tag,"JPEG",new File(imagePath));






            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

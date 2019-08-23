package com.example.matrixtransformation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by Administrator on 2017/5/22.
 */
public class ImageHealp {

   //                                                   色相，饱和度，亮度
    public static Bitmap newImage(Bitmap bitmap,float hue,float saturability,float luminance){
        Bitmap bitmap1=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap1);
        //                          抗锯齿
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);

        ColorMatrix hueColorMatrix=new ColorMatrix();
        hueColorMatrix.setRotate(0,hue);
        hueColorMatrix.setRotate(1,hue);
        hueColorMatrix.setRotate(2,hue);

        ColorMatrix saturabilityMatrix=new ColorMatrix();
        saturabilityMatrix.setSaturation(saturability);

        ColorMatrix luminanceMatrix=new ColorMatrix();
        luminanceMatrix.setScale(luminance,luminance,luminance,1);

        ColorMatrix imageMatrix=new ColorMatrix();
        imageMatrix.postConcat(hueColorMatrix);
        imageMatrix.postConcat(saturabilityMatrix);
        imageMatrix.postConcat(luminanceMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        canvas.drawBitmap(bitmap,0,0,paint);
        return bitmap1;
    }
    //底片效果
    public static Bitmap handleImageNetivage(Bitmap bitmap){
        int widths=bitmap.getWidth();
        int heigths=bitmap.getHeight();
        int count=widths*heigths;
        int color;
        int r,g,b,a;
        Bitmap bmp=Bitmap.createBitmap(widths,heigths, Bitmap.Config.ARGB_8888);

        int[] oldPx=new int[count];
        int[] newPx=new int[count];
        bitmap.getPixels(oldPx,0,widths,0,0,widths,heigths);
        for (int i = 0; i < count; i++) {
            color=oldPx[i];
            r= Color.red(color);
            g= Color.green(color);
            b= Color.blue(color);
            a= Color.alpha(color);
            //底片效果
            r=255-r;
            g=255-g;
            b=255-b;

            if (r>255){
                r=255;
            }else if (r<0){
                r=0;
            }
            if (g>255){
                g=255;
            }else if (g<0){
                g=0;
            }
            if (b>255){
                b=255;
            }else if (b<0){
                b=0;
            }
            //保存新的像素点
            newPx[i]=Color.argb(a,r,g,b);
        }
        bmp.setPixels(newPx,0,widths,0,0,widths,heigths);
        return bmp;
    }

    //怀旧效果
    public static Bitmap handleImageHuai(Bitmap bitmap){
        int widths=bitmap.getWidth();
        int heigths=bitmap.getHeight();
        int count=widths*heigths;
        int color;
        int r,g,b,a,r1,g1,b1;
        Bitmap bmp=Bitmap.createBitmap(widths,heigths, Bitmap.Config.ARGB_8888);

        int[] oldPx=new int[count];
        int[] newPx=new int[count];
        bitmap.getPixels(oldPx,0,widths,0,0,widths,heigths);
        for (int i = 0; i < count; i++) {
            color=oldPx[i];
            r= Color.red(color);
            g= Color.green(color);
            b= Color.blue(color);
            a= Color.alpha(color);
            //算法
           r1=(int)(0.393*r+0.769*g+0.189*b);
           g1=(int)(0.349*r+0.686*g+0.168*b);
           b1=(int)(0.272*r+0.534*g+0.131*b);

            if (r1>255){
                r1=255;
            }
            if (g1>255){
                g1=255;
            }
            if (b1>255){
                b1=255;
            }
            //保存新的像素点
            newPx[i]=Color.argb(a,r1,g1,b1);
        }
        bmp.setPixels(newPx,0,widths,0,0,widths,heigths);
        return bmp;
    }

    //浮雕效果
    public static Bitmap handleImageFu(Bitmap bitmap){
        int widths=bitmap.getWidth();
        int heigths=bitmap.getHeight();
        int count=widths*heigths;
        int color=0,ColorBefore=0;
        int r,g,b,a;
        int r1,g1,b1;
        Bitmap bmp=Bitmap.createBitmap(widths,heigths, Bitmap.Config.ARGB_8888);

        int[] oldPx=new int[count];
        int[] newPx=new int[count];
        bitmap.getPixels(oldPx,0,widths,0,0,widths,heigths);
        for (int i = 1; i < count; i++) {
            ColorBefore=oldPx[i-1];
            r= Color.red(ColorBefore);
            g= Color.green(ColorBefore);
            b= Color.blue(ColorBefore);
            a= Color.alpha(ColorBefore);

            color=oldPx[i];
            r1= Color.red(color);
            g1= Color.green(color);
            b1= Color.blue(color);

            //算法
           r=(r-r1+127);
           g=(g-g1+127);
           b=(b-b1+127);

            if (r>255){
                r=255;
            }
            if (g>255){
                g=255;
            }
            if (b>255){
                b=255;
            }
            //保存新的像素点
            newPx[i]=Color.argb(a,r,g,b);
        }
        bmp.setPixels(newPx,0,widths,0,0,widths,heigths);
        return bmp;
    }
}

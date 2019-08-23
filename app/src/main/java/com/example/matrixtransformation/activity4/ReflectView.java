package com.example.matrixtransformation.activity4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.matrixtransformation.R;


/**
 * Created by Administrator on 2017/5/24.
 */
public class ReflectView extends View{

    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Paint mPaint;
    public ReflectView(Context context) {
        super(context);
        initView();
    }

    public ReflectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ReflectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView(){
        bitmap1= BitmapFactory.decodeResource(getResources(), R.mipmap.text5);
        Matrix matrix=new Matrix();
        //缩放
        matrix.setScale(1,-1);  //通过矩阵 X不变，Y为相反数。则实现了，以X轴对称的图像。
        bitmap2=Bitmap.createBitmap(bitmap1,0,0,bitmap1.getWidth(),bitmap1.getHeight(),matrix,true);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        //*1.7F为倒影的高度值
        //两个颜色值 为渐变颜色的起始颜色
        mPaint.setShader(new LinearGradient(0,bitmap1.getHeight(),0,bitmap1.getHeight()*1.7F,
                0xDD000000,0x10000000, Shader.TileMode.CLAMP));
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //给定画布背景颜色
        canvas.drawColor(Color.GRAY);
        canvas.drawBitmap(bitmap1,0,0,null);
        canvas.drawBitmap(bitmap2,0,bitmap1.getHeight(),null);
        canvas.drawRect(0,bitmap2.getHeight(),bitmap2.getWidth(),bitmap2.getHeight()*2,mPaint);

    }
}

package com.example.matrixtransformation.activity2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.matrixtransformation.R;


/**
 * Created by Administrator on 2017/5/23.
 */
public class YuanView extends View{
    /**
     * 图片
     * 绘制圆角矩形
     */
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Paint paint;

    public YuanView(Context context) {
        super(context);
        initView();
    }

    public YuanView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public YuanView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void initView(){
        setLayerType(LAYER_TYPE_SOFTWARE,null);      //停止硬件加速，因为Xfermode并不一定支持
        bitmap1= BitmapFactory.decodeResource(getResources(), R.drawable.text2);
        bitmap2=Bitmap.createBitmap(bitmap1.getWidth(),bitmap1.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap2);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        //画笔风格--Xfermode
        //Dst  为先画的
//        //圆角矩形
//        canvas.drawRoundRect(0,0,bitmap1.getWidth(),bitmap1.getHeight(),50,50,paint);   //遮罩层
        //圆角
        //前三个参数为：x,y坐标偏移量   圆的大小
        canvas.drawCircle(260,200,180,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        //Src  为后画的
        canvas.drawBitmap(bitmap1,0,0,paint);
        paint.setXfermode(null);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap2,0,0,null);
    }
}


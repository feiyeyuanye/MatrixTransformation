package com.example.matrixtransformation.activity3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.matrixtransformation.R;

/**
 * Created by Administrator on 2017/5/24.
 */
public class BitmapShaderView extends View{

    private Bitmap bitmap;
    private BitmapShader bitmapShader;
    private Paint mPaint;

    public BitmapShaderView(Context context) {
        super(context);

    }

    public BitmapShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    public BitmapShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.text1);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
//        Shader.TileMode.REPEAT    重复    当图片无法铺满全屏时，则重复复制图片摆放
//        Shader.TileMode.CLAMP     拉伸    使用图片的右侧和下方最后一个像素点进行拉伸。如果为白色，则看不出效果。
//        Shader.TileMode.MIRROR    镜像    当图片无法铺满全屏时，则重复复制图片摆放。但相邻两行为镜像放置。
        bitmapShader=new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        mPaint.setShader(bitmapShader);
        canvas.drawCircle(300,200,2000,mPaint);
        //只显示了绘制的区域，其他部分则隐藏掉了、
    }


}

package com.example.matrixtransformation.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

import com.example.matrixtransformation.R;


/**
 * Created by Administrator on 2017/5/23.
 */
public class ImageChangeView extends View{

    private Bitmap bitmap;
    private Matrix matrix;

    public ImageChangeView(Context context) {
        super(context);
        initView();
    }

    public ImageChangeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    private void initView(){
        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        restoreImage(new Matrix());
    }
    public void restoreImage(Matrix matrix){
        this.matrix=matrix;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,null);      //原图
        canvas.drawBitmap(bitmap,matrix,null);   //对比图
    }
}

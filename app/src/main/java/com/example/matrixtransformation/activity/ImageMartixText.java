package com.example.matrixtransformation.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.matrixtransformation.R;
import com.example.matrixtransformation.activity2.YuanJiaoActivity;
import com.example.matrixtransformation.activity3.BitmapShaderActivity;
import com.example.matrixtransformation.activity4.ReflectActivity;

/**
 * Created by Administrator on 2017/5/23.
 */
public class ImageMartixText extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagetext);
    }

    /**
     * 矩阵变换
     * @param view
     */
    public void ImageMartix(View view){
        startActivity(new Intent(this,ImageMartixChange.class));
    }
    /**
     * Xfermode
     * @param view
     */
    public void Xfermode(View view){
        startActivity(new Intent(ImageMartixText.this, YuanJiaoActivity.class));
    }
    /**
     * BitmapShader
     * @param view
     */
    public void BitmapShader(View view){
        startActivity(new Intent(ImageMartixText.this, BitmapShaderActivity.class));
    }
    /**
     * ReflectView
     * @param view
     */
    public void ReflectView(View view){
        startActivity(new Intent(ImageMartixText.this, ReflectActivity.class));
    }


}

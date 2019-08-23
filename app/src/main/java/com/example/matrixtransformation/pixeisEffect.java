package com.example.matrixtransformation;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/5/23.
 */
public class pixeisEffect extends Activity{

    private ImageView imageView1,imageView2,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_pixeis);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.text3);
        imageView1= (ImageView) findViewById(R.id.iv_image1);
        imageView2= (ImageView) findViewById(R.id.iv_image2);
        imageView3= (ImageView) findViewById(R.id.iv_image3);
        imageView4= (ImageView) findViewById(R.id.iv_image4);

        imageView1.setImageBitmap(bitmap);                                         //原图
        imageView2.setImageBitmap(ImageHealp.handleImageNetivage(bitmap));         //底片
        imageView3.setImageBitmap(ImageHealp.handleImageHuai(bitmap));             //怀旧
        imageView4.setImageBitmap(ImageHealp.handleImageFu(bitmap));               //浮雕


    }
}

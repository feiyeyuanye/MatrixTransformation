package com.example.matrixtransformation;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/5/23.
 */
public class ColorMartix extends Activity{

    private ImageView imageView;
    private GridLayout gridLayout;
    private Bitmap bitmap;
    private int mGridWidth,mGridheight;
    private EditText[] edits=new EditText[20];
    private float[] editInts=new float[20];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colormartix);
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.text2);
        imageView= (ImageView) findViewById(R.id.imageview);
        gridLayout= (GridLayout) findViewById(R.id.gd_editText);
        imageView.setImageBitmap(bitmap);
        gridLayout.post(new Runnable() {
            @Override
            public void run() {
                mGridWidth=gridLayout.getWidth()/5;
                mGridheight=gridLayout.getHeight()/4;
                addEdit();
                initMartix(); //赋值
            }
        });
    }
    private void getMartix(){
        for (int i = 0; i < 20; i++) {
            editInts[i]=Float.valueOf(edits[i].getText().toString());
        }

    }
    private void setImageMartix(){
        Bitmap bmp=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMartix=new ColorMatrix();
        colorMartix.set(editInts);

        Canvas canvas=new Canvas(bmp);
        Paint paint=new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMartix));
        canvas.drawBitmap(bitmap,0,0,paint);

        imageView.setImageBitmap(bmp);
    }
    public void leftButton(View view){
        getMartix();
        setImageMartix();
    }
    public void rightButton(View view){
        initMartix();
        getMartix();
        setImageMartix();
    }

    private void addEdit(){
        for (int i = 0; i < 20; i++) {
            EditText e=new EditText(ColorMartix.this);
            e.setGravity(Gravity.CENTER);
            edits[i]=e;
            gridLayout.addView(e,mGridWidth,mGridheight);
        }
    }

    private void initMartix(){
        for (int i = 0; i < 20; i++) {
            if (i%6==0){
                edits[i].setText("1");
            }else {
                edits[i].setText("0");
            }
        }
    }
}

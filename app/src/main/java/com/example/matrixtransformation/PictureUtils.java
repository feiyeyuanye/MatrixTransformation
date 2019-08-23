package com.example.matrixtransformation;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by Administrator on 2017/5/22.
 */
public class PictureUtils extends Activity implements SeekBar.OnSeekBarChangeListener {

    private ImageView imageView;
    private SeekBar hueSeekBae,saturability,luminance;
    private static int MAX_VALUE = 255;
    private static int MIND_INDEX = 127;
    private float hueMartix, saMartix, lumMartix;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.text1);
        imageView = (ImageView) findViewById(R.id.iv_image);
        hueSeekBae = (SeekBar) findViewById(R.id.sb_hue);
        saturability = (SeekBar) findViewById(R.id.saturability);
        luminance = (SeekBar) findViewById(R.id.sb_luminance);

        hueSeekBae.setOnSeekBarChangeListener(this);
        saturability.setOnSeekBarChangeListener(this);
        luminance.setOnSeekBarChangeListener(this);

        hueSeekBae.setMax(MAX_VALUE);
        saturability.setMax(MAX_VALUE);
        luminance.setMax(MAX_VALUE);

        hueSeekBae.setProgress(MIND_INDEX);
        saturability.setProgress(MIND_INDEX);
        luminance.setProgress(MIND_INDEX);

        imageView.setImageBitmap(bitmap);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sb_hue:
                hueMartix = (progress - MIND_INDEX) * 1.0F / MIND_INDEX * 180;
                break;
            case R.id.saturability:
                saMartix = progress * 1.0F / MIND_INDEX;
                break;
            case R.id.sb_luminance:
                lumMartix = progress * 1.0F / MIND_INDEX;
                break;
        }
        imageView.setImageBitmap(ImageHealp.newImage(bitmap, hueMartix, saMartix, lumMartix));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

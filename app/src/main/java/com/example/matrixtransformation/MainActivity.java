package com.example.matrixtransformation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.matrixtransformation.activity.ImageMartixText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToopBar toopBar= (ToopBar) findViewById(R.id.tb);
        toopBar.setOnTopbarClickLitener(new ToopBar.onTopbarClickListener() {
            @Override
            public void setLeftOnClick() {

            }

            @Override
            public void setRightOnClick() {
                startActivity(new Intent(MainActivity.this, ImageMartixText.class));
            }
        });
    }

    public void btnPrimaryColor(View view){
        startActivity(new Intent(this,PictureUtils.class));
    }
    public void ColorMartix(View view){
startActivity(new Intent(this,ColorMartix.class));
    }public void PixPicture(View view){
startActivity(new Intent(this,pixeisEffect.class));
    }
}

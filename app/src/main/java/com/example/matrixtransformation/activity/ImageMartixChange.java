package com.example.matrixtransformation.activity;

import android.app.Activity;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.matrixtransformation.R;


/**
 * Created by Administrator on 2017/5/23.
 */
public class ImageMartixChange extends Activity{

    private GridLayout mGridLayout;
    private ImageChangeView mImageView;
    private int mWidth;
    private int mHeight;
    private float[] mImageMatrix=new float[9];
    private EditText[] mEditText=new EditText[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagechange);
        mImageView= (ImageChangeView) findViewById(R.id.icvImage);
        mGridLayout= (GridLayout) findViewById(R.id.gl_matrix);
        mGridLayout.post(new Runnable() {
            @Override
            public void run() {
                mWidth=mGridLayout.getWidth()/3;
                mHeight=mGridLayout.getHeight()/3;
                MatrixPaint();
                initMatrixImage();
            }
    });

    }

    public void Change(View view){
        getImageMatrix();
        Matrix matrix=new Matrix();
        //二种转换方法
        //第一种 通过矩阵方法
        matrix.setValues(mImageMatrix);   //将数组转化为矩阵
        //第二种方法 通过Android  API
//        matrix.setTranslate(150,150);
        //转换综合使用      Post矩阵组合
//        matrix.setScale(2,2);              //放大两倍
//        matrix.postTranslate(200,200);    //使用post是为了顺序显示

        mImageView.restoreImage(matrix);
        mImageView.invalidate();       //刷新

    }
    public void RegistChange(View view){
        initMatrixImage();
        getImageMatrix();
        Matrix matrix=new Matrix();
        matrix.setValues(mImageMatrix);   //将数组转化为矩阵
        mImageView.restoreImage(matrix);
        mImageView.invalidate();       //刷新
    }
    private void getImageMatrix()
    {
        for (int i = 0; i < 9; i++) {
            EditText et=mEditText[i];
            mImageMatrix[i]=Float.valueOf(et.getText().toString());
        }
    }


    private void MatrixPaint(){
        for (int i=0;i<9;i++){
            EditText editText=new EditText(this);
            editText.setGravity(Gravity.CENTER);
            mEditText[i]=editText;
            mGridLayout.addView(editText,mWidth,mHeight);
        }
    }

    //初始化
    private void initMatrixImage(){
        for (int i = 0; i < 9; i++) {
            if (i%4==0){
                mEditText[i].setText("1");
            }else {
                mEditText[i].setText("0");
            }
        }
    }


//    在Android中，对图片的处理需要使用到Matrix类，Matrix是一个3 x 3的矩阵，他对图片的处理分为四个基本类型：
//
//    1、Translate————平移变换
//
//    2、Scale————缩放变换
//
//    3、Rotate————旋转变换
//
//    4、Skew————错切变换
//
//    在Android的API里对于每一种变换都提供了三种操作方式：set（用于设置Matrix中的值）、post（后乘，根据矩阵的原理，相当于左乘）、pre（先乘，相当于矩阵中的右乘）。默认时，这四种变换都是围绕（0，0）点变换的，当然可以自定义围绕的中心点，通常围绕中心点。
//
//    首先说说平移，在对图片处理的过程中，最常用的就是对图片进行平移操作，该方法为setTranslate()，平移意味着在x轴和y轴上简单地移动图像。setTranslate方法采用两个浮点数作为参数，表示在每个轴上移动的数量。第一个参数是图像将在x轴上移动的数量，而第二个参数是图像将在y轴上移动的数量。在x轴上使用正数进行平移将向右移动图像，而使用负数将向左移动图像。在y轴上使用正数进行平移将向下移动图像，而使用负数将向上移动图像。
//
//    再看缩放，Matrix类中另一个有用的方法是setScale方法。它采用两个浮点数作为参数，分别表示在每个轴上所产生的缩放量。第一个参数是x轴的缩放比例，而第二个参数是y轴的缩放比例。如：matrix.setScale(1.5f,1);
//    比较复杂的就是图片的旋转了，内置的方法之一是setRotate方法。它采用一个浮点数表示旋转的角度。围绕默认点(0,0)，正数将顺时针旋转图像，而负数将逆时针旋转图像，其中默认点是图像的左上角，如：
//
//    Matrix matrix = new Matrix();
//    matrix.setRotate(15);
//
//    另外，也可以使用旋转的角度及围绕的旋转点作为参数调用setRotate方法。选择图像的中心点作为旋转点，如：
//            matrix.setRotate(15,bmp.getWidth()/2,bmp.getHeight()/2);
//
//    对于错切变换，在数学上又称为Shear mapping(可译为“剪切变换”)或者Transvection(缩并)，它是一种比较特殊的线性变换。错切变换的效果就是让所有点的x坐标(或者y坐标)保持不变，而对应的y坐标(或者x坐标)则按比例发生平移，且平移的大小和该点到x轴(或y轴)的垂直距离成正比。错切变换，属于等面积变换，即一个形状在错切变换的前后，其面积是相等的。
//
//    对于程序中，一个特别有用的方法对是setScale和postTranslate，它们允许跨单个轴(或者两个轴)翻转图像。如果以一个负数缩放，那么会将该图像绘制到坐标系统的负值空间。由于(0,0)点位于左上角，使用x轴上的负数会导致向左绘制图像。因此我们需要使用postTranslate方法，将图像向右移动，如：
//
//            matrix.setScale(-1, 1);
//    matrix.postTranslate(bmp.getWidth(),0);
//
//    可以在y轴上做同样的事情，翻转图像以使其倒置。通过将图像围绕两个轴上的中心点旋转180°，可以实现相同的效果，如
//    matrix.setScale(1, -1);
//    matrix.postTranslate(0, bmp.getHeight());



}

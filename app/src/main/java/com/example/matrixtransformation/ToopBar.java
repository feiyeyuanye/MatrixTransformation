package com.example.matrixtransformation;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/5/22.
 */
public class ToopBar extends RelativeLayout {

    private Button leftButton,rightButton;
    private TextView title;

    private int leftTextColor;
    private Drawable leftTextBackground;
    private String leftText;

    private int rightTextColor;
    private Drawable rightTextBackground;
    private String rightText;

    private int titleColor;
    private float titleTextSize;
    private String titleText;

    private LayoutParams leftParams,rightParams,titleParams;

    public ToopBar(final Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.Topbar);
        leftTextColor=ta.getColor(R.styleable.Topbar_leftTextColor,0);
        leftTextBackground=ta.getDrawable(R.styleable.Topbar_leftTextBackground);
        leftText=ta.getString(R.styleable.Topbar_leftText);

        rightTextColor=ta.getColor(R.styleable.Topbar_rightTextColor,0);
        rightTextBackground=ta.getDrawable(R.styleable.Topbar_rightTextBackground);
        rightText=ta.getString(R.styleable.Topbar_rightText);

        titleColor=ta.getColor(R.styleable.Topbar_titleTextColor,0);
        titleTextSize=ta.getDimension(R.styleable.Topbar_titleTextSize,0);
        titleText=ta.getString(R.styleable.Topbar_title);

        ta.recycle();

        leftButton=new Button(context);
        rightButton=new Button(context);
        title=new TextView(context);

        leftButton.setTextColor(leftTextColor);
        leftButton.setText(leftText);
        leftButton.setBackground(leftTextBackground);

        rightButton.setText(rightText);
        rightButton.setBackground(rightTextBackground);
        rightButton.setTextColor(rightTextColor);

        title.setTextSize(titleTextSize);
        title.setTextColor(titleColor);
        title.setText(titleText);
        title.setGravity(Gravity.CENTER);

        setBackgroundColor(0x500000FF);

        leftParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(leftButton,leftParams);

        rightParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(rightButton,rightParams);

        titleParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(title,titleParams);

        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                onTopbarClickListener.setLeftOnClick();
            }
        });
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                onTopbarClickListener.setRightOnClick();
            }
        });

    }
    private onTopbarClickListener onTopbarClickListener;
    public interface onTopbarClickListener{
        public void setLeftOnClick();
        public void setRightOnClick();
    }
    public void setOnTopbarClickLitener(onTopbarClickListener onTopbarClickLitener){
        this.onTopbarClickListener=onTopbarClickLitener;
    }

    public void setLeftIsVisiblity(boolean isFlag){
        if (isFlag){
            leftButton.setVisibility(GONE);
        }else {
            leftButton.setVisibility(VISIBLE);
        }
    }
    public void setRightIsVisiblity(boolean isFlag){
        if (isFlag){
            rightButton.setVisibility(GONE);
        }else {
            rightButton.setVisibility(VISIBLE);
        }
    }
}

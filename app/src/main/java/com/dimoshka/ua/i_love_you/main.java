package com.dimoshka.ua.i_love_you;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class main extends Activity implements Animation.AnimationListener {

    private ImageView mImage;
    private TextView mText;
    private Animation animation = null;

    private int[] img_arr = new int[]{R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6, R.drawable.f7, R.drawable.f8, R.drawable.f9, R.drawable.f10, R.drawable.f11, R.drawable.f12, R.drawable.f13, R.drawable.f14, R.drawable.f15, R.drawable.f16, R.drawable.f17};
    private int[] text_arr = new int[]{R.string.f1, R.string.f2, R.string.f3, R.string.f4, R.string.f5, R.string.f6, R.string.f7, R.string.f8, R.string.f9, R.string.f10, R.string.f11, R.string.f12, R.string.f13, R.string.f14, R.string.f15, R.string.f16, R.string.f17};
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImage = (ImageView) findViewById(R.id.image);
        mText = (TextView) findViewById(R.id.text);
        start();
    }

    private void start() {
        if (id < 17) {
            animation = AnimationUtils.loadAnimation(this, R.anim.combination);
            animation.setAnimationListener(this);
            mImage.startAnimation(animation);
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        mImage.setVisibility(View.VISIBLE);
        if (id<17) {
            start();
        } else {
            System.exit(0);
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        mImage.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        if (id < 17) {
            mImage.setImageResource(img_arr[id]);
            mText.setText(text_arr[id]);
            id += 1;
        }
        mImage.setVisibility(View.VISIBLE);
    }

}

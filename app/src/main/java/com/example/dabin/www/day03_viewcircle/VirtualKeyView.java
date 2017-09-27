package com.example.dabin.www.day03_viewcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Dabin on 2017/9/27.
 */

public class VirtualKeyView extends View {
    public VirtualKeyView(Context context) {
        super(context);
    }

    public VirtualKeyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VirtualKeyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VirtualKeyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint base = new Paint();       //最底部的圈
        Paint middle = new Paint();     //中间的圈
        Paint top = new Paint();        //最顶部的圈

        //选取屏幕中间
        float wi = canvas.getWidth() / 2;
        float he = canvas.getHeight() / 2;

        int baseR = dip2px(getContext(), 150); //设置底部圆半径
        int middleR = dip2px(getContext(), 80); //设置中间圈半径
        int topR = dip2px(getContext(), 50); //设置圆环宽度



        base.setARGB(255, 199, 33, 56);  //底部圈设置为红色
        middle.setColor(Color.WHITE);   //中间部圈设置为白色
        top.setColor(Color.BLUE);       //顶部圈设置为蓝色

        //画笔样式分三种： 1.Paint.Style.STROKE：描边    2.Paint.Style.FILL_AND_STROKE：描边并填充3.Paint.Style.FILL：填充
        //base.setStyle(Paint.Style.STROKE);  //给底部圈描边

        //设置描边的粗细，单位：像素px 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
        //base.setStrokeWidth(20);   //底部圈描边的粗细

        //设置画笔为抗齿锯
        base.setAntiAlias(true);
        middle.setAntiAlias(true);
        top.setAntiAlias(true);


        canvas.drawColor(Color.YELLOW);         //整体页面颜色
        canvas.drawCircle(wi, he, baseR, base);   //底部圈位置大小
        canvas.drawCircle(wi, he, middleR, middle);  //中间圈位置大小
        canvas.drawCircle(wi, he, topR, top);     //顶部圈位置大小

        canvas.drawText("X", wi, he, base);     //底部圈的字体
    }

    //定位
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    //监听
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    //根据手机的分辨率从 dp 的单位 转成为 px(像素)
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}

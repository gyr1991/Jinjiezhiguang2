package com.gyr.viewstudy.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.gyr.viewstudy.R;

public class RectView extends View {
    private Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private int mColor=Color.RED;
    public RectView(Context context) {
        super(context);
        initDraw();
    }


    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypedArray=context.obtainStyledAttributes(attrs, R.styleable.RectView);
        mColor=mTypedArray.getColor(R.styleable.RectView_rect_color,Color.RED);
        mTypedArray.recycle();
        initDraw();
    }

    public RectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    private void initDraw() {
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(1.5f);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode=MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode=MeasureSpec.getMode(heightMeasureSpec);
        int widthSpecSize=MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize=MeasureSpec.getSize(heightMeasureSpec);
        boolean f1=(widthSpecMode ==MeasureSpec.AT_MOST);
        boolean f2=(heightSpecMode ==MeasureSpec.AT_MOST);
        boolean f3=(widthSpecMode ==MeasureSpec.EXACTLY);
        boolean f4=(heightSpecMode ==MeasureSpec.EXACTLY);
        if(f1&&f2){
          setMeasuredDimension(450,450);
        }else if(f1){
            setMeasuredDimension(450,heightSpecSize);
        }else if(f2){
            setMeasuredDimension(widthSpecSize,450);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft=getPaddingLeft();
        int paddingRight=getPaddingRight();
        int paddingTop=getPaddingTop();
        int paddingBottom=getPaddingBottom();
        int aa=getWidth();
        int bb=getHeight();
        int width=getWidth()-paddingLeft-paddingRight;
        int height=getHeight()-paddingTop-paddingBottom;
//        canvas.drawLine(0,height/2,width,height/2,mPaint);
        canvas.drawRect(0+paddingLeft,0+paddingTop,width/2+paddingLeft,height/2+paddingRight,mPaint);
    }
}

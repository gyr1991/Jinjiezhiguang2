package com.gyr.viewstudy.myview;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class CustomView extends View {
    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        mScroller=new Scroller(context);
    }

    public CustomView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public void smoothScrollTo(int destX,int destY){
        int scrollX=getScrollX();
        int scrollY=getScrollY();
        int deltaX=destX-scrollX;
        int deltaY=destY-scrollY;
        mScroller.startScroll(scrollX,scrollY,deltaX,deltaY,2000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y= (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX=x;
                lastY=y;
                break;
            case MotionEvent.ACTION_MOVE:

                int offsetX=x-lastX;
                int offsetY=y-lastY;
//                layout(getLeft()+offsetX,getTop()+offsetY,getRight()+offsetX,getBottom()+offsetY);
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
//                ViewGroup.MarginLayoutParams layoutParams= (ViewGroup.MarginLayoutParams) getLayoutParams();
//                layoutParams.leftMargin=getLeft()+offsetX;
//                layoutParams.topMargin=getTop()+offsetY;
//                setLayoutParams(layoutParams);
                ((View)getParent()).scrollBy(-offsetX,-offsetY);
                break;
        }
        return true;
    }
}

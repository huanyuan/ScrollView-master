package com.jackson.scrollview.view; /**
 * ViewDragHelper  2017-11-20
 * Copyright (c) 2017 KL Co.Ltd. All right reserved.
 */

import android.content.Context;
import android.graphics.Point;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.jackson.scrollview.LogTools;
import com.jackson.scrollview.SPUtils;

/**
 * class description here
 *
 * @author Jackson
 * @version 1.0.0
 *          since 2017 11 20
 */
public class ViewDrag extends LinearLayout {

    private ViewDragHelper mViewDragHelper;

    private Point mPoint = new Point();
    private Point mPoint1 = new Point();

    private boolean isFirst = true;
    private float x, y;
    private boolean isLeft;
    Context mContext;

    public ViewDrag(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ViewDrag(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public ViewDrag(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        mViewDragHelper = ViewDragHelper.create(this, 1.0f, mCallback);  //ViewDragHelper实例化
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        x = event.getX();
        y = event.getY();
        LogTools.d("onTouchEvent()======x:" + event.getX() + "y===:" + event.getY());
        return true;
    }



    private ViewDragHelper.Callback mCallback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return child == dragView1 || child == dragView2;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            int leftBound = getPaddingLeft();
            int rightBound = getWidth() - child.getWidth() - leftBound;
            //这个地方的含义就是 如果left的值 在leftbound和rightBound之间 那么就返回left
            //如果left的值 比 leftbound还要小 那么就说明 超过了左边界 那我们只能返回给他左边界的值
            //如果left的值 比rightbound还要大 那么就说明 超过了右边界，那我们只能返回给他右边界的值
            return Math.min(Math.max(left, leftBound), rightBound);
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            final int topBound = getPaddingTop();
            final int bottomBound = getHeight() - child.getHeight() - topBound;
            return Math.min(Math.max(top, topBound), bottomBound);
        }

        //需要子view的点击事件时添加，并且在xml文件中设置click属性为true
        @Override
        public int getViewVerticalDragRange(View child) {
            return getMeasuredHeight() - child.getMeasuredHeight();
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            if (releasedChild == dragView2) {
                mViewDragHelper.settleCapturedViewAt(mPoint.x, mPoint.y);
                LogTools.d("onViewReleased()=========mPoint.x:" + mPoint.x + " mPoint.y===:" + mPoint.y);
                invalidate();
            }

            //手指释放时可以自动回去，实现回弹需要配合computeScroll方法的配合才能生效
            //如果移动的位置大于屏幕的一半，那么就回到右侧，否则移动到左侧
            if (releasedChild == dragView1) {
//                mViewDragHelper.settleCapturedViewAt(x, y);
                LogTools.d("onViewReleased()=========.x:" + x + " .y===:" + x);
                SPUtils.put(mContext,"x",x);
                SPUtils.put(mContext,"y",y);
                invalidate();
            }
        }
    };

    /**
     * 滚动
     */
    @Override
    public void computeScroll() {
       if (mViewDragHelper.continueSettling(true)){
           invalidate();
       }
    }

    View dragView1;
    View dragView2;
    View dragView3;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
       /* dragView1=findViewById(R.id.tv_1);
        dragView2=findViewById(R.id.tv_2);
        dragView3=findViewById(R.id.tv_3);*/
        dragView1 = getChildAt(0);
        dragView2 = getChildAt(1);
        dragView3 = getChildAt(2);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        LogTools.d("onLayout()=========changed:" + changed + " l===:" + l + " t===:" + t + "r===:" + r + " b===:" + b);
        //布局完成的时候就记录一下位置
        mPoint.x = dragView2.getLeft();
        mPoint.y = dragView2.getTop();

        if (isFirst) {
            //初始化默认位置，只需要在第一次执行这个方法的时候去初始化
            float x = (float) SPUtils.get(mContext,"x",0f);
            float y = (float) SPUtils.get(mContext,"y",0f);
            LogTools.d("onLayout()=========changed x:" + x + " y===:" + y);
            mPoint1.x = dragView1.getLeft();
            mPoint1.y = dragView1.getTop();
            LogTools.d("onLayout()=========changed x:" + x + " y===:" + y);
            //设置view的位置
            dragView1.layout((int)x, (int)y, (int)x + dragView1.getMeasuredWidth(), (int)y + dragView1.getMeasuredHeight());
            isFirst = false;
            invalidate();
        }


    }
}


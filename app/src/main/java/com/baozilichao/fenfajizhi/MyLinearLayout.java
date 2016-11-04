package com.baozilichao.fenfajizhi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MyLinearLayout extends LinearLayout {

	private static final String TAG = "MyLinearLayout";

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		//拦截事件，所有事件由自己分发处理
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		//获得子孩子的个数
		int childCount=getChildCount();
		//本身的宽度除以子View的个数，获得每个孩子的宽度
		int width=getWidth()/childCount;
		//获得此本身的高度
		int height=getHeight();
		//如果当前点击的点的X坐标小于width则表示点击的点在第一列
		if(ev.getX()<=width){
			//获得第一个子View
			View childView=getChildAt(0);
			ev.setLocation(width/2,ev.getY());
			//将事件分发给此View
			childView.dispatchTouchEvent(ev);
			return true;
			//当前点击的的X坐标在第一列和第三列中间
		}else if(ev.getX()>width&&ev.getX()<width*2){
			//当前点击的点的Y坐标小于本身高度的一半，表明点击的点在上在第列的上部分
			if(ev.getY()<height/2){
				ev.setLocation(width/2,ev.getY());
				//将事件分发给每一个子View
				for(int i=0;i<childCount;i++){
					View childView=getChildAt(i);
					try{
						childView.dispatchTouchEvent(ev);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				return true;
			}else{
				ev.setLocation(width/2,ev.getY());
				getChildAt(1).dispatchTouchEvent(ev);
				return true;
			}
		}else{
			ev.setLocation(width/2,ev.getY());
			getChildAt(2).dispatchTouchEvent(ev);
			return true;
		}
	}

}

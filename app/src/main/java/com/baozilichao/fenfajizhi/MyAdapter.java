package com.baozilichao.fenfajizhi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {
	
	private Context mContext;
	private int mIds[];

	public MyAdapter(Context context, int[] ids) {
		this.mContext=context;
		this.mIds=ids;
	}

	@Override
	public int getCount() {
		return 100;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder=new ViewHolder();
			convertView=View.inflate(mContext,R.layout.item_image,null);
			viewHolder.iv=(ImageView) convertView.findViewById(R.id.iv_image);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		int resId=(int) (Math.random()*8);
		viewHolder.iv.setImageResource(mIds[resId]);
		return convertView;
	}
	
	class ViewHolder{
		ImageView iv;
	}

}

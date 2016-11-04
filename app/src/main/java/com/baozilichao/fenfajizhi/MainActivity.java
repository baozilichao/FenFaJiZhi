package com.baozilichao.fenfajizhi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
//博客地址：http://blog.csdn.net/dmk877/article/details/49147901
public class MainActivity extends Activity {

    protected static final String TAG = "MainActivity";
    private MyLinearLayout llMain;

    private ListView lv1;
    private ListView lv2;
    private ListView lv3;

    private MyAdapter myAdapter;
    private int ids[]=new int[]{R.drawable.abc1,R.drawable.abc2,R.drawable.abc3,R.drawable.abc4,R.drawable.abc5,
            R.drawable.abc6,R.drawable.abc7,R.drawable.abc8,R.drawable.abc9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llMain=(MyLinearLayout) findViewById(R.id.ll_main);

        myAdapter=new MyAdapter(MainActivity.this,ids);

        lv1=(ListView) findViewById(R.id.lv1);
        lv2=(ListView) findViewById(R.id.lv2);
        lv3=(ListView) findViewById(R.id.lv3);

        lv1.setAdapter(myAdapter);
        lv2.setAdapter(myAdapter);
        lv3.setAdapter(myAdapter);

    }
}


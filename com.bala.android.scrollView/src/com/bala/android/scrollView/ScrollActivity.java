package com.bala.android.scrollView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ScrollActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        TextView view =  (TextView) findViewById(R.id.textView1);
        String s="";
        for (int i=0; i < 100; i++) {
          s += "Baladewa.com ";
        }
        view.setText(s);
    }

}

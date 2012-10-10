package com.bala.android.scrollView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button mOpenButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOpenButton = (Button) findViewById(R.id.button1);
    }
    /* Switch to activity in click button */
    
    public void switchToScrollView(View clickButton) {
    	goToActivity(this, ScrollActivity.class);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    private void goToActivity(Context currentActivity, Class<? extends Activity> newClass) {
			Intent newActivity = new Intent(currentActivity, newClass);
			currentActivity.startActivity(newActivity);
    }
    
}

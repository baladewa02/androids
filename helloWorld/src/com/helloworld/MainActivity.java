package com.helloworld;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Toast myToast = Toast.makeText(this, "Hello World", Toast.LENGTH_LONG);
		//myToast.setGravity(Gravity.CENTER, 0, 0);
		//myToast.show();
	    AlertDialog helloAlert = new AlertDialog.Builder(this).create();
        helloAlert.setTitle("Ruwan bala Hello Worlds Demo");
        helloAlert.setMessage("Hello World");
        helloAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Close", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {}
		});
        helloAlert.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {}
		});
        helloAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "FOK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {}
		});
        helloAlert.show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}

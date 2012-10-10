package com.bala.android.temprature;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText mEditText;
	private TextView mViewText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mEditText = (EditText) findViewById(R.id.editText1);
		mViewText = (TextView) findViewById(R.id.textView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void calculate(View view) {
		Log.d("MYINFO", "Click on button");
		if (mEditText.getText().length() == 0) {
			Toast.makeText(this, "Please enter a valid number",
					Toast.LENGTH_LONG).show();
			return;
		}
		float inputValue = Float.parseFloat(mEditText.getText().toString());
		switch (view.getId()) {
		case R.id.radio0:
			Log.d("MYINFO", "I am in Celsius");
			RadioButton inCelsius = (RadioButton) findViewById(R.id.radio0);
			if (inCelsius.isChecked()) {
				mViewText.setText(String
						.valueOf(convertFahrenheitToCelsius(inputValue)));
			}
			break;
		case R.id.radio1:
			Log.d("MYINFO", "I am in Fahrenheit");
			RadioButton inFahrenheit = (RadioButton) findViewById(R.id.radio1);
			if (inFahrenheit.isChecked()) {
				mViewText.setText(String
						.valueOf(convertCelsiusToFahrenheit(inputValue)));
			}
		}
	}
	
	private float convertCelsiusToFahrenheit(float val){
		return ((val - 32) * 5 / 9);
	}
	
	private float convertFahrenheitToCelsius(float val){
		return ((val * 9) / 5) + 32;
	}
}

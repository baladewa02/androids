package com.bala.android.temprature;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText mEditText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mEditText = (EditText) findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void calculate(View view) {
		switch (view.getId()) {
		case R.id.button1:
			RadioButton inCelsius = (RadioButton) findViewById(R.id.radio0);
			RadioButton inFahrenheit = (RadioButton) findViewById(R.id.radio1);
			if (mEditText.getText().length() == 0) {
				Toast.makeText(this, "Please enter a valid number",
						Toast.LENGTH_LONG).show();
				return;
			}
			float inputValue = Float.parseFloat(mEditText.getText().toString());
			if (inCelsius.isChecked()) {
				mEditText.setText(String
						.valueOf(convertFahrenheitToCelsius(inputValue)));
				inCelsius.setChecked(false);
				inFahrenheit.setChecked(true);
			} else {
				mEditText.setText(String
						.valueOf(convertCelsiusToFahrenheit(inputValue)));
				inFahrenheit.setChecked(false);
				inCelsius.setChecked(true);
			}
			break;
		}
	}
	
	private float convertCelsiusToFahrenheit(float val){
		return val;
	}
	
	private float convertFahrenheitToCelsius(float val){
		return val;
	}
}

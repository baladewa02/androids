package com.coreservlets.spinnersexercises;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.app.Activity;
import android.graphics.Color;

public class SpinnersExercisesActivity extends Activity {
    private TextView mBottomArea;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mBottomArea = (TextView)findViewById(R.id.bottom_area);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new SpinnerHandler());
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        String[] colorChoices = { "Red", "Yellow", "Green", "Blue" };
        ArrayAdapter<String> spinner2Adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colorChoices);
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinner2Adapter);
        spinner2.setPrompt("Choose Color (Choices from Java)");
        spinner2.setOnItemSelectedListener(new SpinnerHandler());
    }  
    
    private class SpinnerHandler implements OnItemSelectedListener {
        private int[] mColors = { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN };
        
        @Override
        public void onItemSelected(AdapterView<?> spinner, View selectedView, 
                                   int selectedIndex, long id) {
            mBottomArea.setBackgroundColor(mColors[selectedIndex]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> spinner) {
            // Won't be invoked for a Spinner unless you programmatically remove items from the view
        }
    }
}

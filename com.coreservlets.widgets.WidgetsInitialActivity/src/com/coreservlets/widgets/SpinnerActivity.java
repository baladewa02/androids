package com.coreservlets.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Demonstrates some of the basic input Widgets. The main Activity
 *  simply contains buttons that launch the other Activities. The
 *  other Activities each demonstrate a category of input Widget.
 *  <p>
 *  From <a href="http://www.coreservlets.com/android-tutorial/">
 *  the coreservlets.com Android programming tutorial series</a>.
 */

public class SpinnerActivity extends Activity {
    private String mItemSelectedMessageTemplate;
    
    /** Initializes the app when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinners);
        mItemSelectedMessageTemplate = getString(R.string.spinner_message_template);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new SpinnerInfo());
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        List<String> futureAndroidVendors = getFutureAndroidVendors();
        ArrayAdapter<String> spinner2Adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, futureAndroidVendors);
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinner2Adapter);
        spinner2.setOnItemSelectedListener(new SpinnerInfo());
    }
    
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    
    /** Returns a slightly randomized List of names.
     *  You can pass either a String[] or a List<String> to the ArrayAdapter<String> constructor.
     *  Here I convert an array to a List so that I can randomize the order of the elements, in
     *  order to demonstrate that Java can dynamically compute the elements to display in a Spinner.
     *  If you have fixed elements, use XML instead of Java, as in the first Spinner example.
     */
    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = { "Apple", "RIM", "Palm", "Microsoft" };
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }
    
    private class SpinnerInfo implements OnItemSelectedListener {
        private boolean isFirst = true;
        
        /** Shows a Toast for the selected item. Ignored the very first time,
         *  which is when the item is selected on initial display, rather than
         *  by user interaction.
         */
        @Override
        public void onItemSelected(AdapterView<?> spinner, View selectedView, 
                                   int selectedIndex, long id) {
            if (isFirst) {
                isFirst = false;
            } else {
                String selection = spinner.getItemAtPosition(selectedIndex).toString();
                String message =
                        String.format(mItemSelectedMessageTemplate, selection);
                showToast(message);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> spinner) {
            // Won't be invoked for a Spinner unless you programmatically remove items from the view
        }
    }
}
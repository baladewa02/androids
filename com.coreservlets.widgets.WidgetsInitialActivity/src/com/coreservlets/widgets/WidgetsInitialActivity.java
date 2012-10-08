package com.coreservlets.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/** Demonstrates some of the basic input Widgets. The main Activity
 *  simply contains buttons that launch the other Activities. The
 *  other Activities each demonstrate a category of input Widget.
 *  <p>
 *  From <a href="http://www.coreservlets.com/android-tutorial/">
 *  the coreservlets.com Android programming tutorial series</a>.
 */

public class WidgetsInitialActivity extends Activity {
    /** Initializes the app when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    /** Switches to the given class (which must be a subclass of Activity). 
     *  You must also register the new Activity in AndroidManifest.xml.
     */
    private void goToActivity(Class<? extends Activity> activityClass) {
        Intent newActivity = new Intent(this, activityClass);
        startActivity(newActivity);
    }
    
    /** Switches to the ButtonActivity when the associated button is clicked. */
    
    public void showButtonLikeWidgets(View clickedButton) {
        goToActivity(ButtonActivity.class);
    }
    
    /** Switches to the SpinnerActivity when the associated button is clicked. */
    
    public void showSpinners(View clickedButton) {
        goToActivity(SpinnerActivity.class);
    }
}
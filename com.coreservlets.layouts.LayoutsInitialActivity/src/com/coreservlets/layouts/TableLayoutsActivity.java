package com.coreservlets.layouts;

import android.app.Activity;
import android.os.Bundle;

/** Demonstrates the use of table layouts. Also shows the use
 *  of layout_span (equivalent to colspan for HTML tables) and
 *  nested tables (needed to get the equivalent of rowspan for HTML tables).
 *  <p>
 *  From <a href="http://www.coreservlets.com/android-tutorial/">
 *  the coreservlets.com Android programming tutorial series</a>.
 */

public class TableLayoutsActivity extends Activity {
    /** Initializes the app when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_layouts);
    }
}
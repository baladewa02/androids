package com.coreservlets.networking;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/** Connects to the time-of-day server at the National Institute of
 *  Standards and Technology (NIST) and prints out the second line
 *  of the server's response (which shows the current time in UTC format). 
 *  See server list at http://tf.nist.gov/tf-cgi/servers.cgi
 *  See explanation of result format at http://www.nist.gov/pml/div688/grp40/its.cfm
 *  (section on Daytime Protocol).
 *  <p>
 *  From <a href="http://www.coreservlets.com/android-tutorial/">
 *  the coreservlets.com Android programming tutorial series</a>.
 */
public class NistTimeActivity extends Activity {
    private String mHost = "10.20.11.185"; // Or time-a.nist.gov or time.nist.gov
    private int mPort = 8180;
    private TextView mResultDisplay;
    
    /** Initializes the app when it is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nist_time);
        mResultDisplay = (TextView)findViewById(R.id.time_display);
    }
    
    /** Shows the time (second line of reply from time-b.nist.gov) in a TextView. */
    
    public void showTime(View clickedButton) {
        try {
        	Log.i("[beforeConnect] to Host", mHost+":"+mPort);
            Socket socket = new Socket(mHost, mPort);
            BufferedReader in = SocketUtils.getReader(socket);
            in.readLine(); // Ignore leading blank line
            String timeResult = in.readLine();
            mResultDisplay.setText(timeResult);
            socket.close();
        } catch (UnknownHostException uhe) {
            mResultDisplay.setText("Unknown host: " + mHost);
            uhe.printStackTrace(); // View this in DDMS window
        } catch (IOException ioe) {
            mResultDisplay.setText("IOException: " + ioe);
            ioe.printStackTrace(); // View this in DDMS window
        }
    }
}
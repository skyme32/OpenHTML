package com.wordpress.actualizateya.openhtml;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;


public class Splash extends ActionBarActivity {

    private static String TAG = Splash.class.getName();
    private static long SLEEP_TIME = 2;    // Sleep for some time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_splash);

        // Start timer and launch main activity
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();
    }

    @Override
    public void onBackPressed() {
        // do something on back.
        return;
    }

    private class IntentLauncher extends Thread {
        @Override
        /**
         * Sleep for some time and than start new activity.
         */
        public void run() {
            try {
                // Sleeping
                Thread.sleep(SLEEP_TIME*1000);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }

            // Start main activity
            Intent intent = new Intent(Splash.this, MainActivity.class);
            Splash.this.startActivity(intent);
            Splash.this.finish();
        }
    }

}

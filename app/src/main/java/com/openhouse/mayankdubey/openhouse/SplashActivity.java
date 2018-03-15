package com.openhouse.mayankdubey.openhouse;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by mayankdubey on 10/03/18.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //creating new thread just for demonstration of background tasks
        Thread splashActivity=new Thread() {
            public void run() {

                try {
                    //sleep thread for 10 seconds
                    sleep(2000);

                    //Call Main activity
                    Intent i=new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);

                    //destroying Splash activity
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //start thread
        splashActivity.start();
    }
}
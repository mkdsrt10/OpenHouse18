package in.ac.iitd.openhouse.openhouseapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class Splash extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 500;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            public void run() {


                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();



            }
        },  SPLASH_DISPLAY_LENGTH);
    }

}

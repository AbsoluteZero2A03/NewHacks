package com.example.ff.nwhack2015;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;


public class MojioInterface extends Activity {
    private String accessToken;

    private ProgressBar healthBar;
    private ProgressBar expBar;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mojio_interface);

        healthBar = (ProgressBar) findViewById(R.id.healthbar);
        expBar = (ProgressBar) findViewById(R.id.expbar);
        healthBar.setMax(100);
        expBar.setMax(100);
        healthBar.setProgress(50);

        mHandler = new Handler();

    }
    Runnable APIGetter = new Runnable() {
        @Override
        public void run() {
            HttpGetTask httpGetTask = new HttpGetTask(new ArrayList<NameValuePair>(0), accessToken) {
                @Override
                public void DoWithJSON(JSONObject obj) {
                    //Do whatever with your trips JSON
                }
            };
            httpGetTask.execute("https://api.moj.io/v1/Trips?limit=10&offset=0&sortBy=StartTime&desc=false&criteria=");

            mHandler.postDelayed(APIGetter,5000);
        }
    };


    @Override
    protected void onStart() {
        super.onStart();
        Bundle extras = getIntent().getExtras();
        accessToken = extras.getString("access_token");
        APIGetter.run();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mojio_interface, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayJSON(View view) {
        System.out.println(accessToken);
//        HttpGetTask httpGetTask = new HttpGetTask(new ArrayList<NameValuePair>(0), accessToken) {
//            @Override
//            public void DoWithJSON(JSONObject obj) {
//            }
//        };
//        httpGetTask.execute("https://api.moj.io/v1/Trips?limit=10&offset=0&sortBy=StartTime&desc=false&criteria=");
    }
}

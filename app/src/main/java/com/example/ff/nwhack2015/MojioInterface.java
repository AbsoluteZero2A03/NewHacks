package com.example.ff.nwhack2015;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.james.nwhack2015.Action;
import com.example.james.nwhack2015.Avatar;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;


public class MojioInterface extends Activity {
    private String accessToken;
    private Avatar player;
    private ProgressBar healthBar;
    private ProgressBar expBar;
    private TextView healthText;
    private TextView expText;
    private TextView levelText;
    private ListView actions;
    private ArrayAdapter<Action> mActionAdapter;
    private Handler mHandler;
    private TextView information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mojio_interface);

        player = new Avatar("Fred");

        healthBar = (ProgressBar) findViewById(R.id.healthbar);
        expBar = (ProgressBar) findViewById(R.id.expbar);
        healthText = (TextView) findViewById(R.id.health);
        expText = (TextView) findViewById(R.id.exp);
        levelText = (TextView) findViewById(R.id.level);
        actions = (ListView) findViewById(R.id.tasks);
        information = (TextView) findViewById(R.id.information);

        updateAvatarStats();

        mHandler = new Handler();

        //fill adapter and put in list view
        mActionAdapter = new ArrayAdapter<Action>(getApplicationContext(), android.R.layout.simple_list_item_1);
        mActionAdapter.add(new Action("Bike to work", "Eco friendly"));
        actions.setAdapter(mActionAdapter);
        actions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Action action = mActionAdapter.getItem(position);
                action.effect(player);

                updateAvatarStats();
            }
        });
    }
    private void updateAvatarStats() {
        //set progress bars
        healthBar.setMax(player.getMaxHealth());
        expBar.setMax(player.getMaxExp());
        healthBar.setProgress(player.getHealth());
        expBar.setProgress(player.getExp());

        //set progress fractions
        healthText.setText(String.format("Health %d / %d", player.getHealth(), player.getMaxHealth()));
        expText.setText(String.format("Exp %d / % d", player.getExp(), player.getMaxExp()));

        //set level
        levelText.setText(String.format("Level %d", player.getLevel()));
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

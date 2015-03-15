package com.example.ff.nwhack2015;

import com.example.ff.nwhack2015.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class get_token extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_token);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Uri data = getIntent().getData();
        String uriString = data.toString();
        Pattern p = Pattern.compile("access_token=([0-9a-f-]{36})");
        Matcher m = p.matcher(uriString);
        m.find();
        String name = m.group(1);
        Intent i = new Intent(this,MojioInterface.class);
        i.putExtra("access_token", name);
        i.putExtra("from","get_token");
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_token, menu);
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
}

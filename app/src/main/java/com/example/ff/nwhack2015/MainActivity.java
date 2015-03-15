package com.example.ff.nwhack2015;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private List<NameValuePair> getParams = new ArrayList<NameValuePair>(3);
    private String accessToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent thisIntent = getIntent();
        Bundle extras = thisIntent.getExtras();

        getParams.add(new BasicNameValuePair("response_type", "token"));
        getParams.add(new BasicNameValuePair("client_id", "b9550897-97f4-48c0-b06e-bcf12db55c0b"));
        getParams.add(new BasicNameValuePair("redirect_uri", "this.game.app://getToken/"));

        String url = "https://api.moj.io/OAuth2SandBox/authorize?";
        String paramString = URLEncodedUtils.format(getParams, "utf-8");

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url + paramString));
        startActivity(i);
        //Log.d("accessToken", accessToken);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

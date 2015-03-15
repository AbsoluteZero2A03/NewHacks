package com.example.ff.nwhack2015;

/**
 * Created by ff on 13/03/15.
 */

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.List;


/**
 * Created by ff on 13/03/15.
 */
public class HttpGetTask extends AsyncTask<String,Void,HttpResponse> {
    private List<NameValuePair> params;
    private String header;

    public HttpGetTask(List<NameValuePair> param_list, String headerString) {
        super();
        this.params = param_list;
        header = headerString;
    }

    protected HttpResponse doInBackground(String... urlStr) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity;

        if (!urlStr[0].endsWith("?"))
            urlStr[0]+="?";
        String paramString = URLEncodedUtils.format(params, "utf-8");
        System.out.println(urlStr[0] + paramString);
        HttpGet httpGet = new HttpGet(urlStr[0] + paramString);
        httpGet.setHeader("MojioAPIToken",header);
        try {
            return httpClient.execute(httpGet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(HttpResponse httpResponse) {
        super.onPostExecute(httpResponse);
        try {
            InputStream is = httpResponse.getEntity().getContent();
            int c;
            byte[] b = new byte[2048];
            String ss;
            is.read(b);
            String s = new String(b);
            try {
                JSONObject obj = new JSONObject(s);
                double d = obj.getJSONArray("Data").getJSONObject(0).getDouble("FuelEfficiency");
                System.out.println(d);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
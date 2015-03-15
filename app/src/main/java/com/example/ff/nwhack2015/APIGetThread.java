package com.example.ff.nwhack2015;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by ff on 14/03/15.
 */
public class APIGetThread extends Thread {
    List<NameValuePair> params;
    String header;
    String urlString;
    public APIGetThread(List<NameValuePair> param_list, String headerString, String url) {
        super();
        params = param_list;
        header = headerString;
        urlString = url;
    }

    @Override
    public void run() {

        super.run();
        try {
            //new HttpGetTask(params,header).execute(urlString);
            try { Thread.sleep(5000); } catch(Exception e) {}
        } catch (Exception e) {

        }
    }
}

package com.example.accesscode.exampleasync;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class MainActivity extends Activity {

    TextView timeText;
    AsyncTime getTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText = (TextView) findViewById(R.id.time);
        getTime = new AsyncTime();
    }

    @Override
    protected void onResume(){
        super.onResume();
        getTime.execute();
    }

    public class AsyncTime extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String time_url = "http://www.timeapi.org/utc/now";
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(time_url);
                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                String output = EntityUtils.toString(httpEntity);
                output = output.replace('T', '\n');
                return output;
            }
            catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            timeText.setText(s);
        }
    }
}
